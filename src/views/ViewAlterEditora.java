package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daos.PublisherDAO;
import models.PublisherModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAlterEditora extends JFrame {

	private JPanel contentPane;
	private JTextField jCampoNome;
	private JTextField jCampoURL;
	private JPanel panelButtons;
	private JButton buttonSalvar;
	private JButton buttonCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAlterEditora frame = new ViewAlterEditora();
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
	String id_editora;
	
	public String getId_editora() {
		return id_editora;
	}

	public void setId_editora(String id_editora) {
		this.id_editora = id_editora;
	}

	public ViewAlterEditora() {
		
		setTitle("Editar Editora");
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
		
		JLabel labelNomeEditora = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(labelNomeEditora, gbc_lblNewLabel);
		
		jCampoNome = new JTextField();
		GridBagConstraints gbc_jCampoNome = new GridBagConstraints();
		gbc_jCampoNome.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoNome.gridx = 1;
		gbc_jCampoNome.gridy = 0;
		contentPane.add(jCampoNome, gbc_jCampoNome);
		jCampoNome.setColumns(10);
		
		JLabel labelURLEditora = new JLabel("URL:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(labelURLEditora, gbc_lblNewLabel_1);
		
		jCampoURL = new JTextField();
		GridBagConstraints gbc_jCampoURL = new GridBagConstraints();
		gbc_jCampoURL.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoURL.gridx = 1;
		gbc_jCampoURL.gridy = 1;
		contentPane.add(jCampoURL, gbc_jCampoURL);
		jCampoURL.setColumns(10);
		
		panelButtons = new JPanel();
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.fill = GridBagConstraints.BOTH;
		gbc_panelButtons.gridx = 1;
		gbc_panelButtons.gridy = 2;
		contentPane.add(panelButtons, gbc_panelButtons);
		panelButtons.setLayout(new BorderLayout(0, 0));
		
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PublisherDAO pDao = new PublisherDAO();
				Integer editora_id = Integer.valueOf(id_editora);
				String nome = jCampoNome.getText();
				String url = jCampoURL.getText();
				
				try {
					pDao.update(new PublisherModel(editora_id,nome,url));
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		panelButtons.add(buttonSalvar, BorderLayout.WEST);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//JOptionPane.showMessageDialog(null,"alterado");
			}
			
		});
		panelButtons.add(buttonCancelar, BorderLayout.EAST);
	}

	public void setjCampoNome(String text) {
		this.jCampoNome.setText(text);
	}

	public void setjCampoURL(String text) {
		this.jCampoURL.setText(text);
	}
	
	
	
	

}
