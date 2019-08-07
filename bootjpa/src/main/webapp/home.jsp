<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h3>Insert</h3>
<form action="addAlien">
<pre>
	Id: <input type="text" name="aid"><br>
	Name: <input type="text" name="aname"><br>
	Tech: <input type="text" name="tech"><br>
	<input type="submit"><br>
</pre>
</form>
<hr>
<h3>Get By Id</h3>
<form action="getAlienById">
<pre>
	Id: <input type="text" name="aid"><br>
	<input type="submit"><br>
</pre>
</form>
<hr>
<h3>Get By Tech</h3>
<form action="getAlienByTech">
<pre>
	Tech: <input type="text" name="tech"><br>
	<input type="submit"><br>
</pre>
</form>
</body>
</html>