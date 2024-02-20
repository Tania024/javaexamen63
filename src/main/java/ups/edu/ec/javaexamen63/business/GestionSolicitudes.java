package ups.edu.ec.javaexamen63.business;

import java.time.LocalDate;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.javaexamen63.dao.SolicitudesDAO;
import ups.edu.ec.javaexamen63.model.Solicitudes;

@Stateless
public class GestionSolicitudes {
	@Inject
    private SolicitudesDAO solicitudesDAO;

    public void registrarSolicitud(Solicitudes solicitud) {
        try {
        	// Generar fecha actual
            solicitud.setFecha(LocalDate.now()); 


            // Lógica de cálculo de la tabla de amortización
            double interes = solicitud.getMonto() * 0.10;
            double montoConInteres = solicitud.getMonto() + interes;
            double cuotaCapital = montoConInteres / solicitud.getMeses();
            double cuotaInteres = interes / solicitud.getMeses();

            // Crear la descripción de las cuotas y agregarla a la descripción de la solicitud
            StringBuilder descripcionCuotas = new StringBuilder();
            descripcionCuotas.append("# Cuota\tCapital\tInteres\tTotal\n");
            for (int i = 1; i <= solicitud.getMeses(); i++) {
                double cuotaTotal = cuotaCapital + cuotaInteres;

                // Agregar información de la cuota al StringBuilder
                descripcionCuotas.append(i).append("\t").append(cuotaCapital).append("\t").append(cuotaInteres)
                        .append("\t").append(cuotaTotal).append("\n");
            }

            // Agregar la descripción de las cuotas a la descripción de la solicitud
            solicitud.setDescripcionCuotas(descripcionCuotas.toString());

            // Persistir la solicitud
            solicitudesDAO.guardarSolicitud(solicitud);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción de una manera específica para tu aplicación.
        }
    }

    public Solicitudes buscarSolicitudPorId(int id) {
        return solicitudesDAO.buscarSolicitudPorId(id);
    }

    public List<Solicitudes> obtenerTodasLasSolicitudes() {
        return solicitudesDAO.obtenerTodasLasSolicitudes();
    }

}
