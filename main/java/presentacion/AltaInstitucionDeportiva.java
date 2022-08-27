package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import excepciones.InstitucionDeportivaRepetidaExcepcion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AltaInstitucionDeportiva extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaInstitucionDeportiva frame = new AltaInstitucionDeportiva(null);
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
	public AltaInstitucionDeportiva(IControlador iCon) {
		setClosable(true);
		setTitle("Alta Institucion Deportiva");
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel.setBounds(198, 163, 174, 34);
		getContentPane().add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(373, 163, 198, 34);
		getContentPane().add(textFieldNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setToolTipText("Descripcion");
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(198, 208, 174, 34);
		getContentPane().add(lblNewLabel_1);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(373, 208, 198, 34);
		getContentPane().add(textFieldDescripcion);
		
		JLabel lblNewLabel_1_1 = new JLabel("URL");
		lblNewLabel_1_1.setToolTipText("URL");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(198, 253, 174, 34);
		getContentPane().add(lblNewLabel_1_1);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(373, 253, 198, 34);
		getContentPane().add(textFieldURL);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaInstitucionDeportivaAceptarPerformed(e);
			}
		});
		btnNewButton.setBounds(214, 339, 134, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelarsalir = new JButton("Cancelar/Salir");
		btnCancelarsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelarsalir.setBounds(414, 339, 134, 52);
		getContentPane().add(btnCancelarsalir);

	}
	
	
	protected void altaInstitucionDeportivaAceptarPerformed(ActionEvent arg0) {
		String nombre = this.textFieldNombre.getText();
		String desc = this.textFieldDescripcion.getText();
		String url = this.textFieldURL.getText();
		List<DtActividadDeportiva> dtActDep = new ArrayList<>();
		List<DtProfesor> dtProf = new ArrayList<>();
		DtInstitucionDeportiva dtInstDep = new DtInstitucionDeportiva(nombre,desc,url,dtActDep,dtProf);
		if(checkFormulario()) {
			try {
				iCon.AltaInsitucionDeportiva(dtInstDep);
				JOptionPane.showMessageDialog(this, "Institucion agregada con éxito!", "Alta Institucion Deportiva",
		                JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
			}catch (InstitucionDeportivaRepetidaExcepcion e) {
		        JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Institucion Deportiva", JOptionPane.ERROR_MESSAGE);
		    }
		}
	}
	
	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldDescripcion.setText("");
		textFieldURL.setText("");
	}
	
	private boolean checkFormulario() {
        String nombre = this.textFieldNombre.getText();
        String desc = this.textFieldDescripcion.getText();
        String url = this.textFieldURL.getText();
        if (nombre.isEmpty() || desc.isEmpty() || url.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Institucion Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
	}
        
}
