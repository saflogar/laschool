package com.multiplik.editor;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
	
	public static void main (String args[]) throws IOException
	{
		BufferedImage img = ImageIO.read(new File("./etiquet.png"));
		ImageEditor imgEditor = new ImageEditor((BufferedImage) img,6);
		imgEditor.setName("Sergio Alberto Flores Garzá");
		imgEditor.setGrade("5°");
		imgEditor.setSection("B");
		imgEditor.setYear("2013-2014");
		ImageIO.write((RenderedImage) imgEditor.getLabelSheet(), "png", new File("./anexa2.png"));
		
	}

}
