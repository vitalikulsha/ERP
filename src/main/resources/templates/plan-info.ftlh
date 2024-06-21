<!DOCTYPE html>
<html>
<head>
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h4>Подробная информация о плане</h4>
<b>Номер заказа: </b>${plan.orderNumber}<br>
<b>Заказчик: </b>${plan.customer}<br>
<b>Номер гидроцилиндра: </b>${plan.cylinderNumber}<br>
<b>Количество: </b>${plan.quantity}<br>
<hr>
<form action="/product/delete/${plan.id}" method="post">
    <input type="submit" value="Удалить из плана"/>
</form>
</body>
</html>