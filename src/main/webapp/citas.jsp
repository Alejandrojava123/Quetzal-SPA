<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.quetzalspa.modelo.Cita"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Citas</title>

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

<h1>Administración de Citas</h1>

<a class="boton" href="CitaServlet?accion=nueva">
    + Nueva Cita
</a>

<table>

    <tr>
        <th>ID</th>
        <th>Cliente</th>
        <th>Servicio</th>
        <th>Fecha</th>
        <th>Hora</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>

    <%
        List<Cita> lista =
                (List<Cita>) request.getAttribute("listaCitas");

        if (lista != null) {

            for (Cita c : lista) {
    %>

    <tr>

        <td><%= c.getIdCita() %></td>
        <td><%= c.getNombreCliente() %></td>
        <td><%= c.getNombreServicio() %></td>
        <td><%= c.getFecha() %></td>
        <td><%= c.getHora() %></td>
        <td><%= c.getEstado() %></td>

        <td>

            <a class="editar"
               href="CitaServlet?accion=editar&id=<%= c.getIdCita() %>">
                Editar
            </a>

            &nbsp; | &nbsp;

            <a class="eliminar"
               href="CitaServlet?accion=eliminar&id=<%= c.getIdCita() %>"
               onclick="return confirm('¿Estás seguro de eliminar esta cita?');">
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