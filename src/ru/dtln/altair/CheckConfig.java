package ru.dtln.altair;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

//import ru.dtln.servicedesk.mail.ConnectRemedyDb;

public class CheckConfig{

//initialize config parametr
	
	public static InetAddress ipAddr;
	public static int port;
	public static String configRoot;
	
//function get IP address
	
	public InetAddress getAddress()
	{
		byte [] ipbyte = new byte []{127,0,0,1};
		
		try 
		{
			ipAddr = InetAddress.getByAddress(ipbyte);
		}catch(UnknownHostException e)
		{
			e.getMessage();
		}
	
	return ipAddr;
	}
//function get port
	public int getPort(int p)
	{
		port = p;
		return port;
	}
/*	
	private void initConf()
	{
		Properties pconf = new Properties();
		InputStream instream = null;
		
		try{
    		String filename = "altair.conf";
    		instream = CheckConfig.class.getClassLoader().getResourceAsStream(filename);
    		    		 
    		// load a properties file
    		pconf.load(instream);
     
    		serverName = prop.getProperty("server");
    		portNumber = prop.getProperty("port");
    		databaseName = prop.getProperty("database");
    		userName = prop.getProperty("dbuser");
    		password = prop.getProperty("dbpassword");
    		
    		
    	}catch(IOException e)
    	{
    		e.getStackTrace();
    	}finally{
        	if(instream!=null)
        	{
        		try {
        			instream.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        }
	}
*/
}
