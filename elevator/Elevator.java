import java.util.*;

public class Elevator {
    int id;
    int currentFloor;
    State state;
    int capacity;
    int currentWeight;

    Queue<Integer> requests;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 0;
        this.state = State.IDLE;
        this.currentWeight = 0;
        this.requests = new LinkedList<>();
    }

    public void addInternalRequest(int floor) {
        requests.add(floor);
    }

    public void addWeight(int w) {
        currentWeight += w;

        if (currentWeight > capacity) {
            System.out.println("Overweight! Elevator " + id + " stopped.");
            openDoor();
            alarm();
            state = State.IDLE;
        }
    }

    public void move() {
        if (state == State.MAINTENANCE) return;

        if (requests.isEmpty()) {
            state = State.IDLE;
            return;
        }

        int target = requests.poll();

        if (target > currentFloor) state = State.UP;
        else if (target < currentFloor) state = State.DOWN;

        currentFloor = target;

        System.out.println("Elevator " + id + " reached floor " + currentFloor);
        openDoor();
    }

    public void openDoor() {
        System.out.println("Door opened at floor " + currentFloor);
    }

    public void closeDoor() {
        System.out.println("Door closed");
    }

    public void alarm() {
        System.out.println("ALARM in elevator " + id);
    }

    public void emergencyStop() {
        state = State.IDLE;
        alarm();
    }

    public void setMaintenance(boolean flag) {
        if (flag) state = State.MAINTENANCE;
        else state = State.IDLE;
    }
}