// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.example.rapid.web.ui;

import com.example.rapid.domain.Project;
import com.example.rapid.web.ui.ProjectForm;
import com.vaadin.addon.beanvalidation.BeanValidationValidator;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Validator;
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

privileged aspect ProjectForm_Roo_VaadinVisuallyComposableEntityForm {
    
    private Map<Object, Field> ProjectForm.fieldMap = new LinkedHashMap<Object, Field>();
    
    private Map<Object, PropertyConverter> ProjectForm.converterMap = new LinkedHashMap<Object, PropertyConverter>();
    
    public Collection<Object> ProjectForm.getBeanPropertyIds() {
        return Arrays.asList(new Object[] { "name", "enabled" });
    }
    
    public Field ProjectForm.getField(Object propertyId) {
        return fieldMap.get(propertyId);
    }
    
    public void ProjectForm.configure() {
        configureFieldMap();
        configureFields();
        configureContainersForFields();
        configureConverters();
        configureValidators();
    }
    
    public void ProjectForm.refresh() {
        configureContainersForFields();
        configureConverters();
        configureValidators();
    }
    
    public boolean ProjectForm.isModified() {
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
    
    public void ProjectForm.configureFieldMap() {
        fieldMap.put("name", nameField);
        fieldMap.put("enabled", enabledField);
    }
    
    public void ProjectForm.configureFields() {
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
    
    public void ProjectForm.configureContainersForFields() {
        // no fields require special containers
    }
    
    public void ProjectForm.configureConverters() {
        // no converters needed
    }
    
    public void ProjectForm.configureValidators() {
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
    
    public PropertyConverter ProjectForm.getConverter(Object propertyId) {
        return converterMap.get(propertyId);
    }
    
    public String ProjectForm.getIdProperty() {
        return "id";
    }
    
    public String ProjectForm.getVersionProperty() {
        return "version";
    }
    
    public void ProjectForm.validateFields() {
        if (getItemDataSource() != null) {
            for (Object propertyId : getItemDataSource().getItemPropertyIds()) {
                Field field = getField(propertyId);
                if (field != null && !field.isReadOnly()) {
                    field.validate();
                }
            }
        }
    }
    
    public void ProjectForm.commitFields() {
        if (getItemDataSource() != null) {
            for (Object propertyId : getItemDataSource().getItemPropertyIds()) {
                Field field = getField(propertyId);
                if (field != null && !field.isReadOnly()) {
                    field.commit();
                }
            }
        }
    }
    
    public void ProjectForm.setFieldPropertyDataSource(Object propertyId, Property property) {
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
    
    public void ProjectForm.setFieldValues(Item item) {
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
    
    public Field ProjectForm.getFirstField() {
        Iterator<Object> it = getBeanPropertyIds().iterator();
        if (it.hasNext()) {
            return getField(it.next());
        }
        return null;
    }
    
    public Class<Project> ProjectForm.getEntityClass() {
        return Project.class;
    }
    
}
