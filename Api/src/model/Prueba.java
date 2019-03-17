package model;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class Prueba {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Código Postal: ");
		String cp = scn.nextLine();
		scn.close();
		
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("App");
		EntityManager em = factoria.createEntityManager();
		TypedQuery<Restaurante> query = em.createQuery("SELECT r FROM Restaurante r WHERE r.codigopostal = " + cp, Restaurante.class);

		List<Restaurante> restaurante = query.getResultList();

		if (restaurante.size()>0) {
			for (Restaurante r : restaurante) {
				System.out.println(r.getNombre() + " - " + r.getDireccion() +
				" - " + r.getCodigopostal() + " - " + r.getPreciomenu());
				System.out.println("Primeros: ");
				for (Menu m : r.getMenus(r.getIdrestaurante())) {
					
					System.out.println("\t" + m.getPrimero());
				}
				System.out.println("Segundos: ");
				for (Menu m : r.getMenus(r.getIdrestaurante())) {
					
					System.out.println("\t" + m.getSegundo());
				}
			}
		} 
		else {
			System.out.println("No hay restaurantes en ese Código postal");
		}
	
	}

}
