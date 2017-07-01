package ClientSide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Component;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainProg 
{

	private JFrame frame;
	private JPanel jpBottomPanel;
	private JTextArea taScreen;
	private JPanel jpMainPanel;
	private FlipButton[][] buttons;
	private JButton btnConnectToServer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainProg window = new MainProg();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainProg() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		Player player = new Player(); //create a player instance
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jpBottomPanel = new JPanel();
		frame.getContentPane().add(jpBottomPanel, BorderLayout.SOUTH);
		jpBottomPanel.setLayout(new BorderLayout(0, 0));
		
		btnConnectToServer = new JButton("Connect to Server"); //button to insert server address + port
		btnConnectToServer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				player.setHost(JOptionPane.showInputDialog("Please insert sever address to connect to"));
				try
				{
					player.setPort(Integer.parseInt(JOptionPane.showInputDialog("please insert the port of the server to connect to")));
				}catch (NullPointerException exception) 
				{
					//null pointer exception could be thrown when no port is inserted and the parseInt method would try to parse a NULL value
					player.setPort(0); //in such case just set a default value of 0 to the port 
				}
				player.connectToServer(); //try to connect to sever
				
			}
		});
		jpBottomPanel.add(btnConnectToServer, BorderLayout.WEST);
		
		taScreen = new JTextArea();
		taScreen.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		taScreen.setText("hello");
		jpBottomPanel.add(taScreen, BorderLayout.CENTER);
		
		jpMainPanel = new JPanel();
		frame.getContentPane().add(jpMainPanel, BorderLayout.CENTER);
		jpMainPanel.setLayout(new GridLayout(4, 4, 4, 4));
		createButtons(4, 4);
	}
	
	public void createButtons(int rows , int cols)
	{
		buttons = new FlipButton[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				buttons[i][j] = new FlipButton(i , j , 0);
				jpMainPanel.add(buttons[i][j]);
			}
		}
	}

}
