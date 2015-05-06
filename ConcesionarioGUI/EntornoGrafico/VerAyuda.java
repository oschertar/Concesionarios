package EntornoGrafico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 */

public class VerAyuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public VerAyuda() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 422, 218);
		contentPanel.add(scrollPane);
		
		JEditorPane dtrpnHola = new JEditorPane();
		scrollPane.setViewportView(dtrpnHola);
		dtrpnHola.setContentType("text/html");
		dtrpnHola.setText("<h1>Hola</h1>");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton botonSalir = new JButton("Salir");
				botonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonPane.add(botonSalir);
			}
		}
	}
}
