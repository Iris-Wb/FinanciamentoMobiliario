package modelo;

public class Apartamento extends Financiamento{
    private int numVagasGaragem;
    private int numeroAndar;
    public Apartamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar){
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.numVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal(){
        double taxaJurosMensal = ((taxaJurosAnual/100)/12);
        double meses = (prazoFinanciamento*12);
        double parcelaApartamento = valorImovel*(taxaJurosMensal*Math.pow((1+taxaJurosMensal), meses))/(Math.pow((1+taxaJurosMensal), meses)-1);
        return parcelaApartamento;
    }
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
    public void imprimirDadosFinanciamento(){
        System.out.printf("Valor do Imóvel APARTAMENTO: " + valorImovel);
        System.out.printf("\nPrazo do Financiamento: " + prazoFinanciamento);
        System.out.printf("\nTaxa de Juros: " + taxaJurosAnual);
        System.out.printf("\nNúmeros de Vagas de Garagem: " + numVagasGaragem);
        System.out.printf("\nNúmero do Andar: " + numeroAndar);
    }
}
