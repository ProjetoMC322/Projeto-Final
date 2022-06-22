package pt.labfinal;

public interface Componente {
	public int getX();
	public int getY();
	public int getZ();
	public void setX(int novo);
	public void setY(int novo);
	public void setZ(int novo);
	public String getNome();
	public void andar(String movimento, Mapa mapa);
	public void alteraHP(int valor);
	public void adicionaArma(Arma novo);
	public void adicionaVara(Vara novo);
	public void entra(Bond b);
}
