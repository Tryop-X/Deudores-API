package com.deudores.deudores.Services;

import com.deudores.deudores.Entities.Deuda;
import com.deudores.deudores.Entities.Deudor;
import com.deudores.deudores.Repositories.DeudaRepository;
import com.deudores.deudores.Repositories.DeudorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DeudorService {

    private final DeudorRepository deudorRepository;
    private final DeudaRepository deudaRepository;

    public Deudor getAllDeudor(Long idDeudores){
        return this.deudorRepository.findById(idDeudores).orElse(null);
    }

    public Deuda getDeuda(Long idDeuda){
        return this.deudaRepository.findById(idDeuda).orElse(null);
    }

}
