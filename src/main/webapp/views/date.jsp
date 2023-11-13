<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html lang="ru" xml:lang="ru" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Дата</title>
    <style>
        .date {
            font-family: Arial, sans-serif;
            font-size: 20px;
            color: #333;
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
        function displayDate() {
            let date = new Date();
            let dateString = date.toLocaleString("ru-RU");
            document.getElementById("date").textContent = "Время: " + dateString;
        }
        window.onload = displayDate;
        setInterval(displayDate, 1000);
    </script>
</head>
<body>

<button class="logout-button" onclick="window.location.href='/login'">Выход</button>
<h1 id="date" class="date"></h1>
</body>
</html>
