SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_emp_cursor(v_department_id employees.employee_id%TYPE) IS
        SELECT e.employee_id, e.last_name, d.department_name
        FROM employees e JOIN departments d ON e.department_id = d.department_id
        WHERE e.department_id = v_department_id;
BEGIN
    FOR v_emp_record IN c_emp_cursor(&v_department_id) LOOP
        DBMS_OUTPUT.PUT_LINE(v_emp_record.employee_id||', '||v_emp_record.last_name||', '||v_emp_record.department_name);
    END LOOP;
END;
/

DECLARE
    CURSOR c_emp_cursor(v_department_id employees.employee_id%TYPE) IS
        SELECT e.employee_id, e.last_name, d.department_name
        FROM employees e JOIN departments d ON e.department_id = d.department_id
        WHERE e.department_id = v_department_id;
    v_emp_record c_emp_cursor%ROWTYPE;
BEGIN
    OPEN c_emp_cursor(&v_department_id);
    LOOP
        FETCH c_emp_cursor INTO v_emp_record;
        EXIT WHEN c_emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_emp_record.employee_id||', '||v_emp_record.last_name||', '||v_emp_record.department_name);
    END LOOP;
    CLOSE c_emp_cursor;
END;
/

DECLARE
    CURSOR c_emp_cursor IS
        SELECT employee_id, last_name, hire_date FROM employees;
BEGIN
    FOR v_emp_record IN c_emp_cursor LOOP
        IF TO_CHAR(v_emp_record.hire_date, 'RRRR') <= 2000 THEN
            INSERT INTO test01 VALUES v_emp_record;
        ELSE
            INSERT INTO test02 VALUES v_emp_record;
        END IF;
    END LOOP;
END;
/

DECLARE
    CURSOR c_emp_cursor IS
        SELECT employee_id, last_name, hire_date FROM employees;
    v_emp_record c_emp_cursor%ROWTYPE;
BEGIN  
    OPEN c_emp_cursor;
    LOOP
        FETCH c_emp_cursor INTO v_emp_record;
        EXIT WHEN c_emp_cursor%NOTFOUND;
        IF TO_CHAR(v_emp_record.hire_date, 'RRRR') <= 2000 THEN
            INSERT INTO test01 VALUES v_emp_record;
        ELSE
            INSERT INTO test02 VALUES v_emp_record;
        END IF;
    END LOOP;
END;
/

delete from test02;
select * from test02;

--------------------------------------------------------------PL/SQL EXCEPTION

DECLARE
    e_insert_excep EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_insert_excep, -01400);
BEGIN
    INSERT INTO departments(department_id, department_name)
    VALUES (280, NULL);
EXCEPTION
    WHEN e_insert_excep THEN
    DBMS_OUTPUT.PUT_LINE('insert operation failed');
    DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

DECLARE
    v_name VARCHAR2(20) := 'Testing';
    e_invalid_department EXCEPTION;
BEGIN
    UPDATE departments
    SET department_name = v_name
    WHERE department_id = &id;
    IF SQL%NOTFOUND THEN
        RAISE e_invalid_department;
    END IF;
EXCEPTION
WHEN e_invalid_department THEN
    DBMS_OUTPUT.PUT_LINE('No such department id.');
END;
/

DECLARE
    e_name EXCEPTION;
BEGIN
    DELETE FROM employees
    WHERE employee_id = '&id';
    IF SQL%NOTFOUND THEN
        RAISE e_name;
    END IF;
EXCEPTION
    WHEN e_name THEN
        RAISE_APPLICATION_ERROR (-20999, '해당 사원이 없습니다.');
        DBMS_OUTPUT.PUT_LINE('해당 사원이 없습니다.');
END;
/
-- 위와 동일하지만 예외 전달이라서 제대로 끝나지 않는다.
DECLARE
    e_name EXCEPTION;
BEGIN
    DELETE FROM employees
    WHERE employee_id = '&id';
    IF SQL%NOTFOUND THEN
         RAISE_APPLICATION_ERROR (-20999, '해당 사원이 없습니다.');
    END IF;

END;
/

drop table emp_test;

create table emp_test
as
  select employee_id, last_name
  from   employees
  where  employee_id < 200;
  
DECLARE
    e_name EXCEPTION;
BEGIN
    DELETE FROM emp_test
    WHERE employee_id = '&id';
    IF SQL%NOTFOUND THEN
        RAISE e_name;
    END IF;
EXCEPTION
    WHEN e_name THEN
        RAISE_APPLICATION_ERROR(-20999, '해당 사원이 없습니다.');
END;
/

DECLARE
    e_salary EXCEPTION;
    v_employee_id employees.employee_id%TYPE;
    v_hire_date employees.hire_date%TYPE;
BEGIN

    SELECT hire_date INTO v_hire_date FROM employees
    WHERE employee_id = '&id';
    
    IF TO_CHAR(v_hire_date, 'RRRR') >= 2000 THEN
        RAISE e_salary;
    ELSE
        UPDATE employees
        SET salary = salary*1.1
        WHERE employee_id = v_employee_id;
    END IF;
    
EXCEPTION
    WHEN e_salary THEN
        RAISE_APPLICATION_ERROR(-20999, '2000년 이후 입사한 사원입니다.');
END;
/

DECLARE
    e_salary EXCEPTION;
    e_employee EXCEPTION;
    CURSOR c_emp_cursor(v_dapartment_id departments.department_id%TYPE) IS
        SELECT employee_id, hire_date FROM employees
        WHERE department_id = v_dapartment_id
        ORDER BY hire_date;
    v_check BOOLEAN := false;
BEGIN

    FOR v_emp_record IN c_emp_cursor(&v_dapartment_id) LOOP
        IF TO_CHAR(v_emp_record.hire_date, 'RRRR') >= 2000 THEN
            RAISE e_salary;
        ELSE
            UPDATE employees
            SET salary = salary*1.1
            WHERE department_id = v_emp_record.employee_id;
            v_check := true;
        END IF;
    END LOOP;
    
    IF NOT v_check THEN
        RAISE e_employee;
    END IF;

EXCEPTION
    WHEN e_employee THEN
        DBMS_OUTPUT.PUT_LINE('해당 부서에는 사원이 없습니다.');
    WHEN e_salary THEN
        DBMS_OUTPUT.PUT_LINE('2000년 이후 입사한 사원은 갱신되지 않습니다.');
END;
/

DECLARE
    e_salary EXCEPTION;
    e_employee EXCEPTION;
    CURSOR c_emp_cursor(v_dapartment_id departments.department_id%TYPE) IS
        SELECT employee_id, hire_date FROM employees
        WHERE department_id = v_dapartment_id
        ORDER BY hire_date;
    v_emp_record c_emp_cursor%ROWTYPE;
    
BEGIN
    OPEN c_emp_cursor(&v_dapartment_id);
    LOOP
        FETCH c_emp_cursor INTO v_emp_record;
        IF c_emp_cursor%NOTFOUND THEN
            RAISE e_employee;
        END IF;
        EXIT WHEN c_emp_cursor%NOTFOUND;
        
        IF TO_CHAR(v_emp_record.hire_date, 'RRRR') >= 2000 THEN
            RAISE e_salary;
        ELSE
            UPDATE employees
            SET salary = salary*1.1
            WHERE employee_id = v_emp_record.employee_id;
        END IF;
    END LOOP;
    CLOSE c_emp_cursor;
    
EXCEPTION
    WHEN e_employee THEN
        DBMS_OUTPUT.PUT_LINE('해당 부서에는 사원이 없습니다.');
     WHEN e_salary THEN
        DBMS_OUTPUT.PUT_LINE('2000년 이후 입사한 사원은 갱신되지 않습니다.');
END;
/

select * from employees;
SELECT * FROM employees where department_id=90;


--------------------------------------------------------------PL/SQL PROCEDURE

--프로시저 생성
CREATE OR REPLACE PROCEDURE raise_salary
    (p_id IN employees.employee_id%TYPE,
     p_percent IN NUMBER)
IS
BEGIN
    UPDATE employees
    SET salary = salary * (1+p_percent/100)
    WHERE employee_id = p_id;
END raise_salary;
/

--프로시저 호출
EXECUTE raise_salary(176, 10);
BEGIN
    raise_salary(176, 10);
END;
/
SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=176;


-- 프로시저 실습
-- 아이디로 사원 검색
CREATE PROCEDURE test_pro
    (p_id IN employees.employee_id%TYPE)
IS
    e_no_emp EXCEPTION;
BEGIN
    DELETE FROM employees
    WHERE employee_id = p_id;
    
    IF SQL%NOTFOUND THEN
        RAISE e_no_emp;
    END IF;
EXCEPTION
    WHEN e_no_emp THEN
        DBMS_OUTPUT.PUT_LINE('해당 사원이 없습니다.');
END test_pro;
/
BEGIN
    test_pro(0);
END;
/

-- 주민등록번호 포매팅
CREATE OR REPLACE PROCEDURE yedam_ju
    (p_id NUMBER)
IS
    v_id VARCHAR2(20);
BEGIN
    v_id := SUBSTR(p_id, 1, 6) ||'-'||
                SUBSTR(p_id, 7, 1) ||'******';
    DBMS_OUTPUT.PUT_LINE(v_id);
END;
/
BEGIN
    yedam_ju(9511011234567);
END;
/

-- 사원 정보 가져오기 (IN)
CREATE OR REPLACE PROCEDURE getEmployeeInfo
    (v_empno IN employees.employee_id%TYPE)
IS
    v_emp_rec employees%ROWTYPE;
BEGIN
    SELECT *
    INTO v_emp_rec
    FROM employees
    WHERE employee_id = v_empno;
    DBMS_OUTPUT.PUT_LINE(v_emp_rec.last_name ||' '|| v_emp_rec.job_id);
END getEmployeeInfo;
/
BEGIN
getEmployeeInfo(100);
END;
/

-- 사원 정보 가져오기(IN, OUT)
CREATE OR REPLACE PROCEDURE query_emp
    (v_id IN employees.employee_id%TYPE,
    v_name OUT employees.last_name%TYPE,
    v_salary OUT employees.salary%TYPE,
    v_comm OUT employees.commission_pct%TYPE)
IS
BEGIN
    SELECT last_name, salary, commission_pct
    INTO v_name, v_salary, v_comm
    FROM employees
    WHERE employee_id = v_id;
END query_emp;
/

VARIABLE g_emp_name VARCHAR2;
VARIABLE g_emp_salary NUMBER;
VARIABLE g_emp_comm NUMBER;
EXECUTE query_emp(200, :g_emp_name, :g_emp_salary, :g_emp_comm);
PRINT g_emp_name;
PRINT g_emp_salary;
PRINT g_emp_comm;

-- 전화번호 포매팅(IN OUT)
CREATE OR REPLACE PROCEDURE format_phone
 (v_phone_no IN OUT varchar2)
IS
BEGIN
        v_phone_no :='(' || SUBSTR(v_phone_no,1,3)||
                            ')'|| SUBSTR(v_phone_no,4,3)||
                            '-'||SUBSTR(v_phone_no,7);
END format_phone;
/

VARIABLE g_phone_no varchar2;

EXEC :g_phone_no := '0539419775';
PRINT g_phone_no;
EXECUTE format_phone(:g_phone_no);
PRINT g_phone_no;

-- 이름 포매팅 ex) s****
CREATE OR REPLACE PROCEDURE yedam_emp
    (v_name IN varchar2,
    v_hide_name OUT varchar2)
IS
    v_counter number := 1;
BEGIN
    v_hide_name := SUBSTR(v_name, 1, 1);
    WHILE v_counter < LENGTH(v_name) LOOP
        v_hide_name := v_hide_name||'*';
        v_counter := v_counter + 1;
    END LOOP;
END yedam_emp;
/
VARIABLE v_name varchar2;
EXECUTE yedam_emp('subin', :v_name);
PRINT v_name;

-- 이름 포매팅 FOR IN
CREATE OR REPLACE PROCEDURE yedam_emp2
    (v_id IN number, v_result OUT VARCHAR2)
IS
    v_name VARCHAR2(20);
BEGIN
    SELECT last_name INTO v_name
    FROM employees WHERE employee_id = v_id;
    
    FOR i IN 1..LENGTH(v_name) LOOP
        IF i = 1 THEN
            v_result := SUBSTR(v_name, 1, 1);
            continue;
        ELSE 
            v_result := v_result || '*';
        END IF;
    END LOOP;
END yedam_emp2;
/
VARIABLE g_result varchar2;
EXECUTE yedam_emp2(100, :g_result);
PRINT g_result;

-- 이름 포매팅 RPAD
CREATE OR REPLACE PROCEDURE yedam_emp3
    (v_id IN number, v_hide_name OUT VARCHAR2)
IS
BEGIN
    SELECT RPAD(SUBSTR(last_name, 1, 1), LENGTH(last_name), '*') INTO v_hide_name
    FROM employees WHERE employee_id = v_id;
END yedam_emp2;
/
VARIABLE g_hide_name varchar2;
EXECUTE yedam_emp3(200, :g_hide_name);
PRINT g_hide_name;


-- 부서 번호로 사원 정보 가져오기
CREATE OR REPLACE PROCEDURE get_emp
    (v_department_id IN departments.department_id%TYPE)
IS
    CURSOR c_emp_cursor IS
        SELECT employee_id, last_name FROM employees
        WHERE department_id = v_department_id;
    v_emp_record c_emp_cursor%ROWTYPE;
    e_no_emp EXCEPTION;
BEGIN
    OPEN c_emp_cursor;
    LOOP
        FETCH c_emp_cursor INTO v_emp_record;
        IF c_emp_cursor%ROWCOUNT = 0 THEN
            RAISE e_no_emp;
        END IF;
        EXIT WHEN c_emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_emp_record.employee_id||', '||v_emp_record.last_name);
    END LOOP;
    CLOSE c_emp_cursor;
EXCEPTION
    WHEN e_no_emp THEN
        DBMS_OUTPUT.PUT_LINE('해당 부서에는 사원이 없습니다.');
END get_emp;
/
BEGIN
    get_emp(0);
END;
/


--------------------------------------------------------------PL/SQL FUNCTION

CREATE OR REPLACE FUNCTION get_annl
    (v_employee_id IN employees.employee_id%TYPE)
    -- 반드시 리턴구문 넣기!
    RETURN NUMBER
IS
    v_annl employees.employee_id%TYPE;
BEGIN
    SELECT salary*12 INTO v_annl 
    FROM employees WHERE employee_id = v_employee_id;
    
    RETURN v_annl;
END get_annl;
/
VARIABLE g_annl NUMBER;
EXECUTE :g_annl := get_annl(100);
PRINT g_annl;  

CREATE FUNCTION check_sal RETURN Boolean IS
    v_dept_id employees.department_id%TYPE;
    v_empno employees.employee_id%TYPE;
    v_sal employees.salary%TYPE;
    v_avg_sal employees.salary%TYPE;
BEGIN
    v_empno:=205;
    SELECT salary,department_id INTO v_sal,v_dept_id FROM 
    employees
    WHERE employee_id= v_empno;
    SELECT avg(salary) INTO v_avg_sal 
    FROM employees 
    WHERE department_id=v_dept_id;
    IF v_sal > v_avg_sal THEN
    RETURN TRUE;
    ELSE
    RETURN FALSE; 
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    RETURN NULL;
END;
/

BEGIN
    IF (check_sal IS NULL) THEN
        DBMS_OUTPUT.PUT_LINE('The function returned NULL due to exception');
    ELSIF (check_sal) THEN 
        DBMS_OUTPUT.PUT_LINE('Salary > average');
    ELSE
    DBMS_OUTPUT.PUT_LINE('Salary < average');
    END IF;
END;
/