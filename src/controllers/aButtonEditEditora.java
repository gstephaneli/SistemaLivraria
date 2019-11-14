package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;

import javax.swing.JFrame;
import javax.swing.JTable;

import views.ViewAlterAutor;
import views.ViewAlterEditora;

public class aButtonEditEditora implements ActionListener{

	JTable table;
	
	public aButtonEditEditora(JTable table) {
		
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ViewAlterEditora viewAlterEditora= new ViewAlterEditora();
		viewAlterEditora.setVisible(true);
		viewAlterEditora.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		viewAlterEditora.setjCampoNome(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
		viewAlterEditora.setjCampoURL(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
		viewAlterEditora.setId_editora(String.valueOf(table.getValueAt(table.getSelectedRow(), 4)));
		System.out.println(viewAlterEditora.getId_editora());
		
	}

}
