<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.quetzalspa.modelo.Servicio"%>

<%
    Servicio servicio = (Servicio) request.getAttribute("servicio");

    if (servicio == null) {
        response.sendRedirect("ServicioServlet");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quetzal SPA - Editar Servicio</title>

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
            width:470px;
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

        input, textarea, select{
            width:100%;
            padding:11px;
            margin-top:6px;
            border:1px solid #ccc;
            border-radius:6px;
        }

        textarea{
            resize:vertical;
            min-height:90px;
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
    <h3>Editar Servicio</h3>

    <form action="ServicioServlet" method="post">

        <input type="hidden" name="accion" value="actualizar">

        <input type="hidden"
               name="idServicio"
               value="<%= servicio.getIdServicio() %>">

        <label>Nombre del servicio</label>
        <input type="text"
               name="nombre"
               value="<%= servicio.getNombre() %>"
               required>

        <label>Descripción</label>
        <textarea name="descripcion"><%= servicio.getDescripcion() != null ? servicio.getDescripcion() : "" %></textarea>

        <label>Precio ($)</label>
        <input type="number"
               name="precio"
               step="0.01"
               min="0"
               value="<%= servicio.getPrecio() %>"
               required>

        <label>Duración (minutos)</label>
        <input type="number"
               name="duracion"
               min="1"
               value="<%= servicio.getDuracion() %>"
               required>

        <label>Estado</label>
        <select name="activo">

            <option value="true"
                <%= servicio.isActivo() ? "selected" : "" %>>
                Activo
            </option>

            <option value="false"
                <%= !servicio.isActivo() ? "selected" : "" %>>
                Inactivo
            </option>

        </select>

        <button type="submit">
            Guardar cambios
        </button>

    </form>

    <div class="volver">
        <a href="ServicioServlet">
            Cancelar y volver
        </a>
    </div>

</div>

</body>
</html>