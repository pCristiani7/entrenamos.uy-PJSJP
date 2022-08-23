package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import interfaces.IControlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AltaUsuario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldInstitucionDeportiva;
	private JTextField textFieldDescripcion;
	private JTextField textFieldBiografia;
	private JTextField textFieldURL;
	private JRadioButton rdbtnSocio;
	private JRadioButton rdbtnProfesor;
	private JCalendar calendar;
	private IControlador iCon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AltaUsuario(IControlador iCon) {
		this.iCon = iCon;
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Alta Usuario");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel.setBounds(42, 29, 174, 34);
		getContentPane().add(lblNewLabel);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(309, 29, 198, 34);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(42, 74, 174, 34);
		getContentPane().add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(309, 74, 198, 34);
		getContentPane().add(textFieldNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(42, 119, 174, 34);
		getContentPane().add(lblNewLabel_1_1);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(309, 119, 198, 34);
		getContentPane().add(textFieldApellido);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(42, 164, 174, 34);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(309, 164, 198, 34);
		getContentPane().add(textFieldEmail);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fecha Nacimiento");
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(42, 209, 219, 153);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Institucion Deportiva");
		lblNewLabel_1_1_1_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1_1_1_2.setBounds(42, 373, 259, 34);
		getContentPane().add(lblNewLabel_1_1_1_2);
		
		textFieldInstitucionDeportiva = new JTextField();
		textFieldInstitucionDeportiva.setColumns(10);
		textFieldInstitucionDeportiva.setBounds(309, 373, 198, 34);
		getContentPane().add(textFieldInstitucionDeportiva);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Descripcion");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1_1_1_2_1.setBounds(42, 418, 259, 34);
		getContentPane().add(lblNewLabel_1_1_1_2_1);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(309, 418, 198, 34);
		getContentPane().add(textFieldDescripcion);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Biografia (Opcional)");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1_1_1_2_1_1.setBounds(42, 463, 259, 34);
		getContentPane().add(lblNewLabel_1_1_1_2_1_1);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setColumns(10);
		textFieldBiografia.setBounds(309, 463, 198, 34);
		getContentPane().add(textFieldBiografia);
		
		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("URL (Opcional)");
		lblNewLabel_1_1_1_2_1_1_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1_1_1_2_1_1_1.setBounds(42, 508, 259, 34);
		getContentPane().add(lblNewLabel_1_1_1_2_1_1_1);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(309, 508, 198, 34);
		getContentPane().add(textFieldURL);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioAceptarActionPerformed(e);
			}
		});
		
		btnNewButton.setBounds(584, 386, 134, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar/Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		
		btnCancelar.setBounds(584, 473, 134, 52);
		getContentPane().add(btnCancelar);
		
		calendar = new JCalendar();
		calendar.setBounds(309, 209, 198, 153);
		getContentPane().add(calendar);
		
		JPanel panel = new JPanel();
		panel.setBounds(584, 119, 134, 79);
		getContentPane().add(panel);
		
		JLabel lblNewLabelTipo = new JLabel("Tipo");
		lblNewLabelTipo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabelTipo.setBounds(626, 74, 51, 34);
		getContentPane().add(lblNewLabelTipo);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSocio.setSelected(true);
				rdbtnProfesor.setSelected(false);
				textFieldInstitucionDeportiva.setEnabled(false);
				textFieldDescripcion.setEnabled(false);
				textFieldBiografia.setEnabled(false);
				textFieldURL.setEnabled(false);
			}
		});
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSocio.setSelected(false);
				rdbtnProfesor.setSelected(true);
				textFieldInstitucionDeportiva.setEnabled(true);
				textFieldDescripcion.setEnabled(true);
				textFieldBiografia.setEnabled(true);
				textFieldURL.setEnabled(true);
			}
		});
		rdbtnProfesor.setSelected(true);
		panel.add(rdbtnProfesor);
		panel.add(rdbtnSocio);
		
		
	}
	
	protected void altaUsuarioAceptarActionPerformed(ActionEvent arg0) {
		String nickname = this.textFieldNickname.getText();
        String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        String email = this.textFieldEmail.getText();
        Date fechaNac = this.calendar.getDate();
        String institucionDeportiva = this.textFieldInstitucionDeportiva.getText();
        String descripcion = this.textFieldDescripcion.getText();
        String biografia = this.textFieldBiografia.getText();
        String url = this.textFieldURL.getText();
        
        if(rdbtnSocio.isSelected()) {
        	if(checkFormulario()) {
        		DtSocio dtSocio = new DtSocio(nickname,nombre,apellido,email,fechaNac,null);
        		this.iCon.AltaUsuario(dtSocio);
                JOptionPane.showMessageDialog(this, "El Socio se ha creado con éxito", "Alta Usuario",
                        JOptionPane.INFORMATION_MESSAGE);
        	}
        }else if(rdbtnProfesor.isSelected()) {
        	if(checkFormulario()) {
	        	DtProfesor dtProf = new DtProfesor(nickname,nombre,apellido,email,fechaNac,institucionDeportiva,descripcion,biografia,url);
	        	this.iCon.AltaUsuario(dtProf);
	        	JOptionPane.showMessageDialog(this, "El Profesor se ha creado con éxito", "Alta Usuario",
	                    JOptionPane.INFORMATION_MESSAGE);
	        }
        }
        limpiarFormulario();
	}
	
	private boolean checkFormulario() {
        String nickname = this.textFieldNickname.getText();
        String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        String email = this.textFieldEmail.getText();
        String institucionDeportiva = this.textFieldInstitucionDeportiva.getText();
        String descripcion = this.textFieldDescripcion.getText();
        if(rdbtnSocio.isSelected()) {
	        if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	    }else if(rdbtnProfesor.isSelected()) {
	    	if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()|| institucionDeportiva.isEmpty() || descripcion.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	    }
		return closable;
	}
	
	private void limpiarFormulario() {
		textFieldNickname.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldEmail.setText("");
		textFieldInstitucionDeportiva.setText("");
		textFieldDescripcion.setText("");
		textFieldNickname.setText("");
		textFieldBiografia.setText("");
		textFieldURL.setText("");
	}
}
