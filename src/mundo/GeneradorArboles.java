package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import estructuras.ArbolAvl;
import estructuras.RedBlack;

public class GeneradorArboles implements Serializable{

	final static String RUT = "./baseDatos/Tabla";
	
	
	
	public static void main(String[] args) throws IOException {
		File arch = new File ("./data/arbolDescCap");
		ArbolAvl<Objeto> nom = new ArbolAvl<>();
		int i = 1;
		File leer = new File(RUT + "/" + i + ".txt");
		while (leer.exists()) {
			BufferedReader lector = new BufferedReader(new FileReader(leer));
			String [] dats = lector.readLine().split("\t");
			String at = dats[6];
			System.out.println(at);
			Objeto obj = new Objeto(at, leer);
			nom.insertar(obj);
			leer = new File(RUT +"/" + ++i + ".txt");
		}
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(arch));
			os.writeObject(nom);
		} catch (Exception e) {
			
		}

	}

}
