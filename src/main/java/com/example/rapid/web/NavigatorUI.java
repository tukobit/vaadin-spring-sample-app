package com.example.rapid.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
public class NavigatorUI extends UI implements ViewChangeListener {

	private HorizontalSplitPanel mainLayout;

	public static final String MAINVIEW = "main";

	private VerticalLayout sidebar;

	private Panel scroll;

	private CssLayout viewList;

	private Label appName;
	
	private Navigator navigator;
	Panel contentPanel = new Panel("An Equal");

	private VerticalLayout contentPanelContent = new VerticalLayout();
	
//	private List<SidebarItem> menuItems = new ArrayList<SidebarItem>();

	@Override
	protected void init(VaadinRequest request) {
		setSizeFull();
		IMSMainView view = new IMSMainView(contentPanelContent);
		

		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(contentPanelContent);
        navigator = new Navigator(this, viewDisplay);
        SideBarMenu sideMenu = new SideBarMenu(navigator);
        view.addComponent(sideMenu);
//        view.setupMainLayout();
        contentPanel.setContent(contentPanelContent);
        view.addComponent(contentPanel);
        
        
//        navigator.addView(MAINVIEW, view);	
//        mainLayout.addComponent(sideMenu);
        // layout and style adjustments
//        mainLayout.addStyleName("main");
//        mainLayout.addStyleName(Reindeer.SPLITPANEL_SMALL);
//        sidebar.addStyleName(Reindeer.LAYOUT_BLUE);
//        scroll.addStyleName(Reindeer.PANEL_LIGHT);
//        appName.addStyleName(Reindeer.LABEL_H1);
//        mainLayout.setSplitPosition(20);
//        
       
//		navigator.addView("", view);
        
       
		setContent(view);
		setupContent();
//		navigator.addViewChangeListener(this);
        // add entity views to the list
//        addEntityViewsToList();
//        WelcomeView view = new WelcomeView();
//        mainLayout.setSecondComponent(view);
	}
	
	public void setupContent()
	{
		contentPanelContent.setSizeFull();
		contentPanelContent.setMargin(true);
		contentPanel.setContent(contentPanelContent); // Also clears

////		if (event.getParameters() == null || event.getParameters().isEmpty()) {
////			contentPanelContent.addComponent(new Label("Nothing to see here, "
////					+ "just pass along."));
////			return;
////		}
////
////		// Display the fragment parameters
////		Label watching = new Label("You are currently watching a "
////				+ event.getParameters());
//		watching.setSizeUndefined();
//		contentPanelContent.addComponent(watching);
//		contentPanelContent.setComponentAlignment(watching,
//				Alignment.MIDDLE_CENTER);

		// Some other content
//		Embedded pic = new Embedded(null, new ThemeResource("img/"
//				+ event.getParameters() + "-128px.png"));
//		contentPanelContent.addComponent(pic);
//		contentPanelContent.setExpandRatio(pic, 1.0f);
//		contentPanelContent.setComponentAlignment(pic, Alignment.MIDDLE_CENTER);

//		Label back = new Label("And the " + event.getParameters()
//				+ " is watching you");
//		back.setSizeUndefined();
//		contentPanelContent.addComponent(back);
//		contentPanelContent
//				.setComponentAlignment(back, Alignment.MIDDLE_CENTER);
	}

	@Override
	public boolean beforeViewChange(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterViewChange(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 protected abstract class SidebarItem extends AbsoluteLayout {
	        private Button selectButton = new NativeButton();

	        protected SidebarItem(final String viewName) {
	            this(viewName, viewName);
	        }

	        protected SidebarItem(final String viewName, String viewCaption) {
	            setHeight("36px");
	            setWidth("100%");
	            addStyleName("menu-item");
	            selectButton.setCaption(viewCaption);
	            addComponent(selectButton, "top: 0; left: 0; right: 0;");

	            selectButton.addClickListener(new Button.ClickListener() {
	                public void buttonClick(ClickEvent event) {
	                    navigator.navigateTo(viewName);
	                }
	            });
	        }
	        public abstract boolean ownsView(View current);
	    }

	    private class EntitySidebarItem extends SidebarItem {
	        private Button selectButton = new NativeButton();
	        private Button newButton = new NativeButton("New");
	        private final Class<? extends View> viewClass;
	        
	        public EntitySidebarItem(final String viewName, Class<? extends View> viewClass) {
	            super(viewName);
	            
	            System.out.println("View name" + viewName);
	            this.viewClass = viewClass;
	            
	            newButton.addStyleName("new");
	            newButton.setVisible(false);
	            newButton.setEnabled(false);
	            addComponent(newButton, "top: 8px; right: 3px;");
	            
	            newButton.addClickListener(new Button.ClickListener() {
	                public void buttonClick(ClickEvent event) {
	                    navigator.navigateTo(viewName + "/new");
	                }
	            });
	        }

	        public Button getNewButton() {
	            return newButton;
	        }

			@Override
			public boolean ownsView(View current) {
				 return viewClass.isAssignableFrom(current.getClass());
			}
	    }
	    
	    
	    public static class WelcomeView extends VerticalLayout implements View {
	        public WelcomeView() {
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
	            Notification.show("Welcome to Star Health Portal");
			}
	    }
	    
	    
//
//	    public static class WelcomeView extends VerticalLayout implements View {
//	        public WelcomeView() {
//	            setMargin(true);
//	            setSizeFull();
//	            addStyleName(Reindeer.LAYOUT_BLUE);
//	            Label l = new Label(
//	                    "<h1 class=\"v-label-h1\" style=\"text-align: center;\">Welcome</h1> Select an entity type from the left side menu to begin", ContentMode.HTML);
//	            l.setSizeUndefined();
//	            l.addStyleName(Reindeer.LABEL_SMALL);
//	            addComponent(l);
//	            setComponentAlignment(l, Alignment.MIDDLE_CENTER);
//	        }
//
//	        @Override
//			public void enter(ViewChangeEvent event) {
//	        	Notification.show("Welcome to the Animal Farm");
//			}
//	    }


	    public void navigatorViewChange(View previous, View current) {
	    	System.out.println("navigatorViewChange called");
	        for (SidebarItem item : menuItems) {
	            boolean canCreate = false;
	            if (current != null && item.ownsView(current)) {
	                item.addStyleName("open");
	                if (current instanceof AbstractEntityView) {
	                    canCreate = ((AbstractEntityView) current).isCreateAllowed();
	                }
	            } else {
	                item.removeStyleName("open");
	            }
	            if (item instanceof EntitySidebarItem) {
	                EntitySidebarItem entityMenuItem = (EntitySidebarItem) item;
	                entityMenuItem.getNewButton().setEnabled(canCreate);
	                entityMenuItem.getNewButton().setVisible(canCreate);
	            }
	        }
	    }

	  
	    private void addEntityViewsToList() {
	    	final Map<String, Class> entityViews = listEntityViews();
	        navigator.addView("welcome", new WelcomeView());
	        navigator.addView("", new WelcomeView());
	        
	        for (final String key : entityViews.keySet()) {
	            Class viewClass = entityViews.get(key);

	            if (View.class.isAssignableFrom(viewClass)) {
	                navigator.addView(key, viewClass);

	                EntitySidebarItem menuItem = new EntitySidebarItem(key, viewClass);
	                menuItems.add(menuItem);
	                viewList.addComponent(menuItem);
	            }
	        }
	        navigator.navigateTo("welcome");
	    }

	    private Map<String, Class> listEntityViews() {
			Map<String, Class> navLinks = new HashMap<String, Class>();
			navLinks.put("Project", ProjectView.class);
			navLinks.put("User List", RapidUserView.class);
			navLinks.put("Work Entry", WorkEntryView.class);
			return navLinks;
		}

		@AutoGenerated
	    private HorizontalSplitPanel buildMainLayout() {
	        // common part: create layout
	        mainLayout = new HorizontalSplitPanel();

	        // top-level component properties
	        setWidth("100.0%");
	        setHeight("100.0%");

	        // sidebar
	        sidebar = buildSidebar();
	        mainLayout.addComponent(sidebar);
	        mainLayout.addComponent(new ContentLayout());
	        // navigator
//	          navigator = new Navigator(UI.getCurrent(), sidebar);
//	        navigator. setWidth ("100.0%");
//	        navigator.setHeight("100.0%");
//	        navigator.setImmediate(false);
//	        TODO: Setting Navigator to mainlayout has bee commented
//	        mainLayout.add(navigator);

	        return mainLayout;
	    }

	    @AutoGenerated
	    private VerticalLayout buildSidebar() {
	        // common part: create layout
	        sidebar = new VerticalLayout();
	        sidebar.setWidth("100.0%");
	        sidebar.setHeight("100.0%");
	        sidebar.setStyleName("sidebar");
	        sidebar.setImmediate(false);
	        sidebar.setMargin(false);

	        // appName
	        appName = new Label();
	        appName.setWidth("100.0%");
	        appName.setHeight("-1px");
	        appName.setValue("Star Health");
//	        TODO: Read about ContentMode
//	        appName.setContentMode(3);
	        appName.setImmediate(false);
	        sidebar.addComponent(appName);

	        // scroll
	        scroll = buildScroll();
	        sidebar.addComponent(scroll);
	        sidebar.setExpandRatio(scroll, 1.0f);

	        return sidebar;
	    }

	    @AutoGenerated
	    private Panel buildScroll() {
	        // common part: create layout
	        scroll = new Panel();
	        scroll.setWidth("100.0%");
	        scroll.setHeight("100.0%");
	        scroll.setImmediate(false);

	        // viewList
	        viewList = new CssLayout();
	        viewList.setWidth("100.0%");
	        viewList.setHeight("-1px");
	        viewList.setStyleName("view-list");
	        viewList.setImmediate(false);
//	        TODO: Set margin is removed in Vaadin 7
//	        viewList.setMargin(false);
	        scroll.setContent(viewList);

	        return scroll;
	    }

		@Override
		public boolean beforeViewChange(ViewChangeEvent event) {
			navigatorViewChange(event.getOldView(), event.getNewView());
			return false;
		}

		@Override
		public void afterViewChange(ViewChangeEvent event) {
			// TODO Auto-generated method stub
			
		}*/

}
