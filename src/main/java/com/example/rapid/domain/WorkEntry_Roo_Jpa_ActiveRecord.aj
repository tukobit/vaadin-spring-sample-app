// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.example.rapid.domain;

import com.example.rapid.domain.WorkEntry;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect WorkEntry_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager WorkEntry.entityManager;
    
    public static final List<String> WorkEntry.fieldNames4OrderClauseFilter = java.util.Arrays.asList("comment", "project", "employee", "startTime");
    
    public static final EntityManager WorkEntry.entityManager() {
        EntityManager em = new WorkEntry().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long WorkEntry.countWorkEntrys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM WorkEntry o", Long.class).getSingleResult();
    }
    
    public static List<WorkEntry> WorkEntry.findAllWorkEntrys() {
        return entityManager().createQuery("SELECT o FROM WorkEntry o", WorkEntry.class).getResultList();
    }
    
    public static List<WorkEntry> WorkEntry.findAllWorkEntrys(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM WorkEntry o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, WorkEntry.class).getResultList();
    }
    
    public static WorkEntry WorkEntry.findWorkEntry(Long id) {
        if (id == null) return null;
        return entityManager().find(WorkEntry.class, id);
    }
    
    public static List<WorkEntry> WorkEntry.findWorkEntryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM WorkEntry o", WorkEntry.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<WorkEntry> WorkEntry.findWorkEntryEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM WorkEntry o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, WorkEntry.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void WorkEntry.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void WorkEntry.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            WorkEntry attached = WorkEntry.findWorkEntry(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void WorkEntry.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void WorkEntry.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public WorkEntry WorkEntry.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        WorkEntry merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}