# pixeon

Passos para rodar os testes:

1 - Instalar o Maven
```
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T15:33:14-03:00)
Maven home: /opt/apache-maven-3.5.4
Java version: 1.8.0_181, vendor: Oracle Corporation, runtime: /usr/lib/jvm/java-8-oracle/jre
Default locale: pt_BR, platform encoding: UTF-8
OS name: "linux", version: "4.15.0-34-generic", arch: "amd64", family: "unix"
```
2 - Adicionar o Maven ao PATH
```
export PATH=/opt/apache-maven-3.5.4/bin:$PATH
```

3 - Adicionar o geckodriver ao PATH
```
export PATH=/path/to/geckodriver:$PATH
```

4 - Entrar na raiz do projeto e executar:

```
mvn test
```

obs: Os testes podem ser executados separadamente através de tags:

Desafio 1
```
 mvn test -Dcucumber.options="--tags @saucelabs"

```
Desafio 2
```
mvn test -Dcucumber.options="--tags @github"
``` 
Desafio 3
```
mvn test -Dcucumber.options="--tags @extentreports"
``` 
