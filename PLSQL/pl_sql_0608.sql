SET SERVEROUTPUT ON;

--------------------------------------------------------------PL/SQL SELECT
DECLARE
    v_employee_id employees.employee_id%TYPE;
    v_last_name employees.last_name%TYPE;
    v_department_name departments.department_name%TYPE;
BEGIN
    SELECT e.employee_id, e.last_name, d.department_name
    INTO v_employee_id, v_last_name, v_department_name
    FROM employees e JOIN departments d
    ON (e.department_id = d.department_id) WHERE e.employee_id = &input_id;
    
    DBMS_OUTPUT.PUT_LINE('employee_id : '||v_employee_id);
    DBMS_OUTPUT.PUT_LINE('last_name : '||v_last_name);
    DBMS_OUTPUT.PUT_LINE('department_name : '||v_department_name);
END;
/

--------------------------------------------------------------PL/SQL INSERT
DECLARE
    v_employee_id employees.employee_id%TYPE := &input_id;
    v_last_name employees.last_name%TYPE;
    v_department_id employees.department_id%TYPE;
BEGIN

    SELECT last_name, department_id
    INTO v_last_name, v_department_id
    FROM employees
    WHERE employee_id = v_employee_id;
    
    DBMS_OUTPUT.PUT_LINE('employee_id : '||v_employee_id||'last_name : '||v_last_name||'department_id : '||v_department_id);
    
    INSERT INTO yedam01
    VALUES(v_employee_id, v_last_name, v_department_id);

END;
/

--BEGIN
--
--    INSERT INTO yedam01
--    SELECT employee_id, last_name, department_id
--    FROM employees
--    WHERE employee_id = &input_id;
--
--END;
--/

--------------------------------------------------------------PL/SQL UPDATE
DECLARE
    v_employee_id employees.employee_id%TYPE := &input_id;
BEGIN
    UPDATE employees
    SET salary = salary*1.1
    WHERE employee_id = v_employee_id;
END;
/

--------------------------------------------------------------PL/SQL IF
DECLARE
    v_myage number:=25;
BEGIN
    IF v_myage < 11 THEN
        DBMS_OUTPUT.PUT_LINE('I am a child');
    ELSIF v_myage < 20 THEN
        DBMS_OUTPUT.PUT_LINE('I am a young');
    ELSIF v_myage < 30 THEN
        DBMS_OUTPUT.PUT_LINE('I am in my twenties');
    ELSIF v_myage < 40 THEN
        DBMS_OUTPUT.PUT_LINE('I am in my thirties');
    ELSE
        DBMS_OUTPUT.PUT_LINE('I am always young');
    END IF;
END;
/

DECLARE
    v_employee_id employees.employee_id%TYPE:=&input_id;
    v_hire_date employees.hire_date%TYPE;
BEGIN
    SELECT hire_date 
    INTO v_hire_date
    FROM employees 
    WHERE employee_id=v_employee_id;
    
    IF TO_CHAR(v_hire_date, 'RRRR') >= '2000' THEN
        DBMS_OUTPUT.PUT_LINE('New employee');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('Career employee');
    END IF;
END;
/

DECLARE
    v_employee_id employees.employee_id%TYPE:=&input_id;
    v_hire_date employees.hire_date%TYPE;
    v_output VARCHAR2(20);
BEGIN
    SELECT hire_date 
    INTO v_hire_date
    FROM employees 
    WHERE employee_id=v_employee_id;
    
    IF TO_CHAR(v_hire_date, 'RRRR') >= '2000' THEN
        v_output := 'New employee';
    ELSE 
        v_output := 'Career employee';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(v_output);
    
END;
/

CREATE TABLE TEST02
AS
SELECT employee_id, last_name, hire_date
from employees
where employee_id = 0;

DECLARE
    v_employee_id employees.employee_id%TYPE;
    v_last_name employees.last_name%TYPE;
    v_hire_date employees.hire_date%TYPE;
BEGIN
    SELECT employee_id, last_name, hire_date 
    INTO v_employee_id, v_last_name, v_hire_date
    FROM employees 
    WHERE employee_id=&inputId;
    
    IF TO_CHAR(v_hire_date, 'RRRR') >= '2000' THEN
        INSERT INTO test01
        VALUES( v_employee_id, v_last_name, v_hire_date );
    ELSE 
        INSERT INTO test02
        VALUES( v_employee_id, v_last_name, v_hire_date );
    END IF;
END;
/

--------------------------------------------------------------PL/SQL LOOP
DECLARE
    v_countryid locations.country_id%TYPE := 'CA';
    v_loc_id locations.location_id%TYPE;
    v_counter NUMBER(2) := 1;
    v_new_city locations.city%TYPE := 'Montreal';
BEGIN
    SELECT MAX(location_id) INTO v_loc_id FROM locations
    WHERE country_id = v_countryid;
    LOOP
        INSERT INTO locations(location_id, city, country_id)
        VALUES ((v_loc_id + v_counter), v_new_city, v_countryid);
        v_counter := v_counter + 1;
        EXIT WHEN v_counter > 3;
    END LOOP;
END;
/

--------------------------------------------------------------PL/SQL WHILE
DECLARE
    v_countryid locations.country_id%TYPE := 'CA';
    v_loc_id locations.location_id%TYPE;
    v_counter NUMBER(2) := 1;
    v_new_city locations.city%TYPE := 'Montreal';
BEGIN
    SELECT MAX(location_id) INTO v_loc_id FROM locations
    WHERE country_id = v_countryid;
    WHILE v_counter <= 3 LOOP
        INSERT INTO locations(location_id, city, country_id)
        VALUES ((v_loc_id + v_counter), v_new_city, v_countryid);
        v_counter := v_counter + 1;
    END LOOP;
END;
/

--------------------------------------------------------------PL/SQL FOR
DECLARE
    v_countryid locations.country_id%TYPE := 'CA';
    v_loc_id locations.location_id%TYPE;
    v_new_city locations.city%TYPE := 'Montreal';
BEGIN
    SELECT MAX(location_id) INTO v_loc_id FROM locations
    WHERE country_id = v_countryid;
    FOR i IN 1..3 LOOP
        INSERT INTO locations(location_id, city, country_id)
        VALUES ((v_loc_id + i), v_new_city, v_countryid);
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..10 LOOP
        INSERT INTO aaa
        values(i);
    END LOOP;
END;
/

DECLARE
    v_sum number:=0;
BEGIN
    FOR i IN 1..10 LOOP
        v_sum := v_sum + i;
    END LOOP;
    INSERT INTO bbb
    values(v_sum);
END;
/

BEGIN
    FOR i IN 1..10 LOOP
        IF MOD(i, 2) = 0 THEN
            INSERT INTO aaa
            values(i);
        END IF;
    END LOOP;
END;
/

DECLARE
    v_sum number:=0;
BEGIN
    FOR i IN 1..10 LOOP
        IF MOD(i, 2) = 0 THEN
             v_sum := v_sum + i;
        END IF;
    END LOOP;
    
    INSERT INTO bbb
    values(v_sum);
    
END;
/

DECLARE
    v_even_sum number:=0;
    v_odd_sum number:=0;
BEGIN
    FOR i IN 1..10 LOOP
        IF MOD(i, 2) = 0 THEN
             v_even_sum := v_even_sum + i;
        ELSE 
            v_odd_sum := v_odd_sum + i;
        END IF;
    END LOOP;
    
    INSERT INTO aaa values(v_even_sum);
    INSERT INTO bbb values(v_odd_sum);
    
END;
/

BEGIN
    FOR i IN 1..5 LOOP
        FOR j IN 1..i LOOP
            DBMS_OUTPUT.PUT('*');
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

DECLARE
    v_input_num number:=&input_num;
BEGIN
    FOR i IN 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(v_input_num || ' * ' || i || ' = ' || v_input_num*i);
    END LOOP;
END;
/

BEGIN
    FOR i IN 2..9 LOOP
        FOR j IN 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(i || ' * ' || j || ' = ' || i*j);
        END LOOP;
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..9 LOOP
        IF MOD(i, 2) = 1 THEN
            FOR j IN 1..9 LOOP
                DBMS_OUTPUT.PUT_LINE(i || ' * ' || j || ' = ' || i*j);
            END LOOP;
        END IF;
    END LOOP;
END;
/


DECLARE
    v_birth_year CHAR(4);
    v_ddi VARCHAR2(10);
BEGIN
    v_birth_year := TO_CHAR(TO_DATE(&p_input_birthday, 'RRMMDD'), 'RRRR');

    IF MOD(v_birth_year,12) = 0 THEN v_ddi := '원숭이띠';
    ELSIF MOD(v_birth_year,12) = 1 THEN v_ddi := '닭띠';
    ELSIF MOD(v_birth_year,12) = 2 THEN v_ddi := '개띠';
    ELSIF MOD(v_birth_year,12) = 3 THEN v_ddi := '돼지띠';
    ELSIF MOD(v_birth_year,12) = 4 THEN v_ddi := '쥐띠';
    ELSIF MOD(v_birth_year,12) = 5 THEN v_ddi := '소띠';
    ELSIF MOD(v_birth_year,12) = 6 THEN v_ddi := '호랑이띠';
    ELSIF MOD(v_birth_year,12) = 7 THEN v_ddi := '토끼띠';
    ELSIF MOD(v_birth_year,12) = 8 THEN v_ddi := '용띠';
    ELSIF MOD(v_birth_year,12) = 9 THEN v_ddi := '뱀띠';
    ELSIF MOD(v_birth_year,12) = 10 THEN v_ddi := '말띠';
    ELSE v_ddi := '양띠';
    END IF;
    DBMS_OUTPUT.PUT_LINE(v_birth_year||'년생은 '||v_ddi||'입니다.');
END;
/

--------------------------------------------------------------RECORD
DECLARE
    --레코드 구조 선언
    TYPE emp_record_type IS RECORD (
        empno NUMBER(4) NOT NULL := 100,
        ename employees.last_name%TYPE,
        job employees.job_id%TYPE
    );
    --해당 레코드 구조가 저장된 변수 지정
    emp_data emp_record_type;
    temp_data emp_record_type;
BEGIN
    emp_data.ename := 'Kang';
    emp_data.job := 105;
    DBMS_OUTPUT.PUT_LINE(emp_data.empno ||', '||emp_data.ename ||', '|| emp_data.job);
    --레코드 데이터 복사 (동일한 레코드 타입이어야 한다.)
    temp_data := emp_data;
    DBMS_OUTPUT.PUT_LINE(temp_data.empno ||', '||temp_data.ename ||', '|| temp_data.job);
END;
/

--------------------------------------------------------------RECORD %ROWTYPE
DECLARE
    -- employees 컬럼명과 타입이 모두 저장된 레코드 구조.
    emp_record employees%ROWTYPE;
BEGIN
    -- SELECT문으로 한 행의 결과값을 emp_record에 저장한다.
    SELECT *
    INTO emp_record
    FROM employees
    WHERE employee_id = 100;
    DBMS_OUTPUT.PUT_LINE(emp_record.employee_id ||', '||emp_record.last_name);
   -- INSERT INTO employees VALUES emp_record;
   -- UPDATE employees SET ROW = emp_record WHERE employee_id = &inputId;
END;
/

DECLARE
    v_emp_no NUMBER := 124;
    v_emp_rec employees%ROWTYPE;
BEGIN
    SELECT * INTO v_emp_rec
    FROM employees
    WHERE employee_id = v_emp_no;
    
    UPDATE employees
    -- 한 행을 모두 업데이트할 때는 ROW를 사용한다. 레코드 타입을 이용하면 처리가 더 빠르다.
    SET ROW = v_emp_rec
    WHERE employee_id = v_emp_no;
END;
/

--------------------------------------------------------------TABLE
DECLARE
    TYPE dept_table_type IS TABLE OF NUMBER
    INDEX BY BINARY_INTEGER;
    dept_table dept_table_type;
    v_total NUMBER;
BEGIN
    FOR v_counter IN 1..50 LOOP
    dept_table(v_counter) := v_counter;
    END LOOP;
    v_total := dept_table.COUNT;
    DBMS_OUTPUT.PUT_LINE(v_total);
END;
/

DECLARE
    TYPE emp_table_type IS TABLE OF employees.last_name%TYPE
        INDEX BY BINARY_INTEGER;
    emp_table emp_table_type;
    v_index BINARY_INTEGER;
BEGIN
    emp_table(43) := 'MASON';
    emp_table(50) := 'JUNEBUG';
    emp_table(47) := 'TALLER';
    v_index := emp_table.FIRST;
    DBMS_OUTPUT.PUT_LINE(v_index);
    v_index := emp_table.LAST;
    DBMS_OUTPUT.PUT_LINE(v_index);
END;
/

DECLARE
    TYPE dept_table_type IS TABLE OF
            departments%ROWTYPE INDEX BY PLS_INTEGER;
    dept_table dept_table_type;
BEGIN
    SELECT * INTO dept_table(1) FROM departments
        WHERE department_id = 10;
    DBMS_OUTPUT.PUT_LINE(dept_table(1).department_id ||' '||
        dept_table(1).department_name ||' '||
        dept_table(1).manager_id);
END;
/

DECLARE
    TYPE emp_rec_type IS RECORD (
        empno employees.employee_id%TYPE,
        ename employees.last_name%TYPE
    );
    TYPE emp_table_type IS TABLE OF emp_rec_type
        INDEX BY BINARY_INTEGER;
        
    rec_data emp_rec_type;
    emp_data emp_table_type;
BEGIN
    --레코드에 값 넣기
    rec_data.empno := 100;
    rec_data.ename := 'Kim';
    
    --레코드 구조 값을 가진 테이블에 값 넣기
    emp_data(1).empno := 200;
    emp_data(1).ename := 'Shin';
    
    DBMS_OUTPUT.PUT_LINE(emp_data(1).empno);   
END;
/

--------------------------------------------------------------CURSOR
DECLARE
    CURSOR c_emp_cursor IS
        SELECT employee_id, last_name FROM employees
        WHERE department_id = 20;
    v_empno employees.employee_id%TYPE;
    v_lname employees.last_name%TYPE;
BEGIN
    OPEN c_emp_cursor;
    LOOP
        FETCH c_emp_cursor INTO v_empno, v_lname;
        EXIT WHEN
            c_emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_lname);
    END LOOP;
    CLOSE c_emp_cursor;
END;
/

DECLARE
    CURSOR c_emp_cursor IS
        SELECT employee_id, last_name FROM employees
        WHERE department_id = 20;
    v_emp_record c_emp_cursor%ROWTYPE;
BEGIN
    OPEN c_emp_cursor;
    LOOP
        FETCH c_emp_cursor INTO v_emp_record;
        EXIT WHEN
            c_emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_emp_record.employee_id || ' ' || v_emp_record.last_name);
    END LOOP;
    CLOSE c_emp_cursor;
END;
/

DECLARE
    CURSOR c_emp_cursor IS
        SELECT employee_id, last_name FROM employees
        WHERE department_id = 20;
BEGIN
    FOR emp_record IN c_emp_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ' ' || emp_record.last_name);
    END LOOP;
END;
/

BEGIN
    FOR emp_record IN (SELECT employee_id, last_name 
                                FROM employees 
                                WHERE department_id = 20) 
    LOOP
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ' ' || emp_record.last_name);
    END LOOP;
END;
/

DECLARE
        CURSOR c_emp_cursor(deptno NUMBER) IS
        SELECT employee_id, last_name FROM employees
        WHERE department_id = deptno;
    deptno NUMBER := 10;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(deptno);
        FOR emp_record IN c_emp_cursor(deptno) LOOP
            DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ' ' || emp_record.last_name);
        END LOOP;
        deptno := deptno + 10;
        EXIT WHEN deptno > 100;
    END LOOP;
END;
/

select * from employees where department_id = 10;