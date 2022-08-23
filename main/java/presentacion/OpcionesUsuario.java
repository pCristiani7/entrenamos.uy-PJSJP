package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class OpcionesUsuario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcionesUsuario frame = new OpcionesUsuario();
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
	public OpcionesUsuario() {
		setMaximizable(true);
		setBorder(new LineBorder(Color.BLUE));
		getContentPane().setBackground(SystemColor.menu);
		setIconifiable(true);
		JDesktopPane desktopPaneControl1 = new JDesktopPane();
		desktopPaneControl1.setBorder(new CompoundBorder());
		desktopPaneControl1.setBackground(SystemColor.menu);
		setTitle("Usuario");
		setClosable(true);
		setResizable(true);
		setBounds(209, 10, 567, 543);
		getContentPane().setLayout(null);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPaneControl1.removeAll();
				AltaUsuario a1 = new AltaUsuario();
				a1.setLocation((desktopPaneControl1.getWidth()-a1.getWidth())/2, (desktopPaneControl1.getHeight()-a1.getHeight())/2);
				desktopPaneControl1.add(a1).setVisible(true);
			}
		});
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlta.setBounds(10, 143, 156, 58);
		getContentPane().add(btnAlta);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsulta.setBounds(10, 211, 156, 58);
		getContentPane().add(btnConsulta);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(10, 279, 156, 58);
		getContentPane().add(btnModificar);
		
		desktopPaneControl1.setBounds(178, 10, 365, 492);
		getContentPane().add(desktopPaneControl1);

	}

}
