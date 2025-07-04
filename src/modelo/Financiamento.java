package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    //atributos
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }

    // construtor
    public Financiamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // metodos
    public abstract double calcularPagamentoMensal();

    public abstract double calcularTotalPagamento();

    public void imprimirValores(){
        double pagMensal = calcularPagamentoMensal();
        double totalPag = pagMensal * 12 * this.prazoFinanciamento;
        System.out.printf("Pagamento Mensal: %.2f, pagamento Total: %.2f\n\n", pagMensal, totalPag);
    }
    public abstract void imprimirDadosFinanciamento();

}
