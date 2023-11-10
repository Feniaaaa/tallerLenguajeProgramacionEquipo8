package cl.thinkcloud.boxplanner.crud.controller;

import cl.thinkcloud.boxplanner.crud.entity.BoletaEntity;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller @RequestMapping("boleta")
public class ControladorBoleta {

    @Autowired
    private ICrudService servicio;
    
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public BoletaEntity agregarBoleta(@Valid @NonNull @RequestBody BoletaEntity boleta) {
        return servicio.save(boleta);
    }

    
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<BoletaEntity> getAllBoletas() {
        return servicio.findAll();
    }

    
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public BoletaEntity getBoleta(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public BoletaEntity updateBoletaById(@Valid @NonNull @RequestBody BoletaEntity boleta) {
        Optional<BoletaEntity> p = servicio.findById(boleta.getId());
        if (p.isPresent()==true) {
            return servicio.save(boleta);
        } else return null;
    }
    
     
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public BoletaEntity updateBoletaById(@Valid @NonNull @RequestBody BoletaEntity boleta, @PathVariable("id") int id) {
        Optional<BoletaEntity> p = servicio.findById(id);
        if (p.isPresent()==true) {
        	boleta.setId(id);
            return servicio.save(boleta);
        } else return null;
    }

    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public BoletaEntity deleteBoletaById(@Valid @NonNull @RequestBody BoletaEntity boleta) {
        Optional<BoletaEntity> p =  servicio.findById(boleta.getId());
        if (p.isPresent()==true) {
            servicio.delete(boleta.getId());
            return boleta;
        } else return null;
    }
   
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteBoletaById(@PathVariable("id") int id) {
        Optional<BoletaEntity> p =  servicio.findById(id);
        if (p.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    
    //http://localhost:8080/boleta/listar
    @GetMapping("listar")
    public String listar(Model model) {
        List<BoletaEntity> boletas=servicio.findAll();
        model.addAttribute("boletas", boletas);
        return "boleta/index";
    }


    @GetMapping("nuevo")
    public String agregar(Model model) {
        model.addAttribute("boleta", new BoletaEntity());
        return "boleta/form";
    }


    @GetMapping("editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<BoletaEntity> boleta=servicio.findById(id);
        model.addAttribute("boleta", boleta);
        return "boleta/form";
    }


    @PostMapping("grabar")
    public String save(@Valid BoletaEntity p, Model model) {
        servicio.save(p);
        return "redirect:/boleta/listar";
    }


    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        servicio.delete(id);
        return "redirect:/boleta/listar";
    }
}
