package presentacion;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JInternalFrame;

import datatypes.DtClase;
import interfaces.IControlador;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class RankingClases extends JInternalFrame {

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
		lblRankingClases.setFont(new Font("Dialog", Font.BOLD, 22));
		lblRankingClases.setBounds(253, 39, 295, 42);
		getContentPane().add(lblRankingClases);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Dialog", Font.PLAIN, 20));
		textPane.setEditable(false);
		textPane.setBounds(18, 93, 766, 431);
		getContentPane().add(textPane);

	}

	public boolean thereSomething () {
		if(iCon.listarClases().equals(null)) {
			return false;
		}else {
			return true;
		}
	}
	
	public void chargeRanking() {
		List<DtClase> dtClases = iCon.RankingDictadosClases();
		String data = "";
		for(DtClase a: dtClases) {
			String nombre = a.getNombre();
			LocalDate fecha = a.getFecha();
			String url = a.getUrl();
			DtClase aux = iCon.getDatosClase(a.getNombre());
			int cantInscriptos = aux.getRegistros().size();
			data = data + nombre + ": " + fecha + " | " + url + ", (Cantidad de Inscriptos: " + cantInscriptos + ")." +  "\n";
        }
		textPane.setText(data);
	}
}
