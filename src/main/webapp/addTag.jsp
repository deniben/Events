<%--
  Created by IntelliJ IDEA.
  User: dhosttc
  Date: 7/3/2019
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
// TODO doesn't realize
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Add tag</title>
</head>
<body>
<div class="header">
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/"><button class="button">Events</button></a>
        <a href="${pageContext.request.contextPath}/addEvent"><button class="button">New event</button></a>
        <div style="float:right">
            <form action="${pageContext.request.contextPath}/search">
                <input class="btn-search" type="search" name="search" pattern="[^'\x22]+" title="Invalid input" placeholder="Search..">
            </form>
        </div>
    </div>
</div>

<div class="event-form">
    <form method="post" action="${pageContext.request.contextPath}/addTag" id="addTagForm">
        <div class="panel-body">
            <legend style="text-align: center">Add tag</legend>
                <input required class="form-control" type="text" name="tag" id="tag" placeholder="Tag name"><hr>
            <p><input type="submit" value="Add"></p>
        </div>
    </form>
</div>

</body>
</html>
