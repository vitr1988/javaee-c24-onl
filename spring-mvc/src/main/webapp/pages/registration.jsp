<%--
  Created by IntelliJ IDEA.
  User: vitalijivanov
  Date: 27.12.2023
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <form action="/reg" method="post">
        <input type="text" name="login" placeholder="Login: " value="${user.login}" required/> <label>${loginErrorLabel}</label> <br/>
        <input type="text" name="email" placeholder="Email: " value="${user.email}"/> <label>${emailErrorLabel}</label> <br/>
        <input type="password" name="password" placeholder="Password: " value="${user.password}" required/> <label>${passwordErrorLabel}</label> <br/>
        <input type="number" name="age" placeholder="Age: " value="${user.age}"/> <label>${ageErrorLabel}</label> <br/>
        <input type="submit" value="Register"/>
    </form>

</body>
</html>
