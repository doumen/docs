package inspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Inspector {

  public static List<Map.Entry<String, Object>> inspect(
      Object bean) {
    Map<String, Object> props = new LinkedHashMap<String, Object>();

    try {
      BeanInfo info = Introspector.getBeanInfo(bean
          .getClass(), Object.class);
      for (PropertyDescriptor propertyDesc : info
          .getPropertyDescriptors()) {
        String name = propertyDesc.getDisplayName();
        Method reader = propertyDesc.getReadMethod();
        Object value = reader.invoke(bean);
        props.put(name, value == null ? "" : value);
      }
    } catch (IntrospectionException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }

    return new ArrayList<Map.Entry<String, Object>>(props
        .entrySet());
  }
}