package ClientSide;

import javax.swing.ImageIcon;

public class Icon extends ImageIcon
{
	private int sn; //represent the serial number of a picture
	private ImageIcon pic; //represents the picture itself
	
	public Icon(int sn , ImageIcon pic)
	{
		this.sn = sn;
		this.pic = pic;
	}
	
	public void setSerial(int serial)
	{
		sn = serial;
	}
	public int getSerial()
	{
		return sn;
	}
	public void setPic(ImageIcon picture)
	{
		pic = picture;
	}
	public ImageIcon getPic()
	{
		return pic;
	}
}
