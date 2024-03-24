package br.com.nunes.api.calculofrete.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaCepResponseDTO {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    @Override
    public String toString() {

        return  "[" +
                " CEP: '" + cep + "'"+
                ", LOCALIDADE: '" + localidade + "'"+
                ", UF: '" + uf + "'"+
                ", DDD: '" + ddd + "'"+
                " ]";
    }

}
