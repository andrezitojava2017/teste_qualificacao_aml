package com.teste.qualificacao.aml.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("dados-cpgf")
public class CpgfModel {

    @Id
    private String id;
    private int cod_orgao_superior;
    private String nome_orgao_superior;
    private int cod_orgao;
    private String nome_orgao;
    private int cod_unidade_gestora;
    private String nome_unidade_gestora;
    private int ano_extrato;
    private int mes_extrato;
    private String cpf_portador;
    private String nome_portador;
    private String cnpj_cpf_favorecido;
    private String nome_favorecido;
    private String transacao;
    private Date data_transacao;
    private double valor_transacao;

    public CpgfModel(String id, int cod_orgao_superior, String nome_orgao_superior, int cod_orgao, String nome_orgao, int cod_unidade_gestora, String nome_unidade_gestora, int ano_extrato, int mes_extrato, String cpf_portador, String nome_portador, String cnpj_cpf_favorecido, String nome_favorecido, String transacao, Date data_transacao, double valor_transacao) {
        this.id = id;
        this.cod_orgao_superior = cod_orgao_superior;
        this.nome_orgao_superior = nome_orgao_superior;
        this.cod_orgao = cod_orgao;
        this.nome_orgao = nome_orgao;
        this.cod_unidade_gestora = cod_unidade_gestora;
        this.nome_unidade_gestora = nome_unidade_gestora;
        this.ano_extrato = ano_extrato;
        this.mes_extrato = mes_extrato;
        this.cpf_portador = cpf_portador;
        this.nome_portador = nome_portador;
        this.cnpj_cpf_favorecido = cnpj_cpf_favorecido;
        this.nome_favorecido = nome_favorecido;
        this.transacao = transacao;
        this.data_transacao = data_transacao;
        this.valor_transacao = valor_transacao;
    }
    public CpgfModel( int cod_orgao_superior, String nome_orgao_superior, int cod_orgao, String nome_orgao, int cod_unidade_gestora, String nome_unidade_gestora, int ano_extrato, int mes_extrato, String cpf_portador, String nome_portador, String cnpj_cpf_favorecido, String nome_favorecido, String transacao, Date data_transacao, double valor_transacao) {
        this.cod_orgao_superior = cod_orgao_superior;
        this.nome_orgao_superior = nome_orgao_superior;
        this.cod_orgao = cod_orgao;
        this.nome_orgao = nome_orgao;
        this.cod_unidade_gestora = cod_unidade_gestora;
        this.nome_unidade_gestora = nome_unidade_gestora;
        this.ano_extrato = ano_extrato;
        this.mes_extrato = mes_extrato;
        this.cpf_portador = cpf_portador;
        this.nome_portador = nome_portador;
        this.cnpj_cpf_favorecido = cnpj_cpf_favorecido;
        this.nome_favorecido = nome_favorecido;
        this.transacao = transacao;
        this.data_transacao = data_transacao;
        this.valor_transacao = valor_transacao;
    }

    public CpgfModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCod_orgao_superior() {
        return cod_orgao_superior;
    }

    public void setCod_orgao_superior(int cod_orgao_superior) {
        this.cod_orgao_superior = cod_orgao_superior;
    }

    public String getNome_orgao_superior() {
        return nome_orgao_superior;
    }

    public void setNome_orgao_superior(String nome_orgao_superior) {
        this.nome_orgao_superior = nome_orgao_superior;
    }

    public int getCod_orgao() {
        return cod_orgao;
    }

    public void setCod_orgao(int cod_orgao) {
        this.cod_orgao = cod_orgao;
    }

    public String getNome_orgao() {
        return nome_orgao;
    }

    public void setNome_orgao(String nome_orgao) {
        this.nome_orgao = nome_orgao;
    }

    public int getCod_unidade_gestora() {
        return cod_unidade_gestora;
    }

    public void setCod_unidade_gestora(int cod_unidade_gestora) {
        this.cod_unidade_gestora = cod_unidade_gestora;
    }

    public String getNome_unidade_gestora() {
        return nome_unidade_gestora;
    }

    public void setNome_unidade_gestora(String nome_unidade_gestora) {
        this.nome_unidade_gestora = nome_unidade_gestora;
    }

    public int getAno_extrato() {
        return ano_extrato;
    }

    public void setAno_extrato(int ano_extrato) {
        this.ano_extrato = ano_extrato;
    }

    public int getMes_extrato() {
        return mes_extrato;
    }

    public void setMes_extrato(int mes_extrato) {
        this.mes_extrato = mes_extrato;
    }

    public String getCpf_portador() {
        return cpf_portador;
    }

    public void setCpf_portador(String cpf_portador) {
        this.cpf_portador = cpf_portador;
    }

    public String getNome_portador() {
        return nome_portador;
    }

    public void setNome_portador(String nome_portador) {
        this.nome_portador = nome_portador;
    }

    public String getCnpj_cpf_favorecido() {
        return cnpj_cpf_favorecido;
    }

    public void setCnpj_cpf_favorecido(String cnpj_cpf_favorecido) {
        this.cnpj_cpf_favorecido = cnpj_cpf_favorecido;
    }

    public String getNome_favorecido() {
        return nome_favorecido;
    }

    public void setNome_favorecido(String nome_favorecido) {
        this.nome_favorecido = nome_favorecido;
    }

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(String transacao) {
        this.transacao = transacao;
    }

    public Date getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(Date data_transacao) {
        this.data_transacao = data_transacao;
    }

    public double getValor_transacao() {
        return valor_transacao;
    }

    public void setValor_transacao(double valor_transacao) {
        this.valor_transacao = valor_transacao;
    }
}
