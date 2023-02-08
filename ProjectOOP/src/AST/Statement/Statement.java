package AST.Statement;

import AST.Node;
import ErrorExcep.EvalError;
import java.util.Map;

public interface Statement extends Node {
    boolean eval(Map<String, Double> bindings) throws EvalError;
}
