<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
	<title>Developers Registry</title>
	</head>
		<body>
			<h1>Developers Registry</h1>
			<button type="button" onclick="location = 'addDeveloper'">Add Developer</button>
		    <table border="1">
		    <thead>
			    <tr> 
			        <td>Name</td>
			        <td>Role</td>  
			        <td>Date</td>    
			    </tr>
			</thead>
			
			<c:if test="${not empty Devs }">
				<tbody>
				    <c:forEach var="s" items="${Devs}">
				       <tr>
				          <td>${s.name }</td>
				          <td>${s.role }</td>
				          <td>${s.date }</td>
				       </tr>
				    </c:forEach>
				
				</tbody>
		    </c:if>		
		    
		    
		    </table>
		
		</body>
</html>
