package model;

public abstract class Room {

    protected int number;
    protected int maxPeople;
    protected int price;
    protected boolean isReserved;

    public Room(int number, int maxPeople, int price) {
        this.number = number;
        this.maxPeople = maxPeople;
        this.price = price;
        this.isReserved = false;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Room #" + number +
                ", maxPeople=" + maxPeople +
                ", price=" + price +
                ", reserved=" + isReserved;
    }
}