-- Chinook SQL Lab for Travis Williamson - 7-8-19

-- 2 : SQL Queries

-- 2.1 SELECT

-- Task - Select all records from the Employee table.

SELECT * FROM EMPLOYEE; -- Done, Worked
/

-- Task - Select all records from Employee table where last name is King.

SELECT * FROM EMPLOYEE
WHERE EMPLOYEE.LASTNAME = 'King'; -- Done, Worked
/

-- Task - Select all records from Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM EMPLOYEE
WHERE EMPLOYEE.FIRSTNAME = 'Andrew'
AND EMPLOYEE.REPORTSTO IS NULL; -- Done, Worked
/

-- 2.2 ORDER BY

-- Task - Select all albums in Album table and sort result set in descending order by title

SELECT * FROM ALBUM
ORDER BY TITLE DESC; -- Done, Worked
/

-- Task - Select first name from Customer and sort result set in ascending order by city

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC; -- Done, Worked
/

-- 2.3 INSERT INTO

-- Task - Insert two new records into Genre table

INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Experimental');
/

INSERT INTO GENRE (GENREID, NAME)
VALUES (27, 'Smooth Jazz'); -- Done, Worked
/

-- Task - Insert two new records into Employee table

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Smith', 'Bob', 'IT Staff', 6, '05-JUN-75', '06-NOV-05', '345 42 Ave', 'Calgary', 'AB', 'Canada', 'T3B 1Y7', '1 (780) 346-9584', '1 (780) 346-7394', 'bob@chinookcorp.com');
/

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'James', 'Kevin', 'Sales Support Agent', 2, '17-JAN-80', '06-NOV-05', '2222 6 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 5M5', '1 (403) 102-3454', '1 (403) 102-3455', 'kevin@chinookcorp.com');
/ -- Done, Worked

-- Task - Insert two new records into Customer table

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Bruce', 'Beans', 'Amazon', '628 Broadway', 'New York', 'NY', 'USA', '10012-2612', '+1 (212) 555-5555', '+1 (212) 555-5556', 'bbeans@amazon.com', 5);
/

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Biggie', 'Smalls', NULL, '35 Linden St', 'Brooklyn', 'NY', 'USA', '11221', '+1 (212) 849-0666', NULL, 'therealbiggiesmalls@aol.com', 3);
/ -- Done, Worked

-- 2.4 UPDATE

-- Task - Update Aaron Mitchell in Customer table to Robert Walter

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;
/ -- Done, Worked

-- Task - Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/ -- Done, Worked

-- 2.5 LIKE

-- Task - Select all invoices with a billing address like "T%"

SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/ -- Done, Worked

-- 2.6 BETWEEN

-- Task - Select all invoices that have a total between 15 and 50

SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
/ -- Done, Worked

-- Task - Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';
/ -- Done, Worked

-- 2.7 DELETE

-- Task - Delete a record in Customer table where the name is Robert Walter
-- (There may be constraints that rely on this, find out how to resolve them)

-- Note:
--      Couldn't delete the Customer record initially because there were invoice records that referenced
--      the customer by CustomerID.
--      Couldn't delete those invoices initially because there were invoiceline records that referenced
--      those invoices by InvoiceID
--      Once I deleted those invoiceline records one by one, then I was able to delete the invoice records,
--      then finally I was able to delete the Customer record.
--      I'm not sure if there's a safer or more efficient approach to accomplishing this, but it seemed
--      to work for now.

DELETE FROM INVOICELINE
WHERE INVOICEID = 342;
/

DELETE FROM INVOICELINE
WHERE INVOICEID = 50;
/

DELETE FROM INVOICELINE
WHERE INVOICEID = 61;
/

DELETE FROM INVOICELINE
WHERE INVOICEID = 116;
/

DELETE FROM INVOICELINE
WHERE INVOICEID = 245;
/

DELETE FROM INVOICELINE
WHERE INVOICEID = 268;
/

DELETE FROM INVOICELINE
WHERE INVOICEID = 290;
/

DELETE FROM INVOICE
WHERE CUSTOMERID = 32;
/

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/

-- 3 : SQL Functions

-- 3.1 System Defined Functions

-- Task - Create a function that returns the current time

SELECT CURRENT_TIMESTAMP
FROM DUAL;
/

-- Below, I tried to make my own function that impemented the built-in function
-- It compiled, but I wasn't able to get it to execute correctly.

/*
CREATE OR REPLACE FUNCTION RETURN_CURRENT_TIME
RETURN TIMESTAMP
IS
    CURRENT_TIME TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO CURRENT_TIME
    FROM DUAL;
RETURN CURRENT_TIME;
END;
/
*/

-- Task - Create a function that returns the length of name in MEDIATYPE table

SELECT LENGTH(NAME) FROM MEDIATYPE;
/

-- Below, I tried to make my own function that impemented the built-in function
-- It compiled, but I wasn't able to get it to execute correctly.

/*
CREATE OR REPLACE FUNCTION RETURN_MEDIATYPE_NAME_LENGTH
RETURN NUMBER
IS
    NAME_LENGTH NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO NAME_LENGTH 
    FROM MEDIATYPE;
RETURN NAME_LENGTH;
END;
/


CALL RETURN_MEDIATYPE_NAME_LENGTH;
/
*/

-- 3.2 System Defined Aggregate Functions

-- Task - Create a function that returns the average total of all invoices

SELECT AVG (ALL TOTAL)
FROM INVOICE;
/

-- Task - Create a function that returns the most expensive track

SELECT MAX (ALL UNITPRICE)
FROM TRACK;
/

-- 3.3 User Defined Scalar Functions

-- Task - Create a function that returns the average price of invoiceline items in the invoiceline table

SELECT AVG (ALL UNITPRICE)
FROM INVOICELINE;
/

-- 3.4. User Defined Table Valued Functions

-- Task - Create a function that returns all employees who are born after 1968

SELECT * FROM EMPLOYEE
WHERE BIRTHDATE > '31_DEC_68';
/

-- 4 : Stored Procedures

-- 4.1 Basic Stored Procedure

-- Task - Create a stored procedure that selects the first and last names of all the employees

CREATE OR REPLACE PROCEDURE FIRST_LAST_NAMES_EMPLOYEES
AS
    V_FIRST_NAME VARCHAR2(500);
    V_LAST_NAME VARCHAR2(500);
    CURSOR C_FIRSTLASTNAMES IS
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
BEGIN
    OPEN C_FIRSTLASTNAMES;
    LOOP
    FETCH C_FIRSTLASTNAMES INTO V_FIRST_NAME, V_LAST_NAME;
        EXIT WHEN C_FIRSTLASTNAMES%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_FIRST_NAME || ' ' || V_LAST_NAME);
    END LOOP;
    CLOSE C_FIRSTLASTNAMES;
END;
/

--TEST EXECUTION:
--EXEC FIRST_LAST_NAMES_EMPLOYEES;
--/

-- 4.2 Stored Procedure Input Parameters

-- Task - Create a stored procedure that updates the personal information of an employee

CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO(
    P_LASTNAME IN EMPLOYEE.LASTNAME%TYPE,
    P_FIRSTNAME IN EMPLOYEE.FIRSTNAME%TYPE,
    P_TITLE IN EMPLOYEE.TITLE%TYPE,
    P_REPORTSTO IN EMPLOYEE.REPORTSTO%TYPE,
    P_BIRTHDATE IN EMPLOYEE.BIRTHDATE%TYPE,
    P_HIREDATE IN EMPLOYEE.HIREDATE%TYPE,
    P_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    P_CITY IN EMPLOYEE.CITY%TYPE,
    P_STATE IN EMPLOYEE.STATE%TYPE,
    P_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    P_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
    P_PHONE IN EMPLOYEE.PHONE%TYPE,
    P_FAX IN EMPLOYEE.FAX%TYPE,
    P_EMAIL IN EMPLOYEE.EMAIL%TYPE
)
IS
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = P_LASTNAME;
    UPDATE EMPLOYEE SET FIRSTNAME = P_FIRSTNAME;
    UPDATE EMPLOYEE SET TITLE = P_TITLE;
    UPDATE EMPLOYEE SET REPORTSTO = P_REPORTSTO;
    UPDATE EMPLOYEE SET BIRTHDATE = P_BIRTHDATE;
    UPDATE EMPLOYEE SET HIREDATE = P_HIREDATE;
    UPDATE EMPLOYEE SET ADDRESS = P_ADDRESS;
    UPDATE EMPLOYEE SET CITY = P_CITY;
    UPDATE EMPLOYEE SET STATE = P_STATE;
    UPDATE EMPLOYEE SET COUNTRY = P_COUNTRY;
    UPDATE EMPLOYEE SET POSTALCODE = P_POSTALCODE;
    UPDATE EMPLOYEE SET PHONE = P_PHONE;
    UPDATE EMPLOYEE SET FAX = P_FAX;
    UPDATE EMPLOYEE SET EMAIL = P_EMAIL;
END;
/

-- Task - Create a stored procedure that returns the managers of an employee

CREATE OR REPLACE PROCEDURE GET_MANAGER(
    P_EMPLOYEE_ID NUMBER
)
AS
    V_EMPLOYEE_FIRST_NAME VARCHAR2(500);
    V_EMPLOYEE_LAST_NAME VARCHAR2(500);
    V_MANAGERID NUMBER;
    V_MANAGER_FIRST_NAME VARCHAR2(500);
    V_MANAGER_LAST_NAME VARCHAR2(500);
    CURSOR C_EMPLOYEEINFO IS
        SELECT FIRSTNAME, LASTNAME, REPORTSTO
        INTO V_EMPLOYEE_FIRST_NAME, V_EMPLOYEE_LAST_NAME, V_MANAGERID
        FROM EMPLOYEE
        WHERE EMPLOYEEID = P_EMPLOYEE_ID;
    CURSOR C_MANAGERINFO IS
        SELECT FIRSTNAME, LASTNAME
        INTO V_MANAGER_FIRST_NAME, V_MANAGER_LAST_NAME
        FROM EMPLOYEE
        WHERE EMPLOYEEID = V_MANAGERID;
BEGIN
    OPEN C_EMPLOYEEINFO;
    LOOP
    FETCH C_EMPLOYEEINFO INTO V_EMPLOYEE_FIRST_NAME, V_EMPLOYEE_LAST_NAME, V_MANAGERID;
        EXIT WHEN C_EMPLOYEEINFO%NOTFOUND;
    END LOOP;
    CLOSE C_EMPLOYEEINFO;
    OPEN C_MANAGERINFO;
    LOOP
    FETCH C_MANAGERINFO INTO V_MANAGER_FIRST_NAME, V_MANAGER_LAST_NAME;
        EXIT WHEN C_MANAGERINFO%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_MANAGER_FIRST_NAME || ' ' || V_MANAGER_LAST_NAME || ' MANAGES ' || V_EMPLOYEE_FIRST_NAME || ' ' || V_EMPLOYEE_LAST_NAME);
    END LOOP;
    CLOSE C_MANAGERINFO;
END;
/

--TEST EXECUTION
--EXEC GET_MANAGER(3);
--/

-- 4.3 Stored Procedure Output Parameters

-- Task - Create a stored procedure that returns the name and company of a customer

CREATE OR REPLACE PROCEDURE GET_CUSTOMER_NAME_AND_COMPANY (
    P_CUSTOMER_ID IN NUMBER,
    P_CUSTOMER_FIRST_NAME OUT VARCHAR2,
    P_CUSTOMER_LAST_NAME OUT VARCHAR2,
    P_CUSTOMER_COMPANY OUT VARCHAR2
)
AS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO P_CUSTOMER_FIRST_NAME, P_CUSTOMER_LAST_NAME, P_CUSTOMER_COMPANY
    FROM CUSTOMER
    WHERE CUSTOMERID = P_CUSTOMER_ID;
END;
/

--TEST EXECUTION:
/*
DECLARE
    P_CUSTOMER_FIRST_NAME VARCHAR2(40 BYTE);
    P_CUSTOMER_LAST_NAME VARCHAR2(20 BYTE);
    P_CUSTOMER_COMPANY VARCHAR2(80 BYTE);
BEGIN
    GET_CUSTOMER_NAME_AND_COMPANY (5, P_CUSTOMER_FIRST_NAME, P_CUSTOMER_LAST_NAME, P_CUSTOMER_COMPANY);
    DBMS_OUTPUT.PUT_LINE('NAME: ' || P_CUSTOMER_FIRST_NAME || ' ' || P_CUSTOMER_LAST_NAME || ', COMPANY: ' || P_CUSTOMER_COMPANY);
END;
/
*/

-- 5 : Transactions

-- Task - Create a transaction that given a invoiceId will delete that invoice
-- (There may be constraints that rely on this, find out how to resolve them)

CREATE OR REPLACE PROCEDURE DELETE_INVOICE(
    P_INVOICE_ID NUMBER
)
AS
BEGIN
    DELETE FROM INVOICELINE
    WHERE INVOICEID = P_INVOICE_ID;
    DELETE FROM INVOICE
    WHERE INVOICEID = P_INVOICE_ID;
END;
/

--TEST EXECUTION:
--EXEC DELETE_INVOICE(324);
--/

-- 6 : Triggers

-- 6.1 AFTER/FOR

-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table

CREATE OR REPLACE TRIGGER NEW_EMPLOYEE_TRIGGER
AFTER INSERT
ON
EMPLOYEE
FOR EACH ROW
BEGIN
   DBMS_OUTPUT.PUT_LINE('A new employee record was inserted into the database'); 
END;
/

-- Task - Create an after update trigger on the album that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER UPDATED_ALBUM_TRIGGER
AFTER UPDATE
ON
ALBUM
FOR EACH ROW
BEGIN
   DBMS_OUTPUT.PUT_LINE('An album in the database was just updated'); 
END;
/

-- Task - Create an after delete trigger on the customer table that fires after a row is deleted from the table

CREATE OR REPLACE TRIGGER DELETED_CUSTOMER_TRIGGER
AFTER DELETE
ON
CUSTOMER
FOR EACH ROW
BEGIN
   DBMS_OUTPUT.PUT_LINE('A customer record in the database was just deleted'); 
END;
/

-- 7 : JOINS

-- 7.1 INNER

-- Task - Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId

SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM INVOICE
INNER JOIN CUSTOMER ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;
/

-- 7.2 OUTER

-- Task - Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname,
-- lastname, invoiceId, and total

SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
/

-- 7.3 RIGHT

-- Task - Create a right join that joins album and artist specifying artist name and title

SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;
/

-- 7.4 CROSS

-- Task - Create a cross join that joins album and artist and sorts by artist name in ascending order

SELECT * FROM ARTIST
CROSS JOIN ALBUM
ORDER BY ARTIST.NAME ASC;
/

-- 7.5 SELF

-- Task - Perform a self-join on the employee table, joining on the reportsto column

SELECT A.FIRSTNAME || ' ' || A.LASTNAME || ' WORKS FOR ' || B.FIRSTNAME || ' ' || B.LASTNAME
"EMPLOYEES AND THEIR MANAGERS"
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;
/