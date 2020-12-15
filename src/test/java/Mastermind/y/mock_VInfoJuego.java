package Mastermind.y;

public class mock_VInfoJuego extends VInfoJuego{
	CInfoJuego controlador;
	int mock_dim = 5;
	int cNumJugada=0;
	String[] mock_Ganador = {"Na","Ve","Rj","Rj","Az","Bl","Rs"};
	String[] mock_colores = {"Rj", "Az", "Rs" ,"Ne" ,"Bl" ,"Ve" ,"Na" ,"Am" ,"Vi"};
	String[][] mock_Resultados;
	String[][] mock_Usuario;
	
	public mock_VInfoJuego(int dimension)
	{
		mock_dim = mock_validarDimension(dimension);
	}
	
	public int mock_validarDimension(int dimension)
	{
		int result;
		if((dimension >= 3) && (dimension <= 7))
		{
			//la dimension de los arrays estará entre 3 y 7
			result = dimension;
		}
		else
		{
			//si dimension tiene un valor no numerico o fuera de los valores entre 3 y 7
			result = 5;
		}
		
		return result;
	}
	
	public String[] generarArrayGanador()
	{
		//Para el testeo siempre utilizaremos el mismo array.
		//En la vista se generará un array de dim posiciones con colores aleatorios
		String[] result = mock_Ganador;
		return result;
	}
	
	public int mock_actualizarDatos()
	{
		int result = controlador.obtenerIntentos();
		mock_Ganador = controlador.obtenerGanador();
		mock_Usuario = controlador.obtenerJugadasUsuario();
		mock_Resultados = controlador.obtenerResultados();
		return result;
	}
	
	public boolean mock_finJuego(String[] arrayResultado)
	{
		//para finalizar el juego se debe devolver un array de resultados donde todas las posiciones sean negras
		//de lo contrario, el juego seguirá hasta cumplir con este objetivo.
		boolean result = true;
		for(int i = 0; i < mock_dim; i++)
		{
			if(arrayResultado[i] != "Ne") result = false;
		}
		return result;
	}
	
	public void mock_BotonIniciarJuego()
	{
		mock_Ganador = generarArrayGanador();
		controlador = new CInfoJuego(mock_dim, mock_Ganador);
	}
	
	public String[] mock_comprobarResult(String[] arrayUsuario)
	{
		String[] arrayResultado;
		arrayResultado = controlador.comprobaciones(arrayUsuario, mock_Ganador);
		return arrayResultado;
	}
}
