package RailwayReservationSystem;
import java.util.*;

public class TicketBooking {

    private static final int BERTH_LIMIT = 6 / 3;
    private static final int RAC_LIMIT = 1;
    private static final int WAITING_LIST_LIMIT = 1;

    private static int upperSeatNumber = 1;
    private static int middleSeatNumber = 2;
    private static int lowerSeatNumber = 3;

    static List<Passenger> confirmedList = new ArrayList<>();
    static List<Passenger> upperList = new ArrayList<>();
    static List<Passenger> middleList = new ArrayList<>();
    static List<Passenger> lowerList = new ArrayList<>();

    static Queue<Passenger> racQueue = new LinkedList<>();
    static Queue<Passenger> waitingQueue = new LinkedList<>();

    public static void bookTicket(Passenger p) {
        if (upperList.size() == BERTH_LIMIT && lowerList.size() == BERTH_LIMIT && middleList.size() == BERTH_LIMIT) {
            if (updateRacQueue(p)) {
                System.out.println("Added to RAC\nYour ticket id is " + p.getId());
            } else if (updateWaitingQueue(p)) {
                System.out.println("Added to Waiting List\nYour ticket id is " + p.getId());
            } else {
                System.out.println("Tickets not available");
            }
        } else if (checkAvailability(p)) {
            System.out.println("Booking confirmed\nYour ticket id is " + p.getId());
            p.setTicketType("berth");
            confirmedList.add(p);
        } else {
            System.out.println(p.getSeatPreference() + " is not available");
            availableList();
        }
    }

    private static boolean updateWaitingQueue(Passenger p) {
        if (waitingQueue.size() < WAITING_LIST_LIMIT) {
            p.setTicketType("waitingList");
            waitingQueue.add(p);
            return true;
        }
        return false;
    }

    private static boolean updateRacQueue(Passenger p) {
        if (racQueue.size() < RAC_LIMIT) {
            p.setTicketType("rac");
            racQueue.add(p);
            return true;
        }
        return false;
    }

    private static void availableList() {
        System.out.println("Check out the number of seats available:");
        System.out.println("Upper Berth: " + (BERTH_LIMIT - upperList.size()));
        System.out.println("Middle Berth: " + (BERTH_LIMIT - middleList.size()));
        System.out.println("Lower Berth: " + (BERTH_LIMIT - lowerList.size()));
    }

    private static boolean checkAvailability(Passenger p) {
        Map<Integer, Character> map = TicketCanceling.getSeatNumberWithBerth();

        if (p.getSeatPreference() == 'U' && upperList.size() < BERTH_LIMIT) {
            assignSeat(p, map, upperList, 'U');
            return true;
        } else if (p.getSeatPreference() == 'M' && middleList.size() < BERTH_LIMIT) {
            assignSeat(p, map, middleList, 'M');
            return true;
        } else if (p.getSeatPreference() == 'L' && lowerList.size() < BERTH_LIMIT) {
            assignSeat(p, map, lowerList, 'L');
            return true;
        }
        return false;
    }

    private static void assignSeat(Passenger p, Map<Integer, Character> map, List<Passenger> list, char preference) {
        if (!map.isEmpty()) {
            int seatNumber = checkForPreferenceAvailability(map, preference);
            p.setSeatNumber(seatNumber);
            map.remove(seatNumber);
        } else {
            int seatNumber = preference == 'U' ? upperSeatNumber : preference == 'M' ? middleSeatNumber : lowerSeatNumber;
            p.setSeatNumber(seatNumber);
            if (preference == 'U') upperSeatNumber += 3;
            if (preference == 'M') middleSeatNumber += 3;
            if (preference == 'L') lowerSeatNumber += 3;
        }
        list.add(p);
    }

    public static int checkForPreferenceAvailability(Map<Integer, Character> map, char preference) {
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            if (preference == entry.getValue()) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void displayConfirmed() {
        displayList("Confirmed", confirmedList);
    }

    public static void displayRAC() {
        displayQueue("RAC", racQueue);
    }

    public static void displayWaiting() {
        displayQueue("Waiting", waitingQueue);
    }

    private static void displayList(String listName, List<Passenger> list) {
        System.out.println(listName + " List:");
        System.out.println("-------------------------");
        for (Passenger p : list) {
            System.out.println(p);
            System.out.println("-------------------------");
        }
    }

    private static void displayQueue(String queueName, Queue<Passenger> queue) {
        System.out.println(queueName + " Queue:");
        System.out.println("-------------------------");
        for (Passenger p : queue) {
            System.out.println(p);
            System.out.println("-------------------------");
        }
    }
}
