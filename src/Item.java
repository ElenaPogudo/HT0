public class Item {

    public String ItemName;
    public int Square;
    public int MaxSquare;
    public int MinSquare;

    public void setItemName(String ItemName) {//сеттер
        this.ItemName = ItemName;
    }
    public void setSquare(int Square) {
        this.Square = Square;
    }
    public void setMaxSquare(int MaxSquare) {
        this.MaxSquare = MaxSquare;
    }
    public void setMinSquare(int MinSquare) {
        this.MinSquare = MinSquare;
    }

    public String getItemName() {//геттер
        return this.ItemName;
    }
    public int getSquare() {
        if (MaxSquare>MinSquare){
            Square=MaxSquare;
        }
        return this.Square;
    }
    public int getMaxSquare() {
        return this.MaxSquare;
    }
    public int getMinSquare() {
        return this.MinSquare;
    }

    public Item() {//конструкторы
        setItemName("Something");
        setSquare(0);
    }
    public Item(String Name) {
        setItemName(Name);
        setSquare(0);
    }
    public Item(String Name, int Square) {
        setItemName(Name);
        setSquare(Square);
    }
    public Item(String Name, int MinSquare, int MaxSquare) {
        setItemName(Name);
        setMinSquare(MinSquare);
        setMaxSquare(MaxSquare);
    }
}
