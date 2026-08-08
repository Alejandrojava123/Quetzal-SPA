package com.mycompany.quetzalspa.rest;

import com.mycompany.quetzalspa.dao.MedicionDAO;
import com.mycompany.quetzalspa.modelo.MedicionIMC;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("historial")
public class HistorialResource {

    @GET
    @Path("{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerHistorial(@PathParam("idUsuario") int idUsuario) {
        try {
            MedicionDAO dao = new MedicionDAO();
            List<MedicionIMC> historial = dao.obtenerHistorial(idUsuario);

            return Response.ok(historial).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"No se pudo obtener el historial\"}")
                    .build();
        }
    }
}