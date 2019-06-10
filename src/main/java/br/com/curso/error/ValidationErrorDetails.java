package br.com.curso.error;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrorDetails extends ErrorDetail {

    private Map<String,String> errors;

    public ValidationErrorDetails(){
        super();
        errors = new HashMap<>();
    }

    public ValidationErrorDetails addError(String field,String fieldMessage){
         errors.put(field,fieldMessage);
         return this;
    }

    public Map getErrors(){
        return errors;
    }
}
