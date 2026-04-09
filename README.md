# Teste Projedata (Java 26)

Este repositório contém a resolução do teste prático da Projedata usando **Java 26**.

## Destaque importante

O código foi desenvolvido com recursos modernos do Java 26.  
Por isso, a entrada do programa usa uma **`main` simplificada**, sem necessidade da estrutura tradicional `public class Main` + `public static void main(String[] args)`.

## Estrutura do projeto

- `src/Pessoa.java`: classe base com `nome` e `dataNascimento`.
- `src/Funcionario.java`: herda de `Pessoa` e adiciona `salario` e `funcao`.
- `src/Main.java`: execução principal com todas as regras solicitadas no desafio.

## O que o programa faz

A execução em `Main.java` realiza:

1. Cadastro dos funcionários.
2. Remoção do funcionário João.
3. Impressão formatada de dados (data e salário).
4. Aumento de 10% no salário.
5. Agrupamento por função.
6. Impressão dos grupos por função.
7. Listagem de aniversariantes dos meses 10 e 12.
8. Exibição do funcionário com maior idade.
9. Ordenação alfabética de funcionários.
10. Cálculo do total de salários.
11. Cálculo de quantos salários mínimos cada funcionário recebe.

## Como executar

### Pré-requisitos

- **JDK 26** instalado e configurado no `PATH`.

### Compilar

No diretório raiz do projeto, execute:

```bash
javac src/*.java
```

### Rodar

Depois de compilar, execute:

```bash
java -cp src Main.java
```

> Dependendo da forma como sua JDK 26 estiver configurada para recursos mais novos, você também pode executar diretamente com:
>
> ```bash
> java src/Main.java
> ```

## Observação

Se estiver usando IDE (IntelliJ, Eclipse ou VS Code), selecione a JDK 26 no projeto para garantir que a sintaxe da `main` simplificada seja reconhecida corretamente.
