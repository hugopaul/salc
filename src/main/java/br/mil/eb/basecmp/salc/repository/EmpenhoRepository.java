package br.mil.eb.basecmp.salc.repository;

import br.mil.eb.basecmp.salc.domain.AprovacaoRequisicao;
import br.mil.eb.basecmp.salc.domain.Empenho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpenhoRepository  extends JpaRepository<Empenho, Integer> {
}
