package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import interfaces.Fabrica;
import interfaces.IControlador;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PrincipalPage {

	private JFrame frmEntrenamosUy;
	private AltaUsuario altaUsuarioInternalFrame;
	private ConsultaUsuario consultaUsuarioInternalFrame;
	private ConsultaActividadDeportiva consultaActividadDeportivaInternalFrame;
	private AltaInstitucionDeportiva altaInstitucionDeportivaInternalFrame;
	private AltaActividadDeportiva altaActividadDeportivaInternalFrame;
	private AltaDictadoDeClase altaDictadoDeClaseInternalFrame;
	private RegistroAClase registroAClaseInternalFrame;
	private ModificarDatosUsuario modificarDatosUsuarioInternalFrame;
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
	 * @throws ParseException 
	 */
	public PrincipalPage() throws ParseException {
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
		
		altaDictadoDeClaseInternalFrame = new AltaDictadoDeClase(iCon);
		altaDictadoDeClaseInternalFrame.setIconifiable(false);
		altaDictadoDeClaseInternalFrame.setMaximizable(false);
		jInternalFrameSize = altaDictadoDeClaseInternalFrame.getSize();
		altaDictadoDeClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		altaDictadoDeClaseInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(altaDictadoDeClaseInternalFrame);
		
		registroAClaseInternalFrame = new RegistroAClase(iCon);
		registroAClaseInternalFrame.setIconifiable(false);
		registroAClaseInternalFrame.setMaximizable(false);
		jInternalFrameSize = registroAClaseInternalFrame.getSize();
		registroAClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		registroAClaseInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(registroAClaseInternalFrame);
		
		consultaActividadDeportivaInternalFrame = new ConsultaActividadDeportiva(iCon);
		consultaActividadDeportivaInternalFrame.setIconifiable(false);
		consultaActividadDeportivaInternalFrame.setMaximizable(false);
		jInternalFrameSize = consultaActividadDeportivaInternalFrame.getSize();
		consultaActividadDeportivaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		consultaActividadDeportivaInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(consultaActividadDeportivaInternalFrame);
		
		modificarDatosUsuarioInternalFrame = new ModificarDatosUsuario(iCon);
		modificarDatosUsuarioInternalFrame.setMaximizable(false);
		jInternalFrameSize = modificarDatosUsuarioInternalFrame.getSize();
		modificarDatosUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		consultaActividadDeportivaInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(modificarDatosUsuarioInternalFrame);
		
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\\\Users\\\\59894\\\\eclipse-workspace\\\\entrenamos.uy/entrenamos.uy.png"));
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
				if(!altaUsuarioInternalFrame.inicializarComboBoxes()) {
					JOptionPane.showMessageDialog(frmEntrenamosUy, "Atencion para Profesor: No hay Instituciones registradas!", "Alta Usuario",
				            JOptionPane.WARNING_MESSAGE);	
				}
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
				if(altaActividadDeportivaInternalFrame.iniciarlizarComboBoxes())
					altaActividadDeportivaInternalFrame.setVisible(true);
				else {
					JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Instituciones en el sistema!", "Alta Actividad Deportiva",
		                    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_2.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Alta Dictado de Clase");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(altaDictadoDeClaseInternalFrame.inicializarComboBoxInstitucionDeportiva()) {
					if(altaDictadoDeClaseInternalFrame.inicializarComboBoxActividadesAsociadas()) {
						if(altaDictadoDeClaseInternalFrame.inicializarComboBoxProfesores()) {
							altaDictadoDeClaseInternalFrame.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Profesores en el sistema!", "Alta Dictado de Clase",
				                    JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Actividades en el sistema!", "Alta Dictado de Clase",
			                    JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Instituciones en el sistema!", "Alta Dictado de Clase",
		                    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem_4.setForeground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Registrar a Clase");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(registroAClaseInternalFrame.inicializarComboBoxInstituciones()) {
						if(registroAClaseInternalFrame.inicializarComboBoxActividadesAsociadas()) {
							if(registroAClaseInternalFrame.inicializarComboBoxClases()) {
								if(registroAClaseInternalFrame.inicializarComboBoxSocios()) {
									registroAClaseInternalFrame.setVisible(true);
								}else {
									JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Socios en el sistema!", "Alta Dictado de Clase",
						                    JOptionPane.ERROR_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Clases en el sistema!", "Alta Dictado de Clase",
					                    JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Actividades en el sistema!", "Alta Dictado de Clase",
				                    JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Instituciones en el sistema!", "Alta Dictado de Clase",
			                    JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		
		mntmNewMenuItem_6.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem_6.setForeground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_1 = new JMenu("Consultas");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consulta Usuario");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultaUsuarioInternalFrame.inicializarComboBoxes()) {
						consultaUsuarioInternalFrame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Usuarios en el sistema!", "Consulta Usuario",
		                    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Consulta Actividad Deportiva");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultaActividadDeportivaInternalFrame.inicializarComboBoxInstitucionDeportiva()) {
					if(consultaActividadDeportivaInternalFrame.inicializarComboBoxActividadesAsociadas()) {
						consultaActividadDeportivaInternalFrame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Actividades en el sistema!", "Consulta Actividad Deportiva",
			                    JOptionPane.ERROR_MESSAGE);
					}
				}else {
				JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Instituciones en el sistema!", "Consulta Actividad Deportiva",
	                    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem_5.setForeground(Color.BLACK);
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Modificar");
		mnNewMenu_2.setForeground(Color.BLACK);
		mnNewMenu_2.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Modificar Usuario");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificarDatosUsuarioInternalFrame.inicializarComboBoxes()) {
					modificarDatosUsuarioInternalFrame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Usuarios en el sistema!", "Modificar Usuario",
		                    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_3 = new JMenu("Datos");
		mnNewMenu_3.setForeground(Color.BLACK);
		mnNewMenu_3.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Cargar Pruebas");
		mntmNewMenuItem_7.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem_7.setForeground(Color.BLACK);
		mnNewMenu_3.add(mntmNewMenuItem_7);
	}
}
