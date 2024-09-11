<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Input</title>
<style type="text/css">

body {
	background-color: #0d0d0d;
	color: #00ffcc;
	text-align: center;
	
}

table[border="1"] {
	color: #00ffcc;
	
}

</style>
</head>
<body>

	<form method="post" action="jstlResult.jsp">
		<%-- 
			- form 태그는 사용자 입력을 받을 때 사용하는 HTML 폼을 정의합니다.
			- method="post"는 폼 데이터를 서버로 전송하는 HTTP 요청 방법 중 POST 방식을 사용합니다.
			- action="jstlResult.jsp"는 폼 데이터를 전송할 JSP 파일의 경로를 지정합니다.
			- 사용자가 폼을 제출하면 이 데이터를 "jstlResult.jsp" 페이지로 전송합니다.
			
			* 추가 설명:
			- POST 방식은 폼 데이터를 HTTP 요청 본문에 숨겨서 전송하므로 GET 방식에 비해 보안성이 더 높습니다.
			- action 속성에 지정된 URL로 데이터를 전송하게 되며, 이 페이지에서 폼 데이터를 처리합니다.
		--%>
		<table border="1" cellpadding="5" cellspacing="0">
			<%-- 
				- table 태그는 표 형식으로 폼 요소를 배치할 때 사용됩니다.
				- border="1"은 테이블의 테두리를 1픽셀 두께로 설정합니다.
				- cellpadding="5"은 셀의 내부 여백을 5픽셀로 설정합니다.
				- cellspacing="0"은 셀 사이의 간격을 0으로 설정하여 테이블 요소가 밀착되게 합니다.
				
				* 추가 설명:
				- cellpadding과 cellspacing은 표 내부의 여백과 간격을 조정하는 속성입니다. 
				- 여기서는 각각 5px와 0px로 설정하여 셀 내부 여백을 유지하면서 셀 사이의 간격은 없앴습니다.
			--%>
			<tr>
				<th width="70">이름</th>
				<td><input type="text" name="name" ></td>
				<%-- 
					- input 태그는 사용자 입력을 받는 텍스트 필드를 생성합니다.
					- type="text"는 일반 텍스트 입력 필드임을 지정합니다.
					- name="name"은 이 필드의 이름을 지정하며, 서버로 전송될 때 'name'이라는 키로 전송됩니다.
					
					* 추가 설명:
					- 사용자가 이 필드에 입력한 데이터는 'name'이라는 이름으로 전송되며, 서버 측에서 이를 처리합니다.
				--%>
			</tr>
			
			<tr>
				<th width="70">나이</th>
				<td><input type="text" name="age" ></td>
				<%-- 
					- 나이 입력을 위한 또 다른 텍스트 입력 필드입니다.
					- name="age"로 지정되어 있으며, 사용자가 입력한 나이 값이 서버로 전송될 때 'age'라는 키로 전송됩니다.
					
					* 추가 설명:
					- 텍스트 필드에 숫자를 입력하게 되어 있지만, 기본적으로는 텍스트이기 때문에 숫자 이외의 값도 입력될 수 있습니다.
					- 서버 측에서 이 값을 숫자로 변환하거나 유효성 검사를 할 필요가 있습니다.
				--%>
			</tr>
			
			<tr>
				<th width="70">색깔</th>
				<td>
					<select name="color" id="color" style="width: 100px;">
						<%-- 
							- select 태그는 드롭다운 메뉴를 생성합니다.
							- name="color"로 지정하여 사용자가 선택한 값이 'color'라는 이름으로 전송됩니다.
							- id="color"는 이 필드의 ID를 지정합니다.
							- style="width: 100px;"은 드롭다운 메뉴의 너비를 100픽셀로 설정합니다.
						--%>
						<optgroup label="색깔">
							<%-- 
								- optgroup 태그는 관련된 옵션들을 그룹으로 묶습니다.
								- label="색깔"은 이 그룹의 레이블(제목)을 설정하며, 여기서는 "색깔"이 그룹 레이블로 표시됩니다.
							--%>
							<option value="red"> 빨강 </option>
							<option value="green"> 초록 </option>
							<option value="blue"> 파랑 </option>
							<option value="magenta"> 보라 </option>
							<option value="cyan"> 하늘 </option>
							<%-- 
								- option 태그는 드롭다운 메뉴의 선택 항목을 정의합니다.
								- 각 option 태그의 value 속성은 사용자가 해당 옵션을 선택했을 때 서버로 전송되는 값을 지정합니다.
								- 예를 들어, 사용자가 "빨강"을 선택하면 서버로는 "red"라는 값이 전송됩니다.
								
								* 추가 설명:
								- optgroup을 사용해 드롭다운 옵션을 그룹화하면 시각적으로 선택 항목들을 분리할 수 있어 가독성이 좋아집니다.
								- value 속성은 서버로 전송되는 실제 데이터를 지정하고, 사용자는 보기 쉬운 텍스트(빨강, 초록 등)를 보게 됩니다.
							--%>
						</optgroup>
					</select>
				</td>
			</tr>
			
			<tr>
				<th >취미</th>
				<td>
					<%-- 
						- 사용자가 여러 개의 취미를 선택할 수 있도록 체크박스를 제공합니다.
						- name="hobby"로 지정된 각 체크박스는 사용자가 선택한 값만 서버로 전송됩니다.
						- 사용자가 여러 체크박스를 선택할 수 있으므로 hobby에 여러 값이 전달될 수 있습니다.
					--%>
					<input type="checkbox" name="hobby" id="hobby1" value="독서" />
					<label for="hobby1"> 독서 </label>
					<input type="checkbox" name="hobby" id="hobby2" value="영화" />
					<label for="hobby2"> 영화 </label>
					<input type="checkbox" name="hobby" id="hobby3" value="음악" />
					<label for="hobby3"> 음악 </label>
					<input type="checkbox" name="hobby" id="hobby4" value="게임" />
					<label for="hobby4"> 게임 </label>
					<input type="checkbox" name="hobby" id="hobby5" value="쇼핑" />
					<label for="hobby5"> 쇼핑 </label>
					<%-- 
						- 각각의 input 태그는 체크박스를 생성하며, value 속성은 해당 체크박스가 선택되었을 때 서버로 전송되는 값을 정의합니다.
						- 예를 들어, 사용자가 "독서"를 선택하면 서버로는 "독서"라는 값이 전송됩니다.
						- label 태그는 체크박스에 대한 설명을 제공하며, for 속성은 해당 체크박스의 ID를 참조합니다.
						
						* 추가 설명:
						- 여러 체크박스를 선택할 수 있기 때문에, 서버 측에서 이를 배열로 처리하여 여러 개의 값이 처리되도록 할 수 있습니다.
					--%>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<%-- 
						- input type="submit"은 폼 데이터를 서버로 전송하는 버튼을 생성합니다.
						- value="SEND"는 버튼에 표시될 텍스트입니다.
					--%>
					<input type="submit" value="SEND">
					<%-- 
						- input type="reset"은 폼의 모든 입력값을 초기화하는 버튼을 생성합니다.
						- value="CANCEL"은 버튼에 표시될 텍스트입니다.
					--%>
					<input type="reset" value="CANCEL">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
