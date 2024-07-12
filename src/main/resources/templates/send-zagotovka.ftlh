<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Отправить часть деталей в ЦМО</h2>
<hr>
<table>
    <tr>
        <th>Номер детали</th>
        <th>Заявка</th>
        <th>Пила</th>
    </tr>
    <tr>
        <form action="/workshop/zagotovka/send/${part.id}" method="post">
            <td>${part.partNumber}</td>
            <td>${part.input}</td>
            <td><input type="number" name="saw" value="${part.saw}"/></td>
            <td><input type="submit" value="Отправить"/></td>
        </form>
    </tr>
</table>
</body>
</html>