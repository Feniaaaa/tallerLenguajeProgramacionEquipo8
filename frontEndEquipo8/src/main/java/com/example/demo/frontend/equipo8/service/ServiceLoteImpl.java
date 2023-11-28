package com.example.demo.frontend.equipo8.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.frontend.equipo8.dto.BoletaDTO;
import com.example.demo.frontend.equipo8.dto.LoteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class ServiceLoteImpl implements IServiceLote {

	//Este es el user y password que se validan contra el controlador del backend de acuerdo al SecurityConfig
    private String getBasicAuthHeader() {
        String credentials = "admin:1234";
        return new String(Base64.getEncoder().encodeToString(credentials.getBytes()));
    }
    
    
	
    private  HttpHeaders httpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + getBasicAuthHeader());
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }
	
    
    
	@Override
	public List<LoteDTO> findAllREST() throws Exception {
		
		List<LoteDTO> boletasList = new ArrayList();
		
        ResponseEntity<List<LoteDTO>> responseEntity = new RestTemplate().exchange("http://localhost:8080/lote/REST",
                HttpMethod.GET, new HttpEntity<>(httpHeaders()), new ParameterizedTypeReference<List<LoteDTO>>(){});
        
        if (responseEntity.getStatusCode().is2xxSuccessful())
        {
        	if (responseEntity.hasBody())
        	{
	        	 boletasList = responseEntity.getBody();
	        }
        }
        else
        {
        	throw new Exception(this.getClass().getCanonicalName() + " method:findAllREST Error API Rest");
        }
		
		return boletasList;
	}

	
	
	@Override
	public LoteDTO findByIdREST(int id) throws Exception {
		LoteDTO dto = null;

        ResponseEntity<LoteDTO> responseEntity = new RestTemplate().exchange("http://localhost:8080/lote/REST/" + id ,
                HttpMethod.GET, new HttpEntity<>(httpHeaders()), new ParameterizedTypeReference<LoteDTO>(){});
        
        if (responseEntity.getStatusCode().is2xxSuccessful())
        {
        	if (responseEntity.hasBody())
        	{
	        	 dto = responseEntity.getBody();
	        }
        }
        else
        {
        	throw new Exception(this.getClass().getCanonicalName() + " method:findByIdREST Error API Rest");
        }
        return dto;
	}

	
	
	
	@Override
	public LoteDTO saveREST(LoteDTO p) throws Exception {
		LoteDTO dto = null;
			
		ResponseEntity<LoteDTO> responseEntity = new RestTemplate().exchange("http://localhost:8080/lote/REST",
                HttpMethod.POST, new HttpEntity<>(p, httpHeaders()), new ParameterizedTypeReference<LoteDTO>(){});
		
        if (responseEntity.getStatusCode().is2xxSuccessful())
        {
        	if (responseEntity.hasBody())
        	{
	        	 dto = responseEntity.getBody();
	        }
        }
        else
        {
        	throw new Exception(this.getClass().getCanonicalName() + " FrontEdnd Service method:saveREST Error API Rest");
        }
        return dto;

	}
	
	
	

	@Override
	public LoteDTO deleteREST(int id) throws Exception {
		LoteDTO dto = null;
			
		ResponseEntity<LoteDTO> responseEntity = new RestTemplate().exchange("http://localhost:8080/lote/REST/" + id ,
                HttpMethod.DELETE, new HttpEntity<>(httpHeaders()), new ParameterizedTypeReference<LoteDTO>(){});
		
        if (responseEntity.getStatusCode().is2xxSuccessful())
        {
        	if (responseEntity.hasBody())
        	{
	        	 dto = responseEntity.getBody();
	        }
        }
        else
        {
        	throw new Exception(this.getClass().getCanonicalName() + " FrontEdnd Service method:deleteREST Error API Rest");
        }
        return dto;

	}

}
