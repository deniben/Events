<%--
  Created by IntelliJ IDEA.
  User: Deniben
  Date: 7/1/2019
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Event: ${event.name}</title>
</head>
<body>
<div class="header">
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/"><button class="button">Events</button></a>
        <a href="${pageContext.request.contextPath}/addEvent"><button class="button">New event</button></a>
        <a href="${pageContext.request.contextPath}/search?search=nearest"><button class="button">Nearest events</button></a>
        <div style="float:right">
            <form action="${pageContext.request.contextPath}/search">
                <input class="btn-search" type="search" name="search" pattern="[^'\x22]+" title="Invalid input" placeholder="Search..">
            </form>
        </div>
    </div>
</div>
    <div class="login-page">
        <div class="event-form">
            <div class = "event-name">
                <h3>Name: ${event.name}</h3>
            </div>
            <div>
                <h5>Description:</h5>
                <p>${event.description}</p>
            </div>
            <div>
                Location: ${event.location} <div style="text-align: right">Time of begin: ${event.timeOfBegin}</div>
                Tag: ${event.tag} <c:forEach items="${tags}" var="tag">${tag.tag} </c:forEach>
                </br>
                <a href="${pageContext.request.contextPath}/editEvent?eventId=${event.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/removeEvent?eventId=${event.id}" onclick="return confirm('Are you sure you want to delete this event?')">Remove</a>
            </div>
        </div>
    </div>
</body>
</html>
