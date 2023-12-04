package lk.ijse.dep11.edupanel.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


//annotation eka wd krn oni wdya kyl denne me clz eekn
public class LecturerImageConstraintValidator implements ConstraintValidator<LecturerImage, MultipartFile> {//LecturerImage -> annotation eka  //MultipartFile -> validate krnna blaporottu wena field eke type eka

    private long maximumFileSize;
    @Override
    public void initialize(LecturerImage constraintAnnotation) { //meka atule thma annotation eke dewl access krnna plwn (meyge constructor eka run unta passe)
        maximumFileSize= constraintAnnotation.maximumFileSize();
    }


    //logic eka liynne methna
    @Override   //true return unoth validation eka ok/ false nm validation eka fail
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {
        if(multipartFile==null || multipartFile.isEmpty()) return true;
        if(multipartFile.getSize()> maximumFileSize) return false;
        if(multipartFile.getContentType()==null) return false;
        if(!multipartFile.getContentType().startsWith("image/")) return false;
        return true;
    }
}
