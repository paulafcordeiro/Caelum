package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exceptions.SaldoInsuficienteException;

public abstract class Conta implements Comparable<Conta> {
	private String titular;
	private String agencia;
	private int numero;
	private String cpf;
	private int idade;
	private String dataDeAbertura;
	private double saldo;

	public Conta(){}
	
	public Conta(String titular){
		this.titular=titular;
	}
	/**
	 * 
	 * @param titular = É o parâmetro que recebe o nome do titular da conta;
	 * @param agencia = Agencia referente à conta do titular;
	 * @param numero = Número da conta do titular;
	 * @param cpf
	 */
	public Conta(String titular, String agencia, int numero, String cpf) {
		this(titular);
		this.agencia = agencia;
		this.numero = numero;
		this.cpf = cpf;
	}
	
@Override
	public String toString() {
		return titular+": "+agencia +"-"+ numero;
	}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	
	Conta other = (Conta) obj;
	return this.agencia==other.agencia && this.numero==other.numero;
}

/**
 * 
 * Mais algumas palavras por aqui. Métodos que adiciona um valor ao saldo;
 */
	public void deposita(double valor) {
		if(valor<0){
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		}else{
			this.saldo+=valor;
		}
	}

	public void saca(double valor){
		if(valor<0){
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		}
		if(this.saldo<valor){
			throw new SaldoInsuficienteException(valor);
		}
		this.saldo-=valor;

	}

	public double getSaldo() {
		return this.saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(String dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}
	public abstract String getTipo();//{
		//return "Conta";
	//}
	public void transfere(double valor, Conta conta){
		this.saca(valor);
		conta.deposita(valor);
	}
	
	public String recuperaDadosParaImpressao(){
		String dados="Titular: "+this.getTitular();
		dados += "\nNúmero: "+this.getNumero();
		dados += "\nAgência: "+this.getAgencia();
		dados += "\nSaldo: R$"+this.getSaldo();
		dados += "\nTipo: "+ this.getTipo();
		return dados;
	}
	
	public int compareTo(Conta outraConta){
		return this.getTitular().compareTo(outraConta.getTitular());
	}
}
