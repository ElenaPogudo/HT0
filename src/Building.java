import java.util.concurrent.ConcurrentLinkedQueue;

public class Building {

    public String BuildingName;
    public int RoomsNumber;
    public Room A, B;
    public ConcurrentLinkedQueue<Room> BName;  //очередь для хранения комнат


    public void setBuildingName(String BuildingName) {//сеттеры
        this.BuildingName = BuildingName;
    }

    public void setRoomNumber(int RoomNumber) {
        this.RoomsNumber = RoomsNumber;
    }

    public String getBuildingName() {//геттеры
        return this.BuildingName;
    }

    public int getRoomsNumber() {
        return this.RoomsNumber;
    }

    public void describe() {//Выводит информацию о здании
        System.out.println(BuildingName);
        for (int j = 0; j <= BName.size(); j++) {//проходим по очереди
            showRoom(BName.poll());
        }
    }

    public Building(String BuildingName) {//конструктор с параметром имени
        BName = new ConcurrentLinkedQueue<Room>();
        setBuildingName(BuildingName);
    }

    public Building() {//конструктор без параметров
        BName = new ConcurrentLinkedQueue<Room>();
        setBuildingName("Building");
    }

    public Room getRoom(String RoomName) {//геттер комнаты
        for (Room A : BName) {
            if (BName.peek().getRoomName().equals(RoomName)) {
                B = BName.peek();
            }

        }
        return this.B;
    }

    public void addRoom() {//добавление комнаты с разным количеством параметров
        Room room1 = new Room();
        A.setRoomName("room1");
        A.setRoomSquare(0);
        A.setWindowsNumber(0);
        BName.add(room1);
    }

    public void addRoom(String Name) {
        Room A = new Room();
        A.setRoomName(Name);
        A.setRoomSquare(0);
        A.setWindowsNumber(0);
        BName.add(A);
    }

    public void addRoom(String Name, int RoomSquare) {
        Room A = new Room();
        A.setRoomName(Name);
        A.setRoomSquare(RoomSquare);
        A.setWindowsNumber(0);
        BName.add(A);
    }

    public void addRoom(String Name, int RoomSquare, int WindowsNumber) {
        Room A = new Room();
        A.setRoomName(Name);
        A.setRoomSquare(RoomSquare);
        A.setWindowsNumber(WindowsNumber);
        BName.add(A);
    }

    public void showRoom(Room A) {//Вывод информации о комнате

        System.out.print(" " + A.RoomName + "\n  ");
        A.ShowBulbs(A);
        A.ShowSquare(A);
        A.ShowItems(A);
    }
}
