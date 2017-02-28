<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<title>Person removal</title>
</head>
<body>
<h1>
	Person removal!  
</h1>
	<form:form method="GET" action="/intern/removePersonSave">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"><td>				
			</tr>
		</table>
		<input type=submit id="btn1" name="Submit"/>
	</form:form>
		<button type="button" onclick="location = 'PhonebookRegistry'">Cancel</button>
</body>
</html>