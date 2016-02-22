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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidad que representa a un pasajero
 */
@Entity
@Table(name = "pasajero")
public class Pasajero implements java.io.Serializable {

	private int id;
	private String nombre;
	private String apellido;
	private Set<Vuelo> vuelos = new HashSet<Vuelo>(0);

	public Pasajero() {
	}

	public Pasajero(int id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Pasajero(int id, String nombre, String apellido, Set<Vuelo> vuelos) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.vuelos = vuelos;
	}

	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@NotEmpty
	@Column(name = "apellido", nullable = false)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pasajeroxvuelo", joinColumns = {
			@JoinColumn(name = "idpasajero", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idvuelo", nullable = false, updatable = false) })
	public Set<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(Set<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}
