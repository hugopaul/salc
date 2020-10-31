package br.mil.eb.basecmp.salc.rest;

import br.mil.eb.basecmp.salc.domain.AprovacaoRequisicao;
import br.mil.eb.basecmp.salc.domain.Empenho;
import br.mil.eb.basecmp.salc.repository.AprovacaoRequisicaoRepository;
import br.mil.eb.basecmp.salc.repository.RequisicaoRepository;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aprovacao")
public class AprovacaoRequisicaoController {

    private final AprovacaoRequisicaoRepository repository;

    @Autowired
    public AprovacaoRequisicaoController(AprovacaoRequisicaoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public AprovacaoRequisicao salvar(@RequestBody @Valid AprovacaoRequisicao e){
        try {
           return repository.save(e);
        } catch (Exception ex){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta requisição já foi Avaliada!");
        }
    }

    @GetMapping("{id}")
    public AprovacaoRequisicao findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Empenho não Encontrado"
                )
        );
    }


    @GetMapping
    public List<AprovacaoRequisicao> findAll(){
        return repository.findAll();
    }

    @GetMapping("estate")
    public List<AprovacaoRequisicao> findByEstate(){
    //    List<AprovacaoRequisicao> todas = repository.findAll();
   //     List<AprovacaoRequisicao> aprovadas = new ArrayList<>();
    //    for(int i= 0; i < todas.size(); i++){
    //        if(todas.get(i).getEstate() == 0){
     //           aprovadas.add(todas.get(i));
     //       }
    //    }
        return repository.findByEstate(0);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id).map(
                aprovacao -> {
                    repository.delete(aprovacao);
                    return Void.TYPE;
                }
        ).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aprovação de Requisição não encontrada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Integer id, @RequestBody AprovacaoRequisicao appreqAtt){
        repository.findById(id).map(appreqDesatt ->{
            appreqAtt.setId(appreqDesatt.getId());
            return repository.save(appreqAtt);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requisição não Encontrada"));
    }
}
