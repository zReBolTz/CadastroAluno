package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import Util.ListaDeAlunos;
import modelos.Aluno;

public class ViewCadastro {

	
	

	

	

	public static int ViewMenuPrincipal(BufferedReader Reader) throws NumberFormatException, IOException{
		System.out.println();
		
		System.out.println("Cadastro Senai");
		System.out.println("[1] CADASTRO DE USUÁRIO");
		System.out.println("[2] LISTA DE USUÁRIOS");
		System.out.println("[3] EXCLUIR USUÁRIO");
		System.out.println("[4] EDITAR USUÁRIO");
		System.out.println("[5] SAIR");
		
		
		return Integer.parseInt(Reader.readLine());
		
		
		
	}
	public static String[] ViewMenuSalvarAluno(BufferedReader reader) throws IOException {
		String[]MenuAluno= {"Nome do aluno","cpf", "Curso", "Rua:", "Bairro:", "Numero:", "Cidade:", "Estado:", "CEP:"};
		
		
		
		String[] dadosAluno={"","","","","","","","",""};
		for(int i=0; i< MenuAluno.length;i++) {
			System.out.println(MenuAluno[i]);
			dadosAluno[i]=reader.readLine();
		}
		return dadosAluno;
	}
	
	
	
	public static int ViewMenuEditarOuDeletarAluno(String editar_Deletar, BufferedReader Reader) throws NumberFormatException, IOException {
		
		for(int i=0; i< ListaDeAlunos.getInstance().size(); i++)
			System.out.println(i+ " - "+ ListaDeAlunos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja " + editar_Deletar);
		
		
		
		
		
	return 	Integer.parseInt(Reader.readLine());
	}
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws NumberFormatException, IOException{
		String[] dadosEditados={"","",};
		

		System.out.println("escolha o Atributo que deseja editar:");
		System.out.println("1 - Nome\n" 
		+"2 - CPF\n" 
		+"3 - Curso\n"  
		+"4 - Rua\n" 
		+"5 - Número\n"
		+"6 - Bairro\n" 
		+"7 - Cidade\n"
		+"8 - Estado\n"
		+"9 - CEP\n");
		dadosEditados[0]=(reader.readLine());

		
		
		System.out.println("Digite o novo valor do atributo:");
		dadosEditados[1]=(reader.readLine());
		
		
		


		
		
		
		
		
		return dadosEditados;
	}
	
	public static void ViewListaAlunosEditada(){
		for(Aluno a: ListaDeAlunos.getInstance()) {
			
		
			System.out.println("-------------------------------------------------------------------------|");
			System.out.println("NOME= " + a.getNome()                                                 	);
			System.out.println("CPF= " + a.getCpf()                                                  	);
			System.out.println("CURSO= " + a.getCurso()                                             	);
			System.out.println("-------------------------------------------------------------------------|");
			System.out.println("ENDEREÇO= " + a.getEndereco()+                                          "|");
			System.out.println("-------------------------------------------------------------------------|");
			
			
		}
	}
	
	
	
		public static void ViewMsgFinal(int op) {
			
			String[] msgFinal= {"CADASTRO REALIZADO COM SUCESSO", "ALUNO EDITADO COM SUCESO", "ALUNO DELETADO COM SUCESSO", "OBRIGADO E VOLTE SEMPRE =)"}; 
			
		System.out.println(msgFinal[op]);	
		}

}
