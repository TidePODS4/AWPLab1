<!DOCTYPE HTML>
<html lang="ru" xml:lang="ru" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Submit</title>
</head>
<body>
<form method="post">
    <h1>Submit page!</h1>
    <label>Login:
        <input type="text" name="login">
    </label>
    <br/>
    <label>Password:
        <input type="password" name="password">
    </label>
    <br/>
    <label>Is admin:
        <input type="checkbox" name="isAdmin">
    </label>
    <br/>
    <button>Submit</button>
    <br/>
    <c:if isExists = "false">Пользователь уже существует!</c:if>
    <br/>
    <a href="login-user">Login user</a>
</form>
</body>
</html>