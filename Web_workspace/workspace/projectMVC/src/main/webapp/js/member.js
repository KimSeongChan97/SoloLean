// 아이디 중복 체크 (사용자가 입력한 아이디의 중복 여부를 확인)
$('#id').focusout(function(){  
    // 아이디 입력 필드에서 포커스가 벗어날 때 실행되는 이벤트 핸들러
    $('#idDiv').empty(); // idDiv 초기화 (아이디 중복 확인 메시지 영역)
    // 사용자가 아이디 입력 후 포커스가 벗어나면 자동으로 중복 체크를 시작합니다.
    // 빈 메시지 영역을 다시 초기화하여 이전의 결과를 지워줍니다.
    
    if($('#id').val() == '')  // 아이디 입력 필드가 비어 있을 경우
        $('#idDiv').html('먼저 아이디를 입력하세요').css('color', 'cyan');  
        // idDiv에 아이디를 먼저 입력하라는 메시지를 출력하고, 글자색을 cyan으로 설정
        // 사용자가 아무것도 입력하지 않고 포커스를 벗어나면 해당 경고 메시지를 출력하며
        // 이 메시지의 글자색은 쉽게 눈에 띄도록 cyan으로 설정함.
    
    else
        // 아이디가 입력된 경우, AJAX를 사용하여 서버에 중복 체크 요청을 보냄
        $.ajax({
            type: 'post',  // HTTP POST 메서드를 사용하여 서버에 데이터를 보냄
            url: '/projectMVC/member/checkId.do',  
            // 아이디 중복 체크를 처리할 서버 페이지 경로
            data: 'id=' + $('#id').val(),  
            // 서버로 보낼 데이터 (id=값 형식). 사용자가 입력한 아이디를 서버로 전달
            // 사용자가 입력한 값을 서버로 넘기기 위해 'id=' + $('#id').val()로 직렬화하여 서버에 전달함.
            dataType: 'text',  // 서버로부터 응답받을 데이터 형식은 텍스트
            // 서버에서 받을 데이터는 텍스트 형식으로 지정됨.
            
            success: function(data){  
                // 서버로부터 응답이 성공적으로 왔을 때 실행되는 함수
                // 서버로부터 중복 여부에 대한 결과를 받으면 이 함수가 실행됨.
                // 디버깅을 위한 alert(data.trim());  // 서버에서 받은 데이터를 확인하는 디버깅 코드 (실제 동작에서는 주석 처리됨)
                // 디버깅용 alert 코드를 통해 응답 데이터를 확인할 수 있음. 
                
                if(data.trim() == 'exist'){  
                    // 서버에서 받은 데이터가 'exist'라면, 즉 아이디가 이미 존재할 경우
                    // 응답 데이터가 'exist'라면 해당 아이디는 이미 존재함을 의미.
                    $('#idDiv').html('사용 불가능한 아이디').css('color', 'red');  
                    // idDiv에 '사용 불가능한 아이디' 메시지를 출력하고, 글자색을 빨간색으로 설정
                    // 빨간색으로 글자색을 설정하여 경고의 의미를 더 강조함.
                } else {  
                    // 아이디가 존재하지 않을 경우
                    // 서버에서 'exist'가 아닌 다른 값을 받으면 아이디는 사용 가능함을 의미.
                    $('#idDiv').html('사용 가능한 아이디').css('color', 'blue');  
                    // idDiv에 '사용 가능한 아이디' 메시지를 출력하고, 글자색을 파란색으로 설정
                    // 파란색으로 설정하여 사용 가능한 상태임을 명확히 표시함.
                    $('#check').val($('#id').val());  
                    // 중복 체크 완료 후, 체크된 아이디 값을 hidden 필드에 설정 (아이디 중복 체크 상태 저장)
                    // hidden 필드인 'check'에 중복 확인된 아이디 값을 저장해, 유효성 검사를 위한 정보로 사용됨.
                }
            },
            error: function(e){  // 서버 요청이 실패했을 경우 실행되는 함수
                console.log(e);  // 오류 내용을 콘솔에 출력
                // 서버 요청이 실패하면 오류 내용을 콘솔에 출력하여 개발자가 디버깅할 수 있도록 함.
            }
        });
});

// 이메일 도메인 자동 입력 기능
function change() {
    document.getElementById("email2").value = document.getElementById("email3").value;  
    // 사용자가 선택한 이메일 도메인을 email2 입력란에 자동으로 채워줌
    // 이메일 입력 시 도메인을 따로 입력하지 않고 드롭다운 목록에서 선택하게 만들기 위한 기능
    // 예: 사용자가 'naver.com'을 선택하면 'email2'에 'naver.com'이 자동으로 입력됨
    
    // 이 함수는 사용자가 선택한 이메일 도메인(email3)을 자동으로 email2 필드에 넣어주는 기능입니다.
    // 사용자는 도메인 필드를 직접 입력할 필요가 없으며, 선택만 하면 되기 때문에 사용자 경험을 향상시킵니다.
}

// 회원가입 데이터 유효성 검사
function checkWrite() {
    document.getElementById("nameDiv").innerHTML = "";  // nameDiv 초기화 (이름 입력 메시지 출력 영역)
    document.getElementById("idDiv").innerHTML = "";    // idDiv 초기화 (아이디 입력 메시지 출력 영역)
    document.getElementById("pwdDiv").innerHTML = "";   // pwdDiv 초기화 (비밀번호 입력 메시지 출력 영역)
    // 위의 세 줄은 각 필드의 메시지 출력 영역을 비워줍니다.
    // 즉, 이전에 출력된 메시지가 있다면 그것을 지워 초기 상태로 만듭니다.
    
    // 이름 입력 확인
    if(document.writeForm.name.value == "")  // form 태그의 name 필드에 입력된 값이 없을 경우
        document.getElementById("nameDiv").innerHTML = "이름 입력";  
        // nameDiv에 이름을 입력하라는 메시지 출력
        // 사용자가 이름을 입력하지 않고 폼을 제출하려고 할 때 경고 메시지를 출력해 유효성 검사
        // 이름 필드는 필수 입력값이므로 값이 비어 있을 때 경고 메시지를 출력하여 사용자에게 알립니다.
    
    // 아이디 입력 확인
    else if(document.getElementById("id").value == "")  
        // id 필드에 입력된 값이 없을 경우
        document.getElementById("idDiv").innerHTML = "아이디 입력";  
        // idDiv에 아이디를 입력하라는 메시지 출력
        // 사용자에게 필수 입력 필드임을 알림
        // 아이디 역시 필수 항목이므로 입력되지 않으면 경고 메시지를 출력합니다.
    
    // 비밀번호 입력 확인
    else if(document.getElementById("pwd").value == "")  
        // 비밀번호 입력 필드에 값이 없을 경우
        document.getElementById("pwdDiv").innerHTML = "비밀번호 입력";  
        // pwdDiv에 비밀번호를 입력하라는 메시지 출력
        // 비밀번호도 필수 입력 항목으로, 비어 있으면 메시지를 출력해 사용자가 이를 인식할 수 있게 합니다.
    
    // 비밀번호와 비밀번호 확인 값 일치 여부 확인
    else if(document.getElementById("pwd").value != document.getElementById("repwd").value)  
        // 비밀번호와 비밀번호 확인 필드 값이 다를 경우
        document.getElementById("pwdDiv").innerHTML = "비밀번호가 맞지 않습니다.";  
        // pwdDiv에 비밀번호가 일치하지 않는다는 메시지 출력
        // 비밀번호와 확인용 비밀번호가 다르면 제출을 막고 경고 메시지를 출력합니다.
    
    // 아이디 중복 체크 여부 확인
    else if(document.getElementById("id").value != document.getElementById("check").value)  
        // 아이디 중복 체크를 하지 않았을 경우
        document.getElementById("idDiv").innerHTML = "중복체크 하세요";  
        // idDiv에 아이디 중복 체크를 하라는 메시지 출력
        // 사용자가 중복 체크를 하지 않고 제출하려고 할 때 경고
        // 중복 체크는 회원가입의 필수 과정이므로, 체크하지 않았다면 경고 메시지를 출력합니다.
    
    else 
        // 모든 조건이 만족되면 회원가입 폼을 서버로 제출 (submit)
        // 모든 유효성 검사를 통과한 후 폼이 서버로 전송됨
        // 여기서 submit() 호출 대신 AJAX를 사용해 비동기식으로 폼 데이터를 전송하고 결과를 처리합니다.
		
		$.ajax({
			type: 'post',  // HTTP POST 메서드를 사용하여 서버에 데이터를 전송
			url: '/projectMVC/member/write.do',  // 폼 데이터가 전송될 서버 경로
			data: $('#writeForm').serialize(),  // 폼 데이터를 직렬화하여 전송
			// form 데이터를 직렬화하여 전송하는 것은 해당 form의 모든 입력값을 "name=value" 쌍으로 서버에 전달함을 의미합니다.
			success: function(){  // 서버로부터 성공적인 응답을 받았을 때 실행
				alert("회원가입을 축하합니다.");  // 성공 메시지를 사용자에게 알림
				location.href = '/projectMVC/index.jsp';  // 회원가입이 완료되면 메인 페이지로 이동
			},
			error: function(e){  // 서버로부터 응답이 실패했을 때 실행
				console.log(e);  // 콘솔에 오류 내용을 출력
			}			
		});
}

// 회원정보 수정 (회원 정보를 수정하는 기능)
$('#updateBtn').click(function(){  
    // '회원정보 수정' 버튼 클릭 시 실행되는 이벤트 핸들러
    $('#nameDiv').empty();  // nameDiv 초기화 (이름 입력 메시지 영역)
    $('#pwdDiv').empty();   // pwdDiv 초기화 (비밀번호 입력 메시지 영역)
    // 위의 두 줄은 기존의 메시지 출력을 제거하여 사용자가 새로 입력한 정보에 대해 다시 유효성 검사를 하도록 합니다.
    
    if($('#name').val() == '')  // 이름 입력 필드가 비어있을 경우
        $('#nameDiv').html('이름 입력');  
        // nameDiv에 이름을 입력하라는 메시지 출력
        // 이름이 필수 입력 값임을 알리기 위해 메시지를 출력합니다.
    
    else if($('#pwd').val() == '')  // 비밀번호 입력 필드가 비어있을 경우
        $('#pwdDiv').html('비밀번호 입력');  
        // pwdDiv에 비밀번호를 입력하라는 메시지 출력
        // 비밀번호 필드가 비어있을 때 메시지를 출력하여 비밀번호 입력을 유도합니다.
    
    else if($('#pwd').val() != $('#repwd').val())  
        // 비밀번호와 비밀번호 확인 필드 값이 일치하지 않을 경우
        $('#pwdDiv').html('비밀번호가 맞지 않습니다');  
        // pwdDiv에 비밀번호가 일치하지 않는다는 메시지 출력
        // 비밀번호가 일치하지 않으면 제출을 막고 경고 메시지를 출력합니다.
    
    else
        // 모든 조건이 충족되었을 때 AJAX 요청을 통해 회원 정보 수정 데이터를 서버에 전달
        $.ajax({
            type: 'post',  // HTTP POST 메서드를 사용하여 서버에 데이터를 보냄
            url: '/projectMVC/member/update.do',  // 서버로 데이터를 전송할 URL
            data: $('form[name="updateForm"]').serialize(),  // form 데이터를 직렬화하여 서버에 전송
            success: function(){  // 서버로부터 응답이 성공적으로 왔을 때 실행
                alert('회원정보 수정 완료');  // 수정 완료 메시지를 사용자에게 알림
                location.href = '/projectMVC/index.do';  // 수정이 완료되면 메인 페이지로 이동
            },
            error: function(e){  // 서버로부터 응답이 실패했을 때 실행
                console.log(e);  // 콘솔에 오류 내용을 출력
            }
        });
});

// 우편번호 찾기 - Daum API를 사용하여 주소를 검색하고 우편번호와 주소를 자동으로 채움
function checkPost() {
    new daum.Postcode({  // Daum의 우편번호 API를 호출하여 새로운 우편번호 검색 팝업을 엶
        oncomplete: function(data) {  
            // 사용자가 검색결과에서 주소를 선택했을 때 실행되는 콜백 함수
            // 사용자가 주소를 선택하면 'oncomplete' 콜백이 호출되어 아래 작업이 수행됨.
            
            // 사용자가 선택한 주소를 addr 변수에 저장 (도로명 주소 또는 지번 주소 선택 가능)
            var addr = ''; // 주소 변수 (초기화)
            // 이 변수는 사용자가 선택한 주소(도로명 또는 지번)를 저장할 용도로 사용됨.
            
            // 사용자가 선택한 주소 타입에 따라 도로명 주소 또는 지번 주소 값을 저장
            if (data.userSelectedType === 'R') {  
                // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;  // 도로명 주소를 addr 변수에 저장
            } else {  
                // 사용자가 지번 주소를 선택했을 경우
                addr = data.jibunAddress;  // 지번 주소를 addr 변수에 저장
            }
            // 사용자가 선택한 주소 타입에 따라 도로명 주소 또는 지번 주소가 addr 변수에 저장됨.
            // 도로명 주소를 우선적으로 사용하지만, 필요에 따라 지번 주소도 사용할 수 있음.

            // 우편번호와 주소 정보를 각각의 필드에 입력
            document.getElementById('zipcode').value = data.zonecode;  
            // 선택한 주소의 우편번호를 zipcode 필드에 입력
            document.getElementById("addr1").value = addr;  
            // 선택한 주소를 addr1 필드에 입력
            document.getElementById("addr2").focus();  
            // 상세주소 입력 필드로 포커스를 이동시켜 사용자가 직접 상세주소를 입력할 수 있도록 함
            // 사용자가 주소를 선택한 후, 상세 주소를 추가 입력할 수 있도록 상세 주소 필드에 포커스를 맞춥니다.
        }
    }).open();  // 우편번호 검색 팝업 열기
    // Daum 우편번호 검색 API 팝업을 열어 사용자가 직접 주소를 검색하고 선택할 수 있도록 합니다.
}
