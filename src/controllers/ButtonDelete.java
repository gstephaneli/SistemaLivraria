package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ButtonDelete extends DefaultCellEditor {
	protected JButton btn;
	   private String lbl;
	   private Boolean clicked;
	   String opDelete;

	   public ButtonDelete(JTextField txt, JTable table,String aOpDelete ) {
	    super(txt);
	    this.opDelete = aOpDelete;
	    btn=new JButton();
	    btn.setOpaque(true);

	    //WHEN BUTTON IS CLICKED

	    btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String op = opDelete;
				
				if(op == "livros") {
					Object[] options = { "Deletar Livro","Cancelar" };
					int opcao = JOptionPane.showOptionDialog(null, "O que deseja deletar:", "Selecione uma op��o", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					System.out.println(opcao);
				}
				else if(op == "autores") {
					Object[] options = { "Deletar autor","Deletar autor e livros","Cancelar" };
					int opcao = JOptionPane.showOptionDialog(null, "O que deseja deletar:", "Selecione uma op��o", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);		
					System.out.println(opcao);
				}
				else if(op == "editoras") {
					Object[] options = { "Deletar Livro","Deletar editora e livros","Cancelar" };
					int opcao = JOptionPane.showOptionDialog(null, "O que deseja deletar:", "Selecione uma op��o", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					System.out.println(opcao);
				}
			}
		});

	  }

	   //OVERRIDE A COUPLE OF METHODS
	   @Override
	  public Component getTableCellEditorComponent(JTable table, Object obj,
	      boolean selected, int row, int col) {

	      //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
	     lbl=(obj==null) ? "":obj.toString();
	     btn.setText(lbl);
	     clicked=true;
	    return btn;
	  }

	  //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
	   @Override
	  public Object getCellEditorValue() {

	     if(clicked)
	      {
	      //SHOW US SOME MESSAGE
	        JOptionPane.showMessageDialog(btn, lbl+" Clicked");
	      }
	    //SET IT TO FALSE NOW THAT ITS CLICKED
	    clicked=false;
	    return new String(lbl);
	  }

	   @Override
	  public boolean stopCellEditing() {

	         //SET CLICKED TO FALSE FIRST
	      clicked=false;
	    return super.stopCellEditing();
	  }

	   @Override
	  protected void fireEditingStopped() {
	    super.fireEditingStopped();
	  }
}
