package com.teste.qualificacao.aml.repository;

import com.teste.qualificacao.aml.model.CpgfModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpgfRepository extends MongoRepository<CpgfModel, String> {
}
