import java.util.*;

public class Show {
    int id;
    Movie movie;
    Screen screen;
    Map<Seat, Boolean> seatAvailability;

    public Show(int id, Movie movie, Screen screen) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.seatAvailability = new HashMap<>();

        for (Seat s : screen.seats) {
            seatAvailability.put(s, true);
        }
    }

    public synchronized boolean bookSeats(List<Seat> seats) {
        for (Seat s : seats) {
            if (!seatAvailability.getOrDefault(s, false)) {
                return false;
            }
        }

        for (Seat s : seats) {
            seatAvailability.put(s, false);
        }

        return true;
    }

    public synchronized void releaseSeats(List<Seat> seats) {
        for (Seat s : seats) {
            seatAvailability.put(s, true);
        }
    }
}