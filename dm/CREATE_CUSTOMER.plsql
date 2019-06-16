CREATE OR REPLACE PROCEDURE CREATE_CUSTOMER is
    V_CNT NUMBER;

BEGIN
    SELECT count(*) INTO V_CNT
    FROM ALL_TABLES
    WHERE OWNER = 'DEMO' AND
        TABLE_NAME = 'CUSTOMER';

    if V_CNT = 0 then
        EXEVUTE IMMEDIATE 'CREATE TABLE CUSTOMER
                            (
                                CUSTOMER_ID INTEGER,
                                EMAIL VARCHAR(45),
                                FIRSTNAME VARCHAR(40),
                                LASTNAME VARCHAR(40),
                                GENDER VARCHAR(20),
                                BIRTHDATE DATE,
                                CREDITS DECIAML(4,2)
                                )';
        COMMIT;
     end if;

     SELECT count(*) INTO V_CNT
     FROM ALL_SEQUENCE
     WHERE SEQUENCE_OWNER = 'DEMO' AND
           SEQUENCE_NAME = 'SEQ_ACCOUNTNUMBER';

     if V_CNT = 0 then
            EXECUTE IMMEDIATE 'CREATE SEQUENCE SEQ_CUSTOMERNUMBER
                                START WITH 10000
                                INCREMENT BY 1
                                CACHE 20';
            COMMIT,

     end if;
END CREATE_CUSTOMER;

