package cn.aidawone.atomtestingjavajunit5.custom;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/24
 */
public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of("FL", 11, 12),
                Arguments.of("OH", 21, 22),
                Arguments.of("MI", 11, 12));
    }
}
