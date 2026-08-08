<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.quetzalspa.modelo.Cita"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Historial de Citas</title>

    <style>
        body{
            font-family:Arial, Helvetica, sans-serif;
            background:#f4efe6;
            margin:30px;
        }

        h1{
            color:#2c3e50;
        }

        .subtitulo{
            color:#666;
            margin-bottom:25px;
        }

        table{
            width:100%;
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

        .volver{
            display:inline-block;
            margin-top:25px;
            color:#2c3e50;
            font-weight:bold;
            text-decoration:none;
        }

        .vacio{
            background:white;
            padding:20px;
            margin-top:20px;
            border-radius:8px;
        }
    </style>
</head>

<body>

<h1>Historial de Citas</h1>

<p class="subtitulo">
    Consulta de los servicios programados y realizados en Quetzal SPA.
</p>

<%
    List<Cita> historial =
            (List<Cita>) request.getAttribute("historial");

    if (historial != null && !historial.isEmpty()) {
%>

<table>

    <tr>
        <th>ID</th>
        <th>Cliente</th>
        <th>Servicio</th>
        <th>Fecha</th>
        <th>Hora</th>
        <th>Estado</th>
    </tr>

    <%
        for (Cita c : historial) {
    %>

    <tr>
        <td><%= c.getIdCita() %></td>
        <td><%= c.getNombreCliente() %></td>
        <td><%= c.getNombreServicio() %></td>
        <td><%= c.getFecha() %></td>
        <td><%= c.getHora() %></td>
        <td><%= c.getEstado() %></td>
    </tr>

    <%
        }
    %>

</table>

<%
    } else {
%>

<div class="vacio">
    No existen citas registradas actualmente.
</div>

<%
    }
%>

<a class="volver" href="inicio.jsp">
    ← Volver al menú principal
</a>

</body>
</html>