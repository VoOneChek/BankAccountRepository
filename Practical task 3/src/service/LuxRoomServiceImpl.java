package service;

import model.LuxRoom;

public class LuxRoomServiceImpl<T extends LuxRoom>
        extends BasicRoomService<T>
        implements LuxRoomService<T> {

    @Override
    public void foodDelivery(T room) {
        System.out.println("Доставка еды в номер: " + room);
    }
}