package skullhacker.volleyservercommunication;

import java.util.Map;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public abstract class VolleyTask {

	private Context context;
	private ProgressDialog mDialog;
	private String progressMessage;

	public VolleyTask(Context context, String url, Map<String, String> params, String progressMessage) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.progressMessage = progressMessage;
		if(progressMessage!=null&&progressMessage.trim().length()>1)
			showDialog(this.progressMessage);
		if(Networking.isNetworkAvailable(context))
			performTask(params, url);
		else
			Toast.makeText(context, "Internet is required", Toast.LENGTH_LONG).show();
	}

	private void performTask(final Map<String, String> params, String url) {
		// TODO Auto-generated method stub
		RequestQueue mRequestQueue = Volley.newRequestQueue(context);

		StringRequest mRequest = new StringRequest(Method.POST, url, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				hideDialog();
				handleResponse(response);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				hideDialog();
				handleError(arg0);
			}
		}){
			@Override
			public Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				Log.e("Params", params.toString());
				return params;
			}
		};
		mRequest.setShouldCache(true);
		mRequestQueue.add(mRequest);
	}

	protected abstract void handleError(VolleyError arg0);

	protected abstract void handleResponse(String response);

	public void showDialog(String message){
		// TODO Auto-generated method stub
		mDialog = new ProgressDialog(context);
		mDialog.setMessage(message);
		mDialog.show();
	}

	public void hideDialog(){
		// TODO Auto-generated method stub
		if(mDialog!=null&&mDialog.isShowing())
			mDialog.dismiss();
	}

}
