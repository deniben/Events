<%@ page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Search: ${search}</title>
</head>
<body>
<div class="header">
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/index"><button class="button">Events</button></a>
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
            <h3 style="color: green">${nearestSearch}
            ${searched}</h3>
        </div>
        <c:forEach items="${requestScope.events}" var="event">
            <div class="login-page">
                <div class="event-form">
                    <div class = "event-name">
                        <h3>${event.name}</h3>
                    </div>
                    <div>
                        <h5>Description:</h5>
                        <p>${event.description}</p>
                        <p><p>
                    </div>
                    <div>
                        Location: ${event.location} <div style="text-align: right">Time of begin: ${event.timeOfBegin}</div>
                        Tag: ${event.tag}
                        </br>
                        <div style="text-align: right"><a href="${pageContext.request.contextPath}/readmore?eventId=${event.id}">Read More</a></div>
                    </div>
                </div>
            </div>
        </c:forEach>
</body>
</html>