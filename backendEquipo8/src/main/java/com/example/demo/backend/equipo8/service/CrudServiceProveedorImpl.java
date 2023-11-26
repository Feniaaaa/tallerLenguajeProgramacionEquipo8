package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.ProveedorDTO;
import com.example.demo.backend.equipo8.entity.LocalidadEntity;
import com.example.demo.backend.equipo8.entity.ProveedorEntity;
import com.example.demo.backend.equipo8.repository.IProveedorRepository;




@Component
@Service

public class CrudServiceProveedorImpl implements ICrudServiceProveedor {

	@Autowired
	private IProveedorRepository data;

	public List<ProveedorDTO> findAll() {
		List<ProveedorEntity> listE = (List<ProveedorEntity>) data.findAll();
		List<ProveedorDTO> listDto = new ArrayList<ProveedorDTO>();
		for (ProveedorEntity e : listE) {
            ProveedorDTO proveedorDTO = e.toDTO();
            LocalidadEntity localidadEntity = e.getLocalidad();
            if (localidadEntity != null) {
                proveedorDTO.setLocalidad(localidadEntity.toDTO());
            }
            listDto.add(proveedorDTO);
        }
		return listDto;
	}

	public Optional<ProveedorDTO> findById(int id) {
		Optional<ProveedorEntity> oe = data.findById(id);
		ProveedorEntity e = oe.get();
		ProveedorDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
	}

	public ProveedorDTO save(ProveedorDTO dto) {
		ProveedorEntity e = data.save(dto.toEntity());
		return e.toDTO();
	}

	public void delete(ProveedorDTO p) {
		data.delete(p.toEntity());
	}
	
    

}