package bo.com.ahosfot.patterns.structural.flyweight.forest;

import bo.com.ahosfot.patterns.structural.flyweight.trees.Tree;
import bo.com.ahosfot.patterns.structural.flyweight.trees.TreeFactory;
import bo.com.ahosfot.patterns.structural.flyweight.trees.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType treeType = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, treeType);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics g) {
        for (Tree tree : trees) {
            tree.draw(g);
        }
    }
}
