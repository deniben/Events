<%--
  Created by IntelliJ IDEA.
  User: dhosttc
  Date: 6/27/2019
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Edit event : ${requestScope.event.name}</title>
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
<form method="post" action="${pageContext.request.contextPath}/editEvent?eventId=${event.id}" id="editEventForm" >
    <div class="panel-body">
        <legend style="text-align: center">Edit event</legend>
<%--            <embed hidden="true"><p><label for="id">Event ID: </label><input required type="text" id="id" name="eventId" value="${event.id}" placeholder="${requestScope.event.id}" readonly></p></embed>--%>
            <p><label for="name">Event name:</label><input required type="text" id="name" name="name" value = "${event.name}"> </p>
            <label for="description">Description:</label><p><textarea required type="text" name="description" id="description" rows="24" cols="120">${event.description}</textarea></p>
<%--                <input required type="text" id="description" name="description" value="${event.description}"></p>--%>
            <p><label for="location">Location:</label><input required type="text" id="location" name="location" value="${event.location}"></p>
            <p><label for="tag">Tag:</label><input required type="text" id="tag" name="tag" value="${event.tag}"></p>
            <p><label for="timeOfBegin">Time spending:</label><input required type="date" id="timeOfBegin" name="timeOfBegin" value="${event.timeOfBegin}"></p>
    </div>
        <input type="submit" value="Edit">
</form>
</div>

</body>
</html>
