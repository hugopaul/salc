package br.mil.eb.basecmp.salc.rest;

import br.mil.eb.basecmp.salc.domain.AprovacaoRequisicao;
import br.mil.eb.basecmp.salc.domain.Empenho;
import br.mil.eb.basecmp.salc.repository.AprovacaoRequisicaoRepository;
import br.mil.eb.basecmp.salc.repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aprovacao")
@CrossOrigin("http://localhost:4200")
public class AprovacaoRequisicaoController {
    private final AprovacaoRequisicaoRepository repository;

    @Autowired
    public AprovacaoRequisicaoController(AprovacaoRequisicaoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public AprovacaoRequisicao salvar(@RequestBody AprovacaoRequisicao e){
        return repository.save(e);
    }
}
