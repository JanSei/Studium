package parser;
import nodes.DivNode;
import nodes.MinNode;
import nodes.MultNode;
import nodes.Node;
import nodes.NumNode;
import nodes.PlusNode;

public class Parser {
    private final Scanner s;
    private Token look;
    
    public Parser(Scanner s) {
        this.s = s;
        look = s.next();
    }
    
    private String match(int tokenId) {
        if (tokenId == look.tokenId) {
            String r = look.lexem;
            look = s.next();
            return r;
        }
        else
            throw new SyntaxException();
    }

    private int lookup() {
        return look.tokenId;
    }
    
    public Node parse() {
        return expression();
    }

    public Node expression() {
        Node sum = term();
        while (true) {
            switch (lookup()) {
            case Token.ADD:
                match(Token.ADD);
                sum = new PlusNode(sum, term());
                break;
            case Token.SUB:
                match(Token.SUB);
                sum = new MinNode(sum, term());
                break;
            default:
                return sum;
            }
        }
    }
    public Node term() {
        Node product = factor();
        while (true) {
            switch (lookup()) {
            case Token.MUL:
                match(Token.MUL);
                product = new MultNode(product, factor());
                break;
            case Token.DIV:
                match(Token.DIV);
                product = new DivNode(product, factor());
                break;
            default:
                return product;
            }
        }
    }

    public Node factor() {
        switch (lookup()) {
        case Token.NUM:
            return new NumNode(Double.valueOf(match(Token.NUM)));
        case Token.LPR:
            match(Token.LPR);
            Node expression = expression();
            match(Token.RPR);
            return expression;
        default:
            throw new SyntaxException();
        }
    }      
}
