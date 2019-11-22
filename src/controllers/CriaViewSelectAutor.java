package controllers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import daos.AuthorDAO;
import daos.PublisherDAO;
import models.AuthorModel;
import models.PublisherModel;
import views.ViewAlterLivro;
import views.ViewSelectAutor;
import views.viewAddEditora;

public class CriaViewSelectAutor {

	GridBagConstraints gbc = new GridBagConstraints();
	int contadorY = 0;
	
	
	
	static ArrayList<AuthorModel> aSelectionados = new ArrayList<AuthorModel>();
	static ArrayList<AuthorModel> totalAutores = new ArrayList<AuthorModel>();
	static ArrayList<JCheckBox> checkBoxAutores = new ArrayList<JCheckBox>();
	ArrayList<AuthorModel> autoresDoLivro = new ArrayList<AuthorModel>();
	
	public CriaViewSelectAutor(String isbnLivro, ViewSelectAutor frame) throws Throwable {
		
		JPanel panelCkBox = new JPanel();
		
		//panelCkBox.setPreferredSize(new Dimension(290,350));
		panelCkBox.setLayout(new GridBagLayout());
		frame.add(panelCkBox, BorderLayout.WEST);
		
		JScrollPane scroll = new JScrollPane(panelCkBox);
		frame.add(scroll, BorderLayout.CENTER);
		AuthorDAO aDao = new AuthorDAO();
		
		
		totalAutores = aDao.index();
		autoresDoLivro = aDao.listarAutores(isbnLivro);
		totalAutores = aDao.index();
		checkBoxAutores = new ArrayList<JCheckBox>();
		for(AuthorModel autor : totalAutores) {
			
			checkBoxAutores.add(new JCheckBox(autor.getName()));
			
			
		}
		
		for(JCheckBox ckBox : checkBoxAutores) {
			//if(getaSelectionados().isEmpty() != true) {
				//for(AuthorModel autor :aSelectionados) {
					//if(ckBox.getText().trim().contentEquals(autor.getName().trim())) {
						//ckBox.setSelected(true);
					//}
				//}
			//}
			//else if(getaSelectionados().isEmpty() == true){
				//setaSelectionados(null);
			//}
			
				for(AuthorModel autor :autoresDoLivro) {
					if(ckBox.getText().trim().contentEquals(autor.getName().trim())) {
						ckBox.setSelected(true);
					}
				}
			
			panelCkBox.add(ckBox,getGbc());
			contadorY++;
		}
		
		
	}
	
	public static ArrayList<AuthorModel> pegaSelecionados(){
		ArrayList<AuthorModel> aSelectionados = new ArrayList<AuthorModel>();
		aSelectionados = getaSelectionados();
		for(JCheckBox ckBox : checkBoxAutores) {
			
			if(ckBox.isSelected() == true) {
				ViewAlterLivro.limpaAutoresSelecionados();
				for(AuthorModel autor : totalAutores) {
					if(ckBox.getText().trim().equals(autor.getName().trim())) {
						aSelectionados.add(autor);
						ViewAlterLivro.setAutoresSelecionados(autor);
						System.out.println(autor.getName());
					}
				}
			}
		}
		return aSelectionados;
		
	}
	
	public static void preencheComboBox(JComboBox comboBoxEditora) throws Throwable {
		PublisherDAO pDao = new PublisherDAO();
		ArrayList<PublisherModel> editoras = new ArrayList<>();
		editoras = pDao.index();
		for(PublisherModel editora : editoras) {
			
			comboBoxEditora.addItem(editora);
			
		}
		
	}
	public static ArrayList<AuthorModel> getaSelectionados() {
		return aSelectionados;
	}

	public void setaSelectionados(ArrayList<AuthorModel> aSelectionados) {
		this.aSelectionados = aSelectionados;
	}

	public GridBagConstraints getGbc() {
		
		this.gbc.gridy = contadorY;
		return gbc;
	}
	
}
