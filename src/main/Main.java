// Aluna: Iris Warmeling dos Santos
//Turma: 20

package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import javax.sql.rowset.serial.SerialJavaObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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


        // escrita terreno


        try(FileWriter escritor = new FileWriter("terreno.txt")) {
            for (Financiamento financiamento : listaDeFinanciamento) {
                if (financiamento instanceof Terreno) {
                    escritor.write(financiamento.toString());
                    break; // escreve apenas o primeiro terreno encontrado
                }
            }
            escritor.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo inexistente");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // leitura terreno
        FileReader leitorArquivos = null;
        try{
           leitorArquivos = new FileReader("terreno.txt");
           int caracterLido; // tabela asc, começa no 0
           while ((caracterLido = leitorArquivos.read()) != -1){
               System.out.println((char)caracterLido);
           }
           leitorArquivos.close();
        }catch (FileNotFoundException e) {
            System.out.println("Arquivo inexistente");

        } catch (IOException e) {
            e.printStackTrace();
        }


        // escrita casa


        try(FileWriter escritorCasa = new FileWriter("casa.txt")) {
            for (Financiamento financiamento : listaDeFinanciamento) {
                if (financiamento instanceof Casa) {
                    escritorCasa.write(financiamento.toString());
                    break;
                }
            }
            escritorCasa.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo casa inexistente");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // leitura casa
        FileReader leitorArquivosCasa = null;
        try{
            leitorArquivosCasa = new FileReader("casa.txt");
            int caracterLido; // tabela asc, começa no 0
            while ((caracterLido = leitorArquivosCasa.read()) != -1){
                System.out.println((char)caracterLido);
            }
            leitorArquivosCasa.close();
        }catch (FileNotFoundException e) {
            System.out.println("Arquivo casa inexistente");

        } catch (IOException e) {
            e.printStackTrace();
        }


        // escrita apartamento


        try(FileWriter escritorApart = new FileWriter("apartamento.txt")) {
            for (Financiamento financiamento : listaDeFinanciamento) {
                if (financiamento instanceof Apartamento) {
                    escritorApart.write(financiamento.toString());
                    break;
                }
            }
            escritorApart.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo apartamento inexistente");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // leitura
        FileReader leitorArquivosApart = null;
        try{
            leitorArquivosApart = new FileReader("apartamento.txt");
            int caracterLido; // tabela asc, começa no 0
            while ((caracterLido = leitorArquivosApart.read()) != -1){
                System.out.println((char)caracterLido);
            }
            leitorArquivosApart.close();
        }catch (FileNotFoundException e) {
            System.out.println("Arquivo Apartamento inexistente");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financiamentos.ser"))) {
            oos.writeObject(listaDeFinanciamento);
            System.out.println("ArrayList serializado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financiamentos.ser"))) {
            ArrayList<Financiamento> listaLida = (ArrayList<Financiamento>) ois.readObject();
            System.out.println("\n--- Financiamentos lidos do arquivo serializado ---");
            for (Financiamento f : listaLida) {
                f.imprimirDadosFinanciamento();
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}