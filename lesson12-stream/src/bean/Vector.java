package bean;

public class Vector {

	private int x;
	private int y;
	private int z;
	private int t;

	public Vector() {
	}

	public Vector(int x) {
		this.x = x;
	}
	
	public Vector(String x) {
		System.out.println("...");
	}

	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Vector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector(int x, int y, int z, int t) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getT() {
		return t;
	}

	@Override
	public String toString() {
		return "Vector(" + x + "," + y + "," + "," + z + "," + t + ")";
	}

}
