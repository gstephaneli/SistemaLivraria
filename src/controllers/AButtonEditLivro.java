package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;

import views.ViewAlterLivro;

public class AButtonEditLivro implements ActionListener{

	JTable table;

    public AButtonEditLivro(JTable table) {
        this.table = table;
    }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ViewAlterLivro janelaAlterlivro;
		try {
			janelaAlterlivro = new ViewAlterLivro();
			janelaAlterlivro.setVisible(true);
			janelaAlterlivro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			janelaAlterlivro.setjCampoTitulo(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
			janelaAlterlivro.setjCampoISBN(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));
			janelaAlterlivro.setjCampoPreco(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)));
			janelaAlterlivro.setEditoraDoLivro(String.valueOf(table.getValueAt(table.getSelectedRow(), 4)));
			System.out.println(janelaAlterlivro.getEditoraDoLivro());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
