package modelos;

	public class Aluno {
			private String nome;
			private String cpf;
			private String curso;
			private Endereco endereco;
			
			
			public Aluno(String dados) {
				String[] atributos = dados.split(",");
				String []nome = atributos[1].split("=");
				String []cpf= atributos[2].split("=");
				String []curso= atributos[3].split("=");
			
				Endereco endereco1 = new Endereco(atributos);
				this.nome= nome[1].trim();
				this.cpf= cpf[1].trim();
				this.curso= curso[1].trim();
				this.endereco= endereco1;
			
				
				
				
//				for(int x= 0; x < atributos.length; x++)
//					System.out.println(atributos[x]);
			}
			public Aluno() {
				
			}
			
			
			
			public String getNome() {
				return nome;
			}
			public void setNome(String nome) {
				this.nome = nome;
			}
			public String getCpf() {
				return cpf;
			}
			public void setCpf(String Cpf) {
				this.cpf = Cpf;
			}
			public String getCurso() {
				return curso;
			}
			public void setCurso(String curso) {
				this.curso = curso;
			}
			public Endereco getEndereco() {
				return endereco;
			}
			public void setEndereco(Endereco endereco) {
				this.endereco = endereco;
			}
			
			
			
			
			@Override
			public String toString() {
				return "AlunoX, nome= " +  nome + ", cpf= " + cpf + ", curso= " + curso + ", endereço= " + endereco;
			}
	
			
			
	
	
	
	
}
