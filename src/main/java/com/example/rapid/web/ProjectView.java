package com.example.rapid.web;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

public class ProjectView extends VerticalLayout implements View {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4090943458322849134L;

	public ProjectView() {
        setMargin(true);
        setSizeFull();
        addStyleName(Reindeer.LAYOUT_BLUE);
        Label l = new Label(
                "<h1 class=\"v-label-h1\" style=\"text-align: center;\">Welcome</h1> Select an entity type from the left side menu to begin",
                Label.CONTENT_XHTML);
        l.setSizeUndefined();
        l.addStyleName(Reindeer.LABEL_SMALL);
        addComponent(l);
        setComponentAlignment(l, Alignment.MIDDLE_CENTER);
    }

    public String getWarningForNavigatingFrom() {
        return null;
    }

	@Override
	public void enter(ViewChangeEvent event) {
        Notification.show("Welcome to Project View ");
	}
}
