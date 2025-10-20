package com.example.restApi.Controller;

import java.util.List;

import com.example.restApi.Model.Tarefa;
import com.example.restApi.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.restApi.Model.Tarefa;
import com.example.restApi.Repository.TarefaRepository;

@RestController
@RequestMapping({"/tarefas"})
public class TarefaController {
    private TarefaRepository repository;

    @Autowired
    TarefaController(TarefaRepository TarefaRepository) {
        this.repository = TarefaRepository;
    }

    @GetMapping
    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Tarefa> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Tarefa tarefa) {
        return repository.findById(id).map(record -> {
            record.setNomeTarefa(tarefa.getNomeTarefa());
            record.setDataEntrega(tarefa.getDataEntrega());
            record.setResponsavel(tarefa.getResponsavel());
            Tarefa updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}