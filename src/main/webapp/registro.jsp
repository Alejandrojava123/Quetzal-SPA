<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Registro</title>

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
            margin-bottom:10px;
        }

        h3{
            text-align:center;
            color:#666;
            margin-bottom:30px;
        }

        label{
            font-weight:bold;
            display:block;
            margin-top:15px;
        }

        input, select{
            width:100%;
            padding:12px;
            margin-top:6px;
            border:1px solid #ccc;
            border-radius:6px;
        }

        button{
            width:100%;
            margin-top:30px;
            padding:14px;
            background:#2c3e50;
            color:white;
            border:none;
            border-radius:6px;
            cursor:pointer;
            font-size:16px;
        }

        button:hover{
            background:#1f2d3d;
        }

        .volver{
            margin-top:20px;
            text-align:center;
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
    <h3>Registro de Usuario</h3>

    <form action="RegistroServlet" method="post">

        <label>Nombre completo</label>
        <input type="text" name="nombreCompleto" required>

        <label>Nombre de usuario</label>
        <input type="text" name="nombreUsuario" required>

        <label>Contraseña</label>
        <input type="password" name="contrasena" required>

        <label>Edad</label>
        <input type="number" name="edad" min="18" required>

        <label>Sexo</label>
        <select name="sexo" required>
            <option value="">Selecciona una opción</option>
            <option value="Masculino">Masculino</option>
            <option value="Femenino">Femenino</option>
        </select>

        <label>Estatura (m)</label>
        <input type="number"
               name="estatura"
               step="0.01"
               min="1.00"
               max="2.50"
               placeholder="Ejemplo: 1.75"
               required>

        <button type="submit">
            Registrar usuario
        </button>

    </form>

    <div class="volver">
        <a href="login.jsp">
            Volver al inicio de sesión
        </a>
    </div>

</div>

</body>
</html>