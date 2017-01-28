<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
	<title>PhoneBook Registry</title>
	</head>
		<body>
			<h1>PhoneBook Registry</h1>
			<button type="button" onclick="location = 'addPerson'">Add Person</button>
			<button type="button" onclick="location = 'removePerson'">Remove Person</button>
			<button type="button" onclick="location = 'readFromFile'">Reading From File</button>
			<button type="button" onclick="location = 'calling'">Make a call</button>
		    <table border="1">
		    <thead>
			    <tr> 
			        <td>Name</td>
			        <td>Number</td>    
			    </tr>
			</thead>
			
			<c:if test="${not empty Phonebooks }">
				<tbody>
				    <c:forEach var="s" items="${Phonebooks}">
				       <tr>
				          <td>${s.name }</td>
				          <td>${s.number }</td>
				       </tr>
				    </c:forEach>
				
				</tbody>
		    </c:if>		
		    
		    
		    </table>
		
		</body>
</html>
