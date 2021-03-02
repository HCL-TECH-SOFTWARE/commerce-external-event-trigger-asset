# External_Event_trigger_POC


**DISCLAIMER:  This Proof of Concept asset is being provided as-is to help accelerate your projects. We have provided documentation as well as any needed code artifacts for your use.**

**Prerequisites:** HCL Commerce V9.1.x

**Marketing activities require the customer's personalization ID. If the event occurs on an external system that cannot pass the customer personalization ID, you need to map information that is known by the external system to the customer personalization ID in HCL Commerce. To accomplish this mapping, provide an implementation of the MarketingServicesTaskCmd that implements the method getPersonalizationId. This method maps from the external identifier of the customer to the HCL Commerce identifier for the customer (personalizationId). Then, register the task command in the CMDREG table.**

**The implemntation includes below components**
1. Update Java code
2. Register class in CMDREG

### Step - 1: Update Java code

Copy/Paste "com.hcl.commerce.marketing.dialog.util.ExternalMarketingServicesTaskCmdImpl.java" to "WebSphereCommerceServerExtensionsLogic/src".

### Step - 2: Register class in CMDREG

Execute the command in external_triggers.sql in the database.

Restart the Commerce server.

For Additional instructions refer to "Implementation_Guide_External_Triggers.docx" in Documents Folder.
