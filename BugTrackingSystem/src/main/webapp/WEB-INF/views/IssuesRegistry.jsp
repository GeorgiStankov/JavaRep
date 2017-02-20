<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Issues Registry</title>
</head>
<body>
	<h1>Issues Registry</h1>
		<button type="button" onclick="location = 'actionIssue'">Issue
		Actions</button>
	<table border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Date</td>
				<td>Description</td>
				<td>Owner</td>
			</tr>
		</thead>

		<c:if test="${not empty Issues }">
			<tbody>
				<c:forEach var="s" items="${Issues}">
					<tr>
						<td>${s.id }</td>
						<td>${s.title }</td>
						<td>${s.date }</td>
						<td>${s.description }</td>
						<td>${s.owner.name }</td>
					</tr>
				</c:forEach>

			</tbody>
		</c:if>


	</table>

</body>
</html>
