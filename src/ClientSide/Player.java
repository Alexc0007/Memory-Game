package ClientSide;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;

public class Player 
{
	private final int MAX_NUMBER_OF_PICS = 32;
	private BufferedReader input;
	private PrintWriter output;
	private boolean playing;
	private String host;
	private String port;
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
	
	public void setHost(String address)
	{
		host = address;
	}
	public String getHost()
	{
		return host;
	}
}
