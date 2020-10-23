package br.mil.eb.basecmp.salc.rest;

import br.mil.eb.basecmp.salc.ApplicationControllerAdvise;
import br.mil.eb.basecmp.salc.domain.AprovacaoRequisicao;
import br.mil.eb.basecmp.salc.domain.Empenho;
import br.mil.eb.basecmp.salc.domain.Requisicao;
import br.mil.eb.basecmp.salc.repository.AprovacaoRequisicaoRepository;
import br.mil.eb.basecmp.salc.repository.EmpenhoRepository;
import br.mil.eb.basecmp.salc.repository.RequisicaoRepository;
import org.hibernate.HibernateException;
import org.hibernate.PropertyValueException;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

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
       // if( e.getDataDoc() == null){
  //          LocalDate date = LocalDate.now();
  //          e.setDataDoc(date);
 //       }
     return repository.save(e);
    }

    @GetMapping("{id}")
    public Requisicao findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Requisição não Encontrada"
                )
        );
    }
    @GetMapping
    public List<Requisicao> findAll(){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id).map(
                requisicao -> {
                    repository.delete(requisicao);
                    return Void.TYPE;
                }
        ).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aprovação de Requisição não encontrada"));
    }
    @PutMapping("{id}")
    @ResponseStatus
    public void update(@PathVariable Integer id, @RequestBody Requisicao requisicaoAtualizado){
            repository.findById(id).map(requisicaoDesatualizada ->{
                requisicaoAtualizado.setId(requisicaoDesatualizada.getId());
                return repository.save(requisicaoAtualizado);
            }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requisição não Encontrada"));
    }
}
