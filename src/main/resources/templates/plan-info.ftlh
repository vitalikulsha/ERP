<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h4>Подробная информация о плане</h4>
<b>ID: </b>${plan.id}<br>
<b>Номер заказа: </b>${plan.orderNumber}<br>
<b>Заказчик: </b>${plan.customer}<br>
<b>Номер гидроцилиндра: </b>${plan.cylinderNumber}<br>
<b>Количество: </b>${plan.quantity}<br>
<b>Дата отгрузки: </b>${plan.shippingDate}<br>
<hr>
<form action="/plan/delete/${plan.id}" method="post">
    <input type="submit" value="Удалить из плана"/>
</form>
</body>
</html>