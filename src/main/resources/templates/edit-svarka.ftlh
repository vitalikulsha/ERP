<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Редактирование сварки</h2>
<hr>
<table>
    <tr>
        <th>Номер детали</th>
        <th>Заявка</th>
        <th>Сварка 1/th>
        <th>Сварка 2</th>
        <th>Зачистка</th>
    </tr>
    <tr>
        <form action="/workshop/mexobrabotka/edit/${part.id}" method="post">
            <td>${part.partNumber}</td>
            <td>${part.input}</td>
            <td><input type="number" name="welding1" value="${part.welding1}"/></td>
            <td><input type="number" name="welding2" value="${part.welding2}"/></td>
            <td><input type="number" name="cleaning" value="${part.cleaning}"/></td>
            <td><input type="submit" value="Изменить"/></td>
        </form>
    </tr>
</table>
</body>
</html>