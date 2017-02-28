<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Outgoing Calls Registry</title>
</head>
<body>
	<h1>Outgoing Calls Registry</h1>
	<button type="button" onclick="location = 'PhonebookRegistry'">Back
		to Phonebook Registry</button>

	<table border="1">
		<thead>
			<tr>
				<td>Name and number</td>
				<td>Number of calls</td>
			</tr>
		</thead>

		<c:if test="${not empty outgoingCalls }">
			<tbody>
				  <c:forEach var="s" items="${outgoingCalls}">
					 <tr>
						<td>${s.name}</td>
						<td>${s.number}</td>
				 </tr>
					
				</c:forEach>

			</tbody>
		</c:if>


	</table>

</body>
</html>
