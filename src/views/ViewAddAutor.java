package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewAddAutor extends JFrame {

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
					ViewAddAutor frame = new ViewAddAutor();
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
	public ViewAddAutor() {
		setTitle("Cadastrar Autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 129);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel labelNome = new JLabel("Nome:");
		GridBagConstraints gbc_labelNome = new GridBagConstraints();
		gbc_labelNome.insets = new Insets(0, 0, 5, 5);
		gbc_labelNome.gridx = 0;
		gbc_labelNome.gridy = 0;
		contentPane.add(labelNome, gbc_labelNome);
		
		jCampoNome = new JTextField();
		GridBagConstraints gbc_jCampoNome = new GridBagConstraints();
		gbc_jCampoNome.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoNome.gridx = 1;
		gbc_jCampoNome.gridy = 0;
		contentPane.add(jCampoNome, gbc_jCampoNome);
		jCampoNome.setColumns(10);
		
		JLabel labelSobrenome = new JLabel("Sobrenome:");
		GridBagConstraints gbc_labelSobrenome = new GridBagConstraints();
		gbc_labelSobrenome.insets = new Insets(0, 0, 5, 5);
		gbc_labelSobrenome.gridx = 0;
		gbc_labelSobrenome.gridy = 1;
		contentPane.add(labelSobrenome, gbc_labelSobrenome);
		
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
		
		JButton buttonSalvar = new JButton("New button");
		panel.add(buttonSalvar, BorderLayout.WEST);
		
		JButton buttonCancelar = new JButton("New button");
		panel.add(buttonCancelar, BorderLayout.EAST);
	}

}
