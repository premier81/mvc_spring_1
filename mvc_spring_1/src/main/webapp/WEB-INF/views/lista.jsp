<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>to jest model zwrocony z controllera</h3>
<%=session.getId() %>
<%=request.getAttribute("666") %>
<br>
to jest wartosc zmiennej z sesji
<%=session.getAttribute("sesyjna") %>
<br>
to jest wartosc zmiennej z sesji ustawiona atrubutem SessionAttribute. 
<br> wystarczy podac w anotacji, ze w modelu jedna ze zmiennych bedzie sesyna: 
<br>
<%=session.getAttribute("sesyjna2") %>
</body>
</html>