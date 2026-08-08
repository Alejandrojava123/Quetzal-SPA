package com.mycompany.quetzalspa.controlador;

import com.mycompany.quetzalspa.dao.CitaDAO;
import com.mycompany.quetzalspa.dao.ClienteDAO;
import com.mycompany.quetzalspa.dao.ServicioDAO;

import com.mycompany.quetzalspa.modelo.Cita;
import com.mycompany.quetzalspa.modelo.Cliente;
import com.mycompany.quetzalspa.modelo.Servicio;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CitaServlet")
public class CitaServlet extends HttpServlet {

    private final CitaDAO citaDAO = new CitaDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final ServicioDAO servicioDAO = new ServicioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "nueva":

                cargarCatalogos(request);

                request.getRequestDispatcher("registroCita.jsp")
                       .forward(request, response);

                break;

            case "editar":

                int idEditar = Integer.parseInt(
                        request.getParameter("id")
                );

                Cita cita = citaDAO.buscarCita(idEditar);

                request.setAttribute("cita", cita);

                cargarCatalogos(request);

                request.getRequestDispatcher("editarCita.jsp")
                       .forward(request, response);

                break;

            case "eliminar":

                int idEliminar = Integer.parseInt(
                        request.getParameter("id")
                );

                citaDAO.eliminarCita(idEliminar);

                response.sendRedirect("CitaServlet");

                break;

            default:

                List<Cita> listaCitas = citaDAO.listarCitas();

                request.setAttribute("listaCitas", listaCitas);

                request.getRequestDispatcher("citas.jsp")
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

            Cita cita = construirCitaDesdeFormulario(request);

            cita.setIdCita(
                    Integer.parseInt(
                            request.getParameter("idCita")
                    )
            );

            citaDAO.actualizarCita(cita);

            response.sendRedirect("CitaServlet");

        } else {

            Cita cita = construirCitaDesdeFormulario(request);

            boolean registrada = citaDAO.registrarCita(cita);

            if (registrada) {
                response.sendRedirect("CitaServlet");
            } else {
                response.sendRedirect("CitaServlet?accion=nueva&error=1");
            }
        }
    }

    private void cargarCatalogos(HttpServletRequest request) {

        List<Cliente> clientes = clienteDAO.listarClientes();
        List<Servicio> servicios = servicioDAO.listarServicios();

        request.setAttribute("clientes", clientes);
        request.setAttribute("servicios", servicios);
    }

    private Cita construirCitaDesdeFormulario(
            HttpServletRequest request) {

        Cita cita = new Cita();

        cita.setIdCliente(
                Integer.parseInt(
                        request.getParameter("idCliente")
                )
        );

        cita.setIdServicio(
                Integer.parseInt(
                        request.getParameter("idServicio")
                )
        );

        cita.setFecha(
                Date.valueOf(
                        request.getParameter("fecha")
                )
        );

        cita.setHora(
                Time.valueOf(
                        request.getParameter("hora") + ":00"
                )
        );

        cita.setEstado(
                request.getParameter("estado")
        );

        return cita;
    }
}