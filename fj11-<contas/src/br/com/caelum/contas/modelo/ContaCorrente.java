package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel  {
	
	public ContaCorrente(){}
	public String getTipo(){
		return "Conta Corrente";
		//return super.getTipo()+" Corrente"
	}
	@Override
	public void saca(double valor){
		super.saca(valor+0.10);
	}
	@Override
	public double getValorImposto() {
		return this.getSaldo()*0.01;
	}
}
