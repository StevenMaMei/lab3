package test;

import static org.junit.Assert.*;

import org.junit.Test;

import estructuras.ArbolAvl;
import estructuras.NodoAvl;

public class TestArbolAvl {
	ArbolAvl<Integer> arbol;
	private void setupEscenario0(){
		arbol= new ArbolAvl<>();
	}
	private void setupEscenario1(){
		arbol= new ArbolAvl<>();
		NodoAvl<Integer> n1=new NodoAvl<Integer>(5,null);
		arbol.modificarRaiz(n1);
		NodoAvl<Integer> n2= new NodoAvl<Integer>(3,n1);
		NodoAvl<Integer> n3= new NodoAvl<Integer>(8,n1);
		NodoAvl<Integer> n4= new NodoAvl<Integer>(4,n2);
		n1.modificarHijoIzq(n2);
		n1.modificarHijoDer(n3);
		n2.modificarHijoDer(n4);
	}
	private void setupEscenario2(){
		arbol= new ArbolAvl<>();
		NodoAvl<Integer> n1=new NodoAvl<Integer>(5,null);
		arbol.modificarRaiz(n1);
		NodoAvl<Integer> n2= new NodoAvl<Integer>(3,n1);
		NodoAvl<Integer> n3= new NodoAvl<Integer>(8,n1);
		NodoAvl<Integer> n4= new NodoAvl<Integer>(4,n3);

		n1.modificarHijoIzq(n2);
		n1.modificarHijoDer(n3);
		n3.modificarHijoIzq(n4);
	}
	private void setupEscenario3(){
		arbol=new ArbolAvl<>();
		NodoAvl<Integer> raiz= new NodoAvl<Integer>(5,null);
		arbol.modificarRaiz(raiz);
	}
	
	private void setupEscenario4(){
		arbol= new ArbolAvl<>();
		NodoAvl<Integer> raiz= new NodoAvl<Integer>(5,null);
		arbol.modificarRaiz(raiz);
		raiz.modificarHijoIzq(new NodoAvl<Integer>(3,raiz));
		raiz.darHijoIzq().modificarHijoDer(new NodoAvl<Integer>(4,raiz.darHijoIzq()));
	}
	
	private void setupEscenario5(){
		arbol=new ArbolAvl<>();
		NodoAvl<Integer> raiz= new NodoAvl<Integer>(5,null);
		arbol.modificarRaiz(raiz);
		raiz.modificarHijoDer(new NodoAvl<Integer>(7,raiz));
		raiz.darHijoDer().modificarHijoIzq(new NodoAvl<Integer>(6,raiz.darHijoDer()));

	}
	@Test
	public void probarRotaciones(){
		setupEscenario1();
		arbol.darRaiz().rightRotate(arbol);
		assertTrue(arbol.darRaiz().darObjeto()==3);
		assertTrue(arbol.darRaiz().darPadre()== null);
		NodoAvl<Integer> raiz = arbol.darRaiz();
		assertTrue(raiz.darHijoDer().darObjeto()==5);
		assertTrue(raiz.darHijoDer().darHijoIzq().darObjeto()==4);
		assertTrue(raiz.darHijoDer().darHijoDer().darObjeto()==8);
		assertTrue(raiz.darHijoIzq()== null);
		assertTrue(raiz.darHijoDer().darHijoIzq().darHijoDer() == null && raiz.darHijoDer().darHijoIzq().darHijoIzq()== null);
		assertTrue(raiz.darHijoDer().darHijoDer().darHijoIzq()== null && raiz.darHijoDer().darHijoDer().darHijoDer()== null);
		setupEscenario2();
		arbol.darRaiz().leftRotate(arbol);
		assertTrue(arbol.darRaiz().darPadre()== null);
		assertTrue(arbol.darRaiz().darObjeto()==8);
		raiz = arbol.darRaiz();
		assertTrue(raiz.darHijoDer()== null);
		assertTrue(raiz.darHijoIzq().darObjeto()== 5);
		assertTrue(raiz.darHijoIzq().darHijoIzq().darObjeto()==3);
		assertTrue(raiz.darHijoIzq().darHijoIzq().darHijoDer()== null);
		assertTrue(raiz.darHijoIzq().darHijoIzq().darHijoIzq()== null);
		assertTrue(raiz.darHijoIzq().darHijoDer().darObjeto()==4);
		assertTrue(raiz.darHijoIzq().darHijoDer().darHijoIzq()== null);
		assertTrue(raiz.darHijoIzq().darHijoDer().darHijoDer()== null);
		
		
	}
	
	@Test
	public void probarFactorBalanceo(){
		setupEscenario3();
		assertTrue(arbol.darRaiz().darFactorBalanceo()==0);
		setupEscenario1();
		assertTrue(arbol.darRaiz().darFactorBalanceo()==-1);
		arbol.darRaiz().rightRotate(arbol);
		assertTrue(arbol.darRaiz().darFactorBalanceo()==2);
		setupEscenario2();
		assertTrue(arbol.darRaiz().darFactorBalanceo()==1);
		arbol.darRaiz().leftRotate(arbol);
		assertTrue(arbol.darRaiz().darFactorBalanceo()==-2);
	}
	@Test
	public void probarBalanceo(){
		//CASO 1
		setupEscenario1();
		arbol.darRaiz().rightRotate(arbol);
		assertTrue(arbol.darRaiz().darObjeto()==3);
		arbol.darRaiz().darHijoDer().darHijoDer().balancear(arbol);
		assertTrue(arbol.darRaiz().darObjeto()==5);
		assertTrue(arbol.darRaiz().darHijoDer().darObjeto()==8);
		assertTrue(arbol.darRaiz().darHijoIzq().darObjeto()==3);
		assertTrue(arbol.darRaiz().darHijoIzq().darHijoDer().darObjeto()==4);
		assertTrue(arbol.darRaiz().darHijoIzq().darHijoIzq()== null);
		//CASO 2
		setupEscenario2();
		arbol.darRaiz().leftRotate(arbol);
		assertTrue(arbol.darRaiz().darObjeto()==8);
		arbol.darRaiz().darHijoIzq().darHijoIzq().balancear(arbol);
		assertTrue(arbol.darRaiz().darObjeto()==5);
		assertTrue(arbol.darRaiz().darPadre()== null);
		assertTrue(arbol.darRaiz().darHijoIzq().darObjeto()== 3);
		assertTrue(arbol.darRaiz().darHijoIzq().darPadre().darObjeto()==5);
		assertTrue(arbol.darRaiz().darHijoDer().darObjeto()== 8);
		assertTrue(arbol.darRaiz().darHijoDer().darPadre().darObjeto()== 5);
		assertTrue(arbol.darRaiz().darHijoDer().darHijoIzq().darObjeto()==4);
		assertTrue(arbol.darRaiz().darHijoDer().darHijoIzq().darPadre().darObjeto()==8);
		//CASO3
		setupEscenario4();
		arbol.darRaiz().darHijoIzq().darHijoDer().balancear(arbol);;
		assertTrue(arbol.darRaiz().darObjeto()==4);
		assertTrue(arbol.darRaiz().darPadre()== null);
		assertTrue(arbol.darRaiz().darHijoDer().darObjeto()==5);
		assertTrue(arbol.darRaiz().darHijoIzq().darObjeto()==3);
		//CASO4
		setupEscenario5();
		arbol.darRaiz().darHijoDer().darHijoIzq().balancear(arbol);
		assertTrue(arbol.darRaiz().darObjeto()==6);
		assertTrue(arbol.darRaiz().darPadre()== null);
		assertTrue(arbol.darRaiz().darHijoIzq().darObjeto()== 5);
		assertTrue(arbol.darRaiz().darHijoIzq().darPadre().darObjeto()==6);
		assertTrue(arbol.darRaiz().darHijoDer().darObjeto()==7);
		assertTrue(arbol.darRaiz().darHijoDer().darPadre().darObjeto()==6);
	}
	
	@Test
	public void probarInsertar(){
		//CASO1
		setupEscenario0();
		arbol.insertar(5);
		assertTrue(arbol.darRaiz().darObjeto()==5);
		arbol.insertar(3);
		assertTrue(arbol.darRaiz().darHijoIzq().darObjeto()==3);
		arbol.insertar(4);
		assertTrue(arbol.darRaiz().darObjeto()==4 && arbol.darRaiz().darHijoDer().darObjeto()==5 
				&& arbol.darRaiz().darHijoIzq().darObjeto()==3);
		//CASO2
		setupEscenario0();
		arbol.insertar(5);
		assertTrue(arbol.darRaiz().darObjeto()== 5);
		arbol.insertar(7);
		assertTrue(arbol.darRaiz().darHijoDer().darObjeto()==7);
		arbol.insertar(6);
		assertTrue(arbol.darRaiz().darObjeto()==6 && arbol.darRaiz().darHijoDer().darObjeto()==7 
				&& arbol.darRaiz().darHijoIzq().darObjeto()==5);
		//CASO3
		setupEscenario0();
		arbol.insertar(5);
		assertTrue(arbol.darRaiz().darObjeto()==5);
		arbol.insertar(3);
		assertTrue(arbol.darRaiz().darHijoIzq().darObjeto()==3);
		arbol.insertar(2);
		assertTrue(arbol.darRaiz().darObjeto()==3 && arbol.darRaiz().darHijoDer().darObjeto()==5 
				&& arbol.darRaiz().darHijoIzq().darObjeto()==2);
		//CASO4
		setupEscenario0();
		arbol.insertar(5);
		arbol.insertar(7);
		arbol.insertar(8);
		assertTrue(arbol.darRaiz().darObjeto()==7 && arbol.darRaiz().darHijoDer().darObjeto()==8 
				&& arbol.darRaiz().darHijoIzq().darObjeto()==5);
	}
	
	@Test
	public void probarEliminar(){
		probarInsertar();
		arbol.insertar(9);
		try {
			arbol.eliminarNodo(5);
		} catch (Exception e) {
			fail();
		}
		assertTrue(arbol.darRaiz().darObjeto()==8&& arbol.darRaiz().darHijoIzq().darObjeto()==7&&arbol.darRaiz().darHijoDer().darObjeto()==9);
		assertTrue(arbol.darRaiz().darHijoDer().darPadre().darObjeto()==8&&arbol.darRaiz().darHijoIzq().darPadre().darObjeto()==8);
		try {
			assertTrue(arbol.buscarElemento(5)== null);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void probarBuscar(){
		setupEscenario0();
		try {
			assertTrue(arbol.buscarElemento(10)== null);
			fail();
		} catch (Exception e) {
			
		}
		setupEscenario1();
		try {
			assertTrue(arbol.buscarElemento(4).get(0)==4);
			assertTrue(arbol.buscarElemento(100)== null);
		} catch (Exception e) {
			fail();
		}
		
	}

}
