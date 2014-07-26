// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.example.rapid.web.ui;

import com.example.rapid.domain.Project;
import com.example.rapid.domain.RapidUser;
import com.example.rapid.domain.WorkEntry;
import com.example.rapid.web.EntityProviderUtil;
import com.example.rapid.web.ui.WorkEntryForm;
import com.vaadin.addon.beanvalidation.BeanValidationValidator;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Validator;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.vaadin.addon.customfield.ConvertingValidator;
import org.vaadin.addon.customfield.PropertyConverter;
import org.vaadin.addon.customfield.beanfield.BeanFieldPropertyConverter;

privileged aspect WorkEntryForm_Roo_VaadinVisuallyComposableEntityForm {
    
    private Map<Object, Field> WorkEntryForm.fieldMap = new LinkedHashMap<Object, Field>();
    
    private Map<Object, PropertyConverter> WorkEntryForm.converterMap = new LinkedHashMap<Object, PropertyConverter>();
    
    private JPAContainer<Project> WorkEntryForm.containerForProjects;
    
    private JPAContainer<RapidUser> WorkEntryForm.containerForRapidUsers;
    
    public Collection<Object> WorkEntryForm.getBeanPropertyIds() {
        return Arrays.asList(new Object[] { "comment", "project", "employee", "startTime" });
    }
    
    public Field WorkEntryForm.getField(Object propertyId) {
        return fieldMap.get(propertyId);
    }
    
    public void WorkEntryForm.configure() {
        configureFieldMap();
        configureFields();
        configureContainersForFields();
        configureConverters();
        configureValidators();
    }
    
    public void WorkEntryForm.refresh() {
        configureContainersForFields();
        configureConverters();
        configureValidators();
    }
    
    public boolean WorkEntryForm.isModified() {
        if (getItemDataSource() != null) {
            for (Object propertyId : getItemDataSource().getItemPropertyIds()) {
                Field field = getField(propertyId);
                if (field != null && field.isModified()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void WorkEntryForm.configureFieldMap() {
        fieldMap.put("comment", commentField);
        fieldMap.put("project", projectField);
        fieldMap.put("employee", employeeField);
        fieldMap.put("startTime", startTimeField);
    }
    
    public void WorkEntryForm.configureFields() {
        for (Object propertyId : getBeanPropertyIds()) {
            Field field = getField(propertyId);
            if (field == null) {
                continue;
            }
            if (field instanceof TextField) {
                ((TextField) field).setNullRepresentation("");
            }
            field.setWriteThrough(false);
            field.setInvalidAllowed(true);
        }
    }
    
    public void WorkEntryForm.configureContainersForFields() {
        Field field;
        
        field = getField("project");
        if (field instanceof AbstractSelect) {
            ((AbstractSelect) field).setContainerDataSource(getContainerForProjects());
            Object captionId = getProjectCaptionPropertyId();
            if (captionId != null) {
                ((AbstractSelect) field).setItemCaptionPropertyId(captionId);
            } else {
                ((AbstractSelect) field).setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_ITEM);
            }
        }
        
        field = getField("employee");
        if (field instanceof AbstractSelect) {
            ((AbstractSelect) field).setContainerDataSource(getContainerForRapidUsers());
            Object captionId = getRapidUserCaptionPropertyId();
            if (captionId != null) {
                ((AbstractSelect) field).setItemCaptionPropertyId(captionId);
            } else {
                ((AbstractSelect) field).setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_ITEM);
            }
        }
    }
    
    public void WorkEntryForm.configureConverters() {
        // cannot parametrize PropertyConverter here due to an AJDT bug
        PropertyConverter converter;
        Container container;
        Field field;
        
        field = getField("project");
        if (field instanceof AbstractSelect) {
            container = ((AbstractSelect) field).getContainerDataSource();
            converter = new BeanFieldPropertyConverter<Project, Long>(Project.class, container, "Id");
            converterMap.put("project", converter);
        }
        
        field = getField("employee");
        if (field instanceof AbstractSelect) {
            container = ((AbstractSelect) field).getContainerDataSource();
            converter = new BeanFieldPropertyConverter<RapidUser, Long>(RapidUser.class, container, "Id");
            converterMap.put("employee", converter);
        }
    }
    
    public void WorkEntryForm.configureValidators() {
        for (Object propertyId : getBeanPropertyIds()) {
            Field field = getField(propertyId);
            if (field != null) {
                Collection<Validator> validators = field.getValidators();
                if (validators != null) {
                    for (Validator validator : new ArrayList<Validator>(field.getValidators())) {
                        if (validator instanceof BeanValidationValidator || validator instanceof ConvertingValidator) {
                            field.removeValidator(validator);
                        }
                    }
                }
                BeanValidationValidator validator = new BeanValidationValidator(getEntityClass(), String.valueOf(propertyId));
                if (validator.isRequired()) {
                    field.setRequired(true);
                    field.setRequiredError(validator.getRequiredMessage());
                }
                PropertyConverter converter = getConverter(propertyId);
                if (converter == null) {
                    field.addValidator(validator);
                } else {
                    field.addValidator(new ConvertingValidator(validator, converter));
                }
            }
        }
    }
    
    public PropertyConverter WorkEntryForm.getConverter(Object propertyId) {
        return converterMap.get(propertyId);
    }
    
    public JPAContainer<Project> WorkEntryForm.getContainerForProjects() {
        if (containerForProjects == null) {
            JPAContainer<Project> container = new JPAContainer<Project>(Project.class);
            container.setEntityProvider(EntityProviderUtil.get().getEntityProvider(Project.class));
            containerForProjects = container;
        }
        return containerForProjects;
    }
    
    public JPAContainer<RapidUser> WorkEntryForm.getContainerForRapidUsers() {
        if (containerForRapidUsers == null) {
            JPAContainer<RapidUser> container = new JPAContainer<RapidUser>(RapidUser.class);
            container.setEntityProvider(EntityProviderUtil.get().getEntityProvider(RapidUser.class));
            containerForRapidUsers = container;
        }
        return containerForRapidUsers;
    }
    
    public Object WorkEntryForm.getProjectCaptionPropertyId() {
        return "name";
    }
    
    public Object WorkEntryForm.getRapidUserCaptionPropertyId() {
        return null;
    }
    
    public String WorkEntryForm.getIdProperty() {
        return "id";
    }
    
    public String WorkEntryForm.getVersionProperty() {
        return "version";
    }
    
    public void WorkEntryForm.validateFields() {
        if (getItemDataSource() != null) {
            for (Object propertyId : getItemDataSource().getItemPropertyIds()) {
                Field field = getField(propertyId);
                if (field != null && !field.isReadOnly()) {
                    field.validate();
                }
            }
        }
    }
    
    public void WorkEntryForm.commitFields() {
        if (getItemDataSource() != null) {
            for (Object propertyId : getItemDataSource().getItemPropertyIds()) {
                Field field = getField(propertyId);
                if (field != null && !field.isReadOnly()) {
                    field.commit();
                }
            }
        }
    }
    
    public void WorkEntryForm.setFieldPropertyDataSource(Object propertyId, Property property) {
        Field field = getField(propertyId);
        if (field == null) {
            return;
        }
        if (property == null) {
            field.setPropertyDataSource(null);
        } else {
            PropertyConverter converter = getConverter(propertyId);
            if (converter != null) {
                converter.setPropertyDataSource(property);
                field.setPropertyDataSource(converter);
            } else {
                if (field instanceof CheckBox && property.getValue() == null) {
                    property.setValue(Boolean.FALSE);
                }
                field.setPropertyDataSource(property);
            }
        }
    }
    
    public void WorkEntryForm.setFieldValues(Item item) {
        if (item != null) {
            // set values for fields in item
            for (Object propertyId : item.getItemPropertyIds()) {
                setFieldPropertyDataSource(propertyId, item.getItemProperty(propertyId));
            }
            // other fields are not touched by default
        } else {
            // reset all fields
            for (Object propertyId : getBeanPropertyIds()) {
                setFieldPropertyDataSource(propertyId, null);
            }
        }
    }
    
    public Field WorkEntryForm.getFirstField() {
        Iterator<Object> it = getBeanPropertyIds().iterator();
        if (it.hasNext()) {
            return getField(it.next());
        }
        return null;
    }
    
    public Class<WorkEntry> WorkEntryForm.getEntityClass() {
        return WorkEntry.class;
    }
    
}
