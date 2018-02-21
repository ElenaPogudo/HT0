public class Run {
    public static void main(String[] args) throws IlluminanceTooMuchException, SpaceUsageTooMuchException {
        Building building = new Building("Здание 1");
        building.addRoom("Комната 1", 40, 1);
        building.addRoom("Комната 2", 5, 2);
        building.getRoom("Комната 1").add(new Bulb(150));
        building.getRoom("Комната 1").add(new Bulb(250));
        building.getRoom("Комната 1").add(new Bulb(350));
        building.getRoom("Комната 1").add(new Item("Стол письменный", 3));
        building.getRoom("Комната 1").add(new Item("Кресло мягкое и пушистое", 7, 10));
        building.getRoom("Комната 1").add(new Item("Кресло мягкое и пушистое2", 10, 14));
        building.describe();



    }
}
