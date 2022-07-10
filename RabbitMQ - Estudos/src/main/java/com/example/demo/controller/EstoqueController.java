package com.example.demo.controller;

import com.example.demo.constantes.RabbitmqConstantes;
import com.example.demo.dto.EstoqueDto;
import com.example.demo.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {

    @Autowired
    RabbitmqService rabbitmqService;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDto){
        System.out.println(estoqueDto.codigoproduto);
        this.rabbitmqService.enviaMenssagem(RabbitmqConstantes.FILA_ESTOQUE, estoqueDto);

        return new ResponseEntity(HttpStatus.OK);
    }

}
