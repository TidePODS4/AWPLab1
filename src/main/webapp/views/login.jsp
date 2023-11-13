<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html lang="ru" xml:lang="ru" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .login-form {
            width: 300px;
            margin: 0 auto;
            padding: 30px 0;
        }
        .login-form h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        .login-form label {
            display: block;
            margin-bottom: 10px;
        }
        .login-form input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }
        .login-form button {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
        }
        .login-form button:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            text-align: center;
        }
        .button {
            background-color: #4CAF50; /* Зеленый */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }

    </style>
</head>
<body>
<form class="login-form" method="post">
    <h1>Добро пожаловать!</h1>
    <label>Логин:
        <input type="text" name="login">
    </label>
    <br/>
    <label>Пароль:
        <input type="password" name="password">
    </label>
    <br/>
    <br/>
    <button class="button">Войти</button>
    <br/>
    <% if (request.getAttribute("isUserValid") != null && !((boolean) request.getAttribute("isUserValid"))) { %>
    <p class="error-message"> Неверный логин или пароль! </p>
    <% } %>
</form>
</body>
</html>
