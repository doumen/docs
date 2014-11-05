package component;

import dao.GenericDao;
import entity.Arquivo;
import entity.Docto;

public abstract class  DoctoComponent<D,A> {

	public abstract GenericDao<D> getDaoDocto();
	
	public abstract GenericDao<A> getDaoArq();

	
	@SuppressWarnings("unchecked")
	public boolean saveDocto(Docto d,Arquivo a){
		try{
			D doc = (D) d;
			getDaoDocto().persist(doc);
			a.setDocto((Docto) doc);
			A arq = (A) a;									
			getDaoArq().persist(arq);			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public abstract Docto coletaDadosDoXml(Arquivo a);
}
