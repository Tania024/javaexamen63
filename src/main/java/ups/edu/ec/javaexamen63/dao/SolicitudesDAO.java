package ups.edu.ec.javaexamen63.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.javaexamen63.model.Solicitudes;

@Stateless
public class SolicitudesDAO implements Serializable{
	@PersistenceContext
    private EntityManager entityManager;

    public void guardarSolicitud(Solicitudes solicitud) {
        try {
        	// Generar fecha actual
            solicitud.setFecha(LocalDate.now()); // 

            // Calcular tabla de amortización
            calcularTablaAmortizacion(solicitud);

            // Persistir la solicitud
            entityManager.persist(solicitud);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción de una manera específica para tu aplicación.
        }
    }

    private void calcularTablaAmortizacion(Solicitudes solicitud) {
        double interes = solicitud.getMonto() * 0.10;
        double montoConInteres = solicitud.getMonto() + interes;
        double cuotaCapital = montoConInteres / solicitud.getMeses();
        double cuotaInteres = interes / solicitud.getMeses();

        for (int i = 1; i <= solicitud.getMeses(); i++) {
            double cuotaTotal = cuotaCapital + cuotaInteres;

            // Imprimir o procesar la información según sea necesario
            System.out.println(i + "\t" + cuotaCapital + "\t" + cuotaInteres + "\t" + cuotaTotal);
        }
    }

    public Solicitudes buscarSolicitudPorId(int id) {
        return entityManager.find(Solicitudes.class, id);
    }

    public List<Solicitudes> obtenerTodasLasSolicitudes() {
        Query query = entityManager.createQuery("SELECT s FROM Solicitudes s", Solicitudes.class);
        return query.getResultList();
    }

}
