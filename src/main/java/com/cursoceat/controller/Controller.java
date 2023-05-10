package com.cursoceat.controller;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.nio.channels.NonReadableChannelException;
import java.nio.file.FileSystemLoopException;

import com.cursoceat.xml.schema.Club;
import com.cursoceat.xml.schema.Club.Socio;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Controller {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub

			//escribirXML();
			leerXML();
	}
	
	public static void leerXML() throws JAXBException{
		File miArhivo=new File("C:\\Users\\irime\\Desktop\\miClub.xml");
		/***
		 * Desagrupar xml UNmarshaller es leer un xml a partir de un archivo
		 * 1. crear el contexto 
		 * 2. leer o desagrupar a partir de un archivo xml	
		 */
		JAXBContext miContexto=JAXBContext.newInstance(Club.class);
		
		Unmarshaller miLectura=miContexto.createUnmarshaller();
		/* Debemos crear el objeto club con los socios a partir del le lectura que ha hecho el unmarshal con el archivo*/
		Club socios=(Club) miLectura.unmarshal(miArhivo);
		
		/* A ser una coleccion, lo leemos con un forEach*/
		for(Socio s:socios.getSocio()) {
			System.out.println(s.getIdSocio());
			System.out.println(s.getNombreSocio());
			System.out.println(s.getDireccion());
			System.out.println(s.getFechaAlta());	
		}	
	}
	
	
	public static void escribirXML() throws JAXBException{
		/**creamos un coleccion que nos permita guardar los datos de los socios que leamos al XML*/
		Club miclub=new Club();
		
		Socio socio1=new Socio();
		socio1.setIdSocio(1);
		socio1.setNombreSocio("Victoria Sevilla");
		socio1.setDireccion("Calle Amparo,15");
		socio1.setFechaAlta("01-01-2020");
		miclub.getSocio().add(socio1);
		
		Socio socio2=new Socio();
		socio2.setIdSocio(2);
		socio2.setNombreSocio("Monica");
		socio2.setDireccion("Don Victor,185");
		socio2.setFechaAlta("15-05-2021");
		miclub.getSocio().add(socio2);
		
		Socio socio3=new Socio();
		socio3.setIdSocio(3);
		socio3.setNombreSocio("Azucena");
		socio3.setDireccion("Argamasilla,57");
		socio3.setFechaAlta("28-07-2019");
		miclub.getSocio().add(socio3);

		/***
		 * Agrupar xml marshaller es crear un xml a partir de unos datos
		 * 1. crear el contexto 
		 * 2. crear a partir de ese contexto el xml	
		 */
		JAXBContext miContexto=JAXBContext.newInstance(Club.class);
		/* creamos el agrupamiento */
		Marshaller miLectura=miContexto.createMarshaller();
		/* indicamos el formato como se genera el agrupamiento, con JAXB.FORMATTED_OUTPUT nos guarda el archivo con escructura ordenada XML*/
		miLectura.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		/** mostramos por pantalla*/
		miLectura.marshal(miclub, System.out);	
		
		/** crear un archivo a partir de los objetos creados*/
		
		miLectura.marshal(miclub, new File("C:\\Users\\irime\\Desktop\\miClub.xml"));
		
		
		
	}
	
	
	
	

}
