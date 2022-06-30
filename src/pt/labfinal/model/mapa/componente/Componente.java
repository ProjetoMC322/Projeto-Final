package pt.labfinal.model.mapa.componente;

import pt.labfinal.model.item.arma.Arma;
import pt.labfinal.model.item.vara.Vara;
import pt.labfinal.model.mapa.Mapa;

public abstract class Componente{
	protected int x, y, z;
	protected String nome, imagem; 
	
	Componente(String nome, int x, int y, int z, String imagem){
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.z = z;
		this.imagem = imagem;
	}
	 
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getZ() {
		return this.z;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getImage() {
		return imagem;
	}
	
	public int getHPMax() {
		return 0;
	}
	
	public int getHP() {
		return 0;
	}
	
	public void setX(int novo) {
		this.x = novo;
	}
	
	public void setY(int novo) {
		this.y = novo;
	}
	
	public void setZ(int novo) {
		this.z = novo;
	}
	
	public void andar(String movimento, Mapa mapa) {
		return;
	}
	
	public void alteraHP(int valor) {
		return;
	}
	
	public void adicionaArma(Arma novo) {
		return;
	}
	
	public void adicionaVara(Vara novo) {
		return;
	}
	
	public void entra(Bond b) {
		return;
	}
}