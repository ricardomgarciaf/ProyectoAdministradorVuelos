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
 * Entidad que representa a un avion
 */
@Entity
@Table(name = "avion")
public class Avion implements java.io.Serializable {

	private int id;
	private String modelo;
	private int capacidad;
	private String fabricante;
	private Set<Vuelo> vuelos = new HashSet<Vuelo>(0);

	public Avion() {
	}

	public Avion(String modelo, int capacidad, String fabricante) {
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.fabricante = fabricante;
	}

	public Avion(int id, String modelo, int capacidad, String fabricante, Set<Vuelo> vuelos) {
		this.id = id;
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.fabricante = fabricante;
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

	@NotEmpty
	@Column(name = "modelo", nullable = false)
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "capacidad", nullable = false)
	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@NotEmpty
	@Column(name = "fabricante", nullable = false)
	public String getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "avion")
	public Set<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(Set<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}
