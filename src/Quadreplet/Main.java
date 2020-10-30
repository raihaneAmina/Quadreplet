package Quadreplet;

import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		System.out.print("entrer votre opération: ");
		Scanner s = new Scanner(System.in);
		String chaine = s.nextLine();//"(a+b)-j*p+(-k)+(p+g)+(r+9)/(-y)";
		//chaine est l'opération dans laquelle on va calculer
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
			System.out.println(rs);
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
			System.out.println(rs);
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
	    	System.out.println(rs);					
	    	t++;
	    	if (t == 10) {
	    		t=0;
	    	}			
   		}}
			 catch (Exception e) {
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
				System.out.println(rs);
				i++;
				if (i == 10){i=0;}
				}
		    }
	}
	}
