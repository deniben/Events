<%--
  Created by IntelliJ IDEA.
  User: dhosttc
  Date: 26.06.2019
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Add Event</title>
</head>
<body>

<div class="header">
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/"><button class="button">Events</button></a>
        <a href="${pageContext.request.contextPath}/search?search=nearest"><button class="button">Nearest events</button></a>
        <div style="float:right">
            <form action="${pageContext.request.contextPath}/search">
                <input class="btn-search" type="search" name="search" pattern="[^'\x22]+" title="Invalid input" placeholder="Search..">
            </form>
        </div>
    </div>
</div>

<div class="event-form">
<form action="${pageContext.request.contextPath}/addEvent" method="post" id="addEventForm">
    <div class="panel-body">
        <legend style="text-align: center">Add event</legend>
        <p><label for="name">Event name: </label> <input required type="text" id="name" name="name" placeholder="Event name"></p>
        <p><label for="description">Description:</label></p> <textarea wrap="hard" required rows="18" cols="120" type="text" id="description" placeholder="Type some description..." name="description"></textarea>
        <p><label for="location">Location:</label> <input required type="text" id="location" name="location"></p>
        <p><label for="tag">Tag:</label> <input required type="text" id="tag" name="tag"></p>
<%--        <select required multiple class="form-control" name="tags" id="tags">--%>
<%--        <c:forEach items="${requestScope.tags}" var="tag">--%>
<%--            <option class="form-control" value=${tag.id}>${tag.tag}</option>--%>
<%--        </c:forEach>--%>
<%--        </select><br>--%>
        <p><label for="timeOfBegin">Date sending:</label> <input required type="date" id="timeOfBegin" name="timeOfBegin"></p>
        <p><input type="submit" value="Add"></p>
    </div>
</form>
</div>
</body>
</html>
