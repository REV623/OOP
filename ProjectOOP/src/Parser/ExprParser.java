package Parser;

import AST.Expression.*;
import AST.Expression.Number;
import ErrorExcep.SyntaxError;
import Tokenizer.Tokenizer;

public class ExprParser extends StatementParser implements Parser{
    private SyntaxError syntaxError_long = new SyntaxError("Expected Number");

    public ExprParser(Tokenizer tkz) {
        super(tkz);
    }

    @Override
    public Expression parse() throws SyntaxError {
        return parseExpression();
    }

    private Expression parseExpression() throws SyntaxError{
        Expression e = parseTerm();
        while (tkz.peek("+") || tkz.peek("-")){
            if(tkz.peek("+")){
                tkz.consume();
                e =  new BinaryArithExpr(e,"+",parseTerm());
            }else if(tkz.peek("-")){
                tkz.consume();
                e =  new BinaryArithExpr(e,"-",parseTerm());
            }
        }
        return e;
    }

    private Expression parseTerm() throws SyntaxError{
        Expression e = parseFactor();
        while (tkz.peek("*") || tkz.peek("/") || tkz.peek("%")) {
            if(tkz.peek("*")) {
                tkz.consume();
                e = new BinaryArithExpr(e,"*",parseFactor());
            }else if(tkz.peek("/")) {
                tkz.consume();
                e = new BinaryArithExpr(e,"/",parseFactor());
            }else if(tkz.peek("%")) {
                tkz.consume();
                e = new BinaryArithExpr(e,"%",parseFactor());
            }
        }
        return e;
    }

    private Expression parseFactor() throws SyntaxError {
        Expression e = parsePower();
        while (tkz.peek("^")){
            tkz.consume();
            e = new BinaryArithExpr(e,"^",parsePower());
        }
        return e;
    }

    private Expression parsePower() throws SyntaxError {
        Expression e;
        String number = tkz.peek();
        if(isDigit(number.charAt(0))){
            try {
                tkz.consume();
                e = new Number(Long.parseUnsignedLong(number));
            }catch (NumberFormatException error){
                throw error;
            }
        }else if(tkz.peek("(")){
            tkz.consume("(");
            e = parseExpression();
            tkz.consume(")");
        }else if(tkz.peek("opponent")){
            tkz.consume();
            e = parseInfo(true);
        }else if(tkz.peek("nearby")){
            tkz.consume();
            e = parseInfo(false);
        }else{
            String identifier = tkz.consume();
            if(!isIdentifier(identifier)) throw syntaxError_identifier;
            e = new Identifier(identifier);
        }
        return e;
    }

    private Expression parseInfo(boolean isOpponent) throws SyntaxError {
        if(isOpponent) return new OpponentInfo();
        else return new NearbyInfo(parseDirection());
    }
}
