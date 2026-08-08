<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Inicio de Sesión</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f1ea;
            margin: 0;
            padding: 0;
        }

        .contenedor {
            width: 380px;
            margin: 80px auto;
            background-color: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }

        h1 {
            text-align: center;
            margin-bottom: 5px;
        }

        h3 {
            text-align: center;
            font-weight: normal;
            margin-top: 0;
            color: #555;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
            border: 1px solid #bbb;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 11px;
            margin-top: 20px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            font-weight: bold;
        }

        .registro {
            text-align: center;
            margin-top: 18px;
        }

        .descripcion {
            text-align: center;
            margin-top: 22px;
            font-size: 14px;
            color: #666;
            line-height: 1.5;
        }
    </style>
</head>

<body>

    <div class="contenedor">

        <h1>QUETZAL SPA</h1>
        <h3>Sistema Web de Administración</h3>

        <form action="LoginServlet" method="post">

            <label>Usuario:</label>
            <input type="text"
                   name="nombreUsuario"
                   placeholder="Ingresa tu usuario"
                   required>

            <label>Contraseña:</label>
            <input type="password"
                   name="contrasena"
                   placeholder="Ingresa tu contraseña"
                   required>

            <input type="submit" value="Iniciar sesión">

        </form>

        <div class="registro">
            ¿No tienes una cuenta?
            <a href="registro.jsp">Registrarse</a>
        </div>

        <div class="descripcion">
            Sistema para la administración de clientes,
            servicios y citas de Quetzal SPA.
        </div>

    </div>

</body>
</html>