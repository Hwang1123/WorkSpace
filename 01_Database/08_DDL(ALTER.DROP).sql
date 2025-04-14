/*
    DDL : 데이터 정의어
    
    갤체를 생성(CREATE), 변경(ALTER), 삭제(DROP)하는 구문
    
    <ALTER>
    객체를 변경하는 구문
    
    [표현식]
    ALTER TABLE 테이블명 변경할 내용
    * 변경할 내용 
    1) 컬럼 추가/수정/삭제
    2) 제약조건 추가/삭제
    3) 컬럼명/제약조건명/테이블명 변경
*/

SELECT * FROM DEPT_TABLE;
 -- 1) 컬럼 추가/수정/삭제
 -- DEPT_TABLE에 CNAME 컬럼 추가
 ALTER TABLE DEPT_TABLE ADD CNAME VARCHAR2(20);
 
 -- LNAME 컬럼 추가 => 기본값(한국)
 ALTER TABLE DEPT_TABLE ADD LNAME VARCHAR2(20) DEFAULT '한국';
 SELECT * FROM DEPT_TABLE;
 
 -- 1_2) 컬럼 수정
 -- 데이터 타입 수정 : MODIFY 컬럼명 바꾸고자 하는 데이터 타입
 -- DEFAULT값 수정 : MODIFY 컬럼명 DEFAULT 변경할 기본 값
 
 ALTER TABLE DEPT_TABLE MODIFY DEPT_ID CHAR(5);
 ALTER TABLE DEPT_TABLE MODIFY DEPT_ID NUMBER; -- 형식 오류가 발생
 
 -- DEPT_TITLE 컬럼을 VARCHAR(40)
 ALTER TABLE DEPT_TABLE MODIFY DEPT_TITLE VARCHAR2(40);
 -- LNAME 컬럼의 기본 값을 '미국'으로 변경
 ALTER TABLE DEPT_TABLE MODIFY LNAME DEFAULT '미국';
 
 -- 다중변경 가능
 ALTER TABLE DEPT_TABLE
        MODIFY DEPT_TITLE VARCHAR(40)
        MODIFY LNAME DEFAULT '미국';

SELECT * FROM DEPT_TABLE;

-- 1_3) 컬럼 삭제(DROP COLUMN) : DROP COLUMN 삭제하고자 하는 컬럼
CREATE TABLE DEPT_COPY
AS (SELECT * FROM DEPT_TABLE);

SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;
ALTER TABLE DEPT_COPY DROP COLUMN CNAME;
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;
 
ALTER TABLE DEPT_COPY DROP COLUMN LOCATION_ID;

-------------------------------------------------------------------------------
-- 2) 제약조건 추가/삭제(수정은 삭제하고 다시 추가하면 된다.)
/*
    2_1)
    - PRIMARY KEY : ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명);
    - FOREIGN KEY : ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명(컬럼명);
    - UNIQUE : ALTER TABLE 테이블명 ADD UNIQUE(컬럼명);
    - CHECK : ALTER TABLE 테이블명 ADD CHECK(컬럼에 대한 조건식);
    - NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
    
    제약조건명 지정하고자 한다면 [CONSTRAINT 제약조건명] 제약조건
*/

-- DEPT_TABLE
-- DEPT_ID에 PRIMARY KEY제약조건 추가
-- DEPT_TITLE에 UNIQUE제약조건 추가
-- LNAME에 NOT NULL 제약조건 추가
ALTER TABLE DEPT_TABLE
        ADD CONSTRAINT DTABLE_PK PRIMARY KEY(DEPT_ID)
        ADD CONSTRAINT DTABLE_UQ UNIQUE(DEPT_TITLE)
        MODIFY LNAME CONSTRAINT DTABLE_NN NOT NULL;
        
-- 2_2) 제약조건 삭제 : DROP CONSTRAINT 제약조건명(NOT NULL 삭제안됨)
ALTER TABLE DEPT_TABLE DROP CONSTRAINT DTABLE_PK;
ALTER TABLE DEPT_TABLE
        DROP CONSTRAINT DTABLE_UQ
        MODIFY LNAME NULL;
--------------------------------------------------------------
-- 테이블 삭제
DROP TABLE DEPT_TABLE;
-- 어딘가에 참조 되고 있는 부모 테이블은 함부로 삭제가 되지 않는다.
-- 만약 지우고자 한다면
-- 1. 자식 테이블 먼저 전부 삭제
-- 2. 그냥 부모 테이블만 삭제하는데 제약조건까지 삭제하는 방법
-- DROP TABLE 테이블명 CASCADE CONSTRAINT

CREATE TABLE DEPT_TABLE
AS (SELECT * FROM DEPARTMENT);

SELECT * FROM DEPT_TABLE;

-- 3) 컬럼명/제약조건명/테이블명 변경
-- 3_1) 컬럼명 변경 : RENAME COLUMN 기존 컬럼명 TO 바꿀 컬럼명
-- DEPT_TITLE => DEPT_NAME
ALTER TABLE DEPT_TABLE RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

-- 3_2) 제약조건명 변경 : RENAME CONSTRAINT 기존 제약조건명 TO 바꿀 제약조건명
ALTER TABLE DEPT_TABLE RENAME CONSTRAINT SYS_C008850 TO DTABLE_ID_NN;

-- 3_3) 테이블명 변경 : RENAME TO 바꿀 테이블명
ALTER TABLE DEPT_TABLE RENAME TO DEPT_TEST;











