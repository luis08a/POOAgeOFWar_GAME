package presentacion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PreJuego extends JDialog {
	public static PreJuego pj;
	private int height = 400;
	private int width = 400;
	private JPanel panelOpciones;
	private JButton jcj;
	private JButton ia;
	private JPanel panelNombre;
	
	/*
	 * Constructor.
	 */
	public PreJuego() {
		setTitle("POOAgeOfWar");
		setBackground(Color.WHITE);
		setResizable(false);
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		
		prepareElementos();
		prepareAcciones();
		setVisible(true);
	}
	
	private void prepareElementos() {
		panelNombre();
		panelOpciones();
		
	}
	
	private void panelNombre() {
		panelNombre =  new JPanel();
		panelNombre.setBounds(125, 50, 100, 50);
		panelNombre.setLayout(new GridLayout(2,1));
		
		JLabel n = new JLabel("\t Tú nombre:");
		TextArea ta = new TextArea();
		
		panelNombre.add(n);
		panelNombre.add(ta);
		
		add(panelNombre);
	}
	
	private void panelOpciones() {
		panelOpciones = new JPanel();
		panelOpciones.setLayout(new GridLayout(3,1));
		panelOpciones.setBounds(125, 100, 150, 200);
		
		JLabel s = new JLabel("\t Seleccione");
		jcj = new JButton("Jugador vs Jugador");
		ia = new JButton("Jugador vs IA");
		
		panelOpciones.add(s);
		panelOpciones.add(jcj);
		panelOpciones.add(ia);
		
		add(panelOpciones);
	}
	
	private void prepareAcciones() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		ActionListener oyenteJcj = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				POOAgeOfWarGUI.cargarTablero(true);
			}
		};
		jcj.addActionListener(oyenteJcj);
		ActionListener oyenteIa = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				POOAgeOfWarGUI.cargarTablero(false);
			}
		};
		ia.addActionListener(oyenteIa);
	}
	
	/*
	 * @return la única instancia de PreJuego 
	 */
	public static PreJuego getPreJuego() {
		if (pj==null)pj= new PreJuego();
		return pj;
	}
}
