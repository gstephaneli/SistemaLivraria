package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CriaViewSelectAutor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAddLivro extends JFrame {

	private JPanel contentPane;
	private JTextField jCampoNome;
	private JTextField jCampoISBN;
	private JTextField jCampoPreco;

	
	public ViewAddLivro() throws Throwable {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel labelName = new JLabel("Nome:");
		GridBagConstraints gbc_labelName = new GridBagConstraints();
		gbc_labelName.insets = new Insets(0, 0, 5, 5);
		gbc_labelName.gridx = 0;
		gbc_labelName.gridy = 0;
		contentPane.add(labelName, gbc_labelName);
		
		jCampoNome = new JTextField();
		GridBagConstraints gbc_jCampoNome = new GridBagConstraints();
		gbc_jCampoNome.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoNome.gridx = 1;
		gbc_jCampoNome.gridy = 0;
		contentPane.add(jCampoNome, gbc_jCampoNome);
		jCampoNome.setColumns(10);
		
		JLabel labelISBN = new JLabel("ISBN:");
		GridBagConstraints gbc_labelISBN = new GridBagConstraints();
		gbc_labelISBN.insets = new Insets(0, 0, 5, 5);
		gbc_labelISBN.gridx = 0;
		gbc_labelISBN.gridy = 1;
		contentPane.add(labelISBN, gbc_labelISBN);
		
		jCampoISBN = new JTextField();
		GridBagConstraints gbc_jCampoISBN = new GridBagConstraints();
		gbc_jCampoISBN.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoISBN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoISBN.gridx = 1;
		gbc_jCampoISBN.gridy = 1;
		contentPane.add(jCampoISBN, gbc_jCampoISBN);
		jCampoISBN.setColumns(10);
		
		JLabel labelPreco = new JLabel("Pre�o:");
		GridBagConstraints gbc_labelPreco = new GridBagConstraints();
		gbc_labelPreco.insets = new Insets(0, 0, 5, 5);
		gbc_labelPreco.gridx = 0;
		gbc_labelPreco.gridy = 2;
		contentPane.add(labelPreco, gbc_labelPreco);
		
		jCampoPreco = new JTextField();
		GridBagConstraints gbc_jCampoPreco = new GridBagConstraints();
		gbc_jCampoPreco.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoPreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoPreco.gridx = 1;
		gbc_jCampoPreco.gridy = 2;
		contentPane.add(jCampoPreco, gbc_jCampoPreco);
		jCampoPreco.setColumns(10);
		
		JLabel labelAutores = new JLabel("Autores:");
		GridBagConstraints gbc_labelAutores = new GridBagConstraints();
		gbc_labelAutores.insets = new Insets(0, 0, 5, 5);
		gbc_labelAutores.gridx = 0;
		gbc_labelAutores.gridy = 3;
		contentPane.add(labelAutores, gbc_labelAutores);
		
		JButton buttonSelecionarAutores = new JButton("Adicionar Autores");
		buttonSelecionarAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSelectAutor viewSelectAutor;
				try {
					viewSelectAutor = new ViewSelectAutor("");
					viewSelectAutor.setVisible(true);
					viewSelectAutor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		GridBagConstraints gbc_buttonSelecionarAutores = new GridBagConstraints();
		gbc_buttonSelecionarAutores.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonSelecionarAutores.insets = new Insets(0, 0, 5, 0);
		gbc_buttonSelecionarAutores.gridx = 1;
		gbc_buttonSelecionarAutores.gridy = 3;
		contentPane.add(buttonSelecionarAutores, gbc_buttonSelecionarAutores);
		
		JLabel labelEditora = new JLabel("Editora:");
		GridBagConstraints gbc_labelEditora = new GridBagConstraints();
		gbc_labelEditora.insets = new Insets(0, 0, 5, 5);
		gbc_labelEditora.gridx = 0;
		gbc_labelEditora.gridy = 4;
		contentPane.add(labelEditora, gbc_labelEditora);
		
		JComboBox comboBoxEditoras = new JComboBox();
		CriaViewSelectAutor.preencheComboBox(comboBoxEditoras);
		GridBagConstraints gbc_comboBoxEditoras = new GridBagConstraints();
		gbc_comboBoxEditoras.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxEditoras.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEditoras.gridx = 1;
		gbc_comboBoxEditoras.gridy = 4;
		contentPane.add(comboBoxEditoras, gbc_comboBoxEditoras);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Teste
				//System.out.println(comboBoxEditoras.getSelectedItem());
			}
		});
		panel.add(buttonSalvar, BorderLayout.WEST);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(buttonCancelar, BorderLayout.EAST);
	}

}
