package aplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Program {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		String caminho = "c:\\Temp\\empregados.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			
			String funcionario = br.readLine();
			while(funcionario != null) {
				
				String[] dados = funcionario.split(",");
				lista.add(new Funcionario(dados[0],Double.valueOf(dados[1])));
				funcionario = br.readLine();		
			}
			
			System.out.println("LISTANDO OS NOMES DO ARQUIVO");
			for(Funcionario l:lista) {
				System.out.println(l.getNome() + ", " + l.getSalario());
			}
			
			System.out.println();
			System.out.println("LISTANDO NOS NOMES ORDENADOS");
			Collections.sort(lista);
			for(Funcionario l:lista) {
				System.out.println(l.getNome() + ", " + String.format("%.2f", l.getSalario()));
			}
			
			
		}
		
		
	}
	
}
