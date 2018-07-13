package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TesteDoBanco {
	public static void main(String[] args) {
		Banco banco=new Banco("Brasil",1);
		for(int i =0;i<10;i++){
			Conta conta=new ContaCorrente();
			banco.adiciona(conta);
		}
		System.out.println(banco);
	}
}
