package bo.com.ahosfot.patterns.behavior.visitor.visitor;

import bo.com.ahosfot.patterns.behavior.visitor.shapes.Circle;
import bo.com.ahosfot.patterns.behavior.visitor.shapes.CompoundShape;
import bo.com.ahosfot.patterns.behavior.visitor.shapes.Dot;
import bo.com.ahosfot.patterns.behavior.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);
    String visitCircle(Circle circle);
    String visitRectangle(Rectangle rectangle);
    String visitCompoundGraphic(CompoundShape compoundShape);
}
