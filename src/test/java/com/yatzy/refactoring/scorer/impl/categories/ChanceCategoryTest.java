package com.yatzy.refactoring.scorer.impl.categories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;


class ChanceCategoryTest {

    private final ChanceCategory chanceCategory = new ChanceCategory();

    @ParameterizedTest
    @MethodSource("chanceCategoryRollsParameters")
    void should_return_expected_score_with_given_rolls(List<Integer> rolls, Integer expectedScore) {
        Assertions.assertThat(chanceCategory.calculateScore(rolls)).isEqualTo(expectedScore);
    }

    static List<Arguments> chanceCategoryRollsParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(List.of(1, 1, 1, 1, 1), 5),
                Arguments.of(List.of(1, 1, 3, 3, 6), 14),
                Arguments.of(List.of(4, 5, 5, 6, 1), 21),
                Arguments.of(List.of(6, 2, 3, 4, 5), 20)
        );
    }
}