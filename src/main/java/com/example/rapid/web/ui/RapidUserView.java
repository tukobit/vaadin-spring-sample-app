package com.example.rapid.web.ui;

import com.example.rapid.domain.RapidUser;
import com.example.rapid.web.AbstractEntityView;
import com.example.rapid.web.EntityEditor;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;

public class RapidUserView extends AbstractEntityView<com.example.rapid.domain.RapidUser> {

    @Override
    protected EntityEditor createForm() {
        return new RapidUserForm();
    }

    @Override
    protected void configureTable(Table table) {
        table.setContainerDataSource(getTableContainer());
        table.setVisibleColumns(getTableColumns());
        //TODO : Setup Generated Column
//        setupGeneratedColumns(table);
    }

	@Override
	protected Class<? extends RapidUser> getEntityClass() {
		return RapidUser.class;
	}

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "RapidUser";
	}

	@Override
	public boolean isCreateAllowed() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean isUpdateAllowed() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean isDeleteAllowed() {
		return true;
	}

	@Override
	protected boolean isNewEntity(RapidUser entity) {
		return false;
	}

	@Override
	protected void deleteEntity(RapidUser entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected RapidUser saveEntity(RapidUser entity) {
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
	protected Item getItemForEntity(RapidUser entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RapidUser getEntityForItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getIdForEntity(RapidUser entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RapidUser createEntityInstance() {
		return new RapidUser();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
