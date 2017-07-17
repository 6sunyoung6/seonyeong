CREATE OR REPLACE PROCEDURE ONSADMIN.SP_BATCH_EXEC_JOB
AS
    -- 
    -- DEFINE JOBID
    -- - JOBID 구성 : JOB_JOB추가일자_JOB설명
    --
    DEF_JOBID_MIG_ENDDOC_DCT    VARCHAR2(35) := 'JOB_20120306_MIG_ENDDOC_DCT';  -- 완료문서(생산) 이관 작업ID
    DEF_JOBID_MIG_ENDDOC_ENF    VARCHAR2(35) := 'JOB_20120306_MIG_ENDDOC_ENF';  -- 완료문서(접수) 이관 작업ID

    DEF_JOBID_DEL_DUPREC        VARCHAR2(35) := 'JOB_20120726_DEL_DUPREC';      -- 중복 집계 기록물 삭제 작업ID
    DEF_JOBID_SEL_CHANGEREC     VARCHAR2(35) := 'JOB_20120726_SEL_CHANGEREC';   -- 과제카드 변경 기록물 추출 작업ID

    DEF_JOBID_MIG_PROC_DCT      VARCHAR2(35) := 'JOB_20120829_MIG_PROC_DCT';    -- 진행중문서(생산) 이관 작업ID


    -- 상수
    DEF_MAXLOOPCNT  NUMBER := 1000;         -- 한번에 최대 처리할 수 있는 LOOP COUNT
    DEF_MAXJOBTIME  NUMBER := 40;           -- 전체 작업 (Procedure 전체) 최대 수행시간 (분 단위)

    -- 변수
    V_JOBID         VARCHAR2(35);           -- 작업ID
    V_JOBMAXTIME    NUMBER := 0;            -- 작업별 (각 작업 Procedure 내부) 최대 수행시간 (분 단위)
    V_STARTDT       VARCHAR2(20) := '';     -- 작업 시작일시 (milisec 2자리 + 난수2자리)
    V_ENDDT         VARCHAR2(14) := '';     -- 작업 종료일시
    V_ERRORFLAG     VARCHAR2(1) := 'N';     -- 작업 에러발생 FLAG

    V_LOOPCNT       NUMBER := 0;            -- 작업 LOOP 카운트

    V_BEFOREDATE    DATE;                   -- 작업시작 전 sysdate (합계 계산용)
    V_EXECTIME      NUMBER := 0;            -- 작업 소요시간 (합계) (분) 

    V_RETURNMSG     VARCHAR2(500);          -- SP 호출결과 MSG
    V_RESULTMSG     VARCHAR2(500);          -- 작업결과 MSG
    
    V_DEBUGSTEP     VARCHAR2(20);           -- Procedure debug용
BEGIN

    /*
    -- [TITLE]
    -- - SP_BATCH_EXEC_JOB : 배치작업 수행 Main Procedure

    -- [DESCRIPTION]
    -- - 배치작업 Queue에 등록되어 있는 작업을 Background에서 수행함
    --   (Quartz에서 매일 1번씩 정기적으로 수행)
    
    -- - 완료가 되지 않은 작업 중 우선 순위가 높은 작업부터 수행
    -- - 일반적으로 대량의 이관(migration) 작업을 처리할 경우 사용
   
    -- - procedure에서 사용하는 테이블
    --   - (1) 배치작업 Queue
    --      - TABLE : BMS_COM_BATCHJOB_QUEUE
    --        - JOBID       : 작업ID (JOB_JOB추가일자_JOB설명 으로 구성) (PK)
    --        - JOBORDER    : 작업 우선순위 (1이 가장 높은 순위임)
    --        - JOBNAME     : 작업명 (참고용)
    --        - SPNAME      : 작업에서 사용하는 Procedure 명 (참고용)
    --        - MAXTIME     : 최대 처리 제한시간 (분 단위)
    --          - 각 작업별로 수행하는 SP에서 처리 제한시간을 초과할 경우 작업을 중단하도록 개발해야 함
    --        - ENDFLAG     : 작업 완료 여부 (Y/N) (DEFAULT : N)
    --          - 각 작업별로 수행하는 SP에서 더 이상 해당 작업의 처리가 필요없을 경우 FLAG를 Y로 설정함
    
    --   - (2) 배치작업 처리 History
    --      - TABLE : BMS_COM_BATCHJOB_HIS
    --        - JOBID       : 작업ID (PK)
    --        - STARTDT     : 작업 시작일시 (PK)
    --        - ENDDT       : 작업 종료일시
    --        - ERRORFLAG   : 작업 처리 시 에러발생 여부 (DEFAULT : N)
    --        - RESULTMSG   : 작업 처리 시 결과 message (에러등이 발생했을 때 기록)
    
    --        * 동일한 작업에 대해 이력은 여러 개가 존재할 수 있음

    -- - Exception 발생 시
    --   - 작업이력 ERRORFLAG Y, ERRORMSG 기록
    --   - 작업 Queue ENDFLAG Y 기록
    
    -- [INPUT]
    -- - 없음

    -- [OUTPUT]
    -- - 없음
    
    -- [CALL]
    -- - 다른 procedure에서 호출하는 부분 없음
    
    -- [CREATE_INFO]
    -- - AUTHOR : 백영호
    -- - DATE   : 2012.03.08
    
    -- [MODIFY_INFO]
    -- - AUTHOR : 백영호
    -- - DATE   : 2012.07.19
    -- - DESCRIPTION : 진행중문서 이관작업 추가

    -- - AUTHOR : 백영호
    -- - DATE   : 2012.07.26
    -- - DESCRIPTION : 
    --   - 중복집계 기록물 삭제, 과제카드 변경 기록물 취합 작업 추가
    --   - LOOP 수행을 각 개발 작업에서 하지 않고, MAIN에서 수행하도록 구조 변경

    */

    DBMS_OUTPUT.ENABLE;
    DBMS_OUTPUT.PUT_LINE('[START] SP_COM_EXEC_BATCHJOB : ' || TO_CHAR (SYSDATE, 'yyyy-mm-dd hh24:mi:ss'));

    -- 작업 시작일시(분)을 보관 (총 작업시간 체크용)
    V_BEFOREDATE := SYSDATE;
    DBMS_OUTPUT.PUT_LINE('- V_BEFOREDATE : ' || TO_CHAR(V_BEFOREDATE, 'yyyymmddhh24miss'));

    DBMS_OUTPUT.PUT_LINE('- (SP_COM_EXEC_BATCHJOB) LOOP start.');

    -- 작업 LOOP 시작
    WHILE V_LOOPCNT < DEF_MAXLOOPCNT
    LOOP
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        
        ------------------------------------------------------------------------
        V_DEBUGSTEP := '10[' || V_LOOPCNT || ']';

        -- 작업ID(JOBID), 작업최대시간(MAXTIME) 추출
        -- - 아직 진행중인 작업 중에서 우선 순위가 높은것부터 한건씩 처리
        -- - ENDFLAG 의미
        --   - N : 진행중 작업
        --   - Y : 종료된 작업 - 각 작업을 처리하는 로직에서 완료되었을 경우 Y로 업데이트 해야 함
        --   - E : 수행 중 에러가 발생한 작업
        SELECT JOBID
             , MAXTIME
          INTO V_JOBID
             , V_JOBMAXTIME
          FROM (
                SELECT JOBID
                     , MAXTIME
                  FROM BMS_COM_BATCHJOB_QUEUE
                 WHERE ENDFLAG = 'N'    -- 완료안된 작업
                 ORDER BY JOBORDER      -- 작업 우선순위
               )
         WHERE ROWNUM = 1
        ;
    
        DBMS_OUTPUT.PUT_LINE('- JOBID (MAXTIME) : ' || V_JOBID || ' (' || V_JOBMAXTIME || ')' );

        ------------------------------------------------------------------------
        -- LOOP 조건 체크 - 진행할 작업ID가 없다면 종료
        EXIT WHEN (V_JOBID = '' OR V_JOBID IS NULL);
        ------------------------------------------------------------------------


        ------------------------------------------------------------------------
        V_DEBUGSTEP := '20[' || V_LOOPCNT || ']';

        -- 작업 시작일시 확인 (BATCHJOB_HIS - 이력 보관용)
        -- - 현재 작업과 다음 작업사이의 소요시간이 0초일 경우
        --   PK 오류 방지를 위해 난수 2자리를 추가함
        V_STARTDT := TO_CHAR(SYSTIMESTAMP, 'yyyymmddhh24miss.ff2') || '_' || ROUND(DBMS_RANDOM.VALUE(1, 99), 0);
        DBMS_OUTPUT.PUT_LINE('- V_STARTDT : ' || V_STARTDT);

        -- 작업 이력 추가 (시작일시)
        INSERT INTO BMS_COM_BATCHJOB_HIS
            (JOBID, STARTDT)
        VALUES
            (V_JOBID, V_STARTDT)
        ;
        
        COMMIT;

        DBMS_OUTPUT.PUT_LINE ('- INSERT_HIS(JOBID, STARTDT) : (' || V_JOBID || ', ' || V_STARTDT || ')');

        ------------------------------------------------------------------------
        V_DEBUGSTEP := '30[' || V_LOOPCNT || ']';


        --
        -- 작업 시작
        --
        
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        ------------------------------------------------------------------------
        -- 완료문서(생산) 이관 작업 시작
        IF (V_JOBID = DEF_JOBID_MIG_ENDDOC_DCT)
        THEN
            DBMS_OUTPUT.PUT_LINE ('- START JOB : ' || V_JOBID);
            V_DEBUGSTEP := '30-1-S[' || V_LOOPCNT || ']';
            
            SP_BATCH_MIG_ENDDOC(V_JOBID, V_JOBMAXTIME, 'DCT', V_RETURNMSG);
            V_RESULTMSG := V_RETURNMSG;
                
            V_DEBUGSTEP := '30-1-E[' || V_LOOPCNT || ']';
            
        ------------------------------------------------------------------------
        -- 완료문서(접수) 이관 작업 시작
        ELSIF (V_JOBID = DEF_JOBID_MIG_ENDDOC_ENF)
        THEN
            V_DEBUGSTEP := '30-2-S[' || V_LOOPCNT || ']';
            DBMS_OUTPUT.PUT_LINE ('- START JOB : ' || V_JOBID);

            SP_BATCH_MIG_ENDDOC(V_JOBID, V_JOBMAXTIME, 'ENF', V_RETURNMSG);
            V_RESULTMSG := V_RETURNMSG;

            V_DEBUGSTEP := '30-2-E[' || V_LOOPCNT || ']';

        ------------------------------------------------------------------------
        -- 중복 집계 기록물 삭제 작업 시작
        ELSIF (V_JOBID = DEF_JOBID_DEL_DUPREC)
        THEN
            V_DEBUGSTEP := '30-3-S[' || V_LOOPCNT || ']';
            DBMS_OUTPUT.PUT_LINE ('- START JOB : ' || V_JOBID);

            SP_BATCH_DEL_DUPREC(V_JOBID, V_JOBMAXTIME, V_RETURNMSG);
            V_RESULTMSG := V_RETURNMSG;

            V_DEBUGSTEP := '30-3-E[' || V_LOOPCNT || ']';

        ------------------------------------------------------------------------
        -- 과제카드 변경 기록물 추출 작업 시작
        ELSIF (V_JOBID = DEF_JOBID_SEL_CHANGEREC)
        THEN
            V_DEBUGSTEP := '30-4-S[' || V_LOOPCNT || ']';
            DBMS_OUTPUT.PUT_LINE ('- START JOB : ' || V_JOBID);

            SP_BATCH_SEL_CHANGEREC(V_JOBID, V_JOBMAXTIME, V_RETURNMSG);
            V_RESULTMSG := V_RETURNMSG;

            V_DEBUGSTEP := '30-4-E[' || V_LOOPCNT || ']';

        ------------------------------------------------------------------------
        -- 진행중문서(생산) 이관 작업 시작
        ELSIF (V_JOBID = DEF_JOBID_MIG_PROC_DCT)
        THEN
            V_DEBUGSTEP := '30-5-S[' || V_LOOPCNT || ']';
            DBMS_OUTPUT.PUT_LINE ('- START JOB : ' || V_JOBID);

            SP_BATCH_MIG_PROC_DCT(V_JOBID, V_JOBMAXTIME, V_RETURNMSG);
            V_RESULTMSG := V_RETURNMSG;

            V_DEBUGSTEP := '30-5-E[' || V_LOOPCNT || ']';
        
        ------------------------------------------------------------------------
        -- 작업이 추가될때 마다 ELSIF 추가하면 됨
        ELSE
            V_DEBUGSTEP := '30-99-S[' || V_LOOPCNT || ']';
            DBMS_OUTPUT.PUT_LINE ('- ERROR JOB : ' || V_JOBID);

            V_ERRORFLAG := 'Y';
            V_RESULTMSG := '[SKIP] This job has no procedure to process.';
            
            -- 배치작업 QUEUE 테이블에 완료FLAG 기록 
            -- 해당 작업을 처리하는 부분이 없으므로 더 이상 해당 작업이 수행되지 않도록 함
            -- - 작업 QUEUE 에러 처리 (ENDFLAG E 처리 : ERROR 발생)
            UPDATE BMS_COM_BATCHJOB_QUEUE
               SET ENDFLAG = 'E'
             WHERE JOBID = V_JOBID
            ;
            
            COMMIT;

            V_DEBUGSTEP := '30-99-E[' || V_LOOPCNT || ']';

        END IF;
        DBMS_OUTPUT.PUT_LINE('------------------------------------');


        ------------------------------------------------------------------------
        V_DEBUGSTEP := '40[' || V_LOOPCNT || ']';

        --
        -- 작업 이력 업데이트 (종료일시)
        --
        UPDATE BMS_COM_BATCHJOB_HIS
           SET ENDDT = TO_CHAR(SYSDATE, 'yyyymmddhh24miss')
             , ERRORFLAG = V_ERRORFLAG
             , RESULTMSG = V_RESULTMSG
         WHERE JOBID = V_JOBID
           AND STARTDT = V_STARTDT
        ;
        
        COMMIT;

        DBMS_OUTPUT.PUT_LINE ('- UPDATE_HIS(JOBID, STARTDT) : (' || V_JOBID || ', ' || V_STARTDT || ')');


        ------------------------------------------------------------------------
        V_DEBUGSTEP := '50[' || V_LOOPCNT || ']';

        -- 총 작업 소요시간을 계산 (분 단위)
        V_EXECTIME := TRUNC ((SYSDATE - V_BEFOREDATE) * 24 * 60);
        DBMS_OUTPUT.PUT_LINE('- (SP_COM_EXEC_BATCHJOB) LOOP.V_EXECTIME : ' || V_EXECTIME);


        ------------------------------------------------------------------------
        -- LOOP 조건 체크 - 총 작업 소요시간 초과 여부
        --
        -- 소요시간이 전체 작업 최대 시간을 초과하면 중단
        EXIT WHEN V_EXECTIME > DEF_MAXJOBTIME;
        ------------------------------------------------------------------------
        
        V_LOOPCNT := V_LOOPCNT + 1;

    END LOOP;

    DBMS_OUTPUT.PUT_LINE('------------------------------------');
    DBMS_OUTPUT.PUT_LINE('- (SP_COM_EXEC_BATCHJOB) LOOP end.');

    DBMS_OUTPUT.PUT_LINE ('[END] SP_COM_EXEC_BATCHJOB : ' || TO_CHAR (SYSDATE, 'yyyy-mm-dd hh24:mi:ss'));

EXCEPTION
    WHEN NO_DATA_FOUND
    THEN
        -- 배치작업 Queue에 내용이 존재하지 않을 경우 처리
        DBMS_OUTPUT.PUT_LINE ('- There is no job to process.');
        DBMS_OUTPUT.PUT_LINE ('[END] SP_COM_EXEC_BATCHJOB : ' || TO_CHAR (SYSDATE, 'yyyy-mm-dd hh24:mi:ss'));

    WHEN OTHERS
    THEN
        -- Exception이 발생했을 경우 해당 JOB이 더 이상 수행되지 않도록 완료 처리함
        V_RESULTMSG := '[EXCEPTION] [' || V_DEBUGSTEP || '] [' || TO_CHAR(SYSDATE, 'yyyymmddhh24miss') || '] ' || SQLERRM;

        DBMS_OUTPUT.PUT_LINE (V_RESULTMSG);
        
        -- 작업 이력 업데이트 (종료일시)
        -- - ERROR가 발생했으므로 ENDDT 는 업데이트 하지 않음
        UPDATE BMS_COM_BATCHJOB_HIS
           SET ERRORFLAG = 'Y'
             , RESULTMSG = V_RESULTMSG
         WHERE JOBID = V_JOBID
           AND STARTDT = V_STARTDT
        ;
        
        -- 작업 QUEUE 에러 처리 (ENDFLAG E 처리 : ERROR 발생)
        UPDATE BMS_COM_BATCHJOB_QUEUE
           SET ENDFLAG = 'E'
         WHERE JOBID = V_JOBID
        ;
        
        COMMIT;
END;
/
