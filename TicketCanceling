package RailwayReservationSystem;

import java.util.*;

public class TicketCanceling extends TicketBooking {

    // Only for RAC
    private static char preferenceTracker = '\0';
    private static int canceledSeatNumber = 0;

    private static Map<Integer, Character> seatNumberWithBerth = new HashMap<>();

    public static String cancelTicket111(int id) {
        Passenger passenger = findPassenger(id);
        if (passenger != null) {
            cancel(passenger);
            return "Success";
        }
        return "Invalid Id";
    }

    private static Passenger findPassenger(int id) {
        for (Passenger p : confirmedList) {
            if (p.getId() == id) return p;
        }
        for (Passenger p : racQueue) {
            if (p.getId() == id) return p;
        }
        for (Passenger p : waitingQueue) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private static void cancel(Passenger p) {
        if (p.getTicketType().equals("berth")) {
            // Only for RAC
            preferenceTracker = p.getSeatPreference();
            canceledSeatNumber = p.getSeatNumber();
            // Map for reference in future
            seatNumberWithBerth.put(canceledSeatNumber, preferenceTracker);

            deleteFromAllLists(p);
            addRacToBerth(racQueue.poll());
            addWaitingToRac(waitingQueue.poll());
        } else if (p.getTicketType().equals("rac")) {
            racQueue.remove(p);
            addWaitingToRac(waitingQueue.poll());
        } else {
            waitingQueue.remove(p);
        }
    }

    private static void addWaitingToRac(Passenger p) {
        if (p != null) {
            p.setTicketType("rac");
            racQueue.add(p);
        }
    }

    private static void addRacToBerth(Passenger p) {
        if (p != null) {
            p.setSeatPreference(preferenceTracker);
            p.setSeatNumber(canceledSeatNumber);
            p.setTicketType("berth");

            switch (preferenceTracker) {
                case 'U':
                    upperList.add(p);
                    break;
                case 'M':
                    middleList.add(p);
                    break;
                case 'L':
                    lowerList.add(p);
                    break;
            }

            confirmedList.add(p);
            seatNumberWithBerth.remove(canceledSeatNumber);
            preferenceTracker = '\0';
            canceledSeatNumber = 0;
        }
    }

    private static void deleteFromAllLists(Passenger p) {
        confirmedList.remove(p);
        upperList.remove(p);
        middleList.remove(p);
        lowerList.remove(p);
    }

    public static Map<Integer, Character> getSeatNumberWithBerth() {
        return seatNumberWithBerth;
    }
}
