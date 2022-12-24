package com.deudores.deudores.Repositories;

import com.deudores.deudores.Entities.Deudor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeudorRepository extends JpaRepository<Deudor, Long> {
    Optional<Deudor> findByNumeroDocumento(String numeroDocumento);

    @Modifying
    @Query(value = "INSERT INTO deudores (nombre_deudor, tipo_documento, numero_documento) values (:nombre, :tipo, :nroDoc)", nativeQuery = true)
    Object guardarDeudor(String nombre, String tipo, String nroDoc);
}
