use mydb;

create table member(
    name varchar(50) not null,
    id varchar(30) primary key,
    pwd varchar(80) not null,
    gender varchar(3),
    email1 varchar(20),
    email2 varchar(20),
    tel1 varchar(10),
    tel2 varchar(10),
    tel3 varchar(10),
    zipcode varchar(10),
    addr1 varchar(100),
    addr2 varchar(100),
    logtime date
);

insert into member(name, id, pwd, gender) values('홍길동', 'hong', '111', '0');

select * from member;


CREATE TABLE board(
    seq integer primary key auto_increment,
    -- 'seq'는 각 레코드의 고유번호를 저장하는 컬럼입니다.
    -- 'auto_increment'는 새로운 레코드가 삽입될 때마다 자동으로 고유 번호가 증가되도록 설정합니다.
    -- 'primary key'는 이 컬럼이 테이블에서 각 행을 고유하게 식별할 수 있음을 의미하며, 중복이 허용되지 않고 NULL 값을 가질 수 없습니다.

    id VARCHAR(20) NOT NULL,
    -- 'id'는 작성자의 아이디를 저장하는 컬럼입니다. 최대 20자의 문자열을 저장할 수 있으며, 반드시 값이 입력되어야 합니다. (NOT NULL 제약 조건)

    name VARCHAR(40) NOT NULL,
    -- 'name'은 작성자의 이름을 저장하는 컬럼입니다. 최대 40자의 문자열을 저장할 수 있으며, 반드시 값이 입력되어야 합니다. (NOT NULL 제약 조건)

    email VARCHAR(40),
    -- 'email'은 작성자의 이메일 주소를 저장하는 컬럼입니다. 최대 40자의 문자열을 저장할 수 있으며, NULL 값을 허용합니다.

    subject VARCHAR(255) NOT NULL,
    -- 'subject'는 게시글의 제목을 저장하는 컬럼입니다. 최대 255자의 문자열을 저장할 수 있으며, 반드시 값이 입력되어야 합니다. (NOT NULL 제약 조건)

    content VARCHAR(4000) NOT NULL,
    -- 'content'는 게시글의 본문 내용을 저장하는 컬럼입니다. 최대 4000자의 문자열을 저장할 수 있으며, 반드시 값이 입력되어야 합니다. (NOT NULL 제약 조건)

    ref integer,
    -- 'ref'는 게시글의 그룹 번호를 저장하는 컬럼입니다. 동일한 그룹에 속하는 게시글(답글 등)은 같은 'ref' 값을 가집니다.

    lev integer DEFAULT 0 NOT NULL,
    -- 'lev'는 글의 레벨(단계)을 나타내는 컬럼입니다. 기본값은 0이며, 0 이상의 값으로 레벨을 구분할 수 있습니다. (NOT NULL 제약 조건)

    step integer DEFAULT 0 NOT NULL,
    -- 'step'은 글의 순서를 나타내는 컬럼입니다. 같은 그룹(ref)에 속한 글들 사이에서 순서를 결정합니다. 기본값은 0이며, NULL 값을 허용하지 않습니다.

    pseq integer DEFAULT 0 NOT NULL,
    -- 'pseq'는 답글의 경우 원글의 번호를 나타냅니다. 답글이 아닌 원글일 경우 기본값인 0을 가집니다. (NOT NULL 제약 조건)

    reply integer DEFAULT 0 NOT NULL,
    -- 'reply'는 해당 게시글에 달린 답글의 수를 저장하는 컬럼입니다. 기본값은 0이며, NULL 값을 허용하지 않습니다.

    hit integer DEFAULT 0,
    -- 'hit'는 게시글의 조회수를 저장하는 컬럼입니다. 게시글이 조회될 때마다 증가하며, 기본값은 0입니다.

    logtime DATETIME DEFAULT now()
    -- 'logtime'은 게시글이 작성된 시간을 저장하는 컬럼입니다.
    -- 'DATETIME' 형식을 사용하여 날짜와 시간을 모두 기록하며, 기본값으로 'now()' 함수를 사용해 게시글이 삽입된 시점의 날짜와 시간이 자동으로 기록됩니다.
    -- 'DEFAULT now()'는 MySQL 5.6 이상 버전에서 지원됩니다.
    -- 또한 'DEFAULT current_timestamp'도 같은 기능을 수행하며, 레코드가 삽입될 때 현재 날짜와 시간이 자동으로 기록됩니다.
);

select * from board;



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





