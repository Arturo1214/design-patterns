package bo.com.ahosfot.patterns.behavior.visitor.shapes;

import bo.com.ahosfot.patterns.behavior.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
