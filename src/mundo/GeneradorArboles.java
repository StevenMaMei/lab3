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
	
	
	
	public static void main(String[] args) throws Exception {
//		File arch = new File ("./data/arbolNom");
//		RedBlack<Objeto> nom = new RedBlack<>();
//		int i = 1;
//		File leer = new File(RUT + "/" + i + ".txt");
//		while (leer.exists()) {
//			BufferedReader lector = new BufferedReader(new FileReader(leer));
//			String [] dats = lector.readLine().split("\t");
//			String at;
//			if (dats.length == 9) {
//				at = dats[0] + ", " + dats [1];
//			} else {
//				at = dats [0];
//			}
//			System.out.println(i + ", " + at);
//			Objeto obj = new Objeto(at, leer);
//			nom.insertarNodo(obj);
//			leer = new File(RUT +"/" + ++i + ".txt");
//		}
//		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(arch));
//		os.writeObject(nom);
	}

}
