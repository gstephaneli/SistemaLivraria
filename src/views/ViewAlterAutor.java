package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daos.AuthorDAO;
import daos.PublisherDAO;
import models.AuthorModel;
import models.PublisherModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAlterAutor extends JFrame {

	private JPanel contentPane;
	private JTextField jCampoNome;
	private JTextField jCampoSobrenome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAlterAutor frame = new ViewAlterAutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String id_autor;
	
	
	public String getId_autor() {
		return id_autor;
	}

	public void setId_autor(String id_autor) {
		this.id_autor = id_autor;
	}

	public ViewAlterAutor() {
		setTitle("Editar Autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel labelNomeAutor = new JLabel("Nome:");
		GridBagConstraints gbc_labelNomeAutor = new GridBagConstraints();
		gbc_labelNomeAutor.insets = new Insets(0, 0, 5, 5);
		gbc_labelNomeAutor.gridx = 0;
		gbc_labelNomeAutor.gridy = 0;
		contentPane.add(labelNomeAutor, gbc_labelNomeAutor);
		
		jCampoNome = new JTextField();
		GridBagConstraints gbc_jCampoNome = new GridBagConstraints();
		gbc_jCampoNome.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoNome.gridx = 1;
		gbc_jCampoNome.gridy = 0;
		contentPane.add(jCampoNome, gbc_jCampoNome);
		jCampoNome.setColumns(10);
		
		JLabel labelSobrenomeAutor = new JLabel("Sobrenome:");
		GridBagConstraints gbc_labelSobrenomeAutor = new GridBagConstraints();
		gbc_labelSobrenomeAutor.insets = new Insets(0, 0, 5, 5);
		gbc_labelSobrenomeAutor.gridx = 0;
		gbc_labelSobrenomeAutor.gridy = 1;
		contentPane.add(labelSobrenomeAutor, gbc_labelSobrenomeAutor);
		
		jCampoSobrenome = new JTextField();
		GridBagConstraints gbc_jCampoSobrenome = new GridBagConstraints();
		gbc_jCampoSobrenome.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoSobrenome.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoSobrenome.gridx = 1;
		gbc_jCampoSobrenome.gridy = 1;
		contentPane.add(jCampoSobrenome, gbc_jCampoSobrenome);
		jCampoSobrenome.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton buttonSalvar = new JButton("Salvar");
		panel.add(buttonSalvar, BorderLayout.WEST);
		buttonSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Integer author_id = Integer.valueOf(id_autor);
				String nome = jCampoNome.getText();
				String sobrenome = jCampoSobrenome.getText();
				
				AuthorDAO aDao = new AuthorDAO();
				try {
					aDao.update(new AuthorModel(author_id,nome,sobrenome));
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(buttonCancelar, BorderLayout.EAST);
	}

	public void setjCampoNome(String text) {
		this.jCampoNome.setText(text);
	}

	public void setjCampoSobrenome(String text) {
		this.jCampoSobrenome.setText(text);
	}
	
	

}
