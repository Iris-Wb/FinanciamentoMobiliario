package util;

import java.util.Scanner;

public class InterfaceUsuario{

    Scanner scanner = new Scanner(System.in);

    public double solicitarValorImovel(){
        System.out.printf("Digite o valor do imóvel: ");
        double valor = scanner.nextDouble();
        while (valor<=0) {
            System.out.println("Valor inválido, digite um valor acima de zero: ");
            valor = scanner.nextDouble();
        }
        return valor;
    }
    public int solicitarPrazoFinanciamento(){
        System.out.printf("Digite o prazo do financiamento em anos: ");
        int prazo = scanner.nextInt();
        while (prazo<1 || prazo>50){
            System.out.println("Prazo inválido, digite um prazo entre 1 ou 50 anos: ");
            prazo = scanner.nextInt();
        }
        return prazo;
    }
    public double solicitarTaxaJuros(){
        System.out.printf("Digite o valor da taxa de juros: ");
        double taxa = scanner.nextDouble();
        while (taxa < 2.00 || taxa > 15.00){
            System.out.println("Valor de taxa muito baixo ou abusiva, digite um valor entre 2 e 15: ");
            taxa = scanner.nextDouble();
        }
        return taxa;
    }
    public double solicitarAreaConstruida(){
        System.out.printf("Digite o tamanho da área da casa construida (em metros quadrados): ");
        double areaCasa = scanner.nextDouble();
        while (areaCasa <= 0.00 || areaCasa > 1000.00){
            System.out.println("Tamanho indisponível, digite um tamanho válido: ");
            areaCasa = scanner.nextDouble();
        }
        return areaCasa;
    }
    public double solicitarAreaTerreno(){
        System.out.printf("Digite a área total do terreno: ");
        double areaTerreno = scanner.nextDouble();
        while (areaTerreno <= 0.00 || areaTerreno > 1000.00){
            System.out.println("Tamanho indisponível, digite um tamanho válido: ");
            areaTerreno = scanner.nextDouble();
        }
        return areaTerreno;
    }

    public int solicitarNumeroGaragemApartamento(){
        System.out.printf("Digite o número de garagens do apartamento: ");
        int numGaragem = scanner.nextInt();
        while (numGaragem < 0 || numGaragem > 5){
            System.out.println("Quantidade indisponível (digite entre 0 e 5): ");
            numGaragem = scanner.nextInt();
        }
        return numGaragem;
    }
    public int solicitarNumeroAndarApartamento(){
        System.out.printf("Digite o andar do apartamento: ");
        int andarApartamento = scanner.nextInt();
        while (andarApartamento <= 0 || andarApartamento > 30){
            System.out.println("Andar indisponível (digite entre 0 e 30): ");
            andarApartamento = scanner.nextInt();
        }
        return andarApartamento;
    }
    public String solicitarZona(){
        System.out.printf("O terreno está localizado em zona Comercial ou Residencial: ");
        String zona = scanner.next();
        return zona;
    }
}
