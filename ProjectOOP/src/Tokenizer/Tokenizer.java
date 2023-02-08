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
        while(pos<src.length() && isBlank(src.charAt(pos))){
            if(pos<src.length() && src.charAt(pos)=='#'){
                while (pos<src.length() && src.charAt(pos)!='\n') pos++;
            }
            pos++;
        }
        if(pos>=src.length()){
            next = null;
            return;
        }
        char current = src.charAt(pos);
        if(isOperator(current)){
            s.append(current);
            pos++;
        }else{
            s.append(current);
            for(pos++ ; pos<src.length() && !isOperator(src.charAt(pos)) && !isBlank(src.charAt(pos)) ; pos++){
                s.append(src.charAt(pos));
            }
        }
        next = s.toString();
    }

    private boolean isBlank(char c){
        return c==' ' || c=='\n' || c=='\t' || c=='#';
    }

    private boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/' || c=='%' || c=='^' || c=='=' || c=='(' || c==')' || c=='{' || c=='}';
    }

    private boolean isAlphanumeric(char c){
        return ('a'<=c && c<='z') || ('A'<=c && c<='Z') || ('0'<=c && c<='9');
    }
}
