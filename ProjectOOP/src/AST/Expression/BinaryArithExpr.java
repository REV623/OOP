package AST.Expression;

import ErrorExcep.EvalError;
import java.util.Map;

public class BinaryArithExpr implements Expression {
    private Expression left,right;
    private String op;
    public BinaryArithExpr(Expression left, String op, Expression right){
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("(");
        this.left.prettyPrint(s);
        s.append(" ");
        s.append(this.op);
        s.append(" ");
        this.right.prettyPrint(s);
        s.append(")");
    }

    public double eval(Map<String, Double> bindings) throws EvalError {
        double leftValue = left.eval(bindings);
        double rightValue = right.eval(bindings);
        if(op.equals("+")) return leftValue + rightValue;
        else if(op.equals("-")) return leftValue - rightValue;
        else if(op.equals("*")) return leftValue * rightValue;
        else if(op.equals("/")){
            if (rightValue == 0) throw new ArithmeticException("/ by zero");
            return Math.round(leftValue/rightValue);
        }
        else if(op.equals("%")){
            if (rightValue == 0) throw new ArithmeticException("% by zero");
            return leftValue % rightValue;
        }else if(op.equals("^")){
            if (rightValue == 0 && leftValue == 0) throw new ArithmeticException("0^0 undefined");
            return Math.round(Math.pow(leftValue,rightValue));
        }
        throw new EvalError("unknown op -> " + op);
    }
}
