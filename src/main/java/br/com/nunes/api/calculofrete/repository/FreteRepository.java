package br.com.nunes.api.calculofrete.repository;

import br.com.nunes.api.calculofrete.model.FreteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreteRepository extends JpaRepository<FreteModel, Long> {
}
