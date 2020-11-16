package Mastermind.y;

import static org.junit.Assert.*;

import org.junit.Test;

public class CInfoJuegoTest {
	//Rojo --> Rj, Negro --> Ne, Naranja --> Na, Azul --> Az, Blanco --> Bl
	//Amarillo --> Am, Rosa --> Rs, Verde --> Ve, Violeta --> Vi, Hueco --> -
	
	@Test
    public void test_mock_set_data() {
		String[] arrayG = {"Rj", "Az", "Ve", "Am", "Ne"};
		mock_CInfoJuego Inf = new mock_CInfoJuego(5, arrayG);
        String[] arrayU = {"Rj", "Az", "Ve", "Am", "Ne"};
        String[] res_Win = Inf.mock_comprobaciones(arrayU);
        String[] expectedResult = {"Ne","Ne","Ne","Ne","Ne"};
        assertArrayEquals(res_Win, expectedResult);
    }

	@Test
    public void testmock_JugadaNNNNN() {
		mock_VInfoJuego Inf = new mock_VInfoJuego(5);
		Inf.mock_BotonIniciarJuego();
		String[] arrayU = {"Na","Ve","Rj","Rj","Az"};;
		String[] res_Win = Inf.mock_comprobarResult(arrayU);
        String[] expectedResult = {"Ne","Ne","Ne","Ne","Ne"};
        assertArrayEquals(res_Win, expectedResult);
    }
	
	@Test
    public void testmock_numJugada() {
		mock_VInfoJuego Inf = new mock_VInfoJuego(5);
		Inf.mock_BotonIniciarJuego();
		String[] arrayU = {"Na","Ve","Rj","Rj","Az"};;
		String[] res_Win = Inf.mock_comprobarResult(arrayU);
		int res_jugada = Inf.mock_actualizarDatos();
        assertEquals(res_jugada, 1);
    }
	
	@Test
    public void testJugadaNNNNNNN() {
		String[] arrayG = {"Rj", "Az", "Ve", "Am", "Ne", "Az", "Ve"};
		CInfoJuego Inf = new CInfoJuego(7, arrayG);
        String[] arrayU = {"Rj", "Az", "Ve", "Am", "Ne", "Az", "Ve"};
        String[] res_Win = Inf.comprobaciones(arrayU, arrayG);
        String[] expectedResult = {"Ne","Ne","Ne","Ne","Ne","Ne","Ne"};
        assertArrayEquals(res_Win, expectedResult);
    }
    
    @Test
    public void testJugadaNBN() {
    	String[] arrayG = {"Rj", "Az", "Ve"};
    	CInfoJuego Inf = new CInfoJuego(3, arrayG);
        String[] arrayU = {"Rj", "Ve", "Ve"};
        String[] res_Win = Inf.comprobaciones(arrayU, arrayG);
        String[] expectedResult = {"Ne","Bl","Ne"};
        assertArrayEquals(res_Win, expectedResult);
    }
    
    @Test
    public void testJugadaHBHNB() {
    	String[] arrayG = {"Rj", "Az", "Ve", "Am", "Ne"};
    	CInfoJuego Inf = new CInfoJuego(5, arrayG);
        String[] arrayU = {"Rs", "Am", "Na", "Am", "Ve"};
        String[] res_Win = Inf.comprobaciones(arrayU, arrayG);
        String[] expectedResult = {"-","Bl","-","Ne","Bl"};
        assertArrayEquals(res_Win, expectedResult);
    }
    
    @Test
    public void testJugadaH_HNB() {
    	String[] arrayG = {"Rj", "null", "Ve", "Am", "Ne"};
    	CInfoJuego Inf = new CInfoJuego(5, arrayG);
        String[] arrayU = {"Rs", "Am", "Na", "Am", "Ve"};
        String[] res_Win = Inf.comprobaciones(arrayU, arrayG);
        String[] expectedResult = {"-","-","-","Ne","Bl"};
        assertArrayEquals(res_Win, expectedResult);
    }    
    
    @Test
    public void testColorExiste() {
        String[] arrayG = {"Rj", "Az", "Ve", "Am", "Ne"};
        mock_CInfoJuego Inf = new mock_CInfoJuego(5, arrayG);
        boolean res_verde = Inf.mock_colorExiste("Ve", arrayG);
		assertEquals(res_verde,true);
    }
    
    @Test
    public void testColorNoExiste() {
        String[] arrayG = {"Rj", "Az", "Ve", "Am", "Ne"};
        mock_CInfoJuego Inf = new mock_CInfoJuego(5, arrayG);
        boolean res_verde = Inf.mock_colorExiste("Na", arrayG);
		assertEquals(res_verde,false);
    }
    
    @Test
    public void testColorExisteControlador() {
        CInfoJuego Inf = new CInfoJuego();
        String[] arrayG = {"Rj", "Az", "Ve", "Am", "Ne"};
        boolean res_verde = Inf.colorExiste("Ve", arrayG);
		assertEquals(res_verde,true);
    }
    
    @Test
    public void testColorNoExisteControlador() {
        CInfoJuego Inf = new CInfoJuego();
        String[] arrayG = {"Rj", "Az", "Ve", "Am", "Ne"};
        boolean res_verde = Inf.colorExiste("Na", arrayG);
		assertEquals(res_verde,false);
    }
    
    @Test
    public void testmock_DimensionMinima() {
    	int dim = 3;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(dim);
        int res_dim = Inf.mock_validarDimension(dim);
		assertEquals(res_dim,3);
    }
    
    @Test
    public void testmock_DimensionMaxima() {
    	int dim = 7;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(dim);
        int res_dim = Inf.mock_validarDimension(dim);
		assertEquals(res_dim,7);
    }
    
    @Test
    public void testmock_DimensionErronea2() {
    	int dim = 2;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(dim);
        int res_dim = Inf.mock_validarDimension(dim);
		assertEquals(res_dim,5);
    }
    
    @Test
    public void testmock_DimensionErronea8() {
    	int dim = 8;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(dim);
        int res_dim = Inf.mock_validarDimension(dim);
		assertEquals(res_dim,5);
    }
    
    @Test
    public void testDimensionMinima() {
    	int dim = 3;
    	VInfoJuego Inf = new VInfoJuego();
        int res_dim = Inf.validarDimension(dim);
		assertEquals(res_dim,3);
    }
    
    @Test
    public void testDimensionMaxima() {
    	int dim = 7;
    	VInfoJuego Inf = new VInfoJuego();
        int res_dim = Inf.validarDimension(dim);
		assertEquals(res_dim,7);
    }
    
    @Test
    public void testDimensionErronea2() {
    	int dim = 2;
    	VInfoJuego Inf = new VInfoJuego();
        int res_dim = Inf.validarDimension(dim);
		assertEquals(res_dim,5);
    }
    
    @Test
    public void testDimensionErronea8() {
    	int dim = 8;
    	VInfoJuego Inf = new VInfoJuego();
        int res_dim = Inf.validarDimension(dim);
		assertEquals(res_dim,5);
    }
    
    @Test
    public void testmock_contenidoArrayG() {
    	int dim = 8;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(7);
        String[] arrayG = Inf.generarArrayGanador();
        int res_largo = arrayG.length;
		assertEquals(res_largo,7);
    }
    
    /*@Test
    public void testcontenidoArrayG() {
    	VInfoJuego Inf = new VInfoJuego();
    	int res_dim = Inf.validarDimension(7);
    	String[] arrayG = Inf.generarArrayGanador();
        int res_largo = arrayG.length;
		assertEquals(res_largo,5);
    }*/
    
    @Test
    public void testmock_finJuego() {
    	int dim = 8;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(5);
        String[] arrayR = {"Ne","Ne","Ne","Ne","Ne"};
        boolean fin = Inf.mock_finJuego(arrayR);
		assertEquals(fin,true);
    }
    
    @Test
    public void testmock_NofinJuego() {
    	int dim = 8;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(5);
        String[] arrayR = {"Bl","Ne","Ne","Ne","Ne"};
        boolean fin = Inf.mock_finJuego(arrayR);
		assertEquals(fin,false);
    }

    @Test
    public void testfinJuego() {
    	int dim = 8;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(5);
        String[] arrayR = {"Ne","Ne","Ne","Ne","Ne"};
        boolean fin = Inf.mock_finJuego(arrayR);
		assertEquals(fin,true);
    }
    
    @Test
    public void testNofinJuego() {
    	int dim = 8;
    	mock_VInfoJuego Inf = new mock_VInfoJuego(5);
        String[] arrayR = {"Bl","Ne","Ne","Ne","Ne"};
        boolean fin = Inf.mock_finJuego(arrayR);
		assertEquals(fin,false);
    }    
}
