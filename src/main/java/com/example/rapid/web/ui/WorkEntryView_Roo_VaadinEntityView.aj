// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.example.rapid.web.ui;

import com.example.rapid.domain.WorkEntry;
import com.example.rapid.web.EntityProviderUtil;
import com.example.rapid.web.EntityTableColumnGenerator;
import com.example.rapid.web.ui.WorkEntryView;
import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.data.Item;
import com.vaadin.ui.Table;
import java.util.List;

privileged aspect WorkEntryView_Roo_VaadinEntityView {
    
    private JPAContainer<WorkEntry> WorkEntryView.tableContainer;
    
    public String WorkEntryView.getEntityName() {
        return "Work Entry";
    }
    
    public Class<WorkEntry> WorkEntryView.getEntityClass() {
        return WorkEntry.class;
    }
    
    public boolean WorkEntryView.isCreateAllowed() {
        return true;
    }
    
    public boolean WorkEntryView.isUpdateAllowed() {
        return true;
    }
    
    public boolean WorkEntryView.isDeleteAllowed() {
        return true;
    }
    
    public List<WorkEntry> WorkEntryView.listEntities() {
        List<WorkEntry> list = WorkEntry.findAllWorkEntrys();
        return list;
    }
    
    public WorkEntry WorkEntryView.saveEntity(WorkEntry entity) {
        if (entity == null) {
            return null;
        }
        return (WorkEntry) entity.merge();
    }
    
    public void WorkEntryView.deleteEntity(WorkEntry entity) {
        if (entity != null) {
            entity.remove();
        }
    }
    
    public boolean WorkEntryView.isNewEntity(WorkEntry entity) {
        return (entity != null && getIdForEntity(entity) == null);
    }
    
    public String WorkEntryView.getIdProperty() {
        return "id";
    }
    
    public String WorkEntryView.getVersionProperty() {
        return "version";
    }
    
    public WorkEntry WorkEntryView.createEntityInstance() {
        return new WorkEntry();
    }
    
    public JPAContainer<WorkEntry> WorkEntryView.getTableContainer() {
        if (tableContainer == null) {
            JPAContainer<WorkEntry> container = new JPAContainer<WorkEntry>(WorkEntry.class);
            container.setEntityProvider(EntityProviderUtil.get().getEntityProvider(WorkEntry.class));
            tableContainer = container;
        }
        return tableContainer;
    }
    
    public Item WorkEntryView.getItemForEntity(WorkEntry entity) {
        Item item = getTable().getItem(entity.getId());
        if (item == null) {
            item = tableContainer.createEntityItem(entity);
        }
        return item;
    }
    
    public WorkEntry WorkEntryView.getEntityForItem(Item item) {
        if (item instanceof EntityItem && ((EntityItem) item).getEntity() instanceof WorkEntry) {
            return (WorkEntry) ((EntityItem) item).getEntity();
        } else {
            return null;
        }
    }
    
    public Object WorkEntryView.getIdForEntity(WorkEntry entity) {
        return entity != null ? entity.getId() : null;
    }
    
    public void WorkEntryView.setupGeneratedColumns(Table table) {
        table.removeGeneratedColumn("project");
        table.addGeneratedColumn("project", new EntityTableColumnGenerator((String) getProjectCaptionPropertyId()));
        table.removeGeneratedColumn("employee");
        table.addGeneratedColumn("employee", new EntityTableColumnGenerator((String) getRapidUserCaptionPropertyId()));
    }
    
    public Object WorkEntryView.getProjectCaptionPropertyId() {
        return "name";
    }
    
    public Object WorkEntryView.getRapidUserCaptionPropertyId() {
        return null;
    }
    
}
