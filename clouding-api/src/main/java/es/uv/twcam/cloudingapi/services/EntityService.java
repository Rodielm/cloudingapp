package es.uv.twcam.cloudingapi.services;


import java.util.List;



/**
 * AirplaneService
 */
public interface EntityService<T> {

    public List<T> getAll();

    public T findById(Integer id);

    public void delete(Integer id);

    public T save(T entity);
}