<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Заготовительный участок</h2>
<hr>
<h3>Добавить отрезанные заготовки</h3>
<form action="/workshop/zagotovka/create" method="post">
    <table>
        <tr>
            <th>Номер детали</th>
            <th>Заявка</th>
            <th>Пила</th>
        </tr>
        <tr>
            <td><input type="text" name="partNumber"/></td>
            <td><input type="number" name="input"/></td>
            <td><input type="number" name="saw"/></td>
        </tr>
    </table>
    <input type="submit" value="Добавить"/>
</form>
<hr>
<table>
    <tr>
        <th>Номер детали</th>
        <th>Приход</th>
        <th>Пила</th>
        <th>Действия</th>
    </tr>
<#list workpiece as workpiece>
    <tr>
        <td>${workpiece.partNumber}</td>
        <td>${workpiece.input}</td>
        <td>${workpiece.saw}</td>
        <td>
            <form action="/workshop/zagotovka/delete/${workpiece.id}" method="post">
                <input type="submit" value="Удалить "/>
            </form>
            <form action="/workshop/zagotovka/send-all/${workpiece.id}" method="post">
                <input type="submit" value="Отправить всё в ЦМО "/>
            </form>
            <a href="/workshop/zagotovka/edit/${workpiece.id}">Редактировать</a>
        </td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>
</body>
</html>