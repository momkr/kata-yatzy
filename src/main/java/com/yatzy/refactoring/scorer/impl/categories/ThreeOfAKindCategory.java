package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import com.yatzy.refactoring.scorer.utils.MatcherUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.yatzy.refactoring.scorer.utils.MatcherUtils.TRIPLE_SIZE;

@Service
public class ThreeOfAKindCategory implements CategoryScorer {

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {

            Map<Integer, List<Integer>> groupedElements = MatcherUtils.collectDices(dices);
            Map<Integer, List<Integer>> elementsWithThreeOfKind = MatcherUtils.getElementsWithTriple(groupedElements);

            if (elementsWithThreeOfKind.isEmpty()) {
                return DEFAULT_SCORE;
            }

            Integer max = Collections.max(elementsWithThreeOfKind.keySet());
            return elementsWithThreeOfKind.get(max).stream().limit(TRIPLE_SIZE).mapToInt(Integer::intValue).sum();
        }
        else {
            return DEFAULT_SCORE;
        }
    }
}
