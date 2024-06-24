<!DOCTYPE html>
<html>
<head>
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1>
<hr>
<h2>База данных гидроцилиндров</h2>
<form action="/cylinder" method="get">
    Поиск по номеру ГЦ: <input type="text" name="number"><br>
    <input type="submit" value="Поиск"/>
</form>
<table>
    <tr>
        <th>Номер гидроцилиндра</th>
        <th>Наименование</th>
        <th>Ссылка</th>
    </tr>
    <#list cylinders as cylinder>
    <tr>
        <td>${cylinder.number}</td>
        <td>${cylinder.name}</td>
        <td><a href="/cylinder/${cylinder.number}">Подробнее</a></td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>
<hr>
<h3>Добавить гидроцилиндр в базу данных</h3>
<form action="/cylinder/create" method="post">
    Номер гидроцилиндра: <input type="text" name="number"/><br><br>
    Наименование гидроцилиндра: <input type="text" name="name"/><br><br>
    <h4>Список деталей:</h4>
    <table>
        <tr>
            <th>Обозначение детали</th>
            <th>Наименование</th>
            <th>количество в ГЦ</th>
        </tr>
        <tr>
            <td><input type="text" name="params"/></td>
            <td><input type="text" name="params"/></td>
            <td><input type="number" name="params"/></td>
        </tr>
        <tr>
            <td><input type="text" name="params"/></td>
            <td><input type="text" name="params"/></td>
            <td><input type="number" name="params"/></td>
        </tr>
    </table>
<!--    Обозначение первой детали: <input type="text" name="params"/>-->
<!--    Наименование первой детали: <input type="text" name="params"/>-->
<!--    Количество в ГЦ: <input type="number" name="params"/><br><br>-->
<!--    Обозначение второй детали: <input type="text" name="params"/>-->
<!--    Наименование второй детали: <input type="text" name="params"/>-->
<!--    Количество в ГЦ: <input type="number" name="params"/><br><br>-->
    <input type="submit" value="Добавить ГЦ в БД>"/>
</form>
</body>
</html>