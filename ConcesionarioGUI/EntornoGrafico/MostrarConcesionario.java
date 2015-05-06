package EntornoGrafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import concesionarioCoches.Coche;
import concesionarioCoches.Marca;
import concesionarioCoches.Modelo;

public class MostrarConcesionario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMatricula;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnRojo;
	private JRadioButton rdbtnAzul;
	private JRadioButton rdbtnPlata;
	private JComboBox<Marca> comboBoxMarca;
	private JComboBox<Modelo> comboBoxModelo;
	private int indice = 0;
	private JButton botonAnterior;
	private JButton botonSiguiente;
	private JButton btnMostrar;

	/**
	 * Create the dialog.
	 */
	public MostrarConcesionario() {
		setTitle("Mostrar concesionario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMatricula = new JLabel("Matricula");
			lblMatricula.setBounds(23, 36, 75, 14);
			contentPanel.add(lblMatricula);
		}

		txtMatricula = new JTextField();
		txtMatricula.setBackground(Color.WHITE);
		txtMatricula.setEnabled(false);
		txtMatricula.setEditable(false);
		txtMatricula.setBounds(100, 33, 86, 20);
		contentPanel.add(txtMatricula);
		txtMatricula.setColumns(10);

		JPanel Colores = new JPanel();
		Colores.setToolTipText("");
		Colores.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Colores",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		Colores.setBounds(282, 16, 121, 97);
		contentPanel.add(Colores);
		Colores.setLayout(null);

		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setEnabled(false);
		rdbtnRojo.setBounds(6, 16, 109, 23);
		Colores.add(rdbtnRojo);
		buttonGroup.add(rdbtnRojo);

		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setEnabled(false);
		rdbtnAzul.setBounds(6, 42, 109, 23);
		Colores.add(rdbtnAzul);
		buttonGroup.add(rdbtnAzul);

		rdbtnPlata = new JRadioButton("Plata");
		rdbtnPlata.setEnabled(false);
		rdbtnPlata.setBounds(6, 68, 109, 23);
		Colores.add(rdbtnPlata);
		buttonGroup.add(rdbtnPlata);

		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(90, 155, -57, -63);
		contentPanel.add(list);

		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setBackground(Color.WHITE);
		comboBoxMarca.setEnabled(false);
		comboBoxMarca.setBounds(10, 124, 105, 22);
		contentPanel.add(comboBoxMarca);

		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBackground(Color.WHITE);
		comboBoxModelo.setEnabled(false);
		comboBoxModelo.setBounds(126, 124, 105, 22);
		contentPanel.add(comboBoxModelo);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(45, 99, 46, 14);
		contentPanel.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(159, 99, 46, 14);
		contentPanel.add(lblModelo);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			botonAnterior = new JButton("<");
			botonAnterior.setVisible(false);
			botonAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarAnterior();
				}

			});
			buttonPane.add(botonAnterior);

			botonSiguiente = new JButton(">");
			botonSiguiente.setVisible(false);
			botonSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarSiguiente();
				}
			});
			buttonPane.add(botonSiguiente);

			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						clear();
					}
				});

				btnMostrar = new JButton("Mostrar");
				btnMostrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (General.concesionario.size() == 0)
							JOptionPane.showMessageDialog(contentPanel,
									"El concesionario esta vacio", "Error",
									JOptionPane.ERROR_MESSAGE);
						if (General.concesionario.get(0) != null) {
							mostrarCoche(General.concesionario.get(indice));
							comprobarTamaño();
							botonSiguiente.setVisible(true);
							botonAnterior.setVisible(true);
							btnMostrar.setVisible(false);
						}
					}
				});
				buttonPane.add(btnMostrar);
				buttonPane.add(cancelButton);
			}
		}

	}

	private void mostrarSiguiente() {
		mostrarCoche(General.concesionario.get(++indice));
		comprobarTamaño();
	}

	private void mostrarAnterior() {
		mostrarCoche(General.concesionario.get(--indice));
		comprobarTamaño();
	}

	private void mostrarCoche(Coche coche) {
		txtMatricula.setText(coche.getMatricula());
		if (coche.getColor().toString().equals("ROJO"))
			rdbtnRojo.setSelected(true);
		else if (coche.getColor().toString().equals("PLATA"))
			rdbtnPlata.setSelected(true);
		else
			rdbtnAzul.setSelected(true);

		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());

	}

	private void comprobarTamaño() {
		if (General.concesionario.get(indice + 1) == null)
			botonSiguiente.setEnabled(false);
		else
			botonSiguiente.setEnabled(true);

		if (General.concesionario.get(indice - 1) == null)
			botonAnterior.setEnabled(false);
		else
			botonAnterior.setEnabled(true);
	}

	private void clear() {
		txtMatricula.setText("");

		rdbtnRojo.setSelected(true);
		rdbtnPlata.setSelected(false);
		rdbtnAzul.setSelected(false);

		comboBoxMarca.setSelectedIndex(-1);
		comboBoxModelo.setSelectedIndex(-1);

		botonSiguiente.setVisible(false);
		botonAnterior.setVisible(false);
		btnMostrar.setVisible(true);
	}

}