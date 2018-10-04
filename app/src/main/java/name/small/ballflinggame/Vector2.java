package name.small.ballflinggame;

public class Vector2<E> {
    public E x;
    public E y;

    public Vector2(E x, E y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString () {
        try {
            String x = this.x.toString();
            String y = this.y.toString();

            return String.format("x:%s, y:%s", x, y);
        } catch (Exception e) {
            return "Vector type is not Double";
        }
    }
}
