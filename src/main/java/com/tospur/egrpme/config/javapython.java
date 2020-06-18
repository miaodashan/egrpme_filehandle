package com.tospur.egrpme.config;
import org.python.util.PythonInterpreter;

public class javapython {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.set("a","zh多少度");
        interpreter.exec("print a.encode('utf-8')");
    }
}
