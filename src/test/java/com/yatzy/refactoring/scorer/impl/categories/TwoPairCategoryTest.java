package com.yatzy.refactoring.scorer.impl.categories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

class TwoPairCategoryTest {

    private final TwoPairCategory twoPairCategory = new TwoPairCategory();

    @ParameterizedTest
    @MethodSource("sixesCategoryRollsParameters")
    void should_return_expected_score_with_given_rolls(List<Integer> rolls, Integer expectedScore) {
        Assertions.assertThat(twoPairCategory.calculateScore(rolls)).isEqualTo(expectedScore);
    }

    static List<Arguments> sixesCategoryRollsParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(List.of(1, 1, 2, 3, 3), 8),
                Arguments.of(List.of(1, 1, 2, 3, 4), 0),
                Arguments.of(List.of(1, 1, 2, 2, 2), 6),
                Arguments.of(List.of(3, 3, 3, 3, 1), 0)
        );
    }
}