package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	private String Nome;
	private String SobreNome;
	private String NomeCompleto;
	
	public Pessoa(){
		super();
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getSobreNome() {
		return SobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		SobreNome = sobreNome;
	}
	
	
	public String getNomeCompleto() {
		return NomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NomeCompleto == null) ? 0 : NomeCompleto.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((SobreNome == null) ? 0 : SobreNome.hashCode());
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (NomeCompleto == null) {
			if (other.NomeCompleto != null)
				return false;
		} else if (!NomeCompleto.equals(other.NomeCompleto))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (SobreNome == null) {
			if (other.SobreNome != null)
				return false;
		} else if (!SobreNome.equals(other.SobreNome))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", Nome=" + Nome + ", SobreNome=" + SobreNome + ", NomeCompleto=" + NomeCompleto + "]";
	}
	
    

	
    
}
