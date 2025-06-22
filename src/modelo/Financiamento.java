package modelo;

public class Financiamento{
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
    public double calcularPagamentoMensal(){
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual/100) / 12)); //segui exemplo da semana 5
    }
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void imprimirValores(){
        double pagMensal = calcularPagamentoMensal();
        double totalPag = calcularTotalPagamento();
        System.out.printf("valor do pagamento Mensal: %.2f, valor do pagamento Total: %.2f\n", pagMensal, totalPag);
    }

}
