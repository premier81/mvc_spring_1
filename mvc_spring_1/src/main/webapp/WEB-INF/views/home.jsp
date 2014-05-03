<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<%=session.getId() %>
<P>  The time on the server is ${serverTime}. </P>
<p> <%=session.getAttribute("sesyjna") %> </p>

</body>
</html>
