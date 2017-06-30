import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MGServer 
{
	public static void main(String[] args) 
	{
		int numberOfGames = 0;
		ServerSocket server = null;
		Socket s1 = null; //a socket for the first player
		Socket s2 = null; //a socket for the second player
		boolean listening = true;
		int port = 7777;
		
		try 
		{
			server  = new ServerSocket(port);
			System.out.println("server is ready");
			while(listening)
			{
				System.out.println("waiting for first player");
				s1 = server.accept(); //getting connection for first player
				System.out.println("waiting for second player");
				s2 = server.accept(); //getting connection for second player
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
