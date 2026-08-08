<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.quetzalspa.modelo.Cita"%>
<%@page import="com.mycompany.quetzalspa.modelo.Cliente"%>
<%@page import="com.mycompany.quetzalspa.modelo.Servicio"%>

<%
    Cita cita = (Cita) request.getAttribute("cita");

    List<Cliente> clientes =
            (List<Cliente>) request.getAttribute("clientes");

    List<Servicio> servicios =
            (List<Servicio>) request.getAttribute("servicios");

    if (cita == null) {
        response.sendRedirect("CitaServlet");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Editar Cita</title>

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
            width:480px;
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
    <h3>Editar Cita</h3>

    <form action="CitaServlet" method="post">

        <input type="hidden" name="accion" value="actualizar">

        <input type="hidden"
               name="idCita"
               value="<%= cita.getIdCita() %>">

        <label>Cliente</label>

        <select name="idCliente" required>

            <%
                if (clientes != null) {

                    for (Cliente c : clientes) {
            %>

            <option value="<%= c.getIdCliente() %>"
                <%= c.getIdCliente() == cita.getIdCliente()
                    ? "selected" : "" %>>

                <%= c.getNombre() %> <%= c.getApellido() %>

            </option>

            <%
                    }
                }
            %>

        </select>

        <label>Servicio</label>

        <select name="idServicio" required>

            <%
                if (servicios != null) {

                    for (Servicio s : servicios) {
            %>

            <option value="<%= s.getIdServicio() %>"
                <%= s.getIdServicio() == cita.getIdServicio()
                    ? "selected" : "" %>>

                <%= s.getNombre() %>
                - $<%= String.format("%.2f", s.getPrecio()) %>

            </option>

            <%
                    }
                }
            %>

        </select>

        <label>Fecha</label>

        <input type="date"
               name="fecha"
               value="<%= cita.getFecha() %>"
               required>

        <label>Hora</label>

        <input type="time"
               name="hora"
               value="<%= cita.getHora().toString().substring(0,5) %>"
               required>

        <label>Estado</label>

        <select name="estado">

            <option value="Programada"
                <%= "Programada".equals(cita.getEstado())
                    ? "selected" : "" %>>
                Programada
            </option>

            <option value="Confirmada"
                <%= "Confirmada".equals(cita.getEstado())
                    ? "selected" : "" %>>
                Confirmada
            </option>

            <option value="Completada"
                <%= "Completada".equals(cita.getEstado())
                    ? "selected" : "" %>>
                Completada
            </option>

            <option value="Cancelada"
                <%= "Cancelada".equals(cita.getEstado())
                    ? "selected" : "" %>>
                Cancelada
            </option>

        </select>

        <button type="submit">
            Guardar cambios
        </button>

    </form>

    <div class="volver">
        <a href="CitaServlet">
            Cancelar y volver
        </a>
    </div>

</div>

</body>
</html>