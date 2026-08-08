<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.quetzalspa.modelo.Cliente"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Quetzal SPA - Clientes</title>

    <style>

        body{
            font-family: Arial, Helvetica, sans-serif;
            background:#f4efe6;
            margin:30px;
        }

        h1{
            color:#2c3e50;
        }

        .boton{
            display:inline-block;
            background:#2c3e50;
            color:white;
            padding:10px 20px;
            text-decoration:none;
            border-radius:5px;
            margin-bottom:20px;
        }

        .boton:hover{
            background:#1f2d3d;
        }

        table{
            width:100%;
            margin-top:15px;
            border-collapse:collapse;
            background:white;
            box-shadow:0 3px 10px rgba(0,0,0,.10);
        }

        th{
            background:#2c3e50;
            color:white;
            padding:12px;
        }

        td{
            padding:10px;
            border:1px solid #ddd;
            text-align:center;
        }

        tr:nth-child(even){
            background:#f8f8f8;
        }

        .editar{
            color:#2c3e50;
            font-weight:bold;
            text-decoration:none;
        }

        .eliminar{
            color:#b22222;
            font-weight:bold;
            text-decoration:none;
        }

        .volver{
            display:inline-block;
            margin-top:25px;
            color:#2c3e50;
            font-weight:bold;
            text-decoration:none;
        }

    </style>

</head>

<body>

    <h1>Administración de Clientes</h1>

    <a class="boton" href="registroCliente.jsp">
        + Nuevo Cliente
    </a>

    <table>

        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Teléfono</th>
            <th>Correo</th>
            <th>Sexo</th>
            <th>Acciones</th>
        </tr>

        <%
            List<Cliente> lista =
                    (List<Cliente>) request.getAttribute("listaClientes");

            if (lista != null) {

                for (Cliente c : lista) {
        %>

        <tr>

            <td><%= c.getIdCliente() %></td>

            <td><%= c.getNombre() %></td>

            <td><%= c.getApellido() %></td>

            <td><%= c.getTelefono() %></td>

            <td><%= c.getCorreo() %></td>

            <td><%= c.getSexo() %></td>

            <td>

                <a class="editar"
                   href="ClienteServlet?accion=editar&id=<%= c.getIdCliente() %>">
                    Editar
                </a>

                &nbsp; | &nbsp;

                <a class="eliminar"
                   href="ClienteServlet?accion=eliminar&id=<%= c.getIdCliente() %>"
                   onclick="return confirm('¿Estás seguro de eliminar este cliente?');">
                    Eliminar
                </a>

            </td>

        </tr>

        <%
                }
            }
        %>

    </table>

    <a class="volver" href="inicio.jsp">
        ← Volver al menú principal
    </a>

</body>
</html>