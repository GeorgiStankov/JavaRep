<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Issue addition</title>
</head>
<body>
	<h1>Issue addition!</h1>
	<form:form method="POST" action="/bugtracking/addIssueSave"
		modelAttribute="developer">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id">
				<td>
				<td>Title</td>
				<td><input type="text" name="title">
				<td>
				<td>Date</td>
				<td><input type="text" name="date">
				<td>
				<td>Description</td>
				<td><input type="text" name="description">
				<td>
			</tr>
		</table>
		<input type=submit id="btn1" name="Submit" />
	</form:form>

	<h1>Issue removal!</h1>
	<form:form method="GET" action="/bugtracking/removeIssueSave"
		modelAttribute="developer">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id">
				<td>
			</tr>
		</table>
		<input type=submit id="btn1" name="Submit" />
	</form:form>
	
		<h1>Issue edit!</h1>
	<form:form method="POST" action="/bugtracking/editIssueSave"
		modelAttribute="developer">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id">
				<td>
				<td>Title</td>
				<td><input type="text" name="title">
				<td>
				<td>Date</td>
				<td><input type="text" name="date">
				<td>
				<td>Description</td>
				<td><input type="text" name="description">
				<td>
			</tr>
		</table>
		<input type=submit id="btn1" name="Submit" />
	</form:form>
</body>
</html>