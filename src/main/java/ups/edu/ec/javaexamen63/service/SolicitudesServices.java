package ups.edu.ec.javaexamen63.service;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.javaexamen63.business.GestionSolicitudes;
import ups.edu.ec.javaexamen63.model.Solicitudes;

@Path("/solicitudes")
public class SolicitudesServices {
	@Inject
    private GestionSolicitudes gestionSolicitudes;

    @POST
    @Path("/solicitud")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarSolicitud(Solicitudes solicitud) {
        try {
            // Lógica de registro de solicitud en el sistema
            gestionSolicitudes.registrarSolicitud(solicitud);

            return Response.ok().entity("Solicitud registrada exitosamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al registrar la solicitud: " + e.getMessage()).build();
        }
    }
    
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Solicitudes> listarSolicitudes() {
        return gestionSolicitudes.obtenerTodasLasSolicitudes();
    }

}
