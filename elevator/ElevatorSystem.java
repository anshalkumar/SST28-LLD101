import java.util.*;

public class ElevatorSystem {
    List<Elevator> elevators;

    public ElevatorSystem(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void requestElevator(int floor, Direction direction) {
        Elevator best = findElevator();

        if (best != null) {
            best.addInternalRequest(floor);
            System.out.println("Assigned elevator " + best.id);
        }
    }

    private Elevator findElevator() {
        for (Elevator e : elevators) {
            if (e.state != State.MAINTENANCE) return e;
        }
        return null;
    }
}