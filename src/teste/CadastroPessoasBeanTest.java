package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import beans.CadastroPessoasBean;
import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;

public class CadastroPessoasBeanTest {

	CadastroPessoasBean c;
	
	@Before
	public void setUp() throws Exception {
		c = new CadastroPessoasBean();
	}

	@Test
	public void testCriar() {
		
		c.setTipoNovaPessoa("PF");
		c.criar();
		assertEquals(new PessoaFisica(), c.getPessoaSelecionada());

		c.setTipoNovaPessoa("PJ");
		c.criar();		
		assertEquals(new PessoaJuridica(), c.getPessoaSelecionada());
		
	}

	@Test
	public void testSalvar() {
		Pessoa pss = new PessoaFisica();
		
		pss.setNome("José Levy");
		pss.setEmail("clic00@yahho.com");
		pss.setTelefone("(091)984023898");

		assertFalse(c.getLista().contains(pss));
		c.setPessoaSelecionada(pss);
		c.salvar();
		assertTrue(c.getLista().contains(pss));		
	}

	@Test
	public void testExcluir() {
		Pessoa pe = new PessoaFisica();
		pe.setNome("Hospede 08");
		pe.setEmail("cliente08@teste.com");
		pe.setTelefone("(091)89023808");

		assertTrue(c.getLista().contains(pe));
		c.setPessoaSelecionada(pe);
		c.excluir();
		assertFalse(c.getLista().contains(pe));		
	}

}
