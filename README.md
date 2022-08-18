# External_Event_trigger_Asset

## WARRANTY & SUPPORT 
HCL Software provides HCL Commerce open source assets “as-is” without obligation to support them nor warranties or any kind, either express or implied, including the warranty of title, non-infringement or non-interference, and the implied warranties and conditions of merchantability and fitness for a particular purpose. HCL Commerce open source assets are not covered under the HCL Commerce master license nor Support contracts.

If you have questions or encounter problems with an HCL Commerce open source asset, please open an issue in the asset's GitHub repository. For more information about [GitHub issues](https://docs.github.com/en/issues), including creating an issue, please refer to [GitHub Docs](https://docs.github.com/en). The HCL Commerce Innovation Factory Team, who develops HCL Commerce open source assets, monitors GitHub issues and will do their best to address them. 

## HCLC External Event Trigger Asset

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
