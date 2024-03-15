public class Field {
    private int x, y;
    private Mark mark;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        this.mark = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Field{" +
                "x=" + x +
                ", y=" + y +
                ", mark=" + mark +
                '}';
    }
}
