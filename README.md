# Teste de qualificação - AML
Teste de qualificação AML, para concorrer a vaga no bootcamp

Questionario e respostas

A. - **Com suas palavras explique o que é lavagem de dinheiro** <br>
		R: É uma forma de mascarar o dinheiro adquirido de forma ilicita, escondendo como foi adquirido<br>
	
B. - **O que é Cartão de Pagamento do Governo Federal (CPGF), e qual a sua finalidade.**<br>
	R: UM ADIANTAMENTO FEITO PARA O SERVIDOR/PORTADOR DO CARTAO, SOB RESPONSABILIDE E CRITERIO DO ORDENADOR DE DESPESA
	COM PRAZO DE APLICAÇÃO E PRESTAÇÃO DE CONTAS.
	COM A FINALIDADE DE CUSTEAR DESPESAS EXCEPCIONAIS, QUE NAO SUBORDINAM AS FORMAS NORMAIS DE APLICAÇÃO.
	
C. - **QUEM PODE UTILIZAR CPGF:**<br>
R: SERVIDOR PUBLICO EFETIVO OU OCUPANTE DE CARGO EM COMISSAO EM EFETIVO EXERCICIO, E QUE PREENCHA OS REQUISITOS:<br>
* a) não ser responsável por dois suprimentos de fundos em fase de
	aplicação e/ou de prestação de contas;<br>
* b) não tenha a seu cargo a guarda do material a adquirir, salvo quando
	não houver na repartição outro servidor que reúna condições de
	receber o Suprimento de Fundos;<br>
* c) não ser responsável por Suprimento de Fundos que, esgotado o
	prazo, esteja pendente de prestação de contas;<br>
* d) não ter sido declarado em alcance, assim entendido aquele que
	tenha cometido apropriação indevida, extravio, desvio ou falta
	verificada na prestação de contas, de dinheiro ou valores confiados à
	sua guarda;<br>
* e) não tenha tido prestação de contas da aplicação de suprimento
	fundos com despesas impugnadas pelo Ordenador de Despesas ou que
	esteja em processo de Tomada de Contas Especial;<br>
* f) não se confunda com a pessoa do Ordenador de Despesas; e
* g) não seja o próprio demandante da aquisição/contratação de serviço,
	exceto em viagem a serviço.<br>
	
D. - **QUAL A URL ONDE E POSSIVEL FAZER DOWNLOAD DO ARQUIVOS DO CPGF?**<br>
	R: https://www.portaltransparencia.gov.br/download-de-dados/cpgf<br>
	
E. - **QUAL A URL DA PAGAINA COM A DESCRICAO DOS CAMPOS (OU DICIONARIO DE DADOS) DA CPGF?**<br>
	R: https://www.portaldatransparencia.gov.br/pagina-interna/603393-dicionario-de-dados-cpgf

F. - **É possível identificar o nome e o documento do portador do CPGF, em todas as
movimentações ou há movimentações onde não é possível identificar o portador?**<br>
	R: Existem algumas movimentações sigilosas, e outras que nao há a identificação do portador, apenas de seu orgao vinculado<br>

G. - **É possível identificar o Órgão do portador do CPGF?**<br>
	R: Sim, todos os portadores, mesmo os sigilosos, pertencem a um orgao vinculado

H. - **Qual o nome do Órgão cujo código é 20402?**<br>
	R: Agencia Espacial Brasileira

I. - **É possível identificar o Nome e Documento (CNPJ) dos favorecidos pela utilização do
CPGF?**<br>
	R: Nao, as movimentações sigilosas nao possuem identificação dos favorecidos

J. - **É possível identificar a data e o valor das movimentações financeiras do CPGF, em
todas as movimentações? Ou há movimentações onde não é possível identificar as datas e
ou valores?**<br>
	R: As movimentações sigilosas nao constam datas de movimentos, apenas seus valores

K. **Qual a soma das movimentações utilizando o CPGF?**<br>
	R: a soma é 5.619.007,95

L. **Qual a soma das movimentações sigilosas?**<br>
	R: total movimentações sigilosas 3.108.731,15

M. - **Qual o Órgão que mais realizou movimentações sigilosas no período e qual o
valor (somado)?**<br>
	R: Orgao 20101, soma total: 1.699.751.04

N. **Qual nome do portador que mais realizou saques no periodo? qual a soma dos sanques<br>
	realizada por ele? qual o nome do Orgao desse portador?**<br>
	R: Portador:Sigiloso<br>
	Orgao: Fundo Constitucional do Distrito Federal<br>
	Soma total: 3.108.731,15<br><br>
O. - **Qual o nome do favorecido que mais recebeu compras realizadas utilizando o
CPGF?** <br>
	R: Favorecido: Sigiloso<br>
	Total de transações: 2306

P. - **Descreva qual a abordagem utilizada para desenvolver o código para os ítens de K a O**<br>
	R: Foi desenvolvido uma API utlizando a linguagem Java 11 e framework Spring Boot.
	Ao iniciar a aplicação é feito o carregamento das informações constantes no arquivo .CSV disponibilizado<br>
	assim foi possivel o desenvolvimento dos endpoints para obtenção das respostas.
