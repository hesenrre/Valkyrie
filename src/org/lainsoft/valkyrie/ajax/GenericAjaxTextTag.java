package org.lainsoft.valkyrie.ajax;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.lainsoft.valkyrie.form.GenericTextTag;

public abstract class GenericAjaxTextTag
    extends GenericTextTag{
    
    private String url;

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String
    getUrl(){
        return url;
    }
    
    public void
    setUrl(String url){
        this.url = parseURL(url);
    }

    private String
    parseURL(String url){
        List deteminants = null;
        String gfs_path = (gfs_path = (String)pageContext.getServletContext().getAttribute("_gfs_alias_path")) == null ? "" : gfs_path;
        return (url == null || (deteminants = Arrays.asList(url.trim().split("[\\s]{0,}=>[\\s]{0,}"))).size() <= 1) ? url :
            (deteminants.get(0).equals(":action")) ? ((HttpServletRequest)pageContext.getRequest()).getContextPath()+gfs_path +"/"+ deteminants.get(1) : "";       
    }
    
    protected boolean
    is_empty(Object o){
        return o == null ? true : (o instanceof String && o.toString().trim().equals(""));
    }
}
