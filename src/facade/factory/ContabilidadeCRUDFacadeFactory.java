package facade.factory;

import javax.enterprise.inject.Produces;

import facade.GenericCRUDFacade;
import model.Contabilidade;

public class ContabilidadeCRUDFacadeFactory {

	@Produces
	public GenericCRUDFacade<Contabilidade> createContabilidadeCRUDFacade(){
		return new ContabilidadeCRUDFacade();
	}

	public class ContabilidadeCRUDFacade implements GenericCRUDFacade<Contabilidade>{

		@Override
		public boolean acaoAntesRemover(Contabilidade entity) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void acaoNaoRemocao(Contabilidade entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void acaoComponenteNaoRemoveuComSucesso() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
