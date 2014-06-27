package parser;
public final class Token {
    public static final int
        EOF = -1,
        ERR = 0,
        ID  = 1,
        NUM = 2,
        ADD = 3,
        SUB = 4,
        MUL = 5,
        DIV = 6,
        LPR = 7,
        RPR = 8;

    final int tokenId;
    final String lexem;

    Token(int tokenId, String lexem) {
        this.tokenId = tokenId;
        this.lexem = lexem;
    }
}
