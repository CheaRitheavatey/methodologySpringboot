public interface Printable extends Drawable {
    void print();
    default String getPaerSize() {return "A4";}

}
