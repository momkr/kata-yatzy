package com.yatzy.refactoring.scorer.impl.categories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FullHouseCategoryTest {

    @InjectMocks
    private FullHouseCategory fullHouseCategory;

    @Mock
    private PairCategory pairCategory;

    @Mock
    private ThreeOfAKindCategory threeOfAKindCategory;

    @Test
    void should_return_default_value_when_dice_is_null() {
        List<Integer> dices = null;
        Integer expectedTotal = 0;

        Assertions.assertThat(fullHouseCategory.calculateScore(dices)).isEqualTo(expectedTotal);
    }

    @Test
    void should_return_default_value_when_dice_is_empty() {
        List<Integer> dices = Collections.emptyList();
        Integer expectedTotal = 0;

        Assertions.assertThat(fullHouseCategory.calculateScore(dices)).isEqualTo(expectedTotal);
    }

    @Test
    void should_return_given_value_when_roll_is_valid() {
        List<Integer> dices = List.of(6, 2, 2, 2, 6);
        Integer expectedTotal = 18;
        Integer expectedPairSum = 12;
        Integer expectedThreeOfAKindSum = 6;
        Mockito.when(pairCategory.calculateScore(dices)).thenReturn(expectedPairSum);
        Mockito.when(threeOfAKindCategory.calculateScore(dices)).thenReturn(expectedThreeOfAKindSum);

        Assertions.assertThat(fullHouseCategory.calculateScore(dices)).isEqualTo(expectedTotal);
    }

    @Test
    void should_return_default_value_when_roll_is_not_valid() {
        List<Integer> dices = List.of(1, 1, 1, 1, 2);
        Integer expectedTotal = 0;

        Assertions.assertThat(fullHouseCategory.calculateScore(dices)).isEqualTo(expectedTotal);
    }

}