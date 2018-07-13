package br.com.caelum.contas.exceptions;

public class SaldoInsuficienteException extends RuntimeException {
	
	public SaldoInsuficienteException(double valor){
		super("Saldo insuficiente para sacas o valor de: "+valor);
	}
}
