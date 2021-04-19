package com.nextplugins.template.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.henryfabio.sqlprovider.executor.SQLExecutor;
import com.nextplugins.template.NextTemplate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.logging.Logger;

@EqualsAndHashCode(callSuper = false)
@Data(staticConstructor = "of")
public class PluginModule extends AbstractModule {

    private final NextTemplate nextTemplate;

    @Override
    protected void configure() {

        bind(NextTemplate.class)
                .toInstance(nextTemplate);

        bind(Logger.class)
                .annotatedWith(Names.named("main"))
                .toInstance(nextTemplate.getLogger());

        bind(SQLExecutor.class)
                .toInstance(new SQLExecutor(nextTemplate.getSqlConnector()));

    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

}
