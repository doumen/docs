package dao;

import java.util.List;
import entity.Assinante;

public interface GenericDoctosDao<D> extends GenericDao<D> {
	public List<D> findDoctosDoAssinante(Assinante a);
}
