package AST;

import ErrorExcep.EvalError;
import java.util.Map;

public interface Statement extends Node{
    boolean eval(Map<String, Long> bindings) throws EvalError;
}
