package com.teste.qualificacao.aml.controller;

import com.teste.qualificacao.aml.model.CpgfModel;
import com.teste.qualificacao.aml.service.CpgfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class CpgfController {

    @Autowired
    private CpgfService service;

    @GetMapping("/")
    public ResponseEntity<CpgfModel> loadDataCsv() {

        List<String> listCpgfModel = service.getLinesFileCPGF();
        return new ResponseEntity(service.getListCpgf(listCpgfModel), HttpStatus.OK);

    }

    @GetMapping("/questao/k")
    public ResponseEntity<String> getTotalSum() {
        List<String> listCpgfModel = service.getLinesFileCPGF();
        List<CpgfModel> listCpgf = service.getListCpgf(listCpgfModel);
        Double aDouble = service.sumValues(listCpgf);

        return new ResponseEntity("Resposta questao 'K': R$" + aDouble, HttpStatus.OK);
    }

    @GetMapping("/questao/l")
    public ResponseEntity getSumConfidentialInformation() {
        List<String> listCpgfModel = service.getLinesFileCPGF();
        List<CpgfModel> listCpgf = service.getListCpgf(listCpgfModel);
        double result = service.getSumConfidentialInfomation(listCpgf);

        return new ResponseEntity("Resposta questão 'L' : R$" + result, HttpStatus.OK);
    }

    @GetMapping("/questao/m")
    public ResponseEntity getSumConfidentialTransationOrgan(){
        Map.Entry<Integer, Double> result = service.questaoM();
        return new ResponseEntity(result, HttpStatus.OK);
    }


    @GetMapping("/questao/n")
    public ResponseEntity getQuetsaoN(){
        Map.Entry<CpgfModel, Double> result = service.questaoN();

        String portador = result.getKey().getNome_portador();
        String orgao = result.getKey().getNome_orgao();
        double soma = result.getValue();

        String rs = "Portador:" + portador + "\nOrgao: " + orgao + "\nSoma total: " + soma;

        return new ResponseEntity(rs, HttpStatus.OK);
    }

    @GetMapping("/questao/o")
    public ResponseEntity questaoO(){

        Map.Entry<String, Long> result = service.questaoO();
        String nome = result.getKey();
        String total = result.getValue().toString();
        String rs = "Favorecido: " + nome + "\nTotal de transações: " + total;
        return new ResponseEntity(rs, HttpStatus.OK);

    }

}
