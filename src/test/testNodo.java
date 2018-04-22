package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import estructuras.*;

public class testNodo {

	private NodoRedBlack<String> raiz;
	private RedBlack arbol;
	private void escen1 () {
		arbol = new RedBlack();
		raiz = new NodoRedBlack<String>("D", arbol.getNil(), arbol);
		arbol.insertarNodo("D");
	}
	
	@Test
	public void testInsertar() {
		escen1();
		try {
		arbol.insertarNodo("F");
		arbol.insertarNodo("B");
		arbol.insertarNodo("D");
		arbol.insertarNodo("C");
		arbol.insertarNodo("I");
		arbol.insertarNodo("E");
		arbol.insertarNodo("A");
		System.out.println(arbol.getRaiz().getElem());
//		assertTrue(arbol.getRaiz().getElem().equals("D"));
		System.out.println(arbol.getRaiz().getIzq().getElem());
//		assertTrue(arbol.getRaiz().getIzq().getElem().equals("C"));
		System.out.println(arbol.getRaiz().getIzq().getIzq().getElem());
//		assertTrue(arbol.getRaiz().getIzq().getIzq().getElem().equals("A"));
//		System.out.println(arbol.getRaiz().getIzq().getIzq().getIzq());
//		assertTrue(arbol.getRaiz().getIzq().getIzq().getIzq() == arbol.getNil());
		System.out.println(arbol.getRaiz().getIzq().getDer().getElem());
//		assertTrue(arbol.getRaiz().getIzq().getDer().getElem().equals("B"));
		System.out.println(arbol.getRaiz().getDer().getElem());
//		assertTrue(arbol.getRaiz().getDer().getElem().equals("F"));
		System.out.println(arbol.getRaiz().getDer().getIzq().getElem());
//		assertTrue(arbol.getRaiz().getDer().getIzq().getElem().equals("E"));
		System.out.println(arbol.getRaiz().getDer().getDer().getElem());
//		assertTrue(arbol.getRaiz().getDer().getDer().getElem().equals("I"));
		System.out.println(arbol.getRaiz().getDer().getDer().getIzq().getElem());
//		assertTrue(arbol.getRaiz().getDer().getIzq().getDer().getElem().equals("G"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
