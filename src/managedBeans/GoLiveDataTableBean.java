package managedBeans;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.text.WordUtils;

@ManagedBean
@ViewScoped
public class GoLiveDataTableBean implements Serializable {

	private static final long serialVersionUID = -1112842844182517083L;

	public boolean validateField(final String field, final String args) {
		return Arrays.asList(args.replace(" ", "").split(",")).contains(field);
	}

	public String getHeaderColumn(final Properties properties,
			final String field) {
		if (properties.get(field) == null) {
			return WordUtils.capitalizeFully(field);
		} else {
			return properties.get(field).toString();
		}
	}

	// TODO Tratar tipos de objetos posteriorMente
	public Object rowGenericTable(final Object instance, final String field) {
		Object retorno = null;
		if(instance==null)
			return null;
		try {
			if(!field.contains(".")){
				retorno = instance
						.getClass()
						.getDeclaredMethod("get" + capitalize(field))
						.invoke(instance);				
			}else{
				String[] fields = field.split(java.util.regex.Pattern.quote("."));
				Object o = instance;
				for(String f :fields){
					o = o.getClass().getDeclaredMethod("get" + capitalize(f)).invoke(o);
				}
				retorno =  o;
			}
			if(retorno instanceof java.util.Calendar){
				Calendar c = (Calendar) retorno;
				return formatCalendar(c);
			}				
			return retorno;
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Object formatCalendar(Calendar c) {		
		return c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR);
	}

	public Field[] getFields(final List<Class<?>> list) {
		if (!list.isEmpty()) {
			return list.get(0).getClass().getDeclaredFields();
		}
		throw new RuntimeException(
				"Erro ao carregar component, lista esta vazia");
	}

	private String capitalize(String field)
	{
	  return Character.toUpperCase(field.charAt(0)) + field.substring(1);
	}
	
}
