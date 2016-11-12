package br.unipe.rest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Time implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	private int id;
	private String nome;
	private String estado;
	
	public Time() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Time(int id, String nome, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}
	
}