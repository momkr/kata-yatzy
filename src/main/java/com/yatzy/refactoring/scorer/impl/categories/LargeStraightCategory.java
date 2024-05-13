package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yatzy.refactoring.scorer.utils.MatcherUtils.LARGE_STRAIGHT_END_VALUE;
import static com.yatzy.refactoring.scorer.utils.MatcherUtils.LARGE_STRAIGHT_START_VALUE;
import static com.yatzy.refactoring.scorer.utils.MatcherUtils.hasValidStraight;

@Service
public class LargeStraightCategory implements CategoryScorer {

    private static final Integer SCORE = 20;

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {
            boolean validSmallStraight = hasValidStraight(dices, LARGE_STRAIGHT_START_VALUE, LARGE_STRAIGHT_END_VALUE);

            return validSmallStraight ? SCORE : DEFAULT_SCORE;
        }
        else {
            return DEFAULT_SCORE;
        }
    }
}
