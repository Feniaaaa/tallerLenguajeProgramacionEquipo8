package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.entity.BoletaEntity;

public interface ICrudService {
    public List<BoletaEntity> findAll();
    public Optional<BoletaEntity> findById(int id);
    public BoletaEntity save(BoletaEntity boleta);
    public void delete(int id);
}
