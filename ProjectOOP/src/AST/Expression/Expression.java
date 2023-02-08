package AST.Expression;

import AST.Node;
import ErrorExcep.EvalError;
import java.util.Map;

public interface Expression extends Node {
    double eval(Map<String, Double> bindings) throws EvalError;
}
