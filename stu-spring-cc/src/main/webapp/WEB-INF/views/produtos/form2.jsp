<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${s:mvcUrl('PC#gravar').build()}" method="POST">

		<c:set var="err">
			<form:errors path="*" element="div" id="err" cssClass="hidden" />
		</c:set>
		<%-- <form action="${s:mvcUrl('PC#gravar').build()}" method="POST"> --%>
		<div>
			<label>Título</label> <input type="text" name="titulo" />
			<form:errors path="produto.titulo" />

		</div>
		<div>
			<label>Descrição</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
			<form:errors path="produto.descricao" />
		</div>
		<div>
			<label>Páginas</label> <input type="text" name="paginas" />
			<form:errors path="produto.paginas" />
		</div>


		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label> <input type="text"
					name="precos[${status.index}].valor"> <input type="hidden"
					name="precos[${status.index}].tipo" value="${tipoPreco}">
			</div>
		</c:forEach>


		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>