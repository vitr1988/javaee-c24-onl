<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello, World!!</title>
</head>
<body>
    Hello, ${userName}!

    <form method="post" action="/hello">
        <input type="text" name="login" placeholder="Login:"/><br/>
        <input type="password" name="password" placeholder="Password:"/><br/>
        <button type="submit"/>
    </form>
</body>
</html>
