package fr.imie.ecommerce.metier;

public class Util {
	
	public static boolean testIdEtMdp(String mdp, String id){
		
		if("1".equals(mdp)&&"eco".equals(id))
		{
			return true;
		}else{
			
			return false;
			
			// modif
		}
		
	}

}
