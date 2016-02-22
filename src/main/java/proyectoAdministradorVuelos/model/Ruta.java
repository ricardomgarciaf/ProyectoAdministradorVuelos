package proyectoAdministradorVuelos.model;
// Generated Feb 20, 2016 6:32:26 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidad que representa a un ruta
 */
@Entity
@Table(name = "ruta", uniqueConstraints = @UniqueConstraint(columnNames = { "aeropuerto_origen",
		"aeropuerto_destino" }) )
public class Ruta implements java.io.Serializable {

	private int id;
	private Aeropuerto aeropuertoByAeropuertoOrigen;
	private Aeropuerto aeropuertoByAeropuertoDestino;
	private String duracion;
	private Set<Vuelo> vuelos = new HashSet<Vuelo>(0);

	public Ruta() {
	}

	public Ruta(int id, Aeropuerto aeropuertoByAeropuertoOrigen, Aeropuerto aeropuertoByAeropuertoDestino,
			String duracion) {
		this.id = id;
		this.aeropuertoByAeropuertoOrigen = aeropuertoByAeropuertoOrigen;
		this.aeropuertoByAeropuertoDestino = aeropuertoByAeropuertoDestino;
		this.duracion = duracion;
	}

	public Ruta(int id, Aeropuerto aeropuertoByAeropuertoOrigen, Aeropuerto aeropuertoByAeropuertoDestino,
			String duracion, Set<Vuelo> vuelos) {
		this.id = id;
		this.aeropuertoByAeropuertoOrigen = aeropuertoByAeropuertoOrigen;
		this.aeropuertoByAeropuertoDestino = aeropuertoByAeropuertoDestino;
		this.duracion = duracion;
		this.vuelos = vuelos;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aeropuerto_origen", nullable = false)
	public Aeropuerto getAeropuertoByAeropuertoOrigen() {
		return this.aeropuertoByAeropuertoOrigen;
	}

	public void setAeropuertoByAeropuertoOrigen(Aeropuerto aeropuertoByAeropuertoOrigen) {
		this.aeropuertoByAeropuertoOrigen = aeropuertoByAeropuertoOrigen;
	}
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aeropuerto_destino", nullable = false)
	public Aeropuerto getAeropuertoByAeropuertoDestino() {
		return this.aeropuertoByAeropuertoDestino;
	}

	public void setAeropuertoByAeropuertoDestino(Aeropuerto aeropuertoByAeropuertoDestino) {
		this.aeropuertoByAeropuertoDestino = aeropuertoByAeropuertoDestino;
	}

	@NotEmpty
	@Column(name = "duracion", nullable = false)
	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ruta")
	public Set<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(Set<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	@Override
	public String toString() {
		return aeropuertoByAeropuertoOrigen.getNombre() + "->"
				+ aeropuertoByAeropuertoDestino.getNombre();
	}

	
}
