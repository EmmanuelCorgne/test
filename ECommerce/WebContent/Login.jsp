<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="CreerClient" />
	Pseudo:
	<input type="text" name="pseudo" /> MDP:
	<input type="password" name="mdp" />
	<input type="submit" name="bouton" value="Se connecter"
		style="background-color: #1E90FF" />
	<H1>${bean.erreur}</H1>
	</form>
</body>
</html>