package pt.victoria.hub.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import pt.victoria.hub.application.model.ApplicationCode;
import pt.victoria.hub.b2c.SmcService.GetPreferencialContactsRequest;
import pt.victoria.hub.b2c.SmcService.GetPreferencialContactsResponse;
import pt.victoria.hub.b2c.SmcService.SmcServiceProxy;

public class GetPreferencialContactsService extends HttpServlet{
	private static final long serialVersionUID = 1L;
    



	public GetPreferencialContactsService() {
	        super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		ApplicationCode appCode = new ApplicationCode();
    	String getAppCode = appCode.getApplicationCode();
    	
		String applicationCode = getAppCode;
		String vatNumber = "";

		
		SmcServiceProxy getPrefContacts =new SmcServiceProxy();
		GetPreferencialContactsRequest getPreferencialContactsRequest = new GetPreferencialContactsRequest();
		GetPreferencialContactsResponse getPreferencialContactsResponse = new GetPreferencialContactsResponse();
		
		JSONObject requestParameters;
		String responseString;
		PrintWriter out = response.getWriter();
		try {
			requestParameters = JSONManagement.getRequestParameters(request.getReader());
			vatNumber = requestParameters.getString("vatNumber");
			
			getPreferencialContactsRequest.setVatNumber(vatNumber);
			getPreferencialContactsRequest.setApplicationCode(applicationCode);

		} catch (Exception e) {
			responseString = JSONManagement.getJsonResult(-1, e.getMessage(), null);
			out.print(responseString);
			return;
		}
		// Send Request to HUB
		try {

			getPreferencialContactsResponse  = getPrefContacts.getPreferencialContacts(getPreferencialContactsRequest);		
			    JsonObject returnInfo = new JsonObject();
				JsonObject responseData = new JsonObject();	
	

				JSONObject jsonOutput = new JSONObject();
				JSONObject jsonOutputReturn = new JSONObject();
				try{
					jsonOutputReturn.put("status", getPreferencialContactsResponse.getReturnInfo().getStatus().getValue()); 
					jsonOutputReturn.put("code", getPreferencialContactsResponse.getReturnInfo().getCode());
					jsonOutputReturn.put("message", getPreferencialContactsResponse.getReturnInfo().getMessage());
					jsonOutputReturn.put("phase", getPreferencialContactsResponse.getReturnInfo().getPhase().getValue());
					  // Create Inner JSON Object 
					jsonOutput.put("response",jsonOutputReturn);
				
					if (getPreferencialContactsResponse.getPreferencialContacts() != null) {
						jsonOutput.put("preferencialContacts", getPreferencialContactsResponse.getPreferencialContacts());
					}
					
				} catch (Exception e) {
				}
				responseString = jsonOutput.toString();
			
		} catch (Exception e) {
			getPreferencialContactsResponse  = getPrefContacts.getPreferencialContacts(getPreferencialContactsRequest);
			
			JsonObject responseData = new JsonObject();
			    
			JsonObject returnInfo = new JsonObject();
			returnInfo.addProperty("status", getPreferencialContactsResponse.getReturnInfo().getStatus().getValue()); 
		    returnInfo.addProperty("code", getPreferencialContactsResponse.getReturnInfo().getCode());
			returnInfo.addProperty("message", getPreferencialContactsResponse.getReturnInfo().getMessage());
			    // Create Inner JSON Object 
			responseData.add("response", returnInfo);
			out.print(responseData);
			return;
		}

		// Set Json Response
		out.print(responseString);
	}

}
