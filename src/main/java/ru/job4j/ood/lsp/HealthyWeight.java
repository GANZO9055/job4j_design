package ru.job4j.ood.lsp;


/*
Происходит нарушение LSP, т.к. предусловие изменяется,
из-за чего площадь не будет соответствовать ожиданиям.
 */
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

class TestClass {
    public static void main(String[] args) {
        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(10);
        if (square.getArea() != 50) {
            throw new RuntimeException("Происходит нарушение LSP, площадь должна быть 50");
        }
    }
}
