package gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import parser.Parser;
import parser.Scanner;
import nodes.Node;

@SuppressWarnings("serial")
public class TreeMain extends JFrame {
    public TreeMain(Node ast) {
        super("Demo Expression Tree");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ExpressionTreeModel model = new ExpressionTreeModel(ast);
        ExprTreePanel treePanel = new ExprTreePanel(ast, model, true);
        getContentPane().add(treePanel, BorderLayout.WEST);
        pack();
        setResizable(false);
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Aufruf: java ExprTree " +
                "\"arithmetischer Ausdruck\"");
            System.exit(1);
        }
        Node ast = new Parser(new Scanner(args[0])).parse();
        new TreeMain(ast).setVisible(true);
    }
}
