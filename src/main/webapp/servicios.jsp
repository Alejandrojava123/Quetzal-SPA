<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.quetzalspa.modelo.Servicio"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Servicios</title>

    <style>
        body{
            font-family:Arial, Helvetica, sans-serif;
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

    <h1>Administración de Servicios</h1>

    <a class="boton" href="registroServicio.jsp">
        + Nuevo Servicio
    </a>

    <table>

        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Precio</th>
            <th>Duración</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>

        <%
            List<Servicio> lista =
                    (List<Servicio>) request.getAttribute("listaServicios");

            if (lista != null) {

                for (Servicio s : lista) {
        %>

        <tr>

            <td><%= s.getIdServicio() %></td>
            <td><%= s.getNombre() %></td>
            <td><%= s.getDescripcion() %></td>
            <td>$<%= String.format("%.2f", s.getPrecio()) %></td>
            <td><%= s.getDuracion() %> min</td>

            <td>
                <%= s.isActivo() ? "Activo" : "Inactivo" %>
            </td>

            <td>

                <a class="editar"
                   href="ServicioServlet?accion=editar&id=<%= s.getIdServicio() %>">
                    Editar
                </a>

                &nbsp; | &nbsp;

                <a class="eliminar"
                   href="ServicioServlet?accion=eliminar&id=<%= s.getIdServicio() %>"
                   onclick="return confirm('¿Estás seguro de eliminar este servicio?');">
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