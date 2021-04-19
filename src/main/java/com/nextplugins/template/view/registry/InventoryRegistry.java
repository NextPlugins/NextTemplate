package com.nextplugins.template.view.registry;

import com.nextplugins.template.view.TemplateView;
import lombok.Getter;

import javax.inject.Singleton;

@Getter
@Singleton
public class InventoryRegistry {

    private TemplateView templateView;

    public void init() {
        this.templateView = new TemplateView().init();
    }

}
