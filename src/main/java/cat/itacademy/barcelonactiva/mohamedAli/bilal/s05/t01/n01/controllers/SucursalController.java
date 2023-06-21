package cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.domain.SucursalDTO;
import cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllsucursals(){
        try {
            List<SucursalDTO> sucursals = new ArrayList<>();
            sucursalService.findAllSucursals().forEach(sucursals::add);

            if (sucursals.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sin resultados");
            }
            return ResponseEntity.status(HttpStatus.OK).body(sucursals);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> createSucursal(@RequestBody SucursalDTO sucursal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.saveSucursal(sucursal));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSucursal(@RequestBody SucursalDTO sucursal){
        Optional<SucursalDTO> SucursalData   = sucursalService.findSucursalById(sucursal.getPk_SucursalID()).stream().findFirst();
        if (SucursalData.isPresent()){
            SucursalDTO _Sucursal = SucursalData.get();
            _Sucursal.setNomSucursal(sucursal.getNomSucursal());
            _Sucursal.setPaisSucursal(sucursal.getPaisSucursal());
            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.updateSucursal(_Sucursal));
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> deleteSucursal(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.deleteSucursal(id));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getSucursalById(@PathVariable("id") int id){
        Optional<SucursalDTO> SucursalData = sucursalService.findSucursalById(id);
        if (SucursalData.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.findSucursalById(id));
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
