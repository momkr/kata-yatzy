package com.yatzy.refactoring.scorer.impl.faces;

import com.yatzy.refactoring.scorer.CategoryScorer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnesCategory implements CategoryScorer {

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {
            return dices.stream().filter(value -> value.equals(1)).mapToInt(Integer::intValue).sum();
        } else {
            return DEFAULT_SCORE;
        }
    }
}
