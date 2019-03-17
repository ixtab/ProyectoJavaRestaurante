package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MENU database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idmenu;

	@Column(insertable=false, updatable=false)
	private int idrestaurante;

	private String primero;

	private String segundo;

	public Menu() {
	}

	public int getIdmenu() {
		return this.idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public int getIdrestaurante() {
		return this.idrestaurante;
	}

	public void setIdrestaurante(int idrestaurante) {
		this.idrestaurante = idrestaurante;
	}

	public String getPrimero() {
		return this.primero;
	}

	public void setPrimero(String primero) {
		this.primero = primero;
	}

	public String getSegundo() {
		return this.segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

}