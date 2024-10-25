//아이디 중복 체크
function checkId(){
	document.getElementById("idDiv").innerHTML = "";
	
	let id = document.getElementById("id").value;

	if(id == "")
		document.getElementById("idDiv").innerHTML = "먼저 아이디 입력";
	else
		window.open("./checkId.jsp?id="+id, "myWindow", "width=450 height=150 top=100 left=700");
}

//이메일
function change() {
	document.getElementById("email2").value = document.getElementById("email3").value;
}

//회원가입
function checkWrite() {
	document.getElementById("nameDiv").innerHTML = "";
	document.getElementById("idDiv").innerHTML = "";
	document.getElementById("pwdDiv").innerHTML = "";
	
	//if(document.getElementById("name").value == "") => id 속성
	if(document.writeForm.name.value == "")
		document.getElementById("nameDiv").innerHTML = "이름 입력";
	else if(document.getElementById("id").value == "")
		document.getElementById("idDiv").innerHTML = "아이디 입력";
	else if(document.getElementById("pwd").value == "")
			document.getElementById("pwdDiv").innerHTML = "비밀번호 입력";
	else if(document.getElementById("pwd").value != document.getElementById("repwd").value)
			document.getElementById("pwdDiv").innerHTML = "비밀번호가 맞지 않습니다.";
	else if(document.getElementById("id").value != document.getElementById("check").value)
		document.getElementById("idDiv").innerHTML = "중복체크 하세요";
	else 
		document.writeForm.submit();
	
}

//회원정보수정
$('#updateBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val() == '')
		$('#nameDiv').html('이름 입력');
	else if($('#pwd').val() == '')
		$('#pwdDiv').html('비밀번호 입력');
	else if($('#pwd').val() != $('#repwd').val())
		$('#pwdDiv').html('비밀번호가 맞지 않습니다');
	else
		$.ajax({
			type: 'post',
			url: 'update.jsp',
			data: $('form[name="updateForm"]').serialize(), // name=값&id=값&~~~~
			success: function(){
				alert('회원정보 수정 완료');
				location.href = '../index.jsp';
			},
			error: function(e){
				console.log(e);
			}
		});
});
















//우편번호 - Daum API
function checkPost() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addr2").focus();
        }
    }).open();
}

