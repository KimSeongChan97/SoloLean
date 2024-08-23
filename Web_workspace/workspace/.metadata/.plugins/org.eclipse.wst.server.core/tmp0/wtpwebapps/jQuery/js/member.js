$(function() {
    // 문서가 준비되면 즉시 실행될 jQuery 함수입니다.
    // $()는 jQuery의 기본 함수로, $(document).ready()와 동일한 역할을 수행합니다.
    // 즉, 문서의 DOM이 모두 로드된 후에 실행되도록 보장해줍니다.
    
    $('#join').submit(function() {
        // 사용자가 입력한 아이디를 가져옵니다.
        // input 태그에서 name 속성이 'user_id'인 값을 가져와 변수 user_id에 저장합니다.
        let user_id = $('input[name="user_id"]').val();
        
        // 만약 아이디가 비어 있다면 경고 메시지를 보여주고, 해당 입력란에 포커스를 맞춘 후 폼 제출을 막습니다.
        // if(!user_id){ 와 if(user_id == '') 의 차이는 사실 거의 없지만, 
        // 두 번째 조건은 값이 정확히 빈 문자열일 때만 동작하는 반면, 첫 번째 조건은 undefined, null, 빈 문자열 등 
        // 여러 값에 대해 참을 반환합니다. 여기서는 빈 문자열 체크를 위해 두 번째 방식 사용.
        if(user_id == '') {
            // 빈 문자열이거나 공백일 경우 경고창을 띄웁니다.
            alert("아이디를 입력하세요.");
            // 포커스를 아이디 입력란으로 이동
            $('input[name=user_id]').focus(); // 아이디 입력 필드에 다시 포커스를 맞춥니다.
            return false; // 폼 제출을 막기 위해 false 반환
        }
        
        // 비밀번호 입력란에서 값을 가져옵니다.
        let user_pw = $('input[name="user_pw"]').val();
        
        // 비밀번호가 없을 경우 경고 메시지를 출력하고 폼 제출을 막습니다.
        if(!user_pw) {
            // 비밀번호 필드가 비어 있을 경우 경고 메시지를 띄웁니다.
            alert("비밀번호를 입력하세요.");
            // 포커스를 비밀번호 입력란으로 이동
            $('input[name=user_pw]').focus(); // 비밀번호 입력 필드로 다시 포커스를 맞춥니다.
            return false; // 폼 제출 방지
        }
        
        // 성별 라디오 버튼 중 하나라도 선택되었는지 확인합니다.
        if(!$('input[name="gender"]').is(':checked')) {
            // 성별 라디오 버튼이 체크되지 않았을 때 경고 메시지를 띄웁니다.
            alert("성별을 입력하세요.");
            
            // 성별을 선택하지 않은 경우, 기본값으로 첫 번째 성별(남성)을 선택하게 설정합니다.
            // radio는 배열로 취급되며, 0은 첫 번째 선택지(남자)를 의미합니다.
            $('input[name="gender"]:eq(0)').attr('checked', true); // 남성(첫 번째 옵션)을 기본 선택합니다.
            
            return false; // 폼 제출 방지
        }
        
        // 이메일 입력란에서 값을 가져옵니다.
        var email = $('input[name="email"]').val();
        // 이메일이 입력되지 않았을 경우 경고 메시지 출력
        if(!email) {
            // 이메일 필드가 비어 있을 경우 경고 메시지를 띄웁니다.
            alert("이메일을 입력하세요.");
            // 포커스를 이메일 입력란으로 이동
            $('input[name="email"]').focus(); // 이메일 입력 필드로 포커스를 맞춥니다.
            return false; // 폼 제출 방지
        }

        // URL 입력란에서 값을 가져옵니다.
        var url = $('input[name="url"]').val();
        // URL이 입력되지 않았을 경우 경고 메시지 출력
        if(!url) {
            // URL 필드가 비어 있을 경우 경고 메시지를 띄웁니다.
            alert("URL을 입력하세요.");
            // 포커스를 URL 입력란으로 이동
            $('input[name="url"]').focus(); // URL 입력 필드로 포커스를 맞춥니다.
            return false; // 폼 제출 방지
        }
        
        // 핸드폰 번호 입력란에서 값을 가져옵니다.
        var phone = $('input[name="phone"]').val();
        // 핸드폰 번호가 입력되지 않았을 경우 경고 메시지 출력
        if(!phone) {
            // 핸드폰 번호 필드가 비어 있을 경우 경고 메시지를 띄웁니다.
            alert("핸드폰 번호를 입력하세요.");
            // 포커스를 핸드폰 입력란으로 이동
            $('input[name="phone"]').focus(); // 핸드폰 번호 입력 필드로 포커스를 맞춥니다.
            return false; // 폼 제출 방지
        }
        
        // 취미 선택란에서 하나 이상 체크되었는지 확인합니다.
        if(!$('input[name="hobby"]').is(':checked')) {
            // 취미가 하나도 체크되지 않았을 경우 경고 메시지를 띄웁니다.
            alert("취미를 선택하세요.");
            // 기본적으로 두 번째 취미(배열 인덱스 1)를 선택하도록 설정합니다.
            $('input[name="hobby"]:eq(1)').attr('checked', true); // 두 번째 취미 항목을 기본으로 선택합니다.
            return false; // 폼 제출 방지
        }
        
        // 직업 선택란에서 선택된 옵션의 인덱스를 확인합니다. 0번째는 기본 선택(선택 안 함)입니다.
        if($('select[name="job"] > option:selected').index() == 0) {
            // 직업이 선택되지 않았을 경우 경고 메시지를 띄웁니다.
            alert("직업을 선택하세요.");
            // 기본값으로 두 번째 옵션(인덱스 1)을 선택하게 설정합니다.
            $('select[name="job"] > option:eq(1)').attr('selected', true); // 두 번째 직업 옵션을 기본 선택으로 설정합니다.
            return false; // 폼 제출 방지
        }
        
        // 이제 모든 입력이 유효하므로 입력된 데이터를 화면에 출력합니다.
        // 성별의 체크된 값을 가져옵니다.
        let gender = $('input[name="gender"]:checked').val(); // 성별 라디오 버튼 중 체크된 항목의 값을 가져옵니다.
        
        // 취미는 여러 개 선택 가능하므로, 체크된 취미 항목을 배열로 가져옵니다.
        let hobby = $('input[name="hobby"]:checked'); // 취미 항목은 배열 형태로 저장됩니다.
        let hobby_val = ''; // 선택된 취미를 저장할 변수입니다.
        
        // 선택된 취미들을 순회하면서 값을 hobby_val에 추가합니다.
        hobby.each(function() {
            hobby_val += $(this).val() + ", "; // 각 취미 값을 hobby_val에 추가하고 쉼표로 구분합니다.
        });
        
        // 선택된 직업 값을 가져옵니다.
        let job = $('select[name="job"] > option:selected').val(); // 선택된 직업 옵션의 값을 가져옵니다.
        
        // 입력된 내용을 ul 태그로 구성하여 화면에 출력합니다.
        let result = `<ul>
                        <li>아이디 : ` + user_id + `</li>
                        <li>비밀번호 : ` + user_pw + `</li>
                        <li> 성별 : ` +  gender  + `</li>
                        <li> 이메일 : ` + email + `</li>
                        <li> 홈페이지 : ` + url + `</li>
                        <li> 핸드폰 : ` + phone + `</li>
                        <li> 취미 : ` +  hobby_val + `</li>
                        <li> 직업 : ` + job + `</li>
                    </ul>`;
        
        // 결과를 페이지의 body 부분에 출력하여 기존 내용을 대체합니다.
        // $('body').html(result)는 body 태그 안의 기존 내용을 모두 지우고 새롭게 result로 채웁니다.
        $('body').html(result);
        
        return false; // 폼 제출을 막고, 페이지가 리프레시되지 않도록 설정합니다.
    });
});
