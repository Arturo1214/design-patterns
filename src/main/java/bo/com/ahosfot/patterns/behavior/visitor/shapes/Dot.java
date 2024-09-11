package bo.com.ahosfot.patterns.behavior.visitor.shapes;

import bo.com.ahosfot.patterns.behavior.visitor.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dot implements Shape {

    private int id;
    private int x;
    private int y;

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitDot(this);
    }
}
