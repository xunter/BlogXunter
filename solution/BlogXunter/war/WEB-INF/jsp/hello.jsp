<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Blog by ][unter :: Spring Application</title>
        <link rel="stylesheet" type="text/css" href="../css/articles.css" />
    </head>
    <body>
        <div id="header"><h1>Blog by ][unter</h1></div>
        <div id="content">
        <c:forEach items="${model.articles}" var="artes">
      		<div style="margin-top: 10px;"><c:out value="${artes.author}"/> - <c:out value="${artes.date}"/></div>
      		<div style="color: #777777; margin-left: 10px;"><c:out value="${artes.text}"/></div><br />
    	</c:forEach>
        </div>
        
        <div id="footer">2010 &copy; Blog by ][unter</div>

    </body>
</html>