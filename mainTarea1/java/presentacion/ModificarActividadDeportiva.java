package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import datatypes.DtActividadDeportiva;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarActividadDeportiva extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JComboBox<String> comboBoxActividades;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JLabel lblDuracion;
	private JLabel lblCosto;
	private JButton btnModificar;
	private JLabel lblDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarActividadDeportiva frame = new ModificarActividadDeportiva(null);
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
	public ModificarActividadDeportiva(IControlador iCon) {
		setTitle("Modificar Actividad Deportiva");
		setClosable(true);
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblActividadesDeportivas = new JLabel("Actividades Deportivas");
		lblActividadesDeportivas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblActividadesDeportivas.setBounds(157, 42, 259, 34);
		getContentPane().add(lblActividadesDeportivas);
		
		comboBoxActividades = new JComboBox<String>();
		comboBoxActividades.setBounds(424, 42, 198, 34);
		getContentPane().add(comboBoxActividades);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextFields();
			}
		});
		btnSeleccionar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSeleccionar.setBounds(317, 103, 134, 52);
		getContentPane().add(btnSeleccionar);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(418, 220, 198, 40);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setVisible(false);
		textFieldDescripcion.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(418, 272, 198, 40);
		textFieldDuracion.setVisible(false);
		getContentPane().add(textFieldDuracion);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(418, 324, 198, 40);
		textFieldCosto.setVisible(false);
		getContentPane().add(textFieldCosto);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setBounds(212, 220, 161, 40);
		lblDescripcion.setVisible(false);
		getContentPane().add(lblDescripcion);
		
		lblDuracion = new JLabel("Duracion");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblDuracion.setBounds(212, 272, 161, 40);
		lblDuracion.setVisible(false);
		getContentPane().add(lblDuracion);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCosto.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblCosto.setBounds(212, 324, 161, 40);
		lblCosto.setVisible(false);
		getContentPane().add(lblCosto);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarActividadActionPerformed(e);
				popOff();
				setVisible(false);
			}
		});
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnModificar.setBounds(317, 460, 134, 52);
		btnModificar.setVisible(false);
		getContentPane().add(btnModificar);

	}
	
	public boolean inicializarComboBoxActividadesAsociadas() {
		DefaultComboBoxModel<String> modelActividades = new DefaultComboBoxModel<String>(iCon.listarActividades());
		if(modelActividades.getSize() == 0)
			return false;
		else {
			comboBoxActividades.setModel(modelActividades);
			return true;
		}
	}
	
	public void popUp() {
		this.textFieldCosto.setVisible(true);
		this.textFieldDescripcion.setVisible(true);
		this.textFieldDuracion.setVisible(true);
		this.lblCosto.setVisible(true);
		this.lblDescripcion.setVisible(true);
		this.lblDuracion.setVisible(true);
		this.btnModificar.setVisible(true);
	}
	
	public void popOff() {
		this.textFieldCosto.setVisible(false);
		this.textFieldDescripcion.setVisible(false);
		this.textFieldDuracion.setVisible(false);
		this.lblCosto.setVisible(false);
		this.lblDescripcion.setVisible(false);
		this.lblDuracion.setVisible(false);
		this.btnModificar.setVisible(false);
	}
	
	public void setTextFields() {
		DtActividadDeportiva dtAct = iCon.ConsultaActividadDeportiva(this.comboBoxActividades.getSelectedItem().toString());
		String desc = dtAct.getDescripcion();
		String costo = Float.toString(dtAct.getCosto());
		String duracion = Integer.toString(dtAct.getDuracion());
		
		this.textFieldDescripcion.setText(desc);
		this.textFieldCosto.setText(costo);
		this.textFieldDuracion.setText(duracion);
		
		popUp();
	}
	
	protected void modificarActividadActionPerformed(ActionEvent arg0) {
		DtActividadDeportiva dtActOld = iCon.ConsultaActividadDeportiva(this.comboBoxActividades.getSelectedItem().toString());
		String desc = this.textFieldDescripcion.getText();
		float costo = Float.parseFloat(this.textFieldCosto.getText());
		int duracion = Integer.parseInt(this.textFieldDuracion.getText());
		DtActividadDeportiva dtActNew = new DtActividadDeportiva(dtActOld.getNombre(),desc,duracion,costo,dtActOld.getFecha(),dtActOld.getClases(),dtActOld.getInstitucionDeportiva());
		
		if(iCon.ModificarActividadDeportiva(dtActOld.getNombre(),dtActNew)) {
			JOptionPane.showMessageDialog(this, "Actividad modificada con éxito!", "Modificar Actividad",
	                JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "No se pudo modificar la Actividad!", "Modificar Actividad",
	                JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
