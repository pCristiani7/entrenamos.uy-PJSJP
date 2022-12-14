package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControlador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class AltaUsuario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldDescripcion;
	private JTextField textFieldBiografia;
	private JTextField textFieldURL;
	private JTextField textFieldPassword;
	private JRadioButton rdbtnSocio;
	private JRadioButton rdbtnProfesor;
	private JDateChooser dateChooser;
	private JComboBox<String> comboBoxInstitucionDeportiva;
	private JButton btnNewButton;
	private String filename;
    private byte[] profileImage = null;
	private IControlador iCon;
	private JLabel lblImage;

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

	public AltaUsuario(IControlador iCon) throws ParseException {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		this.iCon = iCon;
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Alta Usuario");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel.setBounds(42, 49, 174, 34);
		getContentPane().add(lblNewLabel);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(309, 49, 198, 34);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(42, 94, 174, 34);
		getContentPane().add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(309, 94, 198, 34);
		getContentPane().add(textFieldNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(42, 139, 174, 34);
		getContentPane().add(lblNewLabel_1_1);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(309, 139, 198, 34);
		getContentPane().add(textFieldApellido);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(42, 184, 174, 34);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(309, 184, 198, 34);
		getContentPane().add(textFieldEmail);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fecha Nacimiento");
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(42, 229, 219, 34);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Institucion Deportiva");
		lblNewLabel_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1_1_2.setBounds(42, 319, 259, 34);
		getContentPane().add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Descripcion");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1_1_2_1.setBounds(42, 364, 259, 34);
		getContentPane().add(lblNewLabel_1_1_1_2_1);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(309, 364, 198, 34);
		getContentPane().add(textFieldDescripcion);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Biografia (Opcional)");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1_1_2_1_1.setBounds(42, 409, 259, 34);
		getContentPane().add(lblNewLabel_1_1_1_2_1_1);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setColumns(10);
		textFieldBiografia.setBounds(309, 409, 198, 34);
		getContentPane().add(textFieldBiografia);
		
		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("URL (Opcional)");
		lblNewLabel_1_1_1_2_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1_1_2_1_1_1.setBounds(42, 454, 259, 34);
		getContentPane().add(lblNewLabel_1_1_1_2_1_1_1);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(309, 460, 198, 34);
		getContentPane().add(textFieldURL);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(309, 504, 198, 34);
		getContentPane().add(textFieldPassword);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioAceptarActionPerformed(e);
			}
		});
		
		btnNewButton.setBounds(583, 196, 134, 52); 
		getContentPane().add(btnNewButton);
		
		JButton btnLoadImage = new JButton("Seleccionar");
        btnLoadImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                cargarImg(f);
            }
        });
        btnLoadImage.setBounds(608, 517, 109, 21);
        getContentPane().add(btnLoadImage);
		
		JButton btnCancelar = new JButton("Cancelar/Salir");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		
		btnCancelar.setBounds(583, 283, 134, 52);
		getContentPane().add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(309, 274, 198, 34);
		getContentPane().add(panel);
		
		lblImage = new JLabel("");
        lblImage.setBounds(583, 379, 134, 159);
        getContentPane().add(lblImage);
		
		JLabel lblNewLabelTipo = new JLabel("Tipo");
		lblNewLabelTipo.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelTipo.setBounds(42, 274, 259, 34);
		getContentPane().add(lblNewLabelTipo);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSocio.setSelected(false);
				if(profesoresThere()) {
					btnNewButton.setEnabled(true);
					rdbtnProfesor.setSelected(true);
					comboBoxInstitucionDeportiva.setEnabled(true);
					textFieldDescripcion.setEnabled(true);
					textFieldBiografia.setEnabled(true);
					textFieldURL.setEnabled(true);
				}else {
					btnNewButton.setEnabled(false);
					rdbtnProfesor.setSelected(true);
					comboBoxInstitucionDeportiva.setEnabled(false);
					textFieldDescripcion.setEnabled(false);
					textFieldBiografia.setEnabled(false);
					textFieldURL.setEnabled(false);
				}
			}
		});
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.setSelected(true);
		rdbtnSocio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(true);
				rdbtnSocio.setSelected(true);
				rdbtnProfesor.setSelected(false);
				comboBoxInstitucionDeportiva.setEnabled(false);
				textFieldDescripcion.setEnabled(false);
				textFieldBiografia.setEnabled(false);
				textFieldURL.setEnabled(false);
			}
		});
		panel.add(rdbtnSocio);
		panel.add(rdbtnProfesor);
		
		comboBoxInstitucionDeportiva = new JComboBox<String>();
		comboBoxInstitucionDeportiva.setBounds(309, 319, 198, 34);
		getContentPane().add(comboBoxInstitucionDeportiva);
		
		dateChooser = new JDateChooser();
		Calendar ca = new GregorianCalendar();
		String day = ca.get(Calendar.DAY_OF_MONTH) + "";
		String month = ca.get(Calendar.MONTH) + 1 + "";
		String year = ca.get(Calendar.YEAR) + "";
		String dd = year + "-" + month + "-" + day;
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
		dateChooser.setDate(date);
		dateChooser.setBounds(309, 229, 198, 34);
		getContentPane().add(dateChooser);
		
		
	}
	
	public void cargarImg(File f) {
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
        lblImage.setIcon(imageIcon);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum;(readNum = fis.read(buf))!=-1;){
                bos.write(buf,0,readNum);
            }
             profileImage = bos.toByteArray();
            fis.close();
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null,e2);
        }
    }
	
	public boolean inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelInstituciones = new DefaultComboBoxModel<String>(iCon.listarInstituciones());
		if(modelInstituciones.getSize() == 0)
			return false;
		else {
			comboBoxInstitucionDeportiva.setModel(modelInstituciones);
			return true;
		}
	}
	
	protected void altaUsuarioAceptarActionPerformed(ActionEvent arg0) {
		String password = this.textFieldPassword.getText();
		String nickname = this.textFieldNickname.getText();
        String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        String email = this.textFieldEmail.getText();
        Date fechaNac =dateChooser.getDate();
        String institucionDeportiva = (String) this.comboBoxInstitucionDeportiva.getSelectedItem();
        String descripcion = this.textFieldDescripcion.getText();
        String biografia = this.textFieldBiografia.getText();
        String url = this.textFieldURL.getText();
        
	        if(rdbtnSocio.isSelected()) {
	        	if(checkFormulario()) {
	        		DtSocio dtSocio = new DtSocio(nickname,nombre,apellido,email,fechaNac,profileImage);
	        		try {
		        		this.iCon.AltaUsuario(dtSocio,password);
		                JOptionPane.showMessageDialog(this, "El Socio se ha creado con ?xito", "Alta Usuario",
		                        JOptionPane.INFORMATION_MESSAGE);
		                limpiarFormulario();
		                setVisible(false);
	        		}catch (UsuarioRepetidoExcepcion e) {
	                    JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
	                }
	        	}
	        }else if(rdbtnProfesor.isSelected()) {
	        	if(checkFormulario()) {
		        	DtProfesor dtProf = new DtProfesor(nickname,nombre,apellido,email,fechaNac,descripcion,biografia,url,institucionDeportiva,profileImage);
		        	try {
			        	this.iCon.AltaUsuario(dtProf,password);
			        	JOptionPane.showMessageDialog(this, "El Profesor se ha creado con ?xito", "Alta Usuario",
			                    JOptionPane.INFORMATION_MESSAGE);
			        	limpiarFormulario();
			        	setVisible(false);
		        	} catch (UsuarioRepetidoExcepcion e) {
	                    JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
	                }
		        }
	        }
        } 
	
	private boolean checkFormulario() {
        String nickname = this.textFieldNickname.getText();
        String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        String email = this.textFieldEmail.getText();
        String fechaNac = this.dateChooser.getDateFormatString();
        String institucionDeportiva = (String) this.comboBoxInstitucionDeportiva.getSelectedItem();
        String descripcion = this.textFieldDescripcion.getText();
        if(rdbtnSocio.isSelected()) {
	        if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || email.isEmpty()|| fechaNac.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vac?os", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	    }else if(rdbtnProfesor.isSelected()) {
	    	if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()|| fechaNac.isEmpty() || institucionDeportiva.isEmpty() || descripcion.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vac?os", "Alta Usuario",
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
		textFieldDescripcion.setText("");
		textFieldNickname.setText("");
		textFieldBiografia.setText("");
		textFieldURL.setText("");
		rdbtnProfesor.setSelected(false);
		rdbtnSocio.setSelected(true);
	}
	
	public boolean profesoresThere() {
		ArrayList<String> profesores = iCon.listarProfesoresFront();
		if(profesores.size() > 0 ) {
			return true;
		}else {
			return false;
		}
	}
	
	public void inicializar() {
		comboBoxInstitucionDeportiva.setEnabled(false);
		textFieldDescripcion.setEnabled(false);
		textFieldBiografia.setEnabled(false);
		textFieldURL.setEnabled(false);
	}
	
}
