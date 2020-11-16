package Mastermind.y;

public class MInfoJuego extends CInfoJuego{
	String[] mUsuarioUlt; //ultimo array usuario
	String[][] mUsuario; //matriz jugadas usuario
	String[] mGanador;
	String[] mResultadoUlt; //ultimo array resultado
	String[][] mResultado; //matriz resultados
	int mDimension;
	int mNumJugada = 0;
	int mIntentos = 100;

	public MInfoJuego(int dimension)
	{
		mDimension = dimension;
		mGanador = new String[dimension];
		mUsuarioUlt = new String[dimension];
		mResultadoUlt = new String[dimension];
		mUsuario = new String[mIntentos][dimension];
		mResultado = new String[mIntentos][dimension];
	}
	
	public void setnumJugada(int numjugada)
	{
		mNumJugada = numjugada;
	}
	
	public int getnumjugada()
	{
		return mNumJugada;
	}
	
	public String[] getGanador()
	{
		//obtener jugada ganadora
		return mGanador;
	}
	
	public void setGanador(String[] Ganador)
	{
		//añadir jugada ganadora
		mGanador = Ganador;	
	}
	
	public String[][] getUsuario()
	{
		//get matriz usuario
		return mUsuario;
	}
	
	private void addUsuario ()
	{
		//añadir ultima jugada usuario a la matriz total jugadas
		for(int i = 0; i < mDimension; i++)
		{
			mUsuario[mNumJugada][i] = mUsuarioUlt[i];
		}
	}
	
	public void setUsuarioUlt (String[] Usuario)
	{
		//guardar ultima jugada usuario
		mUsuarioUlt = Usuario;
		addUsuario();
	}
	
	public String[][] getResultado()
	{
		//get matriz resultado
		return mResultado;
	}
	
	private void addResultado ()
	{
		//añadir resultado ultima jugada de usuario a la matriz total resultados
		for(int i = 0; i < mDimension; i++)
		{
			mResultado[mNumJugada][i] = mResultadoUlt[i];
		}
		
	}
	
	public void setResultadoUlt (String[] Resultado)
	{
		//guardar resultado ultima jugada
		mResultadoUlt = Resultado;
		addResultado();
	}
}
