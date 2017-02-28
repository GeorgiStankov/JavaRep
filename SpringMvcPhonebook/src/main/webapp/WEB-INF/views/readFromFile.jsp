<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<title>Reading From File</title>
</head>
<body>
<h1>
	Reading from File!  
</h1>
<h1>Enter directory with double slash "//".Example "C:\\Users\\User\\Desktop\\example.txt"</h1>
	<form:form method="GET" action="/intern/readFromFileSave">
		<table>
			<tr>
				<td>Directory</td>
				<td><input type="text" name="name"><td>				
			</tr>
		</table>
		<input type=submit id="btn1" name="Submit"/>
	</form:form>
		<button type="button" onclick="location = 'PhonebookRegistry'">Cancel</button>
</body>
</html>