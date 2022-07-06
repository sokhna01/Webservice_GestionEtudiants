package server;

import javax.xml.ws.Endpoint;

import service.GestionEtudiant;

public class Serveur {

	public static void main(String[] args) 
	{
		String nomWs = "GestionEtudiant";
		String url = "http://172.20.10.13:8788/";
		Endpoint.publish(url, new GestionEtudiant());
		System.out.printf("%s%s?wsdl", url, nomWs);
	}

}
