<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Resultado de Evaluación</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{

    background:#f4efe6;
    display:flex;
    justify-content:center;
    align-items:center;
    min-height:100vh;

}

.tarjeta{

    width:500px;
    background:white;
    padding:35px;
    border-radius:12px;
    box-shadow:0 5px 15px rgba(0,0,0,.20);

}

h1{

    text-align:center;
    color:#2c3e50;
    margin-bottom:10px;

}

h3{

    text-align:center;
    color:#666;
    margin-bottom:25px;

}

.dato{

    font-size:18px;
    margin:12px 0;

}

.resultado{

    margin-top:20px;
    padding:18px;
    border-radius:8px;
    background:#eef5f9;
    text-align:center;
}

.imc{

    font-size:30px;
    font-weight:bold;
    color:#2c3e50;

}

.clasificacion{

    font-size:22px;
    color:#0b7a3d;
    font-weight:bold;
    margin-top:10px;

}

a{

    display:block;
    margin-top:30px;
    text-align:center;
    text-decoration:none;
    color:#2c3e50;
    font-weight:bold;

}

</style>

</head>

<body>

<div class="tarjeta">

<h1>QUETZAL SPA</h1>

<h3>Resultado de la Evaluación Corporal</h3>

<div class="dato">

Peso registrado:

<b><%=request.getAttribute("peso")%> kg</b>

</div>

<div class="dato">

Estatura:

<b><%=request.getAttribute("estatura")%> m</b>

</div>

<div class="resultado">

<div class="imc">

IMC:
<%=request.getAttribute("imc")%>

</div>

<div class="clasificacion">

<%=request.getAttribute("clasificacion")%>

</div>

</div>

<a href="inicio.jsp">

← Volver al menú principal

</a>

</div>

</body>
</html>