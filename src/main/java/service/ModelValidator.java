package service;

import model.Event;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModelValidator {
    private ValidatorFactory factory;
    private Validator validator;
    private List<String> errorMessages;
    public ModelValidator() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        errorMessages = new ArrayList<>();
    }


    public List<String> validate(Event event){
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        for (ConstraintViolation<Event> violation : violations) {
            errorMessages.add(violation.getMessage());
        }
        return errorMessages;
    }
}
