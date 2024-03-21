package br.com.nunes.api.calculofrete.service;

import br.com.nunes.api.calculofrete.model.FreteModel;
import br.com.nunes.api.calculofrete.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class FreteService {

    @Autowired
    private FreteRepository freteRepository;

    public FreteModel calcularFrete(FreteModel frete){
       //Aqui vai ficar a regra de negocio!!!
       return freteRepository.save(frete);
    }

    public List<FreteModel> listaAllFrete(){
        return freteRepository.findAll();
    }

    public FreteModel listaFreteById(@PathVariable Long id){
        return freteRepository.findById(id).get();
    }
}
