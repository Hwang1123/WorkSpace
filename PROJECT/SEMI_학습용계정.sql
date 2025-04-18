-- SALES_DETAILS 시퀀스 
DROP SEQUENCE SEQ_SNO;
CREATE SEQUENCE SEQ_SNO START WITH 1 INCREMENT BY 1;

-- BOARD 시퀀스
DROP SEQUENCE SEQ_BNO;
CREATE SEQUENCE SEQ_BNO START WITH 1 INCREMENT BY 1;

-- REPLY 시퀀스
DROP SEQUENCE SEQ_RNO;
CREATE SEQUENCE SEQ_RNO START WITH 1 INCREMENT BY 1;

-- PRODUCT 시퀀스
DROP SEQUENCE SEQ_PNO;
CREATE SEQUENCE SEQ_PNO START WITH 1 INCREMENT BY 1;

-- PRODUCT_INVENTORY 시퀀스
DROP SEQUENCE SEQ_INO;
CREATE SEQUENCE SEQ_INO START WITH 1 INCREMENT BY 1;

-- INOUT_HISTORY 시퀀스
DROP SEQUENCE SEQ_HNO;
CREATE SEQUENCE SEQ_HNO START WITH 1 INCREMENT BY 1;

-- PRODUCT_CATEGORY 시퀀스
DROP SEQUENCE SEQ_CNO;
CREATE SEQUENCE SEQ_CNO START WITH 1 INCREMENT BY 1;

-- ATTACHMENT 시퀀스
DROP SEQUENCE SEQ_ANO;
CREATE SEQUENCE SEQ_ANO START WITH 1 INCREMENT BY 1;

-- INOUT_GROUP 시퀀스
DROP SEQUENCE SEQ_GNO;
CREATE SEQUENCE SEQ_GNO START WITH 1 INCREMENT BY 1;

-- CART 시퀀스
DROP SEQUENCE SEQ_CTNO;
CREATE SEQUENCE SEQ_CTNO START WITH 1 INCREMENT BY 1;

-- RECIPE 시퀀스
DROP SEQUENCE SEQ_RCNO;
CREATE SEQUENCE SEQ_RCNO START WITH 1 INCREMENT BY 1;
-------------------------------------------------------------------------

-- 테이블 삭제
DROP TABLE RECIPE CASCADE CONSTRAINTS;
DROP TABLE CART CASCADE CONSTRAINTS;
DROP TABLE SALES_DETAILS CASCADE CONSTRAINTS;
DROP TABLE REPLY CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE USER_INFO CASCADE CONSTRAINTS;
DROP TABLE PRODUCT CASCADE CONSTRAINTS;
DROP TABLE PRODUCT_CATEGORY CASCADE CONSTRAINTS;
DROP TABLE DEPARTMENT CASCADE CONSTRAINTS;
DROP TABLE JOB CASCADE CONSTRAINTS;
DROP TABLE ATTACHMENT CASCADE CONSTRAINTS;
DROP TABLE PRODUCT_INVENTORY CASCADE CONSTRAINTS;
DROP TABLE INOUT_HISTORY CASCADE CONSTRAINTS;
DROP TABLE INOUT_GROUP CASCADE CONSTRAINTS;

-------------------------------------------------------------------------------------------------------------------------------------------------------------
-- PRODUCT_CATEGORY 테이블 생성
CREATE TABLE PRODUCT_CATEGORY (
   PROCATEGORY_NO       NUMBER          NOT NULL,
   PRO_CATEGORY       VARCHAR2(100),
   PRIMARY KEY (PROCATEGORY_NO)
);

-- 컬럼 주석
COMMENT ON COLUMN PRODUCT_CATEGORY.PROCATEGORY_NO IS '제품 카테고리 번호';
COMMENT ON COLUMN PRODUCT_CATEGORY.PRO_CATEGORY IS '제품 카테고리명(화장품 종류)';

-- 더미 데이터
INSERT INTO PRODUCT_CATEGORY VALUES (SEQ_CNO.NEXTVAL, '스킨');
INSERT INTO PRODUCT_CATEGORY VALUES (SEQ_CNO.NEXTVAL, '로션');
INSERT INTO PRODUCT_CATEGORY VALUES (SEQ_CNO.NEXTVAL, '선크림');
INSERT INTO PRODUCT_CATEGORY VALUES (SEQ_CNO.NEXTVAL, '수분크림');
INSERT INTO PRODUCT_CATEGORY VALUES (SEQ_CNO.NEXTVAL, '앰플');
INSERT INTO PRODUCT_CATEGORY VALUES (SEQ_CNO.NEXTVAL, '재료');

-- 카테고리 전체 조회
SELECT * 
FROM PRODUCT_CATEGORY  ;

-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- JOB 테이블 생성
CREATE TABLE JOB (
   JOB_CODE    CHAR(2)      NOT NULL,
   JOB_NAME    VARCHAR2(10), 
   SALARY       NUMBER,
   PRIMARY KEY (JOB_CODE)
); 

-- 컬럼 주석
COMMENT ON COLUMN JOB.JOB_CODE IS '직급 코드';
COMMENT ON COLUMN JOB.JOB_NAME IS '직급명';
COMMENT ON COLUMN JOB.SALARY IS '급여';

-- 더미 데이터
INSERT INTO JOB VALUES ('J0', '거래처',0);
INSERT INTO JOB VALUES ('J1', '사원',1800000);
INSERT INTO JOB VALUES ('J2', '대리',2000000);
INSERT INTO JOB VALUES ('J3', '과장',2500000);
INSERT INTO JOB VALUES ('J4', '부장',3000000);
INSERT INTO JOB VALUES ('J5','대표',3500000);


-- 직급 전체 조회
SELECT * 
FROM JOB  ;
-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- DEPARTMENT 테이블 생성
CREATE TABLE DEPARTMENT (
   DEPT_CODE       CHAR(3)       NOT NULL,
   DEPT_NAME       VARCHAR2(30),
   DEPT_PHONE       VARCHAR2(4),
   PRIMARY KEY (DEPT_CODE)
);

-- 컬럼 주석
COMMENT ON COLUMN DEPARTMENT.DEPT_CODE IS '부서 코드';
COMMENT ON COLUMN DEPARTMENT.DEPT_NAME IS '부서명';
COMMENT ON COLUMN DEPARTMENT.DEPT_PHONE IS '부서 전화번호';

-- 더미 데이터
INSERT INTO DEPARTMENT VALUES ('D0',NULL,NULL);
INSERT INTO DEPARTMENT VALUES ('D1', '영업부', '1001');
INSERT INTO DEPARTMENT VALUES ('D2', '마케팅부', '1002');
INSERT INTO DEPARTMENT VALUES ('D3', '생산부', '1003');
INSERT INTO DEPARTMENT VALUES ('D4', '인사부', '1004');
INSERT INTO DEPARTMENT VALUES ('D5', '개발부', '1005');

-- 부서 전체 조회
SELECT * 
FROM DEPARTMENT  ;

-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- USER 테이블 생성
CREATE TABLE USER_INFO(
   USER_ID       VARCHAR2(30)       NOT NULL,
   JOB_CODE       CHAR(2)          NOT NULL,
   DEPT_CODE       CHAR(3)            NOT NULL,
   USER_PWD       VARCHAR2(100)       NOT NULL,
   COMPANY_NAME    VARCHAR2(30),
   USER_NAME       VARCHAR2(15)       NOT NULL,
   PHONE          VARCHAR2(11)       NOT NULL,
   EMAIL          VARCHAR2(100)       NOT NULL,
   ENROLL_DATE    DATE             DEFAULT SYSDATE,
   MODIFY_DATE    DATE             DEFAULT SYSDATE,
   STATUS          VARCHAR2(1)       DEFAULT 'W',
   USER_DELETED    CHAR(1)          DEFAULT 'N' NOT NULL,
   PRIMARY KEY (USER_ID),
   FOREIGN KEY (JOB_CODE) REFERENCES JOB(JOB_CODE),
   FOREIGN KEY (DEPT_CODE) REFERENCES DEPARTMENT(DEPT_CODE)
);

-- 컬럼 주석
COMMENT ON COLUMN USER_INFO.USER_ID IS '아이디';
COMMENT ON COLUMN USER_INFO.JOB_CODE IS '직급 코드 (J1~J6, 거래처는 J0)';
COMMENT ON COLUMN USER_INFO.DEPT_CODE IS '부서 코드 (D1~D5, 거래처는 D0)';
COMMENT ON COLUMN USER_INFO.USER_PWD IS '비밀번호';
COMMENT ON COLUMN USER_INFO.COMPANY_NAME IS '기업명';
COMMENT ON COLUMN USER_INFO.USER_NAME IS '이름';
COMMENT ON COLUMN USER_INFO.PHONE IS '전화번호';
COMMENT ON COLUMN USER_INFO.EMAIL IS '이메일';
COMMENT ON COLUMN USER_INFO.ENROLL_DATE IS '가입일';
COMMENT ON COLUMN USER_INFO.MODIFY_DATE IS '수정일';
COMMENT ON COLUMN USER_INFO.STATUS IS '승인 상태값(Y/N)';
COMMENT ON COLUMN USER_INFO.USER_DELETED IS '삭제됨 Y , 삭제안됨 N';


-- 대표 (J5는 대표 한 명만 유지)
--INSERT INTO USER_INFO VALUES ('admin', 'J5', 'D1', 'pass01', NULL, '홍길동', '01011112222', 'user01@test.com', SYSDATE, SYSDATE, 'Y', 'N');

-- 직원
INSERT INTO USER_INFO VALUES ('user02', 'J1', 'D2', 'pass02', NULL, '김철수', '01022223333', 'user02@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user03', 'J2', 'D3', 'pass03', NULL, '이영희', '01033334444', 'user03@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user04', 'J3', 'D4', 'pass04', NULL, '박민수', '01044445555', 'user04@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user05', 'J4', 'D5', 'pass05', NULL, '정다인', '01055556666', 'user05@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user06', 'J2', 'D1', 'pass06', NULL, '최수민', '01066667777', 'user06@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user07', 'J1', 'D3', 'pass07', NULL, '한예준', '01077778888', 'user07@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user08', 'J3', 'D2', 'pass08', NULL, '강하늘', '01088889999', 'user08@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user09', 'J4', 'D4', 'pass09', NULL, '오승아', '01099990000', 'user09@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user10', 'J1', 'D5', 'pass10', NULL, '윤지우', '01012121212', 'user10@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user11', 'J2', 'D4', 'pass11', NULL, '김나연', '01023232323', 'user11@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user12', 'J3', 'D5', 'pass12', NULL, '이도현', '01034343434', 'user12@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user13', 'J4', 'D1', 'pass13', NULL, '박지훈', '01045454545', 'user13@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user14', 'J1', 'D2', 'pass14', NULL, '장원영', '01056565656', 'user14@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('user15', 'J2', 'D3', 'pass15', NULL, '최예나', '01067676767', 'user15@test.com', SYSDATE, SYSDATE, 'Y', 'N');

-- 거래처 
INSERT INTO USER_INFO VALUES ('partner01', 'J0', 'D0', 'pass13', 'LG생활건강', '이승철', '01030303030', 'partner01@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('partner02', 'J0', 'D0', 'pass14', '아모레퍼시픽', '박지윤', '01040404040', 'partner02@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('partner03', 'J0', 'D0', 'pass15', '코스맥스', '정우성', '01050505050', 'partner03@test.com', SYSDATE, SYSDATE, 'Y', 'N');
INSERT INTO USER_INFO VALUES ('partner04', 'J0', 'D0', 'pass16', '한국콜마', '한지민', '01060606060', 'partner04@test.com', SYSDATE, SYSDATE, 'Y', 'N');

INSERT INTO USER_INFO VALUES ('partner05', 'J0', 'D0', 'pass17', '마이크로소프트', '이서준', '01020202020', 'partner05@test.com', SYSDATE, SYSDATE, 'W', 'N');
INSERT INTO USER_INFO VALUES ('partner06', 'J0', 'D0', 'pass18', '삼성전자', '박예준', '01043434343', 'partner06@test.com', SYSDATE, SYSDATE, 'W', 'N');
INSERT INTO USER_INFO VALUES ('partner07', 'J0', 'D0', 'pass19', '웰스파고', '정지호', '01054545454', 'partner07@test.com', SYSDATE, SYSDATE, 'W', 'N');
INSERT INTO USER_INFO VALUES ('partner08', 'J0', 'D0', 'pass20', '씨티그룹', '한시우', '01065656565', 'partner08@test.com', SYSDATE, SYSDATE, 'W', 'N');

INSERT INTO USER_INFO VALUES ('partner09', 'J0', 'D0', 'pass21', '월마트', '이서윤', '01038383838', 'partner09@test.com', SYSDATE, SYSDATE, 'N', 'N');
INSERT INTO USER_INFO VALUES ('partner10', 'J0', 'D0', 'pass22', '버라이즌', '박지우', '01049494949', 'partner10@test.com', SYSDATE, SYSDATE, 'N', 'N');
INSERT INTO USER_INFO VALUES ('partner11', 'J0', 'D0', 'pass23', '로열 더치 쉘', '정하은', '01051515151', 'partner11@test.com', SYSDATE, SYSDATE, 'N', 'N');
INSERT INTO USER_INFO VALUES ('partner12', 'J0', 'D0', 'pass24', '아마존닷컴', '한윤서', '01062626262', 'partner12@test.com', SYSDATE, SYSDATE, 'N', 'N');

-- 유저 전체 조회
SELECT * 
FROM USER_INFO;
-------------------------------------------------------------------------------------------------------------------------------------------------------------


-- BOARD 테이블 생성
CREATE TABLE BOARD (
   POST_ID       NUMBER          NOT NULL,
   USER_ID       VARCHAR2(30)    NOT NULL,
   TITLE          VARCHAR2(100)   NOT NULL,
   CONTENT       VARCHAR2(1000),
   CREATED_DATE    DATE          DEFAULT SYSDATE    NOT NULL,
   UPDATE_DATE    DATE,
   TYPE          NUMBER,
   BOARD_DELETED    CHAR(1)       DEFAULT 'N'       NOT NULL,
   PRIMARY KEY (POST_ID),
   FOREIGN KEY (USER_ID) REFERENCES USER_INFO (USER_ID)
);

-- 컬럼 주석
COMMENT ON COLUMN BOARD.POST_ID IS '게시글 번호';
COMMENT ON COLUMN BOARD.USER_ID IS '작성자 ID';
COMMENT ON COLUMN BOARD.TITLE IS '제목';
COMMENT ON COLUMN BOARD.CONTENT IS '내용';
COMMENT ON COLUMN BOARD.CREATED_DATE IS '작성일자';
COMMENT ON COLUMN BOARD.UPDATE_DATE IS '수정일자';
COMMENT ON COLUMN BOARD.TYPE IS '게시판 유형 공지사항(1) 문의사항(2)';
COMMENT ON COLUMN BOARD.BOARD_DELETED IS '삭제됨 Y , 삭제안됨 N';

-- 더미 데이터
INSERT INTO BOARD VALUES (SEQ_BNO.NEXTVAL, 'admin', '공지사항 1', '공지 내용입니다1', SYSDATE, NULL, 1,'N');
INSERT INTO BOARD VALUES (SEQ_BNO.NEXTVAL, 'admin', '공지사항 2', '공지 내용입니다2', SYSDATE, NULL, 1,'N');
INSERT INTO BOARD VALUES (SEQ_BNO.NEXTVAL, 'admin', '공지사항 3', '공지 내용입니다3', SYSDATE, NULL, 1,'N');
INSERT INTO BOARD VALUES (SEQ_BNO.NEXTVAL, 'user02', '문의사항 1', '문의 내용입니다1', SYSDATE, NULL, 2,'N');
INSERT INTO BOARD VALUES (SEQ_BNO.NEXTVAL, 'user05', '문의사항 2', '문의 내용입니다2', SYSDATE, NULL, 2,'N');

-- 게시판 전체 조회
SELECT * 
FROM BOARD;
-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- REPLY 테이블 생성
CREATE TABLE REPLY (
   REP_NO          NUMBER          NOT NULL,
   POST_ID         NUMBER          NOT NULL,
   CONTENT       VARCHAR2(1000)   NOT NULL,
   WRITER          VARCHAR2(30)     NOT NULL,
   CREATED_DATE   DATE          DEFAULT SYSDATE    NOT NULL,
   UPDATE_DATE    DATE,
   REPLY_DELETED  CHAR(1)          DEFAULT 'N'        NOT NULL,
   PRIMARY KEY (REP_NO),
   FOREIGN KEY (POST_ID) REFERENCES BOARD (POST_ID)
);

-- 컬럼 주석
COMMENT ON COLUMN REPLY.REP_NO IS '댓글 번호';
COMMENT ON COLUMN REPLY.POST_ID IS '게시글 번호';
COMMENT ON COLUMN REPLY.CONTENT IS '내용';
COMMENT ON COLUMN REPLY.WRITER IS '작성자';
COMMENT ON COLUMN REPLY.CREATED_DATE IS '작성일자';
COMMENT ON COLUMN REPLY.UPDATE_DATE IS '수정일자';
COMMENT ON COLUMN REPLY.REPLY_DELETED IS '삭제됨 Y , 삭제안됨 N';


-- 댓글 전체 조회
SELECT * FROM REPLY;
-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- PRODUCT 테이블 생성
CREATE TABLE PRODUCT (
   PRO_NO         NUMBER          NOT NULL,
   PROCATEGORY_NO  NUMBER          NOT NULL,
   PRO_NAME       VARCHAR2(100),
   PRO_DETAIL       VARCHAR2(100),
   PRO_PRICE       NUMBER,
   PRO_DELETED    CHAR(1)       DEFAULT 'N'    NOT NULL,
   IS_PRODUCT       CHAR(1)          DEFAULT 'Y',
    PRO_ENROLL_DATE DATE DEFAULT SYSDATE NOT NULL,
   PRIMARY KEY (PRO_NO),
   FOREIGN KEY (PROCATEGORY_NO) REFERENCES PRODUCT_CATEGORY (PROCATEGORY_NO)
);

-- 컬럼 주석
COMMENT ON COLUMN PRODUCT.PRO_NO IS '제품 번호';
COMMENT ON COLUMN PRODUCT.PROCATEGORY_NO IS '제품 카테고리 번호';
COMMENT ON COLUMN PRODUCT.PRO_NAME IS '제품명';
COMMENT ON COLUMN PRODUCT.PRO_DETAIL IS '제품 상세 정보';
COMMENT ON COLUMN PRODUCT.PRO_PRICE IS '단가';
COMMENT ON COLUMN PRODUCT.PRO_DELETED IS '삭제됨 Y , 삭제안됨 N';
COMMENT ON COLUMN PRODUCT.IS_PRODUCT IS '완제품 여부(제품:Y 재료:N)';
COMMENT ON COLUMN PRODUCT.PRO_ENROLL_DATE IS '제품 , 재료 등록일자';


-- 상품 전체 조회
SELECT * FROM PRODUCT ;
-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 제품 재고 테이블 생성
CREATE TABLE PRODUCT_INVENTORY (
    PRO_INVEN_NO     NUMBER    NOT NULL, 
    PRO_NO            NUMBER    NOT NULL, 
    PRO_INVENT_STOCK  NUMBER     NOT NULL, 
    PRIMARY KEY (PRO_INVEN_NO),
    FOREIGN KEY (PRO_NO) REFERENCES PRODUCT(PRO_NO)
);

-- 컬럼 주석
COMMENT ON COLUMN PRODUCT_INVENTORY.PRO_INVEN_NO IS '제품 재고 번호';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRO_NO IS '제품 번호';
COMMENT ON COLUMN PRODUCT_INVENTORY.PRO_INVENT_STOCK IS '제품 재고 수량';


-- 제품 재고 전체 조회
SELECT * FROM PRODUCT_INVENTORY;

-------------------------------------------------------------------------------------------------------------------------------------------------------------

--INOUT_GROUP 테이블 생성
CREATE TABLE INOUT_GROUP (
   GROUP_NO   NUMBER   NOT NULL,
   USER_ID   VARCHAR2(30)   NOT NULL,
   GROUP_TYPE   CHAR(1)   NOT NULL,
   GROUP_DATE   DATE  DEFAULT SYSDATE  NOT NULL,
   GROUP_STATUS   CHAR(1)   NOT NULL,
   PRIMARY KEY (GROUP_NO), 
   FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID)
);

COMMENT ON COLUMN INOUT_GROUP.GROUP_NO IS '그룹번호';
COMMENT ON COLUMN INOUT_GROUP.USER_ID IS '소비자 아이디';
COMMENT ON COLUMN INOUT_GROUP.GROUP_TYPE IS '유형 (입고:O, 출고(판매):I)';
COMMENT ON COLUMN INOUT_GROUP.GROUP_DATE IS '입출고 날짜';
COMMENT ON COLUMN INOUT_GROUP.GROUP_STATUS IS '승인 상태 (W:대기, Y:승인, N:반려)';


-------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 제품 입출고 내역 테이블 생성
CREATE TABLE INOUT_HISTORY (
    HISTORY_NO       NUMBER        NOT NULL, 
    PRO_NO          NUMBER       NOT NULL, 
    GROUP_NO        NUMBER       NOT NULL,
    HISTORY_STOCK   NUMBER       NOT NULL, 
    HISTORY_PRICE   NUMBER      NOT NULL,
    PRIMARY KEY (HISTORY_NO),
    FOREIGN KEY (PRO_NO) REFERENCES PRODUCT(PRO_NO),
    FOREIGN KEY (GROUP_NO) REFERENCES INOUT_GROUP(GROUP_NO)
);

-- 컬럼 주석
COMMENT ON COLUMN INOUT_HISTORY.HISTORY_NO IS '내역 번호';
COMMENT ON COLUMN INOUT_HISTORY.PRO_NO IS '제품 번호';
COMMENT ON COLUMN INOUT_HISTORY.GROUP_NO IS '입출고 그룹 번호';
COMMENT ON COLUMN INOUT_HISTORY.HISTORY_STOCK IS '입출고 수량 - 입고시 단위는 g';
COMMENT ON COLUMN INOUT_HISTORY.HISTORY_PRICE IS '제품 단가';

-- 제품 입출고 내역 전체 조회
SELECT * FROM INOUT_HISTORY;

--------------------------------------------------------------------------------------------------

-- SALES_DETAILS 테이블 생성
CREATE TABLE SALES_DETAILS (
   SAL_NO          NUMBER       NOT NULL,
   USER_ID       VARCHAR2(30) NOT NULL,
   SALES_DATE       DATE    DEFAULT SYSDATE  NOT NULL,
   SALES_AMOUNT    NUMBER        NOT NULL,
   TYPE          CHAR(1)     NOT NULL,
   STATUS          CHAR(1)     DEFAULT 'N'    NOT NULL,
   PRO_NAME       VARCHAR2(50) NOT NULL,
    SALES_STOCK     NUMBER , 
    CHANGE_NAME     VARCHAR2(1000),
    GROUP_NO        NUMBER,
   PRIMARY KEY (SAL_NO),
   FOREIGN KEY (USER_ID) REFERENCES USER_INFO (USER_ID)
);

-- 컬럼 주석
COMMENT ON COLUMN SALES_DETAILS.SAL_NO IS '매출 번호';
COMMENT ON COLUMN SALES_DETAILS.USER_ID IS '작성자 ID';
COMMENT ON COLUMN SALES_DETAILS.SALES_DATE IS '판매/구매 일자';
COMMENT ON COLUMN SALES_DETAILS.SALES_AMOUNT IS '금액';
COMMENT ON COLUMN SALES_DETAILS.TYPE IS '분류 지출(O), 소득(I)';
COMMENT ON COLUMN SALES_DETAILS.STATUS IS '승인상태 대기:N 승인:Y';
COMMENT ON COLUMN SALES_DETAILS.PRO_NAME IS '제품 이름';
COMMENT ON COLUMN SALES_DETAILS.SALES_STOCK IS '입출고 수량';
COMMENT ON COLUMN SALES_DETAILS.CHANGE_NAME IS '입출고한 제품의 이미지 경로';
COMMENT ON COLUMN SALES_DETAILS.GROUP_NO IS '입출고내역의 그룹번호';


-- 매출내역 전체 조회
SELECT * FROM SALES_DETAILS;
-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- CART 테이블 생성
CREATE TABLE CART (
   CART_NO     NUMBER          NOT NULL,
   PRO_NO       NUMBER          NOT NULL,
   USER_ID    VARCHAR2(30)    NOT NULL,
   PRO_STOCK    NUMBER       NOT NULL,
   PRIMARY KEY (CART_NO, PRO_NO, USER_ID),
   FOREIGN KEY (PRO_NO) REFERENCES PRODUCT (PRO_NO),
   FOREIGN KEY (USER_ID) REFERENCES USER_INFO (USER_ID)
);

-- 컬럼 주석
COMMENT ON COLUMN CART.CART_NO IS '장바구니 번호';
COMMENT ON COLUMN CART.PRO_NO IS '제품 번호';
COMMENT ON COLUMN CART.USER_ID IS '유저 ID';
COMMENT ON COLUMN CART.PRO_STOCK IS '상품 구매 수량';



-- 장바구니 전체 조회
SELECT * FROM CART;

-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- RECIPE 테이블 생성
CREATE TABLE RECIPE (
    REC_NO      NUMBER      NOT NULL,
   PRO_NO       NUMBER       NOT NULL,
   MAT_NO       NUMBER       NOT NULL,
   AMOUNT       NUMBER       DEFAULT 10,
   PRIMARY KEY (REC_NO, MAT_NO, PRO_NO),
   FOREIGN KEY (PRO_NO) REFERENCES PRODUCT(PRO_NO),  -- 완제품 참조
   FOREIGN KEY (MAT_NO) REFERENCES PRODUCT(PRO_NO)  -- 재료 참조
);

-- 컬럼 주석
COMMENT ON COLUMN RECIPE.REC_NO IS '레시피 번호';
COMMENT ON COLUMN RECIPE.MAT_NO IS '재료 번호';
COMMENT ON COLUMN RECIPE.PRO_NO IS '제품 번호';
COMMENT ON COLUMN RECIPE.AMOUNT IS '제품 조합시 필요단위(g)';


-- 레시피 전체 조회
SELECT * FROM RECIPE;


-------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 첨부파일 테이블 생성
CREATE TABLE ATTACHMENT (
    ATC_NO       NUMBER         NOT NULL,
    PRO_NO       NUMBER         NULL,
    USER_ID      VARCHAR2(30)   NULL,
    ORIGIN_NAME  VARCHAR2(255)  NOT NULL,
    CHANGE_NAME  VARCHAR2(255)  NOT NULL,
    UPDATE_DATE  DATE          DEFAULT SYSDATE    NOT NULL,
    PRIMARY KEY (ATC_NO),
    FOREIGN KEY (PRO_NO) REFERENCES PRODUCT (PRO_NO),
    FOREIGN KEY (USER_ID) REFERENCES USER_INFO (USER_ID)
);

-- 컬럼 주석
COMMENT ON COLUMN ATTACHMENT.ATC_NO IS '파일 번호';
COMMENT ON COLUMN ATTACHMENT.PRO_NO IS '제품 번호';
COMMENT ON COLUMN ATTACHMENT.USER_ID IS '사용자 ID';
COMMENT ON COLUMN ATTACHMENT.ORIGIN_NAME IS '원본 파일명';
COMMENT ON COLUMN ATTACHMENT.CHANGE_NAME IS '변경된 파일명 + 파일 경로';
COMMENT ON COLUMN ATTACHMENT.UPDATE_DATE IS '업로드 일자';


COMMIT;