package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.entity.BoletaEntity;
import cl.thinkcloud.boxplanner.crud.repository.IBoletaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
@Service
public class CrudServiceBoletaImpl implements ICrudService {

    @Autowired
    private IBoletaRepository data;

    @Override
    public List<BoletaEntity> findAll() {
        return (List<BoletaEntity>)data.findAll();
    }

    @Override
    public Optional<BoletaEntity> findById(int id) {
        return data.findById(id);
    }

    @Override
    public BoletaEntity save(BoletaEntity p) {
        BoletaEntity boleta = data.save(p);
        return boleta;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }
    

}