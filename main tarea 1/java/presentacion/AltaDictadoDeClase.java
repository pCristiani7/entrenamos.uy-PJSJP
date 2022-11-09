package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	 * @throws ParseException 
	 */
	public AltaDictadoDeClase(IControlador iCon) throws ParseException {
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
		comboBoxInstitucionDeportiva.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(!comboBoxInstitucionDeportiva.getSelectedItem().toString().equals(e)) {
						inicializarComboBoxActividades(comboBoxInstitucionDeportiva.getSelectedItem().toString());
						inicializarComboBoxProfesoreReact(comboBoxInstitucionDeportiva.getSelectedItem().toString());
					}
				}
			}
		});
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
				try {
					altaClaseAceptarActionPerformed(e);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonAceptar1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButtonAceptar1.setBounds(206, 474, 134, 52);
		getContentPane().add(btnNewButtonAceptar1);
		
		JButton btnCancelar = new JButton("Cancelar/Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpiarFormulario();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		Calendar ca = new GregorianCalendar();
		String day = ca.get(Calendar.DAY_OF_MONTH) + "";
		String month = ca.get(Calendar.MONTH) + 1 + "";
		String year = ca.get(Calendar.YEAR) + "";
		String dd = year + "-" + month + "-" + day;
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
		dateChooser.setDate(date);
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
		DefaultComboBoxModel<String> modelInstitucionDeportiva = new DefaultComboBoxModel<String>(iCon.listarInstitucionesConActYProf());
		if(modelInstitucionDeportiva.getSize() == 0)
			return false;
		else {
			comboBoxInstitucionDeportiva.setModel(modelInstitucionDeportiva);
			return true;
		}
	}
	
	public boolean inicializarComboBoxActividadesAsociadas() {
		String nombre = this.comboBoxInstitucionDeportiva.getSelectedItem().toString();
		DtInstitucionDeportiva instDep = iCon.getInstitucionDt(nombre);
		List<DtActividadDeportiva> dtAct = iCon.getActividadesInstitucion(instDep.getNombre());
		
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
		DtInstitucionDeportiva instDep = iCon.getInstitucionDt(nombre);
		List<DtProfesor> profesores = iCon.getProfesoresInstitucion(instDep.getNombre());
		
		String[] profesoresRet = new String[profesores.size()];
		int i=0;
		for(DtProfesor p: profesores) {
			profesoresRet[i]=p.getNickname();
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
	
	public boolean inicializarComboBoxProfesoreReact(String s) {
		DtInstitucionDeportiva instDep = iCon.getInstitucionDt(s);
		List<DtProfesor> profesores = iCon.getProfesoresInstitucion(instDep.getNombre());
		
		String[] profesoresRet = new String[profesores.size()];
		int i=0;
		for(DtProfesor p: profesores) {
			profesoresRet[i]=p.getNickname();
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
	
	private void limpiarFormulario() throws ParseException {
		textFieldNombre.setText("");
		textFieldURL.setText("");
		comboBoxInstitucionDeportiva.setModel(new DefaultComboBoxModel<String>());
		comboBoxActividadesAsociadas.setModel(new DefaultComboBoxModel<String>());
		comboBoxProfesores.setModel(new DefaultComboBoxModel<String>());
		textFieldHora.setText("");
		textFieldMinuto.setText("");
		Calendar ca = new GregorianCalendar();
		String day = ca.get(Calendar.DAY_OF_MONTH) + "";
		String month = ca.get(Calendar.MONTH) + 1 + "";
		String year = ca.get(Calendar.YEAR) + "";
		String dd = year + "-" + month + "-" + day;
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
		dateChooser.setDate(date);
		setVisible(false);
	}
	
	protected void altaClaseAceptarActionPerformed(ActionEvent arg0) throws ParseException {
		String actividad = comboBoxActividadesAsociadas.getSelectedItem().toString();
    	String nombre = textFieldNombre.getText();
    	String url = textFieldURL.getText();
    	LocalDate currentFecha = LocalDate.now();
    	String profesor = comboBoxProfesores.getSelectedItem().toString();
		if (checkFormulario()) {
    		try {
    	    	LocalDate fechaClase = Dating.toLocalDate(dateChooser.getDate());
    	    	int hora = Integer.parseInt(textFieldHora.getText());
    	    	int minuto = Integer.parseInt(textFieldMinuto.getText());
    			LocalTime lT = LocalTime.of(hora,minuto);
    			//ActividadDeportiva actDep = iCon.getAct(actividad);
    			//List<DtRegistro> registros = new ArrayList<>();
    			//List<DtClase> clases = new ArrayList<>();
    			DtActividadDeportiva dtActDep = iCon.ConsultaActividadDeportiva(actividad);
    			DtClase dtClase = new DtClase(nombre,url,actividad,fechaClase,currentFecha,lT,profesor);
    			iCon.AltaDictadoClase(dtActDep, dtClase);
    			JOptionPane.showMessageDialog(this, "La Clase se ha creado con �xito!", "Alta Dictado de Clase",
	                    JOptionPane.INFORMATION_MESSAGE);
    			limpiarFormulario();
    		}
    		catch (ClaseRepetidaExcepcion ex) {
    			JOptionPane.showMessageDialog(this, "Ya existe una Clase con ese nombre!", "Alta Dictado de Clase",
	                    JOptionPane.ERROR_MESSAGE);
    		}
    	}
	}
	
	private boolean checkFormulario() {
    	String nombre = textFieldNombre.getText();
    	String url = textFieldURL.getText();
    	String hora = textFieldHora.getText();
    	String minuto = textFieldMinuto.getText();
    	boolean date = dateChooser.getDateFormatString().equals(null);
    	if (nombre.isEmpty() || url.isEmpty() || hora.isEmpty() || minuto.isEmpty() || date) {
    		JOptionPane.showMessageDialog(this, "No puede haber campos vacios!", "Alta Dictado de Clase",
                    JOptionPane.ERROR_MESSAGE);    		
    		return false;
    	}else {
    		return true;
    	}
    }
	
	public boolean inicializarComboBoxActividades(String n) {
		DtInstitucionDeportiva instDep = iCon.getInstitucionDt(n);
		List<DtActividadDeportiva> dtAct = iCon.getActividadesInstitucion(instDep.getNombre());
		
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
}
