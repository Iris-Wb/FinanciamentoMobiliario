package modelo;

public class Apartamento extends Financiamento{
    public Apartamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal(){
        double taxaJurosMensal = ((taxaJurosAnual/100)/12);
        double meses = (prazoFinanciamento*12);
        double parcelaApartamento = valorImovel*(taxaJurosMensal*Math.pow((1+taxaJurosMensal), meses))/(Math.pow((1+taxaJurosMensal), meses)-1);
        return parcelaApartamento;
    }


}
