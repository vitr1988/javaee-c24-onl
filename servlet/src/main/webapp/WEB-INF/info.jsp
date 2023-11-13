<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="static java.time.LocalDateTime.now" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.time.LocalDateTime" %>
<%-- это комментарий в JSP
  Created by IntelliJ IDEA.
  User: vitalijivanov
  Date: 01.11.2023
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Info about me</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<%!
  public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

  String getFormattedTime(LocalDateTime time) {
    return DATE_TIME_FORMATTER.format(time);
  }
%>
<body>
<%--    <%@ include file="header.jsp"%>--%>
    <jsp:include page="header.jsp">
        <jsp:param name="text" value="Header"/>
    </jsp:include>
    <% for (int i = 0; i < 3; i++) { %>
    <% if (i % 2 == 0) { %>
    <div id="main">
        <% String name = (String) request.getAttribute("name"); %>
        <p>My name is <%= Objects.toString(name, "Guest") %></p>
        <p>My name is <%= name %></p>
        <p>My name EL is ${name}</p>
        <p>Current time is <%= getFormattedTime(now()) %></p>
    </div>
    <% } %>
    <% } %>
<%--    <%@ include file="footer.jsp"%>--%>
    <jsp:include page="footer.jsp">
        <jsp:param name="text" value="Footer"/>
    </jsp:include>
</body>
</html>
