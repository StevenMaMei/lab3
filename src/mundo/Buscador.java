package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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
	
	public String [][] buscarNombreIps (String nom) throws Exception{
		String [][] encontrados;
		Objeto obj = new Objeto(nom, null);
		ArrayList <Objeto> enc = nombre.buscarElemento(obj);
		int tam = enc.size();
		encontrados = new String [tam][8];
		for (int i = 0; i < enc.size(); i++) {
			Objeto ob = enc.get(i);
			BufferedReader lector = new BufferedReader(new FileReader(ob.getArchivo()));
			String [] fila = lector.readLine().split("\t");
			if (fila.length == 8) {
				encontrados[i] = fila;
			} else {
				encontrados [i][0] = fila [0] + ", " + fila [1];
				for (int j = 1; j < 8; j++) {
					encontrados[i][j] = fila[j+1];
				}
			}
		}
		
		return encontrados;
	}
	
	public String [][] buscarNitIps (String nit) throws Exception{
		String [][] encontrados;
		Objeto obj = new Objeto(nit, null);
		ArrayList <Objeto> enc = this.nit.buscarElemento(obj);
		int tam = enc.size();
		encontrados = new String [tam][8];
		for (int i = 0; i < enc.size(); i++) {
			Objeto ob = enc.get(i);
			BufferedReader lector = new BufferedReader(new FileReader(ob.getArchivo()));
			String [] fila = lector.readLine().split("\t");
			if (fila.length == 8) {
				encontrados[i] = fila;
			} else {
				encontrados [i][0] = fila [0] + ", " + fila [1];
				for (int j = 1; j < 8; j++) {
					encontrados[i][j] = fila[j+1];
				}
			}
		}
		
		return encontrados;
	}
	
	public String [][] buscarDescripcionCapacidad (String descripcion) throws Exception{
		String [][] encontrados;
		Objeto obj = new Objeto(descripcion, null);
		ArrayList <Objeto> enc = descripcionCapacidad.buscarElemento(obj);
		int tam = enc.size();
		encontrados = new String [tam][8];
		for (int i = 0; i < enc.size(); i++) {
			Objeto ob = enc.get(i);
			BufferedReader lector = new BufferedReader(new FileReader(ob.getArchivo()));
			String [] fila = lector.readLine().split("\t");
			if (fila.length == 8) {
				encontrados[i] = fila;
			} else {
				encontrados [i][0] = fila [0] + ", " + fila [1];
				for (int j = 1; j < 8; j++) {
					encontrados[i][j] = fila[j+1];
				}
			}
		}
		return encontrados;
	}
	
	public String [][] buscarNaturaleza (String nat) throws Exception{
		String [][] encontrados;
		int i = 1;
		ArrayList <String[]> arr = new ArrayList <>();
		File arch = new File ("./baseDatos/tabla/" + i + ".txt");
		while (arch.exists()) {
			BufferedReader lector = new BufferedReader(new FileReader(arch));
			String [] fila = lector.readLine().split("\t");
			if (nat.equals(fila[fila.length - 6])) {
				arr.add(fila);
			}
			arch = new File ("./baseDatos/tabla/" + ++i + ".txt");
		}
		encontrados = new String [arr.size()][8];
		for (String[] fila : arr) {
			if (fila.length == 8) {
				encontrados[i] = fila;
			} else {
				encontrados [i][0] = fila [0] + ", " + fila [1];
				for (int j = 1; j < 8; j++) {
					encontrados[i][j] = fila[j+1];
				}
			}
		}
		return encontrados;
	}
	
	public String [][] buscarDigitoVerificacion (String digito) throws Exception{
		String [][] encontrados;
		int i = 1;
		ArrayList <String[]> arr = new ArrayList <>();
		File arch = new File ("./baseDatos/tabla/" + i + ".txt");
		while (arch.exists()) {
			BufferedReader lector = new BufferedReader(new FileReader(arch));
			String [] fila = lector.readLine().split("\t");
			if (digito.equals(fila[fila.length - 5])) {
				arr.add(fila);
			}
			arch = new File ("./baseDatos/tabla/" + ++i + ".txt");
		}
		encontrados = new String [arr.size()][8];
		for (String[] fila : arr) {
			if (fila.length == 8) {
				encontrados[i] = fila;
			} else {
				encontrados [i][0] = fila [0] + ", " + fila [1];
				for (int j = 1; j < 8; j++) {
					encontrados[i][j] = fila[j+1];
				}
			}
		}
		return encontrados;
	}
	
	public String [][] buscarNivelAtencion (String nivel) throws Exception{
		String [][] encontrados;
		int i = 1;
		ArrayList <String[]> arr = new ArrayList <>();
		File arch = new File ("./baseDatos/tabla/" + i + ".txt");
		while (arch.exists()) {
			BufferedReader lector = new BufferedReader(new FileReader(arch));
			String [] fila = lector.readLine().split("\t");
			if (nivel.equals(fila[fila.length - 4])) {
				arr.add(fila);
			}
			arch = new File ("./baseDatos/tabla/" + ++i + ".txt");
		}
		encontrados = new String [arr.size()][8];
		for (String[] fila : arr) {
			if (fila.length == 8) {
				encontrados[i] = fila;
			} else {
				encontrados [i][0] = fila [0] + ", " + fila [1];
				for (int j = 1; j < 8; j++) {
					encontrados[i][j] = fila[j+1];
				}
			}
		}
		return encontrados;
	}
	
	public String [][] buscarGrupoCapacidad (String grupo) throws Exception{
		String [][] encontrados;
		int i = 1;
		ArrayList <String[]> arr = new ArrayList <>();
		File arch = new File ("./baseDatos/tabla/" + i + ".txt");
		while (arch.exists()) {
			BufferedReader lector = new BufferedReader(new FileReader(arch));
			String [] fila = lector.readLine().split("\t");
			if (grupo.equals(fila[fila.length - 3])) {
				arr.add(fila);
			}
			arch = new File ("./baseDatos/tabla/" + ++i + ".txt");
		}
		encontrados = new String [arr.size()][8];
		for (String[] fila : arr) {
			if (fila.length == 8) {
				encontrados[i] = fila;
			} else {
				encontrados [i][0] = fila [0] + ", " + fila [1];
				for (int j = 1; j < 8; j++) {
					encontrados[i][j] = fila[j+1];
				}
			}
		}
		return encontrados;
	}
	
	public String [][] buscarCantidadCapacidad (String capacidad) throws Exception{
		String [][] encontrados;
		int i = 1;
		ArrayList <String[]> arr = new ArrayList <>();
		File arch = new File ("./baseDatos/tabla/" + i + ".txt");
		while (arch.exists()) {
			BufferedReader lector = new BufferedReader(new FileReader(arch));
			String [] fila = lector.readLine().split("\t");
			if (capacidad.equals(fila[fila.length - 1])) {
				arr.add(fila);
			}
			arch = new File ("./baseDatos/tabla/" + ++i + ".txt");
		}
		encontrados = new String [arr.size()][8];
		for (String[] fila : arr) {
			if (fila.length == 8) {
				encontrados[i] = fila;
			} else {
				encontrados [i][0] = fila [0] + ", " + fila [1];
				for (int j = 1; j < 8; j++) {
					encontrados[i][j] = fila[j+1];
				}
			}
		}
		return encontrados;
	}
	
}
