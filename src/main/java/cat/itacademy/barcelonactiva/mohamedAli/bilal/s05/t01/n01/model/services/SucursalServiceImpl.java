package cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.domain.SucursalDTO;
import cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    public List<SucursalDTO> findAllSucursals() {
        List<Sucursal> sucursals = sucursalRepository.findAll();
        List<SucursalDTO> sucursalDto = new ArrayList<>();

        sucursals.stream().forEach(x ->{
            SucursalDTO s = new SucursalDTO(x);
            sucursalDto.add(s);
        });
        return sucursalDto;
    }

    @Override
    public Optional<SucursalDTO> findSucursalById(Integer id) {
        if (sucursalRepository.findById(id).isPresent()){
            Optional<Sucursal> sucursal = sucursalRepository.findById(id);
            SucursalDTO s = new SucursalDTO(sucursal.get());
            return Optional.of(s);
        }
        return Optional.empty();
    }

    @Override
    public Sucursal saveSucursal(SucursalDTO sucursalNew) {
        if (sucursalNew != null){
            Sucursal sucursal = new  Sucursal(sucursalNew.getPk_SucursalID(), sucursalNew.getNomSucursal(), sucursalNew.getPaisSucursal());
            return sucursalRepository.save(sucursal);
        }
        return new Sucursal();
    }

    @Override
    public String deleteSucursal(int id) {
        if (sucursalRepository.findById(id).isPresent()){
            sucursalRepository.deleteById(id);
            return "Sucursal eliminada";
        }
        return "Error!!! Pruebe una sucursal valida";
    }

    @Override
    public String updateSucursal(SucursalDTO SucursalUpdated) {
        int num = SucursalUpdated.getPk_SucursalID();
        if (sucursalRepository.findById(num).isPresent()){
            Sucursal sucursalToUpdate = new Sucursal();
            sucursalToUpdate.setPk_SucursalID(SucursalUpdated.getPk_SucursalID());
            sucursalToUpdate.setNomSucursal(SucursalUpdated.getNomSucursal());
            sucursalToUpdate.setPaisSucursal(SucursalUpdated.getPaisSucursal());
            sucursalRepository.save(sucursalToUpdate);
            return "Cambio realizado con exito!";
        }
        return "Error, no se pudo realizar el cambio";
    }
}
