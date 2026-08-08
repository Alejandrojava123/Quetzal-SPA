package com.mycompany.quetzalspa.controlador;

import com.mycompany.quetzalspa.dao.MedicionDAO;
import com.mycompany.quetzalspa.modelo.MedicionIMC;
import com.mycompany.quetzalspa.modelo.Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/IMCServlet")
public class IMCServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Usuario usuario =
                (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {

            double peso =
                    Double.parseDouble(
                            request.getParameter("peso")
                    );

            if (peso <= 0) {
                response.sendRedirect(
                        "calcularIMC.jsp?error=1"
                );
                return;
            }

            double estatura = usuario.getEstatura();

            if (estatura <= 0) {
                response.sendRedirect(
                        "calcularIMC.jsp?error=2"
                );
                return;
            }

            double imc =
                    peso / (estatura * estatura);

            imc =
                    Math.round(imc * 100.0) / 100.0;

            String clasificacion;

            if (imc < 18.5) {

                clasificacion = "Bajo peso";

            } else if (imc < 25) {

                clasificacion = "Peso normal";

            } else if (imc < 30) {

                clasificacion = "Sobrepeso";

            } else {

                clasificacion = "Obesidad";
            }

            MedicionIMC medicion =
                    new MedicionIMC();

            medicion.setIdUsuario(
                    usuario.getIdUsuario()
            );

            medicion.setPeso(peso);

            medicion.setImc(imc);

            medicion.setClasificacion(
                    clasificacion
            );

            MedicionDAO dao =
                    new MedicionDAO();

            dao.guardar(medicion);

            request.setAttribute(
                    "peso", peso
            );

            request.setAttribute(
                    "estatura", estatura
            );

            request.setAttribute(
                    "imc", imc
            );

            request.setAttribute(
                    "clasificacion",
                    clasificacion
            );

            request.getRequestDispatcher(
                    "resultadoEvaluacion.jsp"
            ).forward(request, response);

        } catch (NumberFormatException e) {

            response.sendRedirect(
                    "calcularIMC.jsp?error=1"
            );
        }
    }
}