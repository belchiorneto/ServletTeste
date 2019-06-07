package api;

public class FuncionarioModel {
	String nome;
	long salario;
	int id;
	
	public FuncionarioModel(String nome, long salario, int id) {
		this.nome = nome;
		this.salario = salario;
		this.id = id;
	}
	
	private void setSalario(long valor) {
		salario = valor;
	}
	public long getSalario() {
		return salario;
	}
	private void setNome(String valor) {
		nome = nome;
	}
	public String getNome() {
		return nome;
	}
	private void setId(int valor) {
		id = valor;
	}
	public int getId() {
		return id;
	}
}
