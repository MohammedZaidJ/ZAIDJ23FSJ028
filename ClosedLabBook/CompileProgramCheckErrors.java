package ClosedLabBook;

public class CompileProgramCheckErrors {
	public static void main(String[] args) {
		dervied d = new dervied();
		d.useD();
	}
}
class base {
	String Method() {
		return "Wow";
	}
}
class dervied{
	public void useD() {
		base z = new base();
		System.out.println("base says, " + z.Method());
	}
}
