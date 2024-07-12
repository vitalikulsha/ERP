<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Редактирование мехобработки</h2>
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
    </tr>
    <tr>
        <form action="/workshop/mexobrabotka/edit/${part.id}" method="post">
            <td>${part.partNumber}</td>
            <td>${part.input}</td>
            <td><input type="number" name="turning1" value="${part.turning1}"/></td>
            <td><input type="number" name="turning2" value="${part.turning2}"/></td>
            <td><input type="number" name="turning3" value="${part.turning3}"/></td>
            <td><input type="number" name="drilling" value="${part.drilling}"/></td>
            <td><input type="number" name="milling" value="${part.milling}"/></td>
            <td><input type="submit" value="Изменить"/></td>
        </form>
    </tr>
</table>
</body>
</html>