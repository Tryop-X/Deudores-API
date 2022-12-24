package com.deudores.deudores.Services;

import com.deudores.deudores.Entities.Deuda;
import com.deudores.deudores.Entities.Deudor;
import com.deudores.deudores.Repositories.DeudaRepository;
import com.deudores.deudores.Repositories.DeudorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DeudorService {

    private final DeudorRepository deudorRepository;
    private final DeudaRepository deudaRepository;

    public List<Deudor> getAllDeudor(){
        return this.deudorRepository.findAll();
    }

    public List<Deudor> guardarDeudores(List<Deudor> deudores){

        List<Deudor> deudoresFail = new ArrayList<Deudor>();

        for (Deudor deudor : deudores){

            try {
                Optional<Deudor> nDeudor = this.deudorRepository.findByNumeroDocumento(deudor.getNumeroDocumento());
                if(!nDeudor.isEmpty()){
                    Deudor deudor1 = nDeudor.get();


                    Optional<Deuda> deuda = this.deudaRepository.findByaFavor(deudor.getDeudas().get(0).getAFavor());

                    if(deuda.isEmpty()){
                        deudor.getDeudas().get(0).setDeudor(deudor1);
                        deudor1.getDeudas().add(deudor.getDeudas().get(0));
                        System.out.println("Actualizando datos del trabajador");
                        this.deudorRepository.save(deudor1);
                    }else{
                        System.out.println("No se van a agregar datos");
                    }

                }else{
                    System.out.println("El deudor es nuevo");
                    this.deudorRepository.guardarDeudor(deudor.getNombreDeudor(), deudor.getTipoDocumento(), deudor.getNumeroDocumento());
                    Optional<Deudor> deudorguardado = this.deudorRepository.findByNumeroDocumento(deudor.getNumeroDocumento());
                    if(deudorguardado.isEmpty()){
                        System.out.println("falló al agregar deudor");
                        deudoresFail.add(deudor);
                    }else{
                        System.out.println("Se ha encontrado deudor");
                        Deudor deudorG = deudorguardado.get();
                        deudor.getDeudas().get(0).setDeudor(deudorG);
                        this.deudaRepository.save(deudor.getDeudas().get(0));
                        System.out.println("Ha terminado de agregar datos correctos");

                    }
                }
            }catch (Exception e){
                System.out.println("Deudor ha fallado");
                deudoresFail.add(deudor);
            }
            System.out.println("------------------------------------------------");
        }
        return deudoresFail;
    }

    public Optional<Deudor> getDeudorByDocumentoIdentidad(String documentoIdentidad){

        Optional<Deudor> nDeudor = this.deudorRepository.findByNumeroDocumento(documentoIdentidad);
        return nDeudor;
    }

}
