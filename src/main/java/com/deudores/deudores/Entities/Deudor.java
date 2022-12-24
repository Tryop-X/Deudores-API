package com.deudores.deudores.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="deudores")
public class Deudor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDeudor", nullable = false)
    private Long idDeudor;

    @Column(name = "nombre_deudor")
    private String nombreDeudor;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @OneToMany (mappedBy ="deudor", cascade ={CascadeType.ALL})
    private List<Deuda> deudas;
}
