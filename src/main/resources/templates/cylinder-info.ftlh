<!DOCTYPE html>
<html>
<head>
    <title>ERP</title>
</head>
<body>
<h1>ERP</h1>
<hr>
<h4>Подробная информация о гидроцилиндре ${cylinder.number}</h4>
<a href="/drawings/${drawing.id}">Подробнее</a>
<!--<#list images as img>-->
<!--<img src="/images/${img.id}" height="60px"/><br><br>-->
<!--</#list>-->
<b>Номер гидроцилиндра: </b>${cylinder.number}<br>
<b>Название: </b>${cylinder.name}<br>
<b>Список деталей:</b><br>
    <hr>
    <form action="/cylinder/delete/${cylinder.id}" method="post">
        <input type="submit" value="Удалить гидроцилиндр"/>
    </form>
</body>
</html>