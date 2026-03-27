import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {

        EconomyRoom economy = new EconomyRoom(1, 2, 50);
        StandartRoom standard = new StandartRoom(2, 3, 100);
        LuxRoom lux = new LuxRoom(3, 4, 200);
        UltraLuxRoom ultra = new UltraLuxRoom(4, 5, 500);

        BasicRoomService<Room> service = new BasicRoomService<>();

        service.clean(economy);
        service.reserve(economy);
        service.free(economy);

        service.reserve(economy);
        // service.reserve(economy); // вызывает Exception

        service.reserve(standard);

        LuxRoomService<LuxRoom> luxService = new LuxRoomServiceImpl<>();

        luxService.reserve(lux);
        luxService.foodDelivery(lux);

        luxService.foodDelivery(ultra);
    }
}