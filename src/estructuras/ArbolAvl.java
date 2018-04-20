package estructuras;

public class ArbolAvl<T extends Comparable> {

	private NodoAvl<T> raiz;
	
	public void modificarRaiz(NodoAvl<T> n){
		raiz= n;
	}
	public NodoAvl<T> darRaiz(){
		return raiz;
	}
}
