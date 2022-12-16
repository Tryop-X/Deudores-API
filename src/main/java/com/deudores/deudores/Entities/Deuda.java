package com.deudores.deudores.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="deudas")
public class Deuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDeuda", nullable = false)
    private Long idDeuda;

    @Column(name = "lugar_deuda")
    private String lugar;

    @Column(name = "a_favor")
    private String aFavor;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "monto")
    private Double monto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="fk_deudor", nullable = false, foreignKey = @ForeignKey(name="FK_deudor_deuda"))
    private Deudor deudor;

}
