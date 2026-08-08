package com.mycompany.quetzalspa.controlador;

import com.mycompany.quetzalspa.dao.UsuarioDAO;
import com.mycompany.quetzalspa.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();

        usuario.setNombreCompleto(request.getParameter("nombreCompleto"));
        usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
        usuario.setContrasena(request.getParameter("contrasena"));
        usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setEstatura(Double.parseDouble(request.getParameter("estatura")));

        UsuarioDAO dao = new UsuarioDAO();

        if (dao.registrar(usuario)) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("registro.jsp");
        }
    }
}