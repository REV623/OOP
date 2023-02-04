package Tokenizer;

import ErrorExcep.SyntaxError;
import java.util.NoSuchElementException;

public class Tokenizer {
    private final String src;
    private String next;
    private int pos;

    public Tokenizer(String s) throws SyntaxError {
        this.src = s;
        pos = 0;
        computeNext();
    }

    public boolean hasNextToken(){
        return next != null;
    }

    public String peek(){
        if(!hasNextToken()) throw new NoSuchElementException("no more tokens");
        return next;
    }

    public boolean peek(String s){
        if(!hasNextToken()) return false;
        return peek().equals(s);
    }

    public String consume(){
        if(!hasNextToken()) throw new NoSuchElementException("no more tokens");
        String result = next;
        computeNext();
        return result;
    }

    public void consume(String s) throws SyntaxError{
        if(peek(s)) consume();
        else throw new SyntaxError(s + " expected");
    }

    private void computeNext() {
        StringBuilder s = new StringBuilder();
        while(pos<src.length() && src.charAt(pos)==32) pos++;
        if(pos==src.length()){
            next = null;
            return;
        }
        char c = src.charAt(pos);
        if(isDigit(c)){
            s.append(c);
            for(pos++ ; pos<src.length() && isDigit(src.charAt(pos)) ; pos++)
                s.append(src.charAt(pos));
        }else if(isOp(c)){
            s.append(c);
            pos++;
        }else{
            s.append(c);
            for(pos++ ; pos<src.length() && !isDigit(src.charAt(pos)) && !isOp(src.charAt(pos)) && src.charAt(pos)!=32 ; pos++)
                s.append(src.charAt(pos));
        }
        next = s.toString();
    }

    private boolean isDigit(char c){
        return 48<=c && c<=57;
    }

    private boolean isOp(char c){
        return c=='+' || c=='-' || c=='*' || c=='/' || c=='%' || c=='(' || c==')';
    }
}
