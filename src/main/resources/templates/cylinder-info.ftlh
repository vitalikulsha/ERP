<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h2>Карта гидроцилиндра ${cylinder.number}</h4>
<table>
    <tr>
        <th>Обозначение</th>
        <th>Название</th>
        <th>Количество</th>
    </tr>
<#list cylinderParts as part>
    <tr>
        <td>${part.number}</td>
        <td>${part.name}</td>
        <td>${part.quantity}</td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>

</body>
</html>