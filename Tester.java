package patternsProject;

public class Tester {

	public static void main(String[] args) {
		RoachMotel rm = RoachMotel.getInstance();
		rm.createRooms();
		System.out.println(rm);
	}
	
}
