package org.opennms.netmgt.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.opennms.netmgt.provision.persist.OnmsForeignSource;

@XmlRootElement(name="requisitions")
public class OnmsForeignSourceCollection extends LinkedList<OnmsForeignSource> {

	private static final long serialVersionUID = 1L;

	public OnmsForeignSourceCollection() {
        super();
    }

    public OnmsForeignSourceCollection(Collection<? extends OnmsForeignSource> c) {
        super(c);
    }

    @XmlElement(name="onmsForeignSource")
    public List<OnmsForeignSource> getForeignSources() {
        return this;
    }

    public void setForeignSources(List<OnmsForeignSource> foreignSources) {
        clear();
        addAll(foreignSources);
    }
    
    @XmlAttribute(name="count")
    public Integer getCount() {
    	return this.size();
    }
}

