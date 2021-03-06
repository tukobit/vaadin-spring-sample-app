// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.example.rapid.domain;

import com.example.rapid.domain.RapidUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect RapidUser_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager RapidUser.entityManager;
    
    public static final List<String> RapidUser.fieldNames4OrderClauseFilter = java.util.Arrays.asList("username", "password", "admin");
    
    public static final EntityManager RapidUser.entityManager() {
        EntityManager em = new RapidUser().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long RapidUser.countRapidUsers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM RapidUser o", Long.class).getSingleResult();
    }
    
    public static List<RapidUser> RapidUser.findAllRapidUsers() {
        return entityManager().createQuery("SELECT o FROM RapidUser o", RapidUser.class).getResultList();
    }
    
    public static List<RapidUser> RapidUser.findAllRapidUsers(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM RapidUser o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, RapidUser.class).getResultList();
    }
    
    public static RapidUser RapidUser.findRapidUser(Long id) {
        if (id == null) return null;
        return entityManager().find(RapidUser.class, id);
    }
    
    public static List<RapidUser> RapidUser.findRapidUserEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM RapidUser o", RapidUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<RapidUser> RapidUser.findRapidUserEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM RapidUser o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, RapidUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void RapidUser.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void RapidUser.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            RapidUser attached = RapidUser.findRapidUser(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void RapidUser.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void RapidUser.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public RapidUser RapidUser.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        RapidUser merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
