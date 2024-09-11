package bo.com.ahosfot.patterns.behavior.visitor.shapes;

import bo.com.ahosfot.patterns.behavior.visitor.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle implements Shape {

    private int id;
    private int x;
    private int y;
    private int width;
    private int height;

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitRectangle(this);
    }
}
