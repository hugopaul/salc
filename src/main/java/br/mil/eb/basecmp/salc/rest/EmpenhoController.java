package br.mil.eb.basecmp.salc.rest;

import br.mil.eb.basecmp.salc.domain.Empenho;
import br.mil.eb.basecmp.salc.repository.EmpenhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empenho")
@CrossOrigin("http://localhost:4200")
public class EmpenhoController {

    private final EmpenhoRepository repository;

    @Autowired
    public EmpenhoController(EmpenhoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Empenho salvar(@RequestBody Empenho e){
        return repository.save(e);
    }

}
