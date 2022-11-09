package presentacion;

import javax.swing.JInternalFrame;

import interfaces.IControlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

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
	private JComboBox<String> comboBoxInstitucionDeportiva;

	/**
	 * Create the frame.
	 */
	public AltaActividadDeportiva(IControlador iCon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 22));
		this.iCon = iCon;
		setClosable(true);
		setTitle("Alta Actividad Deportiva");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabelInstitucionDeportiva = new JLabel("Institucion Deportiva");
		lblNewLabelInstitucionDeportiva.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva.setBounds(146, 137, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva);
		
		comboBoxInstitucionDeportiva = new JComboBox<String>();
		comboBoxInstitucionDeportiva.setBounds(413, 137, 198, 34);
		getContentPane().add(comboBoxInstitucionDeportiva);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNombre.setBounds(146, 182, 259, 34);
		getContentPane().add(lblNombre);
		
		JLabel lblNewLabelInstitucionDeportiva_1_1 = new JLabel("Descripcion");
		lblNewLabelInstitucionDeportiva_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva_1_1.setBounds(146, 227, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva_1_1);
		
		JLabel lblNewLabelInstitucionDeportiva_1_1_1 = new JLabel("Duracion (minutos)");
		lblNewLabelInstitucionDeportiva_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva_1_1_1.setBounds(146, 272, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva_1_1_1);
		
		JLabel lblNewLabelInstitucionDeportiva_1_1_1_1 = new JLabel("Costo ($)");
		lblNewLabelInstitucionDeportiva_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva_1_1_1_1.setBounds(146, 317, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva_1_1_1_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(413, 182, 199, 34);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(412, 227, 199, 34);
		getContentPane().add(textFieldDescripcion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(412, 272, 199, 34);
		getContentPane().add(textFieldDuracion);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(412, 317, 199, 34);
		getContentPane().add(textFieldCosto);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaActividadDeportivaAceptarPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBounds(204, 440, 134, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar/Salir");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(429, 440, 134, 52);
		getContentPane().add(btnCancelar);

	}
	
	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldDescripcion.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
	}
	
	protected void altaActividadDeportivaAceptarPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String instDep = this.comboBoxInstitucionDeportiva.getSelectedItem().toString();
			String nombre = this.textFieldNombre.getText();
	        String desc = this.textFieldDescripcion.getText();
	        int duracion = Integer.parseInt(this.textFieldDuracion.getText());
	        float costo = Float.parseFloat(this.textFieldCosto.getText());
	        Date fechaReg = new Date();
	       // List<DtClase> dtClase = new ArrayList<>();
			DtActividadDeportiva dtActDep = new DtActividadDeportiva(nombre,desc,duracion,costo,fechaReg,instDep);
			try {
				iCon.AltaActividadDeportiva(dtActDep);
				JOptionPane.showMessageDialog(this, "Actividad agregada con éxito!", "Alta Actividad Deportiva",
		                JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
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
        if (nombre.isEmpty() || desc.isEmpty() || duracion.equals(null) || costo.equals(null)) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Actividad Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
		return true;
	}
	
	public boolean iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelUsr = new DefaultComboBoxModel<String>(iCon.listarInstituciones());
		if(modelUsr.getSize() == 0)
			return false;
		else {
			comboBoxInstitucionDeportiva.setModel(modelUsr);
			return true;
		}
	}
}
