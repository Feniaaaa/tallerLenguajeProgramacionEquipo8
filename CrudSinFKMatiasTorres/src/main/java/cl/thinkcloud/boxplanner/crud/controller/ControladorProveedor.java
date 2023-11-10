package cl.thinkcloud.boxplanner.crud.controller;

import cl.thinkcloud.boxplanner.crud.entity.ProveedorEntity;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller @RequestMapping("proveedor")
public class ControladorProveedor {

    @Autowired
    private ICrudService servicio;
    
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public ProveedorEntity agregarProveedor(@Valid @NonNull @RequestBody ProveedorEntity proveedor) {
        return servicio.save(proveedor);
    }

    

    //GET http://localhost:8080/proveedor/REST
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<ProveedorEntity> getAllProveedores() {
        return servicio.findAll();
    }

    
    
    //GET http://localhost:8080/proveedor/REST/6
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public ProveedorEntity getProveedor(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    

    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public ProveedorEntity updateProveedorById(@Valid @NonNull @RequestBody ProveedorEntity proveedor) {
        Optional<ProveedorEntity> p = servicio.findById(proveedor.getId());
        if (p.isPresent()==true) {
            return servicio.save(proveedor);
        } else return null;
    }
    
    
    
  
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public ProveedorEntity updateProveedorById(@Valid @NonNull @RequestBody ProveedorEntity proveedor, @PathVariable("id") int id) {
        Optional<ProveedorEntity> p = servicio.findById(id);
        if (p.isPresent()==true) {
        	proveedor.setId(id);
            return servicio.save(proveedor);
        } else return null;
    }
    

    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public ProveedorEntity deleteProveedorById(@Valid @NonNull @RequestBody ProveedorEntity proveedor) {
        Optional<ProveedorEntity> p =  servicio.findById(proveedor.getId());
        if (p.isPresent()==true) {
            servicio.delete(proveedor.getId());
            return proveedor;
        } else return null;
    }
    
    
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteProveedorById(@PathVariable("id") int id) {
        Optional<ProveedorEntity> p =  servicio.findById(id);
        if (p.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    
    
   //http://localhost:8080/proveedor/listar
    @GetMapping("listar")
    public String listar(Model model) {
        List<ProveedorEntity> proveedores=servicio.findAll();
        model.addAttribute("proveedores", proveedores);
        return "proveedor/index";
    }

    //http://localhost:8080/proveedor/nuevo
    @GetMapping("nuevo")
    public String agregar(Model model) {
        model.addAttribute("proveedor", new ProveedorEntity());
        return "proveedor/form";
    }

    //http://localhost:8080/proveedor/editar/id
    @GetMapping("editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<ProveedorEntity> proveedor=servicio.findById(id);
        model.addAttribute("proveedor", proveedor);
        return "proveedor/form";
    }

    //http://localhost:8080/proveedor/grabar
    @PostMapping("grabar")
    public String save(@Valid ProveedorEntity p, Model model) {
        servicio.save(p);
        return "redirect:/proveedor/listar";
    }

    //http://localhost:8080/proveedor/eliminar/id
    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        servicio.delete(id);
        return "redirect:/proveedor/listar";
    }
}
