package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import estructuras.NodoRedBlack;
import estructuras.RedBlack;

public class TestRedBlack {

	RedBlack <String> arb;
	
	private void setupEscenario1() {
		arb = new RedBlack<>();
	}
	
	private void setupEscenario2() {
		arb = new RedBlack<>();
		arb.insertarNodo("D");
		arb.insertarNodo("B");
		arb.insertarNodo("H");
		arb.insertarNodo("A");
		arb.insertarNodo("I");
	}
	
	private void setupEscenario3() {
		arb = new RedBlack<>();
		arb.insertarNodo("D");
		arb.insertarNodo("C");
		arb.insertarNodo("H");
		arb.insertarNodo("A");
		arb.insertarNodo("I");
	}
	
	private void setupEscenario4() {
		arb = new RedBlack<>();
		arb.insertarNodo("D");
		arb.insertarNodo("B");
		arb.insertarNodo("H");
		arb.insertarNodo("C");
		arb.insertarNodo("A");
		arb.insertarNodo("I");
	}
	
	@Test
	public void testInsertarVacio() {
		setupEscenario1();
		arb.insertarNodo("D");
		assertEquals(arb.getRaiz().getElem(), "D");
		assertEquals(arb.getRaiz().getColor(), Color.BLACK);
	}
	
	@Test
	public void testInsertarNormal() {
		setupEscenario2();
		arb.insertarNodo("C");
		NodoRedBlack<String> raiz = arb.getRaiz();
		NodoRedBlack<String> ri = raiz.getIzq();
		NodoRedBlack<String> rd = raiz.getDer();
		NodoRedBlack<String> rii = ri.getIzq();
		NodoRedBlack<String> rid = ri.getDer();
		NodoRedBlack<String> rdd = rd.getDer();
		assertEquals(raiz.getElem(), "D");
		assertEquals(raiz.getColor(), Color.BLACK);
		assertEquals(ri.getElem(), "B");
		assertEquals (ri.getColor(), Color.BLACK);
		assertEquals(rd.getElem(), "H");
		assertEquals(rd.getColor(), Color.BLACK);
		assertEquals (rii.getElem(), "A");
		assertEquals(rii.getColor(), Color.RED);
		assertEquals(rid.getElem(), "C");
		assertEquals(rid.getColor(), Color.RED);
		assertEquals(rdd.getElem(), "I");
		assertEquals(rdd.getColor(), Color.RED);
	}
	
	@Test
	public void testInsertarIguales() {
		setupEscenario2();
		arb.insertarNodo("0");
		NodoRedBlack<String> raiz = arb.getRaiz();
		NodoRedBlack<String> ri = raiz.getIzq();
		NodoRedBlack<String> rd = raiz.getDer();
		NodoRedBlack<String> rii = ri.getIzq();
		NodoRedBlack<String> rid = ri.getDer();
		NodoRedBlack<String> rdd = rd.getDer();
		assertEquals(raiz.getElem(), "D");
		assertEquals(raiz.getColor(), Color.BLACK);
		assertEquals(ri.getElem(), "A");
		assertEquals (ri.getColor(), Color.BLACK);
		assertEquals(rd.getElem(), "H");
		assertEquals(rd.getColor(), Color.BLACK);
		assertEquals (rii.getElem(), "0");
		assertEquals(rii.getColor(), Color.RED);
		assertEquals(rid.getElem(), "B");
		assertEquals(rid.getColor(), Color.RED);
		assertEquals(rdd.getElem(), "I");
		assertEquals(rdd.getColor(), Color.RED);
	}
	
	@Test
	public void testInsertarDiferentes() {
		setupEscenario3();
		arb.insertarNodo("B");
		NodoRedBlack<String> raiz = arb.getRaiz();
		NodoRedBlack<String> ri = raiz.getIzq();
		NodoRedBlack<String> rd = raiz.getDer();
		NodoRedBlack<String> rii = ri.getIzq();
		NodoRedBlack<String> rid = ri.getDer();
		NodoRedBlack<String> rdd = rd.getDer();
		assertEquals(raiz.getElem(), "D");
		assertEquals(raiz.getColor(), Color.BLACK);
		assertEquals(ri.getElem(), "B");
		assertEquals (ri.getColor(), Color.BLACK);
		assertEquals(rd.getElem(), "H");
		assertEquals(rd.getColor(), Color.BLACK);
		assertEquals (rii.getElem(), "A");
		assertEquals(rii.getColor(), Color.RED);
		assertEquals(rid.getElem(), "C");
		assertEquals(rid.getColor(), Color.RED);
		assertEquals(rdd.getElem(), "I");
		assertEquals(rdd.getColor(), Color.RED);
	}
	
	@Test
	public void testInsertarPapaTioRojos() {
		setupEscenario4();
		arb.insertarNodo("0");
		NodoRedBlack<String> raiz = arb.getRaiz();
		NodoRedBlack<String> ri = raiz.getIzq();
		NodoRedBlack<String> rd = raiz.getDer();
		NodoRedBlack<String> rii = ri.getIzq();
		NodoRedBlack<String> rid = ri.getDer();
		NodoRedBlack<String> rdd = rd.getDer();
		NodoRedBlack<String> riii = rii.getIzq();
		assertEquals(raiz.getElem(), "D");
		assertEquals(raiz.getColor(), Color.BLACK);
		assertEquals(ri.getElem(), "B");
		assertEquals (ri.getColor(), Color.RED);
		assertEquals(rd.getElem(), "H");
		assertEquals(rd.getColor(), Color.BLACK);
		assertEquals (rii.getElem(), "A");
		assertEquals(rii.getColor(), Color.BLACK);
		assertEquals(rid.getElem(), "C");
		assertEquals(rid.getColor(), Color.BLACK);
		assertEquals(rdd.getElem(), "I");
		assertEquals(rdd.getColor(), Color.RED);
		assertEquals(riii.getElem(), "0");
		assertEquals(riii.getColor(), Color.RED);
	}
	
	@Test
	public void testBuscarRaiz() {
		setupEscenario4();
		try {
			ArrayList <String> res = arb.buscarElemento("D");
			assertEquals(res.size(), 1);
			assertEquals(res.get(0), "D");
		} catch (Exception e) {
			fail();
		}
		
	}
	
	@Test
	public void testBuscarNoExistente() {
		setupEscenario4();
		try {
			arb.buscarElemento("0");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testBuscarArrayList() {
		setupEscenario4();
		arb.insertarNodo("A");
		arb.insertarNodo("A");
		try {
			ArrayList<String> res = arb.buscarElemento("A");
			assertEquals(res.size(), 3);
			for (String x: res) {
				assertEquals(x, "A");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testEliminarSinCambios() {
		setupEscenario2();
		try {
			arb.eliminarNodo("A");
			NodoRedBlack<String> raiz = arb.getRaiz();
			NodoRedBlack<String> ri = raiz.getIzq();
			NodoRedBlack<String> rd = raiz.getDer();
			NodoRedBlack<String> rii = ri.getIzq();
			NodoRedBlack<String> rid = ri.getDer();
			NodoRedBlack<String> rdd = rd.getDer();
			assertEquals(raiz.getElem(), "D");
			assertEquals(raiz.getColor(), Color.BLACK);
			assertEquals(ri.getElem(), "B");
			assertEquals (ri.getColor(), Color.BLACK);
			assertEquals(rd.getElem(), "H");
			assertEquals(rd.getColor(), Color.BLACK);
			assertEquals (rii.getElem(), null);
			assertEquals(rdd.getElem(), "I");
			assertEquals(rdd.getColor(), Color.RED);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testEliminarCambio() {
		setupEscenario2();
		try {
			arb.eliminarNodo("D");
			NodoRedBlack<String> raiz = arb.getRaiz();
			NodoRedBlack<String> ri = raiz.getIzq();
			NodoRedBlack<String> rd = raiz.getDer();
			NodoRedBlack<String> rii = ri.getIzq();
			NodoRedBlack<String> rid = ri.getDer();
			NodoRedBlack<String> rdd = rd.getDer();
			assertEquals(raiz.getElem(), "H");
			assertEquals(raiz.getColor(), Color.BLACK);
			assertEquals(ri.getElem(), "B");
			assertEquals (ri.getColor(), Color.BLACK);
			assertEquals(rd.getElem(), "I");
			assertEquals(rd.getColor(), Color.BLACK);
			assertEquals (rii.getElem(), "A");
			assertEquals(rdd.getElem(), null);
			assertEquals(rii.getColor(), Color.RED);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testEliminarNoExistente () {
		setupEscenario2();
		try {
			arb.eliminarNodo("K");
			fail();
		} catch (Exception e) {
			NodoRedBlack<String> raiz = arb.getRaiz();
			NodoRedBlack<String> ri = raiz.getIzq();
			NodoRedBlack<String> rd = raiz.getDer();
			NodoRedBlack<String> rii = ri.getIzq();
			NodoRedBlack<String> rid = ri.getDer();
			NodoRedBlack<String> rdd = rd.getDer();
			assertEquals(raiz.getElem(), "D");
			assertEquals(raiz.getColor(), Color.BLACK);
			assertEquals(ri.getElem(), "B");
			assertEquals (ri.getColor(), Color.BLACK);
			assertEquals(rd.getElem(), "H");
			assertEquals(rd.getColor(), Color.BLACK);
			assertEquals (rii.getElem(), "A");
			assertEquals(rii.getColor(), Color.RED);
			assertEquals(rdd.getElem(), "I");
			assertEquals(rdd.getColor(), Color.RED);
		}
		
	}
}
