<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록 페이지</title>
<link rel="stylesheet"
    href="${ pageContext.request.contextPath }/css/index.css">
    <!-- 스타일 시트를 불러와서 페이지의 기본 레이아웃을 설정하는 css 파일 -->
    <!-- pageContext.request.contextPath는 현재 웹 애플리케이션의 컨텍스트 경로를 동적으로 가져옵니다. -->
<link rel="stylesheet"
    href="${ pageContext.request.contextPath }/css/imageboardWriteForm.css">
    <!-- 추가적인 스타일 시트를 불러와서 이 폼에 대한 커스텀 스타일 적용 -->
</head>
<body>
    <div id="wrap">
        <div id="header">
            <!-- 페이지의 상단 헤더 영역입니다. -->
            <h1>
                <img alt="사과"
                    src="${ pageContext.request.contextPath }/image/apple.png"
                    width="50" height="50"
                    onclick="location.href='${ pageContext.request.contextPath }/index.do'"
                    style="cursor: pointer;"> 
                <!-- 클릭 시 index.do로 이동하는 이벤트가 설정된 로고 이미지 -->
                MVC를 활용한 미니프로젝트
            </h1>
            <hr style="border-color: #483D8B; border-width: 5px;" />
            <!-- 페이지 상단에 구분선을 추가하여 스타일링 -->
        </div>

        <div id="container">
            <jsp:include page="../main/imageboardMenu.jsp" />
            <!-- JSP의 다른 페이지를 포함하여 재사용성 향상 (네비게이션 메뉴 포함) -->

            <div id="section">
                <form id="imageboardWriteForm" method="post"
                    enctype="multipart/form-data" action="/projectMVC/imageboard/imageboardWrite.do">
                    <!-- enctype="multipart/form-data" 는 파일 업로드를 위한 폼 설정 -->
                    <table border="1">
                        <!-- 테이블을 사용하여 입력 폼을 구성 -->
                        <tr>
                            <th width="100">상품코드</th>
                            <td>
                                <input type="text" id="imageId" name="imageId" size="70"
                                    placeholder="제목 입력">
                                <!-- 상품 코드를 입력받는 필드 -->
                                <div id="subjectDiv"></div>
                                <!-- 입력 유효성 검사 등을 위해 추가한 DIV -->
                            </td>
                        </tr>

                        <tr>
                            <th width="100">상품명</th>
                            <td>
                                <input type="text" id="imageName" name="imageName" size="70"
                                    placeholder="제목 입력">
                                <!-- 상품명을 입력받는 필드 -->
                                <div id="subjectDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <th width="100">상품단가</th>
                            <td>
                                <input type="text" id="imagePrice" name="imagePrice" size="70"
                                    placeholder="제목 입력">
                                <!-- 상품 단가를 입력받는 필드 -->
                                <div id="subjectDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <th width="100">상품수량</th>
                            <td>
                                <input type="text" id="imageQty" name="imageQty" size="70"
                                    placeholder="제목 입력">
                                <!-- 상품 수량을 입력받는 필드 -->
                                <div id="subjectDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <th>상품 내용</th>
                            <td>
                                <textarea id="imageContent" name="imageContent"
                                    rows="10" cols="50"></textarea>
                                <!-- 상품에 대한 설명을 입력하는 textarea -->
                                <div id="imageContentDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <img id="showImg" width="70" height="70">&emsp;
                                <!-- 사용자가 업로드한 이미지를 미리 보여줄 영역 -->
                                
                                <img src="../image/camera.png" alt="카메라" id="camera" width="50"
                                    height="50"> 
                                <!-- 파일 선택을 위한 아이콘 역할을 하는 카메라 이미지 -->
                                
                                <input type="file" id="image1" name="image1"
                                    style="visibility: hidden;">
                                <!-- 실제 파일 업로드 필드로 숨김 처리됨, 카메라 클릭 시 열림 -->
                                
                                <div id="image1Div"></div>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2" class="table-buttons">
                                <input type="submit" value="이미지 등록" id="imageboardWriteBtn">
                                <!-- <input type="button" value="이미지 등록" id="imageboardWriteBtn"> -->
                                <!-- 이미지 등록을 위한 버튼 -->
                                
                                <input type="reset" value="다시작성">
                                <!-- 입력한 내용을 초기화하는 버튼 -->
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- jQuery 라이브러리 로드 -->
    <script type="text/javascript">
    $('#camera').click(function(){
    	$('#image1').trigger('click');//강제 이벤트 발생
    });

    //선택한 이미지 확인하기
    $('#image1').change(function(){
    	readURL(this);
    });

    function readURL(input){
    	var reader = new FileReader();
    	
    	reader.onload = function(e){
    		$('#showImg').attr('src', e.target.result); //e.target - 이벤트가 발생하는 요소를 반환해준다.
    	}
    	
    	reader.readAsDataURL(input.files[0]);
    }
    
    </script>

</body>
</html>

<!-- 
FileReader 란?
FileReader는 type이 file인 input 태그 또는 API 요청과 같은 인터페이스를 통해 
File 또는 Blob 객체를 편리하게 처리할수있는 방법을 제공하는 객체이며
abort, load, error와 같은 이벤트에서 발생한 프로세스를 처리하는데 주로 사용되며,
File 또는 Blob 객체를 읽어서 result 속성에 저장한다.

FileReader도 비동기로 동작한다.

FileReader.onload()
load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료되었을 때마다 발생한다.

파일업로드
- 파일을 업로드 하기 위해서는 반드시 post 방식이여야 한다.
- enctype="multipart/form-data" 지정해야 한다.
- <input type="file" />
- *.jar 필요하다.(cos-05Nov2002.jar)
- storage 폴더 작성
1. 가상폴더 : D:\Web\workspace\projectMVC\src\main\webapp\storage
2. 실제폴더 : D:\Web\workspace\.metadata\.plugin


-->

