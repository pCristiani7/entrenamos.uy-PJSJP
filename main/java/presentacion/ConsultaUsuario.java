package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import datatypes.DtUsuario;
import interfaces.IControlador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

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
		lblNewLabel.setBounds(34, 194, 229, 36);
		getContentPane().add(lblNewLabel);
		
		comboBoxUsuarios = new JComboBox<String>();
		comboBoxUsuarios.setBounds(34, 238, 229, 36);
		getContentPane().add(comboBoxUsuarios);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					inicializarInvisibles();
			}
		});
		btnConsultar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnConsultar.setBounds(86, 285, 134, 52); 
		getContentPane().add(btnConsultar);
		
		lblNewLabelNickname = new JLabel("Nickname");
		lblNewLabelNickname.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelNickname.setBounds(333, 128, 174, 34);
		lblNewLabelNickname.setVisible(false);
		getContentPane().add(lblNewLabelNickname);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNickname.setEditable(false);
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(555, 128, 198, 34);
		textFieldNickname.setVisible(false);
		getContentPane().add(textFieldNickname);
		
		lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelNombre.setBounds(333, 173, 174, 34);
		lblNewLabelNombre.setVisible(false);
		getContentPane().add(lblNewLabelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(555, 173, 198, 34);
		textFieldNombre.setVisible(false);
		getContentPane().add(textFieldNombre);
		
		lblNewLabelApellido = new JLabel("Apellido");
		lblNewLabelApellido.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelApellido.setBounds(333, 218, 174, 34);
		lblNewLabelApellido.setVisible(false);
		getContentPane().add(lblNewLabelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(555, 218, 198, 34);
		textFieldApellido.setVisible(false);
		getContentPane().add(textFieldApellido);
		
		lblNewLabelEmail = new JLabel("Email");
		lblNewLabelEmail.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelEmail.setBounds(333, 263, 174, 34);
		lblNewLabelEmail.setVisible(false);
		getContentPane().add(lblNewLabelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(555, 263, 198, 34);
		textFieldEmail.setVisible(false);
		getContentPane().add(textFieldEmail);
		
		lblNewLabelFechaNac = new JLabel("Fecha Nacimiento");
		lblNewLabelFechaNac.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelFechaNac.setBounds(333, 314, 219, 34);
		lblNewLabelFechaNac.setVisible(false);
		getContentPane().add(lblNewLabelFechaNac);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldFechaNac.setEditable(false);
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(555, 312, 198, 34);
		textFieldFechaNac.setVisible(false);
		getContentPane().add(textFieldFechaNac);

	}
	
	public void cargarDatos() {
		String nickname = comboBoxUsuarios.getSelectedItem().toString();
		DtUsuario dtUsr = iCon.ConsultaUsuario(nickname);
		this.textFieldNickname.setText(dtUsr.getNickname());
		this.textFieldNombre.setText(dtUsr.getNombre());
		this.textFieldApellido.setText(dtUsr.getApellido());
		this.textFieldEmail.setText(dtUsr.getEmail());
		this.textFieldFechaNac.setText(dtUsr.getFechaNac().toString());
	}

	public void inicializarInvisibles() {
		cargarDatos();
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
}
