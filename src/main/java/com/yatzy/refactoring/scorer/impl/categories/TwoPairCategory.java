package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import com.yatzy.refactoring.scorer.utils.MatcherUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.yatzy.refactoring.scorer.utils.MatcherUtils.PAIR_SIZE;

@Service
public class TwoPairCategory implements CategoryScorer {

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {

            Map<Integer, List<Integer>> collect = MatcherUtils.collectDices(dices);
            Map<Integer, List<Integer>> elementsWithPair = MatcherUtils.getElementsWithPair(collect);

            if (elementsWithPair.size() < PAIR_SIZE) {
                return DEFAULT_SCORE;
            }

            return elementsWithPair.entrySet().stream().flatMap(entry -> entry.getValue().stream().limit(PAIR_SIZE)).mapToInt(Integer::intValue).sum();
        } else {
            return DEFAULT_SCORE;
        }
    }
}
