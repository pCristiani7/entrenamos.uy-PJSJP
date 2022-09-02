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
	private ModificarActividadDeportiva modificarDatosActividadInternalFrame;
	private ModificarInstitucionDeportiva modificarDatosInstitucionInternalFrame;
	private ConsultaDictadoClase consultaClaseInternalFrame;
	private RankingActividades rankingActividadesInternalFrame;
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
		
		modificarDatosActividadInternalFrame = new ModificarActividadDeportiva(iCon);
		modificarDatosActividadInternalFrame.setMaximizable(false);
		jInternalFrameSize = modificarDatosActividadInternalFrame.getSize();
		modificarDatosActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		modificarDatosActividadInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(modificarDatosActividadInternalFrame);
		
		modificarDatosInstitucionInternalFrame = new ModificarInstitucionDeportiva(iCon);
		modificarDatosInstitucionInternalFrame.setMaximizable(false);
		jInternalFrameSize = modificarDatosInstitucionInternalFrame.getSize();
		modificarDatosInstitucionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		modificarDatosInstitucionInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(modificarDatosInstitucionInternalFrame);
		
		consultaClaseInternalFrame = new ConsultaDictadoClase(iCon);
		consultaClaseInternalFrame.setMaximizable(false);
		jInternalFrameSize = consultaClaseInternalFrame.getSize();
		consultaClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		consultaClaseInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(consultaClaseInternalFrame);
		
		rankingActividadesInternalFrame = new RankingActividades(iCon);
		rankingActividadesInternalFrame.setMaximizable(false);
		jInternalFrameSize = rankingActividadesInternalFrame.getSize();
		rankingActividadesInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height - jInternalFrameSize.height)/6);
		rankingActividadesInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(rankingActividadesInternalFrame);
		
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Cristiani\\eclipse-workspace\\entrenamos.uy\\images\\entrenamos.uy.png"));
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
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Consulta Dictado de Clase");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultaClaseInternalFrame.inicializarComboBoxInstituciones()) {
					if(consultaClaseInternalFrame.inicializarComboBoxActividadesAsociadas()) {
						if(consultaClaseInternalFrame.inicializarComboBoxClases()) { 
							consultaClaseInternalFrame.setVisible(true);
							}else {
							JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Clases en el sistema!", "Consulta Dictado de Clase",
				                    JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Actividades en el sistema!", "Consulta Dictado de Clase",
			                    JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Instituciones en el sistema!", "Consulta Dictado de Clase",
		                    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenuRanking = new JMenu("Ranking");
		mnNewMenuRanking.setForeground(Color.BLACK);
		mnNewMenuRanking.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnNewMenuRanking);
		
		JMenuItem mntmNewMenuItem_8_1 = new JMenuItem("Ranking Clases");
		mntmNewMenuItem_8_1.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenuRanking.add(mntmNewMenuItem_8_1);
		
		JMenuItem mntmNewMenuItem_10_1 = new JMenuItem("Ranking Actividades Deportivas");
		mntmNewMenuItem_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rankingActividadesInternalFrame.chargeRanking();
				rankingActividadesInternalFrame.setVisible(true);
			}
		});
		mntmNewMenuItem_10_1.setFont(new Font("Dialog", Font.BOLD, 12));
		mnNewMenuRanking.add(mntmNewMenuItem_10_1);
		
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
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Modificar Actividad Deportiva");
		mntmNewMenuItem_9.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificarDatosActividadInternalFrame.inicializarComboBoxActividadesAsociadas()) {
					modificarDatosActividadInternalFrame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Actividades en el sistema!", "Modificar Actividad",
		                    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Modificar Institucion Deportiva");
		mntmNewMenuItem_10.setFont(new Font("Dialog", Font.BOLD, 12));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificarDatosInstitucionInternalFrame.inicializarComboBoxInstituciones()) {
					modificarDatosInstitucionInternalFrame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(frmEntrenamosUy, "No hay Instituciones en el sistema!", "Modificar Institucion",
		                    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		mnNewMenu_2.add(mntmNewMenuItem_9);
	}
}
