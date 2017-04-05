package skeleton.P05_Square;

class Rectangle {
    protected int m_width;
    protected int m_height;

    public Rectangle() {
    }

    public Rectangle(int m_width, int m_height) {
        this.setWidth(m_width);
        this.setHeight(m_height);
    }

    protected void setWidth(int width) {
        m_width = width;
    }

    protected void setHeight(int height) {
        m_height = height;
    }

    public int getWidth() {
        return m_width;
    }

    public int getHeight() {
        return m_height;
    }

    public int getArea() {
        return m_width * m_height;
    }
}
