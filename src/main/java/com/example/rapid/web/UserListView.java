package com.example.rapid.web;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.example.rapid.UserService;
import com.example.rapid.domain.User;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
@VaadinView(UserListView.NAME)
public class UserListView extends VerticalLayout implements View {

	public static final String NAME = "userList";

	@Autowired
	private UserService userService;

	private BeanItemContainer<User> tableContainer = new BeanItemContainer<User>(
			User.class);
	private Table table = new Table();
	
	

	@PostConstruct
	public void PostConstruct() {
		fillTableContainer(tableContainer, 10000);
		table.setPageLength(10);
		table.setCacheRate(4);
		table.setWidth("100%");
		table.setContainerDataSource(tableContainer);
		table.setSelectable(true);
		this.addComponent(table);
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.addComponent(createNewUserButton());
		buttonLayout.addComponent(createEditButton());
		buttonLayout.addComponent(createDeleteButton());
		this.addComponent(buttonLayout);
	}
	
	
	private com.vaadin.ui.Component createNewUserButton() {
		Button button = new Button("New", new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(UserFormView.NAME);
			}
		});
		return button;
	}


	private Button createEditButton() {
		Button button = new Button("Edit", new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Object rowId = table.getValue();
				Long id  = (Long) table.getContainerProperty(rowId, "id").getValue();
				System.out.println(id);
				getUI().getNavigator().navigateTo(UserFormView.NAME + "/" + id);
			}
		});
		return button;
	}

	private Button createDeleteButton() {
		Button button = new Button("Delete", new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Object rowId = table.getValue();
				if (rowId != null)
				{
					Long id  = (Long) table.getContainerProperty(rowId, "id").getValue();
					userService.remove(id);
					table.removeItem(rowId);
				}
			}
		});
		return button;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}

	private void fillTableContainer(BeanItemContainer<User> container, int count) {
		List<User> users = userService.getUsers();

		for (User user : users) {
			container.addItem(user);
		}
	}
}
