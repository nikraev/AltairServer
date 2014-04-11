package ru.dtln.altair;

import java.net.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AlClient
{	
	private static int sPort = 36000; 
	private static byte [] addr = {127,0,0,1};
			
	public void main (String args[])	
	{
		
		try{
		Socket sSocket = new Socket(InetAddress.getByAddress(addr), sPort);
		System.out.println("Socket connection!");
		
		//получаем входящий и исходящий поток
		InputStream sInput = sSocket.getInputStream();
		OutputStream sOutput = sSocket.getOutputStream();
		
		//formMessage();
		//формирование xml
		
		this.createMessage();
		
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private String createMessage()
	{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document doc = docBuilder.newDocument();
		Element message = doc.createElement("message");
		doc.appendChild(message);
		
		Element authentication = doc.createElement("authentication");
		message.appendChild(authentication);
		
		Element password = doc.createElement("password");
		rootElement.appendChild(password);
		
		
		return "f";	
	}
}