package com.nextplugins.template.configuration;

import com.henryfabio.minecraft.configinjector.common.annotations.ConfigField;
import com.henryfabio.minecraft.configinjector.common.annotations.ConfigFile;
import com.henryfabio.minecraft.configinjector.common.injector.ConfigurationInjectable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.function.Function;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */

@Getter
@Accessors(fluent = true)
@ConfigFile("config.yml")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigValue implements ConfigurationInjectable {

    @Getter private static final ConfigValue instance = new ConfigValue();

    @ConfigField("config.example") private String example;
    @ConfigField("config.placeholder") private String placeholder;
    @ConfigField("config.greeting") private String greeting;

    public static <T> T get(Function<ConfigValue, T> function) {
        return function.apply(instance);
    }

}
