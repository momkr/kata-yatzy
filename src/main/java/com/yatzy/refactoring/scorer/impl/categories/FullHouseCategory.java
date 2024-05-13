package com.yatzy.refactoring.scorer.impl.categories;

import com.yatzy.refactoring.scorer.CategoryScorer;
import com.yatzy.refactoring.scorer.utils.MatcherUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FullHouseCategory implements CategoryScorer {

    private final PairCategory pairCategory;

    private final ThreeOfAKindCategory threeOfAKindCategory;

    @Override
    public Integer calculateScore(List<Integer> dices) {
        if (isRollValid(dices)) {
            Map<Integer, List<Integer>> collectedDices = MatcherUtils.collectDices(dices);
            Map<Integer, List<Integer>> elementsWithPair = MatcherUtils.getElementsWithPair(collectedDices);
            Map<Integer, List<Integer>> elementsWithTriple = MatcherUtils.getElementsWithTriple(collectedDices);
            if (!elementsWithPair.isEmpty() && !elementsWithTriple.isEmpty()) {
                return pairCategory.calculateScore(dices) + threeOfAKindCategory.calculateScore(dices);
            } else {
                return DEFAULT_SCORE;
            }
        }
        else {
            return DEFAULT_SCORE;
        }
    }
}
