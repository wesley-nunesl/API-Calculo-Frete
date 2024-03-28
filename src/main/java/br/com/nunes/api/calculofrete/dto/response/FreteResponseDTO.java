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

    private Long id;
    private double peso;
    private String cepOrigem;
    private String cepDestino;
    private String valorTotal;
    private LocalDate dataPrevista;



//    @Override
//    public String toString() {
//
//        return  "[" +
//                " cepOrigem: '" + cepOrigem + "'"+
//                ", cepDestino: '" + cepDestino + "'"+
//                ", valorTotal: '" + valorTotal + "'"+
//                ", dataPrevista: '" + dataPrevista + "'"+
//                " ]";
//    }

}
