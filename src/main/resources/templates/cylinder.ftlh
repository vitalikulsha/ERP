<!DOCTYPE html>
<html>
<head>
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1><hr>
<h4>База гидроцилиндров</h4>
<form action="/" method="get">
    Поиск по номер гидроцилиндра: <input type="text" name="number"><br>
    <input type="submit" value="Поиск"/>
</form>
<table>
    <tr>
        <th>Номер</th>
        <th>Название</th>
        <th>Ссылка</th>
    </tr>
<#list cylinders as cylinder>
    <tr>
        <td>${cylinder.number}</td>
        <td>${cylinder.name}</td>
        <td><a href="/cylinder/${cylinder.id}">Подробнее</a></td>
    </tr>
    <#else>
    <h3>Ничего нет</h3>
</#list>
</table>
<hr>
<h3>Добавить гидроцилиндр в базу гидроцилиндров</h3>
<form action="/cylinder/create" method="post" enctype="multipart/form-data">
    Обозначение: <input type="text" name="number"/><br><br>
    Название: <input type="text" name="name"/><br><br>
<!--    Заказчик: <input type="text" name="customer"/><br><br>-->
<!--    Количество в плане: <input type="number" name="quantityPlan"/><br><br>-->
    Чертеж: <input type="file" name="file">
<!--    Первая фотография: <input type="file" name="file1">-->
<!--    Вторая фотография: <input type="file" name="file2">-->
<!--    Третья фотография: <input type="file" name="file3">-->
    <input type="submit" value="Добавить ГЦ"/>
</form>
</body>
</html>