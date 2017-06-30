import java.util.ArrayList;
import java.util.Collections;

public class Game
{
	private final int DEFAULT_SIZE = 4;
	private int [][] board; //the playing board
	private int currentPlayerPlaying = 1; //by defult the first player is starting
	private int boardSize; //if n is inserted, will create nxn board - must be an even number
	
	public Game(int size)
	{
		if(size%2 == 0 && size >0 && size <=8) //size can be 2,4,6,8 -> any other size will set the board to default size
		{
			boardSize = size; //set the board's size
		}
		else
			boardSize = DEFAULT_SIZE; //default size is 4x4
		board = new int[boardSize][boardSize];
		generateBoard();
	}
	
	
	
	
	
	private void generateBoard()
	{
		int index = 0;
		int numberOfPictures = boardSize*boardSize/2; //incidcates the number of different pictures in the game
		ArrayList<Integer> picIndexes = new ArrayList<>();
		for(int i=0;i<numberOfPictures*2;i++)
		{
			//will add the same picture index twice
			picIndexes.add(index);
			picIndexes.add(index);
			index++; //increment the index
		}
		index = 0; //return index to 0
		Collections.shuffle(picIndexes); //shuffle all of the picture indexes
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				board[i][j] = picIndexes.get(index);
				index++;
			}
		}
	}
	
	public int getBoardSize()
	{
		return boardSize;
	}
	public void setCurrentPlayerPlaying(int player)
	{
		currentPlayerPlaying = player;
	}
}
