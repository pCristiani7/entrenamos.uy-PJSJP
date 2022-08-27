package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;
import logica.Profesor;
import utilidad.Dating;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import excepciones.ClaseRepetidaExcepcion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

public class AltaDictadoDeClase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JTextField textFieldNombre;
	private JTextField textFieldURL;
	private JLabel lblNewLabelNombre;
	private JLabel lblNewLabelFecha;
	private JLabel lblUrl;
	private JDateChooser dateChooser;
	private JLabel lblProfesor;
	private JLabel lblActividadesAsociadas;
	private JComboBox<String> comboBoxInstitucionDeportiva;
	private JComboBox<String> comboBoxActividadesAsociadas;
	private JComboBox<String> comboBoxProfesores;
	private JTextField textFieldHora;
	private JTextField textFieldMinuto;

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
		
		lblActividadesAsociadas = new JLabel("Actividades Asociadas");
		lblActividadesAsociadas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblActividadesAsociadas.setBounds(135, 114, 259, 34);
		getContentPane().add(lblActividadesAsociadas);
		
		comboBoxActividadesAsociadas = new JComboBox<String>();
		comboBoxActividadesAsociadas.setBounds(402, 114, 198, 34);
		getContentPane().add(comboBoxActividadesAsociadas);
		
		lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelNombre.setBounds(135, 180, 259, 34);
		getContentPane().add(lblNewLabelNombre);
		
		lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblProfesor.setBounds(135, 361, 259, 34);
		getContentPane().add(lblProfesor);
		
		comboBoxProfesores = new JComboBox<String>();
		comboBoxProfesores.setBounds(402, 361, 198, 34);
		getContentPane().add(comboBoxProfesores);
		
		lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblUrl.setBounds(135, 406, 259, 34);
		getContentPane().add(lblUrl);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(402, 180, 198, 34);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(402, 406, 198, 34);
		getContentPane().add(textFieldURL);
		
		JButton btnNewButtonAceptar1 = new JButton("Aceptar");
		btnNewButtonAceptar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseAceptarActionPerformed(e);
			}
		});
		btnNewButtonAceptar1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButtonAceptar1.setBounds(206, 474, 134, 52);
		getContentPane().add(btnNewButtonAceptar1);
		
		JButton btnCancelar = new JButton("Cancelar/Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCancelar.setBounds(431, 474, 134, 52);
		getContentPane().add(btnCancelar);
		
		lblNewLabelFecha = new JLabel("Fecha");
		lblNewLabelFecha.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelFecha.setBounds(135, 225, 259, 34);
		getContentPane().add(lblNewLabelFecha);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(402, 225, 198, 34);
		getContentPane().add(dateChooser);
		
		JLabel lblNewLabelHora = new JLabel("Hora");
		lblNewLabelHora.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelHora.setBounds(135, 270, 259, 34);
		getContentPane().add(lblNewLabelHora);
		
		JLabel lblMinuto = new JLabel("Minuto");
		lblMinuto.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblMinuto.setBounds(135, 315, 259, 34);
		getContentPane().add(lblMinuto);
		
		textFieldHora = new JTextField();
		textFieldHora.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldHora.setColumns(10);
		textFieldHora.setBounds(402, 270, 52, 34);
		getContentPane().add(textFieldHora);
		
		textFieldMinuto = new JTextField();
		textFieldMinuto.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldMinuto.setColumns(10);
		textFieldMinuto.setBounds(402, 315, 52, 34);
		getContentPane().add(textFieldMinuto);
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
	
	public void setVisibleActividades() {
		this.lblActividadesAsociadas.setVisible(true);
		this.comboBoxActividadesAsociadas.setVisible(true);
	}
	
	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldURL.setText("");
		comboBoxInstitucionDeportiva.setModel(new DefaultComboBoxModel<String>());
		comboBoxActividadesAsociadas.setModel(new DefaultComboBoxModel<String>());
		comboBoxProfesores.setModel(new DefaultComboBoxModel<String>());
		dateChooser.setDate(null);
	}
	
	protected void altaClaseAceptarActionPerformed(ActionEvent arg0) {
		String actividad = comboBoxInstitucionDeportiva.getSelectedItem().toString();
    	String nombre = textFieldNombre.getText();
    	String url = textFieldURL.getText();
    	LocalDate fechaClase = Dating.toLocalDate(dateChooser.getDate());
    	LocalDate currentFecha = LocalDate.now();
    	String profesor = comboBoxProfesores.getSelectedItem().toString();
    	int hora = Integer.parseInt(textFieldHora.getText());
    	int minuto = Integer.parseInt(textFieldMinuto.getText());
		LocalTime lT = LocalTime.of(hora,minuto);
		if (checkFormulario()) {
    		try {
    			ActividadDeportiva actDep = iCon.getAct(actividad);
    			List<DtRegistro> registros = new ArrayList<>();
    			List<DtClase> clases = new ArrayList<>();
    			DtActividadDeportiva dtActDep = new DtActividadDeportiva(actDep.getNombre(),actDep.getDescripcion(),actDep.getDuracion(),actDep.getCosto(),actDep.getFecha(),clases,actDep.getInstitucionDeportiva().getNombre());
    			DtClase dtClase = new DtClase(nombre,url,registros,actividad,fechaClase,currentFecha,lT,profesor);
    			iCon.AltaDictadoClase(dtActDep, dtClase);
    			JOptionPane.showMessageDialog(this, "Se ha creado la Clase correctamente!");
    			limpiarFormulario();
    		}
    		catch (ClaseRepetidaExcepcion ex) {
    			JOptionPane.showMessageDialog(this, "Ya existe una Clase con ese nombre!", null, JOptionPane.ERROR_MESSAGE);
    		}
    	}
	}
	
	private boolean checkFormulario() {
    	String nombre = textFieldNombre.getText();
    	String url = textFieldURL.getText();
    	
    	if (comboBoxActividadesAsociadas.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe haber una actividad deportiva seleccionada!", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (nombre.isEmpty() || url.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "No puede haber campos vacios!", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (comboBoxProfesores.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe haber un profesor seleccionado!", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else {
    		return true;
    	}
    }
}
