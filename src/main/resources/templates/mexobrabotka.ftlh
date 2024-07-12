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
<h3>Добавить детали в производство</h3>
<form action="/workshop/mexobrabotka/create" method="post">
    <table>
        <tr>
            <th>Номер детали</th>
            <th>Заявка</th>
            <th>Ток 1</th>
            <th>Ток 2</th>
            <th>Ток 3</th>
            <th>Сверл</th>
            <th>Фрезер</th>
        </tr>
        <tr>
            <td><input type="text" name="partNumber"/></td>
            <td><input type="number" name="input"/></td>
            <td><input type="number" name="turning1"/></td>
            <td><input type="number" name="turning2"/></td>
            <td><input type="number" name="turning3"/></td>
            <td><input type="number" name="drilling"/></td>
            <td><input type="number" name="milling"/></td>
        </tr>
    </table>
    <input type="submit" value="Добавить"/>
</form>
<hr>
<table>
    <tr>
        <th>Номер детали</th>
        <th>Заявка</th>
        <th>Ток 1</th>
        <th>Ток 2</th>
        <th>Ток 3</th>
        <th>Сверл</th>
        <th>Фрезер</th>
        <th>Действие</th>
    </tr>
<#list parts as part>
    <tr>
        <td>${part.partNumber}</td>
        <td>${part.input}</td>
        <td>${part.turning1}</td>
        <td>${part.turning2}</td>
        <td>${part.turning3}</td>
        <td>${part.drilling}</td>
        <td>${part.milling}</td>
        <td><form action="/workshop/mexobrabotka/delete/${part.id}" method="post">
                <input type="submit" value="Удалить "/>
            </form>
            <a href="/workshop/mexobrabotka/send/${part.id}">Отправить детали</a><br>
            <a href="/workshop/mexobrabotka/edit/${part.id}">Редактировать</a>
        </td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>
</body>
</html>