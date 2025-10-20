package com.example.restApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restApi.Model.*;

@Repository
public interface TarefaRepository extends JpaRepository <Tarefa, Long>{

}
