<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>이미지 등록 페이지</title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/imageboardWriteForm.css">
</head>
<body>
    <div id="wrap">
        <div id="header">
            <h1>
                <img alt="사과" src="${ pageContext.request.contextPath }/image/apple.png" 
                    width="50" height="50"
                    onclick="location.href='${ pageContext.request.contextPath }/index.do'"
                    style="cursor: pointer;">
                MVC를 활용한 미니프로젝트
            </h1>
            <hr style="border-color: #483D8B; border-width: 5px;" />
        </div>

        <div id="container">
            <jsp:include page="../main/imageboardMenu.jsp" />
            <div id="section">
                <!-- Form에 enctype="multipart/form-data"와 method="post" 추가 -->
                <form id="imageboardWriteForm" method="post" enctype="multipart/form-data">
                    <table border="1">
                        <tr>
                            <th width="100">상품코드</th>
                            <td>
                                <input type="text" id="imageId" name="imageId" size="70" placeholder="제목 입력">
                                <div id="subjectDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <th width="100">상품명</th>
                            <td>
                                <input type="text" id="imageName" name="imageName" size="70" placeholder="제목 입력">
                                <div id="subjectDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <th width="100">상품단가</th>
                            <td>
                                <input type="text" id="imagePrice" name="imagePrice" size="70" placeholder="제목 입력">
                                <div id="subjectDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <th width="100">상품수량</th>
                            <td>
                                <input type="text" id="imageQty" name="imageQty" size="70" placeholder="제목 입력">
                                <div id="subjectDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <th>상품 내용</th>
                            <td>
                                <textarea id="imageContent" name="imageContent" rows="10" cols="50"></textarea>
                                <div id="imageContentDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <img id="showImg" width="70" height="70">&emsp;
                                <img src="../image/camera.png" alt="카메라" id="camera" width="50" height="50"> 
                                <input type="file" id="image1" name="image1" style="visibility: hidden;">
                                <div id="image1Div"></div>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2" class="table-buttons">
                                <input type="button" value="이미지 등록" id="imageboardWriteBtn">
                                <input type="reset" value="다시작성">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>

    <script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
    $('#camera').click(function() {
        $('#image1').trigger('click'); // 이미지 파일 선택을 트리거
    });

    // 선택한 이미지를 미리보기
    $('#image1').change(function() {
        readURL(this);
    });

    function readURL(input) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#showImg').attr('src', e.target.result); // 이미지 미리보기
        }
        reader.readAsDataURL(input.files[0]);
    }

    // 이미지 등록 버튼 클릭 시 Ajax로 데이터 전송
    $('#imageboardWriteBtn').click(function() {
        let formData = new FormData($('#imageboardWriteForm')[0]); // FormData 객체 생성

        $.ajax({
            type: 'post',
            enctype: 'multipart/form-data',
            processData: false, // 데이터를 문자열로 처리하지 않도록 설정
            contentType: false, // 파일 업로드 시 multipart/form-data로 설정
            url: '/projectMVC/imageboard/imageboardWriteAjax.do', // 서버 URL
            data: formData, // formData에 담긴 데이터 전송
            success: function() {
                alert('이미지 등록 완료');
                location.href = "/projectMVC/imageboard/imageboardList.do?pg=1"; // 등록 완료 후 목록으로 이동
            },
            error: function(e) {
                console.log(e);
                alert('이미지 등록 실패');
            }
        });
    });
    </script>
</body>
</html>
