package estructuras;

public class NodoAvl<T extends Comparable> {
	
	private int fb;
	private NodoAvl<T> hijoIzq;
	private NodoAvl<T> hijoDer;
	private NodoAvl<T> padre;
	private T objeto;
	
	public NodoAvl(T o){
		objeto =o;
	}
	
	public void leftRotate(ArbolAvl a){
		NodoAvl<T> y = hijoDer;
		hijoDer=y.hijoIzq;
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
	public void balancear(){
		
		fb= darFactorBalanceo();
		if(Math.abs(fb)>1){
			if(fb==2){
				
			}else{//Fb ==-2
				
			}
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
	
}
