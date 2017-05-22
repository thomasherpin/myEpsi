<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
<%
out.println(session.getAttribute("mail"));
String userid = session.getAttribute("mail").toString();
%>
<div id=container>
	<h1 class="text-center"><span class="label label-success">Accueil</span></h1>

<!-- 	<form id="redirection" method="GET" action="messageredirection">
	</form>
 -->		
 	<h2 class="text-center"><a href="newmessage.jsp"><input type="button" class="btn btn-lg btn-primary" value="Créer un nouveau message !"/></a>
	</h2>
	<div class="col-sm">
 		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Mes messages</h3>
			</div>
			<div class="panel-body">
				<p><b>A récupérer</b>: Liste de tous ces messages</p>
				<p><g>Icone</g>Titre</p>
				<p>Auteur</p>
				<p>Date de modification</p>
			</div>
		</div>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Liste des messages public</h3>
			</div>
			<div class="panel-body">
			  <b>A récupérer</b>: Panel content
			</div>
		</div>
			<div class="panel panel-danger">
			    <div class="panel-heading">
					<h3 class="panel-title"><b>A récupérer</b>: Liste des messages de l'administrateur</h3>
			    </div>
			    <div class="panel-body">
			      <b>A récupérer</b>: Panel content
			    </div>
			</div>
		</div>
	</div>
	
</body>
</html>