package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import datatypes.DtActividadDeportiva;
import datatypes.DtInstitucionDeportiva;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import excepciones.InstitucionDeportivaRepetidaExcepcion;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class AltaActividadDeportiva extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JDateChooser dateChooser;
	private JComboBox<String> comboBoxInstitucionDeportiva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaActividadDeportiva frame = new AltaActividadDeportiva(null);
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
	public AltaActividadDeportiva(IControlador iCon) {
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 22));
		this.iCon = iCon;
		setClosable(true);
		setTitle("Alta Actividad Deportiva");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabelInstitucionDeportiva = new JLabel("Institucion Deportiva");
		lblNewLabelInstitucionDeportiva.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva.setBounds(148, 96, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva);
		
		comboBoxInstitucionDeportiva = new JComboBox<String>();
		comboBoxInstitucionDeportiva.setBounds(415, 96, 198, 34);
		getContentPane().add(comboBoxInstitucionDeportiva);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNombre.setBounds(148, 141, 259, 34);
		getContentPane().add(lblNombre);
		
		JLabel lblNewLabelInstitucionDeportiva_1_1 = new JLabel("Descripcion");
		lblNewLabelInstitucionDeportiva_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva_1_1.setBounds(148, 186, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva_1_1);
		
		JLabel lblNewLabelInstitucionDeportiva_1_1_1 = new JLabel("Duracion (minutos)");
		lblNewLabelInstitucionDeportiva_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva_1_1_1.setBounds(148, 231, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva_1_1_1);
		
		JLabel lblNewLabelInstitucionDeportiva_1_1_1_1 = new JLabel("Costo ($)");
		lblNewLabelInstitucionDeportiva_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva_1_1_1_1.setBounds(148, 276, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fecha de Registro");
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel_1_1_1_1.setBounds(148, 321, 219, 34);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(415, 321, 198, 34);
		getContentPane().add(dateChooser);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(415, 141, 199, 34);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(414, 186, 199, 34);
		getContentPane().add(textFieldDescripcion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(414, 231, 199, 34);
		getContentPane().add(textFieldDuracion);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(414, 276, 199, 34);
		getContentPane().add(textFieldCosto);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBounds(218, 480, 134, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar/Salir");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(450, 480, 134, 52);
		getContentPane().add(btnCancelar);

	}
	
	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldDescripcion.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
	}
	
	protected void altaActividadDeportivaAceptarPerformed(ActionEvent arg0) {
		String instDep = this.comboBoxInstitucionDeportiva.getSelectedItem().toString();
		String nombre = this.textFieldNombre.getText();
        String desc = this.textFieldDescripcion.getText();
        int duracion = Integer.parseInt(this.textFieldDuracion.getText());
        float costo = Float.parseFloat(this.textFieldCosto.getText());
        Date fechaReg = (Date) this.dateChooser.getDate();
		DtActividadDeportiva dtActDep = new DtActividadDeportiva(nombre,desc,duracion,costo,fechaReg,null,//agregar que le llega un dtInstitucionDeportiva !!!!);
		if(checkFormulario()) {
			try {
				iCon.AltaActividadDeportiva(dtActDep);
				JOptionPane.showMessageDialog(this, "Actividad agregada con éxito!", "Alta Actividad Deportiva",
		                JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
			}catch (ActividadDeportivaRepetidaExcepcion e) {
		        JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Institucion Deportiva", JOptionPane.ERROR_MESSAGE);
		    }
		}
	}
	
	private boolean checkFormulario() {
        String nombre = this.textFieldNombre.getText();
        String desc = this.textFieldDescripcion.getText();
        String duracion = this.textFieldDuracion.getText();
        String costo = this.textFieldCosto.getText();
        if (nombre.isEmpty() || desc.isEmpty() || duracion.isEmpty() || costo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Actividad Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelUsr = new DefaultComboBoxModel<String>(iCon.listarInstituciones());
		comboBoxInstitucionDeportiva.setModel(modelUsr);
	}
}
