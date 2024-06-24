<!DOCTYPE html>
<html>
<head>
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