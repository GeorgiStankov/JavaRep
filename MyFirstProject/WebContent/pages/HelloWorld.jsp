<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<c:set var="date" value="<%= new java.util.Date() %>"/>
<c:set var="bool" value="true"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><ct:Header title="Java Web Programming"/>>Hello World</title>
</head>
<body>

<ct:Footer/><br>

<c:if test="${bool != false}">
${date}
</c:if>
       
</body>
</html>