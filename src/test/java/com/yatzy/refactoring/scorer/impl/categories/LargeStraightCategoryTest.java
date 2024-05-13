package com.yatzy.refactoring.scorer.impl.categories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

class LargeStraightCategoryTest {

    private final LargeStraightCategory largeStraightCategory = new LargeStraightCategory();

    @ParameterizedTest
    @MethodSource("largeStraightParameters")
    void should_return_expected_result_with_given_parameters(List<Integer> dices, Integer expectedScore) {
        Assertions.assertThat(largeStraightCategory.calculateScore(dices)).isEqualTo(expectedScore);
    }

    static List<Arguments> largeStraightParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(List.of(6, 2, 3, 4, 5), 20),
                Arguments.of(List.of(2, 3, 4, 5, 6), 20),
                Arguments.of(List.of(1, 2, 2, 4, 5), 0)
        );
    }
}