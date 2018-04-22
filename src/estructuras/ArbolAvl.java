package estructuras;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class ArbolAvl<T extends Comparable> implements Serializable{

	private NodoAvl<T> raiz;
	
	public void modificarRaiz(NodoAvl<T> n){
		raiz= n;
	}
	public NodoAvl<T> darRaiz(){
		return raiz;
	}
	
	public void insertar(T nuevo){
		if(raiz== null){
			raiz= new NodoAvl<>(nuevo, null);
		}else{
			NodoAvl<T> n= raiz.insertarObjeto(nuevo);
			n.balancear(this);
		}
	}
	
	private NodoAvl<T> buscarNodo(T b) throws Exception{
		if(raiz== null){
			throw new Exception("Persona no encontrada");
		}else{
			return raiz.buscarElemento(b);
		}
	}
	public ArrayList<T> buscarElemento(T ob) throws Exception{
		NodoAvl<T> encontrado= buscarNodo(ob);
		if(encontrado == null){
			return null;
		}else{
			return encontrado.darRepetidos();
		}
	}
	public void eliminarNodo(T objetoAct) throws Exception {
		NodoAvl<T> z = buscarNodo(objetoAct);
		NodoAvl <T> y;
		NodoAvl<T> x=null;
		if (z == null) {
			throw new Exception(("No se encontro el objeto"));
		}
		if (z.darHijoIzq() == null || z.darHijoDer() == null) {
			y = z;
		} else {
			y = z.sucesor();
		}
		if (y.darHijoIzq() != null) {
			x = y.darHijoIzq();
		} else {
			x = y.darHijoDer();
		}
		if(x!=null)
			x.modificarPadre(y.darPadre());
		if (y.darPadre() == null) {
			raiz = x;
		} else {
			if (y == y.darPadre().darHijoIzq()) {
				y.darPadre().modificarHijoIzq(x);
			} else {
				y.darPadre().modificarHijoDer(x);
			}
		}
		if (y != z) {
			z.modificarObjeto(y.darObjeto());
		}
		z.balancear(this);
	}
}
