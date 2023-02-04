package AST;

import ErrorExcep.EvalError;
import java.util.Map;

public class BinaryArithExpr implements Expression{
    private Expression left,right;
    private String op;
    public BinaryArithExpr(Expression left, String op, Expression right){
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("(");
        left.prettyPrint(s);
        s.append(op);
        right.prettyPrint(s);
        s.append(")");
    }

    public long eval(Map<String, Long> bindings) throws EvalError {
        long lv = left.eval(bindings);
        long rv = right.eval(bindings);
        if(op.equals("+")) return lv + rv;
        else if(op.equals("-")) return lv - rv;
        else if(op.equals("*")) return lv * rv;
        else if(op.equals("/")){
            if (rv == 0) throw new ArithmeticException("/ by zero");
            return Math.round(lv/rv);
        }
        else if(op.equals("%")){
            if (rv == 0) throw new ArithmeticException("% by zero");
            return lv % rv;
        }else if(op.equals("^")){
            if (rv == 0 && lv == 0) throw new ArithmeticException("0^0 undefined");
            return Math.round(Math.pow(rv,lv));
        }
        throw new EvalError("unknown op -> " + op);
    }
}
