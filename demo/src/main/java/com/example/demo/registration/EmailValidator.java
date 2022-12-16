package com.example.demo.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class serves to validate an email address
 * It allows numeric values from 0 to 9.
 * Both uppercase and lowercase letters from a to z are allowed.
 * Allowed are underscore “_”, hyphen “-“, and dot “.”
 * Dot isn't allowed at the start and end of the local part.
 * Consecutive dots aren't allowed.
 * For the local part, a maximum of 64 characters are allowed.
 *
 * (?=.{1,64}@)            # local-part min 1 max 64
 * [A-Za-z0-9_-]+          # Start with chars in the bracket [ ], one or more (+)
 *                         # dot (.) not in the bracket[], it can't start with a dot (.)
 *
 * (\\.[A-Za-z0-9_-]+)*	 # follow by a dot (.), then chars in the bracket [ ] one or more (+)
 *                         # * means this is optional
 *                         # this rule for two dots (.)
 *
 * @                       # must contain a @ symbol
 *
 * [^-]                    # domain can't start with a hyphen (-)
 * [A-Za-z0-9-]+           # Start with chars in the bracket [ ], one or more (+)
 * (\\.[A-Za-z0-9-]+)*      # follow by a dot (.), optional
 * (\\.[A-Za-z]{2,})       # follow by a dot (.), chars in the bracket [ ], min 2 (.com/.uk)
 *
 *
 *
 */
@Service
public class EmailValidator implements Predicate<String> {

    private static final String VALID_EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(VALID_EMAIL_PATTERN);
    @Override
    public boolean test(String s) {
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
