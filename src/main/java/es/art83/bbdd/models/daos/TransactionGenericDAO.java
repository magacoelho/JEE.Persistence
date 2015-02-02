package es.art83.bbdd.models.daos;

import java.util.List;

public interface TransactionGenericDAO<T, ID> extends GenericDAO<T, ID>{
	
	public void begin();
	public void commit();
	public void rollback();
	
	public List<T> find(String[] attributes, String[] values); //like + and
	public List<T> find(String[] attributes, String[] values, String order, int index, int size);
}
