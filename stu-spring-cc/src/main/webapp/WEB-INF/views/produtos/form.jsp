<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/stu-spring-cc/produtos" method="post">
		<div>
			<label>T�tulo</label> <input type="text" name="titulo" />
		</div>
		<div>
			<label>Descri��o</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
		</div>
		<div>
			<label>P�ginas</label> <input type="text" name="paginas" />
		</div>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>