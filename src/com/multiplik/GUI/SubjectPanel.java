package com.multiplik.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubjectPanel extends JPanel{
	
	private BufferedImage imageLabel;
	private int numMaterias;
	private double scale;
	private boolean isFirstTime;
	private List<JTextField> subjectList;
	SubjectPanel(int numMaterias, double scale)
	{
		super();
		this.numMaterias = numMaterias;
		this.scale = scale;
		this.isFirstTime = true;
		this.setLayout(null);
		subjectList = new ArrayList<JTextField>();
		try {
			imageLabel = ImageIO.read(this.getClass().getResource("/etiquet.png"));
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
			if(isFirstTime)
			{
			JTextField textField = new JTextField();
			subjectList.add(textField);
			this.add(textField);
			System.out.println("[INFO] added textfield to subjectPanel in position("+x+","+y+")");
			textField.setBounds((int)(x+439*scale)-100, (int) (y+505*scale)-20, 250, 20);
			textField.setFont(new Font("Arial",Font.BOLD,(int) (36*scale)));
			}
			
			g.drawImage(imageLabel, x, y,(int)imageWidth,(int) imageHeight, null);
		
			
			if ((i%2) > 0)
			{
				y +=imageHeight+(scale * 100); 
				x = (int) (scale * 100);
			}else
			x += imageWidth+(scale * 100); 
					
		}
		isFirstTime = false;
		
		
	}
	
	public String[] getSubjectsList()
	{
		String subjectStringList[] = new String[subjectList.size()];
		for (int i = 0; i < subjectList.size(); i++)
		{
			subjectStringList[i] = subjectList.get(i).getText();
		}
		return subjectStringList;
	}
}
