package com.example.rapid.web;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.ui.PageState;
import com.vaadin.ui.UI;

@Theme("rapid")
public class RapidWorkHoursWindow extends Page {

    public RapidWorkHoursWindow(UI parent, PageState state) {
    	super(parent, state);
    	RapidWorkHoursEntityManagerView entityManagerView = new RapidWorkHoursEntityManagerView();
    	UI.getCurrent().setContent(entityManagerView);
//    	setContent(entityManagerView);
    	
    }
}
