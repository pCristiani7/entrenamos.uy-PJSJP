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
	private JTextPane textPaneInfoActividades;

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
		comboBoxActividadesAsociadas.setBounds(299, 93, 198, 34);
		getContentPane().add(comboBoxActividadesAsociadas);
		
		JButton btnConsultarActividad = new JButton("Consultar");
		btnConsultarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxClases();
				consultarActividad(e);
				btnConsultarClase.setVisible(true);
				lblClases.setVisible(true);
				comboBoxClases.setVisible(true);
			}
		});
		btnConsultarActividad.setFont(new Font("Dialog", Font.BOLD, 12));
		btnConsultarActividad.setBounds(552, 59, 134, 52);
		getContentPane().add(btnConsultarActividad);
		
		textPaneInfoActividades = new JTextPane();
		textPaneInfoActividades.setFont(new Font("Dialog", Font.BOLD, 15));
		textPaneInfoActividades.setBounds(32, 176, 268, 164);
		textPaneInfoActividades.setVisible(false);
		getContentPane().add(textPaneInfoActividades);
		
		lblClases = new JLabel("Clases");
		lblClases.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblClases.setBounds(334, 176, 259, 34);
		lblClases.setVisible(false);
		getContentPane().add(lblClases);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setBounds(447, 176, 198, 34);
		comboBoxClases.setVisible(false);
		getContentPane().add(comboBoxClases);
		
		btnConsultarClase = new JButton("Ver Clase");
		btnConsultarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarClase(e);
			}
		});
		btnConsultarClase.setFont(new Font("Dialog", Font.BOLD, 12));
		btnConsultarClase.setBounds(447, 221, 134, 52);
		btnConsultarClase.setVisible(false);
		getContentPane().add(btnConsultarClase);
		
		textPaneInfoClase = new JTextPane();
		textPaneInfoClase.setFont(new Font("Dialog", Font.BOLD, 15));
		textPaneInfoClase.setBounds(447, 306, 259, 145);
		textPaneInfoClase.setVisible(false);
		getContentPane().add(textPaneInfoClase);

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
		DtInstitucionDeportiva dtInst = iCon.getInstitucionDt(nombre);
		List<DtActividadDeportiva> dtAct = dtInst.getActividadesDeportivas();
		
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
	
	public boolean inicializarComboBoxActividades(String n) {
		DtInstitucionDeportiva dtInst = iCon.getInstitucionDt(n);
		List<DtActividadDeportiva> dtAct = dtInst.getActividadesDeportivas();
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
		textPaneInfoActividades.setText(" ");
		textPaneInfoActividades.setVisible(false);
		btnConsultarClase.setVisible(false);
		comboBoxClases.setVisible(false);
		lblClases.setVisible(false);
		textPaneInfoClase.setText(" ");
		textPaneInfoClase.setVisible(false);
	}
	
	protected void consultarActividad(ActionEvent arg0) {
		String act = this.comboBoxActividadesAsociadas.getSelectedItem().toString();
		DtActividadDeportiva dtAct = iCon.ConsultaActividadDeportiva(act);
		String data = null;
		data = "Nombre: " + dtAct.getNombre() + "\n" +
				"Descripcion: " + dtAct.getDescripcion() + "\n" +
				"Duracion: " + dtAct.getDuracion() + "\n" +
				"Costo: " + "$" + dtAct.getCosto() + "\n" +
				"Fecha: " + dtAct.getFecha().toString() + "\n";
		
		textPaneInfoActividades.setText(data);
		textPaneInfoActividades.setVisible(true);
	}
	
	protected void consultarClase(ActionEvent arg0) {
		String clase = this.comboBoxClases.getSelectedItem().toString();
		DtClase dtC = iCon.getDatosClase(clase);
		String data_x = null;
		data_x = "Nombre: " + dtC.getNombre() + "\n" +
				"URL: " + dtC.getUrl() + "\n" +
				"Profesor: " + dtC.getProfesor() + "\n" +
				"Fecha: " + "$" + dtC.getFecha().toString() + "\n" +
				"Hora Inicio: " + dtC.getHoraInicio();
		textPaneInfoClase.setText(data_x);
		textPaneInfoClase.setVisible(true);
	}

}
