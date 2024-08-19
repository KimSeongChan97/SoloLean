-- --------------------------------------------------------------------------
-- 서버 출력 설정을 켜서 DBMS_OUTPUT.PUT_LINE으로 출력된 결과가 콘솔에 표시되도록 설정
SET SERVEROUTPUT ON;

-- 첫 번째 익명 PL/SQL 블록을 시작합니다.
BEGIN
    -- DBMS_OUTPUT.PUT_LINE는 콘솔에 텍스트를 출력하는 함수입니다.
    -- 이 함수는 PL/SQL 블록에서 사용되며, 출력할 메시지를 인자로 전달받아 콘솔에 출력합니다.
    -- 아래는 'Hello PL/SQL!!'이라는 메시지를 콘솔에 출력하는 예입니다.
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL!!'); 
END;
-- 첫 번째 블록이 끝났습니다. PL/SQL 블록이 정상적으로 종료됩니다.
-- 이 블록은 간단한 메시지를 출력하는 예시로, 서버에 연결된 콘솔에 텍스트를 출력하는 기본적인 예제입니다.
/
-- 두 번째 익명 PL/SQL 블록입니다.
DECLARE
    -- 이름을 저장할 변수 선언, 최대 10글자까지 저장 가능 (VARCHAR2 타입 사용)
    -- VARCHAR2는 가변 길이 문자열을 저장할 수 있는 데이터 타입입니다. 여기서는 최대 10자의 문자열을 저장할 수 있습니다.
    name varchar2(10);  
    -- 나이를 저장할 변수 선언, 숫자(정수)로 최대 4자리까지 저장 가능, 초기값을 25로 설정 (NUMBER 타입 사용)
    -- NUMBER는 숫자형 데이터 타입으로, 여기서는 최대 4자리 숫자를 저장할 수 있습니다. 초기값을 25로 설정합니다.
    age number(4) := 25;
BEGIN
    -- '홍길동'이라는 문자열을 변수 name에 할당합니다.
    -- 문자열을 변수에 저장할 때는 := 연산자를 사용하여 값을 할당합니다.
    name := '홍길동';  
    -- DBMS_OUTPUT.PUT_LINE을 사용하여 name 변수의 값을 콘솔에 출력합니다.
    -- 문자열을 콘솔에 출력할 때 || 연산자를 사용하여 문자열을 결합할 수 있습니다.
    -- 출력 결과는 'name : 홍길동'입니다.
    dbms_output.put_line('name : ' || name);   
    -- DBMS_OUTPUT.PUT_LINE을 사용하여 age 변수의 값을 콘솔에 출력합니다.
    -- 출력 결과는 'age : 25'입니다.
    dbms_output.put_line('age : ' || age);
END;
-- 두 번째 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록에서는 문자열과 숫자를 출력하는 방법을 배웠으며, 변수 선언 및 값을 할당하는 PL/SQL의 기본 구조를 이해할 수 있습니다.
/
-- departments 테이블에서 department_id가 50인 레코드를 조회하는 SQL 쿼리입니다.
-- 테이블의 특정 레코드를 조회하는 간단한 SQL SELECT 문입니다.
SELECT * 
FROM departments 
WHERE department_id = 50;

-- 세 번째 익명 PL/SQL 블록입니다.
DECLARE
    -- departments 테이블의 department_id 컬럼과 동일한 데이터 타입을 사용하는 변수 v_no를 선언하고 초기값을 50으로 설정합니다.
    -- %TYPE을 사용하여 컬럼과 동일한 데이터 타입을 사용함으로써 컬럼의 데이터 타입이 변경될 경우 코드가 자동으로 대응할 수 있게 합니다.
    -- v_no는 departments 테이블의 department_id 컬럼과 동일한 데이터 타입을 사용합니다. 이렇게 하면 테이블 구조가 변경되더라도 이 변수는 항상 해당 컬럼의 타입을 따릅니다.
    v_no departments.department_id%TYPE := 50;
BEGIN
    -- DBMS_OUTPUT.PUT_LINE을 사용하여 v_no 변수의 값을 콘솔에 출력합니다.
    -- 출력 결과는 'v_no : 50'입니다.
    dbms_output.put_line('v_no : ' || v_no);
END;
-- 세 번째 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록에서는 테이블의 컬럼 타입을 참조하여 변수를 선언하는 방법을 배우며, 테이블의 변경에도 유연하게 대응할 수 있는 코드를 작성하는 방법을 보여줍니다.
/
-- departments 테이블의 모든 레코드를 조회하는 SQL 쿼리입니다.
-- 테이블의 전체 데이터를 조회하는 일반적인 SELECT 문입니다.
select * from departments;

-- 네 번째 익명 PL/SQL 블록입니다.
DECLARE
    -- V_DEPT 변수를 DEPARTMENTS 테이블의 행 구조로 선언
    -- %ROWTYPE은 특정 테이블의 행 전체를 저장할 수 있는 변수 타입을 의미합니다. 이 변수는 departments 테이블의 한 행을 저장할 수 있습니다.
    V_DEPT DEPARTMENTS%ROWTYPE;
BEGIN
    -- SELECT 쿼리 결과를 V_DEPT에 대입합니다.
    -- SELECT 문으로 얻은 결과를 PL/SQL 블록 내의 변수에 저장하려면 INTO 구문을 사용해야 합니다.
    -- 이 경우, V_DEPT는 departments 테이블의 전체 행 구조를 저장하기 때문에 SELECT 문은 해당 테이블의 전체 열을 선택해야 합니다.
    select *
    -- SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID 
    INTO V_DEPT 
    FROM DEPARTMENTS 
    WHERE DEPARTMENT_ID = 50;

    -- SELECT로 받은 값을 출력합니다.
    -- DBMS_OUTPUT.PUT_LINE을 사용하여 SELECT 문으로 가져온 데이터 값을 콘솔에 출력합니다.
    -- 각 출력 구문은 V_DEPT에 저장된 각 열의 값을 출력합니다.
    DBMS_OUTPUT.PUT_LINE('DEPARTMENT_ID : ' || V_DEPT.DEPARTMENT_ID);
    DBMS_OUTPUT.PUT_LINE('DEPARTMENT_NAME : ' || V_DEPT.DEPARTMENT_NAME);
    DBMS_OUTPUT.PUT_LINE('MANAGER_ID : ' || V_DEPT.MANAGER_ID);
    DBMS_OUTPUT.PUT_LINE('LOCATION_ID : ' || V_DEPT.LOCATION_ID);
END;
-- 네 번째 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록에서는 특정 테이블의 행을 SELECT 문으로 가져와 변수에 저장하고, 그 결과를 출력하는 방법을 학습할 수 있습니다.
/
--  익명 PL/SQL 블록입니다.
DECLARE
    -- 상수를 선언합니다. 상수는 변하지 않는 값으로, 여기서는 PI 상수를 선언하여 값을 3.141592로 설정합니다.
    -- 상수는 CONSTANT 키워드를 사용하여 선언되며, 한 번 설정된 값은 변경할 수 없습니다.
    PI CONSTANT NUMBER := 3.141592;
    -- 가변 문자열을 선언하고, 기본값으로 '사과'를 설정합니다.
    -- 기본값은 DEFAULT 키워드를 사용하여 설정할 수 있습니다.
    APPLE VARCHAR2(10) DEFAULT '사과';
    -- NOT NULL 제약 조건을 가진 변수를 선언합니다. 해당 변수에는 반드시 값을 할당해야 하며, NULL 값을 가질 수 없습니다.
    ID VARCHAR2(10) NOT NULL := 'hong';
    -- NOT NULL 제약 조건을 가지며, 기본값으로 '1234'를 가지는 변수를 선언합니다.
    PWD VARCHAR2(10) NOT NULL DEFAULT '1234';
BEGIN
    -- 각 상수와 변수의 값을 콘솔에 출력합니다.
    -- DBMS_OUTPUT.PUT_LINE을 사용하여 각 상수 및 변수의 값을 출력합니다.
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
    DBMS_OUTPUT.PUT_LINE('APPLE : ' || APPLE);
    DBMS_OUTPUT.PUT_LINE('ID : ' || ID);
    DBMS_OUTPUT.PUT_LINE('PWD : ' || PWD);
END;
-- 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록에서는 상수 선언, 기본값 지정, 그리고 NOT NULL 제약 조건을 가지는 변수를 선언하는 방법을 배울 수 있습니다.
/

-- --------------------------------------------------------------------------
-- 첫 번째 익명 PL/SQL 블록입니다.
-- 이 블록에서는 숫자가 홀수인지 짝수인지 판별하는 간단한 조건문 예제를 보여줍니다.
-- MOD 함수는 첫 번째 인자를 두 번째 인자로 나눈 나머지를 반환하는 함수입니다.
DECLARE
    -- 숫자형 변수 num을 선언하고 15로 초기화합니다.
    -- 이 변수는 홀수 또는 짝수를 판별할 값입니다.
    num NUMBER := 15;
BEGIN
    -- MOD 함수를 사용하여 num을 2로 나눈 나머지를 구합니다.
    -- 나머지가 1인 경우는 홀수임을 의미하므로 조건을 충족하면 해당 메시지를 출력합니다.
    -- 이 경우, num이 15이므로 15는 홀수입니다.
    IF MOD(num, 2) = 1 THEN
        -- num이 홀수일 경우, '15는 홀수이다.'라는 메시지를 출력합니다.
        -- DBMS_OUTPUT.PUT_LINE 함수는 콘솔에 출력을 수행하는 함수로, 여기서 num과 문자열 '는 홀수이다.'를 결합하여 출력합니다.
        DBMS_OUTPUT.PUT_LINE(num || '는 홀수이다.');
    END IF;
END;
-- 첫 번째 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록은 특정 값이 홀수인 경우에만 메시지를 출력하는 간단한 PL/SQL 조건문 예제입니다.
/
-- 두 번째 익명 PL/SQL 블록입니다.
-- 이 블록에서는 숫자가 짝수인지 홀수인지를 판별하는 예제를 보여줍니다.

DECLARE
    -- 숫자형 변수 num을 선언하고 16으로 초기화합니다.
    -- 이 변수는 짝수 또는 홀수를 판별할 값입니다.
    num NUMBER := 16;
BEGIN
    -- MOD 함수를 사용하여 num을 2로 나눈 나머지를 구합니다.
    -- 나머지가 0인 경우는 짝수임을 의미하므로 조건을 충족하면 해당 메시지를 출력합니다.
    -- 이 경우, num이 16이므로 짝수입니다.
    IF MOD(num, 2) = 0 THEN
        -- num이 짝수일 경우, '16는 짝수이다.'라는 메시지를 출력합니다.
        -- DBMS_OUTPUT.PUT_LINE 함수는 num과 문자열 '는 짝수이다.'를 결합하여 콘솔에 출력합니다.
        DBMS_OUTPUT.PUT_LINE(num || '는 짝수이다.');
    ELSE
        -- num이 홀수일 경우, 이 부분이 실행됩니다.
        -- 하지만 이 경우 num은 짝수이므로 ELSE 구문은 실행되지 않습니다.
        DBMS_OUTPUT.PUT_LINE(num || '는 홀수이다.');
    END IF;
END;
-- 두 번째 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록은 짝수와 홀수를 판별하여 각각 다른 메시지를 출력하는 예제입니다.
/
-- 세 번째 익명 PL/SQL 블록입니다.
-- 이 블록에서는 점수(score)를 기반으로 학점을 출력하는 예제를 보여줍니다.
-- 점수를 비교하여 적절한 학점을 출력하는 IF-ELSIF-ELSE 구조를 사용합니다.

DECLARE
    -- 숫자형 변수 score를 선언하고 87로 초기화합니다.
    -- 이 변수는 학점을 결정할 점수 값을 나타냅니다.
    score NUMBER := 87;
BEGIN
    -- IF 문을 사용하여 점수를 비교합니다.
    -- 점수가 90 이상이면 'A 학점'을 출력합니다.
    IF score >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('A 학점');
    -- 점수가 80 이상이면 'B 학점'을 출력합니다.
    ELSIF score >= 80 THEN
        DBMS_OUTPUT.PUT_LINE('B 학점');
    -- 점수가 70 이상이면 'C 학점'을 출력합니다.
    ELSIF score >= 70 THEN
        DBMS_OUTPUT.PUT_LINE('C 학점');
    -- 점수가 60 이상이면 'D 학점'을 출력합니다.
    ELSIF score >= 60 THEN
        DBMS_OUTPUT.PUT_LINE('D 학점');
    -- 그 외의 경우에는 'F 학점'을 출력합니다.
    ELSE
        DBMS_OUTPUT.PUT_LINE('F 학점');
    END IF;
END;
-- 세 번째 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록은 IF-ELSIF-ELSE 구조를 사용하여 점수에 따라 다른 학점을 출력하는 예제입니다.
/
-- 네 번째 익명 PL/SQL 블록입니다.
-- 이 블록에서는 CASE 문을 사용하여 점수를 기반으로 학점을 출력하는 예제를 보여줍니다.
-- TRUNC 함수는 소숫점을 제거하고 정수 부분만 반환합니다.

DECLARE
    -- 숫자형 변수 SCORE를 선언하고 87로 초기화합니다.
    -- 이 변수는 학점을 결정할 점수 값을 나타냅니다.
    SCORE NUMBER := 87;
BEGIN
    -- CASE 문을 사용하여 점수를 10으로 나눈 몫을 기준으로 학점을 결정합니다.
    -- TRUNC(SCORE/10)은 점수를 10으로 나눈 정수 값을 반환합니다.
    CASE TRUNC(SCORE / 10)
        -- 몫이 9이면 'A 학점'을 출력합니다.
        WHEN 9 THEN DBMS_OUTPUT.PUT_LINE('A 학점');
        -- 몫이 8이면 'B 학점'을 출력합니다.
        WHEN 8 THEN DBMS_OUTPUT.PUT_LINE('B 학점');
        -- 몫이 7이면 'C 학점'을 출력합니다.
        WHEN 7 THEN DBMS_OUTPUT.PUT_LINE('C 학점');
        -- 몫이 6이면 'D 학점'을 출력합니다.
        WHEN 6 THEN DBMS_OUTPUT.PUT_LINE('D 학점');
        -- 그 외의 경우에는 'F 학점'을 출력합니다.
        ELSE DBMS_OUTPUT.PUT_LINE('F 학점');
    END CASE;
END;
-- 네 번째 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록은 CASE 문을 사용하여 점수를 10으로 나눈 몫에 따라 학점을 출력하는 예제입니다.
/
-- 다섯 번째 익명 PL/SQL 블록입니다.
-- 이 블록은 점수를 기반으로 학점을 출력하는 또 다른 CASE 문 예제를 보여줍니다.
-- 이 CASE 문은 각각의 조건을 비교하여 학점을 결정합니다.

DECLARE
    -- 숫자형 변수 SCORE를 선언하고 87로 초기화합니다.
    -- 이 변수는 학점을 결정할 점수 값을 나타냅니다.
    SCORE NUMBER := 87;
BEGIN
    -- CASE 문을 사용하여 점수를 비교하여 학점을 결정합니다.
    -- WHEN 절을 사용하여 각 점수 조건을 설정합니다.
    CASE
        -- 점수가 90 이상이면 'A 학점'을 출력합니다.
        WHEN SCORE >= 90 THEN DBMS_OUTPUT.PUT_LINE('A 학점');
        -- 점수가 80 이상이면 'B 학점'을 출력합니다.
        WHEN SCORE >= 80 THEN DBMS_OUTPUT.PUT_LINE('B 학점');
        -- 점수가 70 이상이면 'C 학점'을 출력합니다.
        WHEN SCORE >= 70 THEN DBMS_OUTPUT.PUT_LINE('C 학점');
        -- 점수가 60 이상이면 'D 학점'을 출력합니다.
        WHEN SCORE >= 60 THEN DBMS_OUTPUT.PUT_LINE('D 학점');
        -- 그 외의 경우에는 'F 학점'을 출력합니다.
        ELSE DBMS_OUTPUT.PUT_LINE('F 학점');
    END CASE;
END;
-- 다섯 번째 블록이 끝났습니다. 이 블록도 정상적으로 종료됩니다.
-- 이 블록은 조건 기반의 CASE 문을 사용하여 점수에 따라 학점을 출력하는 예제입니다.
/
-- -----------------------------------------------------------------------
-- 무한루프와 exit 를 이용한 반복문
declare
    num number := 0; -- 숫자를 저장하는 num 변수를 선언하고 0으로 초기화
begin
    loop -- 무한 루프를 시작 (반복이 명시적으로 종료될 때까지 계속 실행)
        dbms_output.put_line(num); -- 현재 num 변수의 값을 출력 (처음엔 0)
        num := num + 1; -- num 변수에 1을 더하여 값을 증가시킴
        exit when num > 4; -- num 값이 4보다 클 때 반복문을 종료 (이 조건을 만족하면 루프를 종료함)
    end loop; -- 루프의 끝, exit 조건이 충족되지 않으면 루프는 다시 시작
end;
/
-- while 반복문을 이용한 루프
declare
    num number := 0; -- 숫자를 저장하는 num 변수를 선언하고 0으로 초기화
begin
    while num < 4 loop -- num 값이 4보다 작을 때만 루프를 실행
        dbms_output.put_line(num); -- 현재 num 변수의 값을 출력
        num := num + 1; -- num 변수에 1을 더하여 값을 증가시킴
        exit when num > 4; -- num 값이 4보다 클 경우 루프를 강제로 종료
    end loop; -- while 조건이 만족하지 않으면 루프 종료
end;
/
-- for 반복문을 이용한 루프
begin
    -- for 루프는 0부터 4까지 i 변수를 자동으로 증가시키며 반복 실행
    for i in 0..4 loop -- i 변수를 0부터 4까지 1씩 증가시키면서 루프 실행
        dbms_output.put_line(i); -- 현재 i 값 출력 (0, 1, 2, 3, 4가 순서대로 출력됨)
    end loop; -- 루프가 4까지 실행되면 종료됨
end;
/
-- for 반복문을 역순으로 사용한 루프
begin
    -- reverse 키워드를 사용하여 루프를 역순으로 실행함
    -- i는 4부터 시작하여 0까지 1씩 감소
    for i in reverse 0..4 loop -- i 변수를 4부터 0까지 역순으로 감소시키며 루프 실행
        dbms_output.put_line(i); -- 현재 i 값 출력 (4, 3, 2, 1, 0이 순서대로 출력됨)
    end loop; -- 루프가 0까지 실행되면 종료됨
end;
/
-- continue 를 이용한 반복문
begin 
    -- for 루프는 0부터 4까지 i 변수를 자동으로 증가시키며 반복 실행
    for i in 0..4 loop -- i 변수를 0부터 4까지 1씩 증가시키면서 루프 실행
        continue when mod(i, 2) = 1; -- i 값이 홀수일 경우 루프의 나머지 부분을 건너뛰고 다음 반복으로 넘어감
        dbms_output.put_line(i); -- i 값이 짝수일 경우에만 출력됨 (0, 2, 4가 출력됨)
    end loop; -- 루프가 4까지 실행되면 종료됨
end;
/
-- [문제]
-- 1~10까지의 숫자 중에서 홀수만 출력하고, 홀수의 합을 구하시오.
declare
    sum_odd number := 0; -- 홀수들의 합을 저장할 변수 sum_odd를 선언하고 0으로 초기화
begin
    -- 1부터 10까지 반복하면서 홀수만 찾음
    for i in 1..10 loop -- i 변수를 1부터 10까지 1씩 증가시키며 반복 실행
        if mod(i, 2) = 1 then -- i 값을 2로 나눈 나머지가 1이면 홀수 (짝수는 나머지가 0)
            dbms_output.put_line(i); -- 홀수인 경우 i 값을 출력
            sum_odd := sum_odd + i; -- 현재 홀수 i 값을 sum_odd에 더하여 누적 합계 구함
        end if; -- if 문 종료, 홀수일 때만 조건문 내부 실행
    end loop; -- 루프 종료, 1부터 10까지 모든 숫자가 처리됨
    dbms_output.put_line('홀수의 합: ' || sum_odd); -- 최종적으로 구한 홀수들의 합을 출력
end;
/
declare
    sum_i number := 0; -- 합계를 저장할 변수 sum_i를 선언하고 초기값으로 0을 설정합니다. 
                       -- 이 변수는 홀수들의 누적 합을 계산하는 데 사용됩니다.
begin
    -- for 루프는 i 변수를 1부터 10까지 자동으로 증가시키면서 반복합니다.
    for i in 1..10 loop -- i 변수를 1부터 10까지 1씩 증가시키면서 루프를 실행합니다.       
        -- mod(i, 2)를 사용하여 i가 홀수인지 확인합니다.
        -- mod 함수는 i를 2로 나눈 나머지를 반환하는데, 
        -- i가 홀수일 경우 mod(i, 2)는 1이 되고, 짝수일 경우는 0이 됩니다.
        if mod(i, 2) = 1 then -- i를 2로 나눈 나머지가 1이면 i는 홀수입니다.
            -- 현재 i 값이 홀수일 경우, 이를 출력합니다.
            dbms_output.put_line(i); -- 현재 i 값(홀수)을 출력합니다.
            -- 현재 홀수인 i 값을 sum_i에 더해 누적합니다.
            -- 즉, 이전까지의 홀수들의 합에 현재 홀수 i 값을 더합니다.
            sum_i := sum_i + i; -- sum_i에 현재 i 값을 더하여 업데이트합니다.
        end if; -- if 블록의 종료, 조건이 충족될 때만 이 블록이 실행됩니다.      
    end loop; -- for 루프 종료, 1부터 10까지의 모든 i가 처리된 후 종료됩니다.
    -- 모든 반복이 끝난 후, 최종적으로 계산된 홀수들의 합을 출력합니다.
    dbms_output.put_line(sum_i); -- sum_i에 저장된 홀수들의 총 합계를 출력합니다.
end;
/


