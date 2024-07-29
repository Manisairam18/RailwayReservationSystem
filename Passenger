package RailwayReservationSystem;
public class Passenger {

    private static int idProvider = 0;
    private int id;
    private String name;
    private int age;
    private char seatPreference;
    private String ticketType;
    private int seatNumber;

    public Passenger(String name, int age, char seatPreference) {
        this.id = ++idProvider;
        this.name = name;
        this.age = age;
        this.seatPreference = seatPreference;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSeatPreference() {
        return seatPreference;
    }

    public void setSeatPreference(char seatPreference) {
        this.seatPreference = seatPreference;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Passenger Ticket id: " + id + "\nPassenger Name: " + name +
                "\nPassenger Age: " + age + "\nPassenger Seat No: " + seatNumber + 
                "\nPassenger Preference: " + seatPreference;
    }
}
