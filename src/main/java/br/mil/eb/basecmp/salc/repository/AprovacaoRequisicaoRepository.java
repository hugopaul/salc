package br.mil.eb.basecmp.salc.repository;

import br.mil.eb.basecmp.salc.domain.AprovacaoRequisicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AprovacaoRequisicaoRepository extends JpaRepository<AprovacaoRequisicao, Integer> {

    List<AprovacaoRequisicao> findByEstate(Integer estate);
}
