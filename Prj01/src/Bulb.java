public class Bulb {

    public int Value;

    public void setValue(int Value) {//сеттер
        this.Value = Value;
    }

    public int getValue() {//геттер
        return this.Value;
    }


    public Bulb(int Value) {// конструктор
        setValue(Value);
    }

    public Bulb() {// конструктор без параметров
        setValue(0);
    }

}
