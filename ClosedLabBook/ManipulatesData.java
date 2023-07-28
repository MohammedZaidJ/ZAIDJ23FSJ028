package ClosedLabBook;

public class ManipulatesData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ProtectedData pd=new ProtectedData();
		Manipulate pd = new Manipulate();
		System.out.println("Before manipulating data");
		System.out.println(pd);
		pd.setSize(15);
		System.out.println("After manipulating data");
		System.out.println(pd.getSize());
		
	}

}
class ProtectedData{
	 protected int size=10;
}
class Manipulate extends ProtectedData{
	void setSize(int size) {
		this.size=size;
	}
	
	int getSize() {
		return size;
	}
}

