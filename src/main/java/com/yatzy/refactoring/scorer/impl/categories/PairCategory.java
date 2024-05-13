package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import com.yatzy.refactoring.scorer.utils.MatcherUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class PairCategory implements CategoryScorer {

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {

            Map<Integer, List<Integer>> collect = MatcherUtils.collectDices(dices);
            Map<Integer, List<Integer>> elementsWithPair = MatcherUtils.getElementsWithPair(collect);

            if (elementsWithPair.isEmpty()) {
                return DEFAULT_SCORE;
            }

            Integer max = Collections.max(elementsWithPair.keySet());
            return elementsWithPair.get(max).stream().limit(MatcherUtils.PAIR_SIZE).mapToInt(Integer::intValue).sum();
        } else {
            return DEFAULT_SCORE;
        }
    }


}
