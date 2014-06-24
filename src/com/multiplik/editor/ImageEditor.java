package com.multiplik.editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;


public class ImageEditor {
	

	private Image labelImg;
	private BufferedImage sheetImg;
	private int numOfLabels;
	private List <Image> labelList;
	private Graphics gSheet;
	private Graphics gLabel;
	private List<String> subjectList;
	
	public ImageEditor(BufferedImage labelImg, int numOfLabels)	
	{
		this.labelImg = labelImg;
		this.numOfLabels = numOfLabels;	
		this.gLabel = labelImg.getGraphics();
		gLabel.setColor(Color.BLACK);
		gLabel.setFont(new Font("courier",Font.BOLD,36));
	}
	
	public void setName (String name)
	{
		gLabel.drawString(name, 230, 298);
	}
	
	public void setGrade(String grade)
	{
		gLabel.drawString(grade, 211, 407);
		
	}
	
	public void setSection(String section)
	{
		gLabel.drawString(section, 536, 408);
	}
	
	public void setYear(String year)
	{
		gLabel.drawString(year, 845, 413);
		
	}
	
	public void setSubjects(List<String> subjectList)
	{
		this.subjectList = subjectList;
			
	}
	
	private void drawSubject (String subjectName)
	{
		gLabel.drawString(subjectName, 400, 489);
		
	}
	
	private void clearSubject()
	{
		gLabel.setColor(Color.WHITE);
		gLabel.fillRect(32, 448, 983, 50);
		gLabel.setColor(Color.BLACK);
	}
	
	private void drawLetterSheet()
	{
		sheetImg = new BufferedImage(3400,4400,BufferedImage.TYPE_INT_ARGB);
		gSheet = sheetImg.getGraphics();
		gSheet.setColor(Color.WHITE);
		gSheet.drawRect(0, 0, 1700, 2200);
		int x=0,y=0;
		for (int i=0 ; i < subjectList.size(); i++)
		{
			drawSubject(subjectList.get(i));
			gSheet.drawImage(labelImg,(int)x,(int)y,null);
			this.clearSubject();
			System.out.println("[INFO] imagen "+i+" dibujada en coordenadas:("+x+","+y+")");			
			if ((i%2) > 0)
			{
				y+=labelImg.getHeight(null)+100; 
				x = 0;
			}else
			x+=labelImg.getWidth(null)+100; 
		}
		
	}
	
	public Image getLabelSheet()
	{
		drawLetterSheet();
		return sheetImg;
	}
	

}
