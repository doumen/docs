package managedBeans.component;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CanvasMB {
	
	private String[] test = {"assinante 1","assinante 2"};

	public String[] getTest() {
		return test;
	}

	public void setTest(String[] test) {
		this.test = test;
	}
}
