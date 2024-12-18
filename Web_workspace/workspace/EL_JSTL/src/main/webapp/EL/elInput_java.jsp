<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Input_java</title>
<style type="text/css">

body {
	display: flex;
	justify-content: center;
	align-items: flex-start;
	height: 100vh;
	margin-top: 50px;
	background-color: #0d0d0d;
	color: #00ffcc;
	/*
		- `display: flex`는 Flexbox 레이아웃을 사용해 페이지 요소를 배치합니다.
		- `justify-content: center`는 페이지 가로 방향으로 요소들을 중앙에 배치합니다.
		- `align-items: flex-start`는 세로 방향으로 요소들을 상단에 배치합니다.
		- `height: 100vh`는 페이지의 높이를 100%로 사용한다는 의미입니다. (화면의 전체 높이를 차지함)
		- `margin-top: 50px`은 페이지 상단에 50px의 여백을 주어 좀 더 아래쪽에 폼을 배치합니다.
		- 배경 색상은 #0d0d0d(어두운 배경), 글씨 색상은 형광 네온 스타일의 #00ffcc를 사용하여 스타일을 정의했습니다.
	*/
}

table {
	width: 350px;
	margin: 0 auto;
	border-collapse: collapse;
	border: 2px solid #00ffcc;
	box-shadow: 0px 0px 20px #00ffcc, 0px 0px 40px #ff00ff;
	/*
		- 테이블의 너비를 350px로 설정하였습니다.
		- `margin: 0 auto`는 테이블을 수평으로 가운데 정렬합니다.
		- `border-collapse: collapse`는 테이블 셀의 경계선을 하나로 합쳐서 표시합니다.
		- 테두리는 형광 네온 느낌의 #00ffcc로 설정했고, 네온 효과를 강조하기 위해 box-shadow를 추가했습니다.
		- `box-shadow`는 형광 테두리의 그림자 효과로, 네온과 사이버펑크 느낌을 주는 시각적 효과를 강화합니다.
	*/
}

th, td {
	padding: 15px;
	text-align: center;
	background-color: #1a1a1a;
	border-bottom: 1px solid #00ffcc;
	color: #00ffcc;
	/*
		- `padding: 15px`은 테이블 셀 안의 여백을 지정합니다.
		- `text-align: center`는 셀 안의 텍스트를 가운데 정렬합니다.
		- 셀의 배경색은 #1a1a1a로 어두운 분위기를 유지하고, 글자색은 #00ffcc로 형광 효과를 강조했습니다.
		- 셀의 하단에 1px의 형광 네온 테두리(#00ffcc)를 추가해 테이블 요소를 구분했습니다.
	*/
}


.buttons {
	text-align: center;
	padding-top: 20px;
	/*
		- 버튼들을 가운데 정렬하고, 상단에 20px의 여백을 추가하여 공간을 확보했습니다.
		- 이 클래스를 사용해 submit과 reset 버튼을 테이블 하단에 적절히 배치했습니다.
	*/
}

 input[type="text"] {
     width: 80%;
     padding: 10px;
     background-color: #0d0d0d; /* 어두운 배경 */
     border: 2px solid #00ffcc; /* 형광색 테두리 */
     color: #00ffcc; /* 텍스트 색상 */
     outline: none; /* 클릭 시 외곽선 제거 */
	 /*
		- 입력 필드의 너비를 80%로 설정하여 적절한 크기로 조정하였습니다.
		- `padding: 10px`을 설정하여 입력 필드 내부의 여백을 주었습니다.
		- 배경색(#0d0d0d)은 페이지의 어두운 톤과 일치시키고, 테두리와 텍스트 색상은 네온 스타일(#00ffcc)로 설정했습니다.
		- 클릭 시 입력 필드에 생기는 기본 외곽선을 제거하여 깔끔한 디자인을 유지했습니다.
	 */
 }
 

 input[type="submit"], input[type="reset"] {
     background-color: #1a1a1a; 
     border: 2px solid #ff00ff; 
     color: #00ffcc; 
     padding: 10px 20px;
     cursor: pointer;
     text-transform: uppercase;
     box-shadow: 0px 0px 10px #00ffcc, 0px 0px 20px #ff00ff; 
     transition: all 0.3s ease-in-out; /* 마우스 오버 시 애니메이션 */
	 /*
		- 제출(submit) 및 리셋(reset) 버튼의 스타일을 설정했습니다.
		- 어두운 배경(#1a1a1a)과 형광 보라색(#ff00ff) 테두리를 사용하여 미래적인 느낌을 줍니다.
		- 버튼에 `box-shadow`를 추가해 네온 느낌의 그림자를 주어 시각적으로 더 돋보이게 했습니다.
		- `text-transform: uppercase`는 텍스트를 대문자로 변환하여 강조 효과를 줍니다.
		- `transition`으로 마우스 오버 시 애니메이션 효과를 추가하여 사용자 경험을 향상시킵니다.
	 */
 }

 input[type="submit"]:hover, input[type="reset"]:hover {
     background-color: #00ffcc; /* 호버 시 형광색 배경 */
     color: #0d0d0d; 
     box-shadow: 0px 0px 30px #00ffcc, 0px 0px 50px #ff00ff; 
	 /*
		- 마우스 오버 시 버튼의 배경색이 형광색(#00ffcc)으로 변경되고, 글자 색상은 어두운 배경(#0d0d0d)으로 변경됩니다.
		- box-shadow의 크기를 늘려 네온 효과가 더욱 강해지도록 설정했습니다.
		- 이런 시각적 피드백은 버튼을 더 매력적이고 상호작용하기 쉬운 요소로 만듭니다.
	 */
 }
 
</style>
</head>
<body>
		
	<form action="elResult_java.jsp" method="get" >
		<h3> Java Class 의 메소드를 이용 하겠습니다.</h3>
	<table >
				
		<tr>
			<th>X</th> 
			<td><input type="text" name="x" id="x" value="" ></td> 
		</tr>
		
		<tr>
			<th>Y</th> 
			<td><input type="text" name="y" id="y" value="" ></td> 
		</tr>
		
			<tr>
			<td colspan="2" class="buttons">
			<input type="submit" value="계산" />
			<input type="reset" value="취소"  />
			</td>
			</tr>		
		</table>
	</form>
	
	
</body>
</html>