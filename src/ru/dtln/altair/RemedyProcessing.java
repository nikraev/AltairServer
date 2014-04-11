package ru.dtln.altair;

import java.util.*;

public class RemedyProcessing {

	RemedyProcessing()
	{
		
	}
	
	//метод отвечающий за подключение к Remedy
	private boolean ConnectRemedy()
	{
		return false;
	}
	
	//Метод отвечающий за закрытие соединения с Ремеди
	private boolean CloseConRemedy()
	{
		return false;
	}
	
	//метод проверки авторизации возвращает Remedy_Login_ID
	public String checkAuth (String login, String password)
	{
			return "nkraev";
	}
	
	//метод изменения инцидента
	public boolean setIncident(String IncidentNumber,String AssignedGroup,String Assigned, int Priority, int Status)
	{
		return false;
	}
	
	//метод получения информации о инцидентах пользователя
	public void getIncidentOnUser(String userName)
	{
		  
	}
	
	//метод получения информации о инцидентах группы к которой относиться пользователь
	public void getIncidentonGroup(String groupName)
	{
		
	}
}
