package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.entity.ProveedorEntity;

public interface ICrudService {
    public List<ProveedorEntity> findAll();
    public Optional<ProveedorEntity> findById(int id);
    public ProveedorEntity save(ProveedorEntity proveedor);
    public void delete(int id);
}
