package br.com.caelum.contas.main;

import java.util.Arrays;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class Banco {
	private String nome;
	private int numero;
	private Conta contas[];
	private int tamanho=0;
	
	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public Banco(String nome, int numero){
		this.nome=nome;
		this.numero=numero;
		this.contas=new ContaCorrente[10];
	}
	
	public void adiciona(Conta conta){
		for(int i =0; i<this.contas.length; i++){
			if(this.contas[i]==null){
				this.contas[i]=conta;
				break; //pra fazer só uma vez
			}else {
				this.redimensionaContas();
			}
		} 
	}
	
	private void redimensionaContas() {
		Conta[] novo = new Conta[(int)(this.contas.length*1.3)];
		for(int i=0;i<this.contas.length;i++){
			novo[i]=this.contas[i];
		}
		this.contas=novo;		
	}

	public void remove(Conta contaASerRemovida){
		for(int j=0;j<contas.length;j++){
			if(this.contas[j].equals(contaASerRemovida)){
				this.contas[j]=null;
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Banco [contas=" + Arrays.toString(contas) + "]";
	}
	
}
