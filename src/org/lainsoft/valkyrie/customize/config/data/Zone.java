/**
 * Zone.java is part of Forge Project.
 *
 * Copyright 2004, 2005 LainSoft Foundation, Demetrio Cruz
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
*/
package org.lainsoft.valkyrie.customize.config.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean that represents a zone, in the configuration file.
 */
public class Zone{
    
    private String name;
    private List portlets;
    
    public Zone (String name, List portlets){
        this.name=name;
        this.portlets=portlets;
    }
    
    public Zone(){
        name="";
        portlets = new ArrayList();
    }
    
    public String
    getName(){
        return name;
    }

    public List
    getPortlets(){
        return portlets;
    }

    public void
    setName(String name){
        this.name=name;
    }

    public void
    addPortlet(String portlet){
        portlets.add (portlet);
    }
    
    public boolean
    containsPortlet(String portlet){
        return portlets.contains(portlet);
    }

    public String
    toString(){
        return "Zone [name="+name+", portlets="+portlets+"]";
    }
}
