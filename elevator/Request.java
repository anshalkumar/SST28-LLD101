public class Request {
    int floor;
    Direction direction; // null for internal

    public Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}