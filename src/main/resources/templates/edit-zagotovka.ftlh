<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Редактирование заготовительной операции</h2>
<hr>
<table>
    <tr>
        <th>Номер детали</th>
        <th>Приход</th>
        <th>Пила</th>
    </tr>
    <tr>
        <form action="/workshop/zagotovka/edit/${part.id}" method="post">
            <td><input type="text" name="partNumber" value="${part.partNumber}" readonly disabled/></td>
            <td><input type="number" name="input" value="${part.input}"/></td>
            <td><input type="number" name="saw" value="${part.saw}"/></td>
            <td><input type="submit" value="Изменить"/></td>
        </form>
    </tr>
</table>
</body>
</html>