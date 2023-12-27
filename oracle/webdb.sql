SELECT SYSDATE FROM dual;

CREATE table author(
	author_id number(10), 
	author_name varchar2(100) NOT null,
	author_decs varchar2(500),
	PRIMARY KEY(author_id)
);

select * from book;
select * from Book;
drop table book;

CREATE Table book(
    BOOK_ID number,
    title VARCHAR2(100) not null,
    pubs VARCHAR2(100),
    PUB_DATE date,
    AUTHOR_ID number(10),
    primary key(book_id),
    CONSTRAINT c_book_fk FOREIGN key (AUTHOR_ID)
    REFERENCEs author(AUTHOR_ID)
);


INSERT INTO author
VALUES (1, '박경리', '토지 작가 ');

INSERT INTO author(AUTHOR_ID, AUTHOR_NAME)
VALUES (2, '이문열');

SELECT *
from AUTHOR;

UPDATE AUTHOR
SET author_name = '기안84',
    AUTHOR_DECS = '웬툰작가'
where AUTHOR_ID = 1;

DROP SEQUENCE seq_book_id ;

CREATE SEQUENCE seq_author_id
INCREMENT BY 1
START WITH 7;

INSERT into AUTHOR
VALUES (seq_author_id.nextval, '박경리', '토지 작가');

SELECT * FROM USER_SEQUENCES;

SELECT seq_author_id.currval FROM dual;

SELECT seq_author_id.nextval from dual;

SELECT b.BOOK_ID, b.TITLE, b.PUBS, TO_CHAR(b.PUB_DATE, 'YYYY/MM/DD' ) pubdate, a.AUTHOR_NAME  
FROM BOOK b, AUTHOR a  
WHERE a.AUTHOR_ID = b.AUTHOR_ID 
AND b.TITLE || b.PUBS || a.AUTHOR_NAME LIKE '%의%';

ALTER TABLE AUTHOR
RENAME COLUMN AUTHOR_DECS TO AUTHOR_DESC;
