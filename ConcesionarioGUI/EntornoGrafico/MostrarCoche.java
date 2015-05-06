package EntornoGrafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import concesionarioCoches.Coche;
import concesionarioCoches.CocheNoExistenteException;
import concesionarioCoches.Marca;
import concesionarioCoches.MatriculaNoValidaException;
import concesionarioCoches.Modelo;

public class MostrarCoche extends JDialog {

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

	/**
	 * Create the dialog.
	 */
	public MostrarCoche() {
		setTitle("Mostrar coche");
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
		lblMarca.setBounds(64, 99, 46, 14);
		contentPanel.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(140, 99, 46, 14);
		contentPanel.add(lblModelo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton Mostrar = new JButton("Mostrar");
			Mostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Coche coche = General.concesionario.get(txtMatricula
								.getText());
						if (coche.getColor().toString().equals("ROJO"))
							rdbtnRojo.setSelected(true);
						if (coche.getColor().toString().equals("PLATA"))
							rdbtnPlata.setSelected(true);
						if (coche.getColor().toString().equals("AZUL"))
							rdbtnAzul.setSelected(true);

						comboBoxMarca.addItem(coche.getModelo().getMarca());
						comboBoxMarca.setSelectedItem(coche.getModelo()
								.getMarca());
						comboBoxModelo.addItem(coche.getModelo());
						comboBoxModelo.setSelectedItem(coche.getModelo());

					} catch (MatriculaNoValidaException
							| CocheNoExistenteException e) {
						JOptionPane.showMessageDialog(contentPanel,
								"El coche no existe", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			buttonPane.add(Mostrar);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						clear();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
	private void clear() {
		txtMatricula.setText("");

		rdbtnRojo.setSelected(true);
		rdbtnPlata.setSelected(false);
		rdbtnAzul.setSelected(false);

		comboBoxMarca.setSelectedIndex(-1);
		comboBoxModelo.setSelectedIndex(-1);

	}
}
