package com.multiplik.GUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class DragField extends JTextField
{
	int draggedAtX;
	int draggedAtY;
	DragField()
	{
		super();
		setDoubleBuffered(false);
        setMargin(new Insets(0, 0, 0, 0));
        setSize(25, 25);
        setPreferredSize(new Dimension(25, 25));
		  addMouseListener(new MouseAdapter(){
	            public void mousePressed(MouseEvent e){
	                draggedAtX = e.getX();
	                draggedAtY = e.getY();
	            }
	        });

	        addMouseMotionListener(new MouseMotionAdapter(){
	            public void mouseDragged(MouseEvent e){
	                setLocation(e.getX() - draggedAtX + getLocation().x,
	                        e.getY() - draggedAtY + getLocation().y);
	            }
	        });
	}
	
	  public static void main(String[] args){
	        JFrame frame = new JFrame("DragButton");
	        frame.setLayout(null);
	        frame.getContentPane().add(new DragField());
	     
	        frame.setSize(300, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
	

}
