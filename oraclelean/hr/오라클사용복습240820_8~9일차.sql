--저장 서브프로그램(stored subprogram)
--PL/SQL 블록은 작성한 내용을 한 번 실행하는 데 사용한다. 
--PL/SQL 블록은 이름이 정해져 있지 않아서 익명 블록이라고 한다.
--익명 블록은 오라클에 저장되지 않기 때문에 한 번 실행한 후에 다시 실행하려면 PL/SQL 블록을 다시 작성하여 실행해야 한다.
-- 여러 번 사용할 목적으로 이름을 지정하여 오라클에 저장해 두는 PL/SQL 프로그램
-- 저장할 때 한 번 컴파일 한다.
-- 오라클에 저장하여 공유할 수 있어서 메모리, 성능, 재사용성 등 여러 면에서 장점이 있다. 
-- 대표적인 구현 방식은 프로시저, 함수, 패키지, 트리거이다

--1. 프로시저
-- 특정 처리 작업을 수행하는데 사용하는 저장 서브프로그램 
-- 파라미터를 사용할 수도 있고 사용하지 않을 수도 있다.
--1) 파라미터를 사용하지 않는 프로시저
-- 작업 수행에 별다른 입력 데이터가 필요하지 않은 경우
--① 프로시저 생성
-- 선언부, 실행부, 예외 처리부로 구성되어 있다
--[형식]
--CREATE [OR REPLACE] PROCEDURE 프로시저명
--IS | AS              -- DECLARE 키워드는 사용하지 않는다. 
--선언부
--BEGIN
--실행부
--EXCEPTION
--예외 처리부 
--END [프로시저 이름];
--② 프로시저 실행 
--[형식]
--EXECUTE 프로시저 이름;
--③ 프로시저 내용 확인
--④ 프로시저 삭제

--[실습]
--SET SERVEROUTPUT ON; 
set serveroutput on;
-- 이 명령어는 오라클의 출력 기능을 활성화하는 명령어입니다.
-- DBMS_OUTPUT.PUT_LINE 함수를 사용해 콘솔에 출력할 내용을 표시할 수 있게 됩니다.

-- 프로시저 생성
--CREATE OR REPLACE PROCEDURE PRO_NOPARAM 
--IS
--NAME VARCHAR2(10);  -- NAME이라는 변수를 선언하며, VARCHAR2(10) 타입은 최대 10자까지의 문자열을 저장할 수 있습니다.
--AGE NUMBER(4) := 25; -- AGE라는 변수를 선언하며, NUMBER(4) 타입은 4자리 숫자를 저장할 수 있습니다. 기본값은 25로 설정됩니다.
--BEGIN
--NAME := '홍길동'; -- 실행부에서는 NAME 변수에 '홍길동'이라는 문자열을 할당합니다.
--DBMS_OUTPUT.PUT_LINE('NAME : ' || NAME); -- NAME 변수를 출력하는 함수로, 'NAME : '라는 문자열과 NAME 변수의 값을 결합하여 출력합니다.
--DBMS_OUTPUT.PUT_LINE('AGE : ' || AGE); -- AGE 변수를 출력하는 함수로, 'AGE : '라는 문자열과 AGE 변수의 값을 결합하여 출력합니다.
--END PRO_NOPARAM; 
--/ -- 프로시저의 끝을 나타내며, 프로시저가 컴파일되고 데이터베이스에 저장됩니다.
create or replace procedure PRO_NOPARAM
is
    name varchar2(10);  -- 문자열 타입의 변수 name 선언, 최대 길이는 10자
    age number(4) := 25; -- 숫자 타입의 변수 age 선언, 기본값은 25
begin
    name := '홍길동';  -- name 변수에 '홍길동'이라는 값 할당
    dbms_output.put_line('NAME : ' || name);  -- name 변수를 출력, 'NAME : '와 name 값이 연결되어 출력됨
    dbms_output.put_line('AGE : ' || age);  -- age 변수를 출력, 'AGE : '와 age 값이 연결되어 출력됨
end PRO_NOPARAM; 
/
-- 이 프로시저는 데이터베이스에 저장되며, 언제든지 호출하여 동일한 출력을 할 수 있습니다.
-- 선언된 이름 'PRO_NOPARAM'은 데이터를 입력받지 않고 간단히 이름과 나이를 출력하는 로직을 포함합니다.

--프로시저 실행
--EXECUTE PRO_NOPARAM; 
-- 이 명령어는 저장된 프로시저를 호출하는 방법입니다.
execute PRO_NOPARAM; -- 프로시저를 실행하여, '홍길동'과 25라는 나이가 출력됩니다.

--PL/SQL에서 프로시저 실행 
--BEGIN
--PRO_NOPARAM; 
--END;
--/
-- 이 블록은 PL/SQL 블록 내에서 프로시저를 호출하는 방법입니다.
begin
PRO_NOPARAM;  -- 저장된 프로시저를 호출하여 같은 출력이 발생합니다.
end;
/
-- 프로시저를 PL/SQL 블록 내에서도 호출 가능하며, execute 명령어와 같은 동작을 합니다.

-- 프로시저 확인
--SELECT * FROM USER_SOURCE WHERE NAME = 'PRO_NOPARAM'; 
-- 이 쿼리는 사용자 소스 테이블에서 프로시저 'PRO_NOPARAM'의 소스 코드를 조회하는 방법입니다.
SELECT * FROM USER_SOURCE WHERE NAME = 'PRO_NOPARAM';
-- 사용자 정의된 PL/SQL 객체의 소스 코드를 조회할 수 있습니다. 이 경우, 'PRO_NOPARAM' 프로시저의 소스 코드가 반환됩니다.

--프로시저 삭제
--DROP PROCEDURE PRO_NOPARAM; 
-- 이 명령어는 데이터베이스에서 해당 프로시저를 삭제하는 방법입니다.
-- DROP PROCEDURE PRO_NOPARAM;
-- 삭제된 프로시저는 더 이상 호출할 수 없으며, 필요시 다시 생성해야 합니다.
-- -------------------------------------------------------------
--2) 파라미터를 사용하는 프로시저
--[형식]
--CREATE [OR REPLACE] PROCEDURE 프로시저명 
--(
--파라미터 이름   [MODES] 자료형 [ := | DEFAULT ], -- 자리수 지정 및 NOT NULL 사용 불가능 
--파라미터 이름   [MODES] 자료형 [ := | DEFAULT ], -- ;이 아니라 ,로 지정
--... 
--)
--IS | AS        -- DECLARE 키워드는 사용하지 않는다. 
--선언부
--BEGIN
--실행부
--EXCEPTION
--예외 처리부 
--END [프로시저 이름];
--① IN 모드 파라미터
--- 프로시저 실행에 필요한 값을 직접 입력받는 형식의 파라미터를 지정할 때 사용한다.

--[실습]
--CREATE OR REPLACE PROCEDURE PRO_PARAM_IN 
--(
--NAME IN VARCHAR2, 
--AGE NUMBER,
--PHONE VARCHAR2 := '010-1234-5678', 
--ADDR VARCHAR2 DEFAULT '서울'
--)
--IS 
--BEGIN
--DBMS_OUTPUT.PUT_LINE('NAME : ' || NAME);
--DBMS_OUTPUT.PUT_LINE('AGE : ' || AGE);
--DBMS_OUTPUT.PUT_LINE('PHONE : ' || PHONE);
--DBMS_OUTPUT.PUT_LINE('ADDR : ' || ADDR); 
--END PRO_PARAM_IN;
--/
--EXECUTE PRO_PARAM_IN('홍길동', 25, '010-1111-1111', '부산');
--EXECUTE PRO_PARAM_IN('홍길동', 25);
--EXECUTE PRO_PARAM_IN(NAME => '홍길동', AGE => 25); -- 파라미터 이름과 값을 직접 대입

CREATE OR REPLACE PROCEDURE PRO_PARAM_IN
(
NAME IN VARCHAR2,      -- NAME이라는 입력 파라미터로, 문자열 데이터를 받습니다.
AGE NUMBER,            -- AGE라는 입력 파라미터로, 숫자 데이터를 받습니다.
PHONE VARCHAR2 := '010-1234-5678', -- PHONE은 기본값을 가진 문자열 파라미터로, 값을 전달하지 않으면 '010-1234-5678'이 사용됩니다.
ADDR VARCHAR2 DEFAULT '서울'       -- ADDR 파라미터도 기본값이 있으며, 값이 없으면 '서울'이 사용됩니다.
)
IS
BEGIN
    -- 입력받은 파라미터 값들을 출력하는 부분입니다.
    DBMS_OUTPUT.PUT_LINE('NAME : ' || NAME);  -- NAME 파라미터의 값 출력
    DBMS_OUTPUT.PUT_LINE('AGE : ' || AGE);    -- AGE 파라미터의 값 출력
    DBMS_OUTPUT.PUT_LINE('PHONE : ' || PHONE);-- PHONE 파라미터의 값 출력
    DBMS_OUTPUT.PUT_LINE('ADDR : ' || ADDR);  -- ADDR 파라미터의 값 출력
END PRO_PARAM_IN;
/
-- 위의 프로시저는 기본값을 가진 파라미터를 포함한 입력 파라미터를 사용합니다.
-- 파라미터가 없을 경우 기본값을 사용하고, 있을 경우 전달된 값을 사용합니다.

-- 프로시저 실행 예시
-- 다음 호출은 모든 파라미터 값을 전달하며, 각 값이 출력됩니다.
EXECUTE PRO_PARAM_IN('홍길동', 25, '010-1111-1111', '부산');

-- 다음 호출은 PHONE과 ADDR 값이 전달되지 않으므로 기본값이 사용됩니다.
EXECUTE PRO_PARAM_IN('홍길동', 25);

-- 다음 호출은 파라미터 이름을 지정하여 값을 전달하는 예시입니다.
EXECUTE PRO_PARAM_IN(NAME => '홍길동', AGE => 25);

-- 프로시저 내용을 확인하기 위한 SQL 쿼리로, USER_SOURCE 테이블에서 해당 프로시저의 소스 코드를 조회합니다.
SELECT * FROM USER_SOURCE WHERE NAME = 'PRO_PARAM_IN';

--② OUT 모드 파라미터
--- 프로시저 실행 후 호출한 프로그램으로 값을 반환한다.
-- OUT 파라미터는 프로시저가 실행된 후, 결과 값을 호출한 프로그램으로 돌려주는 역할을 합니다.

--[실습]
--CREATE OR REPLACE PROCEDURE PRO_PARAM_OUT 
--(
--EMPNO IN EMPLOYEES.EMPLOYEE_ID%TYPE, 
--EMPNAME OUT EMPLOYEES.LAST_NAME%TYPE, 
--SAL OUT EMPLOYEES.SALARY%TYPE
--)
--IS 
--BEGIN
--SELECT LAST_NAME, SALARY INTO EMPNAME, SAL FROM EMPLOYEES 
--WHERE EMPLOYEE_ID = EMPNO;
--END PRO_PARAM_OUT; 
--/
-- PL/SQL 불러들임
--DECLARE
--V_EMPNAME EMPLOYEES.LAST_NAME%TYPE; 
--V_SAL EMPLOYEES.SALARY%TYPE;
--BEGIN
--PRO_PARAM_OUT(100, V_EMPNAME, V_SAL);
--DBMS_OUTPUT.PUT_LINE('V_EMPNAME : ' || V_EMPNAME); 
--DBMS_OUTPUT.PUT_LINE('V_SAL : ' || V_SAL);
--END; 
--/
CREATE OR REPLACE PROCEDURE PRO_PARAM_OUT
(
    EMPNO IN EMPLOYEES.EMPLOYEE_ID%TYPE,   -- EMPLOYEES 테이블의 EMPLOYEE_ID 타입과 일치하는 EMPNO 입력 파라미터
    EMPNAME OUT EMPLOYEES.LAST_NAME%TYPE,  -- EMPLOYEES 테이블의 LAST_NAME 타입과 일치하는 EMPNAME 출력 파라미터
    SAL OUT EMPLOYEES.SALARY%TYPE          -- EMPLOYEES 테이블의 SALARY 타입과 일치하는 SAL 출력 파라미터
)
IS
BEGIN
    -- EMPNO에 해당하는 직원의 LAST_NAME과 SALARY를 조회하여, 출력 파라미터 EMPNAME과 SAL에 값을 저장
    SELECT LAST_NAME, SALARY INTO EMPNAME, SAL 
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = EMPNO;
END PRO_PARAM_OUT;
/
-- 이 프로시저는 입력 파라미터 EMPNO를 사용하여 EMPLOYEES 테이블에서 해당 직원의 정보를 조회하고,
-- 조회된 LAST_NAME과 SALARY를 OUT 파라미터 EMPNAME, SAL로 반환합니다.

-- PL/SQL 블록 내에서 프로시저 호출 예시
DECLARE
    V_EMPNAME EMPLOYEES.LAST_NAME%TYPE;  -- EMPLOYEES 테이블의 LAST_NAME 타입과 동일한 V_EMPNAME 변수를 선언
    V_SAL EMPLOYEES.SALARY%TYPE;         -- EMPLOYEES 테이블의 SALARY 타입과 동일한 V_SAL 변수를 선언
BEGIN
    -- 프로시저 호출: EMPNO가 100인 직원의 LAST_NAME과 SALARY를 조회하여 V_EMPNAME과 V_SAL 변수에 저장
    PRO_PARAM_OUT(100, V_EMPNAME, V_SAL);  
    
    -- 결과를 출력: 조회된 직원의 LAST_NAME과 SALARY 값을 출력
    DBMS_OUTPUT.PUT_LINE('V_EMPNAME : ' || V_EMPNAME);  
    DBMS_OUTPUT.PUT_LINE('V_SAL : ' || V_SAL);          
END;
/
-- OUT 파라미터로 전달된 V_EMPNAME과 V_SAL의 값을 출력합니다.
-- 프로시저는 성공적으로 호출되며, OUT 파라미터를 통해 조회된 값이 반환됩니다.

--③ IN OUT 모드 파라미터
--- IN, OUT으로 선언한 파라미터 기능을 동시에 수행한다.
--- IN OUT 파라미터는 프로시저로 값을 전달받아 처리하고, 그 결과를 다시 호출한 쪽으로 반환합니다.

--[실습]
--CREATE OR REPLACE PROCEDURE PRO_PARAM_INOUT 
--(
--NUM IN OUT NUMBER 
--)
--IS 
--BEGIN
--NUM := NUM * 2; 
--END PRO_PARAM_INOUT; 
--/
-- PL/SQL 호출
--DECLARE
--NUM NUMBER; 
--BEGIN
--NUM := 5;
--PRO_PARAM_INOUT(NUM);
--DBMS_OUTPUT.PUT_LINE('NUM : ' || NUM); 
--END;
--/
CREATE OR REPLACE PROCEDURE PRO_PARAM_INOUT 
(
NUM IN OUT NUMBER  -- IN OUT 파라미터로 선언된 NUM은 입력으로 값을 받으며, 그 결과를 다시 반환합니다.
)
IS 
BEGIN
    -- 받은 NUM 값에 2를 곱해서 다시 NUM에 저장
    NUM := NUM * 2; 
END PRO_PARAM_INOUT; 
/
-- 이 프로시저는 IN OUT 파라미터를 사용하여 입력된 숫자를 두 배로 곱한 결과를 다시 반환합니다.

-- PL/SQL 블록 내에서 프로시저 호출 예시
DECLARE
NUM NUMBER;  -- NUMBER 타입의 변수를 선언
BEGIN
NUM := 5;  -- NUM 변수에 초기값 5를 할당
PRO_PARAM_INOUT(NUM);  -- 프로시저 호출: NUM의 값이 5에서 두 배가 되어 10으로 변경됩니다.
DBMS_OUTPUT.PUT_LINE('NUM : ' || NUM);  -- NUM 값 출력: 10이 출력됩니다.
END;
/
-- 프로시저 실행 결과, NUM 값은 5에서 10으로 변경되어 출력됩니다.
-- -----
-- [문제]
-- 1. 25, 36의 합을 구하는 프로시저를 작성하시오
-- 프로시저 명 : PRO_SUM
-- 이 프로시저는 25와 36을 더한 값을 OUT 파라미터를 통해 호출한 곳으로 반환합니다.
-- OUT 파라미터는 프로시저가 완료될 때 값을 반환하는 데 사용됩니다.
CREATE OR REPLACE PROCEDURE PRO_SUM
(
    RESULT OUT NUMBER  -- OUT 파라미터로 결과 값을 반환
)
IS
BEGIN
    -- 25와 36을 더한 값을 OUT 파라미터인 RESULT에 저장합니다.
    RESULT := 25 + 36;  -- 25와 36의 합을 계산
END PRO_SUM;
/
-- 이 프로시저는 별도의 입력 값을 받지 않으며, 고정된 25와 36의 합을 계산하여 OUT 파라미터를 통해 반환합니다.

-- 2. 2의 5승을 구하는 프로시저를 작성하시오
-- 프로시저 명 : PRO_FACTORY
-- 이 프로시저는 2의 5승을 계산한 값을 OUT 파라미터를 통해 반환합니다.
-- Oracle의 내장 함수인 POWER 함수는 첫 번째 인수를 두 번째 인수만큼 거듭제곱하여 그 결과를 반환합니다.
CREATE OR REPLACE PROCEDURE PRO_FACTORY
(
    RESULT OUT NUMBER  -- OUT 파라미터로 결과 값을 반환
)
IS
BEGIN
    -- POWER 함수는 2의 5승을 계산하며 그 값을 RESULT에 저장합니다.
    RESULT := POWER(2, 5);  -- 2의 5승을 계산
END PRO_FACTORY;
/
-- 이 프로시저는 고정된 값(2와 5)을 사용하여 계산을 수행하며, OUT 파라미터로 결과를 반환합니다.

-- 3. 위 2개의 프로시저를 호출하는 PL/SQL를 작성하시오
-- PL/SQL 블록은 두 개의 프로시저를 호출하여 계산된 결과를 출력합니다.
-- 각각의 결과는 OUT 파라미터를 통해 반환된 후 변수에 저장됩니다.
DECLARE
    V_SUM_RESULT NUMBER;      -- PRO_SUM에서 반환될 합계 결과를 저장할 변수
    V_FACTORY_RESULT NUMBER;  -- PRO_FACTORY에서 반환될 2의 5승 결과를 저장할 변수
BEGIN
    -- PRO_SUM 프로시저를 호출하여 25 + 36의 결과를 V_SUM_RESULT에 저장
    PRO_SUM(V_SUM_RESULT);  -- OUT 파라미터로 반환된 결과가 V_SUM_RESULT 변수에 저장됩니다.  
    -- DBMS_OUTPUT.PUT_LINE을 사용하여 25 + 36 = XX 형식으로 결과를 출력합니다.
    -- 이 함수는 문자열을 출력하기 위한 함수로, V_SUM_RESULT 변수에 저장된 값이 화면에 출력됩니다.
    DBMS_OUTPUT.PUT_LINE('25 + 36 = ' || V_SUM_RESULT);  -- "25 + 36 = 61"이 출력됩니다.
    -- PRO_FACTORY 프로시저를 호출하여 2의 5승 결과를 V_FACTORY_RESULT에 저장
    PRO_FACTORY(V_FACTORY_RESULT);  -- OUT 파라미터로 반환된 결과가 V_FACTORY_RESULT 변수에 저장됩니다.
    -- 2 ^ 5 = XX 형식으로 결과를 출력합니다.
    -- V_FACTORY_RESULT 변수에 저장된 값이 화면에 출력됩니다.
    DBMS_OUTPUT.PUT_LINE('2 ^ 5 = ' || V_FACTORY_RESULT);  -- "2 ^ 5 = 32"가 출력됩니다.
END;
/
-- PL/SQL 블록은 두 개의 프로시저를 순차적으로 호출하며, 그 결과를 '25 + 36 = XX'와 '2 ^ 5 = XX' 형식으로 출력합니다.
-- V_SUM_RESULT는 PRO_SUM에서 반환된 25 + 36 = 61을 저장하고, V_FACTORY_RESULT는 PRO_FACTORY에서 반환된 2의 5승 = 32를 저장하여 각각 출력합니다.

-- 다른 답안 : IN과 OUT을 사용하여 프로시저와 PL/SQL를 작성하시오.
-- 1. PRO_SUM 프로시저 생성
-- 두 개의 숫자(X와 Y)를 입력받아 그 합을 HAP에 저장하는 프로시저입니다.
-- IN 매개변수는 프로시저 내에서만 읽을 수 있고, IN OUT 매개변수는 값을 읽고 변경할 수 있습니다.
CREATE OR REPLACE PROCEDURE PRO_SUM
(
    X IN NUMBER,  -- 첫 번째 숫자 X를 입력받습니다.
    Y IN NUMBER,  -- 두 번째 숫자 Y를 입력받습니다.
    HAP IN OUT NUMBER -- X와 Y의 합을 저장할 변수로, 호출 시 전달받은 값이 수정됩니다.
)
IS
BEGIN
    HAP := X + Y; -- HAP에 X와 Y의 합을 저장합니다. 예를 들어, X=25, Y=36이라면 HAP에 61이 저장됩니다.
END PRO_SUM;
/

-- 2. PRO_FACTORY 프로시저 생성
-- 두 개의 숫자 X와 Y를 입력받아 X의 Y승을 계산한 후 MUL에 저장하는 프로시저입니다.
-- 이 프로시저는 power 함수를 사용하지 않고, FOR 루프를 사용하여 직접 제곱을 계산합니다.
CREATE OR REPLACE PROCEDURE PRO_FACTORY
(
    X IN NUMBER, -- 밑(base) 숫자 X를 입력받습니다.
    Y IN NUMBER, -- 지수(exponent) 숫자 Y를 입력받습니다.
    MUL OUT NUMBER -- X의 Y승을 저장할 변수로, 결과가 여기에 저장됩니다.
)
IS
BEGIN
    -- power(2, 5) 대신 FOR 루프를 사용해 제곱을 계산합니다.
    MUL := 1; -- 제곱을 계산할 때 초기값은 1로 설정합니다.
    
    -- FOR 루프는 1부터 Y까지 반복하며, 매번 MUL에 X를 곱합니다.
    -- 예를 들어, X=2, Y=5라면 2를 5번 곱하게 되어 32가 됩니다.
    FOR i IN 1..Y LOOP
        MUL := MUL * X; -- X를 MUL에 계속 곱하여 제곱값을 구합니다.
    END LOOP;   
END PRO_FACTORY;
/

-- 3. 프로시저 호출 및 결과 출력
-- 이 블록에서는 PRO_SUM과 PRO_FACTORY 프로시저를 호출하고, 각각의 결과를 출력합니다.
DECLARE
    HAP NUMBER; -- PRO_SUM 프로시저에서 사용할 HAP 변수를 선언합니다.
    X NUMBER := 2; -- X 변수에 초기값 2를 설정합니다. (PRO_FACTORY에서 사용됨)
    Y NUMBER := 5; -- Y 변수에 초기값 5를 설정합니다. (PRO_FACTORY에서 사용됨)
    MUL NUMBER; -- PRO_FACTORY 프로시저에서 사용할 MUL 변수를 선언합니다.
BEGIN
    -- PRO_SUM 프로시저 호출: 25와 36을 더하여 HAP에 저장합니다.
    PRO_SUM(25, 36, HAP); 
    -- HAP에는 25 + 36의 값인 61이 저장됩니다.

    -- PRO_FACTORY 프로시저 호출: X의 Y승, 즉 2의 5승을 계산하여 MUL에 저장합니다.
    PRO_FACTORY(X, Y, MUL);
    -- MUL에는 2^5의 값인 32가 저장됩니다.

    -- 결과 출력: HAP과 MUL의 값을 각각 출력합니다.
    DBMS_OUTPUT.PUT_LINE('25 + 36 = ' || HAP); -- '25 + 36 = 61'이 출력됩니다.
    DBMS_OUTPUT.PUT_LINE(X || ' ^ ' || Y || ' = ' || MUL); -- '2 ^ 5 = 32'가 출력됩니다.
END;
/

--요약
--PRO_SUM 프로시저: X와 Y라는 두 숫자를 입력받아 이 둘의 합을 HAP이라는 변수에 저장하는 프로시저입니다.
--HAP은 IN OUT 매개변수이므로 호출 전의 값을 전달받고, 계산된 결과를 다시 전달해 줍니다.
--
--PRO_FACTORY 프로시저: X와 Y를 입력받아 X^Y (X의 Y승)를 계산하여 MUL에 저장하는 프로시저입니다.
--FOR 루프를 사용하여 X를 Y번 곱하는 방식으로 제곱 계산을 합니다. 예를 들어, X=2, Y=5이면 2^5=32가 됩니다.
--
--익명 블록:
--PRO_SUM을 호출하여 25 + 36 = 61의 결과를 HAP에 저장하고 출력합니다.
--PRO_FACTORY를 호출하여 2^5 = 32의 결과를 MUL에 저장하고 출력합니다

-- ----------------------------------------------------------------------------
--2. 함수
--- 오라클 함수는 내장함수와 사용자 정의 함수로 나눌 수 있다.
--- 함수는 반환 값의 자료형과 실행부에서 반환할 값을 RETURN절 및 RETURN문으로 명시해야 한다.
-- 함수는 프로시저와 달리 값을 반환하는 목적으로 사용되며, 반환할 값의 자료형을 반드시 명시해야 한다.

--함수 생성 
--[형식]
--CREATE [OR REPLACE] FUNCTION 함수명 
--(
--파라미터 이름   [IN] 자료형 [ := | DEFAULT ], -- 프로시저와 달리 IN모드만 지정한다.
-- 파라미터는 오직 IN 모드로만 선언 가능하며, 입력된 값을 사용한다.
--파라미터 이름   [IN] 자료형 [ := | DEFAULT ], -- ;이 아니라 ,로 지정
-- 파라미터는 콤마(,)로 구분하여 여러 개를 선언할 수 있다.
--... 
--)
--RETURN 자료형  -- 반환 값의 자료형을 명시해야 한다. 함수는 값을 반환하는 것이 목적이므로, 반환되는 데이터의 타입을 지정한다.
--IS | AS 
--선언부
--BEGIN 
--실행부
--RETURN (반환값);  -- RETURN 문을 사용하여 반환할 값을 명시한다. 이 값은 함수의 호출자로 전달된다.
--EXCEPTION 
--예외 처리부
--END [함수 이름];
-- 이 형식에 따라 함수는 값을 계산하거나 처리하고 그 결과를 반환할 수 있다.

--[실습]
---- 함수 생성
-- 이번 실습에서는 세금을 계산하는 함수(FUNC_TAX)를 생성한다. 이 함수는 급여(SALARY)에서 세금(TAX)을 계산하여 결과를 반환한다.
CREATE OR REPLACE FUNCTION FUNC_TAX 
(
    SALARY IN NUMBER  -- SALARY라는 IN 모드 파라미터를 선언합니다. 이 파라미터는 NUMBER 자료형이며, 사용자가 제공하는 급여(예: 월급이나 연봉)를 의미합니다.
)
RETURN NUMBER  -- 이 함수는 NUMBER 자료형의 값을 반환합니다. 반환되는 값은 세금을 차감한 후의 최종 급여입니다.
IS
    TAX NUMBER := 0.033;  -- 세율(TAX)을 3.3%로 설정합니다. 이는 급여에서 차감할 세금 비율로, 세금 계산의 기준이 됩니다.
    -- TAX 변수는 고정된 세율인 3.3%를 나타내며, 이 값은 고정값으로 설정되어 있으므로 매 함수 호출 시 동일한 비율이 적용됩니다.
BEGIN
    -- 함수 본문 시작
    -- SALARY에서 3.3%의 세금을 차감한 값을 계산합니다.
    -- 세금은 SALARY * TAX로 계산되며, 이 값을 SALARY에서 빼면 세후 급여가 됩니다.
    -- SALARY - (SALARY * TAX) 식은 다음과 같이 동작합니다:
    -- 예를 들어, SALARY가 1,000,000원이라면 세금은 1,000,000 * 0.033 = 33,000원이 됩니다.
    -- 최종적으로 세후 급여는 1,000,000 - 33,000 = 967,000원이 됩니다. 
    -- ROUND 함수는 소수점 이하를 반올림하여 결과를 더 깔끔하게 만듭니다.
    -- 예를 들어, 계산 결과가 소수점 이하를 포함할 경우(예: 967,000.75원), ROUND 함수를 사용하여 소수점을 제거하고 967,001원으로 반올림합니다. 
    RETURN (ROUND(SALARY - (SALARY * TAX)));  -- 계산된 세후 급여를 반환합니다.
    -- SALARY에서 세금을 차감한 값을 반환하며, 이 값은 NUMBER 자료형입니다.
    -- 예시: SALARY = 1,000,000, TAX = 0.033일 때 최종적으로 반환되는 값은 967,000원이 됩니다.
END FUNC_TAX;
/
-- 이 함수는 세후 급여를 계산하여 반환하는 역할을 한다. SALARY를 입력받고, TAX를 적용한 후 그 결과를 반환한다.

-- PL/SQL 함수 실행
-- 이 부분은 PL/SQL 블록 내에서 함수를 호출하여 결과를 변수에 저장하고, 그 값을 출력하는 과정입니다.
DECLARE
    PAY NUMBER;  -- PAY 변수는 FUNC_TAX 함수가 반환하는 세후 급여를 저장하는 NUMBER 자료형의 변수입니다.
    -- 이 변수는 함수의 반환값을 받아 처리하기 위한 용도로 사용됩니다.
BEGIN
    -- PAY := FUNC_TAX(3000000);
    -- FUNC_TAX 함수에 급여로 3,000,000을 전달합니다.
    -- 이 함수는 전달된 급여에서 3.3%의 세금을 차감한 값을 반환합니다.
    -- 예를 들어, 급여가 3,000,000이라면, 세금 3.3%는 99,000이므로
    -- 세후 급여는 3,000,000 - 99,000 = 2,901,000이 됩니다.
    -- 이 결과 값이 PAY 변수에 저장됩니다.
    PAY := FUNC_TAX(3000000);       
    -- DBMS_OUTPUT.PUT_LINE('PAY : ' || PAY);
    -- DBMS_OUTPUT.PUT_LINE은 Oracle에서 결과를 출력하는 함수입니다.
    -- PAY 변수에 저장된 세후 급여를 출력합니다.
    -- 예를 들어, PAY가 2,901,000이라면 "PAY : 2901000"과 같이 출력됩니다.
    -- 이 함수는 주로 디버깅이나 확인을 위한 출력에 사용됩니다.
    DBMS_OUTPUT.PUT_LINE('PAY : ' || PAY);  -- 결과가 출력됩니다. 예: 'PAY : 2901000'
END;
/
-- 이 PL/SQL 블록은 FUNC_TAX 함수를 호출하여 세후 급여를 계산한 다음, 그 결과를 PAY 변수에 저장하고,
-- DBMS_OUTPUT.PUT_LINE을 통해 결과를 출력하는 기능을 수행합니다.

---- SQL문에서 함수 실행
-- PL/SQL 블록 외에도 함수를 SQL문에서 직접 호출할 수 있습니다.
-- 이 방식은 함수를 SQL 쿼리 내에서 사용하는 방법입니다.
-- SELECT FUNC_TAX(5000000) FROM DUAL;
-- 이 SQL문은 FUNC_TAX 함수를 호출하여 급여로 5,000,000을 전달합니다.
-- 함수는 전달된 급여에서 세금 3.3%를 차감한 금액을 반환합니다.
-- 예를 들어, 5,000,000의 급여에 대한 세금은 165,000원이므로,
-- 세후 급여는 5,000,000 - 165,000 = 4,835,000원이 됩니다.
-- 이 값이 SQL 쿼리의 결과로 반환됩니다.
SELECT FUNC_TAX(5000000) FROM DUAL;  -- 급여 5,000,000에 대한 세후 급여 계산 결과를 반환합니다.
-- 예상 출력은 "4835000"입니다. (세금 3.3% 차감 후)

---- 함수 삭제
-- 함수는 DROP FUNCTION 문을 사용하여 삭제할 수 있다. 이 문을 실행하면 데이터베이스에서 해당 함수가 삭제된다.
-- DROP FUNCTION FUNC_TAX;
-- 이 명령어는 데이터베이스에서 더 이상 해당 함수를 사용하지 않도록 제거하는 역할을 한다.

-- ------------------------------------------------------------------------
--3. 트리거 (Trigger)
-- 데이터베이스 안의 특정 상황이나 동작, 즉 이벤트가 발생하면 [자동]으로 실행되는 기능을 정의하는 PL/SQL 서브프로그램이다.
-- 테이블의 데이터를 특정 사용자가 변경하려 할 때 해당 데이터나 사용자 기록을 확인한다든지 상황에 따라 데이터를 변경하지 못하게 막는 것이 가능하다.
-- 트리거는 사용자가 직접 호출하는 것이 아니라, 특정 DML 명령어(INSERT, UPDATE, DELETE)가 실행될 때 자동으로 실행된다.

-- 트리거는 특정 이벤트가 발생할 때 자동으로 작동하는 서브프로그램이므로,
-- 프로시저, 함수와 같이 EXECUTE 또는 PL/SQL 블록에서 따로 실행하지 못한다.

-- DML 트리거
-- DML 트리거는 데이터 조작 언어(DML) 명령어(INSERT, UPDATE, DELETE)가 실행될 때 자동으로 실행되는 PL/SQL 코드입니다.
-- 주로 데이터의 무결성을 유지하거나, 특정 조건에서 추가 작업을 수행하기 위해 사용됩니다.

-- [형식]
-- CREATE [OR REPLACE] TRIGGER 트리거 이름 
-- 트리거를 생성할 때 사용하는 구문입니다. "CREATE TRIGGER"는 새로운 트리거를 생성하는 명령어입니다.
-- "OR REPLACE"는 이미 존재하는 트리거가 있을 경우, 해당 트리거를 새로운 정의로 교체합니다.
-- 트리거 이름은 사용자가 정의하는 트리거의 식별자 역할을 하며, 테이블 내에서 고유해야 합니다.

-- BEFORE | AFTER  
-- 트리거가 DML 명령어가 실행되기 전(BEFORE) 또는 후(AFTER)에 실행될지 지정합니다.
-- - BEFORE: 트리거가 지정된 DML 명령어가 실행되기 **전에** 실행됩니다. 예를 들어, 데이터를 삽입하기 전에 트리거가 먼저 실행되어 데이터 검증을 수행할 수 있습니다.
-- - AFTER: 트리거가 지정된 DML 명령어가 실행된 **후에** 실행됩니다. 예를 들어, 데이터가 삽입된 후 추가 로깅 작업을 수행할 수 있습니다.

-- INSERT | UPDATE | DELETE ON 테이블명  
-- 트리거가 실행될 DML 명령어와 해당 트리거가 적용될 테이블을 지정합니다.
-- - INSERT: 데이터가 테이블에 삽입될 때 트리거가 실행됩니다.
-- - UPDATE: 테이블의 데이터가 수정될 때 트리거가 실행됩니다.
-- - DELETE: 테이블에서 데이터가 삭제될 때 트리거가 실행됩니다.
-- 예를 들어, "INSERT OR UPDATE OR DELETE ON EMPLOYEES"는 EMPLOYEES 테이블에서 발생하는 모든 DML 작업에 대해 트리거가 실행됨을 의미합니다.

-- REFERENCING OLD as old | NEW as new  
-- 행 데이터의 이전 값(OLD) 또는 새 값(NEW)을 참조할 수 있습니다.
-- - OLD: 트리거가 실행되기 **전**의 행 데이터 값을 참조할 때 사용됩니다. 이는 UPDATE나 DELETE 작업에서 주로 사용됩니다. (INSERT에서는 의미가 없습니다.)
-- - NEW: 트리거가 실행된 **후**의 새로운 행 데이터 값을 참조할 때 사용됩니다. 이는 INSERT나 UPDATE 작업에서 주로 사용됩니다. (DELETE에서는 의미가 없습니다.)
-- 예를 들어, "OLD.SALARY"는 UPDATE나 DELETE 작업 전에 존재하던 급여 데이터를 참조하고, "NEW.SALARY"는 UPDATE나 INSERT 작업 후의 새 급여 데이터를 참조합니다.

-- FOR EACH ROW  
-- 이 옵션은 트리거가 **테이블의 각 행마다** 실행됨을 의미합니다.
-- 즉, DML 명령어가 여러 행을 수정할 때마다 각각의 행에 대해 트리거가 개별적으로 실행됩니다.
-- 행 단위 트리거로서, 테이블 단위 트리거와 구별됩니다.
-- 예를 들어, 10개의 행을 UPDATE하는 경우, 이 트리거는 10번 실행됩니다.

-- WHEN 조건식  
-- 트리거가 실행될 조건을 지정할 수 있습니다.
-- 특정 조건을 만족하는 경우에만 트리거가 실행되도록 할 수 있으며, 이는 WHERE 절과 유사한 역할을 합니다.
-- 예를 들어, "WHEN (NEW.SALARY > 5000)"은 새로 삽입되거나 업데이트된 급여가 5000보다 클 때만 트리거가 실행되도록 합니다.
-- 조건이 없을 경우 트리거는 DML 명령어가 실행될 때마다 항상 실행됩니다.

-- DECLARE 
-- 선언부는 트리거 내에서 사용될 변수, 상수, 커서 등을 선언할 수 있는 곳입니다.
-- 트리거가 실행되는 동안 필요한 데이터를 저장하기 위한 변수나 제어 구조를 선언합니다.

-- BEGIN
-- 실행부 
-- 트리거가 작동하는 핵심 부분으로, 여기서 특정 작업이 수행됩니다.
-- 예를 들어, 로그 기록, 데이터 검증, 계산, 예외 발생 등이 이 구문 내에서 이루어집니다.
-- 트리거는 DML 명령어가 실행되기 전이나 후에 데이터를 검증하거나 조작할 수 있습니다.

-- EXCEPTION
-- 예외 처리 
-- 실행부에서 오류가 발생할 경우 처리할 예외를 지정합니다.
-- 트리거 실행 중 오류가 발생하면, 이 블록에서 예외를 처리하여 프로그램이 비정상 종료되지 않도록 합니다.
-- 예를 들어, 발생할 수 있는 특정 예외에 대해 사용자 정의 메시지를 반환할 수 있습니다.

-- END;
-- 트리거의 종료를 명시합니다. PL/SQL 코드 블록의 끝을 나타내며, 트리거가 종료됩니다.

-- [실습]
-- ① BEFORE
--- DML 명령어가 실행하기 전에 작동하는 트리거가 생성됩니다.
-- BEFORE 트리거는 지정된 DML 명령어가 실행되기 **전에** 동작합니다.
-- 예를 들어, INSERT, UPDATE, DELETE 명령어가 실행되기 전에 트리거가 먼저 실행되어 조건에 따라 동작을 제어할 수 있습니다.
-- 이 실습에서는 주말에 데이터를 변경하지 못하게 막는 트리거를 생성합니다.

-- 기존 EMPLOYEES 테이블의 데이터를 복제하여 EMP_TAB 테이블을 만듭니다.
CREATE TABLE EMP_TAB AS SELECT * FROM EMPLOYEES;
-- EMPLOYEES 테이블의 모든 데이터를 EMP_TAB에 복사합니다. EMP_TAB은 EMPLOYEES 테이블과 동일한 구조를 갖습니다.

-- 테이블 데이터 확인
SELECT * FROM EMP_TAB;
-- EMP_TAB 테이블의 현재 데이터를 확인합니다.

-- 주말에 EMP_TAB 테이블에 대한 INSERT, UPDATE, DELETE 작업을 금지하는 트리거를 생성합니다.
-- 트리거는 특정 이벤트가 발생할 때 자동으로 실행되는 PL/SQL 코드입니다.
-- 이 트리거는 주말에 EMP_TAB 테이블에 데이터 변경 작업(INSERT, UPDATE, DELETE)을 막습니다.
CREATE OR REPLACE TRIGGER TRI_EMP_WEEKEND
-- EMP_TAB 테이블에 대한 DML 작업(INSERT, UPDATE, DELETE)이 실행될 때 트리거가 작동합니다.
BEFORE
INSERT OR UPDATE OR DELETE ON EMP_TAB 
-- 트리거가 작동하는 시점은 DML 명령어가 실행되기 **전**입니다.
FOR EACH ROW  -- 각 행에 대해 트리거가 실행됩니다.
BEGIN
    -- SYSDATE는 현재 시스템의 날짜와 시간을 반환하는 함수입니다.
    -- TO_CHAR 함수는 SYSDATE를 특정 형식으로 변환해줍니다. 여기서는 'DY' 포맷을 사용해 현재 요일을 문자열로 반환합니다.
    -- 요일이 토요일('토') 또는 일요일('일')일 경우, DML 작업이 금지됩니다.
    -- 참고로, 'DY' 포맷의 반환 값은 지역 설정에 따라 다를 수 있습니다. 한국어 설정에서는 '토', '일'이 반환됩니다.
    IF TO_CHAR(SYSDATE, 'DY') IN ('토', '일') THEN
        -- 주말에 INSERT 작업이 시도되는 경우
        IF INSERTING THEN
            -- RAISE_APPLICATION_ERROR는 사용자 정의 예외를 발생시키는 프로시저입니다.
            -- 여기서는 -20000번대의 오류 코드와 함께 사용자 정의 오류 메시지를 반환합니다.
            -- 이 코드에서는 '주말 사원정보 추가 불가'라는 메시지를 발생시키며, INSERT 작업을 중단시킵니다.
            RAISE_APPLICATION_ERROR(-20000, '주말 사원정보 추가 불가');
        -- 주말에 UPDATE 작업이 시도되는 경우
        ELSIF UPDATING THEN
            -- UPDATE 작업을 시도할 경우, -20001번 오류와 함께 '주말 사원정보 수정 불가'라는 메시지가 반환됩니다.
            -- 이 오류로 인해 UPDATE 작업이 중단됩니다.
            RAISE_APPLICATION_ERROR(-20001, '주말 사원정보 수정 불가');
        -- 주말에 DELETE 작업이 시도되는 경우
        ELSIF DELETING THEN
            -- DELETE 작업을 시도할 경우, -20002번 오류와 함께 '주말 사원정보 삭제 불가'라는 메시지가 반환됩니다.
            -- 이 오류로 인해 DELETE 작업이 중단됩니다.
            RAISE_APPLICATION_ERROR(-20002, '주말 사원정보 삭제 불가');
        -- 그 외의 경우에도 예외를 발생시킵니다.
        ELSE
            -- 예외 처리 시 조건이 잘못 설정되어 다른 작업이 발생할 경우를 대비하여 -20003번 오류와 함께 예외를 발생시킵니다.
            RAISE_APPLICATION_ERROR(-20003, '주말 사원정보 변경 불가');
        END IF;
    END IF; 
END;
/
-- 이 트리거는 주말(토, 일)에 EMP_TAB 테이블에 대해 INSERT, UPDATE, DELETE 작업을 시도할 때
-- 해당 작업을 막고, 사용자 정의 예외 메시지와 함께 오류를 발생시킵니다.
-- 평일에는 트리거가 조건을 만족하지 않으므로 DML 작업이 정상적으로 실행됩니다.

-- 트리거가 정상 작동하는지 확인해봅니다.
-- 먼저 평일에 DML 작업을 실행해봅니다. 이 작업은 주말이 아니므로 정상적으로 실행됩니다.
UPDATE EMP_TAB SET SALARY=30000 WHERE EMPLOYEE_ID = 100;
-- 이 UPDATE 작업은 평일에 실행될 때, 트리거의 조건을 만족하지 않으므로 정상적으로 수행됩니다.
-- 특정 사원의 급여를 30,000으로 수정하는 작업입니다.

-- 수정된 데이터를 다시 확인합니다.
SELECT * FROM EMP_TAB;

-- 시스템의 날짜를 주말로 변경하면 다음과 같은 오류가 발생하게 됩니다.
-- 주말에 수행하려고 하면, 트리거가 작동하여 DML 작업이 금지되고 예외가 발생합니다.
UPDATE EMP_TAB SET SALARY=24000 WHERE EMPLOYEE_ID = 100;
-- 오류 보고 -
-- ORA-20001: 주말 사원정보 수정 불가
-- ORA-06512: "HR.TRI_EMP_WEEKEND", 6행
-- ORA-04088: 트리거 'HR.TRI_EMP_WEEKEND'의 수행시 오류

-- 주말에 INSERT, DELETE도 실행하면 동일한 에러가 발생합니다.
-- 예를 들어, 주말에 사원 정보를 추가하거나 삭제하려고 하면 같은 방식으로 예외가 발생하고 작업이 중단됩니다.

--② AFTER
--- DML 명령어가 실행된 후에 작동하는 트리거가 생성됩니다.
-- AFTER 트리거는 DML 명령어가 실행된 **후**에 동작합니다.
-- 예를 들어, EMP_TAB에 데이터가 삽입, 수정, 삭제된 후에 트리거가 실행되어 로그를 기록할 수 있습니다.
-- 이 트리거는 데이터 변경 후 기록이 필요할 때 유용합니다.

-- EMP_TAB에 DML 명령어가 실행되면 EMP_TAB_LOG 테이블에 변경된 로그가 기록되도록 트리거를 생성합니다.

-- EMP_TAB 테이블에서 발생한 변경 내용을 기록하기 위한 로그 테이블을 생성합니다.
-- 이 로그 테이블은 변경된 데이터의 일부와 변경된 시점, 작업을 수행한 사용자를 기록합니다.
CREATE TABLE EMP_TAB_LOG(
    TABLENAME VARCHAR2(10),  -- 변경된 테이블 이름을 기록합니다. 여기서는 EMP_TAB이 변경된 테이블 이름이 됩니다.
    DML_TYPE VARCHAR2(10),   -- 실행된 DML 명령어 종류를 기록합니다. 예를 들어, 'INSERT', 'UPDATE', 'DELETE' 중 하나가 기록됩니다.
    EMPNO NUMBER(4),         -- 변경된 사원의 ID를 기록합니다. 해당 트리거가 작동한 행의 사원 번호입니다.
    EMPNAME VARCHAR2(30),    -- 변경 작업을 수행한 사용자의 이름을 기록합니다. 현재 세션에서 작업을 수행한 사용자 이름이 기록됩니다.
    CHANGE_DATE DATE         -- 변경 작업이 발생한 날짜와 시간을 기록합니다. SYSDATE 함수를 사용하여 현재 시간을 기록합니다.
);

-- 트리거를 생성하여 EMP_TAB 테이블에서 발생한 DML 작업이 EMP_TAB_LOG에 기록되도록 설정합니다.
-- 트리거는 테이블에서 DML 작업이 발생할 때 자동으로 실행되는 PL/SQL 블록입니다.
CREATE OR REPLACE TRIGGER TRI_EMP_LOG
-- EMP_TAB 테이블에 INSERT, UPDATE, DELETE 실행 후에 트리거가 작동합니다.
AFTER
INSERT OR UPDATE OR DELETE ON EMP_TAB 
-- 트리거는 각 행에 대해 실행됩니다. 즉, 하나의 DML 작업이 여러 행에 영향을 미치면 트리거도 각 행에 대해 각각 실행됩니다.
FOR EACH ROW  
BEGIN
    -- INSERT 작업일 때, 로그 테이블에 INSERT 작업을 기록합니다.
    IF INSERTING THEN  -- :NEW 참조를 통해 새로운 행의 값을 사용할 수 있습니다.
        INSERT INTO EMP_TAB_LOG 
        VALUES ('EMP_TAB',  -- EMP_TAB 테이블이 변경된 테이블임을 기록합니다.
                'INSERT',   -- INSERT 작업이 수행되었음을 기록합니다.
                :NEW.EMPLOYEE_ID,  -- 새로 추가된 행의 EMPLOYEE_ID를 기록합니다. :NEW는 INSERT 작업에서 새로 삽입된 행의 데이터를 참조합니다.
                SYS_CONTEXT('USERENV', 'SESSION_USER'),  -- SYS_CONTEXT 함수는 현재 세션과 관련된 정보를 반환합니다. 'SESSION_USER'는 현재 작업을 수행한 사용자의 이름을 반환합니다.
                SYSDATE);  -- SYSDATE 함수는 현재 날짜와 시간을 반환하며, 로그에 작업이 수행된 시각을 기록합니다.

    -- UPDATE 작업일 때, 로그 테이블에 UPDATE 작업을 기록합니다.
    ELSIF UPDATING THEN  -- :OLD와 :NEW 참조를 통해 변경 전과 변경 후의 값을 사용할 수 있습니다.
        INSERT INTO EMP_TAB_LOG 
        VALUES ('EMP_TAB',
                'UPDATE',  -- UPDATE 작업이 수행되었음을 기록합니다.
                :OLD.EMPLOYEE_ID,  -- 변경된 행의 EMPLOYEE_ID를 기록합니다. UPDATE에서는 변경 이전 행의 데이터는 :OLD로 참조됩니다.
                SYS_CONTEXT('USERENV', 'SESSION_USER'),  -- 현재 작업을 수행한 사용자의 이름을 기록합니다.
                SYSDATE);  -- 작업이 발생한 시간을 기록합니다.

    -- DELETE 작업일 때, 로그 테이블에 DELETE 작업을 기록합니다.
    ELSIF DELETING THEN  -- :OLD 참조를 통해 삭제된 행의 값을 사용할 수 있습니다.
        INSERT INTO EMP_TAB_LOG 
        VALUES ('EMP_TAB',
                'DELETE',  -- DELETE 작업이 수행되었음을 기록합니다.
                :OLD.EMPLOYEE_ID,  -- 삭제된 행의 EMPLOYEE_ID를 기록합니다. DELETE 작업에서는 삭제된 행의 이전 데이터를 :OLD로 참조합니다.
                SYS_CONTEXT('USERENV', 'SESSION_USER'),  -- 현재 작업을 수행한 사용자의 이름을 기록합니다.
                SYSDATE);  -- 작업이 발생한 시간을 기록합니다.
    END IF; 
END;
/
-- 이 트리거는 EMP_TAB에서 발생한 모든 DML 작업(INSERT, UPDATE, DELETE)을 감지하고, 
-- 그 작업에 대한 정보를 EMP_TAB_LOG 테이블에 기록하는 역할을 합니다.
-- 각 작업마다 로그 테이블에 해당 작업의 유형, 사원 번호, 작업을 수행한 사용자, 작업이 발생한 시간을 기록합니다.

-- 트리거가 정상 작동하는지 확인하기 위해 몇 가지 작업을 수행해봅니다.

-- INSERT 작업을 수행하여 트리거가 작동하는지 확인합니다.
-- 새로운 사원 정보를 EMP_TAB에 삽입합니다. 평일에는 이 작업이 정상적으로 추가됩니다.
-- (EMAIL은 NOT NULL 필드이므로 반드시 입력해야 합니다.)
INSERT INTO EMP_TAB(EMPLOYEE_ID, LAST_NAME, EMAIL, JOB_ID, HIRE_DATE) 
VALUES (9999, 'Test', 'Test', 'Test', SYSDATE);

-- 로그 테이블에 기록된 정보를 확인합니다.
SELECT * FROM EMP_TAB_LOG;  -- INSERT 작업에 대한 1개의 로그가 기록됩니다.

-- 동일한 사원 번호로 다시 추가해도 INSERT 작업이 EMP_TAB_LOG 테이블에 기록됩니다.
-- 트리거가 동일하게 작동하여 INSERT 작업이 로그에 기록됩니다.
INSERT INTO EMP_TAB(EMPLOYEE_ID, LAST_NAME, EMAIL, JOB_ID, HIRE_DATE) 
VALUES (9999, 'Test', 'Test', 'Test', SYSDATE);

-- 다시 한번 로그 테이블에 기록된 정보를 확인합니다.
SELECT * FROM EMP_TAB_LOG;  -- 이번에도 INSERT 작업에 대한 1개의 로그가 추가됩니다.

-- EMP_TAB에서 UPDATE 작업을 수행하면 트리거가 작동하여 UPDATE 작업이 로그 테이블에 기록됩니다.
-- 14개의 행이 MANAGER_ID = 100인 조건에 맞추어 SALARY 값이 35,000으로 수정됩니다.
UPDATE EMP_TAB SET SALARY=35000 WHERE MANAGER_ID = 100;

-- EMP_TAB 테이블의 변경된 데이터를 확인합니다.
SELECT * FROM EMP_TAB;
-- EMP_TAB 테이블에서 현재 저장된 데이터를 확인하는 쿼리입니다.
-- UPDATE 작업이 제대로 수행되었는지, 데이터가 정상적으로 수정되었는지 확인할 수 있습니다.

-- 로그 테이블에 기록된 정보를 확인합니다.
-- EMP_TAB 테이블에서 발생한 UPDATE 작업으로 인해 로그 테이블에 몇 개의 로그가 기록되었는지 확인합니다.
-- 이 UPDATE 작업으로 인해 14개의 로그가 추가되어야 합니다.
SELECT * FROM EMP_TAB_LOG;  -- 14개의 UPDATE 로그가 추가됩니다.
-- 로그 테이블은 각 DML 작업에 대한 정보를 기록합니다.
-- INSERT, UPDATE, DELETE가 실행될 때마다 해당 작업에 대한 기록이 EMP_TAB_LOG에 저장됩니다.

-- 트리거 관리
-- 트리거는 데이터베이스 내에서 특정 이벤트에 따라 자동으로 실행되는 PL/SQL 블록입니다.
-- 현재 생성된 트리거 목록을 확인할 수 있습니다.
SELECT * FROM USER_TRIGGERS;
-- USER_TRIGGERS 뷰는 현재 사용자가 소유한 모든 트리거에 대한 정보를 보여줍니다.
-- 여기서 생성된 트리거들의 이름, 상태(활성화 또는 비활성화 여부), 트리거가 동작하는 시점(BEFORE/AFTER) 등을 확인할 수 있습니다.

-- 트리거를 비활성화할 수 있습니다.
-- 비활성화된 트리거는 더 이상 작동하지 않으며, 해당 트리거가 실행되어야 하는 이벤트가 발생해도 트리거가 실행되지 않습니다.
ALTER TRIGGER TRI_EMP_LOG DISABLE;
-- 이 명령어는 TRI_EMP_LOG 트리거를 비활성화(disable)합니다.
-- 비활성화된 상태에서는 EMP_TAB 테이블에 대해 발생하는 DML 작업이 있어도 로그가 기록되지 않습니다.

-- 트리거가 비활성화되면 DML 작업이 수행되더라도 로그가 기록되지 않습니다.
-- 이제 트리거가 비활성화된 상태에서 EMP_TAB에 데이터를 수정해봅니다.
UPDATE EMP_TAB SET SALARY=50000 WHERE EMPLOYEE_ID = 9999;
-- 이 UPDATE 작업은 EMP_TAB 테이블의 데이터를 수정하지만, TRI_EMP_LOG 트리거가 비활성화된 상태이기 때문에
-- 로그 테이블에 기록되지 않습니다.

-- 로그 테이블을 다시 확인해봅니다.
SELECT * FROM EMP_TAB_LOG;  -- 로그가 생성되지 않음
-- 로그 테이블에 새로운 로그가 추가되지 않은 것을 확인할 수 있습니다. 트리거가 비활성화된 상태이기 때문에 로그가 기록되지 않습니다.

-- 트리거를 다시 활성화할 수 있습니다.
-- 비활성화된 트리거는 필요에 따라 다시 활성화하여 원래 기능을 수행하게 할 수 있습니다.
ALTER TRIGGER TRI_EMP_LOG ENABLE;
-- 이 명령어는 TRI_EMP_LOG 트리거를 활성화(enable)합니다.
-- 활성화된 상태에서는 EMP_TAB에 대해 발생하는 DML 작업이 있을 때마다 로그가 정상적으로 기록됩니다.

-- 트리거 삭제
-- 더 이상 필요 없는 트리거는 삭제할 수 있습니다.
-- DROP TRIGGER 명령어를 사용하여 트리거를 삭제하면, 해당 트리거는 데이터베이스에서 완전히 제거됩니다.
-- DROP TRIGGER TRI_EMP_LOG;
-- 트리거를 삭제하면, 이후 해당 트리거가 다시는 실행되지 않으며, 삭제된 트리거는 복구할 수 없습니다.

-- BEFORE 트리거:
-- BEFORE 트리거는 DML 작업이 실행되기 **전에** 실행됩니다.
-- 예를 들어, 주말에 발생하는 모든 DML 작업을 금지하도록 설정할 수 있습니다.
-- 이 트리거는 데이터가 변경되기 전에 조건을 검사하여, 조건에 따라 데이터 변경 작업을 중단할 수 있습니다.
-- RAISE_APPLICATION_ERROR를 사용하여 사용자 정의 오류 메시지를 반환하여 작업을 중단시키는 기능을 구현할 수 있습니다.

-- AFTER 트리거:
-- AFTER 트리거는 DML 작업이 완료된 **후에** 실행됩니다.
-- 이 트리거는 주로 로그 테이블에 변경 사항을 기록하는 데 사용됩니다.
-- 예를 들어, 각 작업(INSERT, UPDATE, DELETE)마다 로그 테이블에 해당 행을 삽입하여
-- 누가 언제 어떤 작업을 했는지를 기록하는데 유용합니다.

-- 트리거 관리:
-- 트리거는 ENABLE 또는 DISABLE 명령을 사용하여 활성화하거나 비활성화할 수 있습니다.
-- 필요에 따라 트리거를 일시적으로 중지하거나 재활성화할 수 있습니다.
-- 비활성화된 트리거는 관련 이벤트가 발생하더라도 작동하지 않으며, 다시 활성화할 때까지 대기 상태로 남아있습니다.

