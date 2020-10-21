package Mastermind.y;

public class MInfoJuego extends CInfoJuego{
	String[] mUsuarioUlt; //ultimo array usuario
	String[][] mUsuario; //matriz jugadas usuario
	String[] mGanador;
	String[] mResultadoUlt; //ultimo array resultado
	String[][] mResultado; //matriz resultados
	
	public String[][] getUsuario()
	{
		//get matriz usuario
		return mUsuario;
	}
	
	private void addUsuario ()
	{
		//añadir ultima jugada usuario a la matriz total jugadas
		mUsuario[mUsuario.length] = mUsuarioUlt;
	}
	
	public String[] getUsuarioUlt()
	{
		//get ultima jugada usuario
		return mUsuarioUlt;
	}
	
	public void setUsuarioUlt (String[] Usuario)
	{
		//guardar ultima jugada usuario
		mUsuarioUlt = Usuario;
		addUsuario();
	}
	
	//getters y setters Ganador y resultado (huecos, blancas y negras)
	
}
