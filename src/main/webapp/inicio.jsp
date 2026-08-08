<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Inicio</title>

    <style>
        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
            font-family:Arial, Helvetica, sans-serif;
        }

        body{
            background:#f4efe6;
        }

        header{
            background:#2c3e50;
            color:white;
            padding:20px;
            text-align:center;
        }

        header h1{
            font-size:36px;
        }

        header p{
            margin-top:10px;
            font-size:18px;
        }

        .contenedor{
            width:90%;
            max-width:1000px;
            margin:40px auto;
        }

        .menu{
            display:grid;
            grid-template-columns:repeat(auto-fit,minmax(220px,1fr));
            gap:25px;
        }

        .tarjeta{
            background:white;
            padding:30px;
            border-radius:12px;
            text-align:center;
            box-shadow:0 5px 12px rgba(0,0,0,.15);
            transition:.3s;
        }

        .tarjeta:hover{
            transform:translateY(-5px);
        }

        .tarjeta h2{
            margin-bottom:15px;
        }

        .tarjeta a{
            text-decoration:none;
            color:white;
            background:#2c3e50;
            padding:12px 25px;
            display:inline-block;
            border-radius:6px;
            margin-top:10px;
        }

        footer{
            text-align:center;
            margin-top:40px;
            color:#555;
            padding-bottom:30px;
        }
    </style>

</head>

<body>

<header>

    <h1>QUETZAL SPA</h1>

    <p>Sistema Web de Administración</p>

</header>

<div class="contenedor">

    <div class="menu">

        <div class="tarjeta">
            <h2>Clientes</h2>
            <a href="ClienteServlet">Administrar</a>
        </div>

        <div class="tarjeta">
    <h2>Servicios</h2>
    <a href="ServicioServlet">Administrar</a>
</div>

        <div class="tarjeta">
    <h2>Citas</h2>
    <a href="CitaServlet">Administrar</a>
</div>

        <div class="tarjeta">
            <h2>Evaluación corporal</h2>
            <a href="calcularIMC.jsp">Abrir</a>
        </div>

        <div class="tarjeta">
    <h2>Historial</h2>
    <a href="HistorialCitasServlet">Ver</a>
</div>

        <div class="tarjeta">
            <h2>Cerrar sesión</h2>
            <a href="login.jsp">Salir</a>
        </div>

    </div>

</div>

<footer>

    © 2026 Quetzal SPA - Sistema Web para administración de clientes, servicios y citas.

</footer>

</body>
</html>