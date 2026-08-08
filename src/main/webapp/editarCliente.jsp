<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.quetzalspa.modelo.Cliente"%>

<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");

    if (cliente == null) {
        response.sendRedirect("ClienteServlet");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Editar Cliente</title>

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
    <h3>Editar Cliente</h3>

    <form action="ClienteServlet" method="post">

        <input type="hidden" name="accion" value="actualizar">
        <input type="hidden" name="idCliente"
               value="<%= cliente.getIdCliente() %>">

        <label>Nombre</label>
        <input type="text"
               name="nombre"
               value="<%= cliente.getNombre() %>"
               required>

        <label>Apellido</label>
        <input type="text"
               name="apellido"
               value="<%= cliente.getApellido() %>"
               required>

        <label>Teléfono</label>
        <input type="text"
               name="telefono"
               value="<%= cliente.getTelefono() != null ? cliente.getTelefono() : "" %>"
               maxlength="15">

        <label>Correo electrónico</label>
        <input type="email"
               name="correo"
               value="<%= cliente.getCorreo() != null ? cliente.getCorreo() : "" %>">

        <label>Sexo</label>
        <select name="sexo">

            <option value="Masculino"
                <%= "Masculino".equals(cliente.getSexo()) ? "selected" : "" %>>
                Masculino
            </option>

            <option value="Femenino"
                <%= "Femenino".equals(cliente.getSexo()) ? "selected" : "" %>>
                Femenino
            </option>

        </select>

        <button type="submit">
            Guardar cambios
        </button>

    </form>

    <div class="volver">
        <a href="ClienteServlet">
            Cancelar y volver
        </a>
    </div>

</div>

</body>
</html>