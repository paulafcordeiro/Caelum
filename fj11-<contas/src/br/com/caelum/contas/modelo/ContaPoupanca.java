package br.com.caelum.contas.modelo;

public class ContaPoupanca extends Conta{
	public ContaPoupanca(){}
	public String getTipo(){
		return "Conta Poupança";
		//return super.getTipo()+" Poupança";
	}
}
