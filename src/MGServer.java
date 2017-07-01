import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MGServer 
{
	private static BufferedReader input1;
	private static Socket s1;
	private static PrintWriter output1;
	private static BufferedReader input2;
	private static PrintWriter output2;
	private static Socket s2;

	public static void main(String[] args) 
	{
		int numberOfGames = 0;
		ServerSocket server = null;
		s1 = null;
		s2 = null;
		boolean listening = true;
		int port = 7777;
		try 
		{
			input1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			output1 = new PrintWriter(s1.getOutputStream(),true);
			input2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
			output2 = new PrintWriter(s2.getOutputStream(),true);
		} catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try 
		{
			server  = new ServerSocket(port);
			System.out.println("server is ready");
			while(listening)
			{
				System.out.println("waiting for first player");
				s1 = server.accept(); //getting connection for first player
				output1.print(1); //let the first connected player know that he is first
				System.out.println("waiting for second player");
				s2 = server.accept(); //getting connection for second player
				output2.print(2); //let the second connected player know that he is second
				MGThread game = new MGThread(s1, s2);
				game.start();
				numberOfGames++;
				System.out.println("Started Game: " + numberOfGames); //printing in terminal the game number that just started
			}
		} catch (IOException e) 
		{
			System.out.println("unable to create server");
			e.printStackTrace();
		}
		
		

	}

}
