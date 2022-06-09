CREATE TABLE department (
DEPTID NUMBER(10) PRIMARY KEY,
DEPTNAME VARCHAR2(10),
LOCATION VARCHAR2(10),
TEL VARCHAR2(15));

CREATE TABLE employee (
EMPID NUMBER(10) PRIMARY KEY,
EMPNAME VARCHAR2(10),
HIREDATE DATE,
ADDR VARCHAR2(12),
TEL VARCHAR2(15),
DEPTID NUMBER(10));

--7
ALTER TABLE employee ADD birthday DATE;

--8
INSERT INTO department
VALUES (1001, 'ÃÑ¹«ÆÀ', 'º»101È£', '053-777-8777');
INSERT INTO department
VALUES (1002, 'È¸°èÆÀ', 'º»102È£', '053-888-9999');
INSERT INTO department
VALUES (1003, '¿µ¾÷ÆÀ', 'º»103È£', '053-222-3333');

INSERT INTO employee
VALUES(20121945, '¹Ú¹Î¼ö', to_date('20120302', 'RRRRMMDD'), '´ë±¸', '010-1111-1234', '1001', null);
INSERT INTO employee
VALUES(20101817, '¹ÚÁØ½Ä', '20100301', '°æ»ê', '010-2222-1234', '1003', null);
INSERT INTO employee
VALUES(20122245, '¼±¾Æ¶ó', '20120302', '´ë±¸', '010-3333-1222', '1002', null);
INSERT INTO employee
VALUES(20121729, 'ÀÌ¹ü¼ö', '20110302', '¼­¿ï', '010-3333-4444', '1001', null);
INSERT INTO employee
VALUES(20121646, 'ÀÌÀ¶Èñ', '20120901', 'ºÎ»ê', '010-1234-2222', '1003', null);

--9
ALTER TABLE employee MODIFY empname NOT NULL;

--10
SELECT e.empname, e.hiredate, d.deptname
FROM department d, employee e
WHERE d.deptid = e.deptid AND d.deptname = 'ÃÑ¹«ÆÀ';

SELECT e.empname, e.hiredate, d.deptname
FROM employee e JOIN department d ON e.deptid = d.deptid
WHERE d.deptname = 'ÃÑ¹«ÆÀ';

--11
DELETE FROM employee WHERE ADDR = '´ë±¸';

--12
UPDATE employee
SET deptid = 1002
WHERE deptid = 1003;
-->
UPDATE employee
SET deptid = (SELECT deptid FROM department WHERE deptname = 'È¸°èÆÀ')
WHERE deptid = (SELECT deptid FROM department WHERE deptname = '¿µ¾÷ÆÀ');

--13
SELECT e.empid, e.empname, e.birthday, d.deptname
FROM employee e, department d
WHERE e.deptid = d.deptid AND e.hiredate > (select hiredate from employee where empid = 20121729);

SELECT e.empid, e.empname, e.birthday, d.deptname
FROM employee e JOIN department d ON e.deptid = d.deptid
WHERE e.hiredate > (select hiredate from employee where empid = 20121729);

--14
CREATE VIEW chongmu
AS
SELECT e.empname, e.addr, d.deptname
FROM department d, employee e
WHERE  d.deptid = e.deptid AND e.deptid = '1001';


--1
SELECT * FROM employees
WHERE hire_date >= TO_DATE('02/01/01', 'RR/MM/DD') AND job_id = 'ST_CLERK';

--2
SELECT first_name, job_id, salary, commission_pct FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY salary DESC;

--3
SELECT 'The salary of '||last_name||' after a 10% raise is '||ROUND(salary+salary*0.1, -2) AS "New salary"
FROM employees
WHERE commission_pct IS NULL;

--4
SELECT last_name, 
          trunc(months_between(TO_DATE(sysdate, 'RR/MM/DD'), TO_DATE(hire_date, 'RR/MM/DD')) /12) AS years, 
        trunc(mod(months_between(TO_DATE(sysdate, 'RR/MM/DD'), TO_DATE(hire_date, 'RR/MM/DD')) /12,1) *12) AS months
FROM employees;

--5
SELECT last_name FROM employees
WHERE SUBSTR(last_name, 0, 1) IN ('J', 'K', 'L', 'M');

--6
SELECT last_name, salary, NVL2(commission_pct, 'Yes', 'No') AS com 
FROM employees;

--7
SELECT d.department_name, d.location_id, e.last_name, e.job_id, e.salary 
FROM departments d, employees e
WHERE d.department_id = e.department_id 
AND d.location_id = 1800;

--8
SELECT COUNT(*) FROM employees where first_name LIKE '%n';

--9
SELECT e.department_id, d.department_name, d.location_id, COUNT(e.employee_id)
FROM employees e, departments d 
WHERE e.department_id = d.department_id
GROUP BY e.department_id, d.department_name, d.location_id;

--10
SELECT job_id FROM employees
WHERE department_id IN (10, 20);

--11
SELECT job_id, COUNT(*) AS "frequency"
FROM employees
WHERE department_id IN (select department_id from departments 
                                  where department_name='Administration' 
                                  OR department_name='Executive')
GROUP BY job_id;

--12
SELECT last_name, hire_date FROM employees;


desc employees;
select * from departments;