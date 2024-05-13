package com.yatzy.refactoring.scorer.impl.faces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

class TwosCategoryTest {

    private final TwosCategory twosCategory = new TwosCategory();

    @ParameterizedTest
    @MethodSource("twosCategoryRollsParameters")
    void should_return_expected_score_with_given_rolls(List<Integer> rolls, Integer expectedScore) {
        Assertions.assertThat(twosCategory.calculateScore(rolls)).isEqualTo(expectedScore);
    }

    static List<Arguments> twosCategoryRollsParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(List.of(1, 2, 2, 4, 5), 4),
                Arguments.of(List.of(2, 2, 2, 2, 2), 10),
                Arguments.of(List.of(3, 3, 3, 4, 5), 0)
        );
    }
}