 
    /**
    no -> 사원번호, pk
    kor_name 한글이름
    eng_name 영어이름
    han_name 한문이름
    jumin1   주민번호1
    jumin2   주민번호2
    img      사진파일명
    b_year   생년
    b_month  월
    b_day    일
    calendar 양/음력
    gender   성별
    marry    결혼
    work_date 년차
    sal_type 급여타입
    work_type 근무형태(SI/SM)
    work_state 계약 형태(정규/계약)
    addr1 주소1
    addr2 주소2
    tel1  전화번호1
    tel2  전화번호2
    tel3  전화번호3
    email 이메일
    tech  기술등급
    drink  주량
    */
    create table board_0616 (
        NO 			varchar(4) not null, 
        KOR_NAME 	VARCHAR(20) NULL,
        ENG_NAME 	VARCHAR(20) NULL,
        HAN_NAME 	VARCHAR(20) NULL,
        JUMIN1   	VARCHAR(20) NULL,
        JUMIN2  	VARCHAR(20) NULL,
        IMG     	VARCHAR(100) NULL,
        B_YEAR   	VARCHAR(20) NULL,
        B_MONTH  	VARCHAR(20) NULL,
        B_DAY    	VARCHAR(20) NULL,
        CALENDER 	VARCHAR(20) NULL,
        GENDER   	VARCHAR(20) NULL,
        MARRY   	VARCHAR(20) NULL,
        WORK_DATE 	VARCHAR(20) NULL,
        SAL_TYPE   	VARCHAR(20) NULL,
        WORK_TYPE   VARCHAR(20) NULL,
        WORK_STATE  VARCHAR(20) NULL,
        ADDR1   	VARCHAR(50) NULL,
        ADDR2   	VARCHAR(50) NULL,
        TEL1   		VARCHAR(20) NULL,
        TEL2   		VARCHAR(20) NULL,
        TEL3   		VARCHAR(20) NULL,
        EMAIL   	VARCHAR(40) NULL,
        TECH   		VARCHAR(20) NULL,
        DRINK   	VARCHAR(20) NULL
    );
CREATE SEQUENCE  seq_BOARD_0616
 START WITH  1
INCREMENT BY 1
 CACHE 20;
 commit;
 
 
 
 insert into board_0616 values (
  seq_BOARD_0616.nextval, '안녕',  'hi',  
   '안녕', '123123', '1231231', '123123', '1988', '09', '14',
   '양력', '여자', '기혼', '1', '월급', 'SI', '정규', '경기도',
   '안산', '111', '1111', '1111', '12@naver.com', '초급', '1'
   );
   
   
   
   
-----------------------------------------------------------------------------------   
-----------------------------------------------------------------------------------   
-----------------------------------------------------------------------------------
-- 회사 대표등록   
   
create table companyInfo(
    companyName varchar(20), -- 회사이름
    companyNo INT PRIMARY KEY ,   -- 회사고유번호
    addr varchar(30),        -- 회사주소
    daepyoType varchar(20),   -- 대표구분
    daepyos varchar(40),     -- 각자대표
    daepyosName varchar(10), -- 각자대표1명
    daepyosAddress varchar(30),-- 각자대표 주소
    jumin1 varchar(20),        -- 주민등록번호 앞자리
    jumin2 varchar(20),        -- 주민등록번호 뒷자리
    daepyo varchar(30),      -- 대표
    homepage varchar(40),    -- 홈페이지주소
    etc varchar(50)          -- 기타
);

create SEQUENCE seq_companyInfo
 START WITH 1
 INCREMENT BY 1
 CACHE 20;
 COMMIT;
 