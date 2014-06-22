package com.multiplik.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.multiplik.connector.MultiplikConnector;

@SuppressWarnings("serial")
public class NewListFrame extends JDialog implements ActionListener
{
	private JTabbedPane pane ;
	private JLabel schoolLabel;
	private JLabel gradeLabel;
	private JLabel subjectLabel;
	private JLabel tittleLabel;
	private JComboBox <String>schoolNameField;
	private JSpinner subjectField;
	private JSpinner gradeField;
	private JButton cancelButton;
	private JButton nextButton;
	private JButton okButton;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel tittleLabel2;
	private ArrayList<String> subjectList;
	private List<JTextField> subjectFieldList;
	private Frame parentFrame;
	NewListFrame(JFrame parent)
	{
		super(parent,"");
		parentFrame = (Frame)parent;
		parent.setEnabled(false);
		pane = new JTabbedPane();
		createPanel1();
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void createPanel1()
	{
		
		
		panel1 = new JPanel();
		Container container = this.getContentPane();
	//	container.setLayout(new GridBagLayout());
		panel1.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		tittleLabel = new JLabel("Nueva Etiqueta");
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.gridheight = 1;
		gc.ipady = 30;
		gc.ipadx = 0;
		gc.fill = GridBagConstraints.NONE;
		panel1.add(tittleLabel,gc);
		
		schoolLabel = new JLabel("Escuela:");
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 30;
		gc.ipadx = 0;
		gc.fill = GridBagConstraints.NONE;
		panel1.add(schoolLabel,gc);
		
		schoolNameField = new JComboBox<String>(new String[]{"Anexa Matutino","Anexa Vespertino"});
		gc.gridx = 2;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 0;
		gc.ipadx = 40;
		gc.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(schoolNameField,gc);
		
		
		gradeLabel = new JLabel("Grado:");
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 30;
		gc.ipadx = 0;
		gc.fill = GridBagConstraints.NONE;
		panel1.add(gradeLabel, gc);
		
		
		gradeField = new JSpinner(new SpinnerNumberModel(1,1,50,1));
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 0;
		gc.ipadx = 40;
		gc.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(gradeField, gc);
		
		subjectLabel = new JLabel("Cant. de Materias");
		gc.gridx = 2;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 0;
		gc.ipadx = 40;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.EAST;
		panel1.add(subjectLabel, gc);
		
		subjectField = new JSpinner(new SpinnerNumberModel(1,1,50,1));
		gc.gridx = 3;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 0;
		gc.ipadx = 40;
		gc.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(subjectField, gc);
		
		cancelButton = new JButton("Cancelar");
		gc.gridx = 1;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 0;
		gc.ipadx = 40;
		gc.fill = GridBagConstraints.NONE;
		panel1.add(cancelButton,gc);
		cancelButton.addActionListener(this);
		
		nextButton = new JButton("=>");
		gc.gridx = 2;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 0;
		gc.ipadx = 40;
		gc.fill = GridBagConstraints.NONE;
		panel1.add(nextButton,gc);
		nextButton.addActionListener(this);
		
		pane.addTab("Datos1", panel1);
		container.add(pane);
		
	}
	
	private void createPanel2()
	{
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		
		tittleLabel2 = new JLabel("Materias");
		panel2.add(tittleLabel2);
		
		int numMaterias = (Integer) subjectField.getValue();
		
	    subjectFieldList = new ArrayList<JTextField>();
		for (int i=0; i< numMaterias; i++)
		{
			subjectFieldList.add(new JTextField(5));
		}
		
		for (int i =0; i< subjectFieldList.size();i++)
		{
			subjectFieldList.get(i).setMaximumSize(new Dimension(400,20));
			panel2.add(subjectFieldList.get(i));
		}
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		panel2.add(okButton);
		
		
		pane.addTab("Materias", panel2);
		
		
	
	}
	
	private List<String> getSubjectList()
	{
		subjectList = new ArrayList<String>();
		for (int i = 0; i < subjectFieldList.size();i++)
		{
			subjectList.add(subjectFieldList.get(i).getText()) ;
			
		}
		return subjectList;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		
		if (e.getSource() == nextButton	)
		{
			createPanel2();
			pane.setSelectedIndex(1);
			pane.setEnabledAt(0, false);
			
		}else if (e.getSource() == cancelButton)
		{
			this.dispose();
		}else if(e.getSource() == okButton)
		{
			MultiplikConnector con = new MultiplikConnector();
			con.createNewSubjectTable((String)schoolNameField.getSelectedItem()+""+ " Grado "+gradeField.getValue(),getSubjectList());
			parentFrame.refreshSubjectList() ;
			parentFrame.setEnabled(true);
		
			this.dispose();
		}
	}	
	
	
	
	
}