package com.example.rapid.web;

import com.example.rapid.web.ui.ProjectView;
import com.example.rapid.web.ui.RapidUserView;
import com.example.rapid.web.ui.WorkEntryView;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

public class SideBarMenu extends Panel {

	Navigator navigator;
	
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
					navigator.navigateTo(NavigatorUI.MAINVIEW + "/" + viewName);
				}
			});
		}
	}

	public SideBarMenu(final Navigator navigator) {
		this.navigator = navigator;
		
//      this.addComponent(logout);
		
		menuHolder.setHeight("100%");
        menuHolder.setWidth(null);

        Button logout = new Button("Logout");
        menuContent.addComponent(logout);	
        menuContent.addComponent(new SideBarItem("Pig"));
        menuContent.addComponent(new SideBarItem("Cat"));
        menuContent.addComponent(new SideBarItem("Dog"));
        menuContent.addComponent(new SideBarItem("Reindeer"));
        menuContent.addComponent(new SideBarItem("Penguin"));
        menuContent.addComponent(new SideBarItem("Sheep"));
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
      navigator.addView("", WelcomeView.class);
   	  navigator.addView(NavigatorUI.MAINVIEW + "/" +"Project", new com.example.rapid.web.ProjectView());
   	  navigator.addView(NavigatorUI.MAINVIEW + "/" + "User_List", new UserView());
   	  navigator.addView(NavigatorUI.MAINVIEW + "/" +"work_entry", WorkEntryView.class);
   	  
//   	  menuItems.add(menuItem);
   	  menuContent.addComponent(new SideBarItem("Project"));
   	  menuContent.addComponent(new SideBarItem("User_List"));
   	  menuContent.addComponent(new SideBarItem("work_entry"));

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
