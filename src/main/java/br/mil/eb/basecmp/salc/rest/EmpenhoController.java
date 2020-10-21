package br.mil.eb.basecmp.salc.rest;

import br.mil.eb.basecmp.salc.domain.Empenho;
import br.mil.eb.basecmp.salc.domain.Requisicao;
import br.mil.eb.basecmp.salc.repository.EmpenhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("{id}")
    public Empenho findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Empenho não Encontrado"
                )
        );
    }

    @GetMapping
    public List<Empenho> findAll(){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id).map(
                empenho -> {
                    repository.delete(empenho);
                    return Void.TYPE;
                }
        ).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empenho não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus
    public void update(@PathVariable Integer id, @RequestBody Empenho empenhoAtt){
        repository.findById(id).map(empenhoDesatt ->{
            empenhoAtt.setId(empenhoDesatt.getId());
            return repository.save(empenhoAtt);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requisição não Encontrada"));
    }
}
