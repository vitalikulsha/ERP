<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Отправить часть деталей</h2>
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
        <th>Кол. деталей</th>
    </tr>
    <tr>
        <form action="/workshop/mexobrabotka/send/${part.id}" method="post">
            <td>${part.partNumber}</td>
            <td>${part.input}</td>
            <td>${part.turning1}</td>
            <td>${part.turning2}</td>
            <td>${part.turning3}</td>
            <td>${part.drilling}</td>
            <td>${part.milling}</td>
            <td><input type="number" name="quantity" value="0"/></td>
            <td>
                <select name="workshop">
                    <option value="welding">Сварка</option>
                    <option value="assembly">Сборка</option>
                    <option value="stock">Склад</option>
                </select>
            </td>
            <td><input type="submit" value="Отправить"/></td>
        </form>
    </tr>
</table>
</body>
</html>