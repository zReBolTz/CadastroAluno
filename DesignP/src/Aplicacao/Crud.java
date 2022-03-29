package Aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;
import Handler.XMLHandlerAluno;
import Util.ListaDeAlunos;
import modelos.Aluno;
import modelos.Endereco;
import view.ViewCadastro;
import modelos.Aluno;
import Util.ListaDeAlunos;

public class Crud {



	public static void SalvarAluno (BufferedReader reader) throws IOException, ParserConfigurationException, SAXException, TransformerException {

	
		
		Aluno aluno= new Aluno();
		Endereco endereco= new Endereco();

		
		String[] dadosAluno= ViewCadastro.ViewMenuSalvarAluno(reader);
		
		
			
			aluno.setNome(dadosAluno[0]);
			aluno.setCpf(dadosAluno[1]);
			aluno.setCurso(dadosAluno[2]);
			endereco.setRua(dadosAluno[3]);
			endereco.setBairro(dadosAluno[4]);
			endereco.setNum(Integer.parseInt(dadosAluno[5]));
			endereco.setCidade(dadosAluno[6]);
			endereco.setEstado(dadosAluno[7]);
			endereco.setCep(dadosAluno[8]);
			System.out.println("");

			aluno.setEndereco(endereco);
			
			ListaDeAlunos.getInstance().add(aluno);
			ManipulacaoArquivoTXT.SalvarArquivoTXT();
			ManipulacaoArquivoXML.SalvarArquivoXML();
	

		
		ViewCadastro.ViewMsgFinal(0);
		
	}
	public static void ListarAluno() throws IOException, ParserConfigurationException, SAXException {

		ListaDeAlunos.getInstance().clear();
	
		
		ManipulacaoArquivoXML.lerArquivoXml();
		
		//ManipulacaoArquivoTXT.LerArquivoTXT(ListAlunos);

		//		for(int i=0; i<ListAlunos.size(); i++)
		//			System.out.println(i+ " - "+ ListAlunos.get(i));



		//Para Mostrar ao usuário a lista de Cadastro  mas sem o indice no lado

		
			ViewCadastro.ViewListaAlunosEditada();
		

	}

	public static void DeletarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, SAXException, TransformerException{
		//criando uma ArrayList com a variavel ListaDeAlunos

		

		System.out.println();
		int indice= ViewCadastro.ViewMenuEditarOuDeletarAluno("Deletar", reader);
		ListaDeAlunos.getInstance().remove(indice);
		
		ManipulacaoArquivoXML.SalvarArquivoXML();
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		
		


		ViewCadastro.ViewMsgFinal(2);
	}

	public static void EditarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, SAXException, TransformerException{
		//criando uma ArrayList com a variavel ListaDeAlunos
		String[] dadosEditados={"",""};
		

	
		int indice = ViewCadastro.ViewMenuEditarOuDeletarAluno("editar",  reader);
		Aluno alunos= ListaDeAlunos.getInstance().get(indice);

		 dadosEditados= ViewCadastro.ViewOpcaoEdicao(reader);
		
		
		switch(Integer.parseInt(dadosEditados[0])) {
		case 1:
			alunos.setNome(dadosEditados[1]);
			break;

		case 2:
			alunos.setCpf(dadosEditados[1]);
			break;

		case 3:
			alunos.setCurso(dadosEditados[1]);
			break;

			
			case 4:
				alunos.getEndereco().setRua(dadosEditados[1]);
					break;
			
			case 5:
				alunos.getEndereco().setBairro(dadosEditados[1]);
					break;
					
			case 6:
				alunos.getEndereco().setNum(Integer.parseInt(dadosEditados[1]));
					break;
			case 7:
				alunos.getEndereco().setCidade(dadosEditados[1]);
					break;
				
			case 8:
				alunos.getEndereco().setEstado(dadosEditados[1]);
					break;
					
			case 9:
				alunos.getEndereco().setCep(dadosEditados[1]);
					break;
						
				
				}
				
		ListaDeAlunos.getInstance().set(indice, alunos);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
			

		
	

		
	
			ViewCadastro.ViewMsgFinal(1);
			}
		
		
		}
	
		
	



	








		
		
	

