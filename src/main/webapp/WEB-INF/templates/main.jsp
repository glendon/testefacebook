<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/static/stylesheets/estilo.css"/>" />
<!-- Inclusão do título pelo Tiles -->
<title><tiles:getAsString name="titulo" /></title>
</head>
<body>
	<!-- Inclusão do cabeçalho -->
	<tiles:insertAttribute name="cabecalho" />
	<!-- Inclusão do conteúdo -->
	<tiles:insertAttribute name="conteudo" />
	<!-- Inclusão do rodapé -->
	<tiles:insertAttribute name="rodape" />
</body>
</html>