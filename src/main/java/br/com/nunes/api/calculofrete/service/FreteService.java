package br.com.nunes.api.calculofrete.service;

import br.com.nunes.api.calculofrete.dto.request.FreteRequestDTO;
import br.com.nunes.api.calculofrete.dto.response.FreteResponseDTO;
import br.com.nunes.api.calculofrete.dto.response.ViaCepResponseDTO;
import br.com.nunes.api.calculofrete.model.FreteModel;
import br.com.nunes.api.calculofrete.repository.FreteRepository;
import br.com.nunes.api.calculofrete.service.restTemplate.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
public class FreteService {

    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private FreteRepository freteRepository;


    public FreteResponseDTO calcularFrete(FreteRequestDTO requestDTO) {
        //Consulta Ceps para obter dados
        ViaCepResponseDTO cepOrigem = viaCepService.consultarCep(requestDTO.getCepOrigem());
        ViaCepResponseDTO cepDestino = viaCepService.consultarCep(requestDTO.getCepDestino());

        double valorTotalFrete = requestDTO.getPeso();
        LocalDate dataPrevistaEntrega = LocalDate.now();

        if (cepOrigem.getDdd().equals(cepDestino.getDdd())) {
            valorTotalFrete *= 0.50;
            dataPrevistaEntrega = dataPrevistaEntrega.plusDays(1);
        } else if (cepOrigem.getUf().equals(cepDestino.getUf())) {
            valorTotalFrete *= 0.75;
            dataPrevistaEntrega = dataPrevistaEntrega.plusDays(3);
        } else {
            dataPrevistaEntrega = dataPrevistaEntrega.plusDays(10);
        }

        FreteModel freteModel = new FreteModel();
        freteModel.setCepOrigem(cepOrigem.getCep());
        freteModel.setCepDestino(cepDestino.getCep());
        freteModel.setPeso(requestDTO.getPeso());
        freteModel.setValorTotal(valorTotalFrete);
        freteModel.setDataPrevistaEntrega(dataPrevistaEntrega);

        freteRepository.save(freteModel);

        return new FreteResponseDTO(cepOrigem.toString(), cepDestino.toString(), valorTotalFrete, dataPrevistaEntrega);

    }


    public List<FreteModel> listaAllFrete() {
        return freteRepository.findAll();
    }

    public FreteModel listaFreteById(@PathVariable Long id) {
        return freteRepository.findById(id).get();
    }


}
