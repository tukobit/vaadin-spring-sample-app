package com.example.rapid.web;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ContentLayout extends CustomComponent {
	private String mainViewUri = null;
	private VerticalLayout layout = new VerticalLayout();
	private String currentFragment = "";

	public ContentLayout() {
		layout.setSizeFull();
		setSizeFull();
//		layout.addComponent(uriFragmentUtil);
		setCompositionRoot(layout);
	}

}
