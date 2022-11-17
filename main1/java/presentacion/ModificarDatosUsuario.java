package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarDatosUsuario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDescripcion;
	private JTextField textFieldBiografia;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblFecha;
	private JLabel lblDescripcion;
	private JLabel lblBiografia;
	private JLabel lblURL;
	private JComboBox<String> comboBoxUsuarios;
	private JDateChooser dateChooser;
	private JButton btnNewButton;
	private JTextField textFieldURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosUsuario frame = new ModificarDatosUsuario(null);
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
	public ModificarDatosUsuario(IControlador iCon) {
		setTitle("Modificar Usuario");
		setClosable(true);
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblUsuarios.setBounds(275, 22, 229, 36);
		getContentPane().add(lblUsuarios);
		
		comboBoxUsuarios = new JComboBox<String>();
		comboBoxUsuarios.setBounds(275, 69, 229, 36);
		getContentPane().add(comboBoxUsuarios);
		
		JButton btnListar = new JButton("Seleccionar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setTextFieldOldUser();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnListar.setBounds(323, 116, 134, 36);
		getContentPane().add(btnListar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(383, 185, 229, 36);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setVisible(false);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(383, 236, 229, 36);
		textFieldApellido.setVisible(false);
		getContentPane().add(textFieldApellido);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(383, 330, 229, 36);
		textFieldDescripcion.setVisible(false);
		getContentPane().add(textFieldDescripcion);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setColumns(10);
		textFieldBiografia.setBounds(383, 377, 229, 36);
		textFieldBiografia.setVisible(false);
		getContentPane().add(textFieldBiografia);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNombre.setBounds(143, 185, 229, 36);
		lblNombre.setVisible(false);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblApellido.setBounds(144, 236, 229, 36);
		lblApellido.setVisible(false);
		getContentPane().add(lblApellido);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblFecha.setBounds(143, 283, 229, 36);
		lblFecha.setVisible(false);
		getContentPane().add(lblFecha);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblDescripcion.setBounds(143, 330, 229, 36);
		lblDescripcion.setVisible(false);
		getContentPane().add(lblDescripcion);
		
		lblBiografia = new JLabel("Biografia");
		lblBiografia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiografia.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblBiografia.setBounds(144, 377, 229, 36);
		lblBiografia.setVisible(false);
		getContentPane().add(lblBiografia);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarUsuarioActionPerformed(e);
				setOffAll();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBounds(323, 487, 134, 52);
		btnNewButton.setVisible(false);
		getContentPane().add(btnNewButton);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(383, 283, 229, 36);
		dateChooser.setVisible(false);
		getContentPane().add(dateChooser);
		
		lblURL = new JLabel("URL");
		lblURL.setHorizontalAlignment(SwingConstants.CENTER);
		lblURL.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblURL.setBounds(143, 425, 229, 36);
		lblURL.setVisible(false);
		getContentPane().add(lblURL);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(383, 424, 229, 37);
		textFieldURL.setVisible(false);
		textFieldURL.setColumns(10);
		getContentPane().add(textFieldURL);
	}
	
	public void setTextFieldOldUser() throws ParseException {
		String nickname = comboBoxUsuarios.getSelectedItem().toString();
		DtUsuario dtUsr = iCon.ConsultaUsuario(nickname);
		
		if(dtUsr instanceof DtSocio) {
			DtSocio dtS = iCon.findSocio(nickname);
			this.textFieldNombre.setText(dtS.getNombre());
			this.textFieldApellido.setText(dtS.getApellido());

			String d = dtS.getFechaNac().toString();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
			dateChooser.setDate(date);
			
			
			setOffProfesor();
			setOnSocio();

		}else if(dtUsr instanceof DtProfesor) {
			DtProfesor dtP = iCon.findProfesor(nickname);
			this.textFieldNombre.setText(dtP.getNombre());
			this.textFieldApellido.setText(dtP.getApellido());
			
			String d = dtP.getFechaNac().toString();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
			dateChooser.setDate(date);
			
			this.textFieldDescripcion.setText(dtP.getDescripcion());
			this.textFieldBiografia.setText(dtP.getBiografia());
			this.textFieldURL.setText(dtP.getSitioweb());
			
			setOffSocio();
			setOnProfesor();
		}
	}
	
	public void setOnSocio(){
		this.textFieldNombre.setVisible(true);
		this.lblNombre.setVisible(true);
		this.lblApellido.setVisible(true);
		this.lblFecha.setVisible(true);
		this.textFieldApellido.setVisible(true);
		this.dateChooser.setVisible(true);
		this.btnNewButton.setVisible(true);
	}
	public void setOffSocio(){
		this.textFieldNombre.setVisible(false);
		this.lblNombre.setVisible(false);
		this.lblApellido.setVisible(false);
		this.lblFecha.setVisible(false);
		this.textFieldApellido.setVisible(false);
		this.dateChooser.setVisible(false);
		this.btnNewButton.setVisible(false);
	}
	
	public void setOnProfesor(){
		this.textFieldNombre.setVisible(true);
		this.lblNombre.setVisible(true);
		this.lblApellido.setVisible(true);
		this.lblFecha.setVisible(true);
		this.lblBiografia.setVisible(true);
		this.lblDescripcion.setVisible(true);
		this.textFieldApellido.setVisible(true);
		this.dateChooser.setVisible(true);
		this.lblURL.setVisible(true);
		this.btnNewButton.setVisible(true);
		this.textFieldDescripcion.setVisible(true);
		this.textFieldBiografia.setVisible(true);
		this.textFieldURL.setVisible(true);
	}
	public void setOffProfesor(){
		this.textFieldNombre.setVisible(false);
		this.lblNombre.setVisible(false);
		this.lblApellido.setVisible(false);
		this.lblFecha.setVisible(false);
		this.lblBiografia.setVisible(false);
		this.lblDescripcion.setVisible(false);
		this.textFieldApellido.setVisible(false);
		this.dateChooser.setVisible(false);
		this.lblURL.setVisible(false);
		this.btnNewButton.setVisible(false);
		this.textFieldDescripcion.setVisible(false);
		this.textFieldBiografia.setVisible(false);
		this.textFieldURL.setVisible(false);
	}
	
	public void setOffAll(){
		this.textFieldNombre.setVisible(false);
		this.textFieldApellido.setVisible(false);
		this.textFieldDescripcion.setVisible(false);
		this.textFieldBiografia.setVisible(false);
		this.textFieldURL.setVisible(false);
		this.dateChooser.setVisible(false);
		this.lblNombre.setVisible(false);
		this.lblApellido.setVisible(false);
		this.lblFecha.setVisible(false);
		this.lblBiografia.setVisible(false);
		this.lblDescripcion.setVisible(false);
		this.lblURL.setVisible(false);
		this.btnNewButton.setVisible(false);
		setVisible(false);
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
	
	protected void modificarUsuarioActionPerformed(ActionEvent arg0) {
		DtUsuario dtUsr = iCon.ConsultaUsuario(comboBoxUsuarios.getSelectedItem().toString());
		if(dtUsr instanceof DtSocio) {
			DtSocio dtSOld = iCon.findSocio(comboBoxUsuarios.getSelectedItem().toString());
			String nickname = comboBoxUsuarios.getSelectedItem().toString();
			String nombre = this.textFieldNombre.getText();
			String apellido = this.textFieldApellido.getText();
			String mail = dtSOld.getEmail();
			Date fechaNac = dateChooser.getDate();
			DtSocio dtSNew = new DtSocio(nickname,nombre,apellido,mail,fechaNac,dtSOld.getProfileImage());
			if(iCon.ModificarDatosUsuario(dtSOld, dtSNew)) {
				JOptionPane.showMessageDialog(this, "Usuario modificado con �xito!", "Modificar Usuario",
		                JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "No se pudo modificar el Usuario!", "Modificar Usuario",
		                JOptionPane.ERROR_MESSAGE);
			}
		}else if(dtUsr instanceof DtProfesor) {
			DtProfesor dtPOld = iCon.findProfesor(comboBoxUsuarios.getSelectedItem().toString());
			String nickname = comboBoxUsuarios.getSelectedItem().toString();
			String nombre = this.textFieldNombre.getText();
			String apellido = this.textFieldApellido.getText();
			String mail = dtPOld.getEmail();
			Date fechaNac = dateChooser.getDate();
			String descripcion = this.textFieldDescripcion.getText();
			String biografia = this.textFieldBiografia.getText();
			String url = this.textFieldURL.getText();
			String inst = dtPOld.getInstitucionDeportiva();
			DtProfesor dtPNew = new DtProfesor(nickname,nombre,apellido,mail,fechaNac,descripcion,biografia,url,inst,dtPOld.getProfileImage());
			if(iCon.ModificarDatosUsuario(dtPOld, dtPNew)) {
				JOptionPane.showMessageDialog(this, "Usuario modificado con �xito!", "Modificar Usuario",
		                JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "No se pudo modificar el Usuario!", "Modificar Usuario",
		                JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
