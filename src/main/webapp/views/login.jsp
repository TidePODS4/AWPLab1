<!DOCTYPE HTML>
<html lang="ru" xml:lang="ru" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>LogIn page</title>
</head>
<body>
<form method="post">
    <h1>LogIn page!</h1>
    <label>Login:
        <input type="text" name="login">
    </label>
    <br/>
    <label>Password:
        <input type="password" name="password">
    </label>
    <br/>
    <button>login</button>
    <br/>
    <p>User valid status: <%=request.getAttribute("isUserValid")%></p>
</form>
</body>
</html>
