<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>План производства</h2>
<form action="/" method="get">
    Поиск по номеру ГЦ: <input type="text" name="cylinderNumber"><input type="submit" value="Поиск"/>
</form>
<hr>
<h3>Добавить гидроцилиндр в план производства</h3>
<form action="/plan/create" method="post">
    <table>
        <tr>
            <th>Номер заказа</th>
            <th>Заказчик</th>
            <th>Обозначение ГЦ</th>
            <th>Количество в плане</th>
            <th>Дата отгрузки</th>
        </tr>
        <tr>
            <td><input type="text" name="orderNumber"/></td>
            <td><input type="text" name="customer"/></td>
            <td><input type="text" name="cylinderNumber"/></td>
            <td><input type="number" name="quantity"/></td>
            <td><input type="date" name="shippingDate"/></td>
        </tr>
    </table>
    <input type="submit" value="Добавить ГЦ в план"/>
</form>
<hr>
<table>
    <tr>
        <th>Номер заказа</th>
        <th>Заказчик</th>
        <th>Номер гидроцилиндра</th>
        <th>Количество</th>
        <th>Дата отгрузки</th>
        <th>Действие</th>
    </tr>
<#list planes as plan>
    <tr>
        <td>${plan.orderNumber}</td>
        <td>${plan.customer}</td>
        <td><a href="/plan/${plan.id}">${plan.cylinderNumber}</a></td>
        <td>${plan.quantity}</td>
        <td>${plan.shippingDate}</td>
        <td><form action="/plan/delete/${plan.id}" method="post">
                <input type="submit" value="Удалить "/>
            </form>
            <a href="/plan/edit/${plan.id}">Редактировать</a>
        </td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>
</body>
</html>