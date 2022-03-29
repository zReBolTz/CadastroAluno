package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerAluno;
import Util.ListaDeAlunos;
import modelos.Aluno;
import Handler.XMLHandlerAluno;


public class ManipulacaoArquivoXML {

	public static String nomeDoArquivo= "CadastrodeAluno.xml";
	
	
	public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
		
		DocumentBuilderFactory DBF= DocumentBuilderFactory.newInstance();
		DocumentBuilder DB= DBF.newDocumentBuilder();
		Document doc= DB.newDocument();
	
		Element alunoTag= doc.createElement("Alunos");
		doc.appendChild(alunoTag);
		
		for(Aluno a: ListaDeAlunos.getInstance()) {
			
			Element alunoTagElement= doc.createElement("aluno");
			alunoTag.setAttribute("id","1" );
			alunoTag.appendChild(alunoTagElement);
			
			
			Element nomeTag= doc.createElement("nome");
			nomeTag.setTextContent(a.getNome());
			alunoTag.appendChild(nomeTag);
			
			Element cpfTag= doc.createElement("CPF");
			cpfTag.setTextContent(a.getCpf());
			alunoTag.appendChild(cpfTag);
			
			
			Element cursoTag= doc.createElement("Curso");
			cursoTag.setTextContent(a.getCurso());
			alunoTag.appendChild(cursoTag);
			
			
			Element EnderecoTag= doc.createElement("Endereco");
			alunoTag.appendChild(EnderecoTag);
			
			
				Element RuaTag= doc.createElement("Rua");
				RuaTag.setTextContent(a.getEndereco().getRua());
				alunoTag.appendChild(RuaTag);
				
				Element bairroTag= doc.createElement("Bairro");
				bairroTag.setTextContent(a.getEndereco().getBairro());
				alunoTag.appendChild(bairroTag);
				
				Element numeroTag= doc.createElement("Numero");
				numeroTag.setTextContent(String.valueOf(a.getEndereco().getNum()));
				alunoTag.appendChild(numeroTag);
				
				Element cidadeTag= doc.createElement("Cidade");
				cidadeTag.setTextContent(a.getEndereco().getCidade());
				alunoTag.appendChild(cidadeTag);
				
				Element estadoTag= doc.createElement("Estado");
				estadoTag.setTextContent(a.getEndereco().getEstado());
				alunoTag.appendChild(estadoTag);
				
				Element cepTag= doc.createElement("CEP");
				cepTag.setTextContent(String.valueOf(a.getEndereco().getRua()));
				alunoTag.appendChild(cepTag);
			
			
			
		}
		
		
		TransformerFactory tf= TransformerFactory.newDefaultInstance();
		Transformer trans= tf.newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");
		
		
		
		DOMSource source =  new DOMSource(doc);
			
		
		
		try(OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){
			StreamResult result= new StreamResult(osw);
			trans.transform(source, result);
		}
		
			
		
		
	}
	public static void lerArquivoXml() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		
		SAXParserFactory spf= SAXParserFactory.newInstance();
		SAXParser parser= spf.newSAXParser();
		
		try(InputStreamReader isr= new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")){
			
			InputSource source= new InputSource(isr);
			XMLHandlerAluno xandler= new XMLHandlerAluno();
			
			parser.parse(source, xandler);
			
			
		}
		
		
	}
	
	
	
}
