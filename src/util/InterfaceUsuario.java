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

}
