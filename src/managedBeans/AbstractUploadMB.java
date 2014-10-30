package managedBeans;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import component.DoctoComponent;

import entity.Arquivo;
import entity.Docto;

public abstract class AbstractUploadMB<D,A> {
	
	public abstract DoctoComponent<D, A> getDoctoComponent();
	
	
	protected Docto docto;
	protected Arquivo arq;
	
	public AbstractUploadMB(Class<D> d,Class<A> a) throws InstantiationException, IllegalAccessException{
			docto = (Docto) d.newInstance();
			arq = (Arquivo) a.newInstance();
	}
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}
	
	public LoginBean getLoginBean(){
		return this.loginBean;
	}

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        boolean salvou = saveFile(file.getContents());
        String m;
        if(salvou)
        	m = "Arquivo " + file.getFileName() + " inserido com sucesso ";
        else
        	m = "Não foi possível inserir o arquivo " + file.getFileName();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Atenção!", m));
    }
        		
	public boolean saveFile(byte[] file){
		arq.setArquivoXML(file);
		arq.setDataInclusao(Calendar.getInstance().getTime());
		arq.setDocto(docto);
		docto.setArquivoXml(arq);
		docto.setDataInclusao(arq.getDataInclusao());
		docto.setAssinante(getLoginBean().getAssinante());
		return getDoctoComponent().saveDocto(docto, arq);
	}
}
