package ClientSide;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FlipButton extends JButton implements ActionListener
{
	/*******************************************************************************************************************************
	 * Instance Variables
	 *******************************************************************************************************************************/
	//represents the position of the button on the buttons array on the board
	private int posRow; 
	private int posCol;
	private int picNumber; //represents the picture number
	private Icon image;
	private boolean flipped;
	
	/********************************************************************************************************************************
	 * Constructors
	 *******************************************************************************************************************************/
	//constructor with default values
	public FlipButton()
	{
		posRow = 0;
		posCol = 0;
		picNumber = 0;
		image = null;
		setFlipped(false);
		this.addActionListener(this);
	}
	//constructor with the positions and the representative pic number
	public FlipButton(int row , int col , int pic)
	{
		posRow = row;
		posCol = col;
		picNumber = pic;
		setFlipped(false);
		this.addActionListener(this);
	}
	
	

	/*******************************************************************************************************************************
	 * Getters and Setters
	 *******************************************************************************************************************************/
	public int getPosRow() 
	{
		return posRow;
	}
	public void setPosRow(int posRow) 
	{
		this.posRow = posRow;
	}
	public int getPosCol() 
	{
		return posCol;
	}
	public void setPosCol(int posCol) 
	{
		this.posCol = posCol;
	}
	public int getPicNumber() 
	{
		return picNumber;
	}
	public void setPicNumber(int picNumber) 
	{
		this.picNumber = picNumber;
	}
	public ImageIcon getImage() 
	{
		return image;
	}
	public void setImage(Icon image) 
	{
		this.image = image;
	}
	public boolean isFlipped() 
	{
		return flipped;
	}
	public void setFlipped(boolean flipped) 
	{
		this.flipped = flipped;
	}
	
	/****************************************************************************************************************************
	 *Methods
	 ****************************************************************************************************************************/
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("pressed button: " +this.posRow + "," + this.posCol);
		
	}
	
	
	
}
