package com.yatzy.refactoring.scorer;

import java.util.List;
import java.util.Objects;

public interface CategoryScorer {

    Integer DEFAULT_SCORE = 0;

    Integer MAX_SCORE = 50;

    default boolean isRollValid(List<Integer> dices) {
        return Objects.nonNull(dices) && dices.size() == 5;
    }

    Integer calculateScore(List<Integer> dices);
}
