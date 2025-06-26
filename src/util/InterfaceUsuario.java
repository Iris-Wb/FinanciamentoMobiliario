package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario{

    Scanner scanner = new Scanner(System.in);

    public double solicitarValorImovel(){
        double valor = -1;
        while (valor <= 0) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valor = scanner.nextDouble();

                if (valor <= 0) {
                    System.out.println("Valor inválido, digite um valor acima de zero.");
                }
            } catch (InputMismatchException e) { // tratar quando digitam letras ao invés de números
                System.out.println("Entrada inválida, digite um número válido.");
                scanner.nextLine(); // limpa o buffer do scanner
            }
        }
        return valor;
    }
    public int solicitarPrazoFinanciamento(){
        int prazo = -1;
        while (prazo < 1 || prazo > 50) {
            try {
                System.out.print("Digite o prazo do financiamento em anos: ");
                prazo = scanner.nextInt();

                if (prazo < 1 || prazo > 50) {
                    System.out.println("Prazo inválido, digite um prazo entre 1 e 50 anos.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, digite um número inteiro.");
                scanner.nextLine(); // limpa o buffer para evitar loop infinito
            }
        }
        return prazo;
    }
    public double solicitarTaxaJuros(){
        double taxa = 1;
        while (taxa < 2.00 || taxa > 15.00) {
            try {
                System.out.print("Digite o valor da taxa de juros: ");
                taxa = scanner.nextDouble();

                if (taxa < 2.00 || taxa > 15.00 ) {
                    System.out.println("Taxa de juros muito baixa ou abusiva, digite algo em 2 e 15: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, digite um número.");
                scanner.nextLine();
            }
        }
        return taxa;
    }
    public double solicitarAreaTerreno() {
        double areaTerreno = -1;

        while (areaTerreno <= 0.00 || areaTerreno > 1000.00) {
            try {
                System.out.print("Digite a área total do terreno: ");
                areaTerreno = scanner.nextDouble();

                if (areaTerreno <= 0.00 || areaTerreno > 1000.00) {
                    System.out.println("Tamanho indisponível, digite um tamanho válido entre 0.01 e 1000.00.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido para a área.");
                scanner.nextLine(); // limpar buffer
            }
        }
        return areaTerreno;
    }

    public double solicitarAreaConstruida(double areaTerreno) {
        double areaConstruida = -1;

        while (areaConstruida <= 0.00 || areaConstruida > 1000.00 || areaConstruida > areaTerreno) {
            try {
                System.out.print("Digite o tamanho da área da casa construída (em metros quadrados): ");
                areaConstruida = scanner.nextDouble();

                if (areaConstruida <= 0.00 || areaConstruida > 1000.00) {
                    System.out.println("Tamanho indisponível, digite um tamanho válido entre 0.01 e 1000.00.");
                } else if (areaConstruida > areaTerreno) {
                    System.out.println("A área construída não pode ser maior que a área total do terreno.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido para a área.");
                scanner.nextLine(); // limpar buffer
            }
        }

        return areaConstruida;
    }

    public int solicitarNumeroGaragemApartamento() {
        int numGaragem = -1;
        while (numGaragem < 0 || numGaragem > 5) {
            try {
                System.out.print("Digite o número de garagens do apartamento: ");
                numGaragem = scanner.nextInt();

                if (numGaragem < 0 || numGaragem > 5) {
                    System.out.println("Quantidade indisponível (digite entre 0 e 5).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro entre 0 e 5.");
                scanner.nextLine(); // limpa buffer
            }
        }
        return numGaragem;
    }

    public int solicitarNumeroAndarApartamento() {
        int andarApartamento = -1;
        while (andarApartamento <= 0 || andarApartamento > 30) {
            try {
                System.out.print("Digite o andar do apartamento: ");
                andarApartamento = scanner.nextInt();

                if (andarApartamento <= 0 || andarApartamento > 30) {
                    System.out.println("Andar indisponível (digite entre 1 e 30).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro entre 1 e 30.");
                scanner.nextLine(); // limpa buffer
            }
        }
        return andarApartamento;
    }

    public String solicitarZona() {
        String zona = "";

        while (true) {
            System.out.print("O terreno está localizado em zona Comercial ou Residencial: ");
            zona = scanner.next();

            if (zona.equalsIgnoreCase("Comercial") || zona.equalsIgnoreCase("Residencial")) {
                break; // entrada válida, sai do loop
            } else {
                System.out.println("Entrada inválida! Digite 'Comercial' ou 'Residencial'.");
            }
        }
        return zona;
    }
}
