package com.example.rapid.web.ui;

import com.example.rapid.domain.WorkEntry;
import com.example.rapid.web.AbstractEntityView;
import com.example.rapid.web.EntityEditor;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;

public class WorkEntryView extends AbstractEntityView<com.example.rapid.domain.WorkEntry> {

    @Override
    protected EntityEditor createForm() {
        return new WorkEntryForm();
    }

    @Override
    protected void configureTable(Table table) {
        table.setContainerDataSource(getTableContainer());
        table.setVisibleColumns(getTableColumns());
//        TODO
//        setupGeneratedColumns(table);
    }

	@Override
	protected Class<? extends WorkEntry> getEntityClass() {
		// TODO Auto-generated method stub
		return WorkEntry.class;
	}

	@Override
	protected String getEntityName() {
		return "WorkEntry";
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
	protected boolean isNewEntity(WorkEntry entity) {
		return true;
	}

	@Override
	protected void deleteEntity(WorkEntry entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WorkEntry saveEntity(WorkEntry entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getIdProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getVersionProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Container getTableContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Item getItemForEntity(WorkEntry entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WorkEntry getEntityForItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getIdForEntity(WorkEntry entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WorkEntry createEntityInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
