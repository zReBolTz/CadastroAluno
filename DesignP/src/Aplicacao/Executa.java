package Aplicacao;

import modelos.Aluno;
import modelos.Endereco;
import view.ViewCadastro;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoArquivoTXT;


public class Executa {


	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, NumberFormatException, TransformerException  {


		BufferedReader reader= new BufferedReader( new InputStreamReader(System.in));





		int menu= 0 ;
		while(menu < 5) {
				
		menu= ViewCadastro.ViewMenuPrincipal(reader);
		

			try {

				switch(menu) {

				case 1:
					Crud.SalvarAluno(reader);
					break;
				case 2:

					Crud.ListarAluno();

					break;

				case 3:
					Crud.DeletarAluno(reader);
					break;

				case 4:
					Crud.EditarAluno(reader);
					break;
				
				
				case 5:
					ViewCadastro.ViewMsgFinal(3);
					break;
				}

			}catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
			
			
			
			
			
	
		
		
		
	
	
		
	











	



