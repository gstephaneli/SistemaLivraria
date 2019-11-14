package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import daos.AuthorDAO;
import daos.BookDAO;
import daos.PublisherDAO;
import models.AuthorModel;
import models.BookModel;
import models.PublisherModel;

public class ActionCampoBusca implements ActionListener{

	
	JTable tabela;
	JTextField campoDeBusca;
	
	
	
	public ActionCampoBusca(JTextField campoBusca, JTable table) {
		this.campoDeBusca = campoBusca;
		tabela = table;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = campoDeBusca.getText();
		
		if(tabela.getColumnName(4) == "Id_Autor") {
			AuthorDAO aDao = new AuthorDAO();
			ArrayList<AuthorModel> autores = new ArrayList<AuthorModel>();
			autores = aDao.getAuthorByName(text);
			try {
				TableBooksController.pBuscaAutor(tabela, autores);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if (tabela.getColumnName(4) == "Id_Editora") {
				PublisherDAO pDao = new PublisherDAO();
				ArrayList<PublisherModel> editoras= new ArrayList<PublisherModel>();
				editoras = pDao.getPublisherByName(text);
				try {
					TableBooksController.pBuscaEditora(tabela, editoras);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else {
			BookDAO bDao = new BookDAO();
			ArrayList<BookModel> livros= new ArrayList<BookModel>();
			livros = bDao.getBookByName(text);
			try {
				TableBooksController.pBuscaLivro(tabela, livros);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}
}
