package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;

import nodes.Node;

@SuppressWarnings("serial")
public class ExprTreePanel extends JPanel implements TreeExpansionListener {
    private final ExpressionTreeModel treeModel;
            
    public ExprTreePanel(Node root, ExpressionTreeModel t, boolean post) {
        super(new BorderLayout());
        //treeModel = new ExpressionTreeModel(root);
        treeModel = t;
        JTree tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        tree.collapseRow(0);
        tree.addTreeExpansionListener(this);
        tree.setPreferredSize(new Dimension(400,300));
        JTextField messageField = new JTextField(
                post ? root.postOrder() : Node.preOrder(root));
        messageField.setEditable(false);
        messageField.setBackground(Color.white);
        messageField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JPanel outputPanel = new JPanel(/*new FlowLayout(FlowLayout.LEFT)*/);
        JLabel labelMessage = new JLabel(
                (post ? "Postorder" : "Preorder") + " Ausgabe");
        outputPanel.add(labelMessage);
        outputPanel.add(messageField);
        
        add(tree, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.SOUTH);
    }
        
    public void treeExpanded(TreeExpansionEvent tee) {
        setExpandedModeTo(tee, true);
    }

    public void treeCollapsed(TreeExpansionEvent tee) {
        setExpandedModeTo(tee, false);
    }

    private void setExpandedModeTo(TreeExpansionEvent tee, boolean value) {
        ((Node)tee.getPath().getLastPathComponent()).setExpanded(value);
        treeModel.refresh(tee);
    }
}
