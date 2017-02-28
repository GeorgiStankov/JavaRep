<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Making a call</title>
</head>
<body>
	<h1>Making a call!</h1>
	<form:form method="POST" action="/intern/callSave">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"><td>
				<td>Number</td>
				<td><input type="text" name="number"><td>
			</tr>
		</table>
		<input type=submit id="btn1" name="Submit" />
	</form:form>
	<button type="button" onclick="location = 'PhonebookRegistry'">Cancel</button>
</body>
</html>