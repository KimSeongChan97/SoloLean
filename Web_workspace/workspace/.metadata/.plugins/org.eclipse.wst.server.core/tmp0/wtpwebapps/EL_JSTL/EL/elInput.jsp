<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Input</title>
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
	- body 태그에 Flexbox를 적용하여 화면 중앙에 정렬되도록 설정했습니다.
	- justify-content: center는 가로 중앙으로 정렬하고,
	  align-items: flex-start는 세로축에서 위쪽부터 시작하도록 설정합니다.
	- height: 100vh는 화면 높이를 100% 사용한다는 의미입니다.
	- margin-top: 50px으로 상단에 여백을 추가하여 중앙에 더 가까워지도록 했습니다.
	- 배경 색상은 어두운 사이버펑크 느낌(#0d0d0d)을 주었고, 
	  텍스트 색상은 형광 네온 느낌의 #00ffcc 색상을 사용했습니다.
	*/
}

table {
	width: 350px;
	margin: 0 auto;
	border-collapse: collapse;
	border: 2px solid #00ffcc;
	box-shadow: 0px 0px 20px #00ffcc, 0px 0px 40px #ff00ff;
	/*
	- 테이블의 너비를 350px로 고정하고, 테두리(border)를 형광색(#00ffcc)으로 지정했습니다.
	- border-collapse: collapse는 테두리 간의 공간을 없애서 하나로 보이도록 하는 설정입니다.
	- margin: 0 auto는 테이블을 가운데로 정렬하기 위한 설정입니다.
	- box-shadow로 테이블에 네온 느낌의 그림자를 추가하여 미래적인 스타일을 구현했습니다.
	- 그림자는 두 가지 색(#00ffcc와 #ff00ff)을 사용하여 네온 효과를 더 극적으로 만들었습니다.
	*/
}

th, td {
	padding: 15px;
	text-align: center;
	background-color: #1a1a1a;
	border-bottom: 1px solid #00ffcc;
	color: #00ffcc;
	/*
	- 테이블의 셀 내부 공간에 padding을 15px 주어 여백을 추가했습니다.
	- text-align: center로 텍스트를 가운데 정렬했고, 셀의 배경색을 #1a1a1a로 지정하여 어두운 느낌을 더했습니다.
	- border-bottom: 1px solid #00ffcc로 셀 하단에 테두리를 넣어 강조 효과를 추가했습니다.
	- 셀 내부의 텍스트 색상은 형광 네온 느낌(#00ffcc)으로 지정했습니다.
	- 테두리와 텍스트 색상은 통일감 있게 설정되어 있어 화면 전체 디자인에 일관성을 줍니다.
	*/
}


.buttons {
	text-align: center;
	padding-top: 20px;
	/*
	- buttons 클래스로 버튼을 포함한 셀을 중앙 정렬했고, 상단에 20px의 여백을 추가했습니다.
	- 이를 통해 버튼들이 테이블 하단 중앙에 배치되도록 했습니다.
	- 버튼의 위치가 명확하게 중앙에 정렬되어 사용자의 접근성을 높였습니다.
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
	- 텍스트 입력 필드의 너비를 80%로 설정하여 화면에 적절한 크기로 보이도록 했습니다.
	- padding을 10px 설정하여 입력 필드 안의 텍스트와 테두리 사이에 여백을 추가했습니다.
	- 배경색은 어두운 #0d0d0d로 설정해 사이버펑크 분위기를 유지했고, 테두리(border)는 형광색(#00ffcc)으로 지정했습니다.
	- 입력된 텍스트의 색상도 형광 네온 느낌(#00ffcc)으로 지정해 디자인을 일관성 있게 유지했습니다.
	- outline: none으로 클릭 시 외곽선이 나타나지 않게 설정했습니다.
	- 넓이(80%)와 패딩(10px)은 사용자가 텍스트를 입력할 때 편안한 사용자 경험을 제공합니다.
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
	- 제출 버튼과 리셋 버튼의 배경색을 어두운 #1a1a1a로 설정하여 배경과 잘 어울리도록 했습니다.
	- 테두리(border)를 형광 보라색(#ff00ff)으로 지정하여 버튼이 강조되도록 했습니다.
	- 버튼의 텍스트 색상도 형광 네온(#00ffcc)으로 설정해 일관된 스타일을 유지했습니다.
	- padding은 버튼의 크기를 조정하기 위해 설정되었고, cursor: pointer로 마우스를 올리면 포인터가 바뀌게 했습니다.
	- text-transform: uppercase는 텍스트를 모두 대문자로 표시하는 설정입니다.
	- box-shadow로 네온 효과를 추가하여 버튼이 마우스를 올렸을 때 강조되는 느낌을 줍니다.
	- transition으로 버튼에 마우스를 올릴 때 부드럽게 색상이 바뀌는 애니메이션 효과를 설정했습니다.
	- 전반적으로 버튼의 시각적 강조와 사용성을 높이기 위한 스타일입니다.
	*/
}

input[type="submit"]:hover, input[type="reset"]:hover {
	background-color: #00ffcc; /* 호버 시 형광색 배경 */
	color: #0d0d0d; 
	box-shadow: 0px 0px 30px #00ffcc, 0px 0px 50px #ff00ff; 
	/*
	- 버튼에 마우스를 올리면 배경색이 형광 네온(#00ffcc)으로 바뀌며, 텍스트 색상은 어두운 #0d0d0d로 변경됩니다.
	- box-shadow의 크기를 키워서 버튼에 마우스를 올리면 네온 효과가 더 크게 나타나도록 했습니다.
	- 이 효과는 사용자 인터페이스를 보다 직관적으로 만들어 주며, 버튼의 가시성을 높여줍니다.
	- hover 효과는 사용자와의 상호작용을 강화시켜 시각적인 피드백을 줍니다.
	*/
}

</style>
</head>
<body>
	
	
	
	<form action="elResult.jsp" method="get" >
	<table >

		<tr>
			<th>X</th> 
			<td><input type="text" name="x" id="x" value="" ></td> 
		</tr>
		<%-- 
			첫 번째 행으로 X 값을 입력받는 필드입니다.
			<th>는 테이블의 제목 셀로 "X"를 표시하고, <td>에는 실제 입력할 필드를 배치했습니다.
			<input type="text" name="x" id="x">로 텍스트 필드를 만들었으며, name과 id를 "x"로 지정하여 이 값이 전송될 때 파라미터 이름이 "x"가 됩니다.
			사용자가 이 필드에 값을 입력하면 form이 제출될 때 이 값이 서버로 전송됩니다.
			이 필드는 넓이를 80%로 지정한 스타일을 따릅니다.
			- name 속성은 폼이 전송될 때 서버로 전달되는 파라미터 이름을 결정합니다.
			- id 속성은 해당 HTML 요소를 JavaScript나 CSS에서 참조할 때 사용됩니다.
		--%>
		
		<tr>
			<th>Y</th> 
			<td><input type="text" name="y" id="y" value="" ></td> 
		</tr>
		<%-- 
			두 번째 행으로 Y 값을 입력받는 필드입니다.
			첫 번째 필드와 마찬가지로 <th>에는 "Y"라는 제목이 표시되고, <td>에는 입력 필드가 위치합니다.
			<input type="text" name="y" id="y">로 텍스트 필드를 만들었으며, 이 필드 역시 name과 id가 "y"로 설정되었습니다.
			이렇게 설정된 값은 form이 제출될 때 서버로 "y"라는 파라미터 이름으로 전송됩니다.
			- name 속성은 서버로 전송되는 파라미터의 이름을 결정하고, id 속성은 스타일링 및 접근성을 위한 식별자로 사용됩니다.
		--%>
		
			<tr>
			<td colspan="2" class="buttons">
			<input type="submit" value="계산" />
			<input type="reset" value="취소"  />
			</td>
			</tr>		
			<%-- 
				세 번째 행으로 두 개의 버튼을 배치한 부분입니다.
				<td colspan="2"로 테이블의 두 열을 합쳐서 버튼들이 중앙에 정렬되도록 했습니다.
				<button> 대신 <input type="submit">과 <input type="reset">을 사용해 각각 폼을 제출하거나 초기화하는 버튼을 추가했습니다.
				계산 버튼은 값을 전송하고, 취소 버튼은 입력값을 리셋합니다. 
				이 버튼들에는 마우스를 올리면 색상이 변하는 스타일이 적용되어 있습니다.
				- submit 버튼은 폼 데이터를 서버로 전송하고, reset 버튼은 입력한 데이터를 초기화합니다.
				- colspan 속성은 두 개의 셀을 하나로 합쳐 버튼들이 테이블 중앙에 위치하도록 도와줍니다.
			--%>	
		</table>
	</form>
	
	
</body>
</html>
