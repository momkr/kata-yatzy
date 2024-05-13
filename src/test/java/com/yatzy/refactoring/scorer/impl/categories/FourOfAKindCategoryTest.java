package com.yatzy.refactoring.scorer.impl.categories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class FourOfAKindCategoryTest {

    private final FourOfAKindCategory fourOfAKindCategory = new FourOfAKindCategory();

    @ParameterizedTest
    @MethodSource("fourOfAKindSumParameters")
    void should_return_expected_result_with_given_parameters(List<Integer> dices, Integer expected) {
        Assertions.assertThat(fourOfAKindCategory.calculateScore(dices)).isEqualTo(expected);
    }

    static List<Arguments> fourOfAKindSumParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(Arrays.asList(3, 3, 3, 3, 5), 12),
                Arguments.of(Arrays.asList(5, 5, 5, 4, 5), 20),
                Arguments.of(Arrays.asList(3, 3, 3, 3, 3), 12),
                Arguments.of(Arrays.asList(2, 2, 2, 2, 5), 8),
                Arguments.of(Arrays.asList(2, 2, 2, 5, 5), 0),
                Arguments.of(Arrays.asList(2, 2, 2, 2, 2), 8)
        );
    }
}