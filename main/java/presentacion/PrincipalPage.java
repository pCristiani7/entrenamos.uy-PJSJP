package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.SystemColor;

public class PrincipalPage {

	private JFrame frmEntrenamosUy;
	private AltaUsuario altaUsuarioInternalFrame;
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalPage window = new PrincipalPage();
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
	public PrincipalPage() {
		initialize();
		
		Fabrica fab = Fabrica.getInstance();
		IControlador iCon = fab.getIControlador();
		
		Dimension desktopSize = frmEntrenamosUy.getSize();
		Dimension jInternalFrameSize;
		
		altaUsuarioInternalFrame = new AltaUsuario(iCon);
		altaUsuarioInternalFrame.setIconifiable(false);
		altaUsuarioInternalFrame.setMaximizable(false);
		jInternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		altaUsuarioInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(altaUsuarioInternalFrame);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Cristiani\\eclipse-workspace\\entrenamos.uy\\entrenamos.uy.png"));
		lblNewLabel.setBounds(31, 0, 1184, 710);
		frmEntrenamosUy.getContentPane().add(lblNewLabel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntrenamosUy = new JFrame();
		frmEntrenamosUy.getContentPane().setBackground(Color.WHITE);
		frmEntrenamosUy.setBackground(Color.WHITE);
		frmEntrenamosUy.setTitle("ENTRENAMOS UY");
		frmEntrenamosUy.setBounds(100, 100, 1200, 800);
		frmEntrenamosUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntrenamosUy.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(4, 6, 0, 7));
		menuBar.setBackground(SystemColor.activeCaption);
		frmEntrenamosUy.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Usuario");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 25));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alta");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioInternalFrame.inicializarComboBoxes();
				altaUsuarioInternalFrame.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consulta");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modificar");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Actividad Deportiva");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Clase");
		mnNewMenu_2.setForeground(Color.BLACK);
		mnNewMenu_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_2);
	}
}
