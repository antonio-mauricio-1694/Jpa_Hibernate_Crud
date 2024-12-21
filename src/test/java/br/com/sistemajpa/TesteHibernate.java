package br.com.sistemajpa;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.DaoGeneric;
import model.PessoaUsuario;
import model.TelefoneUser;

public class TesteHibernate {
	@Test
	public void testeHibernateUltil() {
		//HibernateUltil.getEntityManager();
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		
		PessoaUsuario pessoaUsuario = new 	PessoaUsuario();
		
		pessoaUsuario.setNome("Lucas");
		pessoaUsuario.setSobrenome("sousa");
		pessoaUsuario.setEmail("lucas16@gmail.com");
		pessoaUsuario.setLogin("luc");
		pessoaUsuario.setSenha("@admin2");
		
		daoGeneric.salvar(pessoaUsuario);
	}
	
	
	
	/*@Test
	public void testeBuscar() {
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		PessoaUsuario pessoaUsuario = new 	PessoaUsuario();
		
		pessoaUsuario.setId(2L);
		pessoaUsuario = daoGeneric.pesquisar(pessoaUsuario);
		System.out.println(pessoaUsuario);
		
		
		
	}*/
	
	
	@Test
	public void testeBuscar2() {
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		
	
		PessoaUsuario  pessoaUsuario = daoGeneric.pesquisar(2, PessoaUsuario.class);
	
		System.out.println(pessoaUsuario);
		
		
		
	}


	@Test
	public void testeUpdate() {
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		
	
		PessoaUsuario  pessoaUsuario = daoGeneric.pesquisar(14, PessoaUsuario.class);
		
		pessoaUsuario.setNome("Isis");
		pessoaUsuario.setSenha("160423");
		pessoaUsuario.setLogin("manu");
		pessoaUsuario.setSobrenome("de sousa");
		pessoaUsuario.setEmail("isis@gmail.com");
		daoGeneric.updateMerge(pessoaUsuario); 
	
		System.out.println(pessoaUsuario);
		
		
		
	}
	
	
	@Test
	public void testeDelete() {
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		
		PessoaUsuario  pessoaUsuario = daoGeneric.pesquisar( 22L , PessoaUsuario.class);
		
		daoGeneric.deletarPorId(pessoaUsuario);
	
	
	}
	
	
	@Test
	public void testeConsultar() {
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		
		List<PessoaUsuario> list = daoGeneric.listar(PessoaUsuario.class);
		
		for (PessoaUsuario pessoaUsuario : list) {
			
			System.out.println(pessoaUsuario);
			System.out.println("------------------------------------------------------");
			
		}
	
	
	}
	
	@Test
	public void testQueryList() {
	
	DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
	
	List<PessoaUsuario> list = daoGeneric.getEntityManager().createQuery("from PessoaUsuario where nome = 'Isis'" ).getResultList();
	
	
	for (PessoaUsuario pessoaUsuario : list) {
		
		System.out.println(pessoaUsuario);
		
	}
	
	}
	
	
	
	@Test
	public void testQueryListMax() {
	
	DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
	
	List<PessoaUsuario> list = daoGeneric.getEntityManager().createQuery("from PessoaUsuario order by id" ).setMaxResults(2).getResultList();
	
	
	for (PessoaUsuario pessoaUsuario : list) {
		
		System.out.println(pessoaUsuario);
		
	}
	
	}
	
	
	@Test
	public void testQueryLisParameter() {
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		
		List<PessoaUsuario> list =  daoGeneric.getEntityManager().createQuery("from PessoaUsuario where nome = :nome or sobrenome = : sobrenome" )
				.setParameter("nome", "antonio")
				.setParameter("sobrenome", "carvalho").getResultList();
		
		
		
		for (PessoaUsuario pessoaUsuario : list) {
			
			System.out.println(pessoaUsuario);
			
		}
		 
	}
	@Test
	public void testeNameQUery1() {
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		List<PessoaUsuario> lista = daoGeneric.getEntityManager().createNamedQuery("PessoaUsuario.buscaPorNome").getResultList();
		
		for (PessoaUsuario pessoaUsuario : lista) {
			
			System.out.println(pessoaUsuario);
			
		}
	}
	
	@Test
	public void testeNameQUery2() {
		DaoGeneric<PessoaUsuario> daoGeneric = new DaoGeneric<PessoaUsuario>();
		List<PessoaUsuario> lista = daoGeneric.getEntityManager().createNamedQuery("PessoaUsuario.buscaPorNome")
				.setParameter("nome", "Lucas")
				.getResultList();
		
		for (PessoaUsuario pessoaUsuario : lista) {
			
			System.out.println(pessoaUsuario);
			
		}
	}
	
	@Test
	public void gravaTelefone() {
		DaoGeneric daoGeneric = new DaoGeneric();
		
	PessoaUsuario pessoaUsuario	= (PessoaUsuario) daoGeneric.pesquisar(15L, PessoaUsuario.class);
	
	TelefoneUser telefoneUser = new TelefoneUser();
	telefoneUser.setTipo("celular");
	telefoneUser.setNumero("869981852547");
	telefoneUser.setPessoaUsuario(pessoaUsuario);
	daoGeneric.salvar(telefoneUser);
		
		
	}
	
	@Test
	public void consultarTelefones() {
		DaoGeneric daoGeneric = new DaoGeneric();
		
	PessoaUsuario pessoaUsuario	= (PessoaUsuario) daoGeneric.pesquisar(15L, PessoaUsuario.class);
	
	 for (TelefoneUser fone : pessoaUsuario.getTelefoneUsers()) {
		 
		 System.out.println(fone.getNumero());
		 System.out.println(fone.getTipo());
		 System.out.println(fone.getPessoaUsuario().getNome());
		
	}
		
		
	}
	

}
