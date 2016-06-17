package br.com.crescer.repository;

import br.com.crescer.controllers.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 * @author murillo.peteffi
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
