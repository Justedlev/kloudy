package dev.justedlev.common;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class SimpleModelMapper extends ModelMapper {
    public SimpleModelMapper() {
        this.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);
    }

    @Override
    public <D> D map(Object source, Class<D> destination) {
        return source == null ? null : super.map(source, destination);
    }
}
