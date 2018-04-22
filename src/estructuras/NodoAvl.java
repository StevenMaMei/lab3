package estructuras;

import java.util.ArrayList;

public class NodoAvl<T extends Comparable> {
	
	private int fb;
	private ArrayList<T> repetidos;
	private NodoAvl<T> hijoIzq;
	private NodoAvl<T> hijoDer;
	private NodoAvl<T> padre;
	private T objeto;
	
	public NodoAvl(T o,NodoAvl<T> p){
		objeto =o;
		padre=p;
		repetidos = new ArrayList<>();
		repetidos.add(objeto);
	}
	
	public NodoAvl<T> insertarObjeto(T nuevo){
		if(objeto.compareTo(nuevo)>0){
			if(hijoIzq== null){
				hijoIzq=new NodoAvl<>(nuevo, this);
				return hijoIzq;
			}else{
				return hijoIzq.insertarObjeto(nuevo);
			}
		}else if(objeto.compareTo(nuevo)==0){
			repetidos.add(nuevo);
			return this;
		}else{
			if(hijoDer==null){
				hijoDer=new NodoAvl<>(nuevo,this );
				return hijoDer;
			}else{
				return hijoDer.insertarObjeto(nuevo);
			}
		}
	}
	public NodoAvl<T> buscarElemento(T obj){
		if(this.objeto.compareTo(obj) == 0){
			return this;
		}else if(this.objeto.compareTo(obj)>0){
			if(hijoIzq == null){
				return null;
			}else{
				return hijoIzq.buscarElemento(obj);
			}
		}else if(this.objeto.compareTo(obj)<0){
			if(hijoDer==null){
				return null;
			}else{
				return hijoDer.buscarElemento(obj);
			}
		}
		return null;
	}
	
	public void leftRotate(ArbolAvl a){
		NodoAvl<T> y = hijoDer;
		hijoDer=y.hijoIzq;
		if(y.hijoIzq!= null)
			y.hijoIzq.padre= this;
		y.padre=this.padre;
		if(this.padre==null){
			a.modificarRaiz(y);
		}else{
			if(this == padre.hijoIzq){
				padre.hijoIzq= y;
			}else{
				padre.hijoDer= y;
			}
		}
		y.hijoIzq=this;
		this.padre= y;
	}
	public void rightRotate(ArbolAvl a){
		NodoAvl<T> y = hijoIzq;
		hijoIzq=y.hijoDer;
		if(y.hijoDer!= null)
			y.hijoDer.padre= this;
		y.padre=this.padre;
		if(this.padre==null){
			a.modificarRaiz(y);
		}else{
			if(this == padre.hijoDer){
				padre.hijoDer= y;
			}else{
				padre.hijoIzq= y;
			}
		}
		y.hijoDer=this;
		this.padre= y;
	}
	public void balancear(ArbolAvl t){
		NodoAvl<T> actual= this;
		fb= darFactorBalanceo();
		if(Math.abs(fb)>1){
			if(fb==2){
				if(hijoDer.darFactorBalanceo()>=0){
					leftRotate(t);
					actual=this.padre;
				}else{
					hijoDer.rightRotate(t);
					leftRotate(t);
					actual= this.padre;
				}
			}else{//Fb ==-2
				if(hijoIzq.darFactorBalanceo()<=0){
					rightRotate(t);
					actual=this.padre;
				}else{
					hijoIzq.leftRotate(t);
					rightRotate(t);
					actual= this.padre;
				}
			}
		}
		if(actual.padre!= null){
			padre.balancear(t);
		}
	}
	public int darFactorBalanceo(){
		int izq =0;
		int der=0;
		if(hijoIzq != null){
			izq=hijoIzq.darAlturaIncluyendoRaiz();
		}
		if(hijoDer!= null){
			der=hijoDer.darAlturaIncluyendoRaiz();
		}
		fb= der-izq;
		return der-izq;
	}
	public int darAlturaIncluyendoRaiz(){
		int izq=1;
		int der=1;
		if(hijoIzq!=null){
			izq+=hijoIzq.darAlturaIncluyendoRaiz();
		}
		if(hijoDer!=null){
			der+=hijoDer.darAlturaIncluyendoRaiz();
		}
		return Math.max(izq, der);
	}
	public NodoAvl <T> sucesor (){
		NodoAvl <T> act = null;
		if (hijoDer != null) {
			act = hijoDer;
			while (act.hijoIzq != null) {
				act = act.hijoIzq;
			}
		}
		return act;
	}
	public NodoAvl<T> antecesor () {
		NodoAvl <T> act = null;
		if (hijoIzq != null) {
			act = hijoIzq;
			while (act.hijoDer != null) {
				act = act.hijoDer;
			}
		}
		return act;
	}
	
	public NodoAvl<T> darHijoIzq() {
		return hijoIzq;
	}
	public void modificarHijoIzq(NodoAvl<T> hijoIzq) {
		this.hijoIzq = hijoIzq;
	}
	public NodoAvl<T> darHijoDer() {
		return hijoDer;
	}
	public void modificarHijoDer(NodoAvl<T> hijoDer) {
		this.hijoDer = hijoDer;
	}
	public NodoAvl<T> darPadre() {
		return padre;
	}
	public void modificarPadre(NodoAvl<T> padre) {
		this.padre = padre;
	}
	public T darObjeto() {
		return objeto;
	}
	public void modificarObjeto(T objeto) {
		this.objeto = objeto;
	}
	
	public ArrayList<T> darRepetidos(){
		return repetidos;
	}
	
}
