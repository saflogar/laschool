package com.multiplik.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.multiplik.editor.ImageEditor;

public class Frame extends JFrame implements ActionListener {
	JLabel labelTittle;
	JLabel labelName;
	JLabel labelGrade;
	JLabel labelYear;
	JLabel labelSection;
	JLabel labelSubject;
	JTextField tittleField;
	JTextField nameField;
	JTextField gradeField;
	JTextField yearField;
	JTextField sectionField;
	JTextField subjectField;
	
	JButton submittButton;
	
	public Frame()
	{
		super();
		this.setTitle("Temporada Escolar 2014");
	
		this.setVisible(true);
		createGUI();
		this.setSize(800, 500);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	
	public void createGUI()
	{
		labelSubject = new JLabel("Materia");
		

		subjectField = new JTextField(30);
		
		submittButton = new JButton();
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new GridBagLayout());
		
		submittButton.addActionListener(this);
		
		GridBagConstraints gc = new GridBagConstraints();
		
		labelTittle = new JLabel("Temporada Escolar 2014");
		gc.gridx = 2;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.gridheight =1;
		contenedor.add(labelTittle,gc);
		
		labelName = new JLabel("Alumno:");
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight =1;;
		contenedor.add(labelName,gc);
		
		nameField = new JTextField(40);
		gc.gridx = 2;
		gc.gridy = 1;
		gc.gridwidth = 5;
		gc.gridheight =1;
		contenedor.add(nameField,gc);
		

		labelGrade = new JLabel("Año:");
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		contenedor.add(labelGrade,gc);
		
		gradeField = new JTextField(4);
		gc.gridx = 2;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		contenedor.add(gradeField,gc);
		
		labelSection = new JLabel ("Sección");
		gc.gridx = 3;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		contenedor.add(labelSection,gc);
		
		sectionField = new JTextField(4);
		gc.gridx = 4;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		contenedor.add(sectionField,gc);
		
		labelYear = new JLabel ("Año Escolar");
		gc.gridx = 5;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		contenedor.add(labelYear,gc);
		
		yearField = new JTextField(15);
		gc.gridx = 6;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		contenedor.add(yearField,gc);
		
		gc.gridx = 3;
		gc.gridy = 3;
		contenedor.add(submittButton,gc);
	}
	
	public String getName()
	{
		
		return nameField.getText();
		
	}
	
	public String getSection()
	{
		return sectionField.getText();
	}
	
	public String getGrade()
	{
		return gradeField.getText();
	}
	
	public String getYear()
	{
		return yearField.getText();
	}
	
	public String getSubject()
	{
		return subjectField.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			ImageEditor editor = new ImageEditor(ImageIO.read(new File("./etiquet.png")),1);
			editor.setName(this.getName());
			editor.setGrade(this.getGrade());
			editor.setSection(this.getSection());
			editor.setYear(this.getYear());
			ImageIO.write((RenderedImage) editor.getLabelSheet(), "png", new File("./test.png"));
			editor.getLabelSheet();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
	
	

}
