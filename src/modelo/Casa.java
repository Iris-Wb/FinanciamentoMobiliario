package modelo;

public class Casa extends Financiamento{
    private double areaConstruida;
    private double areaTerreno;
    public Casa(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno){
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal(){
        return ((this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual/100) / 12))) + 80;
    }
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
    public void imprimirDadosFinanciamento(){
        System.out.printf("Valor do Imóvel CASA: " + valorImovel);
        System.out.printf("\nPrazo do Financiamento: " + prazoFinanciamento);
        System.out.printf("\nTaxa de Juros: " + taxaJurosAnual);
        System.out.printf("\nTamanho da área construída: " + areaConstruida + " m²");
        System.out.printf("\nTamanho do terreno total: " + areaTerreno);
    }
}
