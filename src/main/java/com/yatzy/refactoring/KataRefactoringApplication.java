package com.yatzy.refactoring;

import com.yatzy.refactoring.scorer.impl.categories.YatzyCategory;
import com.yatzy.refactoring.submitter.CategorySubmitter;
import com.yatzy.refactoring.submitter.impl.CategorySubmitterImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class KataRefactoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataRefactoringApplication.class, args);

        CategorySubmitter submitter = new CategorySubmitterImpl();

        submitter.submit(List.of(1, 1, 1, 1, 1, 1), new YatzyCategory());
    }
}
