package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;

import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JTextField;

public class ConsultaActividadDeportiva extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JComboBox<String> comboBoxInstitucionDeportiva;
	private JComboBox<String> comboBoxActividadesAsociadas;
	private JComboBox<String> comboBoxClases;
	
	private JTextPane textPaneInfoClase;
	private JButton btnConsultarClase;
	private JLabel lblClases;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldFecha;
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblDuracion;
	private JLabel lblCosto;
	private JLabel lblFecha;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaActividadDeportiva frame = new ConsultaActividadDeportiva(null);
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
	public ConsultaActividadDeportiva(IControlador iCon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarScreenOnClosing();
			}
		});
		this.iCon = iCon;
		setTitle("Consulta Actividad Deportiva");
		setClosable(true);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabelInstitucionDeportiva = new JLabel("Institucion Deportiva");
		lblNewLabelInstitucionDeportiva.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva.setBounds(32, 48, 259, 34);
		getContentPane().add(lblNewLabelInstitucionDeportiva);
		
		comboBoxInstitucionDeportiva = new JComboBox<String>();
		comboBoxInstitucionDeportiva.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(!comboBoxInstitucionDeportiva.getSelectedItem().toString().equals(e)) {
						limpiarScreenOnClosing();
						inicializarComboBoxActividades(comboBoxInstitucionDeportiva.getSelectedItem().toString());
					}
				}
			}
		});
		comboBoxInstitucionDeportiva.setBounds(299, 48, 198, 34);
		getContentPane().add(comboBoxInstitucionDeportiva);
		
		JLabel lblActividadesAsociadas = new JLabel("Actividades Asociadas");
		lblActividadesAsociadas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblActividadesAsociadas.setBounds(32, 93, 259, 34);
		getContentPane().add(lblActividadesAsociadas);
		
		
		btnConsultarClase = new JButton("Ver Clase");
		btnConsultarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarClase(e);
			}
		});
		btnConsultarClase.setFont(new Font("Dialog", Font.BOLD, 12));
		btnConsultarClase.setBounds(552, 384, 134, 34);
		btnConsultarClase.setVisible(false);
		getContentPane().add(btnConsultarClase);
		
		comboBoxActividadesAsociadas = new JComboBox<String>();
		comboBoxActividadesAsociadas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(!comboBoxActividadesAsociadas.getSelectedItem().toString().equals(e)) {
						limpiarScreenOnClosing();
						inicializarComboBoxDynamic(comboBoxActividadesAsociadas.getSelectedItem().toString());
					}
				}
			}
		});
		comboBoxActividadesAsociadas.setBounds(299, 93, 198, 34);
		getContentPane().add(comboBoxActividadesAsociadas);
		
		JButton btnConsultarActividad = new JButton("Consultar");
		btnConsultarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicializarComboBoxClases()) {
					consultarActividad(e);
					btnConsultarClase.setVisible(true);
					lblClases.setVisible(true);
					comboBoxClases.setVisible(true);
				}else {
					consultarActividad(e);
					btnConsultarClase.setVisible(false);
					lblClases.setVisible(false);
					comboBoxClases.setVisible(false);
				}
				
			}
		});
		btnConsultarActividad.setFont(new Font("Dialog", Font.BOLD, 12));
		btnConsultarActividad.setBounds(552, 59, 134, 52);
		getContentPane().add(btnConsultarActividad);
		
		lblClases = new JLabel("Clases");
		lblClases.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblClases.setBounds(32, 390, 76, 34);
		lblClases.setVisible(false);
		getContentPane().add(lblClases);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setBounds(299, 385, 198, 34);
		comboBoxClases.setVisible(false);
		getContentPane().add(comboBoxClases);
		
		textPaneInfoClase = new JTextPane();
		textPaneInfoClase.setFont(new Font("Dialog", Font.ITALIC, 15));
		textPaneInfoClase.setBounds(299, 425, 198, 134);
		textPaneInfoClase.setVisible(false);
		getContentPane().add(textPaneInfoClase);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNombre.setBounds(32, 160, 259, 34);
		lblNombre.setVisible(false);
		getContentPane().add(lblNombre);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblDescripcion.setBounds(32, 205, 259, 34);
		lblDescripcion.setVisible(false);
		getContentPane().add(lblDescripcion);
		
		lblDuracion = new JLabel("Duracion");
		lblDuracion.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblDuracion.setBounds(32, 250, 259, 34);
		lblDuracion.setVisible(false);
		getContentPane().add(lblDuracion);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblCosto.setBounds(32, 295, 259, 34);
		lblCosto.setVisible(false);
		getContentPane().add(lblCosto);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblFecha.setBounds(32, 340, 259, 34);
		lblFecha.setVisible(false);
		getContentPane().add(lblFecha);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Dialog", Font.ITALIC, 15));
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(299, 160, 198, 34);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setVisible(false);
		textFieldNombre.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setFont(new Font("Dialog", Font.ITALIC, 15));
		textFieldDescripcion.setEditable(false);
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(299, 205, 198, 34);
		textFieldDescripcion.setVisible(false);
		getContentPane().add(textFieldDescripcion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setFont(new Font("Dialog", Font.ITALIC, 15));
		textFieldDuracion.setEditable(false);
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setVisible(false);
		textFieldDuracion.setBounds(299, 250, 198, 34);
		getContentPane().add(textFieldDuracion);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setFont(new Font("Dialog", Font.ITALIC, 15));
		textFieldCosto.setEditable(false);
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(299, 295, 198, 34);
		textFieldCosto.setVisible(false);
		getContentPane().add(textFieldCosto);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setFont(new Font("Dialog", Font.ITALIC, 15));
		textFieldFecha.setEditable(false);
		textFieldFecha.setColumns(10);
		textFieldFecha.setVisible(false);
		textFieldFecha.setBounds(299, 340, 198, 34);
		getContentPane().add(textFieldFecha);

	}
	
	public boolean inicializarComboBoxInstitucionDeportiva() {
		DefaultComboBoxModel<String> modelInstitucionDeportiva = new DefaultComboBoxModel<String>(iCon.listarInstitucionesConAct());
		if(modelInstitucionDeportiva.getSize() == 0)
			return false;
		else {
			comboBoxInstitucionDeportiva.setModel(modelInstitucionDeportiva);
			return true;
		}
	}
	
	public boolean inicializarComboBoxActividadesAsociadas() {
		String nombre = this.comboBoxInstitucionDeportiva.getSelectedItem().toString();
		DtInstitucionDeportiva dtInst = iCon.getInstitucionDt(nombre);
		List<DtActividadDeportiva> dtAct = iCon.getActividadesInstitucion(dtInst.getNombre());
		
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
	
	public boolean inicializarComboBoxDynamic(String n) {
		DefaultComboBoxModel<String> modelClases = new DefaultComboBoxModel<String>(iCon.listarClasesActividadDeportiva(n));
			if(modelClases.getSize() == 0)
				return false;
			else {
				comboBoxClases.setModel(modelClases);
				return true;
			}
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
	
	public boolean inicializarComboBoxActividades(String n) {
		DtInstitucionDeportiva dtInst = iCon.getInstitucionDt(n);
		List<DtActividadDeportiva> dtAct = iCon.getActividadesInstitucion(dtInst.getNombre());
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
	
	public void limpiarScreenOnClosing() {
		this.textFieldNombre.setVisible(false);
		this.textFieldDescripcion.setVisible(false);
		this.textFieldDuracion.setVisible(false);
		this.textFieldCosto.setVisible(false);
		this.textFieldFecha.setVisible(false);
		this.lblNombre.setVisible(false);
		this.lblDescripcion.setVisible(false);
		this.lblDuracion.setVisible(false);
		this.lblCosto.setVisible(false);
		this.lblFecha.setVisible(false);
		btnConsultarClase.setVisible(false);
		comboBoxClases.setVisible(false);
		lblClases.setVisible(false);
		textPaneInfoClase.setText(" ");
		textPaneInfoClase.setVisible(false);
	}
	
	protected void consultarActividad(ActionEvent arg0) {
		String act = this.comboBoxActividadesAsociadas.getSelectedItem().toString();
		DtActividadDeportiva dtAct = iCon.ConsultaActividadDeportiva(act);
		this.textFieldNombre.setText(dtAct.getNombre());
		this.textFieldDescripcion.setText(dtAct.getDescripcion());
		String duracion = Integer.toString(dtAct.getDuracion());
		this.textFieldDuracion.setText(duracion);
		String costo = "$" + Float.toString(dtAct.getCosto());
		this.textFieldCosto.setText(costo);
		this.textFieldFecha.setText(dtAct.getFecha().toString());
		
		this.lblNombre.setVisible(true);
		this.lblDescripcion.setVisible(true);
		this.lblDuracion.setVisible(true);
		this.lblCosto.setVisible(true);
		this.lblFecha.setVisible(true);
		this.textFieldNombre.setVisible(true);
		this.textFieldDescripcion.setVisible(true);
		this.textFieldDuracion.setVisible(true);
		this.textFieldCosto.setVisible(true);
		this.textFieldFecha.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	protected void consultarClase(ActionEvent arg0) {
		String clase = this.comboBoxClases.getSelectedItem().toString();
		DtClase dtC = iCon.getDatosClase(clase);
		String data_x = null;
		data_x = "Nombre: " + dtC.getNombre() + "\n" +
				"URL: " + dtC.getUrl() + "\n" +
				"Profesor: " + dtC.getProfesor() + "\n" +
				"Fecha: " + dtC.getFecha().toString() + "\n" +
				"Hora Inicio: " + dtC.getFecha().getHours();
		textPaneInfoClase.setText(data_x);
		textPaneInfoClase.setVisible(true);
	}
	
}
