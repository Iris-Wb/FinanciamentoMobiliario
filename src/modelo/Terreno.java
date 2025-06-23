package modelo;

public class Terreno extends Financiamento{
    private String zona;
    public Terreno(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, String zonaIndustrialOuResidencial){
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.zona = zonaIndustrialOuResidencial;
    }

    @Override
    public double calcularPagamentoMensal(){
        return ((this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual/100) / 12))) * 1.02;
    }
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void imprimirDadosFinanciamento(){
        System.out.printf("Valor do Imóvel TERRENO: " + valorImovel);
        System.out.printf("\nPrazo do Financiamento: " + prazoFinanciamento);
        System.out.printf("\nTaxa de Juros: " + taxaJurosAnual);
        System.out.printf("\nZona (Industrial ou Residencial): " + zona);
    }
}
