package mundo;

import java.io.File;

public class Objeto implements Comparable{

	private String atributo;
	private File archivo;

	public Objeto (String atributo, String ruta) {
		this.atributo = atributo;
		archivo = new File(ruta);
	}
	
	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	@Override
	public int compareTo(Object o) {
		return atributo.compareTo(((Objeto)o).atributo);
	}
	
}
