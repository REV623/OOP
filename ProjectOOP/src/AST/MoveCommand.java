package AST;

import ErrorExcep.EvalError;

import java.util.Map;

public class MoveCommand implements Statement{
    @Override
    public void prettyPrint(StringBuilder s) {

    }

    @Override
    public boolean eval(Map<String, Long> bindings) throws EvalError {
        return false;
    }
}
