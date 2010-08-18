/**
 * Portlet.java is part of Forge Project.
 *
 * Copyright 2004,2005 LainSoft Foundation, Demetrio Cruz
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
*/
package org.lainsoft.valkyrie.customize.config.data;


/**
 * Bean that represents a protlet, in the configuration file.
 */
public class Portlet{

    private String name;
    private String uri;
    private String desc;
    private boolean enabled;


    public Portlet (){
        name = "";
        uri = "";
        desc = "";
        enabled = false;
    }

    public Portlet(String name, String uri, String desc, boolean enabled){
        this.name = name;
        this.uri = uri;
        this.desc = desc;
        this.enabled = enabled;
    }
    
    public String
    getName(){
        return name;
    }

    public String
    getUri(){
        return uri;
    }

    public String
    getDesc(){
        return desc;
    }

    public boolean
    getEnabled(){
        return enabled;
    }

    public void
    setName(String name){
        this.name=name;
    }

    public void
    setUri(String uri){
        this.uri=uri;
    }

    public void
    setDesc(String desc){
        this.desc=desc;
    }

    public void
    setEnabled(boolean enabled){
        this.enabled=enabled;
    }
    
    public String
    toString(){
        return "Portlet[name="+name+",uri="+uri+",desc="+desc+",enabled="+enabled+"]";
    }

    public boolean
    isEmpty(){
        return name==null || name.trim().equals("");
    }
}
