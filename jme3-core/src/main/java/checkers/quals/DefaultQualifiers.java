package checkers.quals;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Specifies the annotations to be included in a type without having to provide
 * them explicitly.
 *
 * This annotation permits specifying multiple default qualifiers for more
 * than one type system.  It is necessary because Java forbids multiple
 * annotations of the same name at a single location.
 *
 * Example:
 * <!-- &nbsp; is a hack that prevents @ from being the first charater on the line, which confuses Javadoc -->
 * <code><pre>
 * &nbsp; @DefaultQualifiers({
 * &nbsp;     @DefaultQualifier("NonNull"),
 * &nbsp;     @DefaultQualifier(value = "Interned", locations = ALL_EXCEPT_LOCALS),
 * &nbsp;     @DefaultQualifier("Tainted")
 * &nbsp; })
 * </pre></code>
 *
 * @see DefaultQualifier
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, METHOD, FIELD, LOCAL_VARIABLE, PARAMETER, TYPE})
public @interface DefaultQualifiers {
    /** The default qualifier settings */
    DefaultQualifier[] value() default { };
}
