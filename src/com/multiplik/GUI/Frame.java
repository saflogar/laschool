package com.multiplik.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListModel;

import com.multiplik.connector.MultiplikConnector;
import com.multiplik.editor.ImageEditor;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	private JLabel labelTittle;
	private JLabel labelName;
	private JLabel labelGrade;
	private JLabel labelYear;
	private JLabel labelSection;
	private JLabel labelSubject;
	
	private	JTextField tittleField;
	private	JTextField nameField;
	private JTextField gradeField;
	private JTextField yearField;
	private JTextField sectionField;
	private JTextField subjectField;
	
	private MultiplikConnector con ;
	private JList<String> list;
	private JScrollPane scrollerList;
	private DefaultListModel<String> listModel;
	
	private JButton submittButton;
	private JButton addButton;
	private JButton removeButton;
	
	public Frame()
	{
		super();
		this.setTitle("Temporada Escolar 2014");
		this.setVisible(true);
		createGUI();
		this.setSize(800, 500);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	

	
	public void createGUI()
	{
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		/*
		labelTittle = new JLabel("Temporada Escolar 2014");
		labelTittle.setFont(new Font(null, Font.BOLD, 20));
		gc.gridx = 4;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 50;
		gc.fill = GridBagConstraints.NONE;
		contenedor.add(labelTittle,gc);*/
		
		con = new MultiplikConnector();
		//System.out.print("[INFO] Number of tables:" + con.getNumberOfTables());
		
		String[] l = (String[]) con.getLists().toArray(new String[con.getLists().size()]);
		listModel = new DefaultListModel<String>();
		for (int i =0; i < l.length; i++)
		{
			listModel.addElement(l[i]);
		}
		
		list = new JList<String>(listModel);
	
		scrollerList = new JScrollPane(list);
	//	list.setModel(listModel);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 6;
		gc.ipadx = 80;
		gc.fill = GridBagConstraints.BOTH;
		contenedor.add(scrollerList,gc);
		
		labelName = new JLabel("Alumno:");
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 30;
		gc.ipadx = 0;
		gc.fill = GridBagConstraints.BOTH;
		contenedor.add(labelName,gc);
		
		nameField = new JTextField();
		gc.gridx = 2;
		gc.gridy = 1;
		gc.gridwidth = 5;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.ipadx = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		contenedor.add(nameField,gc);
		
		labelGrade = new JLabel("Grado:");
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 30;
		gc.ipadx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.fill = GridBagConstraints.NONE;
		
		contenedor.add(labelGrade,gc);
		
		gradeField = new JTextField();
		gc.gridx = 2;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.ipadx = 20;
		gc.fill = GridBagConstraints.HORIZONTAL;
		contenedor.add(gradeField,gc);
		
		labelSection = new JLabel ("Sección");
		gc.gridx = 3;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.fill = GridBagConstraints.NONE;
		contenedor.add(labelSection,gc);
		
		sectionField = new JTextField();
		gc.gridx = 4;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		contenedor.add(sectionField,gc);
		
		labelYear = new JLabel ("Año:");
		gc.gridx = 5;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.ipadx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.fill = GridBagConstraints.NONE;
		contenedor.add(labelYear,gc);
		
		yearField = new JTextField();
		gc.gridx = 6;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.ipadx = 80;
		gc.fill = GridBagConstraints.HORIZONTAL;
		contenedor.add(yearField,gc);
		
		submittButton = new JButton("Crear");
		gc.gridx = 5;
		gc.gridy = 6;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.fill = GridBagConstraints.BOTH;
		contenedor.add(submittButton,gc);
		submittButton.addActionListener(this);
		
		addButton = new JButton("Agregar");
		gc.gridx = 0;
		gc.gridy = 7;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.fill = GridBagConstraints.BOTH;
		contenedor.add(addButton,gc);
		addButton.addActionListener(this);
		
		removeButton = new JButton("Eliminar");
		gc.gridx = 0;
		gc.gridy = 8;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.fill = GridBagConstraints.BOTH;
		contenedor.add(removeButton,gc);
		removeButton.addActionListener(this);
		
	}
	
	private String getFieldName()
	{
		
		return nameField.getText();
		
	}
	
	private String getSection()
	{
		return sectionField.getText();
	}
	
	private String getGrade()
	{
		return gradeField.getText();
	}
	
	private String getYear()
	{
		return yearField.getText();
	}
	
	private String getSubject()
	{
		return subjectField.getText();
	}
	
	public void refreshSubjectList()
	{
		listModel.removeAllElements();
		String[] l = (String[]) con.getLists().toArray(new String[con.getLists().size()]);
		
		for (int i = 0;i < l.length; i++ )
		{
			listModel.addElement(l[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object objeto = e.getSource();
		JButton pressedButton = (JButton)objeto;
		
		if (pressedButton == addButton)
		{
			NewListFrame f = new NewListFrame(this);
			
		}else if(pressedButton == submittButton)
		{
			try {
			//	List <String> list = new ArrayList<String>();
				ImageEditor editor = new ImageEditor(ImageIO.read(new File("./etiquet.png")),1);
				
				editor.setName(nameField.getText());
				editor.setGrade(this.getGrade());
				editor.setSection(this.getSection());
				editor.setYear(this.getYear());
				editor.setSubjects(con.getSubjectList(list.getSelectedValue()));
				ImageIO.write((RenderedImage) editor.getLabelSheet(), "png", new File("./test.png"));
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (pressedButton == removeButton)
		{
			con.deleteList(list.getSelectedValue());
			refreshSubjectList();
			
		}
	}

}
