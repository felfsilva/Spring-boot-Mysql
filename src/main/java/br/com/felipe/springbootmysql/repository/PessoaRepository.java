package br.com.felipe.springbootmysql.repository;

import br.com.felipe.springbootmysql.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Long>{
}
