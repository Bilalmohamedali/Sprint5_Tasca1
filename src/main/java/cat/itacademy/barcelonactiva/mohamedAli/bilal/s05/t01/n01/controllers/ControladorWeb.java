package cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.domain.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ControladorWeb {

    @Autowired
    SucursalController sucursalController;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String showAllSucursals(Model model){

        if (sucursalController.getAllsucursals().getStatusCode().isError()){
            model.addAttribute("error", "Error: " + sucursalController.getAllsucursals().getStatusCode());
            return "error";
        } else if (sucursalController.getAllsucursals().getStatusCode().equals(HttpStatus.NO_CONTENT)) {
            model.addAttribute("error", "Sin resultados");
            return "error";
        }
        model.addAttribute("sucursals", sucursalController.getAllsucursals().getBody());
        return "getAll";
    }

    @GetMapping(value = "/formularioGetOneSucursal")
    public String formularioGetOneSucursal(Model model){
        Optional<SucursalDTO> s = Optional.of(new SucursalDTO());
        model.addAttribute("sucursal", s);
        return "formularioGetOneSucursal";
    }

    @PostMapping(value = "/getOne")
    public String getOneSucursal(@ModelAttribute Sucursal sucursal, Model model){
        Optional<SucursalDTO> SucursalData = (Optional<SucursalDTO>)  sucursalController.getSucursalById(sucursal.getPk_SucursalID()).getBody();
        if (SucursalData==null || SucursalData.isEmpty()){
            model.addAttribute("error", "sin resultados");
            return "error";
        }
        if (SucursalData.isPresent()) {
            SucursalDTO s = SucursalData.get();
            model.addAttribute("sucursals", s);
            return "getOne";
        }else {
            model.addAttribute("error", "sin resultados");
            return "error";
        }
    }

    @GetMapping(value = "formularioAddSucursals")
    public  String formularioAddSucursals(Model model){
        model.addAttribute("sucursal", new Sucursal());
        return "formularioAddSucursals";
    }

    @PostMapping(value = "/add")
    public String addSucursals(@ModelAttribute Sucursal sucursal, Model model){
        SucursalDTO s = new SucursalDTO(sucursal);
        sucursalController.createSucursal(s);
        model.addAttribute("mensaje", "sucursal creada");
        return "add";
    }

    @GetMapping(value = "/formularioUpdateSucursal")
    public String formularioUpdateSucursal(Model model){
        model.addAttribute("sucursal", new Sucursal());
        return "formularioUpdateSucursal";
    }

    @PostMapping(value = "/update")
    public String updateSucursal(@ModelAttribute Sucursal sucursal, Model model) {
        SucursalDTO s = new SucursalDTO(sucursal);
        sucursalController.updateSucursal(s);
        model.addAttribute("mensaje", "sucursal actualizada");
        return "update";
    }

    @GetMapping(value = "/formularioDeleteSucursal")
    public String formularioDeleteSucursal(Model model){
        model.addAttribute("sucursal", new Sucursal());
        return "formularioDeleteSucursal";
    }

    @PostMapping(value = "/delete")
    public String deleteSucursal(@ModelAttribute Sucursal sucursal, Model model){
        sucursalController.deleteSucursal(sucursal.getPk_SucursalID());
        model.addAttribute("mensaje", "sucursal borrada");
        return "delete";
    }
}
