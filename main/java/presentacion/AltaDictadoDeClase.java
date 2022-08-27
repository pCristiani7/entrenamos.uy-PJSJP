package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;
import logica.InstitucionDeportiva;
import logica.Profesor;

import javax.swing.JLabel;


import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import com.github.lgooddatepicker.components.TimePicker;

public class AltaDictadoDeClase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JTextField textFieldNombre;
	private JTextField textFieldURL;
	private JDateChooser dateChooser;
	private TimePicker timePicker;
	private JComboBox<String> comboBoxInstitucionDeportiva;
	private JComboBox<String> comboBoxActividadesAsociadas;
	private JComboBox<String> comboBoxProfesores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDictadoDeClase frame = new AltaDictadoDeClase(null);
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
	public AltaDictadoDeClase(IControlador iCon) {
		setTitle("Alta Dictado de Clase");
		setClosable(true);
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabelInstitucionDeportiva = new JLabel("Institucion Deportiva");
		lblNewLabelInstitucionDeportiva.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva.setBounds(135, 69, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva);
		
		comboBoxInstitucionDeportiva = new JComboBox<String>();
		comboBoxInstitucionDeportiva.setBounds(402, 69, 198, 34);
		getContentPane().add(comboBoxInstitucionDeportiva);
		
		JLabel lblActividadesAsociadas = new JLabel("Actividades Asociadas");
		lblActividadesAsociadas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblActividadesAsociadas.setBounds(135, 114, 259, 34);
		getContentPane().add(lblActividadesAsociadas);
		
		comboBoxActividadesAsociadas = new JComboBox<String>();
		comboBoxActividadesAsociadas.setBounds(402, 114, 198, 34);
		getContentPane().add(comboBoxActividadesAsociadas);
		
		JLabel lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelNombre.setBounds(135, 180, 259, 34);
		getContentPane().add(lblNewLabelNombre);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblProfesor.setBounds(135, 315, 259, 34);
		getContentPane().add(lblProfesor);
		
		JComboBox<String> comboBoxProfesores = new JComboBox<String>();
		comboBoxProfesores.setBounds(402, 315, 198, 34);
		getContentPane().add(comboBoxProfesores);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblUrl.setBounds(135, 360, 259, 34);
		getContentPane().add(lblUrl);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(402, 180, 198, 34);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(402, 360, 198, 34);
		getContentPane().add(textFieldURL);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBounds(206, 474, 134, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar/Salir");
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCancelar.setBounds(431, 474, 134, 52);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabelFecha = new JLabel("Fecha");
		lblNewLabelFecha.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelFecha.setBounds(135, 225, 259, 34);
		getContentPane().add(lblNewLabelFecha);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(402, 225, 198, 34);
		getContentPane().add(dateChooser);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio");
		lblHoraInicio.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblHoraInicio.setBounds(135, 270, 259, 34);
		getContentPane().add(lblHoraInicio);
		
		timePicker = new TimePicker();
		timePicker.getComponentTimeTextField().setEditable(false);
		timePicker.setBounds(402, 270, 198, 34);
		getContentPane().add(timePicker);
	}
	
	public boolean inicializarComboBoxInstitucionDeportiva() {
		DefaultComboBoxModel<String> modelInstitucionDeportiva = new DefaultComboBoxModel<String>(iCon.listarInstituciones());
		if(modelInstitucionDeportiva.getSize() == 0)
			return false;
		else {
			comboBoxInstitucionDeportiva.setModel(modelInstitucionDeportiva);
			return true;
		}
	}
	
	public boolean inicializarComboBoxActividadesAsociadas() {
		String nombre = this.comboBoxInstitucionDeportiva.getSelectedItem().toString();
		InstitucionDeportiva iDep = iCon.getInstitucion(nombre);
		List<DtActividadDeportiva> dtActDep = new ArrayList<>();
		List<DtProfesor> dtProf = new ArrayList<>();
		DtInstitucionDeportiva dtInstDep = new DtInstitucionDeportiva(iDep.getNombre(),iDep.getDescripcion(),iDep.getUrl(),dtActDep,dtProf);
		List<DtActividadDeportiva> dtAct = iCon.listarActividades(dtInstDep);
		
		String[] dtActNombre = new String[dtAct.size()];
		int i=0;
		for(DtActividadDeportiva a: dtAct) {
        	dtActNombre[i]=a.getNombre();
        	i++;
        }
		
		DefaultComboBoxModel<String> modelActividades = new DefaultComboBoxModel<String>(dtActNombre);
		if(modelActividades.getSize() == 0)
			return false;
		else {
			comboBoxActividadesAsociadas.setModel(modelActividades);
			return true;
		}
	}
	
	public boolean inicializarComboBoxProfesores() {
		String nombre = this.comboBoxInstitucionDeportiva.getSelectedItem().toString();
		InstitucionDeportiva iDep = iCon.getInstitucion(nombre);
		List<Profesor> profesores = iDep.getProfesores();
		
		String[] profesoresRet = new String[profesores.size()];
		int i=0;
		for(Profesor p: profesores) {
			profesoresRet[i]=p.getNombre();
        	i++;
        }
		
		DefaultComboBoxModel<String> modelProfesores = new DefaultComboBoxModel<String>(profesoresRet);
		if(modelProfesores.getSize() == 0)
			return false;
		else {
			comboBoxProfesores.setModel(modelProfesores);
			return true;
		}
	}
}
