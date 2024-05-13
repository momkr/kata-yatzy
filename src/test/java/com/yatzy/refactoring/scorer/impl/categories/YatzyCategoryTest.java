package com.yatzy.refactoring.scorer.impl.categories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

class YatzyCategoryTest {

    private final YatzyCategory yatzyCategory = new YatzyCategory();

    @ParameterizedTest
    @MethodSource("yatzyCategoryRollsParameters")
    void should_return_expected_score_with_given_rolls(List<Integer> rolls, Integer expectedScore) {
        Assertions.assertThat(yatzyCategory.calculateScore(rolls)).isEqualTo(expectedScore);
    }

    static List<Arguments> yatzyCategoryRollsParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(List.of(1, 1, 1, 1, 1), 50),
                Arguments.of(List.of(2, 2, 2, 2, 2), 50),
                Arguments.of(List.of(1, 1, 1, 2, 1), 0)
        );
    }

}