package com.example.rapid.web;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

/** Main view with a menu */
public class IMSMainView extends HorizontalSplitPanel implements View {
	private static final long serialVersionUID = -3398565663865641952L;

//	HorizontalSplitPanel mainLayout = new HorizontalSplitPanel();
	VerticalLayout contentPanelContent = new VerticalLayout();


	public IMSMainView(VerticalLayout contentPanelContent) {
		this.contentPanelContent = contentPanelContent;
		setSizeFull();
		setSplitPosition(17);
	}

//	public void setupMainLayout() {
//		contentPanel.setSizeFull();
//		addComponent(contentPanel);
//
//		// mainLayout.setExpandRatio(contentPanel, 1.0f);
//		
////		addComponent(mainLayout);
////		setExpandRatio(mainLayout, 1.0f);
//		setSizeFull();
//	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}
}
// End of Main View