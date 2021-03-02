/**
*==================================================
Copyright [2021] [HCL Technologies]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*==================================================
**/
package com.hcl.commerce.marketing.dialog.util;

import com.ibm.commerce.base.objects.ServerJDBCHelperBean;
import com.ibm.commerce.ejb.helpers.SessionBeanHelper;
import com.ibm.commerce.foundation.logging.LoggingHelper;
import com.ibm.commerce.marketing.dialog.util.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExternalMarketingServicesTaskCmdImpl 
extends MarketingServicesTaskCmdImpl
implements MarketingServicesTaskCmd {
	public  static final String CLASSNAME = "com.hcl.commerce.marketing.dialog.util.ExternalMarketingServicesTaskCmdImpl";

	private static final Logger LOGGER = LoggingHelper.getLogger(ExternalMarketingServicesTaskCmdImpl.class);
	
	

	/**
	 * Need to check the copyright.
	 
	 * IBM copyright notice field.

	 */

	public static final String COPYRIGHT = com.ibm.commerce.copyright.IBMCopyright.SHORT_COPYRIGHT;

	/**

	 * The name of this class.

	 */

	/**

	 * This method will find a customer's personalization ID based on the provided email.

	 * @param triggerParameters: The trigger parameters passed in the service call. This should

	 * include a parameter named email. The external system has the customer's email,

	 * and it is assumed that the customer has provided the same number in their HCL Commerce 

	 * account. This method maps the customer's email to their personalization ID.

	 * @return: The customer's personalization ID.

	 */	
	@Override
	public String getPersonalizationId(StringBuffer triggerParameters) {

		final String METHOD_NAME = "getPersonalizationId";

		if (LoggingHelper.isEntryExitTraceEnabled(LOGGER)) {

			LOGGER.entering(CLASSNAME, METHOD_NAME);

		}

		String pznId = null;

		try {

			String email = MarketingUtil.getDataFromTriggerParametersString(triggerParameters.toString(), "email");
			
			if (LoggingHelper.isTraceEnabled(LOGGER)) {

				LOGGER.logp(Level.FINE, CLASSNAME, METHOD_NAME, "email:" + email);

			}

			if (email != null) {	
				
				List pznIdList = SessionBeanHelper.lookupSessionBean(ServerJDBCHelperBean.class).executeParameterizedQuery( 

                              "select users.personalizationid from users, address where users.users_id = address.member_id and address.email1 = ?", 

                              new Object[]{ email } );

				if (LoggingHelper.isTraceEnabled(LOGGER)) {

					LOGGER.logp(Level.FINE, CLASSNAME, METHOD_NAME, "pznIdList:" + pznIdList);

				}

				if (pznIdList != null && pznIdList.size() > 0) {
					
					List pznIdEntry = (List)pznIdList.get(0);

					pznId = pznIdEntry.get(0).toString();

				}

				if (LoggingHelper.isTraceEnabled(LOGGER)) {

					LOGGER.logp(Level.FINE, CLASSNAME, METHOD_NAME, "pznId:" + pznId);

				}
				
			}

		} catch (Exception e) {

			if (LoggingHelper.isTraceEnabled(LOGGER)) {

				LOGGER.logp(Level.FINE, CLASSNAME, METHOD_NAME, "Exception:" + e);

			}

			e.printStackTrace();

		}		

		if (LoggingHelper.isEntryExitTraceEnabled(LOGGER)) {

			LOGGER.exiting(CLASSNAME, METHOD_NAME);

		}	
		
		return pznId;

	}
}
