create table aaa(
    dataNo int,
    data1 varchar(20)
);
create sequence seq_aaa
start with 1
increment by 1
cache 20;

insert into aaa values (seq_aaa.nextval,'가'); -- dataNo=2
insert into aaa values(seq_aaa.nextval,'나');-- dataNo=3
insert into aaa values(seq_aaa.nextval,'다');-- dataNo=4