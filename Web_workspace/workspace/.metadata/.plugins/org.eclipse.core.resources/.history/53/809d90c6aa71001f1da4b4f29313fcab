// 중복체크 여부를 확인하는 변수
// 아이디 중복 체크가 완료되었는지 여부를 저장하는 변수입니다.
// 'false'는 아직 중복 체크가 안된 상태이고, 'true'는 중복 체크가 완료된 상태를 나타냅니다.
// 'idChecked' 변수는 중복체크 버튼을 눌렀는지 확인하는 역할을 합니다.
// 이 변수를 통해 폼 제출 시 중복 체크가 되었는지 검사하여 아이디가 유효한지 확인할 수 있습니다.
// 추가 주석: 아이디 중복 체크는 회원가입 또는 아이디 변경 시 중요한 기능으로, 이미 사용 중인 아이디가 입력되는 것을 방지합니다.
let idChecked = false; // 아이디 중복체크가 수행되었는지 확인하는 플래그 변수입니다. 기본값은 'false'로 설정됩니다.

// ID 중복 체크 함수
// 사용자가 입력한 아이디가 중복되었는지 확인하는 함수입니다.
// 이 함수는 중복 체크 버튼을 클릭했을 때 호출됩니다.
// 'checkId' 함수는 사용자 입력을 기반으로 서버에 요청을 보내어 아이디 중복 여부를 확인합니다.
// 사용자가 아무런 아이디를 입력하지 않으면 메시지를 표시하고, 입력이 있으면 중복 여부를 확인하는 팝업 창을 띄웁니다.
// 추가 주석: 팝업 창을 통해 중복 체크가 이루어지며, 서버에서 확인한 결과에 따라 ID가 사용 가능한지 여부가 결정됩니다.
function checkId() {
    // 사용자가 입력한 아이디 값을 가져옵니다.
    let id = document.getElementById('id').value;

    // 아이디 입력이 비어있다면, 사용자에게 아이디를 입력하라는 메시지를 보여줍니다.
    // 'if' 조건문을 사용해 아이디 입력란이 비어있는지 확인합니다.
    // 비어 있으면 사용자에게 경고 메시지를 띄우고, 비어 있지 않다면 서버에 중복 체크를 요청하는 새로운 창을 엽니다.
    // 추가 주석: 입력된 아이디가 없다면 중복 체크를 할 수 없으므로 사용자에게 메시지를 통해 입력을 유도합니다.
    if (id === "") {
        // 아이디 입력이 비어있을 경우 오류 메시지를 'idDiv' div에 출력합니다.
        document.getElementById('idDiv').innerHTML = "먼저 아이디를 입력하세요 !!";
    } else {
        // 입력한 아이디를 기반으로 중복 확인 팝업 창을 엽니다.
        // window.open()은 새로운 브라우저 창을 열어서 서버 측에서 아이디 중복 여부를 확인합니다.
        // 'id' 값을 쿼리스트링으로 전달하여 중복 여부를 확인합니다.
        // 추가 주석: 'window.open()' 함수는 새로운 창을 열고, 해당 창에서 아이디 중복 여부를 서버에 요청합니다. 
        window.open("./checkId.jsp?id=" + id, "myWindow", "width=450 height=150 top=100 left=800");

        // 중복 체크가 완료되었음을 표시하기 위해 'idChecked' 변수를 'true'로 변경합니다.
        idChecked = true; // 중복 체크가 완료된 상태로 설정합니다.
    }
}

// 이메일 선택 시, 직접 입력 기능 제공
// 사용자가 이메일 도메인을 직접 입력하거나, 기존 도메인을 선택할 수 있도록 하는 함수입니다.
// 사용자가 이메일 도메인을 선택하면 'email3' 필드의 값을 'email2' 필드에 넣어줍니다.
// 추가 주석: 사용자가 선택한 이메일 도메인 옵션을 'email2' 필드에 적용시켜 이메일 입력을 간소화합니다.
function change() {
    // email3 필드의 값을 email2 필드로 복사해줍니다.
    document.getElementById("email2").value = document.getElementById("email3").value;
}

// 회원가입 폼 제출 시 호출되는 함수입니다.
// 이 함수는 폼 제출 전에 사용자가 입력한 값들이 유효한지 확인하고, 유효하지 않은 경우 오류 메시지를 표시합니다.
// event.preventDefault()를 사용하여 폼 제출을 막고, 모든 유효성 검사를 통과한 경우에만 폼을 제출합니다.
// 추가 주석: 유효성 검사를 통해 잘못된 입력을 방지하고, 사용자가 올바르게 정보를 입력했을 때만 서버에 요청이 전송됩니다.
function memberWrite(event) {
    // 폼 제출을 방지하기 위해 기본 이벤트를 막습니다.
    // 폼이 유효성 검사를 통과하지 않았을 때, 기본 동작인 페이지 리로딩을 방지합니다.
    event.preventDefault();

    // 오류 메시지 초기화: 입력 필드 아래의 div 내용을 비워줍니다.
    // 이전에 표시된 오류 메시지가 있을 경우 이를 초기화하여 새로운 오류 메시지가 중복되지 않도록 합니다.
    document.getElementById("nameDiv").innerHTML = ""; 
    document.getElementById("idDiv").innerHTML = ""; 
    document.getElementById("pwdDiv").innerHTML = ""; 
    document.getElementById("repwdDiv").innerHTML = "";

    // 유효성 검사 실패 여부를 추적할 변수
    // 폼이 유효하지 않은 경우 'false'로 설정되어 폼 제출을 막습니다.
    let isValid = true;

    // 이름이 비어 있을 경우
    // 사용자가 이름을 입력하지 않았을 때 오류 메시지를 표시합니다.
    if (document.memberForm.name.value.trim() === "") {
        // 이름 입력이 비어있을 경우 'nameDiv'에 오류 메시지를 출력합니다.
        document.getElementById("nameDiv").innerHTML = "이름을 입력하세요";
        isValid = false; // 유효성 검사 실패를 나타내는 플래그 설정
    }

    // 아이디가 비어 있을 경우
    // 사용자가 아이디를 입력하지 않았을 때 오류 메시지를 표시합니다.
    if (document.getElementById("id").value.trim() === "") {
        document.getElementById("idDiv").innerHTML = "아이디를 입력하세요";
        isValid = false;
    }

    // 비밀번호가 비어 있을 경우
    // 비밀번호 필드가 비어있는지 확인하고, 오류 메시지를 출력합니다.
    if (document.getElementById("pwd").value.trim() === "") {
        document.getElementById("pwdDiv").innerHTML = "비밀번호를 입력하세요";
        isValid = false;
    }

    // 비밀번호와 재입력된 비밀번호가 일치하지 않을 경우
    // 사용자가 입력한 두 비밀번호가 일치하는지 확인하고, 일치하지 않으면 오류 메시지를 출력합니다.
    if (document.getElementById("pwd").value !== document.getElementById("repwd").value) {
        document.getElementById("repwdDiv").innerHTML = "비밀번호가 일치하지 않습니다.";
        isValid = false;
    }

    // 아이디 중복 체크가 완료되지 않았을 경우
    // 중복 체크가 완료되지 않았을 때 오류 메시지를 출력합니다.
    // 추가 주석: 아이디 중복 체크가 되어야만 회원가입이 가능하도록 유효성 검사를 진행합니다.
    if (document.getElementById("id").value !== document.getElementById("check").value) {
        document.getElementById("idDiv").innerHTML = "아이디 중복 체크를 하세요";
        isValid = false;
    }

    // 유효성 검사를 모두 통과했을 때만 폼을 제출합니다.
    // 'isValid'가 true인 경우에만 폼을 실제로 제출하게 됩니다.
    if (isValid) {
        document.memberForm.submit(); // 유효성 검사가 통과되었을 때 폼을 제출합니다.
    }
}

// 아이디 변경 시 중복 체크 상태를 초기화하는 코드
// 사용자가 아이디 입력란에 새로운 값을 입력할 때마다 중복 체크 상태를 초기화합니다.
// 중복 체크를 한 후 아이디를 변경할 경우 다시 중복 체크를 해야 하므로, 이때 idChecked를 'false'로 설정하여 중복 체크가 되지 않은 상태로 만듭니다.
// 추가 주석: 아이디를 변경했을 경우 새로운 중복 체크가 필요하기 때문에 idChecked 변수를 초기화하여 다시 중복 체크를 하게 만듭니다.
document.getElementById('id').addEventListener('input', function () {
    idChecked = false; // 아이디가 변경되면 다시 중복 체크를 해야 하므로 'false'로 설정합니다.
});

// 우편번호 검색을 위한 Daum API 함수
// 사용자가 '우편번호 검색' 버튼을 클릭했을 때 호출됩니다.
// Daum API를 사용하여 주소를 검색하고, 사용자가 선택한 주소를 입력 필드에 자동으로 채워줍니다.
// 추가 주석: Daum 우편번호 검색 API는 사용자가 쉽게 주소를 입력할 수 있도록 도와주는 기능입니다.
function checkPost() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 사용자가 선택한 주소를 저장할 변수
            var addr = '';

            // 사용자가 도로명 주소를 선택했을 때와 지번 주소를 선택했을 때를 구분하여 주소를 저장합니다.
            if (data.userSelectedType === 'R') {
                addr = data.roadAddress; // 도로명 주소를 선택한 경우 도로명 주소를 저장
            } else {
                addr = data.jibunAddress; // 지번 주소를 선택한 경우 지번 주소를 저장
            }

            // 선택한 우편번호와 주소를 각 필드에 넣습니다.
            document.getElementById('zipcode').value = data.zonecode; // 우편번호 필드에 자동으로 값 채우기
            document.getElementById("addr1").value = addr; // 주소 필드에 선택된 주소 값 넣기
            document.getElementById("addr2").focus(); // 상세 주소 필드에 포커스를 자동으로 이동
        }
    }).open(); // 우편번호 검색 팝업을 엽니다.
}

// 회원정보 수정
// 추가 주석: 회원정보 수정 시, 입력된 정보가 유효한지 확인한 후 서버에 AJAX로 전송하여 서버 측에서 회원 정보를 수정합니다.
$(document).ready(function() {
    $('#updateBtn').click(function() {
        // 수정 폼에서 입력 값이 올바른지 확인하기 위한 유효성 검사 로직입니다.
        $("#nameDiv").empty(); 
        $("#pwdDiv").empty(); 

        if ($('#name').val() == '') {
            $("#nameDiv").html('이름을 입력하세요');
        } else if ($('#pwd').val() == '') {
            $("#pwdDiv").html('비밀번호를 입력하세요');
        } else if ($('#pwd').val() != $('#repwd').val()) {
            $("#pwdDiv").html('비밀번호가 맞지 않습니다.');
        } else {
            // 유효성 검사가 통과되었을 경우, AJAX 요청을 통해 회원 정보를 서버에 전송합니다.
            $.ajax({
                type: 'post',
                url: 'memberUpdate.jsp',
                data: $('form[name="updateForm"]').serialize(), // 폼 데이터를 직렬화해서 전송
                success: function() {
                    alert('회원정보 수정을 완료하였습니다 !');
                    location.href = '../index.jsp';
                },
                error: function(e) {
                    console.log(e);  // 에러 발생 시 콘솔에 출력
                }
            });
        }
    });
});
