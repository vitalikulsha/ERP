<!DOCTYPE html>
<html>
<head>
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h4>План производства</h4>
<form action="/" method="get">
    Поиск по номеру ГЦ: <input type="text" name="cylinderNumber"><br>
    <input type="submit" value="Поиск"/>
</form>
<table>
    <tr>
        <th>Номер заказа</th>
        <th>Заказчик</th>
        <th>Номер гидроцилиндра</th>
        <th>Количество</th>
        <th>Дата отгрузки</th>
        <th>Ссылка</th>
        <th>Удалить</th>
    </tr>
<#list planes as plan>

    <tr>
        <td>${plan.orderNumber}</td>
        <td>${plan.customer}</td>
        <td>${plan.cylinderNumber}</td>
        <td>${plan.quantity}</td>
        <td>${plan.shippingDate}</td>
        <td><a href="/cylinder/${plan.cylinderNumber}">Подробнее</a></td>
        <td><form action="/plan/delete/${plan.id}" method="post">
                <input type="submit" value="Удалить "/>
            </form>
        </td>
    </tr>

    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>
<hr>
<h3>Добавить гидроцилиндр в план производства</h3>
<form action="/plan/create" method="post">
    Номер заказа: <input type="text" name="orderNumber"/><br><br>
    Заказчик: <input type="text" name="customer"/><br><br>
    Обозначение гидроцилиндра: <input type="text" name="cylinderNumber"/><br><br>
    Количество в плане: <input type="number" name="quantity"/><br><br>
    Дата отгрузки: <input type="date" name="shippingDate"/><br><br>
    <input type="submit" value="Добавить ГЦ в план"/>
</form>
</body>
</html>