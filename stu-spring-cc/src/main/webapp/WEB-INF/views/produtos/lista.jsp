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
<c:url value="/" var="cssPath" />
<link rel="stylesheet" href="${cssPath}resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${cssPath}resources/css/bootstrap-theme.min.css">
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
      <a class="navbar-brand" href="#">Casa do Código</a>
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


		<h1>Lista de Produtos</h1>
		<h1>${sucesso}</h1>

		<table
			class="table table-bordered table-hover table-condensed table-striped ">
			<thead>
				<tr>
					<th>Título</th>
					<th>Descrição</th>
					<th>Páginas</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td><a
							href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build()}">${produto.titulo}</a></td>
						<td>${produto.descricao}</td>
						<td>${produto.paginas}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>