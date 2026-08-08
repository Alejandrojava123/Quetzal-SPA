package com.mycompany.quetzalspa.controlador;

import com.mycompany.quetzalspa.dao.CitaDAO;
import com.mycompany.quetzalspa.modelo.Cita;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HistorialCitasServlet")
public class HistorialCitasServlet extends HttpServlet {

    private final CitaDAO citaDAO = new CitaDAO();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Cita> historial = citaDAO.listarCitas();

        request.setAttribute("historial", historial);

        request.getRequestDispatcher("historialCitas.jsp")
               .forward(request, response);
    }
}