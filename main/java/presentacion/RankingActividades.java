package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import datatypes.DtActividadDeportiva;

public class RankingActividades extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingActividades frame = new RankingActividades(null);
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
	public RankingActividades(IControlador iCon) {
		setTitle("Ranking Actividades Deportivas");
		setClosable(true);
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Dialog", Font.PLAIN, 20));
		textPane.setEditable(false);
		textPane.setBounds(12, 87, 766, 431);
		getContentPane().add(textPane);
		
		JLabel lblNewLabel = new JLabel("RANKING ACTIVIDADES");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(247, 33, 295, 42);
		getContentPane().add(lblNewLabel);
	}
	
	public boolean thereSomething () {
		if(iCon.listarActividades().equals(null)) {
			return false;
		}else {
			return true;
		}
	}
	
	public void chargeRanking() {
		List<DtActividadDeportiva> dtActs = iCon.RankingActividadesDeportivas();
		String data = "";
		for(DtActividadDeportiva a: dtActs) {
			String nombre = a.getNombre();
			float costo = a.getCosto();
			String desc = a.getDescripcion();
			DtActividadDeportiva aux = iCon.ConsultaActividadDeportiva(a.getNombre());
			int cantClases = aux.getClases().size();
			data = data + nombre + ": $" + costo + " | " + desc + ", (Cantidad Clases: " + cantClases + ")." +  "\n";
        }
		textPane.setText(data);
	}
}
