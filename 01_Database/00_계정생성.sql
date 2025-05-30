-- 한 줄 주석
/*
    여러줄
    주석
*/

--일반 사용자 계정을 생성하는 구문(오진 관리자 계정에서만 사용할 수 있음)
--[표현법] CREATE USER c##계정명 IDENTIFIED BY 비밀번호;
CREATE USER C##SPRING IDENTIFIED BY SPRING;
--SQL은 대소문자를 구분하지 않음 다만 비밀번호는 대소문자를 구분함

--위에서 생성된 일반 사용자계정에 최소한의 권한(접속, 데이터관리) 부여
--[표현법] GRANT 권한1 , 권한2 ... TO 계정;
GRANT CONNECT, RESOURCE TO C##SPRING;

ALTER USER C##SPRING DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

drop user [id] cascade; -- 계정삭제