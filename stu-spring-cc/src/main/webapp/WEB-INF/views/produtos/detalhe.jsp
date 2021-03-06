<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<c:url value="/" var="contextPath" />

<title>${produto.titulo}</title>
<link href="${contextPath}resources/css/cssbase-min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' />
<link href="${contextPath}resources/css/fonts.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-ie7.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-embedded.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/layout-colors.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/responsive-style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/guia-do-programador-style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/produtos.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="canonical" href="http://www.casadocodigo.com.br/" />

</head>
<body class="produto">

	<header id="layout-header">
		<div class="clearfix container">
			<a href="/" id="logo"> </a>
			<div id="header-content">
				<nav id="main-nav">
					<ul class="clearfix">
						<li><a href="/carrinho" rel="nofollow">Carrinho Seu
								Carrinho (${carrinhoCompras.quantidade}) </a></li>


					</ul>
				</nav>
			</div>
		</div>
	</header>

	<article id="${produto.id}">
		<header id="product-highlight" class="clearfix">
			<div id="product-overview" class="container">

				<h1 class="product-title">${produto.titulo}</h1>
				<p class="product-author">
					<span class="product-author-link"> </span>
				</p>

				<p class="book-description">${produto.descricao}</p>
			</div>
		</header>

		<section class="buy-options clearfix">
			<form action="${contextPath}carrinho/add" method="post"
				class="container">


				<input type="hidden" value="${produto.id}" name="produtoId" />
				<ul id="variants" class="clearfix">
					<c:forEach items="${produto.precos}" var="preco">
						<li class="buy-option">
						<input type="radio" name="tipoPreco"class="variant-radio" id="tipo" value="${preco.tipo}" checked="checked" />
						<label class="variant-label">${preco.tipo}</label>
						<small class="compare-at-price">R$ 39,90</small>
						<p class="variant-price">${preco.valor}</p></li>
					</c:forEach>
				</ul>


				<button type="submit" class="submit-image icon-basket-alt"
					title="Compre Agora AQUI COLOQUE O TITULO">Compre aqui</button>
			</form>
		</section>

		<div class="container">
			<section class="summary">
				<ul>
					<li>
						<h3>
							E muito mais... <a href='/pages/sumario-java8'>veja o sum??rio</a>.
						</h3>
					</li>
				</ul>
			</section>

			<section class="data product-detail">
				<h2 class="section-title">Dados do livro:</h2>
				<p>
					N??mero de p??ginas: <span>${produto.paginas}</span>
				</p>
				<p></p>
				<p>
					Data de publica????o:
					<fmt:formatDate value="${produto.dataLancamento.time}"
						pattern="dd/MM/yyyy" />
				</p>
				<p>
					Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta
						uma errata</a>
				</p>
			</section>
		</div>
	</article>

	<footer id="layout-footer">
		<div class="clearfix container">

			<div id="collections-footer">
				<!-- cdc-footer -->
				<p class="footer-title">Cole????es de Programa????o</p>
				<ul class="footer-text-links">
					<li><a href="/collections/livros-de-java">Java</a></li>
					<li><a href="/collections/livros-desenvolvimento-web">Desenvolvimento
							Web</a></li>
					<li><a href="/collections/livros-de-mobile">Mobile</a></li>
					<li><a href="/collections/games">Games</a></li>
					<li><a href="/collections/livros-de-front-end">Front End</a></li>
				</ul>
				<p class="footer-title">Outros Assuntos</p>
				<ul class="footer-text-links">
					<li><a href="/collections/livros-de-agile">Agile</a></li>
					<li><a href="/collections/outros">e outros...</a></li>
				</ul>
			</div>
			<div id="social-footer">
				<!-- books-footer -->
				<p class="footer-title">Links da Casa do C??digo</p>
				<ul class="footer-text-links">
					<li><a href="http://livros.casadocodigo.com.br" rel="nofollow">Meus
							E-books</a></li>
					<li><a href="/pages/sobre-a-casa-do-codigo">Sobre a Casa
							do C??digo</a></li>
					<li><a href="/pages/perguntas-frequentes">Perguntas
							Frequentes</a></li>
					<li><a href="https://www.caelum.com.br">Caelum - Ensino e
							Inova????o</a></li>
					<li><a href="http://www.codecrushing.com/" rel="nofollow">Code
							Crushing</a></li>
					<li><a
						href="http://www.casadocodigo.com.br/pages/politica-de-privacidade"
						rel="nofollow">Pol??tica de Privacidade</a></li>
				</ul>
				<p class="footer-title">Redes Sociais</p>
				<ul>
					<li class="social-links"><a
						href="http://www.twitter.com/casadocodigo" target="_blank"
						id="twitter" rel="nofollow">Facebook</a> <a
						href="http://www.facebook.com/casadocodigo" target="_blank"
						id="facebook" rel="nofollow">Twitter</a></li>
				</ul>
			</div>
			<div id="newsletter-footer">
				<!-- social-footer -->
				<p class="footer-title">Receba as Novidades e Lan??amentos</p>
				<div id="form-newsletter">
					<form action="" method="POST" id="ss-form" class="form-newsletter">
						<ul>
							<li>
							<input type="hidden" name="pageNumber" value="0" />
							<input	type="hidden" name="backupCache" value="" />
							<input type="email" 								name="entry.0.single" value="" class="ss-q-short" id="entry_0"
								placeholder="seu@email.com" /></li>
							<li><input type="submit" name="submit"
								value="Quero Receber!" id="submit-newsletter" /></li>
						</ul>
					</form>
					<ul>
						<li class="ie8"><a href="" rel="nofollow">Receba as
								Novidades e Lan??amentos</a></li>
					</ul>
				</div>
				<ul class="footer-payments">
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</footer>
</body>
</html>