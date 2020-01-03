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
    <title>Successful</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="header">
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/index"><button class="button">Events</button></a>
        <a href="${pageContext.request.contextPath}/addEvent"><button class="button">New event</button></a>
        <a href="${pageContext.request.contextPath}/search?search=nearest"><button class="button">Nearest events</button></a>
        <div style="float:right">
            <form action="${pageContext.request.contextPath}/search">
                <input class="btn-search" type="search" name="search" pattern="[^'\x22]+" title="Invalid input" placeholder="Search..">
            </form>
        </div>
    </div>
</div>
<div class="event-form">
    <div style="text-align: center; font-size: 18px; color: green;">
        ${requestScope.accessAddedEvent}
        ${requestScope.successedRemove}
        ${requestScope.AccessUpdated}
        ${requestScope.accessAddedTag}
        <meta http-equiv="refresh" content="1; url=${pageContext.request.contextPath}/index">
    </div>
</div>
</body>
</html>
