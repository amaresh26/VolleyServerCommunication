## VolleyServerCommunication
An Ultimate HttpClient Helper using Volley.

This is used to work with Http Clients Volley.

This requires the following jar files to be copied in the libs folder ( available in the libs folder of this library )

volley.jar

## Steps for importing the jar file 

* Download the library [here](https://www.dropbox.com/s/mk94fvn9w9hvddf/volley.jar?dl=0) .
* Copy the required jar files in your libs folder of the project.
* Copy the VolleyTask.java file in your src folder.
* Add the library into Android Studio by 
```
compile 'com.mcxiaoke.volley:library:1.0.17'
```

## Required Permissions

```
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

## Request Method Process

4 parameters need to be passed. They are as follows

* mContext is the Context of the Class(eg - MainActivity.this)
* URL is the url of the service(eg - http://www.youtube.com/get_video)
* map is the parametres of the request is wrapped into HashMap
* progressMessage - message to be shown during server request with Progress Dialog.

```
//storing parameters with the key and value 
Map<String , String> map = new HashMap<String , String>();
		map.put("Key", "VALUE");
		/*
		* @param mContext need to send the present context
		* @param URL is the url of the api 
		* @param map parameters of the api with key as name of parameter and value as value of the parameter
		* @param progressMessage is the for showing the progress bar if "" then no progress bar or pass the string
		*/
		new VolleyTask(mContext, URL, map, progressMessage) {
		
			/*
			* response will be in string 
			*/
			@Override
			protected void handleResponse(String response) {
				//handle the response here 
			}
			@Override
			protected void handleError(VolleyError arg0) {
				//handle the volley errors here
			}
		};
		
```
