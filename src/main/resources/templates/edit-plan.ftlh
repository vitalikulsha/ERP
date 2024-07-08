<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Редактирование плана производства</h2>
<hr>
<table>
    <tr>
        <th>Номер заказа</th>
        <th>Заказчик</th>
        <th>Номер гидроцилиндра</th>
        <th>Количество</th>
        <th>Дата отгрузки</th>
    </tr>
    <tr>
        <td>${plan.orderNumber}</td>
        <td>${plan.customer}</td>
        <td>${plan.cylinderNumber}</td>
        <td>${plan.quantity}</td>
        <td>${plan.shippingDate}</td>
    </tr>
    <tr>
        <form action="/plan/edit/${plan.id}" method="post">
            <td><input type="text" name="orderNumber"/></td>
            <td><input type="text" name="customer"/></td>
            <td><input type="text" name="cylinderNumber"/></td>
            <td><input type="number" name="quantity"/></td>
            <td><input type="date" name="shippingDate"/></td>
            <td><input type="submit" value="Изменить"/></td>
        </form>
    </tr>
</table>
</body>
</html>