package com.example.rapid.web.ui;

import com.example.rapid.domain.Project;
import com.example.rapid.web.AbstractEntityView;
import com.example.rapid.web.EntityEditor;
import com.example.rapid.web.EntityProviderUtil;
import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.data.Item;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;

//@RooVaadinEntityView(formBackingObject = com.example.rapid.domain.Project.class)
public class ProjectView extends
		AbstractEntityView<com.example.rapid.domain.Project> implements View{

	private JPAContainer<Project> tableContainer;

	public ProjectView() {
	}
	
	@Override
	protected EntityEditor createForm() {
		return new ProjectForm();
	}

	@Override
	protected void configureTable(Table table) {
		table.setContainerDataSource(getTableContainer());
		table.setVisibleColumns(getTableColumns());

		setupGeneratedColumns(table);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	protected Class<? extends Project> getEntityClass() {
		return Project.class;
	}

	@Override
	protected String getEntityName() {
		return "Project";
	}

	@Override
	public boolean isCreateAllowed() {
		return true;
	}

	@Override
	protected boolean isUpdateAllowed() {
		return true;
	}

	@Override
	protected boolean isDeleteAllowed() {
		return true;
	}

	@Override
	protected boolean isNewEntity(Project entity) {
		return (entity != null && getIdForEntity(entity) == null);
	}

	@Override
	protected void deleteEntity(Project entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			// entity.remove();
		}
	}

	@Override
	protected Project saveEntity(Project entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getIdProperty() {
		return "id";
	}

	@Override
	public Object getVersionProperty() {
		return "version";
	}

	public JPAContainer<Project> getTableContainer() {
		if (tableContainer == null) {
			JPAContainer<Project> container = new JPAContainer<Project>(
					Project.class);
			container.setEntityProvider(EntityProviderUtil.get()
					.getEntityProvider(Project.class));
			tableContainer = container;
		}
		return tableContainer;
	}

	public void setupGeneratedColumns(Table table) {
		// Add generated columns here
	}

	public Item getItemForEntity(Project entity) {
		Item item = getTable().getItem(entity.getId());
		if (item == null) {
			item = tableContainer.createEntityItem(entity);
		}
		return item;
	}

	@Override
	protected Project getEntityForItem(Item item) {
		if (item instanceof EntityItem
				&& ((EntityItem) item).getEntity() instanceof Project) {
			return (Project) ((EntityItem) item).getEntity();
		} else {
			return null;
		}
	}

	@Override
	public Object getIdForEntity(Project entity) {
		return entity != null ? entity.getId() : null;
	}

	@Override
	protected Project createEntityInstance() {
		return new Project();
	}

}
