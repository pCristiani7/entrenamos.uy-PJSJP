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

public class PrincipalPage {

	private JFrame frmEntrenamosUy;
	private AltaUsuario altaUsuarioInternalFrame;
	private ConsultaUsuario consultaUsuarioInternalFrame;
	private AltaInstitucionDeportiva altaInstitucionDeportivaInternalFrame;
	private AltaActividadDeportiva altaActividadDeportivaInternalFrame;
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
		
		consultaUsuarioInternalFrame = new ConsultaUsuario(iCon);
		consultaUsuarioInternalFrame.setIconifiable(false);
		consultaUsuarioInternalFrame.setMaximizable(false);
		jInternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		consultaUsuarioInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(consultaUsuarioInternalFrame);
		
		altaInstitucionDeportivaInternalFrame = new AltaInstitucionDeportiva(iCon);
		altaInstitucionDeportivaInternalFrame.setIconifiable(false);
		altaInstitucionDeportivaInternalFrame.setMaximizable(false);
		jInternalFrameSize = altaInstitucionDeportivaInternalFrame.getSize();
		altaInstitucionDeportivaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		altaInstitucionDeportivaInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(altaInstitucionDeportivaInternalFrame);
		
		altaActividadDeportivaInternalFrame = new AltaActividadDeportiva(iCon);
		altaActividadDeportivaInternalFrame.setIconifiable(false);
		altaActividadDeportivaInternalFrame.setMaximizable(false);
		jInternalFrameSize = altaActividadDeportivaInternalFrame.getSize();
		altaActividadDeportivaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		altaActividadDeportivaInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(altaActividadDeportivaInternalFrame);
		
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
		frmEntrenamosUy.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registros");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alta Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioInternalFrame.inicializarComboBoxes();
				altaUsuarioInternalFrame.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Alta Institucion Deportiva");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaInstitucionDeportivaInternalFrame.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alta Actividad Deportiva");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaActividadDeportivaInternalFrame.iniciarlizarComboBoxes();
				altaActividadDeportivaInternalFrame.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_2.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Consultas");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consulta Usuario");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioInternalFrame.iniciarlizarComboBoxes();
				consultaUsuarioInternalFrame.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JMenu mnNewMenu_2 = new JMenu("Modificar");
		mnNewMenu_2.setForeground(Color.BLACK);
		mnNewMenu_2.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
	}
}
