package ru.dtln.altair;

import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class AlProtocol
{
	private String remedyLoginID; 
	
	AlProtocol()
	{

	}
	
	public String clientMessage(InputStream inStream)
	{
		//получаем параметры входящего сообщения
		Map<String, String> data = this.parseMessage(inStream);
		RemedyProcessing remProc  = new  RemedyProcessing();
		
		if(remedyLoginID.isEmpty())
		{
			this.remedyLoginID = remProc.checkAuth(data.get(1),data.get(2));
			if(remedyLoginID.isEmpty())
			{
				return "Authentication fail! Login or password incorrect!";
			}
		}
			
		return "Successfully";	
	}
	
	
	//Парсим входящее сообщение получая из него map  т.к. с ним удобнее работать
	private Map<String, String> parseMessage(InputStream inStream)
	{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		
		Map<String, String> mapData = new HashMap<String, String>();  
		
		try{
			 
			//Создаём фабрику
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//Создаём документ
			Document doc = builder.parse(inStream);
			//Получаем первый элемент авторизации
			
			//Получаем элементы аутентификации
			Element element = doc.getDocumentElement();
			NodeList dataNodes = element.getChildNodes();
			
			for(int i = 0, N = dataNodes.getLength(); i < N; i++)
				{
					mapData.put(dataNodes.item(i).getNodeName(), dataNodes.item(i).getNodeValue());
				}
			
			return mapData;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return mapData;
	}
	
}