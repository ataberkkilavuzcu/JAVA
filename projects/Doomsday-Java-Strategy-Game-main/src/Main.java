
public class Main {
		public static void main(String[] args) {
		
				try {
					
					doomsdayGui window = new doomsdayGui();
					window.frmDoomsday.setVisible(true);
					

					Player p1 = new Player("GENERAL", "Red");
					Player p2 = new Player("ADMIRAL", "Cyan");
					Player p3 = new Player("REBELS", "Gray");
					
					int i = 0, rebelturn = 0;
					
					Tile [] tiles = new Tile[7]; 

					tiles[0] = new Tile("Ankara", p3, 10);
					tiles[1] = new Tile("Marmara", null, 3);
					tiles[2] = new Tile("the Black Sea", null, 3);
					tiles[3] = new Tile("the Mediterranean", null, 3);
					tiles[4] = new Tile("the Southeast", null, 3);
					tiles[5] = new Tile("the East", null, 3);
					tiles[6] = new Tile("the Aegean", null, 3);
					
					Tile.setTiles(p1,p2,tiles);
					for (int j = 0; j < tiles.length; j++) {
						doomsdayGui.setButtonText(tiles[j]);
					}
					for (int j = 1; j < tiles.length; j++) {
						doomsdayGui.startingColor(tiles[j]);
					}
				
			
					while (i == 0) {
						boolean attackChk=false;
						
						int xy =0;
						
						int xz;
						
					
						
						boolean plchk = true;
						boolean plchk2 = true;
					
						if (tiles[0].getOwner() == p1 || tiles[1].getOwner() == p1 ||  tiles[2].getOwner() == p1 || tiles[3].getOwner() == p1 || tiles[4].getOwner() == p1 || tiles[5].getOwner() == p1 || tiles[6].getOwner() == p1 ){
						

						doomsdayGui.changeTurn("P1 DEPLOY");
						while(plchk == true) {
							synchronized (doomsdayGui.getM()) {
								doomsdayGui.getM().wait();
							}
							xy = doomsdayGui.tileN;				
							if(tiles[xy].getOwner() == p1) {
								if (tiles[0].getOwner() == p1) {
			                        tiles[xy].Deploy(7);
			                    }
			                    else {
			                        tiles[xy].Deploy(4);
			                    }
		
							plchk = false;
							}
						}
						plchk = false;
						doomsdayGui.changeTurn("P1 ATTACK");
						while (plchk == false) {
							
							Tile.setattackChk(false);
							
							while(Tile.getattackChk()==false) {
								synchronized (doomsdayGui.getM()) {
									doomsdayGui.getM().wait();
								}
								xz = doomsdayGui.tileN;	
							if (tiles[xy].getOwner() == p1 && tiles[xz].getOwner() != p1) {
							tiles[xy].attack(p1, tiles[xz]);
					
							if (Tile.getattackChk()==true) {
								plchk = true;
							}
							
							}
							}
							}
						}
						
						if (tiles[0].getOwner() == p2 || tiles[1].getOwner() == p2 ||  tiles[2].getOwner() == p2 || tiles[3].getOwner() == p2 || tiles[4].getOwner() == p2 || tiles[5].getOwner() == p2 || tiles[6].getOwner() == p2 ){
						doomsdayGui.changeTurn("P2 DEPLOY");
						while (plchk2 == true) {
							synchronized (doomsdayGui.getM()) {
								doomsdayGui.getM().wait();
							}
							xy = doomsdayGui.tileN;
							if(tiles[xy].getOwner() == p2) {
								if (tiles[0].getOwner() == p2) {
			                        tiles[xy].Deploy(7);
			                    }
			                    else {
			                        tiles[xy].Deploy(4);
			                    }
								
								plchk2 = false;
								}
						}
						plchk2=false;
						doomsdayGui.changeTurn("P2 ATTACK");
						while (plchk2 == false) {
							
							Tile.setattackChk(false);
							while(Tile.getattackChk()==false) {
								synchronized (doomsdayGui.getM()) {
									doomsdayGui.getM().wait();
								}
								xz = doomsdayGui.tileN;	
							if (tiles[xy].getOwner() == p2 && tiles[xz].getOwner() != p2) {				
								tiles[xy].attack(p2, tiles[xz]);
							if (Tile.getattackChk()==true) {
								plchk2 = true;
							}	
							
							}
							}
							}
						}	

						
						
						
			
						
						
						if (tiles[0].getOwner() == tiles[1].getOwner() && tiles[1].getOwner() == tiles[2].getOwner() && tiles[2].getOwner() == tiles[3].getOwner() && tiles[3].getOwner() == tiles[4].getOwner() && tiles[4].getOwner() == tiles[5].getOwner() && tiles[5].getOwner() == tiles [6].getOwner() ) {
							doomsdayGui.setWinText(tiles[0].getOwner().getName()+" HAS");
							i = 1;
						}
				
						
						if (tiles[0].getOwner() == tiles[1].getOwner() && tiles[1].getOwner() == tiles[2].getOwner() && tiles[2].getOwner() == tiles[3].getOwner() && tiles[3].getOwner() == tiles[4].getOwner() && tiles[4].getOwner() == tiles[5].getOwner() && tiles[5].getOwner() == tiles [6].getOwner() ) {
							doomsdayGui.setWinText(tiles[0].getOwner().getName()+" HAS");
							i = 1;
						}
						
						if (tiles[0].getOwner() == p3) {
							rebelturn += 1;
						}
						else {
							rebelturn = 0;
						}
						if (rebelturn == 10) {
							doomsdayGui.setWinText("REBELS HAVE");
							doomsdayGui.setText();
							i = 1;
						}
						
				
				
				}

				}
					
				 catch (Exception e) {
					e.printStackTrace();
				};
			
		
			}
		
		}


		
	
		
		
		
		