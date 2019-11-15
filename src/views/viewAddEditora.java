package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ActionAdd;
import daos.PublisherDAO;
import models.PublisherModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class viewAddEditora extends JFrame {

	private JPanel contentPane;
	private JTextField jCampoNome;
	private JTextField jCampoURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewAddEditora frame = new viewAddEditora();
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
	public viewAddEditora() {
		
		String name,url;
		setTitle("Cadastrar Editora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 128);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel labelNameEditora = new JLabel("Nome:");
		GridBagConstraints gbc_labelNameEditora = new GridBagConstraints();
		gbc_labelNameEditora.insets = new Insets(0, 0, 5, 5);
		gbc_labelNameEditora.gridx = 0;
		gbc_labelNameEditora.gridy = 0;
		contentPane.add(labelNameEditora, gbc_labelNameEditora);
		
		jCampoNome = new JTextField();
		GridBagConstraints gbc_jCampoNome = new GridBagConstraints();
		gbc_jCampoNome.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoNome.gridx = 1;
		gbc_jCampoNome.gridy = 0;
		contentPane.add(jCampoNome, gbc_jCampoNome);
		jCampoNome.setColumns(10);
		
		JLabel labelURLEditora = new JLabel("URL:");
		GridBagConstraints gbc_labelURLEditora = new GridBagConstraints();
		gbc_labelURLEditora.insets = new Insets(0, 0, 5, 5);
		gbc_labelURLEditora.gridx = 0;
		gbc_labelURLEditora.gridy = 1;
		contentPane.add(labelURLEditora, gbc_labelURLEditora);
		
		jCampoURL = new JTextField();
		GridBagConstraints gbc_jCampoURL = new GridBagConstraints();
		gbc_jCampoURL.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoURL.gridx = 1;
		gbc_jCampoURL.gridy = 1;
		contentPane.add(jCampoURL, gbc_jCampoURL);
		jCampoURL.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton buttonSalvar = new JButton("Salvar");
	
		buttonSalvar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PublisherDAO pDao = new PublisherDAO();
				try {
					pDao.store(new PublisherModel(jCampoNome.getText(),jCampoURL.getText()));
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			
		});
		panel.add(buttonSalvar, BorderLayout.WEST);
		
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener(){ {
			
		}
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		}); 
		panel.add(buttonCancelar, BorderLayout.EAST);
		
		
		
	}

	
	public void setjCampoNome(JTextField jCampoNome) {
		this.jCampoNome = jCampoNome;
	}

	public void setjCampoURL(JTextField jCampoURL) {
		this.jCampoURL = jCampoURL;
	}

	public JTextField getjCampoNome() {
		return this.jCampoNome;
	}

	public JTextField getjCampoURL() {
		return this.jCampoURL;
	}
	
	

	
	

}
