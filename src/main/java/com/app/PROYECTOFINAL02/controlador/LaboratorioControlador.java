package com.app.PROYECTOFINAL02.controlador;

import com.app.PROYECTOFINAL02.entidad.Laboratorio;
import com.app.PROYECTOFINAL02.servicio.CorreoElectronicoDuplicadoException;
import com.app.PROYECTOFINAL02.servicio.LaboratorioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice
public class LaboratorioControlador {



@ExceptionHandler(CorreoElectronicoDuplicadoException.class)
    public ModelAndView handleLaboratorioDuplicadoException(CorreoElectronicoDuplicadoException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }


    @Autowired
    private LaboratorioServicio servicio;

    @GetMapping({"/index","/"})
    public String listarLaboratorios(Model modelo){
        modelo.addAttribute("index", servicio.listarTodosLosLaboratorios());
        return "index"; //nos retorna al archiivo Laboratorio
    }

    @GetMapping("/index/nuevo")
    public String crearLaboratorioFormulario(Model modelo){
        Laboratorio laboratorio = new Laboratorio();
        modelo.addAttribute("laboratorio", laboratorio);
        return "crear_laboratorio";
    }

    @PostMapping("/index")
    public String guardarLaboratorio(@ModelAttribute("laboratorio") Laboratorio laboratorio){
        servicio.guardarLaboratorio(laboratorio);
        return "redirect:/index";
    }

    @GetMapping("/index/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("laboratorio", servicio.obteberLaboratorioPorId(id));
        return "editar_laboratorio";
    }

   @PostMapping("/index/{id}")
   public String actualizarLaboratorio(@PathVariable long id, @ModelAttribute("laboratorio") Laboratorio laboratorio, Model modelo){
    Laboratorio laboratorioExistente = servicio.obteberLaboratorioPorId(id);
    laboratorioExistente.setId(id);
    laboratorioExistente.setCodigolaboratorio(laboratorio.getCodigolaboratorio());
    laboratorioExistente.setServiciolabortorio(laboratorio.getServiciolabortorio());
    laboratorioExistente.setProveedor(laboratorio.getProveedor());
    laboratorioExistente.setCantidad(laboratorio.getCantidad());
    laboratorioExistente.setPrecio(laboratorio.getPrecio());
    servicio.actualizarLaboratorio(laboratorioExistente);
    return "redirect:/index";
   }

    @GetMapping("/index/{id}")
    public String eliminarLaboratorio(@PathVariable Long id){
        servicio.eliminarLaboratorio(id);
        return "redirect:/index";
    }

    @GetMapping("/index/buscar")
public String buscarLaboratorio(@RequestParam(name = "q", required = false) String query, Model modelo){
    if(query != null && !query.isEmpty()) {
        modelo.addAttribute("index", servicio.buscarLaboratorios(query));
    } else {
        modelo.addAttribute("index", servicio.listarTodosLosLaboratorios());
    }
    return "index";
}

}
