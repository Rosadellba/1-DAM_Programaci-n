package persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import dominio.Incidencia;
import dominio.Listas;

public class XML {
/**
 * Metodo que exporta las lista de pendientes a un xml
 * @param lista
 * @throws JAXBException
 * @throws IOException
 */
	public static void exportarPendientes(List<Incidencia> lista) throws JAXBException, IOException {
		Listas tempLista = new Listas();
		tempLista.setPendientes(lista);
		
		JAXBContext contexto = JAXBContext.newInstance(Listas.class);
		Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(tempLista, new FileWriter("pendientes.xml"));
}

	/**
	 * Metodo que exporta las lista de resuelta a un xml
	 * @param lista
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static void exportarResueltas(List<Incidencia> lista) throws JAXBException, IOException {
	Listas tempLista = new Listas();
	tempLista.setResueltas(lista);
	
	JAXBContext contexto = JAXBContext.newInstance(Listas.class);
	Marshaller m = contexto.createMarshaller();
	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	m.marshal(tempLista, new FileWriter("resueltas.xml"));
}

	/**
	 * Metodo que exporta las lista de eliminadas a un xml
	 * @param lista
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static void exportarEliminadas(List<Incidencia> lista) throws JAXBException, IOException {
	Listas tempLista = new Listas();
	tempLista.setEliminadas(lista);
	
	JAXBContext contexto = JAXBContext.newInstance(Listas.class);
	Marshaller m = contexto.createMarshaller();
	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	m.marshal(tempLista, new FileWriter("eliminados.xml"));
}
}
