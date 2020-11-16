package Mastermind.y;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.util.Random;

public class VInfoJuego {
	//String[] listComprobaciones = {};
	DefaultListModel listComprobaciones = new DefaultListModel();
	DefaultListModel listResultados = new DefaultListModel();
	CInfoJuego controlador;
	int dim;
	String[] arrayNull = {"null","null","null","null","null","null","null"};
	String[] Ganador = {"null","null","null","null","null","null","null"};
	String[][] Usuario;
	String[][] Resultado;
	int intentos = 0;
	String[] colores = {"Rj", "Az", "Rs" ,"Ne" ,"Bl" ,"Ve" ,"Na" ,"Am" ,"Vi"};
	private JFrame frmMastermind;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInfoJuego window = new VInfoJuego();
					window.frmMastermind.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VInfoJuego() {
		//vista:generar combinacion ganadora \\mock object: poner combinación ganadora fija
		//vista:consola/gráfico \\test: junit y coverage
		initialize();
	}

	public int actualizarDatos()
	{
		int result = controlador.obtenerIntentos();
		Ganador = controlador.obtenerGanador();
		Usuario = controlador.obtenerJugadasUsuario();
		Resultado = controlador.obtenerResultados();
		return result;
	}
	
	public int validarDimension(int dimension)
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
		String[] result = Ganador;
		//generar array con largo=dim
		Random rand = new Random();
		int upperbound = 9;
        //generar random values de 0-8
        int int_random;
		
        for (int i = 0; i < dim; i++)
        {
        	int_random = rand.nextInt(upperbound);
        	result[i] = colores[int_random];
        }
		return result;
	}
	
	public boolean finJuego(String[] arrayResultado)
	{
		//para finalizar el juego se debe devolver un array de resultados donde todas las posiciones sean negras
		//de lo contrario, el juego seguirá hasta cumplir con este objetivo.
		boolean result = true;
		for(int i = 0; i < dim; i++)
		{
			if(arrayResultado[i] != "Ne") result = false;
		}
		return result;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMastermind = new JFrame();
		frmMastermind.setTitle("Mastermind 1462825");
		frmMastermind.setBounds(100, 100, 500, 620);
		frmMastermind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMastermind.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(275, 452, 209, 130);
		frmMastermind.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dimensi\u00F3n (3-7):");
		lblNewLabel.setBounds(22, 52, 79, 14);
		panel.add(lblNewLabel);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Rj", "Az", "Rs", "Ne", "Bl", "Ve", "Na", "Am", "Vi"}));
		comboBox1.setMaximumRowCount(9);
		comboBox1.setBounds(0, 53, 49, 22);
		comboBox1.setVisible(false);
		frmMastermind.getContentPane().add(comboBox1);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Rj", "Az", "Rs", "Ne", "Bl", "Ve", "Na", "Am", "Vi"}));
		comboBox2.setMaximumRowCount(9);
		comboBox2.setBounds(49, 53, 49, 22);
		comboBox2.setVisible(false);
		frmMastermind.getContentPane().add(comboBox2);
		
		JComboBox comboBox3 = new JComboBox();
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"Rj", "Az", "Rs", "Ne", "Bl", "Ve", "Na", "Am", "Vi"}));
		comboBox3.setMaximumRowCount(9);
		comboBox3.setBounds(97, 53, 50, 22);
		comboBox3.setVisible(false);
		frmMastermind.getContentPane().add(comboBox3);
		
		JComboBox comboBox4 = new JComboBox();
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {"Rj", "Az", "Rs", "Ne", "Bl", "Ve", "Na", "Am", "Vi"}));
		comboBox4.setMaximumRowCount(9);
		comboBox4.setBounds(146, 53, 50, 22);
		comboBox4.setVisible(false);
		frmMastermind.getContentPane().add(comboBox4);
		
		JComboBox comboBox5 = new JComboBox();
		comboBox5.setModel(new DefaultComboBoxModel(new String[] {"Rj", "Az", "Rs", "Ne", "Bl", "Ve", "Na", "Am", "Vi"}));
		comboBox5.setMaximumRowCount(9);
		comboBox5.setBounds(196, 53, 49, 22);
		comboBox5.setVisible(false);
		frmMastermind.getContentPane().add(comboBox5);
		
		JComboBox comboBox6 = new JComboBox();
		comboBox6.setModel(new DefaultComboBoxModel(new String[] {"Rj", "Az", "Rs", "Ne", "Bl", "Ve", "Na", "Am", "Vi"}));
		comboBox6.setMaximumRowCount(9);
		comboBox6.setBounds(246, 53, 49, 22);
		comboBox6.setVisible(false);
		frmMastermind.getContentPane().add(comboBox6);
		
		JComboBox comboBox7 = new JComboBox();
		comboBox7.setModel(new DefaultComboBoxModel(new String[] {"Rj", "Az", "Rs", "Ne", "Bl", "Ve", "Na", "Am", "Vi"}));
		comboBox7.setMaximumRowCount(9);
		comboBox7.setBounds(295, 53, 49, 22);
		comboBox7.setVisible(false);
		frmMastermind.getContentPane().add(comboBox7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 88, 484, 353);
		frmMastermind.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 231, 331);
		panel_3.add(scrollPane);
		
		JSpinner spinnerDim = new JSpinner();
		spinnerDim.setModel(new SpinnerNumberModel(5, 3, 7, 1));
		spinnerDim.setBounds(106, 49, 30, 20);
		panel.add(spinnerDim);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setBounds(243, 11, 231, 331);
		panel_3.add(scrollPane2);
		
		JList list2 = new JList();
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane2.setViewportView(list2);
		
		JLabel lblNewLabel_3 = new JLabel("Empezar a jugar");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(22, 11, 177, 27);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 484, 44);
		frmMastermind.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("MASTERMIND");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 452, 269, 130);
		frmMastermind.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Leyenda colores");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(21, 11, 170, 30);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Rojo --> Rj");
		lblNewLabel_4.setBounds(21, 49, 76, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Azul --> Az");
		lblNewLabel_4_1.setBounds(21, 74, 76, 14);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Rosa --> Rs");
		lblNewLabel_4_1_1.setBounds(21, 99, 76, 14);
		panel_2.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Negro --> Ne");
		lblNewLabel_4_2.setBounds(96, 49, 76, 14);
		panel_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Blanco --> Bl");
		lblNewLabel_4_1_2.setBounds(96, 74, 76, 14);
		panel_2.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Verde --> Ve");
		lblNewLabel_4_1_1_1.setBounds(96, 99, 76, 14);
		panel_2.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Naranja --> Na");
		lblNewLabel_4_2_1.setBounds(182, 49, 87, 14);
		panel_2.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Amarillo --> Am");
		lblNewLabel_4_1_2_1.setBounds(182, 74, 87, 14);
		panel_2.add(lblNewLabel_4_1_2_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Violeta --> Vi");
		lblNewLabel_4_1_1_1_1.setBounds(182, 99, 76, 14);
		panel_2.add(lblNewLabel_4_1_1_1_1);
		
		JButton bComprobar = new JButton("Comprobar");
		bComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean fin = true;
				String c1, c2, c3, c4, c5, c6, c7;
				String[] usuario = arrayNull;
				String[] result = arrayNull;
				c1 = comboBox1.getSelectedItem().toString();
				c2 = comboBox2.getSelectedItem().toString();
				c3 = comboBox3.getSelectedItem().toString();
				c4 = comboBox4.getSelectedItem().toString();
				c5 = comboBox5.getSelectedItem().toString();
				c6 = comboBox6.getSelectedItem().toString();
				c7 = comboBox7.getSelectedItem().toString();
				
				if(dim > 2)
				{
					intentos = actualizarDatos();
					usuario = addRespuestaUsuario(c1, c2, c3, c4, c5, c6, c7);
					list.setModel(listComprobaciones);
					result = comprobarResult(usuario);
					list2.setModel(listResultados);
					//fin juego
					for (int i = 0; i < dim; i++)
					{
						if (result[i] != "Ne") fin = false;
					}
					fin = finJuego(result);
					if (fin == true)
					{
						intentos++;
						JOptionPane.showMessageDialog(null, "Ganaste en " + intentos + " intentos");
					}
				}
			}
		});
		bComprobar.setBounds(362, 53, 89, 23);
		bComprobar.setVisible(false);
		frmMastermind.getContentPane().add(bComprobar);		
		
		Button bIniciar = new Button("Iniciar Juego");
		bIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Iniciar Juego
				dim = (Integer) spinnerDim.getValue();
				dim = validarDimension(dim);
				Ganador = generarArrayGanador();
				controlador = new CInfoJuego(dim, Ganador);
				String p = Ganador[0] + " " + Ganador[1] + " " + Ganador[2];
				for (int i = 3; i < Ganador.length; i++)
				{
					if (Ganador[i] != "null")
					{
						p = p + " " + Ganador[i];
					}
				}
				JOptionPane.showMessageDialog(null, p);
				bIniciar.setEnabled(false);
				spinnerDim.setEnabled(false);
				bComprobar.setVisible(true);
				comboBox1.setVisible(true);
				comboBox2.setVisible(true);
				comboBox3.setVisible(true);
				listComprobaciones.addElement("Nº    Jugadas usuario");
				list.setModel(listComprobaciones);
				listResultados.addElement("Nº    Resultados");
				list2.setModel(listResultados);
				switch(dim) {
				  case 4: comboBox4.setVisible(true); break;
				  case 5: comboBox4.setVisible(true); comboBox5.setVisible(true); break;
				  case 6: comboBox4.setVisible(true); comboBox5.setVisible(true); comboBox6.setVisible(true); break;
				  case 7: comboBox4.setVisible(true); comboBox5.setVisible(true); comboBox6.setVisible(true); comboBox7.setVisible(true); break;
				  default:
				    // code block
				}

				
			}
		});
		bIniciar.setBounds(22, 87, 85, 33);
		panel.add(bIniciar);
	}
	
	public String[] addRespuestaUsuario(String c1, String c2, String c3, String c4, String c5, String c6, String c7)
	{
		String[] usuario = arrayNull;
		switch(dim) {
		  case 3: listComprobaciones.addElement(intentos+"    "+c1+" "+c2+" "+c3);
		  		  usuario[0] = c1; usuario[1] = c2; usuario[2] = c3; break;
		  case 4: listComprobaciones.addElement(intentos+"    "+c1+" "+c2+" "+c3+" "+c4);
		  		  usuario[0] = c1; usuario[1] = c2; usuario[2] = c3; usuario[3] = c4; break;
		  case 5: listComprobaciones.addElement(intentos+"    "+c1+" "+c2+" "+c3+" "+c4+" "+c5);
		          usuario[0] = c1; usuario[1] = c2; usuario[2] = c3; usuario[3] = c4; usuario[4] = c5; break;
		  case 6: listComprobaciones.addElement(intentos+"    "+c1+" "+c2+" "+c3+" "+c4+" "+c5+" "+c6);
		  		  usuario[0] = c1; usuario[1] = c2; usuario[2] = c3; usuario[3] = c4;
		  		  usuario[4] = c5; usuario[5] = c6;  break;
		  case 7: listComprobaciones.addElement(intentos+"    "+c1+" "+c2+" "+c3+" "+c4+" "+c5+" "+c6+" "+c7);
		  		  usuario[0] = c1; usuario[1] = c2; usuario[2] = c3; usuario[3] = c4;
		  		  usuario[4] = c5; usuario[5] = c6; usuario[6] = c7; break;
		  default:
		    // code block
			  
		}
		return usuario;
	}
	
	public String[] comprobarResult(String[] arrayUsuario)
	{
		String r1, r2, r3, r4, r5, r6, r7;
		//String[] arrayResultado;
		String[] result = arrayNull;
		String[] arrayG = controlador.obtenerGanador();
		result = controlador.comprobaciones(arrayUsuario, arrayG);
		switch(dim) {
		  case 3: r1 = result[0]; r2 = result[1]; r3 = result[2];
			      listResultados.addElement(intentos+"    "+r1+" "+r2+" "+r3); break;
		  case 4: r1 = result[0]; r2 = result[1]; r3 = result[2]; r4 = result[3];
			      listResultados.addElement(intentos+"    "+r1+" "+r2+" "+r3+" "+r4);break;
		  case 5: r1 = result[0]; r2 = result[1]; r3 = result[2]; r4 = result[3]; r5 = result[4];
			      listResultados.addElement(intentos+"    "+r1+" "+r2+" "+r3+" "+r4+" "+r5);break;
		  case 6: r1 = result[0]; r2 = result[1]; r3 = result[2]; r4 = result[3]; r5 = result[4]; r6 = result[5];
			      listResultados.addElement(intentos+"    "+r1+" "+r2+" "+r3+" "+r4+" "+r5+" "+r6);break;
		  case 7: r1 = result[0]; r2 = result[1]; r3 = result[2]; r4 = result[3]; r5 = result[4]; r6 = result[5]; r7 = result[6];
			      listResultados.addElement(intentos+"    "+r1+" "+r2+" "+r3+" "+r4+" "+r5+" "+r6+" "+r7); break;
		  default:
		    // code block
			  
		}
		return result;
	}
}
