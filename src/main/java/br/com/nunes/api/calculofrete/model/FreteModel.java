package br.com.nunes.api.calculofrete.model;

import br.com.nunes.api.calculofrete.dto.response.FreteResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Calculo-Frete")
public class FreteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double peso;
    private String cepOrigem;
    private String cepDestino;
    private double valorTotal;
    private LocalDate dataPrevistaEntrega;
    private String nomeDestinatario;
    private LocalDate dataConsulta;

    public FreteResponseDTO convertToDto(){
        FreteResponseDTO freteResponseDTO = new FreteResponseDTO();
        freteResponseDTO.setId(this.id);
        freteResponseDTO.setPeso(this.peso);
        freteResponseDTO.setCepOrigem(this.cepOrigem);
        freteResponseDTO.setCepDestino(this.cepDestino);
        freteResponseDTO.setValorTotal("R$ " + this.valorTotal);
        freteResponseDTO.setDataPrevista(this.dataPrevistaEntrega);
        freteResponseDTO.setNomeDestinatario(this.nomeDestinatario);
        freteResponseDTO.setDataConsulta(this.dataConsulta);

        return freteResponseDTO;
    }

}
