package com.rocketseat.certification_nlw.modules.certifications.controlles;

import com.rocketseat.certification_nlw.modules.certifications.service.Top10RankingServices;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudentEntity;
import com.rocketseat.certification_nlw.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private Top10RankingServices top10RankingServices;

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;
    @GetMapping("/top10")
    public List<CertificationStudentEntity> top10(){
        return this.top10RankingServices.execute();
    }
}
