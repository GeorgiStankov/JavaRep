<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<title>Person addition</title>
</head>
<body>
<h1>
	Person addition!  
</h1>
	<form:form method="POST" action="/intern/addPersonSave" modelAttribute="person">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"><td>
				<td>Number</td>
				<td><input type="text" name="number"><td>
			</tr>
		</table>
		<input type=submit id="btn1" name="Submit"/>
	</form:form>
</body>
</html>