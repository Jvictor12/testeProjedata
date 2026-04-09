//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/* TESTE PRÁTICO PROGRAMAÇÃO.

Considerando que uma indústria possui as pessoas/funcionários abaixo:

        Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:

        1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

        2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

        3 – Deve conter uma classe Principal para executar as seguintes ações:
        3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
3.2 – Remover o funcionário “João” da lista.
        3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        • informação de data deve ser exibido no formato dd/mm/aaaa;
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        3.6 – Imprimir os funcionários, agrupados por função.
3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
3.10 – Imprimir a lista de funcionários por ordem alfabética.
        3.11 – Imprimir o total dos salários dos funcionários.
3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

Orientações gerais:
        • você poderá utilizar a ferramenta que tem maior domínio (exemplos: eclipse, netbeans etc);
• após finalizado o desenvolvimento, exportar o projeto e encaminhar o link do seu teste aqui mesmo na etapa Mão na Massa 🖐.
Basta Colar o link ainda aqui nessa etapa.
        • Assim que recebermos seu projeto desenvolvido, será agendada uma entrevista com nosso time técnico para avaliação.

Esperamos que você use todo seu conhecimento e criatividade nesse teste.

Caso você não souber resolver determinado requisito comente no código que aquele item você não sabe como desenvolver, e vá para o próximo. Avaliaremos o que você conseguiu desenvolver e como foi desenvolvido.

Boa sorte! */

// 3 – Deve conter uma classe Principal para executar as seguintes ações:
void main() {

    List<Funcionario> funcionarios = new ArrayList<>();

    // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
    funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
    funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
    funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
    funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
    funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 5 ,1), new BigDecimal("2234.68"), "Recepcionista"));
    funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
    funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
    funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
    funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
    funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

    // 3.2 – Remover o funcionário “João” da lista.
    funcionarios.removeIf(f -> f.getNome().equals("João"));

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    NumberFormat moedaBR = NumberFormat.getInstance(new Locale("pt", "BR"));

    // 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
    //          • informação de data deve ser exibido no formato dd/mm/aaaa;
    //          • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
    System.out.println("\nFuncionários: ");
    for (Funcionario f : funcionarios) {
        System.out.println("Nome: " + f.getNome());
        System.out.println("Data: " + f.getDataNascimento().format(formatter));
        System.out.println("Salário: " + moedaBR.format(f.getSalario()));
        System.out.println("Função: " + f.getFuncao());
    }

    // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
    funcionarios.forEach(f ->
            f.setSalario(f.getSalario().multiply(new BigDecimal("1.10")))
    );

    // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
    Map<String, List<Funcionario>> agrupados =
            funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

    // 3.6 – Imprimir os funcionários, agrupados por função.
    System.out.println("\nFuncionários agrupados por função: ");
    agrupados.forEach((funcao, lista) -> {
        System.out.println("Função: " + funcao);
        lista.forEach(f -> System.out.println(" - " + f.getNome()));
    });

    // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
    System.out.println("\nFuncionários que fazem aniversário no mês 10 e 12");
    funcionarios.stream()
            .filter(f -> {
                int mes = f.getDataNascimento().getMonthValue();
                return mes == 10 || mes == 12;
            })
            .forEach(f -> System.out.println(f.getNome()));

    // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
    Funcionario maisVelho = funcionarios.stream()
            .min(Comparator.comparing(Funcionario::getDataNascimento))
            .get();
    int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
    System.out.println("\nO Funcionário mais velho é: " + maisVelho.getNome() + " com " + idade + " anos");

    // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
    System.out.println("\nFuncionários em ordem alfabética");
    funcionarios.stream()
            .sorted(Comparator.comparing(Funcionario::getNome))
            .forEach(f -> System.out.println(f.getNome()));

    // 3.11 – Imprimir o total dos salários dos funcionários.
    BigDecimal total = funcionarios.stream()
            .map(Funcionario::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("\nTotal dos salários: " + moedaBR.format(total));

    // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
    BigDecimal salarioMinimo = new BigDecimal("1212");
    System.out.println("\nSalários mínimos");
    funcionarios.forEach(f -> {
        BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
        System.out.println(f.getNome() + ": " + qtd + " salários mínimos");
    });
}
