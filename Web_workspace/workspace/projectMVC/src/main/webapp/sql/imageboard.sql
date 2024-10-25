-- [테이블] Oracle
CREATE TABLE imageboard(
    seq NUMBER PRIMARY KEY, 
    -- seq: 각 레코드의 고유번호를 저장하는 컬럼으로, PRIMARY KEY로 지정되어 있음.
    -- PRIMARY KEY: 테이블에서 각 행을 고유하게 식별할 수 있는 값. 중복이 허용되지 않고, NULL 값을 가질 수 없음.
    
    imageId VARCHAR2(20) UNIQUE, 
    -- imageId: 상품코드를 저장하는 컬럼으로, 최대 20자의 문자열을 저장할 수 있음.
    -- UNIQUE: 이 컬럼의 값은 테이블 내에서 중복될 수 없음. 즉, 각 상품코드는 유일해야 함.
    
    imageName VARCHAR2(40) NOT NULL, 
    -- imageName: 상품명을 저장하는 컬럼으로, 최대 40자의 문자열을 저장할 수 있음.
    -- NOT NULL: 반드시 값이 입력되어야 하는 컬럼. NULL 값을 허용하지 않음.
    
    imagePrice NUMBER NOT NULL, 
    -- imagePrice: 상품의 단가(가격)를 저장하는 컬럼으로, 숫자 값을 가짐.
    -- NOT NULL: 가격은 반드시 입력되어야 하며, NULL 값이 허용되지 않음.

    imageQty NUMBER NOT NULL, 
    -- imageQty: 상품의 수량을 저장하는 컬럼으로, 숫자 값을 가짐.
    -- NOT NULL: 상품의 수량 역시 반드시 입력되어야 하며, NULL 값을 가질 수 없음.

    imageContent VARCHAR2(4000) NOT NULL, 
    -- imageContent: 상품에 대한 설명이나 내용을 저장하는 컬럼으로, 최대 4000자의 문자열을 저장할 수 있음.
    -- NOT NULL: 이 컬럼도 반드시 값이 입력되어야 함.

    image1 varchar2(200), 
    -- image1: 상품과 연관된 이미지를 저장하는 컬럼으로, 최대 200자의 문자열을 저장할 수 있음.
    -- 이미지 URL이나 파일 경로를 저장하는 용도로 사용될 수 있음. NOT NULL 제약조건이 없으므로, 값이 없을 수 있음.

    logtime DATE DEFAULT SYSDATE
    -- logtime: 레코드가 생성된 시간을 저장하는 컬럼으로, 날짜 값을 가짐.
    -- DEFAULT SYSDATE: 레코드가 삽입될 때 자동으로 현재 날짜와 시간이 입력됨.
);

-- [시퀀스]
CREATE SEQUENCE seq_imageboard NOCACHE NOCYCLE;
    -- NOCACHE: 시퀀스 값을 미리 캐시하지 않도록 설정. 캐시를 사용하지 않으면, 시퀀스 값이 하나씩 생성될 때마다 즉시 디스크에 기록됨. 
    -- NOCYCLE: 시퀀스가 최대값에 도달했을 때, 다시 시작하지 않도록 설정. 즉, 시퀀스 값은 반복되지 않음.
    -- 이 시퀀스를 사용하면 `seq_imageboard.NEXTVAL`을 통해 고유한 순차적인 숫자 값을 생성할 수 있음.

select * from imageboard;

-- 
-- [테이블] MySQL
CREATE TABLE imageboard(
    seq integer primary key auto_increment, 
    -- 'seq'는 각 레코드의 고유번호를 저장하는 컬럼입니다.
    -- 'auto_increment'는 새로운 레코드가 삽입될 때 자동으로 고유 번호가 증가되도록 합니다.
    -- 'primary key'는 이 컬럼이 테이블에서 각 행을 고유하게 식별할 수 있음을 의미하며, 중복이 허용되지 않고 NULL 값을 가질 수 없습니다.
    
    imageId VARCHAR(20) UNIQUE, 
    -- 'imageId'는 상품 코드를 저장하는 컬럼으로, 최대 20자의 문자열을 저장할 수 있습니다.
    -- 'UNIQUE' 제약 조건이 적용되어 있어, 이 컬럼의 값은 테이블 내에서 중복될 수 없습니다. 즉, 각 상품 코드는 유일해야 합니다.
    
    imageName VARCHAR(40) NOT NULL, 
    -- 'imageName'은 상품명을 저장하는 컬럼으로, 최대 40자의 문자열을 저장할 수 있습니다.
    -- 'NOT NULL' 제약 조건이 적용되어 있어, 반드시 값이 입력되어야 하며 NULL 값을 허용하지 않습니다.
    
    imagePrice int NOT NULL, 
    -- 'imagePrice'는 상품의 가격을 저장하는 컬럼입니다. 정수형(int) 값을 가지며, 반드시 입력되어야 합니다.
    -- 'NOT NULL' 제약 조건이 있어, 이 값은 NULL 값을 허용하지 않습니다.

    imageQty int NOT NULL, 
    -- 'imageQty'는 상품의 수량을 저장하는 컬럼입니다. 정수형(int) 값을 가지며, 반드시 입력되어야 합니다.
    -- 'NOT NULL' 제약 조건이 있어, 수량 값도 NULL 값을 가질 수 없습니다.

    imageContent VARCHAR(4000) NOT NULL, 
    -- 'imageContent'는 상품에 대한 설명이나 내용을 저장하는 컬럼으로, 최대 4000자의 문자열을 저장할 수 있습니다.
    -- 'NOT NULL' 제약 조건이 적용되어 있어, 이 컬럼도 반드시 값이 입력되어야 합니다.

    image1 varchar(200), 
    -- 'image1'은 상품과 관련된 이미지의 파일 경로나 URL을 저장하는 컬럼입니다. 최대 200자의 문자열을 저장할 수 있습니다.
    -- 이 컬럼은 NULL 값을 허용하므로, 이미지가 반드시 존재하지 않아도 됩니다.

    logtime DATE DEFAULT (current_date)
    -- 'logtime'은 레코드가 생성된 날짜를 저장하는 컬럼입니다.
    -- 'DATE' 데이터 형식을 사용하며, 기본값으로 'current_date'를 사용하여 레코드가 삽입된 날짜(년-월-일)를 기록합니다.
    -- 'current_date'는 현재 날짜만을 반환하며, 시간이 포함되지 않습니다.
);
