package estructuras;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import mundo.Objeto;

public class RedBlack <T extends Comparable> implements IRedBlack<T>, Serializable{

	private NodoRedBlack<T> raiz;
	
	private NodoRedBlack <T> nil;
	
	public RedBlack (){
		nil = new NodoRedBlack<T>(null, raiz, this);
		nil.setColor(Color.BLACK);
	}

	public NodoRedBlack<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoRedBlack<T> raiz) {
		this.raiz = raiz;
	}

	public NodoRedBlack<T> getNil() {
		return nil;
	}

	public void setNil(NodoRedBlack<T> nil) {
		this.nil = nil;
	}
	
	@Override
	public void insertarNodo(T objetoAct) {

		NodoRedBlack<T> nodoInsertar = new NodoRedBlack<>(objetoAct, nil, this);

		if (raiz == null) {
			raiz = nodoInsertar;
		} else {
			if (nodoInsertar != null) {
				nodoInsertar = raiz.insertarObjeto(objetoAct, this);
			}

		}
		insertFixUp(nodoInsertar);

	}

	@Override
	public void insertFixUp(NodoRedBlack z) {
		while (z != nil && z.getPadre() != raiz && z.getPadre().getColor().equals(Color.RED)) {
			NodoRedBlack <T> papa = z.getPadre();
			NodoRedBlack<T> abuelo = papa.getPadre();
			if (papa == abuelo.getIzq()) {
				NodoRedBlack<T> y = abuelo.getDer();
				if (y.getColor().equals(Color.RED)) {
					papa.setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					abuelo.setColor(Color.RED);
					z = abuelo;
				} else {
					if (z == papa.getDer()) {
						z = papa;
						z.leftRotate(this);
				}
					papa.setColor(Color.BLACK);
					abuelo.setColor(Color.RED);
					abuelo.rigthRotate(this);
				}
			} else {
				NodoRedBlack<T> y = abuelo.getIzq();
				if (y.getColor().equals(Color.RED)) {
					papa.setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					abuelo.setColor(Color.RED);
					z = abuelo;
				} else {
					if (z == papa.getIzq()) {
						z = papa;
						z.rigthRotate(this);;
					}
					papa.setColor(Color.BLACK);
					abuelo.setColor(Color.RED);
					abuelo.leftRotate(this);;
					}
			}
		}
		raiz.setColor(Color.BLACK);
	}
	

	private NodoRedBlack<T> buscarNodo(T objetoAct) throws Exception {
		NodoRedBlack<T> encontrado = null;
		
		if (raiz == null) {
			throw new Exception("No se encontró el elemento a eliminar");
		} else {
			 encontrado = raiz.buscarElemento(objetoAct);
		}
		
		return encontrado;
	}
	
	
//	public void tranplant (NodoArbol<T> u, NodoArbol<T> v) {
//		if (u.getPadre() == nil) {
//			raiz = v;
//		} else if (u == u.getPadre().getIzq()) {
//			u.getPadre().setIzq(v);
//		} else {
//			u.getPadre().setDer(v);
//		}
//		v.setAntecesor(u.getPadre());
//	}
	
	@Override
	public void eliminarNodo(T objetoAct) throws Exception {
		NodoRedBlack<T> z = buscarNodo(objetoAct);
		NodoRedBlack <T> y;
		NodoRedBlack<T> x;
		if (z == null) {
			throw new Exception(("No se encontro el objeto"));
		}
		if (z.getIzq() == nil || z.getDer() == nil) {
			y = z;
		} else {
			y = z.sucesor();
		}
		if (y.getIzq() != nil) {
			x = y.getIzq();
		} else {
			x = y.getDer();
		}
		if (x != nil) {
			x.setPadre(y.getPadre());
		}
		if (y.getPadre() == nil) {
			raiz = x;
		} else {
			if (y == y.getPadre().getIzq()) {
				y.getPadre().setIzq(x);
			} else {
				y.getPadre().setDer(x);
			}
		}
		if (y != z) {
			z.setElem(y.getElem());
		}
		if (y.getColor() == Color.BLACK) {
			deleteFixup(z);
		}

	}

	@Override
	public void deleteFixup (NodoRedBlack <T> x) {
		while (x != raiz && x.getColor().equals(Color.BLACK)) {
			NodoRedBlack <T> papa = x.getPadre();
			if (x == papa.getIzq()) {
				NodoRedBlack <T> w = papa.getDer();
				if (w.getColor().equals(Color.RED)) {
					w.setColor(Color.BLACK);
					papa.setColor(Color.RED);
					papa.leftRotate(this);
					w = papa.getDer();
				}
				if (w.getIzq().getColor().equals(Color.BLACK) && w.getDer().getColor().equals(Color.BLACK)) {
					w.setColor(Color.RED);
					x = x.getPadre();
				} else {
					if (w.getDer().getColor().equals(Color.BLACK)) {
						w.getIzq().setColor(Color.BLACK);
						w.setColor(Color.RED);
						w.rigthRotate(this);
						w = x.getPadre().getDer();
					}
					w.setColor(x.getPadre().getColor());
					x.getPadre().setColor(Color.BLACK);
					w.getDer().setColor(Color.BLACK);
					x.getPadre().leftRotate(this);
					x = raiz;
				}
			} else {
				NodoRedBlack <T> w = papa.getIzq();
				if (w.getColor().equals(Color.RED)) {
					w.setColor(Color.BLACK);
					papa.setColor(Color.RED);
					papa.rigthRotate(this);
					w = papa.getIzq();
				}
				if (w.getIzq().getColor().equals(Color.BLACK) && w.getDer().getColor().equals(Color.BLACK)) {
					w.setColor(Color.RED);
					x = papa;
				} else {
					if (w.getIzq().getColor().equals(Color.BLACK)) {
						w.getDer().setColor(Color.BLACK);
						w.setColor(Color.RED);
						w.leftRotate(this);
						w = papa.getIzq();
					}
					w.setColor(papa.getColor());
					papa.setColor(Color.BLACK);
					w.getIzq().setColor(Color.BLACK);
					papa.rigthRotate(this);
					x = raiz;
				}
			}
		}
	}

	@Override
	public ArrayList<T> buscarElemento(T objetoAct) throws Exception {
		ArrayList<T> elem;
		NodoRedBlack <T> nodo = buscarNodo(objetoAct);
		if (nodo == null) {
			elem = null;
		} else {
			elem = nodo.getRepetidos();
		}
		return elem;
	}


	
	
}
