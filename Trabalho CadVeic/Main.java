import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;

    public Veiculo(String placa, String modelo, String marca, int ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Marca: " + marca
                + " | Modelo: " + modelo
                + " | Ano: " + ano
                + " | Placa: " + placa;
    }
}

List<Veiculo> veiculos = new ArrayList<>();

void main() {
    String menu = """
            ==== Cadastro de Veículos ====
            1 - Cadastrar Veículo
            2 - Listar Veículos
            3 - Consultar Veículo
            0 - Sair
            """;

    int opcao;

    do {
        limparTela();
        IO.println(menu);
        opcao = Input.readInt("Escolha uma opção: ");
        limparTela();

        switch (opcao) {
            case 1 -> cadastrarVeiculo();
            case 2 -> listarVeiculos();
            case 3 -> consultarVeiculo();
            case 0 -> IO.println("Programa encerrado.");
            default -> IO.println("Opção inválida.");
        }

        if (opcao != 0) {
            aguardarEnter();
        }
    } while (opcao != 0);
}

void limparTela() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}

void aguardarEnter() {
    IO.readln("\nPressione ENTER para voltar ao menu: ");
}

String normalizarPlaca(String placa) {
    return placa.trim()
            .toUpperCase()
            .replace("-", "");
}

void cadastrarVeiculo() {
    String placa = normalizarPlaca(IO.readln("Digite a placa do veículo: "));

    String modelo = IO.readln("Digite o modelo do veículo: ").trim();
    String marca = IO.readln("Digite a marca do veículo: ").trim();
    String anoTexto = IO.readln("Digite o ano de fabricação: ").trim();
    limparTela();

    if (placa.isBlank() || modelo.isBlank() || marca.isBlank() || anoTexto.isBlank()) {
        IO.println("Todos os campos devem ser preenchidos.");
        return;
    }

    for (Veiculo veiculo : veiculos) {
        if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
            IO.println("Erro: essa placa já está cadastrada.");
            return;
        }
    }

    int ano;

    try {
        ano = Integer.parseInt(anoTexto);
    } catch (NumberFormatException e) {
        IO.println("Ano inválido. Digite apenas números.");
        return;
    }

    int anoAtual = LocalDate.now().getYear();

    if (ano < 1900 || ano > anoAtual + 1) {
        IO.println("Ano inválido. Informe um ano entre 1900 e " + (anoAtual + 1) + ".");
        return;
    }

    veiculos.add(new Veiculo(placa, modelo, marca, ano));
    IO.println("Veículo cadastrado com sucesso.");
}

void listarVeiculos() {
    if (veiculos.isEmpty()) {
        IO.println("Nenhum veículo cadastrado.");
        return;
    }

    IO.println("Veículos cadastrados:");

    for (int i = 0; i < veiculos.size(); i++) {
        IO.println((i + 1) + " - " + veiculos.get(i));
    }
}

void consultarVeiculo() {
    String placa = normalizarPlaca(IO.readln("Digite a placa do veículo: "));
    limparTela();

    for (Veiculo veiculo : veiculos) {
        if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
            IO.println("Veículo encontrado:");
            IO.println(veiculo);
            return;
        }
    }

    IO.println("Veículo não encontrado.");
}