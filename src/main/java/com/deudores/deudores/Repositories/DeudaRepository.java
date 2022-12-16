package com.deudores.deudores.Repositories;

import com.deudores.deudores.Entities.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeudaRepository extends JpaRepository<Deuda, Long>{
}
