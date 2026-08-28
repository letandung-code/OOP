
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToaDo td1 = new ToaDo();
		td1.setTen("Dung");
		td1.setX(3);
		td1.setY(5);
		
		ToaDo td2 = new ToaDo("Le", 7, 2);
		System.out.println("Toa do 1: " + td1);
		System.out.println("Toa do 2: " + td2);
	}

}
