package com.multiplik.image.util;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*Package created to find the x,y coordinates in the labels*/
public class Main extends JFrame implements MouseListener {
	
	public static void main (String[] args) throws IOException
	{
		
		
		Main frame = new Main();
		frame.setSize(2000, 1000);
		frame.createGUI();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	}
	
	public void createGUI() throws IOException
	{
		
		this.add(new JPanel() 
		{
			
			@Override
			public void paintComponent(Graphics g)
			{
				
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("./etiquet.png")), 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.print("("+e.getX()+","+e.getY()+")");
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
