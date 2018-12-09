package game.worlds;

public class RoomGenerator {

	private Room[] rooms;

	public RoomGenerator() {
		rooms = new Room[1];

		Room room = new Room();
		rooms[0] = room;
	}

	public Room[] getRooms() {
		return rooms;
	}
}
