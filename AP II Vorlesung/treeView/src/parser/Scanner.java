package parser;
import java.io.*;

public class Scanner {
    private final Reader file;
    private static final char EOF = '\001';
    private char c = ' ';

    /**
     * Reads next character.
     * The character can be found in variable c.
     * Read errors lead to program abortion.
     */
    private void getNextChar() {
        if (c == EOF) return;
        try {
            int ci = file.read();
            c = (ci == -1) ? EOF : (char)ci;
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public Scanner(InputStream stream) {
        this(new InputStreamReader(stream));
    }
    
    public Scanner(String input) {
    	this(new StringReader(input+";"));
    }
    	
    public Scanner(Reader rdr) {
    	this.file = rdr;
        getNextChar();
    }

    private void digits(StringBuffer buf) {
        while (Character.isDigit(c)) {
            buf.append(c);
            getNextChar();
        }
    }
    public Token next() {
        while (Character.isWhitespace(c) && c != '\n') getNextChar();
        if (Character.isDigit(c)) {
            StringBuffer buf = new StringBuffer();
            digits(buf);
            if (c == '.') {
                buf.append(c);
                getNextChar();
                if (Character.isDigit(c)) digits(buf);
            }
            if (c == 'e' || c == 'E') {
                buf.append(c);
                getNextChar();
                if (c == '+' || c == '-') {
                    buf.append(c);
                    getNextChar();
                }
                digits(buf);
            }
            return new Token(Token.NUM, buf.toString());
        }
        else if (Character.isJavaIdentifierStart(c)) {
            StringBuffer buf = new StringBuffer();
            while (Character.isJavaIdentifierPart(c)) {
                buf.append(c);
                getNextChar();
            }
            // id = ht.get(s.toString())
            // if (id == null) -> Token.ID
            //    sonst Keyword
            return new Token(Token.ID, buf.toString());
        }
        else if (c == '+') {
            getNextChar();
            return new Token(Token.ADD, "+");
        }
        else if (c == '-') {
            getNextChar();
            return new Token(Token.SUB, "-");
        }
        else if (c == '*') {
            getNextChar();
            return new Token(Token.MUL, "*");
        }
        else if (c == '/') {
            getNextChar();
            return new Token(Token.DIV, "/");
        }
        else if (c == '(') {
            getNextChar();
            return new Token(Token.LPR, "(");
        }
        else if (c == ')') {
            getNextChar();
            return new Token(Token.RPR, ")");
        }
        else if (c == '\001')
            return new Token(Token.EOF, null);
        else {
            getNextChar();
            return new Token(Token.ERR, String.valueOf(c));
        }
    }
}
