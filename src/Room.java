import java.util.ArrayList;

public class Room {

    public static final int MINLIGHTS = 300;
    public static final int MAXLIGHTS = 4000;
    public static final double MINFREESPASEPERCENT = 0.3;
    public String RoomName;
    public int RoomSquare;
    public int WindowsNumber;
    public int Lights;//общее количество света в комнате
    public int ResultRoomSquare;//количество пустой площади в комнате
    public ArrayList<Bulb> BulbsInfo = new ArrayList<Bulb>();//список лампочек
    public ArrayList<Item> ItemsInfo = new ArrayList<Item>();//список мебели


    public void Room(String RoomName, int RoomSquare, int WindowsNumber) {//конструктор
        setRoomName(RoomName);
        setRoomSquare(RoomSquare);
        setWindowsNumber(WindowsNumber);
        setLights(Lights);
    }

    public void Room() {//конструктор без параметров
        setRoomName("Room");
        setRoomSquare(0);
        setWindowsNumber(0);
    }

    public void setRoomName(String RoomName) {//сеттеры

        this.RoomName = RoomName;
    }

    public void setLights(int Lights) {
        this.Lights = Lights;
    }

    public void setRoomSquare(int RoomSquare) {
        this.RoomSquare = RoomSquare;
    }

    public void setWindowsNumber(int WindowsNumber) {
        this.WindowsNumber = WindowsNumber;
    }

    public String getRoomName() {//геттеры
        return this.RoomName;
    }

    public int getRoomSquare() {
        return this.RoomSquare;
    }

    public int getWindowsNumber() {
        return this.WindowsNumber;
    }

    public void add(Item I)throws SpaceUsageTooMuchException {//добавление Мебели (с исключением занимаемого места)
        ItemsInfo.add(I);
        ResultRoomSquare=RoomSquare;
        for (Item IT : ItemsInfo) {
            if (IT.MaxSquare == 0) {
                ResultRoomSquare = ResultRoomSquare - IT.Square;
            } else {
                ResultRoomSquare = ResultRoomSquare - IT.MaxSquare;
            }
        }
        if ((double)ResultRoomSquare <Room.MINFREESPASEPERCENT*RoomSquare) throw new SpaceUsageTooMuchException("Too many litems");
    }

    public void ShowSquare(Room A) {//вывод на консоль площади
        if (ItemsInfo.size() != 0) {
            System.out.print("  Площадь = " + A.RoomSquare + " м^2( занято ");
            int a = 0;
            int b = 0;
            for (Item I : ItemsInfo) {
                if ((I.MaxSquare == 0) && (I.MinSquare == 0)) {
                    if (I.Square == 0) {
                    } else {
                        a = a + I.Square;
                        b = b + I.Square;
                    }
                } else {
                    a = a + I.MinSquare;
                    b = b + I.MaxSquare;
                }
            }
            int percent = 100 - ((b * 100) / A.RoomSquare);
            System.out.print(a + "-" + b + " м^2, гарантированно свободно:" + (A.RoomSquare - b) + " м^2 или " + percent + "% площади)");
        } else {
            System.out.print("  Площадь = " + A.RoomSquare + " м^2 (свободно 100%)");
        }
    }

    public void ShowItems(Room A) {//вывод на консоль Мебели
        if (ItemsInfo.size() != 0) {
            System.out.print("\n  Мебель: \n");
            for (Item I : ItemsInfo) {
                if ((I.MaxSquare != 0)) {
                    System.out.println("   " + I.ItemName + " (площадь от " + I.MinSquare + " м^2 до " + I.MaxSquare + " м^2)");
                } else {
                    System.out.println("   " + I.ItemName + " (площадь " + I.Square + " м^2)");
                }
            }


        } else {
            System.out.print("\n  Мебели нет\n");
        }
    }

    public void add(Bulb B) throws IlluminanceTooMuchException {//добавление лампочки(с исключением слишком много света)
        BulbsInfo.add(B);
        Lights = WindowsNumber * 700;
        for (Bulb BC : BulbsInfo) {
            Lights += BC.Value;
        }
        if (Lights > Room.MAXLIGHTS) throw new IlluminanceTooMuchException("Too many lights");
    }

    public void ShowBulbs(Room A) {//вывод на консоль инф о лампочках
        A.Lights = A.WindowsNumber * 700;
        System.out.print("Освещенность = ");
        if (BulbsInfo.size() == 0) {
            System.out.print(A.Lights);
            ShowWindows(A);
            System.out.println(")");
        } else if (BulbsInfo.size() == 1) {
            for (Bulb B : BulbsInfo) {
                A.Lights += B.Value;
                System.out.print(A.Lights);
                ShowWindows(A);
                System.out.print(", лампочка " + B.Value + " лк)");
            }
        } else {
            for (Bulb B : BulbsInfo) {
                A.Lights += B.Value;
            }
            System.out.print(A.Lights);
            ShowWindows(A);
            if (BulbsInfo.size() == 2) {
                System.out.print(") лампочки " + BulbsInfo.get(0).Value + " лк и " + BulbsInfo.get(1).Value + " лк)");
                System.out.println();
            } else {
                for (int i = 0; i < BulbsInfo.size() - 2; i++) {
                    System.out.print(" лампочки " + (BulbsInfo.get(i).Value) + " лк");
                    BulbsInfo.remove(i);
                }
                System.out.print(" , " + BulbsInfo.get(0).Value + " лк и " + BulbsInfo.get(1).Value + " лк)");
                System.out.println();
            }
        }
//        if (A.Lights > Room.MAXLIGHTS) {
//            try {
//                throw new IlluminanceTooMuchException("Too Much Illumination");
//            } catch (IlluminanceTooMuchException e) {
//                e.printStackTrace();
//            }
//            return;
//        }
//        if (A.Lights < Room.MINLIGHTS) {
//            try {
//                throw new IlluminanceNotEnoughException("Not enough illumination");
//            } catch (IlluminanceNotEnoughException e) {
//                e.printStackTrace();
//            }
//            return;
//        }
    }

    public void ShowWindows(Room A) {//вывод на консоль инф о окнах
        System.out.print(" (" + A.WindowsNumber);
        switch (A.WindowsNumber) {
            case 0:
                System.out.print(" окон по 700 лк");
                break;
            case 1:
                System.out.print(" окно по 700 лк");
                break;
            case 2:
                System.out.print(" окона по 700 лк");
                break;
            case 3:
                System.out.print(" окона по 700 лк");
                break;
            case 4:
                System.out.print(" окона по 700 лк");
                break;
            default:
                System.out.print(" окон по 700 лк");
                break;

        }
        if (A.Lights != A.WindowsNumber * 700) {
            System.out.print(",");
        }

    }
}

