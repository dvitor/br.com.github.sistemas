package br.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesContextUtil {
	public static void addMessage(Severity severity, String summary, String detail, boolean isValidationFailed) {
		FacesMessage.Severity facesSeverity = severity.getSeverity();
		FacesMessage msg = new FacesMessage(facesSeverity, summary, detail); 
		getContext().addMessage(null, msg);
		if(isValidationFailed) {
			getContext().validationFailed();
		}
	}
	public static FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context == null) {
			System.out.println("FacesContext indisponível");
		}
		return context;
	}
	
	
	public static enum Severity{
		ERROR(FacesMessage.SEVERITY_ERROR), 
		FATAL(FacesMessage.SEVERITY_FATAL), 
		INFO(FacesMessage.SEVERITY_INFO), 
		WARN(FacesMessage.SEVERITY_WARN);
		
		private FacesMessage.Severity severity;

		private Severity(FacesMessage.Severity severity) {
			this.severity = severity;
		}
		
		private FacesMessage.Severity getSeverity() {
			return severity;
		}
	}
}
