/**
 * RoleFilter.java is part of Forge Project.
 *
 * Copyright 2004,2005 LainSoft Foundation, Demetrio Cruz
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
*/
package org.lainsoft.valkyrie.security;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * TagLibrary represeting a security filter, it's used to hide or show
 * view zones that a security role or user can see or not.
 *
 * @jsp.tag    name="rolefilter"
 *             body-content="JSP"
 *             description="Security filter, can show or hidden content 
 *                           for specific users or roles".
 */
public class RoleFilter
    extends BodyTagSupport{
    
    private boolean allowed;    
    private String role;
    private String user;
    

    public void
    setAllowed(String allowed){
        this.allowed = (new Boolean (allowed)).booleanValue();
    }

    public void
    setRole(String role){
        this.role = (role==null || role.trim().equals("")) ? "" : role;
    }

    public void
    setUser(String user){
        this.user = (user==null || user.trim().equals("")) ? "" : user;
    }

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String
    getAllowed(){
        return allowed+"";
    }

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="false"
     */
    public String
    getRole(){
        return role;
    }

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="false"
     */
    public String
    getUser(){
        return user;
    }
    
    public int
    doStartTag(){
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        return isInRoleList(request) || isInUserList(request.getUserPrincipal()==null?",":request.getUserPrincipal().getName())
            || userAndRoleAreEmpty()
            ? allowed ? EVAL_BODY_BUFFERED : SKIP_BODY
            : allowed ? SKIP_BODY : EVAL_BODY_BUFFERED;
    }

    
    public void
    doInitBody() {
        // nothing to evaluate
    }


    public int
    doAfterBody() {
        JspWriter writer = getBodyContent().getEnclosingWriter();
        try{
            writer.write(getBodyContent().getString());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }

    
    public int 
    doEndTag() {
        return EVAL_PAGE;
    }

    private boolean
    userAndRoleAreEmpty(){
        return (user==null || user.trim().equals("")) && (role==null || role.trim().equals(""));
    }


    private boolean
    isInRoleList (HttpServletRequest request){
        String []roles = role.split(",");
        for (int i=0; i<roles.length;i++){
            if (request.isUserInRole(roles[i]))
                return true;
        }
        return false;
    }


    private boolean
    isInUserList (String principal){
        return user.matches(".*\\b"+principal+"\\b.*");
    }
    
}
