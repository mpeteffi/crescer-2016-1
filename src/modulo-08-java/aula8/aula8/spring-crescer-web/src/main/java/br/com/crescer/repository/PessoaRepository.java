package br.com.crescer.repository;

import br.com.crescer.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Murillo
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
