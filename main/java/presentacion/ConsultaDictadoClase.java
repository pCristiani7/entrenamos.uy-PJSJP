package presentacion;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtRegistro;
import interfaces.IControlador;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JTextField;

public class ConsultaDictadoClase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JComboBox<String> comboBoxInstitucionDeportiva;
	private JComboBox<String> comboBoxActividadesAsociadas;
	private JComboBox<String> comboBoxClases;
	private JTextField textFieldNombre;
	private JTextField textFieldProfesor;
	private JTextField textFieldHoraInicio;
	private JLabel lblNombre;
	private JLabel lblProfesor;
	private JLabel lblHoraInicio;
	private JLabel lblRegistros;
	private JTextPane textPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDictadoClase frame = new ConsultaDictadoClase(null);
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
	public ConsultaDictadoClase(IControlador iCon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				clearOnClosing();	
				setVisible(false);
			}
		});
		setTitle("Consulta Dictado de Clase");
		setClosable(true);
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabelInstitucionDeportiva = new JLabel("Institucion Deportiva");
		lblNewLabelInstitucionDeportiva.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabelInstitucionDeportiva.setBounds(50, 40, 259, 34);
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
		comboBoxInstitucionDeportiva.setBounds(317, 40, 198, 34);
		getContentPane().add(comboBoxInstitucionDeportiva);
		
		JLabel lblActividadesAsociadas = new JLabel("Actividades Asociadas");
		lblActividadesAsociadas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblActividadesAsociadas.setBounds(50, 85, 259, 34);
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
		comboBoxActividadesAsociadas.setBounds(317, 85, 198, 34);
		getContentPane().add(comboBoxActividadesAsociadas);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblClases.setBounds(50, 130, 259, 34);
		getContentPane().add(lblClases);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setBounds(317, 130, 198, 34);
		getContentPane().add(comboBoxClases);
		
		JButton btnVerInformacion = new JButton("Ver");
		btnVerInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarDatos(e);
			}
		});
		btnVerInformacion.setFont(new Font("Dialog", Font.BOLD, 12));
		btnVerInformacion.setBounds(562, 75, 134, 52);
		getContentPane().add(btnVerInformacion);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNombre.setBounds(50, 201, 259, 34);
		lblNombre.setVisible(false);
		getContentPane().add(lblNombre);
		
		lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblProfesor.setBounds(50, 246, 259, 34);
		lblProfesor.setVisible(false);
		getContentPane().add(lblProfesor);
		
		lblHoraInicio = new JLabel("Hora Inicio");
		lblHoraInicio.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblHoraInicio.setBounds(50, 291, 259, 34);
		lblHoraInicio.setVisible(false);
		getContentPane().add(lblHoraInicio);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setFont(new Font("Dialog", Font.ITALIC, 15));
		textFieldNombre.setBounds(317, 201, 198, 34);
		textFieldNombre.setVisible(false);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldProfesor = new JTextField();
		textFieldProfesor.setEditable(false);
		textFieldProfesor.setFont(new Font("Dialog", Font.ITALIC, 15));
		textFieldProfesor.setColumns(10);
		textFieldProfesor.setBounds(317, 246, 198, 34);
		textFieldProfesor.setVisible(false);
		getContentPane().add(textFieldProfesor);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setEditable(false);
		textFieldHoraInicio.setFont(new Font("Dialog", Font.ITALIC, 15));
		textFieldHoraInicio.setColumns(10);
		textFieldHoraInicio.setBounds(317, 291, 198, 34);
		textFieldHoraInicio.setVisible(false);
		getContentPane().add(textFieldHoraInicio);
		
		lblRegistros = new JLabel("Registros");
		lblRegistros.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblRegistros.setBounds(50, 352, 259, 147);
		lblRegistros.setVisible(false);
		getContentPane().add(lblRegistros);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Dialog", Font.ITALIC, 15));
		textPane.setEditable(false);
		textPane.setBounds(317, 352, 198, 147);
		textPane.setVisible(false);
		getContentPane().add(textPane);

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
		DtInstitucionDeportiva instDep = iCon.getInstitucionDt(n);
		List<DtActividadDeportiva> dtAct = instDep.getActividadesDeportivas();
		
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
		DtInstitucionDeportiva instDep = iCon.getInstitucionDt(nombre);
		List<DtActividadDeportiva> dtAct = instDep.getActividadesDeportivas();
		
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
	
	public void clearOnClosing() {
		this.lblNombre.setVisible(false);
		this.lblProfesor.setVisible(false);
		this.lblHoraInicio.setVisible(false);
		this.lblRegistros.setVisible(false);
		this.textFieldNombre.setVisible(false);
		this.textFieldProfesor.setVisible(false);
		this.textFieldHoraInicio.setVisible(false);
		this.textPane.setVisible(false);
	}
	
	protected void consultarDatos(ActionEvent arg0) {
		String clase = this.comboBoxClases.getSelectedItem().toString();
		DtClase dtC = iCon.ConsultaDictadoClase(clase);
		List <DtRegistro> registros = dtC.getRegistros();
		String data = "";
		for(DtRegistro x:registros) {
			data = data + x.getFecha().toString() + "\n";
		}
		textPane.setText(data);
		textFieldNombre.setText(dtC.getNombre());
		textFieldProfesor.setText(dtC.getProfesor());
		textFieldHoraInicio.setText(dtC.getHoraInicio().toString());
		
		this.lblNombre.setVisible(true);
		this.lblProfesor.setVisible(true);
		this.lblHoraInicio.setVisible(true);
		this.lblRegistros.setVisible(true);
		this.textFieldNombre.setVisible(true);
		this.textFieldProfesor.setVisible(true);
		this.textFieldHoraInicio.setVisible(true);
		textPane.setVisible(true);
	}
}
