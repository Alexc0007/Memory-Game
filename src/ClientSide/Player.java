package ClientSide;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;

public class Player 
{
	private int serial; //will represent the serial number of the player , if its player1 of player 2
	private final int MAX_NUMBER_OF_PICS = 32;
	private BufferedReader input;
	private PrintWriter output;
	private boolean playing;
	private String host;
	private int port;
	private Socket socket;
	
	
	public Icon[] pictures = new Icon[MAX_NUMBER_OF_PICS];
	
	
	/*
	 * method to set all the pictures from the Resource folder into an array
	 */
	public Icon[] setPicIndexes()
	{
		Icon[] pics = new Icon[32];
		int index = 0;
		File dir = new File("/Resources");
		File[]directoryListing = dir.listFiles();
		if(directoryListing != null) //verify its a directory
		{
			for(File pic : directoryListing) //for each pic - place it in the array
			{
				pics[index] = new Icon(index+1, new ImageIcon(pic.getName()));
			}
		}
		return pics;
	}
	
	/*
	 * Connect to server method - method creates a socket and streams to talk to the server
	 */
	public void connectToServer()
	{
		try 
		{
			socket = new Socket(host, port); //create the socket
			input = new BufferedReader(new InputStreamReader(socket.getInputStream())); //create the input stream
			output = new PrintWriter(socket.getOutputStream() , true); //create the output stream
			System.out.println("connected to server "+ host + ":" + port); //announce on console that connected to server
			serial = input.read(); //will set the serial , depending on the connection order to the server
		} catch (IOException e) 
		{
			System.out.println("unable to connect to server - check port/address");
			e.printStackTrace();
		}
	}
	
	
	
	public void setHost(String address)
	{
		host = address;
	}
	public String getHost()
	{
		return host;
	}
	public void setPort(int port)
	{
		this.port = port;
	}

	public int getSerial() 
	{
		return serial;
	}
	public void setSerial(int serial) 
	{
		this.serial = serial;
	}
}
