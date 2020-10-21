package br.mil.eb.basecmp.salc.repository;

import br.mil.eb.basecmp.salc.domain.AprovacaoRequisicao;
import br.mil.eb.basecmp.salc.domain.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequisicaoRepository  extends JpaRepository<Requisicao, Integer> {
}
