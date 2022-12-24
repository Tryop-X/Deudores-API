package com.deudores.deudores.Controllers.DTO;

import com.deudores.deudores.Entities.Deudor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeudorDTO {

    @JsonProperty("satisfactorio")
    boolean existe;

    @JsonProperty("mensaje")
    String mensaje;

    @JsonProperty("data")
    Deudor data;
}
