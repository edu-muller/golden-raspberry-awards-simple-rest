# golden-raspberry-awards-simple-rest

**Requisitos**
- *Java 11*.
- *Maven*.

**Preparação do ambiente**
- Executar o comando `mvn install`.

**Execução dos testes**
- Executar o comando `mvn test`.

**Geração do executável**
- Executar o comando `mvn clean package`.
- Um ***JAR*** será gerado na pasta *target*.

**Execução**
- No diretório de execução é necessário um arquivo de entrada de dados com nome *movielist.csv*.
- Executar o comando `java -jar <nome-do-jar>`.
- A porta padrão configurada é ***8080***.

**Rotas disponíveis**
- `GET /movies/producers/awards-intervals`
