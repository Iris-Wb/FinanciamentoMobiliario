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

        // Declaração das variáveis para solicitar que o usuário digite no pronpt, ao invés de passar como parâmetros pronto (para teste)
        double valorImovel = interfaceUsuario.solicitarValorImovel();
        int prazoFinanciamentoAnos = interfaceUsuario.solicitarPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.solicitarTaxaJuros();
        double areaConstruida = interfaceUsuario.solicitarAreaConstruida();
        double areaTerreno = interfaceUsuario.solicitarAreaTerreno();
        int numeroDeGaragem = interfaceUsuario.solicitarNumeroGaragemApartamento();
        int numeroAndarApartamento = interfaceUsuario.solicitarNumeroAndarApartamento();
        String zona = interfaceUsuario.solicitarZona();

        // Uma vez solicitando para o usuário digitar os parametros de casa
        listaDeFinanciamento.add(new Casa(valorImovel, prazoFinanciamentoAnos, taxaJuros, areaConstruida, areaTerreno));

        // Demais vezes já passando os valores de parâmetros
        listaDeFinanciamento.add(new Casa(150000, 8, 10, 20, 50));
        listaDeFinanciamento.add(new Apartamento(205000, 10, 10, 2, 10));
        listaDeFinanciamento.add(new Apartamento(500000, 10, 10, 0, 12));
        listaDeFinanciamento.add(new Terreno(500000, 10, 10, "Residencial"));

        // Uma vez solicitando para o usuário digitar os parametros de apartamento (para teste)
        listaDeFinanciamento.add(new Apartamento(valorImovel,prazoFinanciamentoAnos,taxaJuros,numeroDeGaragem, numeroAndarApartamento));

        // Uma vez solicitando para o usuário digitar os parametros de terreno (para teste)
        listaDeFinanciamento.add(new Terreno(valorImovel, prazoFinanciamentoAnos, taxaJuros, zona));

        double totalImoveis = 0;
        double totalFinanciamento = 0;

        for (int i = 0; i < listaDeFinanciamento.size(); i++){
            Financiamento financiamento = listaDeFinanciamento.get(i);
            System.out.printf("Financiamento " + (i + 1) + ": ");
            System.out.printf("valor do imóvel: %.2f, valor do financiamento: %.2f\n", financiamento.getValorImovel(), financiamento.calcularTotalPagamento());
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamento += financiamento.calcularTotalPagamento();
        }
        System.out.printf("\nTotal de todos os imóveis: %.2f, total de todos os financiamentos: %.2f\n\n", totalImoveis, totalFinanciamento);


        for (int i = 0; i < listaDeFinanciamento.size(); i++){
            System.out.printf("Financiamento " + (i + 1) + ": ");
            listaDeFinanciamento.get(i).imprimirValores();
        }

        System.out.printf("\n");
        for (Financiamento financiamento : listaDeFinanciamento){
            financiamento.imprimirDadosFinanciamento();
            System.out.println("\n");
        }

    }
}