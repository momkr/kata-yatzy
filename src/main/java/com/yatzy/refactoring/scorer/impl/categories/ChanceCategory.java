package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChanceCategory implements CategoryScorer {

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {
            return dices.stream().mapToInt(Integer::intValue).sum();
        }
        else {
            return DEFAULT_SCORE;
        }
    }
}
