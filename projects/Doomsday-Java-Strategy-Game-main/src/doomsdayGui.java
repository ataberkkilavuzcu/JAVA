




import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class doomsdayGui implements ActionListener{

	 JFrame frmDoomsday;
	 static JButton  btnMarmara,btnAnkara,btnSoutE,btnMedi,btnAegean,btnEast,btnBlacksea;
	 static JLabel lblTurn; 
	 static JPanel panelWinp1;
	 static JTextPane txtpnHasWon,txtpnYouHaveDefeated;
	
	 static int tileN;
	 static String str="";
	 
	 static Main m = new Main();
	 
	 public static Main getM() {
		 return m;
	 }
	 public static void setText() {
		 txtpnYouHaveDefeated.setText("   The rebels have taken over! Sadly, you \r\n   failed to save your country and were \r\n\t\tleft in great shame!\r\n");
	 }
	 
	public static void setWinText(String abc) {
		txtpnHasWon.setText("\t"+abc+ " WON!");
		panelWinp1.setVisible(true);
		
	}
	
	
	public static String getStr() {
		return str;
	}


	public doomsdayGui() {
		

		frmDoomsday = new JFrame();
		frmDoomsday.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/gameicon.png")));
		frmDoomsday.setResizable(false);
		frmDoomsday.setTitle("Doomsday");
		frmDoomsday.setBounds(100, 100, 1280, 720);
		frmDoomsday.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoomsday.getContentPane().setLayout(null);
		
		JPanel panelMap = new JPanel();
		panelMap.setVisible(false);
		
		panelWinp1 = new JPanel();
		panelWinp1.setVisible(false);
		panelWinp1.setBounds(302, 138, 556, 358);
		frmDoomsday.getContentPane().add(panelWinp1);
		panelWinp1.setLayout(null);
		
		txtpnYouHaveDefeated = new JTextPane();
		txtpnYouHaveDefeated.setOpaque(false);
		txtpnYouHaveDefeated.setEditable(false);
		txtpnYouHaveDefeated.setText("   You have defeated the evil forces of your \r\n   enemies, and brought your country back \r\n\t\t\tto glory!\r\n");
		txtpnYouHaveDefeated.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtpnYouHaveDefeated.setBounds(10, 91, 536, 177);
		panelWinp1.add(txtpnYouHaveDefeated);
		
		txtpnHasWon = new JTextPane();
		txtpnHasWon.setFont(new Font("Times New Roman", Font.BOLD, 31));
		txtpnHasWon.setText("\t\t..... HAS WON!");
		txtpnHasWon.setOpaque(false);
		txtpnHasWon.setBounds(65, 11, 427, 52);
		panelWinp1.add(txtpnHasWon);
		
		JButton btnNewButton = new JButton("FINISH\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(184, 245, 199, 52);
		panelWinp1.add(btnNewButton);
		panelMap.setBounds(0, 0, 1280, 720);
		frmDoomsday.getContentPane().add(panelMap);
		panelMap.setLayout(null);
		 
		 JPanel panelTurn = new JPanel();
		 panelTurn.setOpaque(false);
		 panelTurn.setBounds(986, 559, 273, 123);
		 panelMap.add(panelTurn);
		 
		 lblTurn = new JLabel("PRESS TO START");
		 lblTurn.setForeground(Color.BLACK);
		 lblTurn.setHorizontalTextPosition(SwingConstants.CENTER);
		 lblTurn.setHorizontalAlignment(SwingConstants.CENTER);
		 lblTurn.setFont(new Font("Times New Roman", Font.BOLD, 37));
		 lblTurn.setBounds(new Rectangle(986, 556, 258, 123));
		 panelTurn.add(lblTurn);
		 
		 btnSoutE = new JButton("Soldier:\r\n");
		 btnSoutE.setFont(new Font("Times New Roman", Font.BOLD, 15));
		 btnSoutE.setBounds(929, 488, 139, 60);
		 panelMap.add(btnSoutE);
		 
		 btnMedi = new JButton("Soldier:\r\n");
		 btnMedi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		 btnMedi.setBounds(498, 559, 134, 60);
		 panelMap.add(btnMedi);
		 
		 btnAegean = new JButton("Soldier:\r\n");
		 btnAegean.setFont(new Font("Times New Roman", Font.BOLD, 15));
		 btnAegean.setBounds(96, 414, 126, 51);
		 panelMap.add(btnAegean);
		 
		 btnEast = new JButton("Soldier:\r\n");
		 btnEast.setFont(new Font("Times New Roman", Font.BOLD, 15));
		 btnEast.setBounds(793, 316, 126, 51);
		 panelMap.add(btnEast);
		 
		 btnBlacksea = new JButton("Soldier:\r\n");
		 btnBlacksea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		 btnBlacksea.setBounds(661, 126, 131, 51);
		 panelMap.add(btnBlacksea);
		
		btnAnkara = new JButton("Soldier:\r\n");
		btnAnkara.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAnkara.setBounds(334, 316, 114, 51);
		panelMap.add(btnAnkara);
		
		btnMarmara = new JButton("Soldier:");		
		

		btnMarmara.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnMarmara.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnMarmara.setBounds(151, 221, 126, 42);
		panelMap.add(btnMarmara);
		
		
	{  btnMarmara.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			    	
			    	  tileN= 1;
			    	  synchronized (m) {
			    		  m.notify();
					}
			    	  
			    	  
			      			   
		}});}
	   btnBlacksea.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 if (e.getSource() == btnBlacksea) { 		    	 
			    	  tileN= 2;
			    	  synchronized (m) {
			    		  m.notify();
					}
			    	 
			    	  
			    	  			      }			   
		}});
	   
	   btnAnkara.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 if (e.getSource() == btnAnkara) { 
			    	  tileN= 0;
			    	  synchronized (m) {
			    		  m.notify();
					}
			      }			   
		}});
	   
	   btnMedi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 if (e.getSource() == btnMedi) { 
			    	  
			    	  tileN= 3;
			    	  synchronized (m) {
			    		  m.notify();
					}
			      }			   
		}});
	   btnSoutE.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 if (e.getSource() == btnSoutE) { 
			    	  
			    	  tileN= 4;
			    	  synchronized (m) {
			    		  m.notify();
					}
			      }			   
		}});
	   
	   btnEast.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 if (e.getSource() == btnEast) { 
			    	  
			    	  tileN= 5;
			    	  synchronized (m) {
			    		  m.notify();
					}
			      }			   
		}});
	   
	   btnAegean.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 if (e.getSource() == btnAegean) { 
			    	  
			    	  tileN= 6;
			    	  synchronized (m) {
			    		  m.notify();
					}
			      }			   
		}});
		
		JTextPane txtpnTheBlackSea = new JTextPane();
		txtpnTheBlackSea.setText("The Black Sea");
		txtpnTheBlackSea.setOpaque(false);
		txtpnTheBlackSea.setForeground(Color.BLACK);
		txtpnTheBlackSea.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtpnTheBlackSea.setEditable(false);
		txtpnTheBlackSea.setBounds(441, 101, 191, 51);
		panelMap.add(txtpnTheBlackSea);
		
		JTextPane txtpnTheAegean = new JTextPane();
		txtpnTheAegean.setText("The Aegean");
		txtpnTheAegean.setOpaque(false);
		txtpnTheAegean.setForeground(Color.BLACK);
		txtpnTheAegean.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtpnTheAegean.setEditable(false);
		txtpnTheAegean.setBounds(86, 352, 191, 51);
		panelMap.add(txtpnTheAegean);
		
		JTextPane txtpnAnkara = new JTextPane();
		txtpnAnkara.setText("Ankara\r\n");
		txtpnAnkara.setOpaque(false);
		txtpnAnkara.setForeground(Color.BLACK);
		txtpnAnkara.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtpnAnkara.setEditable(false);
		txtpnAnkara.setBounds(498, 247, 191, 51);
		panelMap.add(txtpnAnkara);
		
		JTextPane txtpnTheMediterranean = new JTextPane();
		txtpnTheMediterranean.setText("The Mediterranean");
		txtpnTheMediterranean.setOpaque(false);
		txtpnTheMediterranean.setForeground(Color.BLACK);
		txtpnTheMediterranean.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtpnTheMediterranean.setEditable(false);
		txtpnTheMediterranean.setBounds(247, 543, 258, 37);
		panelMap.add(txtpnTheMediterranean);
		
		JTextPane txtpnTheSoutheast = new JTextPane();
		txtpnTheSoutheast.setText("The Southeast");
		txtpnTheSoutheast.setOpaque(false);
		txtpnTheSoutheast.setForeground(Color.BLACK);
		txtpnTheSoutheast.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtpnTheSoutheast.setEditable(false);
		txtpnTheSoutheast.setBounds(728, 529, 191, 51);
		panelMap.add(txtpnTheSoutheast);
		
		JTextPane txtpnTheEast = new JTextPane();
		txtpnTheEast.setForeground(Color.BLACK);
		txtpnTheEast.setEditable(false);
		txtpnTheEast.setOpaque(false);
		txtpnTheEast.setText("The East");
		txtpnTheEast.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtpnTheEast.setBounds(986, 288, 191, 51);
		panelMap.add(txtpnTheEast);
		
		JTextPane txtpnMarmara = new JTextPane();
		txtpnMarmara.setForeground(Color.BLACK);
		txtpnMarmara.setEditable(false);
		txtpnMarmara.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtpnMarmara.setOpaque(false);
		txtpnMarmara.setText("Marmara");
		txtpnMarmara.setBounds(84, 108, 208, 60);
		panelMap.add(txtpnMarmara);
		
		JLabel lblMap = new JLabel("");
		lblMap.setIcon(new ImageIcon(this.getClass().getResource("/map.jpeg")));
		lblMap.setBounds(new Rectangle(0, 0, 1280, 720));
		panelMap.add(lblMap);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(302, 136, 528, 347);
		panelMap.add(lblNewLabel);

		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 1280, 720);
		frmDoomsday.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		JButton btnStart = new JButton("START");
		btnStart.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 31));
		btnStart.setOpaque(false);
		btnStart.setBounds(493, 550, 188, 68);
		panelMenu.add(btnStart);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setForeground(Color.WHITE);
		txtpnTitle.setFont(new Font("Times New Roman", Font.BOLD, 52));
		txtpnTitle.setText("Doomsday\r\n");
		txtpnTitle.setOpaque(false);
		txtpnTitle.setBounds(493, 22, 320, 76);
		panelMenu.add(txtpnTitle);
		
		JTextPane txtpnText = new JTextPane();
		txtpnText.setForeground(Color.WHITE);
		txtpnText.setFont(new Font("Times New Roman", Font.BOLD, 23));
		txtpnText.setText("You were once a citizen of the proud Republic of Turkey. People were happy, and your country was thriving. However, internal and external factors have finally brought your country in the brink of destruction. The army got divided, different generals took arms claiming their ideals were the best for the country. While the civil war started, the rebels used the chaos to attack and capture the underdefended capital of the country, Ankara. The parliament has been dissolved and they extend their reach as days pass. As a general fighting for your ideals and your country, it is now up to you to decide the fate of Turkey. Will you emerge victorious, or will you see the destruction of your beloved country? Doomsday is upon us!\r\n\r\nYou all have ten turns to get back capital Ankara from the rebels, or you will lose the game as the rebels form their evil kingdom!\r\n\r\nYou lose if you have no territories left, and the general with all the provinces wins!\r\n");
		txtpnText.setOpaque(false);
		txtpnText.setEditable(false);
		txtpnText.setBounds(147, 142, 1006, 431);
		panelMenu.add(txtpnText);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(this.getClass().getResource("/storybgg.gif")));
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblMenu.setVerticalAlignment(SwingConstants.TOP);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(0, 0, 1280, 720);
		panelMenu.add(lblMenu);
		
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelMap.setVisible(true);
			}
		});
	
	
		
	}
	
	public static void setButtonText(Tile t) {
		if (t.getName()=="Marmara") {
			
			btnMarmara.setText("Soldier: "+t.getSoldiers());
			
		}	
		else if (t.getName()=="the Black Sea") {
			btnBlacksea.setText("Soldier: "+t.getSoldiers());
			
		}
		else if (t.getName()=="the Mediterranean") {
			btnMedi.setText("Soldier: "+t.getSoldiers());
			
		}
		else if (t.getName()=="the Southeast") {
			btnSoutE.setText("Soldier: "+t.getSoldiers());
			
		}
		else if (t.getName()=="the East") {
			btnEast.setText("Soldier: "+t.getSoldiers());
			
		}
		else if (t.getName()=="the Aegean") {
			btnAegean.setText("Soldier: "+t.getSoldiers());
			
		}
		else if (t.getName()=="Ankara") {
			btnAnkara.setText("Soldier: "+t.getSoldiers());
		}
		
			
		}
	
	
	
	
	public static void startingColor(Tile t) {
	if (t.getName()=="Marmara") {
		if (t.getOwner().getColor()=="Red") {
			btnMarmara.setBackground(Color.RED);
		} else {
			btnMarmara.setBackground(Color.CYAN);
		}
	}	
	else if (t.getName()=="Ankara") {
		if (t.getOwner().getColor()=="Red") {
			btnAnkara.setBackground(Color.RED);
		} else if(t.getOwner().getColor()=="Cyan") {
			btnAnkara.setBackground(Color.CYAN);
		}
	}
	else if (t.getName()=="the Black Sea") {
		if (t.getOwner().getColor()=="Red") {
			btnBlacksea.setBackground(Color.RED);
		} else {
			btnBlacksea.setBackground(Color.CYAN);
		}
		
	}
	else if (t.getName()=="the Mediterranean") {
		if (t.getOwner().getColor()=="Red") {
			btnMedi.setBackground(Color.RED);
		} else {
			btnMedi.setBackground(Color.CYAN);
		}
		
	}
	else if (t.getName()=="the Southeast") {
		if (t.getOwner().getColor()=="Red") {
			btnSoutE.setBackground(Color.RED);
		} else {
			btnSoutE.setBackground(Color.CYAN);
		}
		
	}
	else if (t.getName()=="the East") {
		if (t.getOwner().getColor()=="Red") {
			btnEast.setBackground(Color.RED);
		} else {
			btnEast.setBackground(Color.CYAN);
		}
		
	}
	else if (t.getName()=="the Aegean") {
		if (t.getOwner().getColor()=="Red") {
			btnAegean.setBackground(Color.RED);
		} else {
			btnAegean.setBackground(Color.CYAN);
		}
		
	}
	}
	
		
	

	   public static int getTileN() {
	
	    	return tileN;
	    }
	   
	
	    
	    
	public static void changeTurn(String Turn) {
		lblTurn.setText(Turn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


