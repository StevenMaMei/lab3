package estructuras;

import java.util.ArrayList;

public interface IRedBlack <T extends Comparable>{
	void insertFixUp(NodoRedBlack z);
	ArrayList<T> buscarElemento(T objetoAct) throws Exception;
	void eliminarNodo(T objetoAct) throws Exception;
	void deleteFixup(NodoRedBlack<T> x);
	void insertarNodo(T objetoAct);
	
}
