package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Util.ListaDeAlunos;
import modelos.Aluno;

public class ManipulacaoArquivoTXT {

	private static String nomeDoArquivo= "Cadastro de Alunos.txt";
	
	
	
	public static void SalvarArquivoTXT() throws IOException {
	
		try(BufferedWriter buffer= new BufferedWriter(new FileWriter(nomeDoArquivo));
		PrintWriter pw= new PrintWriter(buffer)){
			for (Aluno a: ListaDeAlunos.getInstance()) 
			pw.println(a);
			
		
					}
				}
	
	public static void LerArquivoTXT () throws IOException {
		
		
		try (FileWriter arq= new FileWriter(nomeDoArquivo, true)){
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String line="";



		try (BufferedReader reader= new BufferedReader(new FileReader(nomeDoArquivo))){
			while((line= reader.readLine()) != null && !"".equals(line)) {
				Aluno al= new Aluno(line);
				ListaDeAlunos.getInstance().add(al);
			}


		} catch (IOException e) {

			e.printStackTrace();


		}
		
		
		
		}
	
	
	
	
	
	
	
	

	
}
