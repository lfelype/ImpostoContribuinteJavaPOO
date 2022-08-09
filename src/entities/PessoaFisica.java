package entities;

import entities.Contribuinte;

public class PessoaFisica extends Contribuinte {

    private Double gastosSaude;

    public PessoaFisica(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double taxa() {
        double imposto;
        if (getRendaAnual() < 20000.0) {
            imposto = getRendaAnual() * 0.15;
        } else {
            imposto = getRendaAnual() * 0.25;
        }
        imposto = imposto - getGastosSaude()*0.5;
        if (imposto < 0.0) {
            imposto = 0.0;
        }
        return imposto;
    }
}
