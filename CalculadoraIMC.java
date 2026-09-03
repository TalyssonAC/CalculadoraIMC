void main() {
    String nome = IO.readln("Informe seu nome: ");
    char genero = IO.readln("Informe seu gênero (M: masculino, F: feminino, D: prefiro não informar): ")
            .toUpperCase().charAt(0);
    double altura = Double.parseDouble(IO.readln("Informe sua altura em centímetros: "));
    double peso = Double.parseDouble(IO.readln("Informe seu peso em quilos: "));
    double alturaEmMetros = altura / 100.0;
    double imc = peso / (alturaEmMetros * alturaEmMetros);

    IO.println("\nNome: " + nome);
    IO.println("Gênero: " + genero);
    IO.println("IMC: " + imc);

    switch (genero) {
        case 'M':
            if (imc >= 40) {
                IO.println("Classificação: Obesidade Mórbida");
            } else if (imc >= 30) {
                IO.println("Classificação: Obesidade Moderada");
            } else if (imc >= 25) {
                IO.println("Classificação: Obesidade Leve");
            } else if (imc >= 20) {
                IO.println("Classificação: Normal");
            } else {
                IO.println("Classificação: Abaixo do Normal");
            }
            break;

        case 'F':
        case 'D':
            if (imc >= 39) {
                IO.println("Classificação: Obesidade Mórbida");
            } else if (imc >= 29) {
                IO.println("Classificação: Obesidade Moderada");
            } else if (imc >= 24) {
                IO.println("Classificação: Obesidade Leve");
            } else if (imc >= 19) {
                IO.println("Classificação: Normal");
            } else {
                IO.println("Classificação: Abaixo do Normal");
            }
            break;

        default:
            IO.println("Gênero inválido. Use M, F ou D.");
    }

}