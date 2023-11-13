<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="ru" xml:lang="ru" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Панель администратора</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 2px 2px;
            cursor: pointer;
        }
        .button-delete {
            background-color: #f44336;
        }
        body {
            padding-top: 50px; /* Высота вашей кнопки + немного дополнительного пространства */
        }
        .logout-button {
            position: fixed; /* Фиксированное позиционирование, чтобы кнопка оставалась наверху при прокрутке */
            top: 10px;
            right: 10px;
            padding: 10px;
            background-color: #f44336;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
    <script>
        function toggleForm(formId) {
            let form = document.getElementById(formId);
            if (form.style.display === "none") {
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }
    </script>
</head>
<body>
<button class="logout-button" onclick="window.location.href='/login'">Выход</button>

<table>
    <tr>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Администратор</th>
        <th>Действия</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.admin}</td>
            <td>
                <button class="button" onclick="toggleForm('updateUserForm${user.login}')">Изменить</button>
                <div id="updateUserForm${user.login}" style="display:none">
                    <form action="/admin-panel" method="post">
                        <input type="hidden" name="_method" value="put"/>
                        <input type="hidden" name="login" value="${user.login}" />
                        <label for="password">Пароль:</label><br>
                        <input type="password" id="password" name="password"><br>
                        <label for="admin">Администратор:</label><br>
                        <input type="checkbox" id="admin" name="admin"><br>
                        <input type="submit" value="Сохранить" class="button">
                    </form>
                </div>
                <form action="/admin-panel" method="post">
                    <input type="hidden" name="_method" value="delete"/>
                    <input type="hidden" name="login" value="${user.login}" />
                    <input type="submit" value="Удалить" class="button button-delete"/>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>
<button class="button" onclick="toggleForm('addUserForm')">Добавить пользователя</button>
<div id="addUserForm" style="display:none">
    <form action="/admin-panel" method="post">
        <label for="login">Логин:</label><br>
        <input type="text" id="login" name="login"><br>
        <label for="password">Пароль:</label><br>
        <input type="password" id="password" name="password"><br>
        <label for="admin">Администратор:</label><br>
        <input type="checkbox" id="admin" name="admin"><br>
        <input type="submit" value="Добавить" class="button">
    </form>
</div>
</body>

</html>