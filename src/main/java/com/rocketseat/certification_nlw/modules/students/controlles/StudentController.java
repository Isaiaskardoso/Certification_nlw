package com.rocketseat.certification_nlw.modules.students.controlles;

import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.rocketseat.certification_nlw.modules.students.dto.VerifyIfHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudentEntity;
import com.rocketseat.certification_nlw.modules.students.service.StudentCertificationAnswersService;
import com.rocketseat.certification_nlw.modules.students.service.VerifyIfHasCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private VerifyIfHasCertificationService verifyIfHasCertificationService;

    @Autowired
    private StudentCertificationAnswersService studentCertificationAnswersService;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyIfHasCertificationDTO verifyIfHasCertificationDTO){
        var result = this.verifyIfHasCertificationService.execute(verifyIfHasCertificationDTO);
        if (result){
            return "Usuário já vez a prova";
        }

        return "Usuário pode fazer a prova";

    }
    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        try {var result = studentCertificationAnswersService.execute(studentCertificationAnswerDTO);
            return  ResponseEntity.ok().body(result);

        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }



    }
}
