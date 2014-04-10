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
/*	
	private boolean state;

	AlProtocol()
	{
		state = false;
	}
*/	
	public Map<String, String> clientMessage(InputStream inStream)
	{
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		
		Map<String, String> mapData = new HashMap<String, String>();  
		
		try{
			//создаём класс отправки сообщений
			RemedyProcessing remProc = new RemedyProcessing(); 
			//Создаём фабрику
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//Создаём документ
			Document doc = builder.parse(inStream);
			//Получаем первый элемент авторизации
			
			//Получаем элементы аутентификации
			Element auth = doc.getDocumentElement();
			NodeList authnodes = auth.getChildNodes();
			
			if(authnodes.getLength() != 2)
			{
				System.out.println("To more auth parameter");
			}
			else
			{
				remProc.checkAuth(authnodes.item(0).getTextContent() , authnodes.item(1).getTextContent());
			}
			
			Element data = doc.getDocumentElement();
			NodeList datanodes = data.getChildNodes();
			
			for(int i = 0, N = datanodes.getLength(); i < N; i++)
				{
					mapData.put(datanodes.item(i).getNodeName(), datanodes.item(i).getNodeValue());
				}
			
			return mapData;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return mapData;
	}
}