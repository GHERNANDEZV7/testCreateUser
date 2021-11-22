package cl.springboot.rest.usuarioapirest.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.springframework.stereotype.Service;

@Service
public class PasswordConstraintValidator implements ConstraintValidator<IValidPassword, String> {

    @Override
    public void initialize(IValidPassword arg0) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
            // Debe estar entre 8 y 30 caracteres
            new LengthRule(8, 30),

            // al menos 1 mayuscula
            new CharacterRule(EnglishCharacterData.UpperCase, 1),

            // al menos 1 minuscula
            new CharacterRule(EnglishCharacterData.LowerCase, 1),

            // al menos 2 digitos
            new CharacterRule(EnglishCharacterData.Digit, 2),


            // no whitespace
            new WhitespaceRule()

        ));
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        List<String> messages = validator.getMessages(result);

        String messageTemplate = messages.stream()
            .collect(Collectors.joining(","));
        context.buildConstraintViolationWithTemplate(messageTemplate)
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
        return false;
    }
}