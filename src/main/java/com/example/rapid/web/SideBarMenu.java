package com.example.rapid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.example.rapid.web.NavigatorUI2.MainView;
import com.example.rapid.web.ui.WorkEntryView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
public class SideBarMenu extends Panel {

	Navigator navigator;
	
	@Autowired
	private UserFormView userView;
	
	/**
	 * 
	 */
	private VerticalLayout menuContent = new VerticalLayout();
	
	private static final long serialVersionUID = -672408962187207449L;

	Panel menuHolder = new Panel("List of Equals");
	
	public class SideBarItem extends Button {
		protected SideBarItem(final String viewName) {
			setHeight("36px");
			setWidth("100%");
			addStyleName("menu-item");
			this.setCaption(viewName);
			// addComponent(selectButton, "top: 0; left: 0; right: 0;");

			this.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
//					navigator.navigateTo(NavigatorUI.MAINVIEW + "/" + viewName);
					navigator.navigateTo(viewName);
				}
			});
		}
	}

	public SideBarMenu(final Navigator navigator) {
		this.navigator = navigator;
		
//      this.addComponent(logout);
		
		menuHolder.setHeight("100%");
        Button logout = new Button("Logout");
        menuContent.addComponent(logout);	
        menuContent.setWidth("100%");
        menuContent.setMargin(true);
        addEntityViewsToList();
//        menuHolder.setContent(menuContent);
        this.setContent(menuContent);
     // Allow going back to the start
       logout.addClickListener(new ClickListener(){

    	   private static final long serialVersionUID = 8293596563714179697L;

			@Override
            public void buttonClick(ClickEvent event) {
                navigator.navigateTo("");
            }
        });
        
	}
	
	
	
	 private void addEntityViewsToList() {
   	  menuContent.addComponent(new SideBarItem(ProjectView.NAME));
   	  menuContent.addComponent(new SideBarItem(UserFormView.NAME));
   	 

//       for (final String key : entityViews.keySet()) {
//           Class viewClass = entityViews.get(key);
//
//           if (View.class.isAssignableFrom(viewClass)) {
//               navigator.addView(key, viewClass);
//
//               SideBarItem menuItem = new SideBarItem(key);
////               menuItems.add(menuItem);
//               menuContent.addComponent(menuItem);
//
////               viewList.addComponent(menuItem);
//           }
//       }
//       navigator.navigateTo("");
//       navigator.navigateTo("welcome");
   }


}
