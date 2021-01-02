import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.DaoGenerico;
import entity.Pessoa;

@RequestScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGenerico<Pessoa> daoGenerico = new DaoGenerico<Pessoa>();
	private List<Pessoa> listaPessoa = new ArrayList<Pessoa>();

	public PessoaBean() {
		if (listaPessoa.isEmpty()) {
			listaPessoa = daoGenerico.doListar(pessoa);
		}
	}
	
	public String doAdicionar() {
		daoGenerico.doAdicionar(pessoa);
		mostrarMessage("Adicionado com sucesso !");
		return "";
	}
	
	public String doSalvar() {
		pessoa = daoGenerico.doSalvar(pessoa);
		mostrarMessage("Salvo com sucesso !");
		return "";
	}

	public String doApagar(Pessoa itemGrid) {
		daoGenerico.doApagarPorId(itemGrid);
		listaPessoa.remove(itemGrid);
		mostrarMessage("Apagado com sucesso !");
		return "";
	}
	
	/*
	 * @PostConstruct public void init() { if (listaPessoa.isEmpty()) { listaPessoa
	 * = daoGenerico.doListar(pessoa); } }
	 */
	public void doListar() {
		listaPessoa = daoGenerico.doListar(pessoa);
	}

	public void doSelectPessoa(Pessoa itemGrid) {
		pessoa = itemGrid;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public void mostrarMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, (summary == null) || (summary.isEmpty() || summary.isBlank()) ? "sem msg" :  summary , null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

}
