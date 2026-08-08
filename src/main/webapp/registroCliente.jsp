<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Nuevo Cliente</title>

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
            width:450px;
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

        label{
            display:block;
            margin-top:15px;
            font-weight:bold;
        }

        input, select{
            width:100%;
            padding:11px;
            margin-top:6px;
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
            margin-top:18px;
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
    <h3>Registro de Cliente</h3>

    <form action="ClienteServlet" method="post">

        <label>Nombre</label>
        <input type="text" name="nombre" required>

        <label>Apellido</label>
        <input type="text" name="apellido" required>

        <label>Teléfono</label>
        <input type="text" name="telefono" maxlength="15">

        <label>Correo electrónico</label>
        <input type="email" name="correo">

        <label>Sexo</label>
        <select name="sexo">
            <option value="">Selecciona una opción</option>
            <option value="Masculino">Masculino</option>
            <option value="Femenino">Femenino</option>
        </select>

        <button type="submit">
            Registrar Cliente
        </button>

    </form>

    <div class="volver">
        <a href="ClienteServlet">Volver a Clientes</a>
    </div>

</div>

</body>
</html>