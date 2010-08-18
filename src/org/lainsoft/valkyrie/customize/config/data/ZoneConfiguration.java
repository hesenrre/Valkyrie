/**
 * ZoneConfiguration.java is part of Forge Project.
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
import java.util.Map;
import java.util.TreeMap;

/**
 * Bean that represents a zone configuration
 */ 
public class ZoneConfiguration{
    
    private Map zones;
    private Map portlets;
    
    public ZoneConfiguration (Map zones, Map portlets){
        this.zones = zones;
        this.portlets = portlets;
    }

    public ZoneConfiguration (){
        zones = new TreeMap();
        portlets = new TreeMap();
    }

    public List
    getPortlets(){
        return new ArrayList(portlets.values());
    }
    
    public void
    addPortlet (Portlet portlet){
        portlets.put(portlet.getName(),portlet);
    }

    public List
    getZones(){
        return new ArrayList(zones.values());
    }
    
    public void
    addZone(Zone zone){
        zones.put(zone.getName(),zone);
    }

    public Zone
    getZone(String name){
        return zones.containsKey(name) ? (Zone)zones.get(name) : new Zone();
    }
    
    public List
    getPortletsFor(String zone){
        List portletNames = getZone(zone).getPortlets();
        ArrayList portlets = new ArrayList();
        for (int i=0; i<portletNames.size();i++){
            Portlet temp;
            if (!(temp = getPortlet(portletNames.get(i).toString())).isEmpty()){
                portlets.add(temp);
            }
        }
        return portlets;
    }

    public Portlet
    getPortlet(String name){
        return portlets.containsKey(name) ? (Portlet)portlets.get(name) : new Portlet();
    }

    public boolean
    portletBelongsToZone (String zone, String portlet){
        return getZone(zone).containsPortlet(portlet);
    }
    
    public String 
    toString (){
        return "ZoneConfiguration [zones="+zones+", portlets="+portlets+"]";
    }
    

}
