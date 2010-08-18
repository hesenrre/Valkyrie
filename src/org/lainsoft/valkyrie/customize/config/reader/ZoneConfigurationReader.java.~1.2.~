/**
 * ZoneConfigurationReader.java is part of Forge Project.
 *
 * Copyright 2004,2005 LainSoft Foundation, Demetrio Cruz
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
*/

package org.lainsoft.forge.view.customize.config.reader;

import org.lainsoft.forge.persistance.io.reader.XMLBeanReader;
import org.lainsoft.forge.view.customize.config.data.ZoneConfiguration;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.File;
import org.xml.sax.SAXException;

/**
 * Configuration reader for zones and portlets
 */
public class ZoneConfigurationReader{
    
    private XMLBeanReader internalReader;
    private static long filedate = 0;
    private static String fileName="";
    private static ZoneConfiguration cachedZoneConfig;
    private static ZoneConfigurationReader reader;


    private ZoneConfigurationReader(){
        internalReader=XMLBeanReader.getInstance();
    }
    
    /**
     * Retrives an instance of the <code>ZoneConfigurationReader</code>.
     */
    public static ZoneConfigurationReader
    getInstance (){
        if (reader == null)
            reader = new ZoneConfigurationReader ();
        return reader;
    }
    
    /**
     * Read the configuration of the specified xml.
     * @param filename the name of the configuration file.
     * @return a bean that represents the configuration readed.
     */
    public ZoneConfiguration
    read(String filename){
        if (filename==null || !filename.toLowerCase().matches(".+\\.xml"))
            return new ZoneConfiguration();
        
        long lastModified = (new File (filename)).lastModified();
        if (!fileName.equals(filename) || (lastModified != filedate)){
            fileName = fileName.equals(filename)?fileName:filename;
            filedate = lastModified;
            cachedZoneConfig = internalRead(filename);
        }
        return cachedZoneConfig;
    }
    
    private ZoneConfiguration
    internalRead(String filename){
        try {
            return (ZoneConfiguration) internalReader.read(filename, ZoneConfiguration.class);
        }catch (IntrospectionException ie){
            System.out.println ("IntrospectionException while reading "+filename);
            ie.printStackTrace();
        }catch (IOException ioe){
            System.out.println ("IOException while reading "+filename);
            ioe.printStackTrace ();
        }catch (SAXException saxe){
            System.out.println ("SAXException while reading "+filename);
            saxe.printStackTrace();
        }
        return new ZoneConfiguration();
    }
}
