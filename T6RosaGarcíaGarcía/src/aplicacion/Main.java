package aplicacion;

import java.io.IOException;


import java.util.Scanner;

import javax.xml.bind.JAXBException;

import dominio.Listas;
import persistencia.IncidenciaDao;
import presentacion.Menu;



public class Main {
/**
 * Metodo principal que hace que se ejecute el programa incidencias
 * @param args
 */
    public static void main(String[] args) {
        IncidenciaDao incidenciaDao = new IncidenciaDao();
		incidenciaDao.conectar();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        Listas lista = new Listas();
        if(incidenciaDao.listarIncidenciasPendinetes()!=null || incidenciaDao.listarIncidenciasResueltas()!=null || incidenciaDao.listarIncidenciasEliminadas()!=null) {
        	lista.setPendientes(incidenciaDao.listarIncidenciasPendinetes());
        	lista.setResueltas(incidenciaDao.listarIncidenciasResueltas());
        	lista.setEliminadas(incidenciaDao.listarIncidenciasEliminadas());
        }
        	
        
        

        do {
        	  Menu.menuPrincipal();
        	  
            try {

                opcion = sc.nextInt();

                

            }catch (Exception e) {
            	
               //System.out.println("Error"+e.getMessage());
               //e.printStackTrace();
            }
            sc.nextLine();
            try {
				Logica.ejecutaOpcion(opcion,lista,incidenciaDao );
			} catch (JAXBException | IOException e) {

				e.printStackTrace();
			}
        } while (opcion != 12);
    }

}
