<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Участок сварки</h2>
<hr>
<h3>Добавить детали в производство</h3>
<form action="/workshop/svarka/create" method="post">
    <table>
        <tr>
            <th>Номер детали</th>
            <th>Заявка</th>
            <th>Сварка 1</th>
            <th>Сварка 2</th>
            <th>Зачистка</th>
        </tr>
        <tr>
            <td><input type="text" name="partNumber"/></td>
            <td><input type="number" name="input"/></td>
            <td><input type="number" name="welding1"/></td>
            <td><input type="number" name="welding2"/></td>
            <td><input type="number" name="cleaning"/></td>
        </tr>
    </table>
    <input type="submit" value="Добавить"/>
</form>
<hr>
<table>
    <tr>
        <th>Номер детали</th>
        <th>Заявка</th>
        <th>Сварка 1</th>
        <th>Сварка 2</th>
        <th>Зачистка</th>
        <th>Действие</th>
    </tr>
<#list parts as part>
    <tr>
        <td>${part.partNumber}</td>
        <td>${part.input}</td>
        <td>${part.welding1}</td>
        <td>${part.welding2}</td>
        <td>${part.cleaning}</td>
        <td><form action="/workshop/svarka/delete/${part.id}" method="post">
                <input type="submit" value="Удалить "/>
            </form>
            <a href="/workshop/svarka/edit/${part.id}">Редактировать</a>
        </td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>
</body>
</html>