<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Карта гидроцилиндра ${cylinder.number}</h2>
<h3>Заказчик: "${customer}" || План-заявка: ${cylinderPlan} шт</h3>
<h4>Номер заявки: ${orderNumber} || Отзрузка: ${shippingDate}</h4>
<table>
    <tr>
        <th>Обозначение</th>
        <th>Название</th>
        <th>Кол. в ГЦ</th>
        <th>Кол. по плану</th>
        <th>Пила</th>
        <th>Ток 1</th>
        <th>Ток 2</th>
        <th>Ток 3</th>
        <th>Сверл</th>
        <th>Фрез</th>
        <th>Сварка 1</th>
        <th>Сварка 2</th>
        <th>Зачистка</th>
    </tr>
<#list cylinderParts as part>
    <tr>
        <td>${part.number}</td>
        <td>${part.name}</td>
        <td>${part.quantity}</td>
        <td>${part.quantity*cylinderPlan}</td>
        <td>${part.sumSaw()}</td>
        <td>${part.sumTurning1()}</td>
        <td>${part.sumTurning2()}</td>
        <td>${part.sumTurning3()}</td>
        <td>${part.sumDrilling()}</td>
        <td>${part.sumMilling()}</td>
        <td>${part.sumWelding1()}</td>
        <td>${part.sumWelding2()}</td>
        <td>${part.sumCleaning()}</td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>

</body>
</html>