package com.multiplik.etiquetas;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Etiquetador {
	
	
	public static void main (String args[]) throws ParserConfigurationException, TransformerException
	{

		Etiquetador et = new Etiquetador();
		et.llenarDatos();
		
		
	}
	
	public void llenarDatos() throws ParserConfigurationException, TransformerException
	{
		File file = new File("data.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.newDocument();
		
		Element root = doc.createElement("root");
		doc.appendChild(root);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("./test.xml"));
		transformer.transform(source, result);
		
		System.out.println("File saved!");
		
	}
	
	public void obtenerDatos()
	{
		
	}

}
