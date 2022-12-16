package com.deudores.deudores.Repositories;

import com.deudores.deudores.Entities.Deudor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeudorRepository extends JpaRepository<Deudor, Long> {
}
