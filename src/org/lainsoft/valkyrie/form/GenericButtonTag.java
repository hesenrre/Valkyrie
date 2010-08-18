/**
 * ButtonTag.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Israel Buitron
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.valkyrie.form;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagLibrary represeting an abstract generic button tag.
 */
public abstract class GenericButtonTag extends GenericInputTag {

    /**
     * <code>disabled</code> tag attribute.
     */
    private String disabled;

    /**
     * <code>checked</code> tag attribute.
     */
    private String checked;    
    

    /**
     * Gets <code>disabled</code> tag attribute.
     * @return <code>disabled</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getDisabled(){
        return disabled;
    }

    /** 
     * Sets <code>disabled</code> tag attribute.
     * @param disabled New <i>disabled</i> attribute value.
     */
    public void setDisabled(String disabled) {
	boolean d = (new Boolean(disabled)).booleanValue();
        this.disabled = !d ? "" : Boolean.toString(d);
    }


    /**
     * Gets <code>checked</code> tag attribute.
     * @return <code>checked</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getChecked(){
        return checked;
    }

    /** 
     * Sets <code>checked</code> tag attribute.
     * @param checked New <i>checked</i> attribute value.
     */
    public void setChecked(boolean checked) {
	boolean c = (new Boolean(checked)).booleanValue();
        this.checked = !c ? "" : Boolean.toString(c);
    }


    /**
     * Gets all attributes and their values.
     * If one attribute is not valued (null ore empty) it is not 
     * included in the list.
     * @return <code>String</code> with all valued attributes.
     */
    public String getModifiers() {
	return super.getModifiers() + 
	    (isEmpty(disabled) ? "": "disabled ") +
	    (isEmpty(checked) ? "": "checked ");
    }
}
