package estructuras;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class NodoRedBlack <T extends Comparable> implements Serializable{

	private T elem;
	private Color color;
	private NodoRedBlack izq;
	private NodoRedBlack der;
	private NodoRedBlack padre;
	private ArrayList<T> repetidos;
	
	public NodoRedBlack (T elem, NodoRedBlack padre, RedBlack arbol) {
		this.elem = elem;
		this.padre = padre;
		izq = arbol.getNil();
		der = arbol.getNil();
		color = Color.RED;
		repetidos = new ArrayList<>();
		repetidos.add(elem);
	}

	public T getElem() {
		return elem;
	}

	public void setElem(T elem) {
		this.elem = elem;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public NodoRedBlack getIzq() {
		return izq;
	}

	public void setIzq(NodoRedBlack izq) {
		this.izq = izq;
	}

	public NodoRedBlack getDer() {
		return der;
	}

	public void setDer(NodoRedBlack der) {
		this.der = der;
	}

	public NodoRedBlack getPadre() {
		return padre;
	}

	public void setPadre(NodoRedBlack padre) {
		this.padre = padre;
	}
	
	public void leftRotate(RedBlack T) {
		NodoRedBlack<T> y = der;
		der = y.izq;
		if (y.getIzq() != T.getNil()) {
			y.getIzq().setPadre(this);
		}
		y.setPadre(padre);
		if (padre == T.getNil()) {
			T.setRaiz(y);
		} else if (this == padre.getIzq()) {
			padre.setIzq(y);
		} else {
			padre.setDer(y);
		}
		y.setIzq(this);
		padre = y;
	}
	
	public void rigthRotate(RedBlack T) {
		NodoRedBlack<T> y = izq;
		izq = y.der;
		if (y.getDer() != T.getNil()) {
			y.getDer().setPadre(this);
		}
		y.setPadre(padre);
		if (padre == T.getNil()) {
			T.setRaiz(y);
		} else if (this == padre.getIzq()) {
			padre.setIzq(y);
		} else {
			padre.setDer(y);
		}
		y.setDer(this);
		padre = y;
	}
	
	public NodoRedBlack insertarObjeto(T nuevo, RedBlack arbol){
		if(elem.compareTo(nuevo)>0){
			if(izq == arbol.getNil()){
				izq=new NodoRedBlack<T>(nuevo, this, arbol);
				return izq;
			}else{
				return izq.insertarObjeto(nuevo, arbol);
			}
		}else if(elem.compareTo(nuevo)==0){
			repetidos.add(nuevo);
			return this;
		}else{
			if(der==arbol.getNil()){
				der=new NodoRedBlack<T>(nuevo,this, arbol);
				return der;
			}else{
				return der.insertarObjeto(nuevo, arbol);
			}
		}
	}
	
	public NodoRedBlack<T> antecesor () {
		NodoRedBlack <T> act = null;
		if (izq != null) {
			act = izq;
			while (act.getDer() != null) {
				act = act.getDer();
			}
		}
		return act;
	}
	
	public NodoRedBlack <T> sucesor (){
		NodoRedBlack <T> act = null;
		if (der != null) {
			act = der;
			while (act.getIzq() != null) {
				act = act.getIzq();
			}
		}
		return act;
	}
	
	public NodoRedBlack<T> buscarElemento(T objeto, RedBlack arb){
		if(elem.compareTo(objeto) == 0){
			return this;
		}else if(elem.compareTo(objeto)>0){
			if(izq == arb.getNil()){
				return null;
			}else{
				return izq.buscarElemento(objeto, arb);
			}
		}else if(elem.compareTo(objeto)<0){
			if(der==arb.getNil()){
				return null;
			}else{
				return der.buscarElemento(objeto, arb);
			}
		}
		return null;
	}
	
	public ArrayList<T> getRepetidos(){
		return repetidos;
	}
}
