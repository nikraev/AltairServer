package ru.dtln.altair;

import java.net.*;
//import java.io.File;
//import java.io.IOException;
import java.io.*;
import java.util.*;

public class AlServer
{
	public static int port = 36000;
	public static InetAddress ipAddr;
	public static int backlog = 10;
			
	public AlServer()
	{
		byte [] ipbyte = new byte []{127,0,0,1};
		
		try 
		{
			ipAddr = InetAddress.getByAddress(ipbyte);
		}catch(UnknownHostException e)
		{
			e.getMessage();
		}
	}

/* Пока исключено из разработки
	public void checkConf()
	{
		File conffile = new File("altair.conf");
		if( conffile.exists())
		{
			
		}
	}
*/
	public static void main(String args[])
	{
		
		try{
			
		//создаём класас отвечающий за протокол
		AlProtocol dataProcessing = new AlProtocol();
		//создаём серверный сокет
		ServerSocket sSocket = new ServerSocket(port,backlog,ipAddr);
		
		//Ловим клиентский сокет
		Socket cSocket = sSocket.accept();
		
		//включаем keep-alive соединения
		try{
					cSocket.setKeepAlive(true);
		}catch(SocketException e){
			System.out.printf(e.getMessage());
		}
			
		//Получаем входной и выходной потоки сокета
		
		InputStream inSteram = cSocket.getInputStream();
		OutputStream outStraem = cSocket.getOutputStream();
		
		//отправляем сообщение на обработку
		//dataProcessing.clientMessage(inSteram);	
		
		//System.out.println(dataProcessing.clientMessage(inSteram));
		//sSocket.close();
		}catch(IOException e)
		{
			e.getMessage();
		}
	}
}