package br.com.nunes.api.calculofrete.controller;

import br.com.nunes.api.calculofrete.model.FreteModel;
import br.com.nunes.api.calculofrete.repository.FreteRepository;
import br.com.nunes.api.calculofrete.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FreteController {

    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private FreteService freteService;

    @GetMapping("/CalculoFrete")
    public List<FreteModel> getAllFrete(){
        return freteService.listaAllFrete();
    }

    @GetMapping("/CalculoFrete/{id}")
    public FreteModel getFreteById(@PathVariable Long id){
        return freteService.listaFreteById(id);
    }

    @PostMapping("/CalculoFrete")
    public FreteModel salvaFrete(@RequestBody  FreteModel frete){
        return freteService.calcularFrete(frete);
    }


}