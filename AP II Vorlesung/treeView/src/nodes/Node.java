package nodes;
public abstract class Node {
    protected Node left;
    protected Node right;
    private boolean expanded = false;

    public abstract double value();
    protected abstract String symbol();
   
    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    
    // Rekursives Durchlaufen des Baumes:
    public static String preOrder(Node n) {
        if (n != null)
            return " " + n.symbol() + preOrder(n.left) +  preOrder(n.right);
        else
            return "";
    }

    public static String inOrder(Node n) {
        if (n != null)
            return inOrder(n.left) +  " " + n.symbol() + inOrder(n.right);
        else
            return "";
    }

    public static String postOrder(Node n) {
        if (n != null)
            return postOrder(n.left) + postOrder(n.right) + " " + n.symbol();
        else
            return "";
    }

    /* Alternative
    */    
    public String postOrder() {
        StringBuffer buf = new StringBuffer();
        postorder(buf);
        buf.append("  ");
        return buf.toString();
    }
    
    private void postorder(StringBuffer buf) {
        if (left != null) left.postorder(buf);
        if (right != null) right.postorder(buf);
        buf.append("  ");
        buf.append(symbol());
    }

    
    public void setExpanded(boolean value) {
        expanded = value;
    }

    public int getChildCount() {
        return count(left) + count(right);
    }
    
    private int count(Node link) {
        return link == null ? 0 : 1;
    }
    
    public String toString() {
        return expanded ? symbol() : String.valueOf(value());
    }
    
    public Object getChild(int index) {
        return index == 0 ? left : right;
    }

    public int getIndexOfChild(Node child) {
        return child == left ? 0 : 1;
    }
}
