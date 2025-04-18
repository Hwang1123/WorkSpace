--1.
CREATE TABLE TB_CATEGORY(
    NAME VARCHAR2(10),
    USE_YN CHAR(1)DEFAULT 'Y'
);
SELECT * FROM TB_CATEGORY;

--2.
CREATE TABLE TB_CLASS_TYPE(
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);
SELECT * FROM TB_CLASS_TYPE;

--3.
ALTER TABLE TB_CATEGORY ADD PRIMARY KEY(NAME);

--4.
ALTER TABLE TB_CATEGORY MODIFY NAME NOT NULL;

--5.
ALTER TABLE TB_CATEGORY MODIFY NAME VARCHAR2(20);
ALTER TABLE TB_CLASS_TYPE MODIFY NO VARCHAR2(10)
                        MODIFY NAME VARCHAR2(20);

--6.
ALTER TABLE TB_CATEGORY RENAME COLUMN NAME TO CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE RENAME COLUMN NO TO CLASS_TYPE_NO;
ALTER TABLE TB_CLASS_TYPE RENAME COLUMN TB_CLASS_TYPE_NO TO CLASS_TYPE_NAME;

--7.
ALTER TABLE TB_CATEGORY RENAME CONSTRAINT SYS_C008345 TO PK_CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE RENAME CONSTRAINT SYS_C008344 TO PK_CLASS_TYPE_NAME;

--8.
INSERT INTO TB_CATEGORY VALUES ('공학', 'Y');
INSERT INTO TB_CATEGORY VALUES ('자연과학', 'Y');
INSERT INTO TB_CATEGORY VALUES ('의학', 'Y');
INSERT INTO TB_CATEGORY VALUES ('예체능', 'Y');
INSERT INTO TB_CATEGORY VALUES ('인문사회', 'Y');
COMMIT;

--9.
ALTER TABLE TB_DEPARTMENT ADD FOREIGN KEY(CATEGORY) REFERENCES TB_CATEGORY(CATEGORY_NAME);

--10.
GRANT CREATE VIEW TO C##TEST; --관리자 계정 실행

CREATE VIEW VW_학생일반정보
    AS SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
        FROM TB_STUDENT;
        
SELECT * FROM VW_학생일반정보;

--11.
CREATE VIEW VW_지도면담
    AS (SELECT STUDENT_NAME, DEPARTMENT_NAME, PROFESSOR_NAME
        FROM TB_STUDENT
        JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
        JOIN TB_CLASS USING(DEPARTMENT_NO)
        JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
        JOIN TB_PROFESSOR USING(PROFESSOR_NO));
        
SELECT * FROM VW_지도면담;

--12.
CREATE VIEW VW_학과별학생수
    AS (SELECT DEPARTMENT_NAME, COUNT(*) AS "STUDENT_COUNT"
        FROM TB_DEPARTMENT
        JOIN TB_STUDENT USING(DEPARTMENT_NO)
        GROUP BY DEPARTMENT_NAME);
        
SELECT * FROM VW_학과별학생수;

--13.
UPDATE VW_학생일반정보
SET STUDENT_NAME = '황윤창'
WHERE STUDENT_NO = 'A213046';

SELECT * FROM VW_학생일반정보;

--14.
/*
    CREATE VIEW VW_학생일반정보
    AS SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
        FROM TB_STUDENT
    WITH READ ONLY;
*/
-- WITH READ ONLY절을 사용하여 뷰에 대해서 조회만 가능하도록 생성한다.

--15.
SELECT *
FROM (SELECT CLASS_NO, CLASS_NAME, COUNT(*) AS "누적수강생(명)"
    FROM TB_CLASS
    JOIN TB_GRADE USING(CLASS_NO)
    JOIN TB_STUDENT USING(STUDENT_NO)
    WHERE SUBSTR(TERM_NO, 1, 4) IN ('2009','2008','2007') --?????
    GROUP BY CLASS_NO, CLASS_NAME
    ORDER BY COUNT(*) DESC)
WHERE ROWNUM <= 3;

SELECT EXTRACT(YEAR FROM TO_DATE(TERM_NO, 'YYYYMM'))
FROM TB_GRADE
GROUP BY TERM_NO
ORDER BY TERM_NO DESC;