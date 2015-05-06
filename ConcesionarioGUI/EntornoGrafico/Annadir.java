package EntornoGrafico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import concesionarioCoches.Coche;
import concesionarioCoches.CocheYaExistenteException;
import concesionarioCoches.ColorNoValidoException;
import concesionarioCoches.Marca;
import concesionarioCoches.MatriculaNoValidaException;
import concesionarioCoches.Modelo;
import concesionarioCoches.ModeloNoValidoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
//Pruebaaaa
public class Annadir extends JDialog {

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
	private JComboBox<?> comboBoxModelo;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("rawtypes")
	public Annadir() {
		setTitle("A\u00F1adir");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMatricula = new JLabel("Matricula");
			lblMatricula.setBounds(21, 36, 75, 14);
			contentPanel.add(lblMatricula);
		}

		txtMatricula = new JTextField();
		txtMatricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Coche.esValida(txtMatricula.getText().toString()))
					txtMatricula.setForeground(Color.RED);

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				txtMatricula.setForeground(Color.BLACK);
			}
		});
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
		rdbtnRojo.setBounds(6, 16, 109, 23);
		Colores.add(rdbtnRojo);
		rdbtnRojo.setSelected(true);
		buttonGroup.add(rdbtnRojo);

		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(6, 42, 109, 23);
		Colores.add(rdbtnAzul);
		buttonGroup.add(rdbtnAzul);

		rdbtnPlata = new JRadioButton("Plata");
		rdbtnPlata.setBounds(6, 68, 109, 23);
		Colores.add(rdbtnPlata);
		buttonGroup.add(rdbtnPlata);

		JList list = new JList();
		list.setBounds(90, 155, -57, -63);
		contentPanel.add(list);

		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setModel(new DefaultComboBoxModel<Marca>(Marca.values()));
		comboBoxMarca.setBounds(10, 124, 105, 22);
		contentPanel.add(comboBoxMarca);

		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setModel(new DefaultComboBoxModel(
				getModelo(comboBoxMarca)));
		comboBoxModelo.setBounds(126, 124, 105, 22);
		contentPanel.add(comboBoxModelo);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(64, 99, 46, 14);
		contentPanel.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(140, 99, 46, 14);
		contentPanel.add(lblModelo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton Añadir = new JButton("A\u00F1adir");
			Añadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if (General.concesionario.annadir(
								txtMatricula.getText(), colorSeleccionado(),
								(Modelo) comboBoxModelo.getSelectedItem())) {
							JOptionPane.showMessageDialog(contentPanel,
									"Coche añadido con exito");
						}
					} catch (HeadlessException | MatriculaNoValidaException
							| ColorNoValidoException | ModeloNoValidoException
							| CocheYaExistenteException e) {
						if (!Coche.esValida(txtMatricula.getText().toString())) {
							JOptionPane.showMessageDialog(contentPanel,
									"La matricula no es valida", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
						try {
							if (General.concesionario.almacen
									.contains(new Coche(txtMatricula.getText()))) {
								JOptionPane
										.showMessageDialog(
												contentPanel,
												"Ya existe un coche con esta matricula",
												"Error",
												JOptionPane.ERROR_MESSAGE);
							}
						} catch (MatriculaNoValidaException e1) {
							e1.printStackTrace();
						}

					}
				}
			});
			buttonPane.add(Añadir);
			{
				JButton botonSalir = new JButton("Salir");
				botonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						clear();
					}
				});
				buttonPane.add(botonSalir);
			}
		}
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(
						getModelo(comboBoxMarca)));
			}
		});
	}

	private Object[] getModelo(JComboBox<Marca> comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca().equals(marca))
				modelos.add(m);
		}
		return modelos.toArray();
	}

	private concesionarioCoches.Color colorSeleccionado() {
		if (rdbtnRojo.isSelected())
			return concesionarioCoches.Color.ROJO;
		if (rdbtnPlata.isSelected())
			return concesionarioCoches.Color.PLATA;
		if (rdbtnAzul.isSelected())
			return concesionarioCoches.Color.AZUL;
		return null;
	}

	private void clear() {
		txtMatricula.setText("");

		rdbtnRojo.setSelected(true);

		comboBoxMarca.setModel(new DefaultComboBoxModel<Marca>(Marca.values()));
		comboBoxModelo.setModel(new DefaultComboBoxModel(
				getModelo(comboBoxMarca)));
	}

}
