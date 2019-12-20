package services;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface malvoyantsServiceLocal {
	
	public void ajouterValeurs(String codeCapteur,String content);
	public String test();
	 public List getNodeValues(int id);

}
