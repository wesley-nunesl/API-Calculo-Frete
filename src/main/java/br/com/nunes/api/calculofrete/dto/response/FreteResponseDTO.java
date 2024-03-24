package br.com.nunes.api.calculofrete.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreteResponseDTO {

    private String cepOrigem;
    private String cepDestino;
    private double valorTotal;
    private LocalDate dataPrevista;

}
