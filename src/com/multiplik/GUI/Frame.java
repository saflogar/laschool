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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	
	private JPanel panelDeDatos;
	
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
	
	private HashMap<Integer,String> listMap;
	
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
	

	
	private void createGUI()
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
		
		try {
			con = new MultiplikConnector();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.print("[INFO] Number of tables:" + con.getNumberOfTables());
		/*=================================================================================================*/
		// Logica para rellenar lista de listas escolares.
		/*=================================================================================================*/
		//String[] l = (String[]) con.getListOfList().toArray(new String[con.getLists().size()]);
		listMap = new HashMap<Integer,String>();
		con.getListOfList(listMap);
		listModel = new DefaultListModel<String>();
		
		for (String element: listMap.values())
		{
			listModel.addElement(element);
			System.out.println("[INFO] added "+element+" to the listModel" );
			
		}
	/*	for (int i =0; i < l.length; i++)
		{
			listModel.addElement(l[i]);
		}
		*/
		list = new JList<String>(listModel);
	    /*==============================================================================================*/
		
		scrollerList = new JScrollPane(list);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.gridheight = 2;
		gc.ipadx = 80;
		gc.fill = GridBagConstraints.BOTH;
		contenedor.add(scrollerList,gc);
		
	/*	labelName = new JLabel("Alumno:");
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
		contenedor.add(yearField,gc);*/
		
		panelDeDatos = new PanelDeDatos();
		gc.gridx = 2;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 0;
		gc.fill = GridBagConstraints.BOTH;
		contenedor.add(panelDeDatos,gc);
		
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
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 5;
		gc.fill = GridBagConstraints.NONE;
		contenedor.add(addButton,gc);
		addButton.addActionListener(this);
		
		removeButton = new JButton("Eliminar");
		gc.gridx = 1;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight =1;
		gc.ipady = 5;
		gc.fill = GridBagConstraints.NONE;
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
	
	public void refreshListList()
	{
		listModel.removeAllElements();
		con.getListOfList(listMap);
		for (String element: listMap.values())
		{
			listModel.addElement(element);
		}
	}
	
	private int searchID(String value)
	{
		int id = 0;
		for (Entry<Integer, String> entry : listMap.entrySet())
		{
			System.out.println("[INFO] is :"+value+"equal to :"+entry);
			if(value.equals(entry.getValue()))
			{
				id = entry.getKey();
				System.out.print("[INFO] id to delete ="+id);
				//con.deleteList(id);
				//refreshListList();
				break;
				
			}
			
		}
		return id;
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
				editor.setSubjects(con.getSubjectList(searchID(list.getSelectedValue())));
				ImageIO.write((RenderedImage) editor.getLabelSheet(), "png", new File("./test.png"));
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (pressedButton == removeButton)
		{
			String selectedValue = list.getSelectedValue();
			
			con.deleteList(searchID(selectedValue));
			refreshListList();
			/*int idToDelete;
			for (Entry<Integer, String> entry : listMap.entrySet())
			{
				System.out.println("[INFO] is :"+selectedValue+"equal to :"+entry);
				if(selectedValue.equals(entry.getValue()))
				{
					idToDelete = entry.getKey();
					System.out.print("[INFO] id to delete ="+idToDelete);
					con.deleteList(idToDelete);
					refreshListList();
					break;
					
				}
				
			}*/
			
			
			
		}
	}
	
	class PanelDeDatos extends JPanel
	{
		public PanelDeDatos() {
			super();
			GridBagConstraints gc = new GridBagConstraints();
			this.setLayout(new GridBagLayout());
			
			labelName = new JLabel("Alumno:");
			gc.gridx = 0;
			gc.gridy = 0;
			gc.gridwidth = 1;
			gc.gridheight =1;
			gc.ipady = 30;
			gc.ipadx = 0;
			gc.fill = GridBagConstraints.BOTH;
			this.add(labelName,gc);
			
			nameField = new JTextField();
			gc.gridx = 1;
			gc.gridy = 0;
			gc.gridwidth = 4;
			gc.gridheight =1;
			gc.ipady = 0;
			gc.ipadx = 0;
			gc.fill = GridBagConstraints.HORIZONTAL;
			this.add(nameField,gc);
			
			labelGrade = new JLabel("Grado:");
			gc.gridx = 0;
			gc.gridy = 1;
			gc.gridwidth = 1;
			gc.gridheight =1;
			gc.ipady = 30;
			gc.ipadx = 0;
			gc.anchor = GridBagConstraints.EAST;
			gc.fill = GridBagConstraints.NONE;
			this.add(labelGrade,gc);
			
			gradeField = new JTextField();
			gc.gridx = 1;
			gc.gridy = 1;
			gc.gridwidth = 1;
			gc.gridheight =1;
			gc.ipady = 0;
			gc.ipadx = 20;
			gc.fill = GridBagConstraints.HORIZONTAL;
			this.add(gradeField,gc);
			
			labelSection = new JLabel ("Sección:");
			gc.gridx = 2;
			gc.gridy = 1;
			gc.gridwidth = 1;
			gc.gridheight =1;
			gc.ipady = 0;
			gc.anchor = GridBagConstraints.EAST;
			gc.fill = GridBagConstraints.NONE;
			this.add(labelSection,gc);
			
			sectionField = new JTextField();
			gc.gridx = 3;
			gc.gridy = 1;
			gc.gridwidth = 1;
			gc.gridheight =1;
			gc.ipady = 0;
			gc.fill = GridBagConstraints.HORIZONTAL;
			this.add(sectionField,gc);
			
			labelYear = new JLabel ("Año:");
			gc.gridx = 4;
			gc.gridy = 1;
			gc.gridwidth = 1;
			gc.gridheight =1;
			gc.ipady = 0;
			gc.ipadx = 0;
			gc.anchor = GridBagConstraints.EAST;
			gc.fill = GridBagConstraints.NONE;
			this.add(labelYear,gc);
			
			yearField = new JTextField();
			gc.gridx = 5;
			gc.gridy = 1;
			gc.gridwidth = 1;
			gc.gridheight =1;
			gc.ipady = 0;
			gc.ipadx = 80;
			gc.fill = GridBagConstraints.HORIZONTAL;
			this.add(yearField,gc);
		}
		
		
		
	}

}
