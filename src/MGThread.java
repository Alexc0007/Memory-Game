import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.print.attribute.standard.MediaSize.Other;

public class MGThread extends Thread
{	
	private Socket socket1; //this is the socket of the first player
	private Socket socket2; //this socket for the second player
	private int playingPlayer;
	private Game game = null;
	private BufferedReader input1 = null; //buffer reader for first player
	private PrintWriter output1 = null; //printwriter for first player
	private BufferedReader input2 = null; //buffer reader for second player
	private PrintWriter output2 = null; //printwriter for second player
	
	public MGThread(Socket socket1 , Socket socket2)
	{
		this.socket1 = socket1;
		this.socket2 = socket2;
	}
	
	public void run()
	{
		try 
		{
			//assemble streams for player1
			input1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			output1 = new PrintWriter(socket1.getOutputStream(),true);
			//assemble streams for player2
			input2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
			output2 = new PrintWriter(socket2.getOutputStream(),true);
			int size = input1.read(); //get the size of the board from player1
			game = new Game(size); //create a new game of the given size
			
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
}
