package dominio;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import presentacion.Menu;

@XmlRootElement (name="controlIncidencias")
@XmlType (propOrder = {"pendientes", "resueltas", "eliminadas"})
@XmlAccessorType (XmlAccessType.FIELD)
public class Listas implements Serializable {
	/**
	 * Lista que guarda Incidencias que tienen 
	 * su estado en pendiente
	 */
	@XmlElement(name = "incidencia" , required = false)
	 private List <Incidencia> pendientes = new ArrayList<>();
	/**
	 * Lista que guarda Incidencias que tienen 
	 * su estado en resuelta
	 */
	@XmlElement(name = "incidencia" , required = false)
	 private List <Incidencia> resueltas = new ArrayList<>();
	/**
	 * Lista que guarda Incidencias que tienen 
	 * su estado en eliminada
	 */
	@XmlElement(name = "incidencia" , required = false)
	 private List <Incidencia> eliminadas = new ArrayList<>();
	 
	/**
	  * Contructor de listas vacia.
	  */
	 public Listas() {
		 
	 }
	 ///////////geters y seters////////////////////
	 public List<Incidencia> getPendientes() {
		return pendientes;
	}

	public void setPendientes(List<Incidencia> pendientes) {
		this.pendientes = pendientes;
	}

	public List<Incidencia> getResueltas() {
		return resueltas;
	}

	public void setResueltas(List<Incidencia> resueltas) {
		this.resueltas = resueltas;
	}

	public List<Incidencia> getEliminadas() {
		return eliminadas;
	}

	public void setEliminadas(List<Incidencia> eliminadas) {
		this.eliminadas = eliminadas;
	}

	////////////////////////Metodos///////////////////////
	
	/**
	 * registrarIncidencia Crea un Objeto de tipo incidencia y lo 
	 * agrega a la lista de pendientes.
	 * @param puesto
	 * @param problema
	 */
	public Incidencia registrarIncidencia( int puesto, String problema) {
		
		 Incidencia nueva = new Incidencia(problema, puesto);
		 nuevaId(nueva.getFecha(), nueva);
		 pendientes.add(nueva);
		System.out.println("La incidencia se ha registrado correctamente");
		mostrarIncidencia(nueva);
		return nueva;
	}
	 /**
	  * buscarIncidencia segun el estado busca en una lista atravez del 
	  * atributo codigo y te imprime en pantalla donde se ha encontrado la incidencia 
	  * y te la enseña.
	  * @param codigo
	  * @param estado
	  * @return Incidencia.
	  */
	 public Incidencia buscarIncidencia(String codigo, String estado) {
			Incidencia incidenciaBuscada = null;
			int i;

			
			if(estado.equalsIgnoreCase("pendiente")) {
				
				for( i = 0; i < pendientes.size(); i++) {
					if(pendientes.get(i).getCodigo().equals(codigo)) {
						incidenciaBuscada = pendientes.get(i);
				System.out.println("Se ha encontado en pendientes");
				mostrarIncidencia(incidenciaBuscada);
					}
				}
				
			}else if(estado.equalsIgnoreCase("resuelta")) {
				for( i = 0; i < resueltas.size(); i++) {
					if(resueltas.get(i).getCodigo().equals(codigo)) {
								incidenciaBuscada = resueltas.get(i);
				System.out.println("Se ha encontrado en resueltas");	
				mostrarIncidencia(incidenciaBuscada);
					}
				}

				
			}else if(estado.equalsIgnoreCase("eliminada")) {
				for( i = 0; i < eliminadas.size(); i++) {
					if(eliminadas.get(i).getCodigo().equals(codigo)) {
								incidenciaBuscada = eliminadas.get(i);
				System.out.println("Se ha enconetrado en eliminadas");	
				mostrarIncidencia(incidenciaBuscada);
					}
				}
				
			}else {
				System.out.println("La incidencia no ha sido encontrada, revisa que todos los datos han sido introducidos correctamente");
			}
				
			
			return incidenciaBuscada;
		}
	/**
	 * buscarIncidencia segun el estado busca en una lista atravez del 
	  * atributo codigo.
	 * @param codigo
	 * @param estado
	 * @return Incidencia
	 */
	 private Incidencia buscarIncidencias(String codigo, String estado) {
			Incidencia incidenciaBuscada = null;
			int i;

			
			if(estado.equalsIgnoreCase("pendiente")) {
				
				for( i = 0; i < pendientes.size(); i++) {
					if(pendientes.get(i).getCodigo().equals(codigo)) {
						incidenciaBuscada = pendientes.get(i);

					}
				}
				
			}else if(estado.equalsIgnoreCase("resuelta")) {
				for( i = 0; i < resueltas.size(); i++) {
					if(resueltas.get(i).getCodigo().equals(codigo)) {
								incidenciaBuscada = resueltas.get(i);

					}
				}

				
			}else if(estado.equalsIgnoreCase("eliminada")) {
				for( i = 0; i < eliminadas.size(); i++) {
					if(eliminadas.get(i).getCodigo().equals(codigo)) {
								incidenciaBuscada = eliminadas.get(i);

					}
				}
				
			}

			return incidenciaBuscada;
		}
	 /**
	  * posicionIncidencia busca la Incidencia.
	  * @param codigo TODO
	  * @return Devuelve en que indice se ha encontrado Incidencia
	  */
	 	private int posicionIncidencia(String codigo, String estado) {
	 		int i;
	 		int j =0;
	 		
	 		if(estado.equalsIgnoreCase("pendiente")) {
				
				for( i = 0; i < pendientes.size(); i++) {
					if(pendientes.get(i).getCodigo().equals(codigo)) {
						j=i;
					}
				}
				
			}else if(estado.equalsIgnoreCase("resuelta")) {
				for( i = 0; i < resueltas.size(); i++) {
					if(resueltas.get(i).getCodigo().equals(codigo)) {
								j=i;	
					}
				}

				
			}else if(estado.equalsIgnoreCase("eliminada")) {
				for( i = 0; i < eliminadas.size(); i++) {
					if(eliminadas.get(i).getCodigo().equals(codigo)) {
								j=i;
					}
				}
				
			}

	 		return j;
	 	}
	 	
		/**
		 * 
		 * modificarIncidencia cambia algunos de los valores de los atributos
		 * de Incidencias, que estén en la lista de pendientes
		 *
		 * @param codigo
		 * @param estado
		 */
		public Incidencia modificarIncidencia(String codigo,String estado) {
			Scanner teclado = new Scanner(System.in);
			if(buscarIncidencias(codigo, estado)!= null) {
				int opciones=0;
				boolean verdad = false;
				do {
					Menu.modpMenu();
					opciones = teclado.nextInt();
					switch (opciones) {
					case 1:
						System.out.println("¿En cual puesto se ha producido la incidencia?");
						pendientes.get(posicionIncidencia(codigo,estado)).setPuesto(teclado.nextInt());
						Menu.intro();
						break;
					case 2:
						System.out.println("¿Cual es el problema?");
						teclado.nextLine();
						String problema = teclado.nextLine();
						pendientes.get(posicionIncidencia(codigo,estado)).setProblema(problema);
						Menu.intro();
						break;
					case 3:
						verdad = true;
						break;
					default:
						teclado.nextLine();
						System.out.println("La opción elegida es incorrecta.\n Pulse intro para continuar");
						teclado.nextLine();
					}
				}while(verdad != true);
				System.out.println("Se ha modificado la incidencia");
				mostrarIncidencia(pendientes.get(posicionIncidencia(codigo,estado)));
				
			}else System.out.println("La incidencia no ha sido encontrada");
			Incidencia incidencia = buscarIncidencias(codigo, estado);
			return incidencia;
		}
		/**
		 * 
		 * modificarResuelta cambia algunos de los valores de los atributos
		 * de Incidencias, que estén en la lista de resueltas
		 *
		 * @param codigo
		 */
		public Incidencia  modificarResuelta(String codigo) {
			Scanner teclado = new Scanner(System.in);
			if(buscarIncidencia(codigo,"resuelta")!= null) {
				Incidencia nueva = buscarIncidencia(codigo,"resuelta");
				boolean verdad = false;
				
				do {
					Menu.modrMenu();
					int opciones=0;
					opciones = teclado.nextInt();
					switch (opciones) {
					case 1:
						System.out.println("¿Que dia se ha resuelto?");
						int dia =teclado.nextInt();
						System.out.println("¿Que mes se ha resuelto?");
						int mes = teclado.nextInt();
						System.out.println("¿Que año se ha resuelto?");
						int anyo = teclado.nextInt();
						String fecha = nueva.Generador(dia, mes, anyo);
						pendientes.get(posicionIncidencia(codigo,"resuelta")).setFechaResolucionEliminacion(fecha);
						Menu.intro();
						break;
					case 2:
						System.out.println("¿Como se ha resuelto la incidencia?");
						teclado.nextLine();
						String resolucion = teclado.nextLine();
						pendientes.get(posicionIncidencia(codigo,"resuelta")).setResolucion(resolucion);
						Menu.intro();
						break;
					case 3:
						verdad = true;
						break;
					default:
						teclado.nextLine();
						System.out.println("La opción elegida es incorrecta.\n Pulse intro para continuar");
						teclado.nextLine();
					}
				}while(verdad != true);
				System.out.println("Se ha modificado la incidencia");
				mostrarIncidencia(pendientes.get(posicionIncidencia(codigo,"resuelta")));
				
			}
			Incidencia incidencia = buscarIncidencias(codigo, "resuelta"); 
			return incidencia;

		}
		/**
		 * eliminar añade algunos atributos a Incidencia,
		 * la añade a la lista elimnadas y las borra de pendientes
		 * @param codigo
		 * @param causa
		 */
		public Incidencia eliminar(String codigo,String causa) {
			Incidencia nueva = buscarIncidencias(codigo, "pendiente");
			String fecha = nueva.Generador(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getYear());
			pendientes.get(posicionIncidencia(codigo,"pendiente")).setEstado("eliminada");
			pendientes.get(posicionIncidencia(codigo,"pendiente")).setFechaResolucionEliminacion(fecha);
			pendientes.get(posicionIncidencia(codigo,"pendiente")).setCausa(causa);
			eliminadas.add(pendientes.get(posicionIncidencia(codigo, "pendiente")));
			eliminadas = ordenar(eliminadas);
			pendientes.remove(posicionIncidencia(codigo, "pendiente"));
			pendientes = ordenar(pendientes);
			
			System.out.println("La incidencia ha sido eliminada");
			mostrarIncidencia(eliminadas.get(posicionIncidencia(codigo,"eliminada")));
			nueva = buscarIncidencias(codigo, "eliminada");
			return nueva;
		
		}
		/**
		 * resolver añade algunos atributos a Incidencia,
		 * la añade a la lista resueltas y las borra de pendientes
		 * @param codigo
		 * @param causa
		 */
		public Incidencia resolver(String codigo,String causa) {
			Incidencia nueva = buscarIncidencia(codigo,"pendiente");
			String fecha = nueva.Generador(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getYear());
			pendientes.get(posicionIncidencia(codigo,"pendiente")).setEstado("resuelta");
			pendientes.get(posicionIncidencia(codigo,"pendiente")).setFechaResolucionEliminacion(fecha);
			resueltas.add(pendientes.get(posicionIncidencia(codigo, "pendiente")));
			resueltas = ordenar(resueltas);
			pendientes.remove(posicionIncidencia(codigo, "pendiente"));
			pendientes = ordenar(pendientes);
			
			System.out.println("La incidencia ha sido resuelta");
			mostrarIncidencia(resueltas.get(posicionIncidencia(codigo,"resuelta")));
			nueva = buscarIncidencias(codigo, "resuelta");
			return nueva;
		}
		

		/**
		 * devolver Elimina algunos atributos de Incidencia y cambia su etsado a pendiente
		 * @param codigo
		 */
		public Incidencia devolver(String codigo) {
			Incidencia nueva = buscarIncidencia(codigo,"resuelta");
			String fecha =nueva.Generador(0, 0, 0);
			resueltas.get(posicionIncidencia(codigo,"resuelta")).setFechaResolucionEliminacion(fecha);
			resueltas.get(posicionIncidencia(codigo,"resuelta")).setEstado("pendiente");
			resueltas.get(posicionIncidencia(codigo,"pendiente")).setResolucion(null);
			System.out.println("La incidencia ha sido devuelta a la lista pendientes");
			mostrarIncidencia(resueltas.get(posicionIncidencia(codigo, "pendiente")));
			pendientes.add(resueltas.get(posicionIncidencia(codigo, "pendiente")));
			pendientes = ordenar(pendientes);
			resueltas.remove(posicionIncidencia(codigo, "pendiente"));
			resueltas = ordenar(resueltas);
			nueva = buscarIncidencias(codigo, "pendiente");
			return nueva;
			
		
		}
		/**
		 * mostrarIncidencia muestra en la consola incidencia que le das
		 * @param encontrada
		 */
		private void mostrarIncidencia(Incidencia encontrada) {
			System.out.println(encontrada.toString());
		}
		/**
		 * mostrarPendientes muestra en la consola todas incidencias almacenadas en la listas 
		 * de pendientes
		 */
		public void mostrarPendientes() {
			for (Incidencia incidencia : pendientes) {
				System.out.println(incidencia.toString());
				System.out.println();
			}
		}
		/**
		 * mostrarPendientes muestra en la consola todas incidencias almacenadas en la listas 
		 * de resueltas
		 */
		public void mostrarResueltas() {
			for (Incidencia incidencia : resueltas) {
				System.out.println(incidencia.toString());
				System.out.println();
			}
		}
		/**
		 * mostrarPendientes muestra en la consola todas incidencias almacenadas en la listas 
		 * de eliminadas
		 */
		public void mostrarEliminadas() {
			for (Incidencia incidencia : eliminadas) {
				System.out.println(incidencia.toString());
				System.out.println();
			}
		}
		/**
		 * ordenar osdena una lista por su cosdigo
		 * @param lista
		 * @return
		 */
		private List<Incidencia> ordenar(List<Incidencia> lista) {
			TreeSet<Incidencia> listaOrdenada = new TreeSet<>();
			listaOrdenada.addAll(lista);	
			return new ArrayList<Incidencia>(listaOrdenada);

		}
		/**
		 * comprobarUltimaFecha extarae la fecha del atributo codigo de
		 * Incidencias y lo compara con la fecha de hoy.
		 * @param codigo
		 * @return sonFechasIguales
		 */
		private  boolean comprobarUltimaFecha(String fechaHoy) {
			 boolean sonFechasIguales = false;
			    String ultimaFecha = null;
			    String fecha = "";

			        if (!pendientes.isEmpty()) {
			            ultimaFecha = pendientes.get(pendientes.size()-1).getCodigo();
			            for(int i = 0; i <= ultimaFecha.length()-1; i++) {
			            	if(ultimaFecha.charAt(i)=='-')
			            		break;
			            	fecha += ultimaFecha.charAt(i);
			            }
			            if (fecha.equals(fechaHoy)) {
			                sonFechasIguales = true;
			               
			            }
			        }
			        
			        if (!resueltas.isEmpty()) {
			            ultimaFecha = resueltas.get(resueltas.size() - 1).getCodigo();
			            for(int i = 0; i <= ultimaFecha.length()-1; i++) {
			            	if(ultimaFecha.charAt(i)=='-')
			            		break;
			            	fecha += ultimaFecha.charAt(i);
			            }
			            if (ultimaFecha.equals(fechaHoy)) {
			                sonFechasIguales = true;
			            }
			        }

			        if (!eliminadas.isEmpty()) {
			            ultimaFecha = eliminadas.get(eliminadas.size() - 1).getCodigo();
			            for(int i = 0; i <= ultimaFecha.length()-1; i++) {
			            	if(ultimaFecha.charAt(i)=='-')
			            		break;
			            	fecha += ultimaFecha.charAt(i);
			            }
			            if (ultimaFecha.equals(fechaHoy)) {
			                sonFechasIguales = true;
			            }
			        }


			    return sonFechasIguales;
		}
		/**
		 *  nuevaId incremeta del valor de id y le da valor al atributo codigo 
		 *  de una Incidencia
		 * @param fecha
		 * @param incidencia
		 */
		private void nuevaId(String fecha ,Incidencia incidencia) {
			int id= ultimaId();

			if (id>=1 && comprobarUltimaFecha(fecha)==true ) {
				id++;
			}
			String codigo= incidencia.getDia()+"/"+incidencia.getMes()+"/"+incidencia.getAnyo()+"-"+incidencia.getHoras()+":"
			+incidencia.getMinutos()+"-"+id;
			
			incidencia.setCodigo(codigo);
			
		}
		/**
		 * ultimaId coge la id del atributo codigo.
		 * @return ultimaId
		 */
		private int  ultimaId() {
			int ultimaId=1;

			 if (!pendientes.isEmpty()) {
				String ultimaFecha = pendientes.get(pendientes.size()-1).getCodigo();
				
				 for(int i =ultimaFecha.length()-1; i > 0; i--) {
	            	if(ultimaFecha.charAt(i)=='-')
	            		break;
	            	ultimaId = Character.getNumericValue(ultimaFecha.charAt(i));

	            }
			 }
			  
			return ultimaId;
			
		}

}
