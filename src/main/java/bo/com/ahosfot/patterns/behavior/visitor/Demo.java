package bo.com.ahosfot.patterns.behavior.visitor;

import bo.com.ahosfot.patterns.behavior.visitor.shapes.*;
import bo.com.ahosfot.patterns.behavior.visitor.visitor.XmlExportVisitor;

public class Demo {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.addShape(dot);
        compoundShape.addShape(circle);
        compoundShape.addShape(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.addShape(dot);
        compoundShape.addShape(c);

        export(circle, compoundShape);
    }

    private static void export(Shape... shapes) {
        XmlExportVisitor exportVisitor = new XmlExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}
