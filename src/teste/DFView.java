package teste;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "dfView")
public class DFView {

	public void viewCars() {
		RequestContext.getCurrentInstance().openDialog("viewCars");
	}

	public void viewCarsCustomized() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", false);
		options.put("resizable", false);
		options.put("contentHeight", 320);

		RequestContext.getCurrentInstance().openDialog("viewCars", options,
				null);
	}
	
	public void print(){
		System.out.println("printou!!");
		RequestContext.getCurrentInstance().openDialog("viewCars");
	}
}
