package com.deudores.deudores.Controllers;

import com.deudores.deudores.Controllers.DTO.DeudorDTO;
import com.deudores.deudores.Controllers.DTO.DeudorListDTO;
import com.deudores.deudores.Entities.Deuda;
import com.deudores.deudores.Entities.Deudor;
import com.deudores.deudores.Services.DeudorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deudores")
@AllArgsConstructor
public class DeudorController {

    private final DeudorService deudorService;

    @PostMapping
    public ResponseEntity<DeudorListDTO> guardarDeudores (@RequestBody List<Deudor> deudores){
        DeudorListDTO deudorListDTO  = new DeudorListDTO();

        List<Deudor> deudoresFail = this.deudorService.guardarDeudores(deudores);

        if (deudoresFail.size() == 0) {
            deudorListDTO.setSatisfactorio(true);
            deudorListDTO.setMensaje("Se han cargado todos los datos correctamente");
            return new ResponseEntity<>(deudorListDTO, HttpStatus.OK);
        }else{
            deudorListDTO.setSatisfactorio(false);
            deudorListDTO.setMensaje("Algunos datos no se han registrado");
            deudorListDTO.setData(deudoresFail);
            return new ResponseEntity<>(deudorListDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Deudor>> getAllDeudores (){
        return new ResponseEntity<>(this.deudorService.getAllDeudor(), HttpStatus.OK);
    }

    @GetMapping("/documentoIdentidad/{documentoIdentidad}")
    public ResponseEntity<DeudorDTO> getDeudorByDocumentoIdentidad(@PathVariable("documentoIdentidad") String documentoIdentidad){
        DeudorDTO deudorDTO = new DeudorDTO();

        Optional<Deudor> deudor = this.deudorService.getDeudorByDocumentoIdentidad(documentoIdentidad);

        if(deudor.isPresent()){
            deudorDTO.setExiste(true);
            deudorDTO.setMensaje("Este señor tiene deuda");
            deudorDTO.setData(deudor.get());
            return new ResponseEntity<>(deudorDTO, HttpStatus.OK);
        }else{
            deudorDTO.setExiste(false);
            deudorDTO.setMensaje("Este señor no tiene deuda");
            return new ResponseEntity<>(deudorDTO, HttpStatus.OK);
        }
    }
}
