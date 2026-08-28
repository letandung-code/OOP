
public class ToaDo {
	private String Ten;
	private int x;
	private int y;
	
	//khong tham so
	public ToaDo() {
		this.Ten = "";
		this.x = 0;
		this.y = 0;
	}
	
	//co tham so day du
	public ToaDo(String Ten, int x, int y) {
		this.Ten = Ten;
		this.x = x;
		this.y = y;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d,%d)",Ten,x,y);
	}
}
