package com.model;

import com.exception.MissingValueException;

import java.util.HashMap;
import java.util.Map;

public class Template {

    private String templateText;
    private Map<String, String> variables;

    public Template(String templateText) {
        this.variables = new HashMap<String, String>();
        this.templateText = templateText;
    }

    public void set(String name, String value) {
        this.variables.put(name, value);
    }

    public String evaluate() {
        String result = replaceVariables();

        checkForMissingValue(result);

        return result;
    }

    private String replaceVariables() {
        String result = templateText;

        for (Map.Entry<String, String> entry: variables.entrySet()){
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }

    private void checkForMissingValue(String result) {
        if(result.matches(".*\\$\\{.+\\}.*")){
            throw new MissingValueException();
        }
    }
}
