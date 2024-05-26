package aplicacion;

import java.io.IOException;

import java.util.Scanner;

import javax.xml.bind.JAXBException;


import dominio.Listas;
import persistencia.IncidenciaDao;
import persistencia.XML;
import presentacion.Menu;

public class Logica {
	/**
	 * Metodo que hace que switch funcine y se ejecuten en el los otros metodos
	 * @param opcion
	 * @param lista
	 * @param incidenciaDao
	 * @throws JAXBException
	 * @throws IOException
	 */
    public static void ejecutaOpcion(int opcion, Listas lista, IncidenciaDao incidenciaDao) throws JAXBException, IOException {
        Scanner teclado = new Scanner(System.in);
        final String ejemploCodigo ="¿Cual es el codigo de la incidencia?(dia/mes/año-horas-minutos-id)";
        final String preguntarEstado="¿La incidencia está pendiente|resuelta|eliminada?";
       
        switch (opcion) {


        case 1:
            System.out.println("Estas a punto de reistrar una nueva incidencia");
            System.out.println("Introduce una brebe descripción del problema");
            String problema = teclado.nextLine();
            System.out.println("¿En cual puesto se ha producido la incidencia?");
            int puesto = teclado.nextInt();
            incidenciaDao.create(lista.registrarIncidencia(puesto, problema));
            Menu.intro();
            break;

        case 2:
            System.out.println(ejemploCodigo);
            String codigo = teclado.next();
            System.out.println(preguntarEstado);
            String estado = teclado.next();
            lista.buscarIncidencia(codigo, estado);
            Menu.intro();
            break;

        case 3:
			System.out.println(ejemploCodigo);
			codigo = teclado.nextLine();
			System.out.println(preguntarEstado);
			estado = teclado.next();
			incidenciaDao.update( lista.modificarIncidencia(codigo, estado));
            Menu.intro();
            break;

        case 4:
			System.out.println(ejemploCodigo);
			codigo = teclado.nextLine();
			System.out.println("¿Cual es la causa de la eliminación?");
			String causa = teclado.nextLine();
			incidenciaDao.delete(codigo);
			incidenciaDao.create(lista.eliminar(codigo, causa));
            Menu.intro();
            break;

        case 5:
			System.out.println(ejemploCodigo);
			codigo = teclado.nextLine();
			System.out.println("¿Como has solucionado el problema?");
			causa = teclado.nextLine();
			incidenciaDao.delete(codigo);
			incidenciaDao.create(lista.resolver(codigo, causa));
            Menu.intro();
            break;

        case 6:
			System.out.println(ejemploCodigo);
			codigo = teclado.nextLine();
			incidenciaDao.update(lista.modificarResuelta(codigo));
            Menu.intro();
            break;
        case 7:
			System.out.println(ejemploCodigo);
			codigo = teclado.nextLine();
            lista.devolver(codigo);
            Menu.intro();
            break;

        case 8:
            lista.mostrarPendientes();
            Menu.intro();
            break;

        case 9:
            lista.mostrarResueltas();
            Menu.intro();
            break;

        case 10:
            lista.mostrarEliminadas();
            Menu.intro();
            break;
        case 11:
            Menu.subMenu();
            int opciones=0;
			opciones = teclado.nextInt();
			switch (opciones) {
					case 1:
						XML.exportarPendientes(lista.getPendientes());
						Menu.intro();
						break;
					case 2:
						XML.exportarResueltas(lista.getResueltas());
						Menu.intro();
						break;
					case 3:
						XML.exportarEliminadas(lista.getEliminadas());
						Menu.intro();
						break;
					}
            break;

        case 12:
            //Data.escribirFichero(lista);
            Menu.intro();
            System.out.println("¡Hasta mañana!");
            teclado.close();
            incidenciaDao.cerrarConexion();
            break;
            
            
        default:
            System.out.println("La opción elegida es incorrecta.");
            Menu.intro();
        }
        }

        

    

}