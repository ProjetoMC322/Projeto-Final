package pt.labfinal;

public class Bond implements Componente{
	
	private static final Bond instance = new Bond ();
	private String nome = "Bond";
	private int x, y, z, hp;
	
	private Bond(){}

    public static Bond getInstance(){
        return instance;
    }
    
    public int getHP() {
		return hp;
	};
    public int getX() {
		return x;
	};
	public int getY() {
		return y;
	};
	public int getZ() {
		return z;
	};
	public void setX(int novo) {
		this.x = novo;
	};
	public void setY(int novo) {
		this.y = novo;
	}
	public void setZ(int novo) {
		this.z = novo;
	};
	
	public String getNome() {
		return nome;
	}
	
}
