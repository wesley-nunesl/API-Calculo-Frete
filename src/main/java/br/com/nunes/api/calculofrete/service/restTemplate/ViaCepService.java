package br.com.nunes.api.calculofrete.service.restTemplate;

import br.com.nunes.api.calculofrete.dto.response.ViaCepResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ViaCepService {
    private static final String Url_Via_Cep = "https://viacep.com.br/ws/";

    public ViaCepResponseDTO consultarCep(String cep){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(Url_Via_Cep + cep + "/json/", ViaCepResponseDTO.class);
    }
}
