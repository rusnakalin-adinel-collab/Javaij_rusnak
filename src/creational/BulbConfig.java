package creational;

import java.util.Objects;

// Імплементуємо НАШ інтерфейс
public class BulbConfig implements Prototype {
    private String color;
    private int brightness;

    public BulbConfig(String color, int brightness) {
        this.color = color;
        this.brightness = brightness;
    }

    public void setColor(String color) { this.color = color; }
    public void setBrightness(int brightness) { this.brightness = brightness; }

    // Перевизначаємо методи equals та hashCode (як у прикладі викладача)
    // Це хороший тон для порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BulbConfig that = (BulbConfig) o;
        return brightness == that.brightness && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, brightness);
    }

    // Власне сам метод клонування (використовуємо конструктор!)
    @Override
    public Prototype doClone() {
        return new BulbConfig(this.color, this.brightness);
    }

    @Override
    public String toString() {
        return "Колір: " + color + ", Яскравість: " + brightness + "%";
    }
}