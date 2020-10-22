package br.mil.eb.basecmp.salc.repository;

import br.mil.eb.basecmp.salc.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
}
