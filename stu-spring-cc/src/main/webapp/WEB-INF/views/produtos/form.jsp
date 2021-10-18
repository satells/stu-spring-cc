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
<c:url value="/" var="cssPath"/>
<link rel="stylesheet" href="${cssPath}resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}resources/css/bootstrap-theme.min.css">


</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Home</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${s:mvcUrl('PC#lista').build()}">Lista de Produtos</a></li>
        <li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div>
</nav>
	<div class="container">



	<form action="${s:mvcUrl('PC#gravar').build()}" method="POST" enctype="multipart/form-data" >

		<c:set var="err">
			<form:errors path="*" element="div" id="err" cssClass="hidden" />
		</c:set>
		<%-- <form action="${s:mvcUrl('PC#gravar').build()}" method="POST"> --%>
		<div class="form-group">
			<label>Título</label>
			<form:input path="produto.titulo" cssClass="form-control" />
			<form:errors path="produto.titulo" />

		</div>
		<div class="form-group">
			<label>Descrição</label>
			<form:textarea path="produto.descricao" cssClass="form-control" />
			<form:errors path="produto.descricao" />
		</div>
		<div class="form-group">
			<label>Páginas</label>
			<form:input path="produto.paginas" cssClass="form-control" />
			<form:errors path="produto.paginas" />
		</div>
		<div class="form-group">
			<label>Data de Lançamento</label>
			<form:input path="produto.dataLancamento" cssClass="form-control" />
			<form:errors path="produto.dataLancamento" />
		</div>


		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div class="form-group">
				<label>${tipoPreco}</label>
				<form:input path="produto.precos[${status.index}].valor" cssClass="form-control" />
				<form:hidden path="produto.precos[${status.index}].tipo"
					value="${tipoPreco}" />
			</div>
		</c:forEach>
		<div class="form-group">
			<label>Sumário</label>
			<input name="sumario" type="file"class="form-control" />
		</div>


		<button type="submit" class="btn btn-primary">Cadastrar</button>
	</form>
	</div>
</body>
</html>