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
        <!-- 전체 페이지를 감싸는 최상위 div 요소입니다. -->
        <div id="header">
            <!-- 페이지의 상단 헤더 영역입니다. -->
            <h1>
                <img alt="사과"
                    src="${ pageContext.request.contextPath }/image/apple.png"
                    width="50" height="50"
                    onclick="location.href='${ pageContext.request.contextPath }/index.do'"
                    style="cursor: pointer;"> 
                <!-- 클릭 시 index.do로 이동하는 이벤트가 설정된 로고 이미지 -->
                <!-- onclick 속성은 이미지 클릭 시 실행될 JavaScript 코드를 정의합니다. -->
                MVC를 활용한 미니프로젝트
            </h1>
            <hr style="border-color: #483D8B; border-width: 5px;" />
            <!-- 페이지 상단에 구분선을 추가하여 스타일링 -->
        </div>

        <div id="container">
            <!-- 페이지의 주요 내용을 담는 컨테이너 div입니다. -->
            <jsp:include page="../main/imageboardMenu.jsp" />
            <!-- JSP의 다른 페이지를 포함하여 재사용성 향상 (네비게이션 메뉴 포함) -->
            <!-- jsp:include 태그는 다른 JSP 파일의 내용을 현재 페이지에 포함시킵니다. -->

            <div id="section">
                <!-- 실제 폼이 들어갈 섹션 영역입니다. -->
                <form id="imageboardWriteForm" >
                    <!-- 이미지 정보를 입력받는 폼입니다. method와 action 속성이 없는 이유는 JavaScript로 제어하기 때문입니다. -->
                    
                    <table border="1">
                        <!-- 테이블을 사용하여 입력 폼을 구성 -->
                        <tr>
                            <th width="100">상품코드</th>
                            <td>
                                <input type="text" id="imageId" name="imageId" size="70"
                                    placeholder="제목 입력">
                                <!-- 상품 코드를 입력받는 필드 -->
                                <!-- placeholder 속성은 입력 필드에 힌트 텍스트를 표시합니다. -->
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
                                <!-- rows와 cols 속성은 textarea의 크기를 지정합니다. -->
                                <div id="imageContentDiv"></div>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <!-- colspan="2"는 이 셀이 2개의 열을 차지한다는 의미입니다. -->
                                <img id="showImg" width="70" height="70">&emsp;
                                <!-- 사용자가 업로드한 이미지를 미리 보여줄 영역 -->
                                <!-- &emsp;는 큰 공백을 나타내는 HTML 엔티티입니다. -->
                                
                                <img src="../image/camera.png" alt="카메라" id="camera" width="50"
                                    height="50"> 
                                <!-- 파일 선택을 위한 아이콘 역할을 하는 카메라 이미지 -->
                                
                                <input type="file" id="image1" name="image1"
                                    style="visibility: hidden;">
                                <!-- 실제 파일 업로드 필드로 숨김 처리됨, 카메라 클릭 시 열림 -->
                                <!-- visibility: hidden;은 요소를 숨기지만 공간은 차지하게 합니다. -->
                                
                                <div id="image1Div"></div>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2" class="table-buttons">
                            	<input type="button" value="이미지 등록" id="imageboardWriteBtn">
                                <!-- 이미지 등록을 위한 버튼 -->
                                <!-- type="button"은 폼을 제출하지 않는 일반 버튼입니다. -->
                                
                                <input type="reset" value="다시작성">
                                <!-- 입력한 내용을 초기화하는 버튼 -->
                                <!-- type="reset"은 폼의 모든 입력 필드를 초기 값으로 되돌립니다. -->
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- jQuery 라이브러리 로드 -->
    <!-- jQuery는 JavaScript 작업을 간소화하는 라이브러리입니다. -->
    <script type="text/javascript">
    $('#camera').click(function(){
        // 카메라 아이콘을 클릭하면 파일 선택 창이 열리도록 함
        $('#image1').trigger('click');
        // trigger() 메소드는 특정 이벤트를 강제로 발생시킵니다.
    });
    
    // 사용자가 파일을 선택하면 선택된 파일의 이미지를 보여줌
    $('#image1').change(function(){
        readURL(this);
        // this는 현재 이벤트가 발생한 요소를 가리킵니다.
    });
    
    function readURL(input){
        var reader = new FileReader();
        // FileReader 객체를 사용하여 파일을 비동기적으로 읽어옴
        
        reader.onload = function(e){
            $('#showImg').attr('src', e.target.result); 
            // 파일이 로드되면 미리보기 이미지의 src 속성을 변경하여 보여줌
        }
        reader.readAsDataURL(input.files[0]); 
        // 선택한 파일을 데이터 URL 형식으로 읽어옴 (이미지 미리보기에 적합)
    }
    
    $('#imageboardWriteBtn').click(function(){
    		
    });
    
    // 이미지 버튼(Ajax)
    $('#imageboardWriteBtn').click(function(){
        let formData = new FormData($('#imageboardWriteForm')[0]);
        $.ajax({
            type: 'post',
    url: '/projectMVC/imageboard/imageboardWriteAjax.do',
    enctype: 'multipart/form-data',
    processData: false,
    // processData: false 설정의 이유
    // - 기본값은 true이며, 이 경우 데이터를 문자열로 변환하여 전송합니다.
    // - false로 설정하면 데이터를 문자열로 변환하지 않고 그대로 전송합니다.
    // - 파일 업로드 시 필수적인 설정입니다. 파일 데이터는 문자열로 변환되면 안 되기 때문입니다.
    // - FormData 객체를 사용할 때도 반드시 false로 설정해야 합니다.
    // - 이렇게 함으로써 파일이나 Blob 데이터가 올바르게 서버로 전송될 수 있습니다.
    
    contentType: false,
    // contentType: false 설정의 이유
    // - 기본값은 'application/x-www-form-urlencoded; charset=UTF-8'입니다.
    // - false로 설정하면 jQuery가 contentType을 설정하지 않습니다.
    // - 이는 브라우저가 multipart/form-data를 자동으로 설정할 수 있게 합니다.
    // - 파일 업로드 시 필수적인 설정입니다. multipart/form-data는 파일 전송에 적합한 인코딩 방식입니다.
    // - FormData 객체를 사용할 때도 반드시 false로 설정해야 합니다.
    // - 이렇게 함으로써 파일 데이터가 올바른 형식으로 서버에 전송될 수 있습니다.
    
    data: formData,
    success: function(data){
        alert('이미지 등록 완료');
    },
    error: function(e){
        console.log(e);
    }    
        }); // ajax 호출
    });

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


processData
 
기본값은 true
기본적으로 Query String으로 변환해서 보내진다('변수=값&변수=값')
파일 전송시에는 반드시 false로 해야 한다.(formData를 문자열로 변환하지 않는다)

contentType
  
기본적으로 "application/x-www-form-urlencoded; charset=UTF-8"
파일 전송시에는 'multipart/form-data'로 전송이 될 수 있도록 false로 설정한다

-->

