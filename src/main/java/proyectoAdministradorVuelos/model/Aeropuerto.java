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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidad que representa a un aeropuerto
 */
@Entity
@Table(name = "aeropuerto")
public class Aeropuerto implements java.io.Serializable {

	private int id;
	private String nombre;
	private String ciudad;
	private String pais;
	private Set<Ruta> rutasForAeropuertoOrigen = new HashSet<Ruta>(0);
	private Set<Ruta> rutasForAeropuertoDestino = new HashSet<Ruta>(0);

	public Aeropuerto() {
	}

	public Aeropuerto(int id, String nombre, String ciudad, String pais) {
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public Aeropuerto(int id, String nombre, String ciudad, String pais, Set<Ruta> rutasForAeropuertoOrigen,
			Set<Ruta> rutasForAeropuertoDestino) {
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.rutasForAeropuertoOrigen = rutasForAeropuertoOrigen;
		this.rutasForAeropuertoDestino = rutasForAeropuertoDestino;
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

	@NotEmpty
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@NotEmpty
	@Column(name = "ciudad", nullable = false)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@NotEmpty
	@Column(name = "pais", nullable = false)
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aeropuertoByAeropuertoOrigen")
	public Set<Ruta> getRutasForAeropuertoOrigen() {
		return this.rutasForAeropuertoOrigen;
	}

	public void setRutasForAeropuertoOrigen(Set<Ruta> rutasForAeropuertoOrigen) {
		this.rutasForAeropuertoOrigen = rutasForAeropuertoOrigen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aeropuertoByAeropuertoDestino")
	public Set<Ruta> getRutasForAeropuertoDestino() {
		return this.rutasForAeropuertoDestino;
	}

	public void setRutasForAeropuertoDestino(Set<Ruta> rutasForAeropuertoDestino) {
		this.rutasForAeropuertoDestino = rutasForAeropuertoDestino;
	}
	
}
