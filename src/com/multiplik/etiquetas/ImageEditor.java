package com.multiplik.etiquetas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;




public class ImageEditor {
	BufferedImage img;
	Graphics g;
	
	ImageEditor(String imgPath) throws IOException
	{
		img = ImageIO.read(new File(imgPath));
		g =img.getGraphics();
		
	}
	
	

}
