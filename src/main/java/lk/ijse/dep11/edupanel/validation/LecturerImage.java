package lk.ijse.dep11.edupanel.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//custom annotation eka
@Constraint(validatedBy = LecturerImageConstraintValidator.class)  //Constraint validator ekka link krna eka
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LecturerImage {
    long maximumFileSize() default (500 * 1024);
    String message() default "Invalid image or file size exceeds more than {maximumFileSize}kb"; //meka aniwa tynna oni //constraint clz ekkin copy kr gnna me 3
    Class<?>[] groups() default {};//meka aniwa tynna oni
    Class<? extends Payload>[] payload() default {};//meka aniwa tynna oni
}
