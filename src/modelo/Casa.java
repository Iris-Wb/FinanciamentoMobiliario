package modelo;

import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento{
    private double areaConstruida;
    private double areaTerreno;
    public Casa(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno){
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = tamanhoTerreno;
    }

    private void validarValorJuros(double valorJuros, double valorAcrescimo) throws AumentoMaiorDoQueJurosException {
        if (valorAcrescimo > valorJuros/2) {
            throw new AumentoMaiorDoQueJurosException("O acréscimo não pode ser maior do que o valor da metade do juros da mensalidade!");
        }
    }

    @Override
    public double calcularPagamentoMensal(){
        double parcelaSemJuros = this.valorImovel / (this.prazoFinanciamento * 12);
        double pagamentoComJuros = parcelaSemJuros * (1 + ((this.taxaJurosAnual / 100) / 12));
        double valorJuros = pagamentoComJuros - parcelaSemJuros;
        double valorAcrescimo = 80; // valor fixo de exemplo
        try {
            validarValorJuros(valorJuros, valorAcrescimo);
        } catch (AumentoMaiorDoQueJurosException e){
            //System.out.println("Catch da exceção: " + e.getMessage());
            valorAcrescimo = valorJuros/2;
        }
        double pagamentoMensal = pagamentoComJuros + valorAcrescimo;
        return pagamentoMensal;
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
