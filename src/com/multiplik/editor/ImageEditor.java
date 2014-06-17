package com.multiplik.editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;


public class ImageEditor {
	
	private String name;
	private String school;
	private String grade;
	private String year;
	private Image labelImg;
	private BufferedImage sheetImg;
	private int numOfLabels;
	private List <Image> labelList;
	private Graphics gSheet;
	private Graphics gLabel;
	
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
		gLabel.drawString(name, 50, 300);
	}
	
	public void setGrade(String grade)
	{
		gLabel.drawString(grade, 20, 20);
		
	}
	
	public void setSchool(String school)
	{
		gLabel.drawString(school, 20, 20);
	}
	
	public void setYear(String year)
	{
		gLabel.drawString(year, 20, 20);
	}
	
	public void setSubjects(List<String> subjecList)
	{
			
	}
	
	private void drawLetterSheet()
	{
		sheetImg = new BufferedImage(3400,4400,BufferedImage.TYPE_INT_ARGB);
		gSheet = sheetImg.getGraphics();
		gSheet.setColor(Color.WHITE);
		gSheet.drawRect(0, 0, 1700, 2200);
		int x=0,y=0;
		for (int i=0 ; i < 8; i++)
		{
			x=0;
			for (int j=0; j< 2; j++)
			{
				gSheet.drawImage(labelImg,(int)x,(int)y,null);
				System.out.println("imagen"+i+"dibujada en coordenadas"+x+","+y);
				x+=labelImg.getWidth(null)+100;
			
				
			}
			y+=labelImg.getHeight(null)+100;
			
		}
		
	}
	
	public Image getLabelSheet()
	{
		drawLetterSheet();
		return sheetImg;
		
	}
	

}
