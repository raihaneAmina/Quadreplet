package Quadreplet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.UIManager;

@SuppressWarnings({ "serial", "unused" })

public class Qdrplt extends JFrame {
	

		private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		private int w = screenSize.width;
		private int h = screenSize.height;
		private JPanel contentPane;
		private JTextArea tATxt;
		private JButton btnRun;
		private JTextArea tAResult;
		private JScrollPane scrollPane;
		private JScrollPane scrollPane_1;
		private JSeparator separator_5;
		ArrayList sArray;
		
		@SuppressWarnings("rawtypes")
		private JComboBox comboBox;
		Connection con=null;
		java.sql.PreparedStatement pst = null;
		ResultSet rs = null;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Qdrplt frame = new Qdrplt();
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
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Qdrplt() {
			setUndecorated(true);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {
					int ret = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter l�application");
					if (ret == 0) {         
						//System.exit(0);
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						}else {
						setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
						}
				}
			});
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(w/4, h/7, 750, 528);
			setTitle("Systeme Login");
			//setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/logo.png").getFile()));
			contentPane = new JPanel();
			contentPane.setBackground(new Color(36,47,65));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 378, 528);
			panel.setBackground(new Color(97,212,195));
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel Master = new JLabel("Master 1");
			Master.setForeground(Color.BLACK);
			Master.setBounds(0, 30, 378, 40);
			Master.setHorizontalAlignment(SwingConstants.CENTER);
			Master.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(Master);
			
			
			JLabel lblNewLabel = new JLabel("Génération de code intermédiaire");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBounds(0, 90, 378, 40);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel2 = new JLabel("sous forme de quadruplet");
			lblNewLabel2.setForeground(Color.BLACK);
			lblNewLabel2.setBounds(0, 120, 378, 40);
			lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel2);
			
			JLabel lblNewLabel3 = new JLabel("pour une expression arithmétique ");
			lblNewLabel3.setForeground(Color.BLACK);
			lblNewLabel3.setBounds(0, 150, 378, 40);
			lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel3.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel3);
			
			JLabel lblNewLabel4 = new JLabel("réaliser par: ");
			lblNewLabel4.setForeground(Color.BLACK);
			lblNewLabel4.setBounds(40, 200, 378, 40);
			lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel4.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel4);
			
			JLabel lblNewLabel5 = new JLabel("- SEHAL Amina Rihane");
			lblNewLabel5.setForeground(Color.BLACK);
			lblNewLabel5.setBounds(80, 230, 378, 40);
			lblNewLabel5.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel5.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel5);
			
			JLabel lblNewLabel6 = new JLabel("- Raieb Rekia");
			lblNewLabel6.setForeground(Color.BLACK);
			lblNewLabel6.setBounds(80, 260, 378, 40);
			lblNewLabel6.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel6.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel6);
			
			JLabel lblNewLabel7 = new JLabel("Encadré par: ");
			lblNewLabel7.setForeground(Color.BLACK);
			lblNewLabel7.setBounds(40, 290, 378, 40);
			lblNewLabel7.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel7.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel7);
			
			JLabel lblNewLabel8 = new JLabel("- Mm. BOUDALI Fatiha");
			lblNewLabel8.setForeground(Color.BLACK);
			lblNewLabel8.setBounds(80, 320, 378, 40);
			lblNewLabel8.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel8.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel8);
			
			JLabel lblNewLabel9 = new JLabel("Ingénierie de Logiciel");
			lblNewLabel9.setForeground(Color.BLACK);
			lblNewLabel9.setBounds(0, 380, 378, 40);
			lblNewLabel9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel9.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
			//lblNewLabel.setBounds(0, 41, 667, 40);
			panel.add(lblNewLabel9);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setForeground(Color.BLACK);
			separator_2.setBackground(Color.BLACK);
			separator_2.setBounds(46, 425, 280, 2);
			panel.add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setForeground(Color.BLACK);
			separator_3.setBackground(Color.BLACK);
			separator_3.setBounds(79, 450, 206, 2);
			panel.add(separator_3);
			
			JLabel label = new JLabel("");
			label.setBounds(46, 137, 280, 277);
			panel.add(label);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			//ImageIcon img = new ImageIcon(Qdrplt.class.getResource("/img/timetable.png"));
			//label.setIcon(img);
			JLabel lblNewLabel_1 = new JLabel("Opération");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(419, 99, 163, 14);
			lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			contentPane.add(lblNewLabel_1);
			
			JLabel lblMotDePasse = new JLabel("Résultat");
			
			lblMotDePasse.setForeground(Color.WHITE);
			lblMotDePasse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblMotDePasse.setBounds(419, 195, 163, 24);
			contentPane.add(lblMotDePasse);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(419, 123, 285, 39);
			contentPane.add(scrollPane);
			
			tATxt = new JTextArea();
			scrollPane.setViewportView(tATxt);
			tATxt.setFont(new Font("Monospaced", Font.BOLD, 16));
			tATxt.setLineWrap(true);
			
		
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(419, 230, 285, 160);
			tAResult= new JTextArea();
			scrollPane_1.setViewportView(tAResult);
			tAResult.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			contentPane.add(scrollPane_1);
			tAResult.setLineWrap(true);
			
			//tAResult.setText("oppp");
			
			JSeparator separator = new JSeparator();
			separator.setBounds(419, 172, 285, 2);
			contentPane.add(separator);
			
			JButton btnRun = new JButton("Calculer");
			btnRun.setForeground(Color.BLACK);
			btnRun.setBackground(new Color(97,212,195));
			btnRun.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			btnRun.setBounds(500, 410, 122, 48);
			contentPane.add(btnRun);			
			
			JLabel lblConnectezvous = new JLabel("Calcule De Quadreplet");
			lblConnectezvous.setHorizontalAlignment(SwingConstants.CENTER);
			lblConnectezvous.setForeground(Color.WHITE);
			lblConnectezvous.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblConnectezvous.setBounds(380, 27, 370, 39);
			contentPane.add(lblConnectezvous);
			
			JLabel lblSehalAminaRihane = new JLabel("SEHAL Amina Rihane & RAIEB Rekia");
			lblSehalAminaRihane.setBounds(373, 489, 367, 28);
			contentPane.add(lblSehalAminaRihane);
			lblSehalAminaRihane.setForeground(Color.WHITE);
			lblSehalAminaRihane.setHorizontalAlignment(SwingConstants.CENTER);
			lblSehalAminaRihane.setFont(new Font("Utsaah", Font.PLAIN, 14));
					
			JSeparator separator_4 = new JSeparator();
			separator_4.setBounds(558, 437, 145, -3);
			contentPane.add(separator_4);
			
			
			JLabel label_1 = new JLabel("\u0640\u0640\u0640");
			label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent arg0) {
					label_1.setForeground(Color.WHITE);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					label_1.setForeground(new Color(97,212,195));
					
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					setState(JFrame.ICONIFIED);
				}
			});
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Arial", Font.BOLD, 18));
			label_1.setBounds(674, 11, 29, 20);
			contentPane.add(label_1);
			
			JLabel lblX = new JLabel("x");
			lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent arg0) {
					
					lblX.setForeground(Color.WHITE);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					
					lblX.setForeground(new Color(97,212,195));
					
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
					
				}
			});
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Arial", Font.BOLD, 18));
			lblX.setBounds(705, 11, 29, 20);
			contentPane.add(lblX);
			
			btnRun.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String chaine = tATxt.getText();
					compteur c = new compteur();
					// calculer le nombre des opérateur
					int cptP = c.compteur(chaine, "(");
					int cptm = c.compteur(chaine, "*");
					int cptd = c.compteur(chaine, "/");
					int cptad = c.compteur(chaine, "+");
					int cptsu = c.compteur(chaine, "-");
					String chainenv=null;	
					String []T = new String [100];
			// effacer les parentaises est remplir ses operation dans un table T
					String[] arrOfStr = chaine.split("[()]"); 
					sArray = new ArrayList();
					
				    int j =0;
			// si le nombre les () n'est pas vide .. on calcule ses opération 
				    if (cptP!=0) 
				    {
						for (int i = 1; i < arrOfStr.length; i=i+2)
						{
			//si la taille du String =3 alors est une opération de 2 var (var1 op var2)
						if(arrOfStr[i].length()==3) {
						String r1 = Character.toString(arrOfStr[i].charAt(0));
						String r2 = Character.toString(arrOfStr[i].charAt(1));
						String r3 = Character.toString(arrOfStr[i].charAt(2));
						String f = r1+r2+r3;	
						String in = ""+j; 
						String rs ="("+r2+","+r1+","+r3+","+in+")" ;
						chaine = chaine.replace(f, in);	
						
						sArray.add(rs);		       

						arrOfStr[i]=in;
						j++;
						if (j == 10) {j=0;}
					}
			//si la taille du String =3 alors est une opération d'un seul var (op var)
					if(arrOfStr[i].length()==2) 
					{
						String r1 = Character.toString(arrOfStr[i].charAt(0));
						String r2 = Character.toString(arrOfStr[i].charAt(1));
						String f = r1+r2;	
						String in = ""+j; 
			// in est le résultat de cette opération
						String rs ="("+r1+","+r2+", ,"+in+")" ;
			// remplacer l'opération f par le variable in 
						chaine = chaine.replace(f, in);
						sArray.add(rs);	
						//tAResult.setText(rs);
						//System.out.println(rs);
						arrOfStr[i]=in;
							j++;
							if (j == 10) {j=0;}			
						}			
					}
							chaine="";
							for (int i = 1; i < arrOfStr.length; i++) 
							{
						    	// regrouper la table dans le string
								chaine=chaine+arrOfStr[i];
						    }		
				    }
			// si le nombre des * ou /  n'est pas vide .. on calcule ses opération
				    int t=j;
				    if ((cptm!=0)||(cptd!=0)) 
				    {
				    	try {
				    		int k1 = c.compteur(chaine, "*");
				    		int k2 = c.compteur(chaine, "/");
				    		int k = k1+k2;
				    		
				    		int Pos[]=new int[k];
				    		Pos = c.posit(chaine);
				    		
				    		chainenv = chaine;
				    		
				   	for (int l = 0; l < Pos.length ; l++) {
				 		Pos = c.posit(chainenv);
						String r1 = Character.toString(chainenv.charAt(Pos[l]-1));
				    	String r2 = Character.toString(chainenv.charAt(Pos[l]));
				    	String r3 = Character.toString(chainenv.charAt(Pos[l]+1));
				    	String f = r1+r2+r3;	
				    	String in = ""+t; 
				    	chainenv = chainenv.replace(f, in);	
				    	String rs ="("+r2+","+r1+","+r3+","+in+")" ;
				    	sArray.add(rs);	
				    	tAResult.setText(rs);
				    	//System.out.println(rs);					
				    	t++;
				    	if (t == 10) {
				    		t=0;
				    	}			
			   		}}
						 catch (Exception c1) {
							// TODO: handle exception
						}
				    	chaine = chainenv;
				    }
				    int i=t;
			// si le nombre des + ou - n'est pas vide .. on calcule ses opération
				  if ((cptad!=0)||(cptsu!=0)) 
				    {	    	
						while (chaine.length() != 1) 
						{
							String r1 = Character.toString(chaine.charAt(0));
							String r2 = Character.toString(chaine.charAt(1));
							String r3 = Character.toString(chaine.charAt(2));
							String f = r1+r2+r3;	
							String in = ""+i; 
							String rs ="("+r2+","+r1+","+r3+","+in+")" ;
							chaine = chaine.replace(f, in);	
							sArray.add(rs);	
							//System.out.println(rs);
							i++;
							if (i == 10){i=0;}
							}
					    }
				  //tAResult.setCaret((Caret) s);
				  tAResult.setText(sArray.toString());
				}
				
			});

			

		}


}	
	



