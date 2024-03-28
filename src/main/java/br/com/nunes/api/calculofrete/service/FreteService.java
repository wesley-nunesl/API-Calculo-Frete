package br.com.nunes.api.calculofrete.service;

import br.com.nunes.api.calculofrete.dto.request.FreteRequestDTO;
import br.com.nunes.api.calculofrete.dto.response.FreteResponseDTO;
import br.com.nunes.api.calculofrete.dto.response.ViaCepResponseDTO;
import br.com.nunes.api.calculofrete.model.FreteModel;
import br.com.nunes.api.calculofrete.repository.FreteRepository;
import br.com.nunes.api.calculofrete.service.exceptions.CepNotFoundException;
import br.com.nunes.api.calculofrete.service.exceptions.FreteNotFoundException;
import br.com.nunes.api.calculofrete.service.restTemplate.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
public class FreteService {

    private final double CUSTO_POR_KG = 1;
    private final double DESCONTO_50_PERCENT = 0.50;
    private final double DESCONTO_75_PERCENT = 0.75;
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private FreteRepository freteRepository;


    public FreteModel calcularFrete(FreteRequestDTO requestDTO) {
        //Consulta Ceps para obter dados
        ViaCepResponseDTO cepOrigem = viaCepService.consultarCep(requestDTO.getCepOrigem());
        ViaCepResponseDTO cepDestino = viaCepService.consultarCep(requestDTO.getCepDestino());

        double valorTotalFrete = requestDTO.getPeso() * CUSTO_POR_KG;
        LocalDate dataPrevistaEntrega = LocalDate.now();

        if (cepOrigem.getDdd().equals(cepDestino.getDdd())) {
            valorTotalFrete *= DESCONTO_50_PERCENT;
            dataPrevistaEntrega = dataPrevistaEntrega.plusDays(1);
        } else if (cepOrigem.getUf().equals(cepDestino.getUf())) {
            valorTotalFrete *= DESCONTO_75_PERCENT;
            dataPrevistaEntrega = dataPrevistaEntrega.plusDays(3);
        } else {
            dataPrevistaEntrega = dataPrevistaEntrega.plusDays(10);
        }

        FreteModel freteModel = createFreteModel(requestDTO, cepOrigem, cepDestino, valorTotalFrete, dataPrevistaEntrega);

        return freteRepository.save(freteModel);

    }


    private FreteModel createFreteModel(FreteRequestDTO requestDTO, ViaCepResponseDTO cepOrigem, ViaCepResponseDTO cepDestino, double valorTotalFrete, LocalDate dataPrevistaEntrega) {
        FreteModel freteModel = new FreteModel();
        freteModel.setCepOrigem(cepOrigem.getCep());
        freteModel.setCepDestino(cepDestino.getCep());
        freteModel.setPeso(requestDTO.getPeso());
        freteModel.setValorTotal(valorTotalFrete);
        freteModel.setDataPrevistaEntrega(dataPrevistaEntrega);
        return freteModel;
    }


    public List<FreteModel> listaAllFrete() {
        return freteRepository.findAll();
    }

    public FreteModel listaFreteById(@PathVariable Long id) {
        return freteRepository.findById(id).get();
    }


}
