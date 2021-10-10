package entities;

public class Rectangle {
  public double width;
  public double height;

  public double calcArea() {
    return this.height * this.width;
  }

  public double calcPerimeter() {
    return (this.height * this.width) * 2;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getWidth() {
    return width;
  }
}
