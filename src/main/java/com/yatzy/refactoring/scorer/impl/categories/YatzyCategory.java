package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class YatzyCategory implements CategoryScorer {

    @Override
    public boolean isRollValid(List<Integer> dices) {
        return CategoryScorer.super.isRollValid(dices) && hasAllSameValues(dices);
    }

    private static boolean hasAllSameValues(List<Integer> dices) {
        return new HashSet<>(dices).size() == 1;
    }

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {
            return MAX_SCORE;
        }
        else {
            return DEFAULT_SCORE;
        }
    }
}
