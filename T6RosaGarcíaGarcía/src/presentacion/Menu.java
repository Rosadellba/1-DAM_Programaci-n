package presentacion;

import java.util.Scanner;

public class Menu {
	public static void menuPrincipal() {
		System.out.println("Selecione una opción:");
		System.out.println("1.Registrar incidencia.");
		System.out.println("2.Buscar incidencia.");
		System.out.println("3.Modificar incidencia.");
		System.out.println("4.Eliminar incidencia.");
		System.out.println("5.Resolver incidencia.");
		System.out.println("6.Modificar incidencia resuelta.");
		System.out.println("7.Devolver incidencia resuelta.");
		System.out.println("8.Mostrar incidencias pendientes.");
		System.out.println("9.Mostrar incidencias resueltas.");
		System.out.println("10.Mostrar incidencias eliminadas.");
		System.out.println("11.Exportar XML.");
		System.out.println("12.Salir.");
	}
	/**
	 * sub menu para elgeir que array exportar a xml
	 */
	public static void subMenu() {
		System.out.println("1.Exportar pendientes");
		System.out.println("2.Exportar resueltas");
		System.out.println("3.Exportar eliminadas");
	}
	/**
	 * sub menu para modificar un objeto que se encuentra en el array de pendientes
	 */
	public static void modpMenu() {
		System.out.println("¿Qué datos deseas modificar?");
		System.out.println("1. nº de puesto");
		System.out.println("2. Problema");
		System.out.println("3. Salir");
	}
	/**
	 * sub menu para modificar un objeto que se encuentra en el array de resueltas
	 */
	public static void modrMenu() {
		System.out.println("¿Qué datos deseas modificar?");
		System.out.println("1. Fecha de resolución");
		System.out.println("2. Descripción");
		System.out.println("3. Salir");
	}
		/**
		 * Permite al usuario visualizar lo escrito en pantalla antes de pulsar intro
		 */
	public static void intro() {	
		Scanner teclado = new Scanner(System.in);
		System.out.println("Pulse intro para continuar");
		teclado.nextLine();
	}
}
