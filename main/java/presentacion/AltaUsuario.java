package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class AltaUsuario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
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
	public AltaUsuario() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setMaximizable(true);
		getContentPane().setBackground(SystemColor.menu);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta");
		setBounds(178, 10, 365, 492);

	}

}
