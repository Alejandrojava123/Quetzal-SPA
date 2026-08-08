<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Quetzal SPA - Evaluación Corporal</title>

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

.contenedor{
    width:430px;
    background:white;
    padding:35px;
    border-radius:12px;
    box-shadow:0 5px 15px rgba(0,0,0,.20);
}

h1{
    text-align:center;
    margin-bottom:8px;
}

h3{
    text-align:center;
    color:#666;
    margin-bottom:25px;
}

.descripcion{
    color:#555;
    text-align:center;
    line-height:1.5;
    margin-bottom:25px;
}

label{
    display:block;
    font-weight:bold;
}

input{
    width:100%;
    padding:12px;
    margin-top:7px;
    border:1px solid #ccc;
    border-radius:6px;
}

button{
    width:100%;
    margin-top:25px;
    padding:13px;
    background:#2c3e50;
    color:white;
    border:none;
    border-radius:6px;
    cursor:pointer;
    font-size:16px;
}

.volver{
    text-align:center;
    margin-top:20px;
}

.volver a{
    text-decoration:none;
    color:#2c3e50;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="contenedor">

    <h1>QUETZAL SPA</h1>

    <h3>Evaluación Corporal</h3>

    <p class="descripcion">
        Registra tu peso actual para obtener una
        evaluación de referencia con base en tu
        estatura registrada.
    </p>

    <form action="IMCServlet" method="post">

        <label>Peso actual (kg)</label>

        <input
            type="number"
            name="peso"
            min="1"
            step="0.01"
            placeholder="Ejemplo: 70.00"
            required>

        <button type="submit">
            Calcular evaluación
        </button>

    </form>

    <div class="volver">

        <a href="inicio.jsp">
            ← Volver al menú principal
        </a>

    </div>

</div>

</body>
</html>