package dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement (name="incidencia")
@XmlType(propOrder = {"estado","codigo", "puesto", "problema","fechaResolucionEliminacion", "causa", "resolucion"})
@XmlAccessorType (XmlAccessType.FIELD) 
public class Incidencia implements Comparable<Incidencia>, Serializable {
////////////////////////////////Variables////////////////////////
	
	@XmlElement(required = true)
	String codigo;
	@XmlElement(required = true)
	String problema;
	@XmlElement(required = true)
	String causa;
	@XmlElement(required = true)
	String resolucion;
	@XmlElement(required = true)
	String estado;
	@XmlTransient
	static int id;
	@XmlElement(required = true)
	int puesto;
	@XmlTransient
	int dia,mes,anyo,horas,minutos;
	@XmlTransient
	int diar;
	@XmlTransient
	int mesr;
	@XmlTransient
	int anyor;
	@XmlElement(required = true)
	String fechaResolucionEliminacion;
	@XmlTransient
	LocalDateTime hora = LocalDateTime.now();
	@XmlTransient
	String fecha;
/////////////////////Constructores///////////////////////////////	
	/**
	 * Contructor que crea una Incidencia llena
	 */
	public Incidencia (String problema, int puesto) {
		
		
		this.dia = hora.getDayOfMonth();
		this.mes = hora.getMonthValue();
		this.anyo = hora.getYear();
		this.horas = hora.getHour();
		this.minutos = hora.getMinute();
		this.estado = "pendiente";
		setProblema(problema);
		this.puesto = puesto;
		fecha = dia+"/"+mes+"/"+anyo;
		
	}
	/**
	 * Contructor que crea una Incidencia vacia
	 */
	public Incidencia () {
	
	}
	/**
	 * Método que genera el atributo fechaResolucionEliminacion
	 * @param diar
	 * @param mesr
	 * @param anyor
	 * @return
	 */
	public String Generador(int diar,int mesr,int anyor) {
		this.fechaResolucionEliminacion= diar+"/"+mesr+"/"+anyor;
		return fechaResolucionEliminacion;
		
	}
	public String getFechaResolucionEliminacion() {
		return fechaResolucionEliminacion;
	}
	public void setFechaResolucionEliminacion(String fechaResolucionEliminacion) {
		this.fechaResolucionEliminacion = fechaResolucionEliminacion;
	}
	//////////geters y seters///////////////////////////////////////
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Incidencia.id = id;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public int getDiar() {
		return diar;
	}

	public void setDiar(int diar) {
		this.diar = diar;
	}

	public int getMesr() {
		return mesr;
	}

	public void setMesr(int mesr) {
		this.mesr = mesr;
	}

	public int getAnyor() {
		return anyor;
	}

	public void setAnyor(int anyor) {
		this.anyor = anyor;
	}
	////////////////////////Sobre escritos/////////////////////
	@Override
	public String toString() {
		
		String datosIncidencia = "\nCódigo: "+getCodigo()+"\nEstado: "+getEstado()+ "\nPuesto: "+getPuesto() + "\nProblema: "+getProblema() + "\n";
		
		if(getEstado() == "eliminada") {		
			datosIncidencia += "Fecha de eliminación: "+getFechaResolucionEliminacion()+ "\nCausa de eliminación: "+getCausa() + "\n";
		}
		else if(getEstado() == "resuelta") {		
			datosIncidencia += "Fecha resolución: "+getFechaResolucionEliminacion() + "\nResolución: "+getResolucion() + "\n";
		}
		return datosIncidencia;
	}


	/**
	 * Compara los codigos de las incidencias.
	 * @return 1 si son iguales.
	 * @return 0 si no son iguales.
	 */
	@Override
	public int compareTo(Incidencia o) {
		if(this.codigo.equals(o.codigo)) {
			return 1;
		}else
		return 0;
	}
	

}
