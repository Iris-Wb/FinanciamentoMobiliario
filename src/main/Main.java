// Aluna: Iris Warmeling dos Santos
//Turma: 20

package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import javax.sql.rowset.serial.SerialJavaObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        var listaDeFinanciamento = new ArrayList<Financiamento>();

        // Declaração das variáveis para solicitar que o usuário digite no prompt, ao invés de passar como parâmetros (para teste)
        double valorImovelCasa = interfaceUsuario.solicitarValorImovel();
        int prazoFinanciamentoAnosCasa = interfaceUsuario.solicitarPrazoFinanciamento();
        double taxaJurosCasa = interfaceUsuario.solicitarTaxaJuros();
        double areaTerreno = interfaceUsuario.solicitarAreaTerreno();
        double areaConstruida = interfaceUsuario.solicitarAreaConstruida(areaTerreno);
        /*
        double valorImovelApartamento = interfaceUsuario.solicitarValorImovel();
        int prazoFinanciamentoAnosApartamento = interfaceUsuario.solicitarPrazoFinanciamento();
        double taxaJurosApartamento = interfaceUsuario.solicitarTaxaJuros();
        int numeroDeGaragem = interfaceUsuario.solicitarNumeroGaragemApartamento();
        int numeroAndarApartamento = interfaceUsuario.solicitarNumeroAndarApartamento();

        double valorImovelTerreno = interfaceUsuario.solicitarValorImovel();
        int prazoFinanciamentoAnosTerreno = interfaceUsuario.solicitarPrazoFinanciamento();
        double taxaJurosTerreno = interfaceUsuario.solicitarTaxaJuros();
        String zona = interfaceUsuario.solicitarZona();
*/
        // Uma vez solicitando para o usuário digitar os parametros de casa
        listaDeFinanciamento.add(new Casa(valorImovelCasa, prazoFinanciamentoAnosCasa, taxaJurosCasa, areaConstruida, areaTerreno));
        // Uma vez solicitando para o usuário digitar os parametros de apartamento (para teste)
        //listaDeFinanciamento.add(new Apartamento(valorImovelApartamento,prazoFinanciamentoAnosApartamento,taxaJurosApartamento,numeroDeGaragem, numeroAndarApartamento));
        // Uma vez solicitando para o usuário digitar os parametros de terreno (para teste)
        //listaDeFinanciamento.add(new Terreno(valorImovelTerreno, prazoFinanciamentoAnosTerreno, taxaJurosTerreno, zona));

        // Demais vezes já passando os valores de parâmetros
        listaDeFinanciamento.add(new Casa(960000, 1, 12, 20, 50));
        listaDeFinanciamento.add(new Apartamento(205000, 10, 10, 2, 10));
        listaDeFinanciamento.add(new Apartamento(500000, 10, 10, 0, 12));
        listaDeFinanciamento.add(new Terreno(500000, 10, 10, "Residencial"));

        System.out.println();
        double totalImoveis = 0;
        double totalFinanciamento = 0;

        for (int i = 0; i < listaDeFinanciamento.size(); i++){
            System.out.printf("Financiamento " + (i + 1) + ": \n");
            Financiamento financiamento = listaDeFinanciamento.get(i);
            double totalPagamento = financiamento.calcularPagamentoMensal() * 12 * financiamento.getPrazoFinanciamento();
            // para evitar chamar o metodo que calcula o pagamento total, pois chamaria o catch duas vezes.
            System.out.printf("Valor do imóvel: %.2f, valor do financiamento: %.2f\n\n", financiamento.getValorImovel(), totalPagamento);
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamento += totalPagamento;
        }
        System.out.println("___________________________________________________________________________________");
        System.out.printf("Total de todos os imóveis: %.2f, total de todos os financiamentos: %.2f\n", totalImoveis, totalFinanciamento);
        System.out.println("-----------------------------------------------------------------------------------\n");


        for (int i = 0; i < listaDeFinanciamento.size(); i++){
            System.out.printf("Financiamento " + (i + 1) + ": \n");
            listaDeFinanciamento.get(i).imprimirValores();
        }

        for (Financiamento financiamento : listaDeFinanciamento){
            financiamento.imprimirDadosFinanciamento();
            System.out.println("\n");
        }

    }
}