## VolleyServerCommunication
An Ultimate HttpClient Helper using Volley.

This is used to work with Http Clients Volley.

This requires the following jar files to be copied in the libs folder ( available in the libs folder of this library )

volley.jar

## Steps for importing the jar file 

* Download the library [here](https://www.dropbox.com/s/mk94fvn9w9hvddf/volley.jar?dl=0) .
* Copy the required jar files in your libs folder of the project.
* Copy the VolleyTask.java file in your src folder.

## Required Permissions

```
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

## Request Method Processing

4 parameters need to be passed. They are as follows

* #mContext# is the Context of the Class(eg - MainActivity.this)
* URL is the url of the service(eg - http://www.youtube.com/get_video)
* map is the parametres of the request is wrapped into HashMap
* progressMessage - message to be shown during server request with Progress Dialog.

```
Map<String , String> map = new HashMap<String , String>();
		map.put("Key", "VALUE");
		
		new VolleyTask(mContext, URL, map, progressMessage) {
			@Override
			protected void handleResponse(String response) {
				handleResponce(response);
			}
			@Override
			protected void handleError(VolleyError arg0) {
			}
		};
		
		```
