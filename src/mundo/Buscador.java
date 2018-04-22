package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import estructuras.*;

public class Buscador {

	private RedBlack<Objeto> nombre;
	private RedBlack <Objeto> nit;
	private ArbolAvl <Objeto> descripcionCapacidad;
	
	public Buscador () throws FileNotFoundException, IOException, ClassNotFoundException {
		File arch = new File("./data/arbolNom");
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(arch));
		nombre = (RedBlack <Objeto>) is.readObject();
		
		arch = new File("./data/arbolNit");
		is = new ObjectInputStream(new FileInputStream(arch));
		nit = (RedBlack <Objeto>) is.readObject();
		
		arch = new File("./data/arbolDescCap");
		is = new ObjectInputStream(new FileInputStream(arch));
		descripcionCapacidad = (ArbolAvl <Objeto>) is.readObject();
		
	}
}
