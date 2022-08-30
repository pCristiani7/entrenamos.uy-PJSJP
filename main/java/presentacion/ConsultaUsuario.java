package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import interfaces.IControlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ConsultaUsuario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JComboBox<String> comboBoxUsuarios;
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldFechaNac;
	private JLabel lblNewLabelNickname;
	private JLabel lblNewLabelNombre;
	private JLabel lblNewLabelEmail;
	private JLabel lblNewLabelApellido;
	private JLabel lblNewLabelFechaNac;
	private JComboBox comboBoxActividadesDeportivas;
	private JLabel lblRegistroaClases;
	private JLabel lblClasesDictadas;
	private JComboBox comboBoxClasesDictadas;
	private JComboBox comboBoxRegistroClases;
	private JLabel lblAtividadesdeportivas;
	private JTextPane textPaneData;
	private JButton btnConsultarDepends;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario(null);
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
	public ConsultaUsuario(IControlador iCon) {
		setTitle("Consulta Usuario");
		setClosable(true);
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Usuarios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel.setBounds(31, 92, 229, 36);
		getContentPane().add(lblNewLabel);
		
		comboBoxUsuarios = new JComboBox<String>();
		comboBoxUsuarios.setBounds(20, 138, 229, 36);
		getContentPane().add(comboBoxUsuarios);

		lblNewLabelNickname = new JLabel("Nickname");
		lblNewLabelNickname.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelNickname.setBounds(289, 48, 174, 34);
		lblNewLabelNickname.setVisible(false);
		getContentPane().add(lblNewLabelNickname);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNickname.setEditable(false);
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(511, 48, 198, 34);
		textFieldNickname.setVisible(false);
		getContentPane().add(textFieldNickname);
		
		lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelNombre.setBounds(289, 93, 174, 34);
		lblNewLabelNombre.setVisible(false);
		getContentPane().add(lblNewLabelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(511, 93, 198, 34);
		textFieldNombre.setVisible(false);
		getContentPane().add(textFieldNombre);
		
		lblNewLabelApellido = new JLabel("Apellido");
		lblNewLabelApellido.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelApellido.setBounds(289, 138, 174, 34);
		lblNewLabelApellido.setVisible(false);
		getContentPane().add(lblNewLabelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(511, 138, 198, 34);
		textFieldApellido.setVisible(false);
		getContentPane().add(textFieldApellido);
		
		lblNewLabelEmail = new JLabel("Email");
		lblNewLabelEmail.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelEmail.setBounds(289, 183, 174, 34);
		lblNewLabelEmail.setVisible(false);
		getContentPane().add(lblNewLabelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(511, 183, 198, 34);
		textFieldEmail.setVisible(false);
		getContentPane().add(textFieldEmail);
		
		lblNewLabelFechaNac = new JLabel("Fecha Nacimiento");
		lblNewLabelFechaNac.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelFechaNac.setBounds(289, 234, 219, 34);
		lblNewLabelFechaNac.setVisible(false);
		getContentPane().add(lblNewLabelFechaNac);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldFechaNac.setEditable(false);
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(511, 232, 198, 34);
		textFieldFechaNac.setVisible(false);
		getContentPane().add(textFieldFechaNac);
		textFieldFechaNac.setVisible(false);
		
		lblClasesDictadas = new JLabel("Clases Dictadas");
		lblClasesDictadas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblClasesDictadas.setBounds(289, 289, 174, 52);
		lblClasesDictadas.setVisible(false);
		getContentPane().add(lblClasesDictadas);
		
		comboBoxActividadesDeportivas = new JComboBox();
		comboBoxActividadesDeportivas.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxActividadesDeportivas.setBounds(289, 431, 219, 41);
		comboBoxActividadesDeportivas.setVisible(false);
		getContentPane().add(comboBoxActividadesDeportivas);
		
		lblRegistroaClases = new JLabel("Registro a Clases");
		lblRegistroaClases.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblRegistroaClases.setBounds(511, 289, 198, 52);
		lblRegistroaClases.setVisible(false);
		getContentPane().add(lblRegistroaClases);
		
		comboBoxClasesDictadas = new JComboBox();
		comboBoxClasesDictadas.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxClasesDictadas.setBounds(289, 340, 174, 41);
		comboBoxClasesDictadas.setVisible(false);
		getContentPane().add(comboBoxClasesDictadas);
		
		comboBoxRegistroClases = new JComboBox();
		comboBoxRegistroClases.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxRegistroClases.setBounds(511, 340, 174, 41);
		comboBoxRegistroClases.setVisible(false);
		getContentPane().add(comboBoxRegistroClases);
		
		lblAtividadesdeportivas = new JLabel("ActividadesDeportivas");
		lblAtividadesdeportivas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblAtividadesdeportivas.setBounds(289, 385, 255, 36);
		lblAtividadesdeportivas.setVisible(false);
		getContentPane().add(lblAtividadesdeportivas);
		
		textPaneData = new JTextPane();
		textPaneData.setFont(new Font("Dialog", Font.PLAIN, 15));
		textPaneData.setEditable(false);
		textPaneData.setVisible(false);
		textPaneData.setBounds(20, 289, 219, 244);
		getContentPane().add(textPaneData);
		
		btnConsultarDepends = new JButton("Consultar");
		btnConsultarDepends.setFont(new Font("Dialog", Font.BOLD, 12));
		btnConsultarDepends.setBounds(551, 426, 134, 52);
		btnConsultarDepends.setVisible(false);
		getContentPane().add(btnConsultarDepends);
		

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname = comboBoxUsuarios.getSelectedItem().toString();
				DtUsuario dtUsr = iCon.ConsultaUsuario(nickname);
				if(dtUsr instanceof DtSocio) {
					lblAtividadesdeportivas.setVisible(false);
					comboBoxClasesDictadas.setVisible(false);
					comboBoxActividadesDeportivas.setVisible(false);
					lblClasesDictadas.setVisible(false);
					comboBoxRegistroClases.setVisible(true);
					lblRegistroaClases.setVisible(true);
					DtSocio dtS = (DtSocio) dtUsr;
					inicializarInvisiblesSocio(dtS);
				}else if(dtUsr instanceof DtProfesor) {
					lblAtividadesdeportivas.setVisible(true);
					comboBoxClasesDictadas.setVisible(true);
					comboBoxActividadesDeportivas.setVisible(true);
					lblClasesDictadas.setVisible(true);
					comboBoxRegistroClases.setVisible(false);
					lblRegistroaClases.setVisible(false);
					DtProfesor dtP = (DtProfesor) dtUsr;
					inicializarInvisiblesProfesor(dtP);
				}
			}
		});
		btnConsultar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnConsultar.setBounds(70, 178, 134, 52); 
		getContentPane().add(btnConsultar);
		

	}
	
	public void cargarDatosSocio(DtSocio dtS) {
		this.textFieldNickname.setText(dtS.getNickname());
		this.textFieldNombre.setText(dtS.getNombre());
		this.textFieldApellido.setText(dtS.getApellido());
		this.textFieldEmail.setText(dtS.getEmail());
		this.textFieldFechaNac.setText(dtS.getFechaNac().toString());
	}
	
	public void cargarDatosProfesor(DtProfesor dtP) {
		this.textFieldNickname.setText(dtP.getNickname());
		this.textFieldNombre.setText(dtP.getNombre());
		this.textFieldApellido.setText(dtP.getApellido());
		this.textFieldEmail.setText(dtP.getEmail());
		this.textFieldFechaNac.setText(dtP.getFechaNac().toString());
	}

	public void inicializarInvisiblesProfesor(DtProfesor p) {
		cargarDatosProfesor(p);
		this.textFieldNickname.setVisible(true);
		this.textFieldNombre.setVisible(true);
		this.textFieldApellido.setVisible(true);
		this.textFieldEmail.setVisible(true);
		this.textFieldFechaNac.setVisible(true);
		this.lblNewLabelNickname.setVisible(true);
		this.lblNewLabelNombre.setVisible(true);
		this.lblNewLabelApellido.setVisible(true);
		this.lblNewLabelEmail.setVisible(true);
		this.lblNewLabelFechaNac.setVisible(true);
		this.lblAtividadesdeportivas.setVisible(true);
		this.comboBoxClasesDictadas.setVisible(true);
		this.comboBoxActividadesDeportivas.setVisible(true);
		this.lblClasesDictadas.setVisible(true);
		this.btnConsultarDepends.setVisible(true);
	}
	
	public void inicializarInvisiblesSocio(DtSocio s) {
		cargarDatosSocio(s);
		this.textFieldNickname.setVisible(true);
		this.textFieldNombre.setVisible(true);
		this.textFieldApellido.setVisible(true);
		this.textFieldEmail.setVisible(true);
		this.textFieldFechaNac.setVisible(true);
		this.lblNewLabelNickname.setVisible(true);
		this.lblNewLabelNombre.setVisible(true);
		this.lblNewLabelFechaNac.setVisible(true);
		this.lblNewLabelApellido.setVisible(true);
		this.lblNewLabelEmail.setVisible(true);
		this.comboBoxRegistroClases.setVisible(true);
		this.lblRegistroaClases.setVisible(true);
		this.btnConsultarDepends.setVisible(true);
	}
		
	public boolean inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelUsr = new DefaultComboBoxModel<String>(iCon.listarUsuarios());
		if(modelUsr.getSize() == 0)
			return false;
		else {
			comboBoxUsuarios.setModel(modelUsr);
			return true;
		}
	}
	
	public boolean inicializarComboBoxRegistros() {
		String s = comboBoxUsuarios.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelUsr = new DefaultComboBoxModel<String>(iCon.listarRegistrosSocio(s));
		if(modelUsr.getSize() == 0)
			return false;
		else {
			comboBoxRegistroClases.setModel(modelUsr);
			return true;
		}
	}
	
	public boolean inicializarComboBoxClasesDictadas() {
		String s = comboBoxUsuarios.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelUsr = new DefaultComboBoxModel<String>(iCon.listarRegistrosSocio(s));
		if(modelUsr.getSize() == 0)
			return false;
		else {
			comboBoxClasesDictadas.setModel(modelUsr);
			return true;
		}
	}
}
