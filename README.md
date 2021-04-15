# Sincronização Receita

Projeto desenvolvido em Java, utilizando SpringBoot para simular o consumo
de um serviço do Banco Central que realiza a sincronização de dados bancários.

## Utilização
Para rodar o projeto, basta criar um run configuration para Java Application. Escolher o projeto
e como main class definir com.sincronizacaoreceita.SincronizacaoReceita.
Nos Argumentos deve-se passar o caminho completo para o arquivo CSV a ser processado.
Será gerado um outro arquivo CSV na raiz do projeto, basicamente com a mesma estrutura do arquivo
de origem, mas com uma coluna a mais, que é a coluna referente ao resultado do processamento de
cada linha.

## Build
Caso deseje gerar um executavel do projeto, basta rodar um comando maven, clean install, que será
gerado um arquivo executável java.

## Exemplo de execução

java -jar sincronizareceita-0.0.1-SNAPSHOT.jar contas.csv