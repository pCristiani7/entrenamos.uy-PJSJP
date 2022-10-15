package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import datatypes.DtInstitucionDeportiva;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarInstitucionDeportiva extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JComboBox<String> comboBoxInstituciones;
	private JTextField textFieldDescripcion;
	private JTextField textFieldURL;
	private JLabel lblURL;
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
	public ModificarInstitucionDeportiva (IControlador iCon) {
		setTitle("Modificar Actividad Deportiva");
		setClosable(true);
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucionesDeportivas = new JLabel("Instituciones Deportivas");
		lblInstitucionesDeportivas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblInstitucionesDeportivas.setBounds(96, 42, 320, 34);
		getContentPane().add(lblInstitucionesDeportivas);
		
		comboBoxInstituciones = new JComboBox<String>();
		comboBoxInstituciones.setBounds(424, 42, 198, 34);
		getContentPane().add(comboBoxInstituciones);
		
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
		textFieldDescripcion.setBounds(418, 240, 198, 40);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setVisible(false);
		textFieldDescripcion.setColumns(10);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(418, 292, 198, 40);
		textFieldURL.setVisible(false);
		getContentPane().add(textFieldURL);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setBounds(212, 240, 161, 40);
		lblDescripcion.setVisible(false);
		getContentPane().add(lblDescripcion);
		
		lblURL = new JLabel("URL");
		lblURL.setHorizontalAlignment(SwingConstants.CENTER);
		lblURL.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblURL.setBounds(212, 292, 161, 40);
		lblURL.setVisible(false);
		getContentPane().add(lblURL);
		
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
	
	public boolean inicializarComboBoxInstituciones() {
		DefaultComboBoxModel<String> modelActividades = new DefaultComboBoxModel<String>(iCon.listarInstituciones());
		if(modelActividades.getSize() == 0)
			return false;
		else {
			comboBoxInstituciones.setModel(modelActividades);
			return true;
		}
	}
	
	public void popUp() {
		this.textFieldDescripcion.setVisible(true);
		this.textFieldURL.setVisible(true);
		this.lblDescripcion.setVisible(true);
		this.lblURL.setVisible(true);
		this.btnModificar.setVisible(true);
	}
	
	public void popOff() {
		this.textFieldDescripcion.setVisible(false);
		this.textFieldURL.setVisible(false);
		this.lblDescripcion.setVisible(false);
		this.lblURL.setVisible(false);
		this.btnModificar.setVisible(false);
	}
	
	public void setTextFields() {
		DtInstitucionDeportiva dtInstOld = iCon.getInstitucionDt(this.comboBoxInstituciones.getSelectedItem().toString());
		String desc = dtInstOld.getDescripcion();
		String url = dtInstOld.getUrl();
		
		this.textFieldDescripcion.setText(desc);
		this.textFieldURL.setText(url);
		
		popUp();
	}
	
	protected void modificarActividadActionPerformed(ActionEvent arg0) {
		DtInstitucionDeportiva dtInstOld = iCon.getInstitucionDt(this.comboBoxInstituciones.getSelectedItem().toString());
		String desc = this.textFieldDescripcion.getText();
		String url = this.textFieldURL.getText();
		DtInstitucionDeportiva dtInstNew= new DtInstitucionDeportiva(dtInstOld.getNombre(),desc,url,dtInstOld.getActividadesDeportivas(),dtInstOld.getProfesores());
		
		if(iCon.ModificarInstitucionDeportiva(dtInstOld.getNombre(),dtInstNew)){
			JOptionPane.showMessageDialog(this, "Institucion modificada con éxito!", "Modificar Institucion",
	                JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "No se pudo modificar la Institucion!", "Modificar Institucion",
	                JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
