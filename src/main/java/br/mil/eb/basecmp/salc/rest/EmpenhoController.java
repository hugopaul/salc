package br.mil.eb.basecmp.salc.rest;

import br.mil.eb.basecmp.salc.domain.AprovacaoRequisicao;
import br.mil.eb.basecmp.salc.domain.Empenho;
import br.mil.eb.basecmp.salc.domain.Requisicao;
import br.mil.eb.basecmp.salc.repository.EmpenhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empenho")
public class EmpenhoController {

    private final EmpenhoRepository repository;

    @Autowired
    public EmpenhoController(EmpenhoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Empenho salvar(@RequestBody  @Valid Empenho e){
        try {
            return repository.save(e);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já Existe este NÚMERO de Empenho ou a Requisição ja foi Empenhada !");
        }
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody@Valid Empenho empenhoAtt){
        repository.findById(id).map(empenhoDesatt ->{
            empenhoAtt.setId(empenhoDesatt.getId());
            return repository.save(empenhoAtt);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requisição não Encontrada"));
    }
}
