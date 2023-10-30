package com.example.demo.backend.equipo8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.backend.equipo8.dto.UsuarioDTO;
import com.example.demo.backend.equipo8.entity.UsuarioEntity;
import com.example.demo.backend.equipo8.repository.IUsuarioRepository;




@Component
@Service
public class CrudServiceUsuarioImpl implements ICrudService {

	@Autowired
	private IUsuarioRepository data;

	public List<UsuarioDTO> findAll() {
		List<UsuarioEntity> listE = (List<UsuarioEntity>) data.findAll();
		List<UsuarioDTO> listDto = new ArrayList<UsuarioDTO>();
		for (UsuarioEntity e : listE) {
			listDto.add(e.toDTO());
		}
		return listDto;
	}

	public Optional<UsuarioDTO> findById(int id) {
		Optional<UsuarioEntity> oe = data.findById(id);
		UsuarioEntity e = oe.get();
		UsuarioDTO dto = e.toDTO();
		return Optional.ofNullable(dto);
	}

	public UsuarioDTO save(UsuarioDTO dto) {
		UsuarioEntity e = data.save(dto.toEntity());
		return e.toDTO();
	}

	public void delete(UsuarioDTO p) {
		data.delete(p.toEntity());
	}
	
    

}