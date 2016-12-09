package test;

import static org.junit.Assert.*;

import org.junit.Test;

import persistence.CategoriaDAO;
import persistence.EsporteDAO;
import webapp.Categoria;
import webapp.Esporte;

public class TestDatabase {

	@Test
	public void testEsporte() {
		Esporte esporte = new Esporte();
		EsporteDAO esporteDAO = new EsporteDAO();
		esporte.setNomeEsporte("Capoeira");
		
		Esporte esporteTeste = esporteDAO.salvar(esporte);
		assertEquals(esporte.getNomeEsporte(),esporteTeste.getNomeEsporte() );
		Categoria categoria = new Categoria();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoria.setNomeCategoria("Profissional");
		Categoria categoriaTeste = categoriaDAO.salvar(categoria, esporteTeste.getIdEsporte());
		assertEquals(categoria.getNomeCategoria(), categoriaTeste.getNomeCategoria());
		
	}

}
