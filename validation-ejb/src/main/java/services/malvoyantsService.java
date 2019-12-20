package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Capteur;
import entities.valeurs;

/**
 * Session Bean implementation class malvoyantsService
 */
@Stateless
@LocalBean
public class malvoyantsService implements malvoyantsServiceLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public malvoyantsService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterValeurs(String codeCapteur, String content) {
		// TODO Auto-generated method stub,
		TypedQuery<Capteur> x = em.createQuery("select c from Capteur c where c.reference=:codeCapteur", Capteur.class);
		Capteur c = x.setParameter("codeCapteur", codeCapteur).getSingleResult();
		valeurs v = new valeurs();
		v.setCapteur(c);
		v.setContent(content);
		v.setDateCreation();
		em.persist(v);

	}

	@Override
	public List getNodeValues(int id) {
		// TODO Auto-generated method stub,
		TypedQuery<valeurs> x = em.createQuery(
				"SELECT v from valeurs v,Capteur c,Noeud n WHERE v.capteur.idCap=c.idCap  and c.noeuds.id=:id  and  c.reference=v.capteur.reference ",
				valeurs.class);
		Set<valeurs> set = new HashSet<valeurs>();
		set.addAll(x.setParameter("id", id).getResultList());
		List<valeurs> c = new ArrayList<>();
		List<valeurs> cnew = new ArrayList<>();
		c.addAll(set);
		List<valeurs> result=new ArrayList<>();
		/*List<valeurs> result = c.stream()
				.sorted((o1, o2) -> o1.getCapteur().getReference().compareTo(o2.getCapteur().getReference()))
				.collect(Collectors.toList());*/
		List<valeurs> temp = c.stream().filter(e->e.getCapteur().getNomCapteur().equals("temperature"))
				.sorted((o1, o2) -> o2.getDateCreation().compareTo(o1.getDateCreation()))
				.collect(Collectors.toList());
		List<valeurs> gaz = c.stream().filter(e->e.getCapteur().getNomCapteur().equals("gaz"))
				.sorted((o1, o2) -> o2.getDateCreation().compareTo(o1.getDateCreation()))
				.collect(Collectors.toList());
		List<valeurs> lumonisite = c.stream().filter(e->e.getCapteur().getNomCapteur().equals("lumonisité"))
				.sorted((o1, o2) -> o2.getDateCreation().compareTo(o1.getDateCreation()))
				.collect(Collectors.toList());
		List<valeurs> color = c.stream().filter(e->e.getCapteur().getNomCapteur().equals("couleur"))
				.sorted((o1, o2) -> o2.getDateCreation().compareTo(o1.getDateCreation()))
				.collect(Collectors.toList());
		List<valeurs> flame = c.stream().filter(e->e.getCapteur().getNomCapteur().equals("flame"))
				.sorted((o1, o2) -> o2.getDateCreation().compareTo(o1.getDateCreation()))
				.collect(Collectors.toList());
		List<valeurs> hum = c.stream().filter(e->e.getCapteur().getNomCapteur().equals("humidity"))
				.sorted((o1, o2) -> o2.getDateCreation().compareTo(o1.getDateCreation()))
				.collect(Collectors.toList());
		List<valeurs> tag = c.stream().filter(e->e.getCapteur().getNomCapteur().equals("tag ref "))
				.sorted((o1, o2) -> o2.getDateCreation().compareTo(o1.getDateCreation()))
				.collect(Collectors.toList());
		if(tag.size()!=0)
		result.add(tag
				.get(0));
		if(hum.size()!=0)
		result.add(hum.get(0));
		if(temp.size()!=0)
		result.add(temp.get(0));
		if(lumonisite.size()!=0)
		result.add(lumonisite.get(0));
		if(flame.size()!=0)
		result.add(flame.get(0));
		if(color.size()!=0)
		result.add(color.get(0));
		if(gaz.size()!=0)
		result.add(gaz.get(0));
		
		// ras el ham
		/*for (int i = 0; i < result.size() - 1; i++)
		{

			if (result.get(i).getCapteur().getReference().equals(result.get(i + 1).getCapteur().getReference())) {
				if (result.get(i).getDateCreation().compareTo(result.get(i + 1).getDateCreation()) > 0 || result.get(i).getDateCreation().compareTo(result.get(i + 1).getDateCreation()) == 0) {
						System.out.println(result.get(i).getCapteur().getReference()+" "+"/"+result.get(i+1).getCapteur().getReference());
						result.remove(result.get(i + 1));
				} else {
					result.remove(result.get(i));
				}

			}
		}
*/
		// fin ras el ham
		
		return result;

	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "bonjour";

	}

}
