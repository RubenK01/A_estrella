import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldX_Fail;
	private JTextField textFieldY_Fail;
	private JPanel Tablero ;
	
	private JButton btnPintaTablero;
	private JButton btnAniadirFail;
	private JButton btnCalculaA;
	private JButton btnAniadirIni;
	private JButton btnAniadirFin;
	
	private JButton[][] botones;
	private JTextField textField_InicioX;
	private JTextField textField_InicioY;
	private JTextField textField_XFinal;
	private JTextField textField_YFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void pintarTablero() {
		
		//this.Tablero = new JPanel();
		this.Tablero.repaint();
		this.Tablero.removeAll();
		this.Tablero.setLayout(new GridLayout(Variables.getWidth(),Variables.getHeigh(),0,0));
		
		
		
		this.botones = new JButton[Variables.getWidth()][Variables.getHeigh()];
		for(int i = Variables.getWidth()-1; i >=0; i--) {
			for(int j=0; j<Variables.getHeigh(); j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setEnabled(false);
				if(Variables.getMap()[i][j] == -1 ) {
					this.botones[i][j].setBackground(Color.BLACK);
				}
				else if (Variables.getMap()[i][j] == 1) { //path
					this.botones[i][j].setBackground(Color.gray);
				}
				else if (Variables.getMap()[i][j] == 2) { //ini
					this.botones[i][j].setBackground(Color.blue);
				}
				else if (Variables.getMap()[i][j] == 3) { //fin
					this.botones[i][j].setBackground(Color.GREEN);
				}
				else {
					this.botones[i][j].setBackground(Color.white);
				}
				this.Tablero.add(this.botones[i][j]);
			}
			
		}
		
		
		this.Tablero.revalidate();
		
	}
	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		this.Tablero = new JPanel();
		
		
		
		
		JLabel lblEligeDimensiones = new JLabel("Elige dimensiones:");
		
		textFieldX = new JTextField();
		textFieldX.setColumns(10);
		
		textFieldY = new JTextField();
		textFieldY.setColumns(10);
		
		btnPintaTablero = new JButton("Pinta Tablero");
		
		btnPintaTablero.addActionListener(this);
		
		JLabel lblAadePuntos = new JLabel("A\u00F1ade puntos:");
		
		textFieldX_Fail = new JTextField();
		textFieldX_Fail.setColumns(10);
		
		JLabel lblX = new JLabel("X: ");
		
		JLabel lblY = new JLabel("Y:");
		
		textFieldY_Fail = new JTextField();
		textFieldY_Fail.setColumns(10);
		
		btnAniadirFail = new JButton("Añadir");
		
		btnAniadirFail.addActionListener(this);
	
		
		btnCalculaA = new JButton("CALCULA A*");
		
		btnCalculaA.addActionListener(this);
		
		JLabel lblAadeInicio = new JLabel("A\u00F1ade inicio:");
		
		JLabel lblX_1 = new JLabel("X:");
		
		textField_InicioX = new JTextField();
		textField_InicioX.setColumns(10);
		
		JLabel lblY_1 = new JLabel("Y:");
		
		textField_InicioY = new JTextField();
		textField_InicioY.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("A\u00F1ade final:");
		
		JLabel lblX_2 = new JLabel("X:");
		
		textField_XFinal = new JTextField();
		textField_XFinal.setColumns(10);
		
		btnAniadirIni = new JButton("A\u00F1adir");
		
		btnAniadirIni.addActionListener(this);
		
		JLabel lblY_2 = new JLabel("Y:");
		
		textField_YFinal = new JTextField();
		textField_YFinal.setColumns(10);
		
		btnAniadirFin = new JButton("A\u00F1adir");
		
		btnAniadirFin.addActionListener(this);
		
			///////////////////////
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(Tablero, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalculaA, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
						.addComponent(lblEligeDimensiones)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldX, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldY, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPintaTablero)
						.addComponent(btnAniadirFail)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblX)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldX_Fail, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblY))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAniadirIni, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
										.addComponent(btnAniadirFin, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblX_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField_XFinal, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblNewLabel))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblX_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_InicioX, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
										.addComponent(lblAadeInicio))
									.addPreferredGap(ComponentPlacement.RELATED, 15, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblY_2)
										.addComponent(lblY_1))))
							.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldY_Fail, 0, 0, Short.MAX_VALUE)
								.addComponent(textField_InicioY, 0, 0, Short.MAX_VALUE)
								.addComponent(textField_YFinal, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
							.addGap(28))
						.addComponent(lblAadePuntos))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEligeDimensiones)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPintaTablero)
					.addGap(11)
					.addComponent(lblAadePuntos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(textFieldX_Fail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldY_Fail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAniadirFail)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAadeInicio)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX_1)
						.addComponent(lblY_1)
						.addComponent(textField_InicioY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_InicioX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAniadirIni)
					.addGap(9)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY_2)
						.addComponent(textField_YFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_XFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAniadirFin)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(btnCalculaA, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(Tablero, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.btnPintaTablero) {
			Variables.setHeigh(Integer.parseInt(textFieldX.getText()));
			Variables.setWidth(Integer.parseInt(textFieldY.getText()));		
			
			Utils.construyeMap();
			this.pintarTablero();
			Utils.limpiaDatos();
			
		}
		else if(e.getSource() == this.btnAniadirFail) {
			int y = Integer.parseInt(textFieldX_Fail.getText()) - 1;
			int x = Integer.parseInt(textFieldY_Fail.getText()) - 1;
			
			Utils.addFail(x, y);
			
			this.pintarTablero();
			
		}
		else if(e.getSource() == this.btnAniadirIni) {
			int y = Integer.parseInt(textField_InicioX.getText()) - 1;
			int x = Integer.parseInt(textField_InicioY.getText()) - 1;

			Nodo inicial = new Nodo(null,x,y);
			Variables.setInicial(inicial);
			
			Utils.addIni(x, y);
			
			this.pintarTablero();		
		}
		else if(e.getSource() == this.btnAniadirFin) {
			int y = Integer.parseInt(textField_XFinal.getText()) - 1;
			int x = Integer.parseInt(textField_YFinal.getText()) - 1;
			
			Nodo n = new Nodo(null, x, y);
			Variables.setTarget(n);
			
			Utils.addFin(x, y);
			
			this.pintarTablero();
		}
		else if(e.getSource() == this.btnCalculaA) {
			Variables.setAbierta( new ArrayList<Nodo>());
			List<Nodo> cerr = new ArrayList<Nodo>();
			Variables.setCerrada(cerr);
			
			ACtrl a_Est = new ACtrl(Variables.getInicial(), Variables.getMap());
		
			a_Est.calculaPathMinimo();
			
			Utils.pathHastaInicio();
			
			this.pintarTablero();
			
			//limpia recorrido
			
			for(int i = 0; i < Variables.getMap().length; i++) {
				for (int j =0; j < Variables.getMap()[i].length ; j++) {
					if(Variables.getMap()[i][j] == 1)
						Variables.getMap()[i][j] = 0;
				}
			}
			
			Variables.getTarget().setPadre(null);
		}
		
		
	}
}
