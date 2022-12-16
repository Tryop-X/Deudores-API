package com.deudores.deudores.Controllers;

import com.deudores.deudores.Entities.Deuda;
import com.deudores.deudores.Entities.Deudor;
import com.deudores.deudores.Services.DeudorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deudores")
@AllArgsConstructor
public class DeudorController {

    private final DeudorService deudorService;

    @GetMapping
    public ResponseEntity<Deudor> deudores(){
        return new ResponseEntity<Deudor>(this.deudorService.getAllDeudor(1L), HttpStatus.OK);
    }

    @GetMapping("/deuda")
    public ResponseEntity<Deuda> deudas(){
        return new ResponseEntity<Deuda>(this.deudorService.getDeuda(1L), HttpStatus.OK);
    }

}
