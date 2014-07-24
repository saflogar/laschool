package com.multiplik.editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
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
		gLabel.setFont(new Font("Arial",Font.BOLD,36));
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
		gLabel.drawString(section, 500, 408);
	}
	
	public void setYear(String year)
	{
		gLabel.drawString(year, 840, 413);
	}
	
	public void setSubjects(List<String> subjectList)
	{
		this.subjectList = subjectList;
	}
	
	private void drawSubject (String subjectName)
	{
		gLabel.drawString(subjectName, 20, 489);
		
	}
	
	private void clearSubject()
	{
		gLabel.setColor(Color.WHITE);
		gLabel.fillRect(32, 448, 983, 50);
		gLabel.setColor(Color.BLACK);
	}
	
	private void drawDotLine(int x1, int y1, int x2, int y2)
	{
		Graphics2D g2d	= (Graphics2D) gSheet;
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		g2d.setStroke(dashed);
		g2d.setColor(Color.BLACK);
		g2d.drawLine(x1, y1, x2, y2);
	}
	
	
	
	private void drawLetterSheet()
	{
		sheetImg = new BufferedImage(2550,3300,BufferedImage.TYPE_INT_ARGB);
		gSheet = sheetImg.getGraphics();
		gSheet.setColor(Color.WHITE);
		gSheet.drawRect(0, 0, 2550, 3300);
		int x=140,y=185;
		drawDotLine(x-(140/2), 0, x-(140/2), 3300);
		drawDotLine(x+labelImg.getWidth(null)+(140/2), 0, x+labelImg.getWidth(null)+(140/2), 3300);
		drawDotLine(x+(labelImg.getWidth(null)*2)+(140)+(140/2), 0, x+(labelImg.getWidth(null)*2)+(140)+(140/2), 3300);
		for (int i=0 ; i < subjectList.size(); i++)
		{
			drawSubject(subjectList.get(i));
			gSheet.drawImage(labelImg,(int)x,(int)y,null);
			this.clearSubject();
			System.out.println("[INFO] etiqueta "+i+" dibujada en coordenadas:("+x+","+y+")");			
			if ((i%2) > 0)
			{
				drawDotLine(0,y-(150/2) , 2550,y-(150/2));

				y+=labelImg.getHeight(null)+150; 
				x = 140;
			}else
			x+=labelImg.getWidth(null)+130; 
		}
		drawDotLine(0,y-(150/2) , 2550,y-(150/2));

		
	}
	
	public Image getLabelSheet()
	{
		drawLetterSheet();
		return sheetImg;
	}
	

}
