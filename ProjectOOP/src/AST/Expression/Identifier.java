package AST.Expression;

import ErrorExcep.EvalError;
import java.util.Map;

public class Identifier implements Expression {
    private String name;

    public Identifier(String name,Map<String, Double> map){
        this.name = name;
        map.put(this.name, 0d);
    }

    public Identifier(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double eval(Map<String, Double> bindings) throws EvalError {
        if(bindings.containsKey(name)) return bindings.get(name);
        throw new EvalError("undefined variable -> " + name);
    }

    public void prettyPrint(StringBuilder s) {
        s.append(name);
    }
}
