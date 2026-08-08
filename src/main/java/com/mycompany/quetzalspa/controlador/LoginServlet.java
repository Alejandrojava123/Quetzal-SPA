package com.mycompany.quetzalspa.controlador;

import com.mycompany.quetzalspa.dao.UsuarioDAO;
import com.mycompany.quetzalspa.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasena = request.getParameter("contrasena");

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.validarLogin(nombreUsuario, contrasena);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("inicio.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}