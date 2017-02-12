<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<title>Dev addition</title>
</head>
<body>
<h1>
	Dev addition!  
</h1>
	<form:form method="POST" action="/bugtracking/addDeveloperSave" modelAttribute="developer">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"><td>
				<td>Role</td>
				<td><input type="text" name="role"><td>
				<td>Starting Date </td>
				<td><input type="text" name="date"><td>
				<td>Team Lead ID</td>
				<td><input type="text" name="teadLeadID"><td>
			</tr>
		</table>
		<input type=submit id="btn1" name="Submit"/>
	</form:form>
</body>
</html>