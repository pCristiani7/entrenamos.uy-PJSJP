package excepciones;

public class RegistroRepetidoExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	public RegistroRepetidoExcepcion(String string) {
        super(string);
    }

}
