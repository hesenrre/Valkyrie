/**
 * Select_Tag_From_Collection.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Israel Buitron
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.forge.view.form;

import java.util.Arrays;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.security.InvalidParameterException;

/**
 * TagLibrary represeting an input select_tag.
 *
 * @jsp.tag  name="select_tag_from_collection"
 *           description="Select tag."
 */
public class Select_Tag_From_Collection extends GenericTag {

    private static int ATTRIBUTE = 0;
    private static int COLLECTION = 1;

    /**
     * <i>Disable</i> tag attribute value.
     */
    private String disabled;

    /**
     * <i>Multiple</i> tag attribute value.
     */
    private String multiple;

    /**
     * <i>Size</i> tag attribute value.
     */
    private String size;

    /**
     * <i>Collection</i> tag attribute value.
     */
    private String collection;


    /**
     * Gets the <i>disabled</i> tag attribute value.
     * @return <code>disabled</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getDisabled(){
        return disabled;
    }

    /**
     * Sets the <i>disabled</i> tag attribute value.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param disabled New <i>disabled</i> tag attribute value.
     */
    public void setDisabled(String disabled){
	boolean d = (new Boolean(disabled)).booleanValue();
        this.disabled = !d ? "" : Boolean.toString(d) ;
    }


    /**
     * Gets the <i>multiple</i> tag attribute value.
     * @return <code>multiple</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getMultiple(){
        return multiple;
    }

    /**
     * Sets the <i>multiple</i> tag attribute value.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param multiple New <i>multiple</i> tag attribute value.
     */
    public void setMultiple(String multiple){
	boolean m = (new Boolean(multiple)).booleanValue();
        this.multiple = !m ? "" : Boolean.toString(m) ;
    }


    /**
     * Gets the <i>size</i> tag attribute value.
     * @return <code>size</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getSize() {
	return this.size;
    }

    /**
     * Sets the <i>size</i> tag attribute value.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param size New <i>size</i> tag attribute value.
     */
    public void setSize(String size) {
	try {
	    int i = (new Integer(size)).intValue();
	    this.size = (i>=0 ? Integer.toString(i) : "");
	} catch(NumberFormatException e) {
	    this.size = "";
	}
    }


    /**
     * Gets the <i>collection</i> tag attribute value.
     * @return <code>collection</code> tag attribute value.
     * @jsp.attribute   required="true"
     *               rtexprvalue="true"
     */
    public String getCollection() {
	return this.collection;
    }

    /**
     * Sets the <i>collection</i> tag attribute value.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param collection New <i>collection</i> tag attribute value.
     */
    public void setCollection(String collection) {
	this.collection = collection;
    }

    /**
     * Takes a <code>Map</code> and builds a <code>String</code> with 
     * this format <i>[key1 => value1, key2 => value2, ... , keyn => 
     * valuen ]</i>.
     * @param map Collection which contains objects to list.
     * @return A formatted <code>String</code> representating the 
     *         <code>Map</code>.
     */
    protected String getList(Map map) {
        System.out.println("map for getList(Map)>"+map+"]");
	if(map==null)
	    return "[]";

	String resp="[";

	Iterator iter = map.keySet().iterator();
	while(iter.hasNext()) {
	    Object key = iter.next();
	    Object value = map.get(key);

	    resp += ( (key==null ? "" : key.toString()) + "=>" + 
		      (value==null ? "" : value.toString()) +
		      (iter.hasNext() ? "," : "" ) );
	}
        
        System.out.println("List from map>"+resp+"]");

	return resp += "]";
    }

    /**
     * Takes a <code>List</code> and builds a <code>String</code> with 
     * this format <i>[key1 => value1, key2 => value2, ... , keyn => 
     * valuen ]</i>.
     * @param list Collection which contains objects to list.
     * @return A formatted <code>String</code> representating the 
     *         <code>List</code>.
     */
    protected String getList(List list) {
	if(list==null)
	    return "[]";

	String resp = "[";

	Iterator iter = list.iterator();
	while(iter.hasNext()) {
	    Object value = iter.next();

	    resp += ( list.indexOf(value) + "=>" + 
		      (value==null ? "" : value.toString()) +
		      (iter.hasNext() ? "," : "" ) );
	}

	return resp += "]";
    }

    /**
     * Gets all attributes and their values.
     * If one attribute is not valued (null ore empty) it is not 
     * included in the list.
     * @return <code>String</code> with all valued attributes.
     */
    protected String getModifiers() {
	return super.getModifiers() +
	    (isEmpty(disabled) ? "" : "disabled ") +
	    (isEmpty(multiple) ? "" : "multiple ") +
	    (isEmpty(size)     ? "" : "size=\'" + size + "\' ");
    }

    /**
     * Checks a <code>String</code> and demermines if it represents
     * an attribute name or a formatted <code>String</code> list.
     * @param str <code>String</code> to check.
     * @return 0 if <code>String</code> is an attribute name or 1 
     *         if is a formatte list.
     * @throws InvalidParameterException If <code>String</code> is 
     *         not an attribute name neither a formetted list.
     */
    public static int evalueString(String str) throws InvalidParameterException {
	int evaluation;
	String[] tokens = str.split(",");
        
        System.out.println("tokens>'"+Arrays.asList(tokens)+"' size="+tokens.length);
	if(tokens.length==1) {
	    String[] subtokens = tokens[0].trim().split("=>");
            System.out.println("sub tokens>"+Arrays.asList(subtokens));
	    if(subtokens.length>2 || subtokens.length==0){
                System.out.println("to throwing first exception");

		throw new InvalidParameterException("Must be a list or an attribute.");
            }

	    evaluation = subtokens.length==1 ? ATTRIBUTE : COLLECTION;
	} else {
            for(int i=0; i<tokens.length; i++) {
		String[] subtokens = tokens[i].trim().split("=>");
                System.out.println("sub tokens>"+Arrays.asList(subtokens));
		if(subtokens.length!=2){
                    System.out.println("to throwing second exception");
		    throw new InvalidParameterException("Must be a list or an attribute.");
                }
	    }
	    evaluation = COLLECTION;
	}

	return evaluation;
    }

    /**
     * Builds the option HTML tags list from a formatted list.
     * @param formattedList <code>String</code> with all list 
     *        elements for build options HTML tags.
     * @return Option HTML tags list.
     */
    protected String buildOptionsFromList(String formattedList) {
	String formatted = "";
	formattedList = formattedList.substring(formattedList.indexOf("[")+1,
						formattedList.lastIndexOf("]"));

	if(evalueString(formattedList)==COLLECTION) {
	    String[] tokens = formattedList.split(",");
	    for(int i=0; i<tokens.length; i++) {
		String[] subtokens = tokens[i].trim().split("=>");
		formatted += ("<option value=\'" + subtokens[0].trim() + 
			      "\'>" + subtokens[1].trim() + "</option>");
	    }
	}

	return formatted;
    }


    /**
     * Builds the option HTML tags list from a collection.
     * @param collection <code>Collection</code> with all elements for 
     *        build options HTML tags.
     * @return Option HTML tags list.
     */
    protected String buildOptionsFromCollection(Object collection) {
	String formatted = "";

	if(collection==null)
	    return formatted;

	if(collection instanceof Map) {
	    formatted = buildOptionsFromList(getList((Map)collection));
	} else if(collection instanceof List) {
	    formatted = buildOptionsFromList(getList((List)collection));
	}

	return formatted;
    }

    /**
     * Finds a collection in the <code>HttpRequest</code>, <code>
     * HttpSession</code> or <code>ServletContext</code>.
     * @param collection <code>Collection</code> name.
     * @return If empty name returns or if collection not found in 
     *         those places <code>null</code>, otherwise the found 
     *         <code>Collection</code>.
     */
    protected Object searchCollection(String collection) {
	if(isEmpty(collection))
	    return null;

	Object collect_obj = (collect_obj = pageContext.getRequest().getAttribute(collection))==null ? 
	    ( (collect_obj = pageContext.getSession().getAttribute(collection))==null ? 
	      pageContext.getServletContext().getAttribute(collection) : collect_obj ) : 
	    collect_obj ;

	return collect_obj;
    }

    public int doStartTag(){
        JspWriter writer = pageContext.getOut();
	String optionList = "";
        System.out.println("name>"+getName()+" collection>"+getCollection());

        try{
	    if(evalueString(getCollection())==COLLECTION){
                System.out.println("building from collection");

		optionList = buildOptionsFromList(getCollection());
            }else if(evalueString(getCollection())==ATTRIBUTE){
                System.out.println("building from attribute");
		optionList = buildOptionsFromCollection(searchCollection(getCollection()));
            }
            writer.print("<select " + this.getModifiers() + ">" + optionList);
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }

    public int doEndTag() {
        JspWriter writer = pageContext.getOut();
        try{
	    writer.print("</select>");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return EVAL_PAGE;
    }

    /**
     * Checks if a <code>String</code> is <code>null</code> or is 
     * empty.
     * @param <code>String</code> to evalue.
     * @return <code>true</code> is empty or <code>null</code> 
     *         otherwise <code>false</code>
     */
    protected boolean isEmpty(String str){
        return str==null || str.trim().equals("");
    }
}
