import java.util.*;

public class BookingService {
    List<Theatre> theatres = new ArrayList<>();
    List<Show> shows = Collections.synchronizedList(new ArrayList<>());
    int bookingCounter = 1;

    // API 1
    public List<Theatre> showTheatres(String city) {
        List<Theatre> res = new ArrayList<>();
        for (Theatre t : theatres) {
            if (t.city.equals(city)) res.add(t);
        }
        return res;
    }

    // API 2
    public List<Movie> showMovies(String city) {
        List<Movie> res = new ArrayList<>();

        for (Show s : shows) {
            if (s.screen != null) {
                res.add(s.movie);
            }
        }
        return res;
    }

    // API 3
    public Booking bookTickets(User user, Show show, List<Seat> seats) {
        boolean success = show.bookSeats(seats);

        if (!success) {
            System.out.println("Seats not available");
            return null;
        }

        Booking booking = new Booking(bookingCounter++, user, show, seats);
        System.out.println("Booking successful");
        return booking;
    }

    // API 4
    public void cancelBooking(Booking booking) {
        booking.status = "CANCELLED";
        booking.show.releaseSeats(booking.seats);

        Payment payment = new Payment(1, 100); // dummy
        payment.refund();
    }

    // Admin adds show (concurrency safe)
    public synchronized void addShow(Show show) {
        shows.add(show);
    }
}