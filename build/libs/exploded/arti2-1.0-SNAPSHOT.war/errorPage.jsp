<%--
  Created by IntelliJ IDEA.
  User: dhosttc
  Date: 7/2/2019
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="header">
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/"><button class="button">Events</button></a>
        <a href="${pageContext.request.contextPath}/addEvent"><button class="button">New event</button></a>
        <a href="${pageContext.request.contextPath}/search?search=nearest"><button class="button">Nearest events</button></a>
        <div style="float:right">
            <form action="${pageContext.request.contextPath}/search">
                <input class="btn-search" type="text" name="search" placeholder="Search..">
            </form>
        </div>
    </div>
</div>
<div class="event-form">
    <div style="text-align: center;">
        <div style="color: red; font-size: 18px">
            ${requestScope.errorAddEvent}
            ${requestScope.errorUpdateEvent}
            ${requestScope.errors}
            ${requestScope.SearchNotFount}
        </div>
    </div>
</div>
</body>
</html>
