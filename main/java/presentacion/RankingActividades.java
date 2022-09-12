package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControlador;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import datatypes.DtActividadDeportiva;
import javax.swing.JTextArea;

public class RankingActividades extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlador iCon;
	private JTextArea textPane;
	private JScrollPane scroll;

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
		
		JLabel lblNewLabel = new JLabel("RANKING ACTIVIDADES");
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 34, 221, 42);
		getContentPane().add(lblNewLabel);
		
		textPane = new JTextArea();
		textPane.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 18));
		textPane.setEditable(false);
		textPane.setLineWrap(true);
		textPane.setWrapStyleWord(true);
		textPane.setBounds(92, 87, 600, 400);
		getContentPane().add(textPane);
		
		scroll = new JScrollPane(
				textPane,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(92, 87, 600, 400);
		getContentPane().add(scroll);
	}
	
	public int thereSomething () {
		ArrayList<String> acts = iCon.listarActsFront();
		if(acts.size() > 0) {
			return 1;
		}else {
			return 2;
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
