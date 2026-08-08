package com.mycompany.quetzalspa.controlador;

import com.mycompany.quetzalspa.dao.ServicioDAO;
import com.mycompany.quetzalspa.modelo.Servicio;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServicioServlet")
public class ServicioServlet extends HttpServlet {

    private final ServicioDAO dao = new ServicioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "editar":

                int idEditar = Integer.parseInt(request.getParameter("id"));

                Servicio servicio = dao.buscarServicio(idEditar);

                request.setAttribute("servicio", servicio);

                request.getRequestDispatcher("editarServicio.jsp")
                       .forward(request, response);

                break;

            case "eliminar":

                int idEliminar = Integer.parseInt(request.getParameter("id"));

                dao.eliminarServicio(idEliminar);

                response.sendRedirect("ServicioServlet");

                break;

            default:

                List<Servicio> listaServicios = dao.listarServicios();

                request.setAttribute("listaServicios", listaServicios);

                request.getRequestDispatcher("servicios.jsp")
                       .forward(request, response);

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if ("actualizar".equals(accion)) {

            int idServicio = Integer.parseInt(
                    request.getParameter("idServicio")
            );

            Servicio servicio = new Servicio();

            servicio.setIdServicio(idServicio);
            servicio.setNombre(request.getParameter("nombre"));
            servicio.setDescripcion(request.getParameter("descripcion"));
            servicio.setPrecio(
                    Double.parseDouble(request.getParameter("precio"))
            );
            servicio.setDuracion(
                    Integer.parseInt(request.getParameter("duracion"))
            );
            servicio.setActivo(
                    Boolean.parseBoolean(request.getParameter("activo"))
            );

            dao.actualizarServicio(servicio);

            response.sendRedirect("ServicioServlet");

        } else {

            Servicio servicio = new Servicio();

            servicio.setNombre(request.getParameter("nombre"));
            servicio.setDescripcion(request.getParameter("descripcion"));
            servicio.setPrecio(
                    Double.parseDouble(request.getParameter("precio"))
            );
            servicio.setDuracion(
                    Integer.parseInt(request.getParameter("duracion"))
            );
            servicio.setActivo(true);

            boolean registrado = dao.registrarServicio(servicio);

            if (registrado) {
                response.sendRedirect("ServicioServlet");
            } else {
                response.sendRedirect("registroServicio.jsp?error=1");
            }
        }
    }
}