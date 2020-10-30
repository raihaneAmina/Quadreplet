package Quadreplet;

import java.util.Arrays;

public class compteur {
	
	
	
	public int compteur(String chaine, String op) {
		int cp = 0;			
		int pos = chaine.indexOf(op);
	    while (pos!= -1) 
	    {
	    	cp++;
	    	pos = chaine.indexOf(op, pos+2);   	
		}
		
	    
		return cp;
	}
	
	public int[] posit(String chaine) {
		compteur c = new compteur();
		int k1 = c.compteur(chaine, "*");
		int k2 = c.compteur(chaine, "/");
		int k = k1+k2;

		
		int pos1 = chaine.indexOf("*");
		int pos2 = chaine.indexOf("/");

		int Pos[]=new int[k];
		int i= 0;
		while (pos1 != -1) {
			
			Pos[i]=pos1;
			//System.out.println(pos1);
			pos1 = chaine.indexOf("*", pos1+2);
			i++;			
		}
		while (pos2 != -1) {
			
			Pos[i]=pos2;
			//System.out.println(pos2);
			pos2 = chaine.indexOf("/", pos2+2);
			i++;			
		}
		// tri la table Pos
		Arrays.sort(Pos);
		
		return Pos;
	}
	
	

}
