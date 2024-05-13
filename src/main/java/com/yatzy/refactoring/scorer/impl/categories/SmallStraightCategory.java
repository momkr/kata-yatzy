package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yatzy.refactoring.scorer.utils.MatcherUtils.SMALL_STRAIGHT_END_VALUE;
import static com.yatzy.refactoring.scorer.utils.MatcherUtils.SMALL_STRAIGHT_START_VALUE;
import static com.yatzy.refactoring.scorer.utils.MatcherUtils.hasValidStraight;

@Service
public class SmallStraightCategory implements CategoryScorer {

    private static final Integer SCORE = 15;

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {
            boolean validSmallStraight = hasValidStraight(dices, SMALL_STRAIGHT_START_VALUE, SMALL_STRAIGHT_END_VALUE);

            return validSmallStraight ? SCORE : DEFAULT_SCORE;
        }
        else {
            return DEFAULT_SCORE;
        }
    }
}
