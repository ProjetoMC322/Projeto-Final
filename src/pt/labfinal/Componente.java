package pt.labfinal;

public interface Componente {
	public int getX();
	public int getY();
	public int getZ();
	public void setX(int novo);
	public void setY(int novo);
	public void setZ(int novo);
	public String getNome();
	public void andar();
	public void atirar();
}
