package AST;

import ErrorExcep.EvalError;

import java.util.Map;

public interface Expression extends Node{
    long eval(Map<String, Long> bindings) throws EvalError;
}
