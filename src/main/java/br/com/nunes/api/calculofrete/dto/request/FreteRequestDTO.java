package br.com.nunes.api.calculofrete.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreteRequestDTO {

    private double peso;
    private String cepOrigem;
    private String cepDestino;
}
