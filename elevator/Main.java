import java.util.*;

public class Main {
    public static void main(String[] args) {

        Elevator e1 = new Elevator(1, 700);
        Elevator e2 = new Elevator(2, 600);

        ElevatorSystem system = new ElevatorSystem(Arrays.asList(e1, e2));

        system.requestElevator(5, Direction.UP);

        e1.addInternalRequest(10);

        e1.addWeight(750); 

        e1.move();
        e1.move();

        e1.emergencyStop();

        e2.setMaintenance(true);
    }
}