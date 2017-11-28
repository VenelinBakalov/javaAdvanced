package skeleton.P03_GraphicEditor;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();
        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(shape);
        Shape rect = new Rectangle();
        editor.drawShape(rect);
        Shape square = new Square();
        editor.drawShape(square);
    }
}
