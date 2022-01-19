package com.teste.qualificacao.aml.service;

import com.teste.qualificacao.aml.model.CpgfModel;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.utility.ListIterate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CpgfService {


    public Double sumValues(List<CpgfModel> data) {

        double sumV = data.stream().mapToDouble(CpgfModel::getValor_transacao).sum();
        //System.out.println(sumV);
        return sumV;
    }

    public double getSumConfidentialInfomation(List<CpgfModel> data) {

        double sigiloso = data.stream()
                .filter(ln -> ln.getNome_portador().equalsIgnoreCase("Sigiloso"))
                .mapToDouble(v -> v.getValor_transacao())
                .sum();

        return sigiloso;
    }

    /**
     * Faz leitura do arquivo csv
     *
     * @return List<String>
     */
    public List<String> getLinesFileCPGF() {
        List<String> listData = new ArrayList<>();
        Path path = Paths.get("d:\\202110_CPGF.csv");
        try {
            List<String> linhas = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
            linhas.remove(0); // remove o cabeçalho
            listData = linhas;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listData;
    }

    /**
     * Cria uma lista de objetos Cpgf, com os dados do arquivo CSV
     *
     * @param linesFile
     * @return List<CpgfModel>listData
     */
    public List<CpgfModel> getListCpgf(List<String> linesFile) {
        List<CpgfModel> listData = new ArrayList<>();

        linesFile.stream()
                .map(ln -> ln.replace("\"", "").split(";"))
                .forEach(ln -> {
                /*
                    ln[0]-COD_ORGAO_SUPERIOR
                    ln[1]-NOME_ORGAO_SUPERIOR
                    ln[2]-COD_ORGAO
                    ln[3]-NOME_ORGAO
                    ln[4]-COD_UNIDADE_GESTORA
                    ln[5]-NOME_UNIDADE_GESTORA
                    ln[6]-ANO_EXTRACAO
                    ln[7]-MES_EXTRACAO
                    ln[8]-CPF_PORTADOR
                    ln[9]-NOME_PORTADOR
                    ln[10]-CNPJ_CPF_FAVORECIDO
                    ln[11]-NOME_FAVORECIDO
                    ln[12]-TRANSACAO
                    ln[13]-DATA_TRANSACAO
                    ln[14]- VALOR_TRANSACAO
                 */

                    CpgfModel cpfgData = new CpgfModel(
                            Integer.parseInt(ln[0]),
                            ln[1],
                            Integer.parseInt(ln[2]),
                            ln[3],
                            Integer.parseInt(ln[4]),
                            ln[5],
                            Integer.parseInt(ln[6]),
                            Integer.parseInt(ln[7]),
                            ln[8],
                            ln[9],
                            ln[10],
                            ln[11],
                            ln[12],
                            formatStringToDate(ln[13]),
                            formatStringToDouble(ln[14])
                    );
                    listData.add(cpfgData);

                });

        return listData;
    }


    /**
     * Formata String em um Double valido
     *
     * @param transacao
     * @return Double transacaoValue
     */
    public Double formatStringToDouble(String transacao) {
        String value = transacao.replace(",", ".");
        Double transacaoValue = Double.parseDouble(value);
        return transacaoValue;
    }


    /**
     * Formata String em Date valido
     * ou caso campo esteja vazio, retorna NULL
     *
     * @param data_transacao
     * @return Date dataTransacao
     */
    public Date formatStringToDate(String data_transacao) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataTransacao = null;

        try {
            if (data_transacao == null || data_transacao.isEmpty()) {
                return null;
            }
            dataTransacao = format.parse(data_transacao);
        } catch (ParseException e) {
            System.out.println("Erro na conversao de data");
        }
        return dataTransacao;
    }

    /**
     * Recuperamos a soma dos gastos sigilosos e qual o orgão que manteve mais movimentações
     *
     * @return
     */
    public Map.Entry<Integer, Double> questaoM() {

        List<String> listCpgfModel = getLinesFileCPGF();
        List<CpgfModel> listCpgf = getListCpgf(listCpgfModel);

        // recupero os codigos dos orgaos
        List<Integer> codOrgao = listCpgf.stream()
                .map(cp -> cp.getCod_orgao())
                .distinct()
                .collect(Collectors.toList());

        // recupero os orgaos onde o portador é sigiloso
        List<CpgfModel> sigiloso = listCpgf.stream()
                .filter(ln -> ln.getNome_portador().equalsIgnoreCase("sigiloso"))
                .collect(Collectors.toList());

        // mapa que ira armazenar a soma de cada orgao
        Map<Integer, Double> mapa = new HashMap<>();

        // soma das transações por codigo do orgao
        for (Integer integer : codOrgao) {
            double sum = sigiloso.stream()
                    .filter(sg -> sg.getCod_orgao() == integer) // integer é um list q contem o codigo_orgaos
                    .mapToDouble(value -> value.getValor_transacao())
                    .sum();
            mapa.put(integer, sum);
        }

        // define qual o orgao com mais movimentaçoes sigilosa
        Map.Entry<Integer, Double> max = Collections
                .max(mapa.entrySet(), Comparator.comparingDouble(Map.Entry::getValue));


        return max;

    }

    public Map.Entry<CpgfModel, Double> questaoN() {
        List<String> listCpgfModel = getLinesFileCPGF();
        List<CpgfModel> listCpgf = getListCpgf(listCpgfModel);

        List<CpgfModel> portador = listCpgf.stream()
                .filter(d -> !d.getNome_portador().equalsIgnoreCase("sigiloso"))
                .collect(Collectors.toList());

        MutableList<CpgfModel> distinct = ListIterate
                .distinct(portador, HashingStrategies.fromFunction(CpgfModel::getNome_portador));


        Map<CpgfModel, Double> mapa = new HashMap<CpgfModel, Double>();

        for (CpgfModel port : distinct) {
            double sum = portador.stream()
                    .filter(d -> d.getNome_portador().equalsIgnoreCase(port.getNome_portador()))
                    .mapToDouble(value -> value.getValor_transacao())
                    .sum();
            mapa.put(port, sum );
        }

        Map.Entry<CpgfModel, Double> max = Collections
                .max(mapa.entrySet(), Comparator.comparingDouble(Map.Entry::getValue));

      // mapa.forEach((s, aDouble) -> System.out.println(s.getNome_portador() + " - " + s.getNome_orgao() + " " + aDouble));

        //System.out.println(max);
        return max;

    }

}
