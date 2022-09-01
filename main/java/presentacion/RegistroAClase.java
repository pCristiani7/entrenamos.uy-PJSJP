package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;
import logica.InstitucionDeportiva;
import utilidad.Dating;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtSocio;
import excepciones.RegistroRepetidoExcepcion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;

public class RegistroAClase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JComboBox<String> comboBoxInstitucionDeportiva;
	private JComboBox<String> comboBoxActividadesAsociadas;
	private JComboBox<String> comboBoxSocios;
	private JComboBox<String> comboBoxClases;
	private JTextPane textPaneInfoClase;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroAClase frame = new RegistroAClase(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public RegistroAClase(IControlador iCon) throws ParseException {
		this.iCon = iCon;
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Registro a Clase");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabelInstitucionDeportiva = new JLabel("Institucion Deportiva");
		lblNewLabelInstitucionDeportiva.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva.setBounds(35, 55, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva);
		
		comboBoxInstitucionDeportiva = new JComboBox<String>();
		comboBoxInstitucionDeportiva.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(!comboBoxInstitucionDeportiva.getSelectedItem().toString().equals(e)) {
						inicializarComboBoxActividades(comboBoxInstitucionDeportiva.getSelectedItem().toString());
					}
				}
			}
		});
		comboBoxInstitucionDeportiva.setBounds(302, 55, 198, 34);
		getContentPane().add(comboBoxInstitucionDeportiva);
		
		JLabel lblActividadesAsociadas = new JLabel("Actividades Asociadas");
		lblActividadesAsociadas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblActividadesAsociadas.setBounds(35, 100, 259, 34);
		getContentPane().add(lblActividadesAsociadas);
		
		comboBoxActividadesAsociadas = new JComboBox<String>();
		comboBoxActividadesAsociadas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(!comboBoxActividadesAsociadas.getSelectedItem().toString().equals(e)) {
						inicializarComboBoxDynamic(comboBoxActividadesAsociadas.getSelectedItem().toString());
					}
				}
			}
		});
		comboBoxActividadesAsociadas.setBounds(302, 100, 198, 34);
		getContentPane().add(comboBoxActividadesAsociadas);
		
		JLabel lblSocios = new JLabel("Socios");
		lblSocios.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblSocios.setBounds(35, 222, 259, 34);
		getContentPane().add(lblSocios);
		
		comboBoxSocios = new JComboBox<String>();
		comboBoxSocios.setBounds(302, 222, 198, 34);
		getContentPane().add(comboBoxSocios);
		
		
		textPaneInfoClase = new JTextPane();
		textPaneInfoClase.setFont(new Font("Dialog", Font.BOLD, 15));
		textPaneInfoClase.setEditable(false);
		textPaneInfoClase.setBounds(547, 207, 198, 252);
		getContentPane().add(textPaneInfoClase);
		
		JButton btnVerClases = new JButton("Ver Informacion de Clase");
		btnVerClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoClase(e);
			}
		});
		btnVerClases.setFont(new Font("Dialog", Font.BOLD, 12));
		btnVerClases.setBounds(547, 95, 198, 52);
		getContentPane().add(btnVerClases);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblClases.setBounds(35, 145, 259, 34);
		getContentPane().add(lblClases);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setBounds(302, 145, 198, 34);
		getContentPane().add(comboBoxClases);
		
		JLabel lblNewLabelFecha = new JLabel("Fecha");
		lblNewLabelFecha.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelFecha.setBounds(35, 267, 259, 34);
		getContentPane().add(lblNewLabelFecha);
		
		dateChooser = new JDateChooser();
		Calendar ca = new GregorianCalendar();
		String day = ca.get(Calendar.DAY_OF_MONTH) + "";
		String month = ca.get(Calendar.MONTH) + 1 + "";
		String year = ca.get(Calendar.YEAR) + "";
		String dd = year + "-" + month + "-" + day;
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
		dateChooser.setDate(date);
		dateChooser.setBounds(302, 267, 198, 34);
		getContentPane().add(dateChooser);
		
		JButton btnNewButtonAceptar1 = new JButton("Aceptar");
		btnNewButtonAceptar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					registroAClaseAceptarActionPerformed(e);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonAceptar1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButtonAceptar1.setBounds(140, 407, 134, 52);
		getContentPane().add(btnNewButtonAceptar1);
		
		JButton btnCancelar = new JButton("Cancelar/Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCancelar.setBounds(315, 407, 134, 52);
		getContentPane().add(btnCancelar);
		
		JLabel lblInformacion = new JLabel("Informacion");
		lblInformacion.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblInformacion.setBounds(589, 162, 114, 34);
		getContentPane().add(lblInformacion);
	}
	
	public boolean inicializarComboBoxInstituciones() {
		DefaultComboBoxModel<String> modelInstituciones = new DefaultComboBoxModel<String>(iCon.listarInstituciones());
		if(modelInstituciones.getSize() == 0)
			return false;
		else {
			comboBoxInstitucionDeportiva.setModel(modelInstituciones);
			return true;
		}
	}
	
	public boolean inicializarComboBoxActividades(String n) {
		InstitucionDeportiva iDep = iCon.getInstitucion(n);
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
	
	public boolean inicializarComboBoxSocios() {
		DefaultComboBoxModel<String> modelSocios = new DefaultComboBoxModel<String>(iCon.listarSocios());
		if(modelSocios.getSize() == 0)
			return false;
		else {
			comboBoxSocios.setModel(modelSocios);
			return true;
		}
	}
	
	public void inicializarComboBoxDynamic(String n) {
		DefaultComboBoxModel<String> modelClases = new DefaultComboBoxModel<String>(iCon.listarClasesActividadDeportiva(n));
			comboBoxClases.setModel(modelClases);
	}
	
	public boolean inicializarComboBoxClases() {
		String nombre = this.comboBoxActividadesAsociadas.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelClases = new DefaultComboBoxModel<String>(iCon.listarClasesActividadDeportiva(nombre));
		if(modelClases.getSize() == 0)
			return false;
		else {
			comboBoxClases.setModel(modelClases);
			return true;
		}
	}
	
	protected void infoClase(ActionEvent arg0) {
		String claseSelected = comboBoxClases.getSelectedItem().toString();
		DtClase dtC = iCon.getDatosClase(claseSelected);
		DtSocio dtS = iCon.findSocio(comboBoxSocios.getSelectedItem().toString());
		List <DtRegistro> registros = dtC.getRegistros();
		String data = "Nombre: " + dtC.getNombre() + "\n" + "Actividad: " + 
		dtC.getActividadDeportiva() + "\n" + "Profesor: " + dtC.getProfesor() +
		"\n" + "Hora Inicio: " + dtC.getHoraInicio().toString()+ "\n\n" + "Registros: " + "\n";
		for(DtRegistro x:registros) {
			data = data + dtS.getNickname() + " - " + x.getFecha().toString() + "\n";
		}
		textPaneInfoClase.setText(data);
	}
	
	private void limpiarFormulario() throws ParseException {
		Calendar ca = new GregorianCalendar();
		String day = ca.get(Calendar.DAY_OF_MONTH) + "";
		String month = ca.get(Calendar.MONTH) + 1 + "";
		String year = ca.get(Calendar.YEAR) + "";
		String dd = year + "-" + month + "-" + day;
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
		dateChooser.setDate(date);
		textPaneInfoClase.setText(" ");
		setVisible(false);
	}
	
	protected void registroAClaseAceptarActionPerformed(ActionEvent arg0) throws ParseException {
		LocalDate fechaClase = Dating.toLocalDate(dateChooser.getDate());
		String clase = comboBoxClases.getSelectedItem().toString();
		String socio = comboBoxSocios.getSelectedItem().toString();
		try {
			iCon.RegistroDictadoClase(clase, socio, fechaClase);
			JOptionPane.showMessageDialog(this, "Registro realizado con éxito!", "Registro a Clase",
	                JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
		}
		catch (RegistroRepetidoExcepcion ex) {
			JOptionPane.showMessageDialog(this, "Ya existe un registro de ese Socio!", "Registro a Clase",
	                JOptionPane.ERROR_MESSAGE);
		}
	}
}
