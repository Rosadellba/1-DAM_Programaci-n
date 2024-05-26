package persistencia;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dominio.Incidencia;




public class IncidenciaDao {
		private Connection conexion;

	/**
	 * Contructor que lo que hace es conectar con la base de datos
	 */
		public IncidenciaDao(){
			conexion = conectar();
		}
		/**
		 * Metodo para conectar con la base de datos
		 * @return Connection
		 */
		public Connection conectar() {
			Connection con = null;
			String url ="jdbc:mysql://localhost/incidencias";
			try {
				con =  DriverManager.getConnection(url,"rosa","12345");
				
			} catch (SQLException e) {
				System.out.println("Error al conectar con la BD");
			}
			return con;
			
		}
		
		/**
		 * Metodo para cerrar la conexión la base de datos
		 */
		public void cerrarConexion(){
			try {
				conectar().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Metodo que busca una incidencia pendiente
		 * @param codigoBuscar
		 * @return incidencia
		 */
		public Incidencia buscaIncidenciaPendiente(String codigoBuscar) {
			Connection con = conectar();
			Incidencia encontrada = new Incidencia();
			
			String sql = "SELECT * FROM pendientes WHERE Codigo = ?";
			
		try(PreparedStatement sentencia = con.prepareStatement(sql)) {
			
			sentencia.setString(1, codigoBuscar);
			
			
				ResultSet rs = sentencia.executeQuery();
				if (rs.next()) {
					
					String codigo = rs.getString("Codigo");
					encontrada.setCodigo(codigo);
					String estado = rs.getString("Estado");
					encontrada.setEstado(estado);
					int puesto = rs.getInt("Puesto");
					encontrada.setPuesto(puesto);
					String problema = rs.getString("Problema");
					encontrada.setProblema(problema);
					
				}

			
		} catch (SQLException e) {
			e.getMessage();
			e.getSQLState();
			e.getErrorCode();
		}
			return encontrada;
		}
		/**
		 * Metodo que busca una incidencia eliminada
		 * @param codigoBuscar
		 * @return incidencia
		 */
		public Incidencia buscaIncidenciaEliminada(String codigoBuscar) {
			Connection con = conectar();
			Incidencia encontrada = new Incidencia();
			int numero=0;
			String sql = "SELECT * FROM eliminadas WHERE Codigo = ?";
			
		try(PreparedStatement sentencia = con.prepareStatement(sql)) {
			
			sentencia.setString(1, codigoBuscar);
			
			
				ResultSet rs = sentencia.executeQuery();
				if (rs.next()) {
					
					String codigo = rs.getString("Codigo");
					encontrada.setCodigo(codigo);
					String estado = rs.getString("Estado");
					encontrada.setEstado(estado);
					int puesto = rs.getInt("Puesto");
					encontrada.setPuesto(puesto);
					String problema = rs.getString("Problema");
					encontrada.setProblema(problema);
					String fecha = rs.getString("Fechadeeliminacion");
					String causa = rs.getString("Causadeeliminacion");
				}

			
		} catch (SQLException e) {
			e.getMessage();
			e.getSQLState();
			e.getErrorCode();
		}
			return encontrada;
		}
		/**
		 * Metodo que busca una incidencia resuelta
		 * @param codigoBuscar
		 * @return incidencia
		 */
		public Incidencia buscaIncidenciaResuelta(String codigoBuscar) {
			Connection con = conectar();
			Incidencia encontrada = new Incidencia();
			int numero=0;
			String sql = "SELECT * FROM eliminadas WHERE Codigo = ?";
			
		try(PreparedStatement sentencia = con.prepareStatement(sql)) {
			
			sentencia.setString(1, codigoBuscar);
			
			
				ResultSet rs = sentencia.executeQuery();
				if (rs.next()) {
					
					String codigo = rs.getString("Codigo");
					encontrada.setCodigo(codigo);
					String estado = rs.getString("Estado");
					encontrada.setEstado(estado);
					int puesto = rs.getInt("Puesto");
					encontrada.setPuesto(puesto);
					String problema = rs.getString("Problema");
					encontrada.setProblema(problema);
					String fecha = rs.getString("Fecharesolucion");
					String resolucion = rs.getString("Resolucion");
				}

			
		} catch (SQLException e) {
			e.getMessage();
			e.getSQLState();
			e.getErrorCode();
		}
			return encontrada;
		}
		/**
		 * Metodo que crea una incidencia en la base de datos
		 * @param incidencia
		 */
		public void create(Incidencia incidencia) {
			Connection con = conectar();
			if(incidencia.getEstado().equals("pendiente")) {
				String sql = "INSERT INTO pendientes (Codigo,Estado,Puesto,Problema) VALUES(?,?,?,?) ";
				try (PreparedStatement sentencia = con.prepareStatement(sql)){
					
					sentencia.setString(1, incidencia.getCodigo());
					sentencia.setString(2, incidencia.getEstado());
					sentencia.setInt(3, incidencia.getPuesto());
					sentencia.setString(4, incidencia.getProblema());
					sentencia.executeUpdate();
				} catch (SQLException e) {
			        System.out.println("Mensaje de error: " + e.getMessage());
			        System.out.println("Estado SQL: " + e.getSQLState());
			        System.out.println("Codigo de error: " + e.getErrorCode());
				}
			}else if(incidencia.getEstado().equals("resuelta")){
				String sql = "INSERT INTO pendientes (Codigo,Estado,Puesto,Problema,Fecharesolucion,Resolucion) VALUES(?,?,?,?,?,?) ";
				try (PreparedStatement sentencia = con.prepareStatement(sql)){
					sentencia.setString(1, incidencia.getCodigo());
					sentencia.setString(2, incidencia.getEstado());
					sentencia.setInt(3, incidencia.getPuesto());
					sentencia.setString(4, incidencia.getProblema());
					sentencia.setString(5,incidencia.getFechaResolucionEliminacion());
					sentencia.setString(6, incidencia.getResolucion());
					sentencia.executeUpdate();
				} catch (SQLException e) {
			        System.out.println("Mensaje de error: " + e.getMessage());
			        System.out.println("Estado SQL: " + e.getSQLState());
			        System.out.println("Codigo de error: " + e.getErrorCode());
				}
			}else if(incidencia.getEstado().equals("eliminada")){
				String sql = "INSERT INTO pendientes (Codigo,Estado,Puesto,Problema,Fechadeeliminacion,Causadeeliminacion) VALUES(?,?,?,?,?,?) ";
				try (PreparedStatement sentencia = con.prepareStatement(sql)){
					sentencia.setString(1, incidencia.getCodigo());
					sentencia.setString(2, incidencia.getEstado());
					sentencia.setInt(3, incidencia.getPuesto());
					sentencia.setString(4, incidencia.getProblema());
					sentencia.setString(5, incidencia.getFechaResolucionEliminacion());
					sentencia.setString(6, incidencia.getCausa());
					sentencia.executeUpdate();
				} catch (SQLException e) {
			        System.out.println("Mensaje de error: " + e.getMessage());
			        System.out.println("Estado SQL: " + e.getSQLState());
			        System.out.println("Codigo de error: " + e.getErrorCode());
				}
			}
		}
		
		/**
		 * Metodo qeu elimina una incidecnia en la base de datos
		 * @param codigoBuscar
		 */
		public void delete(String codigoBuscar) {
			Connection con = conectar();
			String sql = "";
			if(buscaIncidenciaPendiente(codigoBuscar)!=null) {
				sql = "DELETE FROM pendientes where Codigo =?";
				try(PreparedStatement sentencia = con.prepareStatement(sql)) {
					sentencia.setString(1, codigoBuscar);	
					sentencia.executeUpdate();					
				} catch (SQLException e) {
					e.getMessage();
					e.getSQLState();
					e.getErrorCode();
				}
				
			}else if(buscaIncidenciaResuelta(codigoBuscar)!=null) {
				sql = "DELETE FROM resueltas where Codigo =?";
				try(PreparedStatement sentencia = con.prepareStatement(sql)) {
					sentencia.setString(1, codigoBuscar);	
					sentencia.executeUpdate();					
				} catch (SQLException e) {
					e.getMessage();
					e.getSQLState();
					e.getErrorCode();
				}
			}else if(buscaIncidenciaEliminada(codigoBuscar)!=null) {
				sql = "DELETE FROM eliminadas where Codigo =?";
				try(PreparedStatement sentencia = con.prepareStatement(sql)) {
					sentencia.setString(1, codigoBuscar);	
					sentencia.executeUpdate();					
				} catch (SQLException e) {
					e.getMessage();
					e.getSQLState();
					e.getErrorCode();
				}
			}
			
		}
		
		/**
		 * Metodo que actualiza la base de datos
		 * @param incidencia
		 */
		public void update(Incidencia incidencia) {
			Connection con = conectar();
			if(incidencia.getEstado().equals("pendientes")) {
				String sql = "UPDATE pendintes SET Codigo=?,Estado=?,Puesto=?,Problema=?";
				try(PreparedStatement sentencia = con.prepareStatement(sql)) {
					sentencia.setString(1, incidencia.getCodigo());
					sentencia.setString(2, incidencia.getEstado());
					sentencia.setInt(3, incidencia.getPuesto());
					sentencia.setString(4, incidencia.getProblema());
					sentencia.executeUpdate();			
				} catch (SQLException e) {
					e.getMessage();
					e.getSQLState();
					e.getErrorCode();
				}
			}else if(incidencia.getEstado().equals("resueltas")) {
				String sql = "UPDATE resueltas SET Codigo=?,Estado=?,Puesto=?,Problema=?,Fecharesolucion=?,Resolucion=?";
				try(PreparedStatement sentencia = con.prepareStatement(sql)) {
					sentencia.setString(1, incidencia.getCodigo());
					sentencia.setString(2, incidencia.getEstado());
					sentencia.setInt(3, incidencia.getPuesto());
					sentencia.setString(4, incidencia.getProblema());
					sentencia.setString(5, incidencia.getFechaResolucionEliminacion());
					sentencia.setString(6, incidencia.getResolucion());
					sentencia.executeUpdate();			
				} catch (SQLException e) {
					e.getMessage();
					e.getSQLState();
					e.getErrorCode();
				}
			}else if(incidencia.getEstado().equals("eliminadas")) {
				String sql = "UPDATE eliminadas SET Codigo=?,Estado=?,Puesto=?,Problema=?,Fechadeeliminancion=?,Causadeeliminacion=?";
				try(PreparedStatement sentencia = con.prepareStatement(sql)) {
					sentencia.setString(1, incidencia.getCodigo());
					sentencia.setString(2, incidencia.getEstado());
					sentencia.setInt(3, incidencia.getPuesto());
					sentencia.setString(4, incidencia.getProblema());
					sentencia.setString(5, incidencia.getFechaResolucionEliminacion());
					sentencia.setString(6, incidencia.getCausa());
					sentencia.executeUpdate();			
				} catch (SQLException e) {
					e.getMessage();
					e.getSQLState();
					e.getErrorCode();
				}
			}
		}
		
		
		/**
		 * Metodo que convierte todos los registros de la tabla pendientes en un listado
		 * @return Lista pendientes
		 */
		public List<Incidencia> listarIncidenciasPendinetes(){
			Connection con = conectar();
			String sql = "UPDATE pendintes SET Codigo=?,Estado=?,Puesto=?,Problema=?";
			Incidencia nueva = null;
			List<Incidencia> lista = new ArrayList<Incidencia>();
			try(PreparedStatement sentencia = con.prepareStatement(sql);
					ResultSet rs = sentencia.executeQuery(sql)) {
				while (rs.next()) {
					String codigo = rs.getString("Codigo");
					nueva.setCodigo(codigo);
					String estado = rs.getString("Estado");
					nueva.setEstado(estado);
					int puesto = rs.getInt("Puesto");
					nueva.setPuesto(puesto);
					String problema = rs.getString("Problema");
					nueva.setProblema(problema);
					
					lista.add(nueva);
				}
				
			} catch (SQLException e) {
				e.getMessage();
				e.getSQLState();
				e.getErrorCode();
			}
			
			return lista;
		}
		/**
		 * Metodo que convierte todos los registros de la tabla resueltas en un listado
		 * @return Lista resueltas
		 */
		public List<Incidencia> listarIncidenciasResueltas(){
			Connection con = conectar();
			String sql = "UPDATE resueltas SET Codigo=?,Estado=?,Puesto=?,Problema=?,Fecharesolucion=?,Resolucion=?";
			Incidencia nueva = null;
			List<Incidencia> lista = new ArrayList<Incidencia>();
			try(PreparedStatement sentencia = con.prepareStatement(sql);
					ResultSet rs = sentencia.executeQuery(sql)) {
				while (rs.next()) {
					String codigo = rs.getString("Codigo");
					nueva.setCodigo(codigo);
					String estado = rs.getString("Estado");
					nueva.setEstado(estado);
					int puesto = rs.getInt("Puesto");
					nueva.setPuesto(puesto);
					String problema = rs.getString("Problema");
					nueva.setProblema(problema);
					String fecha = rs.getString("Fecharesolucion");
					String resolucion = rs.getString("Resolucion");
					
					lista.add(nueva);
				}
				
			} catch (SQLException e) {
				e.getMessage();
				e.getSQLState();
				e.getErrorCode();
			}
			
			return lista;
		}
		/**
		 * Metodo que convierte todos los registros de la tabla eliminadas en un listado
		 * @return Lista eliminadas
		 */
		public List<Incidencia> listarIncidenciasEliminadas(){
			Connection con = conectar();
			String sql = "UPDATE eliminadas SET Codigo=?,Estado=?,Puesto=?,Problema=?,Fechadeeliminancion=?,Causadeeliminacion=?";
			Incidencia nueva = null;
			List<Incidencia> lista = new ArrayList<Incidencia>();
			try(PreparedStatement sentencia = con.prepareStatement(sql);
					ResultSet rs = sentencia.executeQuery(sql)) {
				while (rs.next()) {
					String codigo = rs.getString("Codigo");
					nueva.setCodigo(codigo);
					String estado = rs.getString("Estado");
					nueva.setEstado(estado);
					int puesto = rs.getInt("Puesto");
					nueva.setPuesto(puesto);
					String problema = rs.getString("Problema");
					nueva.setProblema(problema);
					String fecha = rs.getString("Fechadeeliminacion");
					String causa = rs.getString("Causadeeliminacion");
					
					lista.add(nueva);
				}
				
			} catch (SQLException e) {
				e.getMessage();
				e.getSQLState();
				e.getErrorCode();
			}
			
			return lista;
		}
}

