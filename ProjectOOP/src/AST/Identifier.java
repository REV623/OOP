package AST;

import ErrorExcep.EvalError;
import java.util.Map;

public class Identifier implements Expression{
    private String name;

    public Identifier(String name){
        this.name = name;
    }

    public String getName(){ return name; }

    public long eval(Map<String, Long> bindings) throws EvalError {
        if(bindings.containsKey(name)) return bindings.get(name);
        throw new EvalError("undefined variable -> " + name);
    }

    public void prettyPrint(StringBuilder s) {
        s.append(name);
    }
}
