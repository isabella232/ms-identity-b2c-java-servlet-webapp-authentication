package com.microsoft.azuresamples.webapp.authentication;
import javax.servlet.http.HttpSession;

import java.io.Serializable;
import java.util.HashMap;

public class MsalAuthSession implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SESSION_KEY = "msalAuth";
    private boolean authenticated = false;
    private String username = null;
    private HashMap<String,String> idTokenClaims = new HashMap<>();
    private String tokenAcquisitionResult = null;

    public static MsalAuthSession getMsalAuthSession(final HttpSession session) {
        MsalAuthSession msalAuth =(MsalAuthSession) session.getAttribute(MsalAuthSession.SESSION_KEY);
        if ( msalAuth == null) {
            msalAuth = new MsalAuthSession();
            session.setAttribute(MsalAuthSession.SESSION_KEY, msalAuth);
        }
        
        return msalAuth;
    }

    public HashMap<String,String> getIdTokenClaims() {
        return idTokenClaims;
    }

    public void setIdTokenClaims(final HashMap<String,String> idTokenClaims) {
        this.idTokenClaims = idTokenClaims;
    }

    public String getTokenAcquisitionResult() {
        return tokenAcquisitionResult;
    }

    public void setTokenAcquisitionResult(final String tokenAcquisitionResult) {
        this.tokenAcquisitionResult = tokenAcquisitionResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(final boolean authenticated) {
        this.authenticated = authenticated;
    }
}