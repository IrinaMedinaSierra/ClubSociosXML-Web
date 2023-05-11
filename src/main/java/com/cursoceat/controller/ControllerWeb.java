package com.cursoceat.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.channels.NonReadableChannelException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursoceat.xml.schema.Club;
import com.cursoceat.xml.schema.Club.Socio;

/**
 * Servlet implementation class ControllerWeb
 */
@WebServlet("/ControllerWeb")
public class ControllerWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Club miclub=new Club();
	List <Club> miSociosAlta=null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String nombre=request.getParameter("nombreSocio");
		String direccion=request.getParameter("direccionSocio");
		String alta=request.getParameter("altaSocio");
		
		Socio socio=new Socio();

		socio.setNombreSocio(nombre);
		socio.setDireccion(direccion);
		socio.setFechaAlta(alta);
		miclub.getSocio().add(socio);
		
		System.out.print(socio.toString());
		
		
		// para que se recargue la pagina incluyendo un nuevo registro
		
		
		response.sendRedirect("index.jsp");
		
	}catch (Exception e) {
		request.setAttribute("msn","Algo va mal");	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
