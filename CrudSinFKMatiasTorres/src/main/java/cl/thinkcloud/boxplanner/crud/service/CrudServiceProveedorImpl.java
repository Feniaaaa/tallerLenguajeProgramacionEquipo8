package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.entity.ProveedorEntity;
import cl.thinkcloud.boxplanner.crud.repository.IProveedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
@Service
public class CrudServiceProveedorImpl implements ICrudService {

    @Autowired
    private IProveedorRepository data;

    @Override
    public List<ProveedorEntity> findAll() {
        return (List<ProveedorEntity>)data.findAll();
    }

    @Override
    public Optional<ProveedorEntity> findById(int id) {
        return data.findById(id);
    }

    @Override
    public ProveedorEntity save(ProveedorEntity p) {
        ProveedorEntity proveedor = data.save(p);
        return proveedor;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }
    

}