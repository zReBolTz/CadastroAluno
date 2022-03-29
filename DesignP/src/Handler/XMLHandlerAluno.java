package Handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Util.ListaDeAlunos;
import modelos.Aluno;
import modelos.Endereco;


public class XMLHandlerAluno extends DefaultHandler {

	private StringBuilder texto;
	Aluno aluno;
	Endereco endereco;
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inicio do Documento");

	}

	@Override
	public void endDocument() throws SAXException {

		System.out.println("Fim do Documento");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("aluno")) {
			aluno = new Aluno();
			endereco= new Endereco();
		}else {
			texto= new StringBuilder();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("nome")) {
			aluno.setNome(texto.toString());
		}else if(qName.equals("CPF")) {
			aluno.setCpf(texto.toString());
		}else if(qName.equals("Curso")) {
			aluno.setCurso(texto.toString());
		}else if(qName.equals("Rua")) {
			endereco.setRua(texto.toString());
		}else if(qName.equals("Bairro")){
			endereco.setBairro(texto.toString());
		}else if(qName.equals("Numero")) {
			endereco.setNum(Integer.parseInt(texto.toString()));
		}else if(qName.equals("Cidade")) {
			endereco.setCidade(texto.toString());
		}else if(qName.equals("Estado")) {
			endereco.setEstado(texto.toString());
		}else if(qName.equals("CEP")) {
			endereco.setCep(texto.toString());
			aluno.setEndereco(endereco);
			ListaDeAlunos.getInstance().add(aluno);       
		}
		    

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		texto.append(ch, start, length);	

	}

	@Override
	public void error(SAXParseException e) throws SAXException {


	}







}
