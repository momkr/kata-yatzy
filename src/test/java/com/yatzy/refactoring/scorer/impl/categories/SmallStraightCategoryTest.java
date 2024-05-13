package com.yatzy.refactoring.scorer.impl.categories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

class SmallStraightCategoryTest {

    private final SmallStraightCategory smallStraightCategory = new SmallStraightCategory();

    @ParameterizedTest
    @MethodSource("smallStraightParameters")
    void should_return_expected_result_with_given_parameters(List<Integer> values, Integer expectedScore) {
        Assertions.assertThat(smallStraightCategory.calculateScore(values)).isEqualTo(expectedScore);
    }


    static List<Arguments> smallStraightParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(List.of(1, 2, 3, 4, 5), 15),
                Arguments.of(List.of(2, 3, 4, 5, 1), 15),
                Arguments.of(List.of(1, 2, 2, 4, 5), 0)
        );
    }
}