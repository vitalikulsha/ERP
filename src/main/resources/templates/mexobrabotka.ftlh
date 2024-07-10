<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Участок мехобработки</h2>
<hr>
<h3>Добавить обработанные детали</h3>
<form action="/workshop/mexobrabotka/create" method="post">
    <table>
        <tr>
            <th>Номер детали</th>
            <th>Ток 1</th>
            <th>Ток 2</th>
            <th>Ток 3</th>
            <th>Сверл</th>
            <th>Фрезер</th>
        </tr>
        <tr>
            <td><input type="text" name="partNumber"/></td>
            <td><input type="text" name="turning1"/></td>
            <td><input type="text" name="turning2"/></td>
            <td><input type="number" name="turning3"/></td>
            <td><input type="date" name="drilling"/></td>
            <td><input type="date" name="milling"/></td>
        </tr>
    </table>
    <input type="submit" value="Добавить"/>
</form>
<hr>
<table>
    <tr>
        <th>Номер детали</th>
        <th>Приход</th>
        <th>Ток 1</th>
        <th>Ток 2</th>
        <th>Ток 3</th>
        <th>Сверл</th>
        <th>Фрезер</th>
        <th>Действие</th>
    </tr>
<#list mexobrabotka as mexobrabotka>
    <tr>
        <td>${mexobrabotka.partNumber}</td>
        <td>${mexobrabotka.input}</td>
        <td>${mexobrabotka.turning1}</td>
        <td>${mexobrabotka.turning2}</td>
        <td>${mexobrabotka.turning3}</td>
        <td>${mexobrabotka.drilling}</td>
        <td>${mexobrabotka.milling}</td>
        <td><form action="/workshop/mexobrabotka/delete/${mexobrabotka.id}" method="post">
                <input type="submit" value="Удалить "/>
            </form>
            <a href="/workshop/mexobrabotka/edit/${mexobrabotka.id}">Редактировать</a>
        </td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>
</body>
</html>