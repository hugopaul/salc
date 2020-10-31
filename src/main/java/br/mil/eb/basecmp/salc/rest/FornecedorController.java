package br.mil.eb.basecmp.salc.rest;

import br.mil.eb.basecmp.salc.domain.Fornecedor;
import br.mil.eb.basecmp.salc.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private final FornecedorRepository repository;

    @Autowired
    public FornecedorController(FornecedorRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Fornecedor salvar(@RequestBody @Valid Fornecedor e){

        Long days = Long.valueOf(e.getPrazoEntrega().intValue());
        e.setDataEntrega(e.getDataConttFornecedor().plusDays(days));
        return repository.save(e);
    }

    @GetMapping("{id}")
    public Fornecedor findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Fornecedor não Encontrado"
                )
        );
    }


    @GetMapping
    public List<Fornecedor> findAll(){
        return repository.findAll();
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id).map(
                fornecedor -> {
                    repository.delete(fornecedor);
                    return Void.TYPE;
                }
        ).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Fornecedor fornecedorAtt){
        repository.findById(id).map(fornecedorDesatt ->{
            fornecedorAtt.setId(fornecedorDesatt.getId());
            return repository.save(fornecedorAtt);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requisição não Encontrada"));
    }
}
