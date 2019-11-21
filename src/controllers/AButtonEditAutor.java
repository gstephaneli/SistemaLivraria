package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;

import views.ViewAlterAutor;
import views.ViewAlterLivro;

public class AButtonEditAutor implements ActionListener{

	JTable table;
	
	public AButtonEditAutor(JTable table) {
		
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ViewAlterAutor viewAlterAutor = new ViewAlterAutor();
		viewAlterAutor.setVisible(true);
		viewAlterAutor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		viewAlterAutor.setjCampoNome(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)).trim());
		viewAlterAutor.setjCampoSobrenome(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)).trim());
		viewAlterAutor.setId_autor(String.valueOf(table.getValueAt(table.getSelectedRow(), 4)).trim());
		
		
		
		
	}

}
