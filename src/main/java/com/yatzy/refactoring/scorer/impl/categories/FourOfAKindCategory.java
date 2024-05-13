package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import com.yatzy.refactoring.scorer.utils.MatcherUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class FourOfAKindCategory implements CategoryScorer {

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {

            Map<Integer, List<Integer>> groupedElements = MatcherUtils.collectDices(dices);
            Map<Integer, List<Integer>> elementsWithFourOfAKind = MatcherUtils.getElementsWithSquare(groupedElements);

            if (elementsWithFourOfAKind.isEmpty()) {
                return DEFAULT_SCORE;
            }

            Integer max = Collections.max(elementsWithFourOfAKind.keySet());
            return elementsWithFourOfAKind.get(max).stream().limit(MatcherUtils.SQUARE_SIZE).mapToInt(Integer::intValue).sum();
        }
        else {
            return DEFAULT_SCORE;
        }
    }
}
