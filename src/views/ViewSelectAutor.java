package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CriaViewSelectAutor;
import daos.AuthorDAO;
import models.AuthorModel;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.GridBagConstraints;

public class ViewSelectAutor extends JFrame {


	
	int contadoCkBox=0;
	//JPanel panelCkBox = null;
	public ViewSelectAutor(String isbn) throws Throwable {
		setTitle("Seleção de Autores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(300,380));
		setLayout(new BorderLayout());
		
		
		
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new BorderLayout());
		add(panelBotoes,BorderLayout.PAGE_END);
		
		new CriaViewSelectAutor(isbn,this);
		
		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewAlterLivro.pegaAutoresSelecionados(CriaViewSelectAutor.pegaSelecionados());
				dispose();
			}
		});
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelBotoes.add(buttonSalvar,BorderLayout.LINE_START);
		panelBotoes.add(buttonCancelar,BorderLayout.LINE_END);
		
		
		
		
	}
	

}
