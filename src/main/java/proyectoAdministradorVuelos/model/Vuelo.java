package proyectoAdministradorVuelos.model;
// Generated Feb 20, 2016 6:32:26 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidad que representa a un vuelo
 */
@Entity
@Table(name = "vuelo", uniqueConstraints = @UniqueConstraint(columnNames = { "idavion", "fecha", "horainicio" }) )
public class Vuelo implements java.io.Serializable {

	private int id;
	private Avion avion;
	private Ruta ruta;
	private Date fecha;
	private Date horainicio;
	private Date horafin;
	private Set<Pasajero> pasajeros = new HashSet<Pasajero>(0);

	public Vuelo() {
	}

	public Vuelo(int id, Avion avion, Ruta ruta, Date fecha, Date horainicio, Date horafin) {
		this.id = id;
		this.avion = avion;
		this.ruta = ruta;
		this.fecha = fecha;
		this.horainicio = horainicio;
		this.horafin = horafin;
	}

	public Vuelo(int id, Avion avion, Ruta ruta, Date fecha, Date horainicio, Date horafin, Set<Pasajero> pasajeros) {
		this.id = id;
		this.avion = avion;
		this.ruta = ruta;
		this.fecha = fecha;
		this.horainicio = horainicio;
		this.horafin = horafin;
		this.pasajeros = pasajeros;
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
	@JoinColumn(name = "idavion", nullable = false)
	public Avion getAvion() {
		return this.avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idruta", nullable = false)
	public Ruta getRuta() {
		return this.ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 13)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@NotNull
	@DateTimeFormat(pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	@Column(name = "horainicio", nullable = false, length = 15)
	public Date getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Date horainicio) {
		this.horainicio = horainicio;
	}

	@NotNull
	@DateTimeFormat(pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	@Column(name = "horafin", nullable = false, length = 15)
	public Date getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Date horafin) {
		this.horafin = horafin;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pasajeroxvuelo", joinColumns = {
			@JoinColumn(name = "idvuelo", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idpasajero", nullable = false, updatable = false) })
	public Set<Pasajero> getPasajeros() {
		return this.pasajeros;
	}

	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	@Override
	public String toString() {
		return ruta + "-" + fecha + " " + horainicio;
	}
	
	

}
