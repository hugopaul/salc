package br.mil.eb.basecmp.salc.rest;

import br.mil.eb.basecmp.salc.domain.Empenho;
import br.mil.eb.basecmp.salc.domain.Requisicao;
import br.mil.eb.basecmp.salc.repository.EmpenhoRepository;
import br.mil.eb.basecmp.salc.repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requisicoes")
@CrossOrigin("http://localhost:4200")
public class RequisicaoController {

    private final RequisicaoRepository repository;

    @Autowired
    public RequisicaoController(RequisicaoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Requisicao salvar(@RequestBody Requisicao e){
        return repository.save(e);
    }
}
