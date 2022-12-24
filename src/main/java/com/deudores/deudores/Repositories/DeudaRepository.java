package com.deudores.deudores.Repositories;

import com.deudores.deudores.Entities.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeudaRepository extends JpaRepository<Deuda, Long>{

    Optional<Deuda> findByaFavor(String nombreAFavor);

}
