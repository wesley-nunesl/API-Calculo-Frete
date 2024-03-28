package br.com.nunes.api.calculofrete.controller;

import br.com.nunes.api.calculofrete.model.FreteModel;
import br.com.nunes.api.calculofrete.dto.request.FreteRequestDTO;
import br.com.nunes.api.calculofrete.dto.response.FreteResponseDTO;
import br.com.nunes.api.calculofrete.repository.FreteRepository;
import br.com.nunes.api.calculofrete.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FreteController {

    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private FreteService freteService;

    @GetMapping("/CalculoFrete")
    public List<FreteResponseDTO> getAllFrete() {
        List<FreteModel> listModel = freteService.listaAllFrete();
        List<FreteResponseDTO> listDTO = new ArrayList<>();
        listModel.forEach(freteModel -> {
            listDTO.add(freteModel.convertToDto());
        });
        return listDTO;
    }

    @GetMapping("/CalculoFrete/{id}")
    public FreteModel getFreteById(@PathVariable Long id) {
        return freteService.listaFreteById(id);
    }

    @PostMapping("/CalculoFrete")
    public ResponseEntity<FreteResponseDTO> calcularFrete(@RequestBody FreteRequestDTO requestDTO) throws RuntimeException {
        FreteModel responseDTO = freteService.calcularFrete(requestDTO);
        return ResponseEntity.ok(responseDTO.convertToDto());

    }

}
