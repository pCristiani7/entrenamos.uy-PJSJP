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

public class ConsultaDictadoClase extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JComboBox<String> comboBoxInstitucionDeportiva;
	private JComboBox<String> comboBoxActividadesAsociadas;
	private JComboBox<String> comboBoxClases;
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
				textPane.setVisible(false);
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
		lblNewLabelInstitucionDeportiva.setBounds(157, 40, 259, 34);
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
		comboBoxInstitucionDeportiva.setBounds(424, 40, 198, 34);
		getContentPane().add(comboBoxInstitucionDeportiva);
		
		JLabel lblActividadesAsociadas = new JLabel("Actividades Asociadas");
		lblActividadesAsociadas.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblActividadesAsociadas.setBounds(157, 85, 259, 34);
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
		comboBoxActividadesAsociadas.setBounds(424, 85, 198, 34);
		getContentPane().add(comboBoxActividadesAsociadas);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblClases.setBounds(157, 130, 259, 34);
		getContentPane().add(lblClases);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setBounds(424, 130, 198, 34);
		getContentPane().add(comboBoxClases);
		
		JButton btnVerInformacion = new JButton("Ver");
		btnVerInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarDatos(e);
			}
		});
		btnVerInformacion.setFont(new Font("Dialog", Font.BOLD, 12));
		btnVerInformacion.setBounds(322, 189, 134, 52);
		getContentPane().add(btnVerInformacion);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Lato Black", Font.BOLD, 15));
		textPane.setBounds(157, 283, 465, 224);
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
	
	protected void consultarDatos(ActionEvent arg0) {
		String clase = this.comboBoxClases.getSelectedItem().toString();
		DtClase dtC = iCon.ConsultaDictadoClase(clase);
		List <DtRegistro> registros = dtC.getRegistros();
		String data = "Nombre: " + dtC.getNombre() + "\n" + "Actividad: " + 
		dtC.getActividadDeportiva() + "\n" + "Profesor: " + dtC.getProfesor() +
		"\n" + "Hora Inicio: " + dtC.getHoraInicio().toString()+ "\n\n" + "Registros: " + "\n";
		for(DtRegistro x:registros) {
			data = data + x.getFecha().toString() + "\n";
		}
		textPane.setText(data);
		textPane.setVisible(true);
	}
}
