package com.multiplik.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SubjectPanel extends JPanel{
	
	private BufferedImage imageLabel;
	private int numMaterias;
	private double scale;
	SubjectPanel(int numMaterias, double scale)
	{
		super();
		this.numMaterias = numMaterias;
		this.scale = scale;
		try {
			imageLabel = ImageIO.read(new File("./etiquet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int x = (int) (scale * 100); 
		int y = (int) (scale * 100);
		double imageWidth = imageLabel.getWidth()*scale;
		double imageHeight = imageLabel.getHeight()*scale;
		for (int i = 0; i < numMaterias; i++)
		{
			g.drawImage(imageLabel, x, y,(int)imageWidth,(int) imageHeight, null);
			if ((i%2) > 0)
			{
				y +=imageHeight+(scale * 100); 
				x = (int) (scale * 100);
			}else
			x += imageWidth+(scale * 100); 
					
		}
		
		
	}
	

}
