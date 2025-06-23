package modelo;

public abstract class Financiamento{
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
        double totalPag = calcularTotalPagamento();
        System.out.printf("valor do pagamento Mensal: %.2f, valor do pagamento Total: %.2f\n", pagMensal, totalPag);
    }
    public abstract void imprimirDadosFinanciamento();

}
