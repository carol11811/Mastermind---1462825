package Mastermind.y;

public class mock_CInfoJuego extends CInfoJuego{
	
	MInfoJuego modelo;
	int c_dimension;
	int cNumJugada=0;
	
	public mock_CInfoJuego(int dimension, String[] arrayGanador)
	{
		c_dimension = dimension;
		modelo = new MInfoJuego(dimension);
		modelo.setGanador(arrayGanador);
	}
	
	public String[] mock_comprobaciones(String[] arrayUsuario)
	{
		String[] result = {"Ne", "Ne", "Ne", "Ne", "Ne"};
		modelo.setnumJugada(cNumJugada);
		int jugada = modelo.getnumjugada();
		modelo.setUsuarioUlt(arrayUsuario);
		modelo.setResultadoUlt(result);
		
		return result;
	}
	
	protected boolean mock_colorExiste(String color, String[] arrayGanador)
    {
    	//Miramos si el color de la posición i de nuestra jugada existe dentro del array ganador
    	boolean result = false;
    	int i = 0;
    	
    	while((result == false) && (i<arrayGanador.length))
    	{
    		//bucle: mientras no encontremos el color dentro del array ganador
    		//o bien, no hayamos recorrido todo el array ganador
    		if(arrayGanador[i] == color)
    		{
    			//color encontrado dentro del array. Devolvemos true como result
    			result = true;
    		}
    		i++;
    	}
    	
    	return result;
    }
}
