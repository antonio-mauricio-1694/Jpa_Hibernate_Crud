package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TelefoneUser  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String numero;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PessoaUsuario pessoaUsuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public PessoaUsuario getPessoaUsuario() {
		return pessoaUsuario;
	}

	public void setPessoaUsuario(PessoaUsuario pessoaUsuario) {
		this.pessoaUsuario = pessoaUsuario;
	}
	
	
	
	
	
	

}
