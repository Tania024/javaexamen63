package ups.edu.ec.javaexamen63.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Solicitudes implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cedulaCliente;
    private String nombreCliente;
    private String correoElectronico;

    
    private LocalDate fecha;

    private double monto;
    private int meses;
    
    
    private String descripcionCuotas;

    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getMeses() {
		return meses;
	}
	public void setMeses(int meses) {
		this.meses = meses;
	}
	
	
	public String getDescripcionCuotas() {
	    return descripcionCuotas;
	}

	public void setDescripcionCuotas(String descripcionCuotas) {
	    this.descripcionCuotas = descripcionCuotas;
	}
	
	
	@Override
	public String toString() {
		return "Solicitudes [id=" + id + ", cedulaCliente=" + cedulaCliente + ", nombreCliente=" + nombreCliente
				+ ", correoElectronico=" + correoElectronico + ", fecha=" + fecha + ", monto=" + monto + ", meses="
				+ meses + "]";
	}
	
	

}
