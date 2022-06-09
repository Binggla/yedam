-- DBMS_OUTPUT.PUT_LINE : 내용 출력. SET SERVEROUTPUT ON; 해주기!
SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO, WORLD!');
END;
/

DECLARE
    v_sal NUMBER(7,2) := 60000;
    v_comm NUMBER(7,2) := v_sal * .20;
    v_message VARCHAR2(255):= 'eligible for commission';
BEGIN
    DECLARE
    v_sal NUMBER(7,2) := 50000;
    v_comm NUMBER(7,2) := 0;
    v_total_comp NUMBER(7,2) := v_sal + v_comm;
    BEGIN
        v_message := ' CLERK not '||v_message;
        DBMS_OUTPUT.PUT_LINE('LOCAL' || v_message);
        v_comm := v_sal * .30;
        DBMS_OUTPUT.PUT_LINE('LOCAL v_comm : ' || v_comm);
        DBMS_OUTPUT.PUT_LINE('LOCAL v_total_comp : ' ||  v_total_comp);
    END;
v_message := 'SALESMAN'||v_message;
DBMS_OUTPUT.PUT_LINE('OUTTER : '|| v_message);
END;
/

DECLARE
    v_sum_sal employees.salary%TYPE;
    v_department_id NUMBER NOT NULL := 10;
    BEGIN
        SELECT SUM(salary) -- 그룹 함수
        INTO v_sum_sal
        FROM employees
        WHERE department_id = v_department_id;
        
        DBMS_OUTPUT.PUT_LINE('total_salary : '||v_sum_sal);
    END;
/

BEGIN
    INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES(employees_seq.NEXTVAL, 'Ruth', 'Cores', 'RCORES', CURRENT_DATE, 'AD_ASST', 4000);
END;
/

VARIABLE rows_deleted VARCHAR2(30);
DECLARE
    v_deptno NUMBER := 30;
    BEGIN
        DELETE FROM employees
        WHERE department_id = v_deptno;
        DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || 'rows deleted.');
    END;
/
PRINT rows_deleted;

--1
ACCEPT p_employee_id PROMPT 'Please enter the employee id : ';
DECLARE
    v_employee_id employees.employee_id%TYPE;
    v_last_name employees.last_name%TYPE;
    v_department_name departments.department_name%TYPE;
BEGIN
    SELECT e.employee_id, e.last_name, d.department_name
    INTO v_employee_id, v_last_name, v_department_name
    FROM employees e JOIN departments d
    ON e.department_id = d.department_id WHERE e.employee_id = &p_employee_id;
    
    DBMS_OUTPUT.PUT_LINE('employee_id : '||v_employee_id);
    DBMS_OUTPUT.PUT_LINE('last_name : '||v_last_name);
    DBMS_OUTPUT.PUT_LINE('department_name : '||v_department_name);
END;
/

--2
DECLARE
    v_last_name employees.last_name%TYPE;
    v_salary employees.salary%TYPE;
    v_total_salary employees.salary%TYPE;
BEGIN
    SELECT last_name, salary, (salary*12+(NVL(salary, 0)*NVL(commission_pct, 0)*12)) AS "total_salary"
    INTO v_last_name, v_salary, v_total_salary
    FROM employees
    WHERE employee_id = &p_employee_id;
    
    DBMS_OUTPUT.PUT_LINE('last name : '||v_last_name);
    DBMS_OUTPUT.PUT_LINE('salary : '||v_salary);
    DBMS_OUTPUT.PUT_LINE('total salary : '||v_total_salary);
END;
/