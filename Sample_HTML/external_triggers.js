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
function TriggerEvent() {
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json; charset=UTF-8");


	var DM_ReqCmd = document.getElementById("DM_ReqCmd").value;
	var emailId = document.getElementById("emailId").value;
	//Created event externalCoupon, the event takes catalogId as parameter of any value.
	//The event will add coupon to the customer wallet
	var formData = {
		'DM_ReqCmd': DM_ReqCmd,
		'storeId': '11',
		'catalogId': '11501',
		'email': emailId
	};
	var raw = formData;

	var requestOptions = {
	  method: 'POST',
	  headers: myHeaders,
	  body: raw,
	  redirect: 'follow'
	};

fetch("https://localhost:6443/wcs/resources/store/11/event", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}


