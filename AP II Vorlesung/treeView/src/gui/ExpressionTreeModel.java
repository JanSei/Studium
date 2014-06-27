package gui;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import nodes.Node;

public class ExpressionTreeModel implements TreeModel {
    private final List<TreeModelListener> listeners = new ArrayList<>();
    private final Node root;

    /**
     * Method ExpressionTreeModel.
     * @param r
     */
    public ExpressionTreeModel(Node r) {
        if (r == null) throw new NullPointerException("root is null");
        root = r;
    }
    
    /**
     * @see javax.swing.tree.TreeModel#getChild(Object, int)
     */
    public Object getChild(Object parent, int index) {
        return ((Node)parent).getChild(index);
    }

    /**
     * @see javax.swing.tree.TreeModel#getIndexOfChild(Object, Object)
     */
    public int getIndexOfChild(Object parent, Object child) {
        return ((Node)parent).getIndexOfChild((Node)child);
    }

    /**
     * @see javax.swing.tree.TreeModel#getRoot()
     */
    public Object getRoot() {
        return root;
    }

    /**
     * @see javax.swing.tree.TreeModel#getChildCount(Object)
     */
    public int getChildCount(Object parent) {
        return ((Node)parent).getChildCount();
    }

    /**
     * @see javax.swing.tree.TreeModel#isLeaf(Object)
     */
    public boolean isLeaf(Object node) {
    	return ((Node)node).getChildCount() == 0;
    }
    
    /**
     * @see javax.swing.tree.TreeModel#valueForPathChanged(TreePath, Object)
     */
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see javax.swing.tree.TreeModel#addTreeModelListener(TreeModelListener)
     */
    public void addTreeModelListener(TreeModelListener tml) {
        listeners.add(tml);
    }

    /**
     * @see javax.swing.tree.TreeModel#removeTreeModelListener(TreeModelListener)
     */
    public void removeTreeModelListener(TreeModelListener tml) {
        listeners.remove(tml);
    }

    /**
     * Inform the tree view about a change.
     * @param tee TreeExpansionEvent
     */
    public void refresh(TreeExpansionEvent tee) {
        TreeModelEvent tme = new TreeModelEvent(
                tee.getSource(), tee.getPath().getPath(), null, null);
        for (TreeModelListener listener : listeners) 
            listener.treeNodesChanged(tme);
    }
}
        
