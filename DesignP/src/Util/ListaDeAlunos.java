package Util;

import java.util.ArrayList;
import java.util.List;

import modelos.Aluno;

public class ListaDeAlunos {

	private static List<Aluno> listaAlunos= new ArrayList<Aluno>();
	
	public static List<Aluno> getInstance(){
		return listaAlunos;
	}

	
	
	
}
