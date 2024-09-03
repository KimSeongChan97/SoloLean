-- 테이블 생성: guestbook (방명록 테이블)
create table guestbook (
    seq number primary key,            -- seq 필드: 방명록 항목의 고유 식별자입니다. 
                                       -- 숫자형 데이터 타입을 사용하며, primary key로 설정되어 각 레코드가 고유해야 합니다.
                                       -- 이 필드는 시퀀스 객체인 seq_guestbook으로부터 값을 자동으로 받아옵니다.

    name varchar2(30),                 -- name 필드: 방명록 작성자의 이름을 저장하는 필드입니다.
                                       -- 최대 30자의 문자열을 저장할 수 있습니다.
                                       -- 이 필드는 필수 입력 항목이 아니므로 null 값을 가질 수 있습니다.

    email varchar2(30),                -- email 필드: 작성자의 이메일 주소를 저장하는 필드입니다.
                                       -- 최대 30자의 문자열을 저장할 수 있습니다.
                                       -- 이 필드 역시 필수 입력 항목이 아니므로 null 값을 가질 수 있습니다.

    homepage varchar2(35),             -- homepage 필드: 작성자의 홈페이지 URL을 저장하는 필드입니다.
                                       -- 최대 35자의 문자열을 저장할 수 있습니다.
                                       -- 필수 입력 항목이 아니므로 null 값을 가질 수 있습니다.

    subject varchar2(500) not null,    -- subject 필드: 방명록 항목의 제목을 저장하는 필드입니다.
                                       -- 최대 500자의 문자열을 저장할 수 있으며, 이 필드는 null 값을 가질 수 없습니다.
                                       -- 따라서 반드시 값이 입력되어야 합니다.

    content varchar2(4000) not null,   -- content 필드: 방명록 항목의 내용을 저장하는 필드입니다.
                                       -- 최대 4000자의 문자열을 저장할 수 있으며, 이 필드 또한 null 값을 가질 수 없습니다.
                                       -- 따라서 방명록 항목 작성 시 반드시 내용이 입력되어야 합니다.

    logtime date                       -- logtime 필드: 방명록 항목이 작성된 시간을 저장하는 필드입니다.
                                       -- 날짜 및 시간 정보를 저장하는 date 데이터 타입을 사용합니다.
                                       -- null 값을 가질 수 있으며, 기본적으로 이 필드에는 방명록이 작성된 시간을 기록합니다.
);

-- 시퀀스 생성: seq_guestbook (guestbook 테이블의 seq 필드에 값을 제공)
create sequence seq_guestbook
    nocycle                            -- nocycle 옵션: 시퀀스 값이 최대값에 도달해도 다시 처음으로 되돌아가지 않습니다.
    nocache;                           -- nocache 옵션: 시퀀스 값이 캐시되지 않으며, 매번 시퀀스를 생성할 때마다 값을 생성합니다.
                                       -- 이 시퀀스는 guestbook 테이블의 primary key인 seq 필드에 고유한 값을 제공합니다.

select * from guestbook; 

-- 이 쿼리는 게스트북 테이블에서 순번(seq)을 기준으로 내림차순으로 정렬된 데이터 중,
-- 첫 번째부터 세 번째까지의 데이터를 선택하는 데 사용됩니다
select * from -- 최종적으로 모든 열의 데이터를 선택합니다.
(select rownum rn, tt.* from -- 서브쿼리에서 rownum을 사용하여 각 행에 번호를 매깁니다.
(select * from guestbook order by seq desc) -- guestbook 테이블의 모든 데이터를 seq 기준으로 내림차순 정렬하여 가져옵니다.
tt ) -- 서브쿼리의 결과에 별칭 tt를 부여하여 이후 참조할 수 있도록 합니다.
where rn>= 1 and rn <=3; -- 행 번호 rn이 1에서 3 사이인 행을 선택합니다.

select count(*) from guestbook;
