package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JInternalFrame;

import datatypes.DtClase;
import interfaces.IControlador;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class RankingClases extends JInternalFrame {

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
					RankingClases frame = new RankingClases(null);
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
	public RankingClases(IControlador iCon) {
		setTitle("Ranking de Clases");
		setClosable(true);
		this.iCon = iCon;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblRankingClases = new JLabel("RANKING CLASES");
		lblRankingClases.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankingClases.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 22));
		lblRankingClases.setBounds(92, 34, 170, 42);
		getContentPane().add(lblRankingClases);
		
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
		ArrayList<String> clases = iCon.listarClasesFront();
		if(clases.size() > 0) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public void chargeRanking() {
		List<DtClase> dtClases = iCon.RankingDictadosClases();
		String data = "";
		for(DtClase a: dtClases) {
			String nombre = a.getNombre();
			Date fecha = a.getFecha();
			String url = a.getUrl();
			DtClase aux = iCon.getDatosClase(a.getNombre());
			int cantInscriptos = iCon.getRegistrosClase(aux.getNombre()).size();
			data = data + nombre + ": " + fecha + " | " + url + ", (Cantidad de Inscriptos: " + cantInscriptos + ")." +  "\n";
        }
		textPane.setText(data);
	}
}
