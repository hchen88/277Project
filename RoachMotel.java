package patternsProject;

import java.util.ArrayList;

public class RoachMotel { //simple locking

	private RoachMotel() {}
	
	private static RoachMotel uniqueInstance;
	
	public static RoachMotel getInstance() {
		
		synchronized(RoachMotel.class) {
			if(uniqueInstance == null) {
				uniqueInstance = new RoachMotel();
			}
		}
		return uniqueInstance;
	}
	
	protected ArrayList<Integer> roomNumAv = new ArrayList<Integer>();
	protected ArrayList<MotelRoom> rooms = new ArrayList<MotelRoom>();
	
	public void createRooms() {
		roomNumAv.add(101);
		roomNumAv.add(102);
		roomNumAv.add(103);
		roomNumAv.add(104);
		roomNumAv.add(105);
	}
	
	public void checkIn(RoachColony colony, String roomType, ArrayList<String> amenities) {
		int roomNum = roomNumAv.get(0);
		rooms.add(new MotelRoom(colony, roomType, amenities, roomNum, costPerNight));
		roomNumAv.remove(0);
		//cost per night (decorator for amenities)
		System.out.println("Amenities: " + amenities + "\nCost per night: ");
	}
	
	public String toString() {
		/*
		motel: {}available: [101, 102, 103, 104, 105]
		available Rooms: [101, 102, 103, 104, 105]
		in set amenities: [foodbar, spa, refillbar, shower]
		Suite, FoodBar, Spa, RefillBar, Shower 160.0
		 */
		return "Available Rooms: " + roomNumAv;
	}
	
}
