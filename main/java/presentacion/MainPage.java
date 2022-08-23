package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;

public class MainPage {

	private JFrame frmEntrenamosUy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frmEntrenamosUy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntrenamosUy = new JFrame();
		frmEntrenamosUy.setTitle("ENTRENAMOS UY");
		frmEntrenamosUy.getContentPane().setBackground(SystemColor.activeCaption);
		frmEntrenamosUy.setResizable(false);
		frmEntrenamosUy.setBackground(Color.WHITE);
		frmEntrenamosUy.getContentPane().setForeground(Color.WHITE);
		frmEntrenamosUy.setBounds(100, 100, 800, 600);
		frmEntrenamosUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntrenamosUy.getContentPane().setLayout(null);
		
		JDesktopPane desktopPaneControl = new JDesktopPane();
		desktopPaneControl.setBorder(new CompoundBorder());
		desktopPaneControl.setBackground(SystemColor.inactiveCaption);
		desktopPaneControl.setBounds(209, 10, 567, 543);
		frmEntrenamosUy.getContentPane().add(desktopPaneControl);
		
		JButton btnNewButton = new JButton("Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPaneControl.removeAll();
				OpcionesUsuario f1 = new OpcionesUsuario();
				f1.setLocation((desktopPaneControl.getWidth()-f1.getWidth())/2, (desktopPaneControl.getHeight()-f1.getHeight())/2);
				desktopPaneControl.add(f1).setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(24, 142, 156, 58);
		frmEntrenamosUy.getContentPane().add(btnNewButton);
		
		JButton btnActividadDeportiva = new JButton("Actividad Deportiva");
		btnActividadDeportiva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActividadDeportiva.setBounds(24, 210, 156, 58);
		frmEntrenamosUy.getContentPane().add(btnActividadDeportiva);
		
		JButton btnNewButton_1_1 = new JButton("Clase");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(24, 275, 156, 58);
		frmEntrenamosUy.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Salir");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setBounds(24, 467, 156, 58);
		frmEntrenamosUy.getContentPane().add(btnNewButton_1_1_1);
	}

}
