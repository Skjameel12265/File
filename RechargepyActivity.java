package app.chipper.biller.com;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.*;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class RechargepyActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String network = "";
	private String amount = "";
	private boolean num = false;
	private String accountbalance = "";
	private String netw = "";
	private String key = "";
	private HashMap<String, Object> resp = new HashMap<>();
	private HashMap<String, Object> ch = new HashMap<>();
	private HashMap<String, Object> nt = new HashMap<>();
	private HashMap<String, Object> data = new HashMap<>();
	private double rand1 = 0;
	private HashMap<String, Object> tokenDetails1 = new HashMap<>();
	private String plain_id = "";
	private String fontName = "";
	private String typeace = "";
	private boolean isAirtime = false;
	private double crn = 0;
	private String code = "";
	private String customer = "";
	private String itemcode = "";
	private String fee = "";
	private String name_ = "";
	private String productCode = "";
	private double amut = 0;
	private String text_refere = "";
	private HashMap<String, Object> MAP = new HashMap<>();
	private HashMap<String, Object> MAPToken = new HashMap<>();
	private boolean tru = false;
	
	private LinearLayout linear3;
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView Name;
	private LinearLayout linear4;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear_chosen;
	private TextView label_name;
	private EditText cusNumb;
	private LinearLayout linearAMT;
	private CardView adview1;
	private CircleImageView img;
	private TextView billerName;
	private ImageView imageview2;
	private TextView txt_amt;
	private LinearLayout amt;
	private LinearLayout linear10;
	private TextView textview42;
	private LinearLayout linear13;
	private LinearLayout linear22;
	private TextView textbtn;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private TextView textview8_49;
	private TextView textview10_98;
	private TextView textview12_197;
	private LinearLayout linear23;
	private LinearLayout linear24;
	private LinearLayout linear25;
	private TextView textview22;
	private TextView textview24;
	private TextView textview26;
	
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private AlertDialog.Builder d;
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private TimerTask t;
	private Calendar cal = Calendar.getInstance();
	private Intent i = new Intent();
	private  bs;
	private ObjectAnimator animation = new ObjectAnimator();
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private DatabaseReference SqlUsers = _firebase.getReference("users");
	private ChildEventListener _SqlUsers_child_listener;
	private DatabaseReference sqlWal = _firebase.getReference("users/wallet");
	private ChildEventListener _sqlWal_child_listener;
	private DatabaseReference sqlHistory = _firebase.getReference("history");
	private ChildEventListener _sqlHistory_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.rechargepy);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		Name = findViewById(R.id.Name);
		linear4 = findViewById(R.id.linear4);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		linear_chosen = findViewById(R.id.linear_chosen);
		label_name = findViewById(R.id.label_name);
		cusNumb = findViewById(R.id.cusNumb);
		linearAMT = findViewById(R.id.linearAMT);
		adview1 = findViewById(R.id.adview1);
		img = findViewById(R.id.img);
		billerName = findViewById(R.id.billerName);
		imageview2 = findViewById(R.id.imageview2);
		txt_amt = findViewById(R.id.txt_amt);
		amt = findViewById(R.id.amt);
		linear10 = findViewById(R.id.linear10);
		textview42 = findViewById(R.id.textview42);
		linear13 = findViewById(R.id.linear13);
		linear22 = findViewById(R.id.linear22);
		textbtn = findViewById(R.id.textbtn);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		textview8_49 = findViewById(R.id.textview8_49);
		textview10_98 = findViewById(R.id.textview10_98);
		textview12_197 = findViewById(R.id.textview12_197);
		linear23 = findViewById(R.id.linear23);
		linear24 = findViewById(R.id.linear24);
		linear25 = findViewById(R.id.linear25);
		textview22 = findViewById(R.id.textview22);
		textview24 = findViewById(R.id.textview24);
		textview26 = findViewById(R.id.textview26);
		net = new RequestNetwork(this);
		d = new AlertDialog.Builder(this);
		req = new RequestNetwork(this);
		auth = FirebaseAuth.getInstance();
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.hideKeyboard(getApplicationContext());
				finish();
			}
		});
		
		cusNumb.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				try {
					_autoTransitionScroll(linear2);
					if (_charSeq.length() > 9) {
						customer = _charSeq;
						num = true;
						linearAMT.setVisibility(View.VISIBLE);
					}
					else {
						num = false;
						linearAMT.setVisibility(View.GONE);
					}
				} catch (Exception e) {
					 
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		amt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				etInput.requestFocus();
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_widget_animate(linear10);
				if (cusNumb.getText().toString().equals("")) {
					_MaterialDialog("Blank Field ", "Enter your phone number ", "", "ok");
				}
				else {
					if (!num) {
						_MaterialDialog("Invalid number ", "Mobile number is invalid it must be up to 11 digit's ( example.080*********)", "", "ok");
					}
					else {
						if (etInput.getText().toString().equals("")) {
							_MaterialDialog("Blank Field ", "Enter or select an amount ", "", "ok");
						}
						else {
							if(etInput.length() != 0) {
								int cleanIntOutput = etInput.getCleanIntValue();
								amount = Integer.toString(cleanIntOutput);
								//amount = etInput.getInt(cleanIntOutput).toString();
								amount = amount.replace(".00", "");
								amount = amount.replace(",", "");
								if (Double.parseDouble(amount) > 49) {
									if (accountbalance.equals("")) {
										_MaterialDialog("Oops!!", "Error while fetching your info check internet connections or try again later", "", "ok");
									}
									else {
										if ((Double.parseDouble(accountbalance) > Double.parseDouble(amount)) || (Double.parseDouble(accountbalance) == Double.parseDouble(amount))) {
											MAP = new HashMap<>();
											MAP.put("code", code);
											MAP.put("item_code", itemcode);
											MAP.put("customer", customer);
											net.setParams(MAP, RequestNetworkController.REQUEST_PARAM);
											MAPToken.put("Authorization", key);
											net.setHeaders(MAPToken);
											net.startRequestNetwork(RequestNetworkController.GET, "https://api.flutterwave.com/v3/bill-items/".concat(itemcode.concat("/validate")), "", _net_request_listener);
											SketchwareUtil.showMessage(getApplicationContext(), "Here...");
											_telegramLoaderDialog(true);
										}
										else {
											_MaterialDialog("Insufficient Funds", "Low balance please fund your wallet and try again...", "", "ok");
										}
									}
								}
								else {
									_MaterialDialog("Invalid amount ", "minimum amount is ₦50", "", "ok");
								}
							}
						}
					}
				}
			}
		});
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_widget_animate(linear14);
				if (etInput.isEnabled()) {
					etInput.setText(String.valueOf(100 * 100));
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "A fix amount has been made.");
				}
			}
		});
		
		linear15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_widget_animate(linear15);
				if (etInput.isEnabled()) {
					etInput.setText(String.valueOf(200 * 100));
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "A fix amount has been made.");
				}
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_widget_animate(linear16);
				if (etInput.isEnabled()) {
					etInput.setText(String.valueOf(300 * 100));
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "A fix amount has been made.");
				}
			}
		});
		
		linear23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (etInput.isEnabled()) {
					etInput.setText(String.valueOf(500 * 100));
				}
				else {
					
				}
			}
		});
		
		linear24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (etInput.isEnabled()) {
					etInput.setText(String.valueOf(1000 * 100));
				}
				else {
					
				}
			}
		});
		
		linear25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (etInput.isEnabled()) {
					etInput.setText(String.valueOf(5000 * 100));
				}
				else {
					
				}
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try {
					JSONObject obj = new JSONObject(_response);
					if (obj.getString("status").equals("success")) {
						JSONObject Data = obj.getJSONObject("data");
						_telegramLoaderDialog(false);
						name_ = Data.getString("name");
						productCode = Data.getString("product_code");
						code = Data.getString("biller_code");
						customer = Data.getString("customer");
						fee = Data.getString("fee");
						bs = new com.google.android.material.bottomsheet.BottomSheetDialog(RechargepyActivity.this);
						View bsV;
						bsV = getLayoutInflater().inflate(R.layout.bottom_topup,null );
						bs.setContentView(bsV);
						bs.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
						final LinearLayout bg = (LinearLayout) bsV.findViewById(R.id.bg);
						final TextView t1 = (TextView) bsV.findViewById(R.id.t1);
						final TextView t2 = (TextView) bsV.findViewById(R.id.t2);
						final TextView t3 = (TextView) bsV.findViewById(R.id.t3);
						final TextView t5 = (TextView) bsV.findViewById(R.id.t5);
						final TextView biller = (TextView) bsV.findViewById(R.id.biller);
						final TextView amt = (TextView) bsV.findViewById(R.id.amt);
						final TextView fee_ = (TextView) bsV.findViewById(R.id.fee);
						final TextView number = (TextView) bsV.findViewById(R.id.number);
						final TextView btn = (TextView) bsV.findViewById(R.id.btn);
						amt.setText("₦".concat(new DecimalFormat("###,###.##").format(Integer.parseInt(amount))));
						fee_.setText("₦".concat(fee));
						biller.setText(name_);
						number.setText(customer);
						t2.setText(getIntent().getStringExtra("label_name"));
						btn.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF212121));
						_advancedCorners(bg, "#ffffff", 31, 31, 0, 0);
						t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 0);
						t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 0);
						t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 0);
						t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 0);
						biller.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
						number.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
						amt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
						fee_.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
						btn.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
						btn.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
								rand1 = SketchwareUtil.getRandom((int)(1000), (int)(9999));
								text_refere = customer.concat(amount.concat(name_.concat(String.valueOf((long)(rand1)))));
								data = new HashMap<>();
								data.put("country", "NG");
								data.put("customer", customer);
								data.put("type", getIntent().getStringExtra("biller_name"));
								data.put("amount", (int)(Integer.parseInt(amount)));
								data.put("reference", text_refere);
								req.setParams(data, RequestNetworkController.REQUEST_BODY);
								tokenDetails1.put("Authorization", key);
								tokenDetails1.put("Content-Type", "application/json");
								req.setHeaders(tokenDetails1);
								req.startRequestNetwork(RequestNetworkController.POST, "https://api.flutterwave.com/v3/bills", "", _req_request_listener);
								_telegramLoaderDialog(true);
							}
						});
						bs.show();
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										if (tru) {
											bs.dismiss();
										}
									}
								});
							}
						};
						_timer.scheduleAtFixedRate(t, (int)(0), (int)(10));
					}
					else {
						_MaterialDialog("Ohh Sorry", obj.getString("message"), "Close", "");
						_telegramLoaderDialog(false);
					}
				} catch (Exception e) {
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
					_telegramLoaderDialog(false);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				_telegramLoaderDialog(false);
				if (_message.contains("api.flutterwave.com")) {
					_MaterialDialog("Oh Sorry", "There seems to be an error connecting to the server. You should check your internet connection and try again.", "", "ok");
				}
				else {
					_MaterialDialog("ERROR", _message, "", "ok");
				}
			}
		};
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				/*
resp = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
if (resp.get("status").toString().equals("success")) {
t = new TimerTask() {
@Override
public void run() {
runOnUiThread(new Runnable() {
@Override
public void run() {
_telegramLoaderDialog(false);
_MaterialDialog("Recharge Completed ", netw.concat(" Recharge of ".concat("₦".concat(amount.concat(" to ".concat(cusNumb.getText().toString()).concat(" was successful "))))), "ok", "");
}
});
}
};
_timer.schedule(t, (int)(1000));
ch = new HashMap<>();
ch.put("-available-balance", String.valueOf((long)(Double.parseDouble(accountbalance) - Double.parseDouble(amount))));
sqlWal.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(ch);
cal = Calendar.getInstance();
nt = new HashMap<>();
nt.put("date", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(cal.getTime()));
nt.put("title", "Airtime Recharge ");
nt.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
nt.put("message", netw.concat(" Recharge of ".concat("₦".concat(amount.concat(" to ".concat(cusNumb.getText().toString()).concat(" was successful "))))));
if (resp.containsKey("message")) {
nt.put("api-message", resp.get("message").toString());
}
nt.put("key", sqlHistory.push().getKey());
sqlHistory.child(nt.get("key").toString()).updateChildren(nt);
if (getIntent().getStringExtra("type").contains("airtime")) {
int notifyId = 001;
NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
Notification.Builder mbuilder = new Notification.Builder(RechargepyActivity.this);
mbuilder.setSmallIcon(R.drawable.notification_icon);
mbuilder.setContentTitle("Airtime Topit");
mbuilder.setContentText("Your recharge of ".concat("₦".concat(amount.concat(" to ".concat(cusNumb.getText().toString()).concat(" was successful ")))));
mbuilder.setShowWhen(true);
mbuilder.setDefaults( Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
mbuilder.setOngoing(false);
mbuilder.setColor(Color.parseColor("#212121"));
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
		String channelId1 = "1";
		String channelName1 = "Notifications";
		NotificationChannel channel = new NotificationChannel(channelId1, channelName1, NotificationManager.IMPORTANCE_DEFAULT);
		channel.enableLights(true);
		channel.setLightColor(Color.BLACK);
		channel.setShowBadge(true);
		channel.enableVibration(true);
		mbuilder.setChannelId(channelId1);
		if (mNotificationManager != null) {
				mNotificationManager.createNotificationChannel(channel);
		}
} else {
		mbuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
}
if (mNotificationManager != null) {
		mNotificationManager.notify(notifyId, mbuilder.build());
}

}
tru = true;
nt.clear();
}
else {
if (resp.get("status").toString().equals("pending")) {
tru = true;
ch = new HashMap<>();
ch.put("-available-balance", String.valueOf((long)(Double.parseDouble(accountbalance) - Double.parseDouble(amount))));
sqlWal.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(ch);
cal = Calendar.getInstance();
nt = new HashMap<>();
nt.put("date", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(cal.getTime()));
nt.put("title", "Airtime Recharge ");
nt.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
nt.put("message", netw.concat(" Recharge of ".concat("₦".concat(amount.concat(" to ".concat(cusNumb.getText().toString()).concat(" was successful "))))));


_set_Notification("Recharge Successful", netw.concat(" Recharge of ".concat("₦".concat(amount.concat(" to ".concat(cusNumb.getText().toString()).concat(" was successful "))))));
t = new TimerTask() {
@Override
public void run() {
runOnUiThread(new Runnable() {
@Override
public void run() {
_MaterialDialog("Recharge Completed ", netw.concat(" Recharge of ".concat("₦".concat(amount.concat(" to ".concat(cusNumb.getText().toString()).concat(" was successful "))))), "ok", "");
_telegramLoaderDialog(false);
}
});
}
};
_timer.schedule(t, (int)(1000));
}
else {
_telegramLoaderDialog(false);
_MaterialDialog("An error occured ", "Check your Info and try again ", "", "ok");
}
}
*/
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				_telegramLoaderDialog(false);
				if (_message.contains("api.flutterwave.com")) {
					_MaterialDialog("Oh Sorry", "We couldn't complete your request. Please check your internet connection and try again.", "", "ok");
				}
				else {
					_MaterialDialog("ERROR", _message, "", "ok");
				}
			}
		};
		
		_SqlUsers_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		SqlUsers.addChildEventListener(_SqlUsers_child_listener);
		
		_sqlWal_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("-available-balance")) {
						accountbalance = _childValue.get("-available-balance").toString();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		sqlWal.addChildEventListener(_sqlWal_child_listener);
		
		_sqlHistory_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		sqlHistory.addChildEventListener(_sqlHistory_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_removeScollBar(vscroll1);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) { 
			getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));
		}
		crn = 30;
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF212121));
		linear_chosen.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFAFAFA));
		cusNumb.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)1, 0xFFEEEEEE, 0xFFF5F5F5));
		linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)2, 0xFFEEEEEE, 0xFFFFFFFF));
		linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)2, 0xFFEEEEEE, 0xFFFFFFFF));
		linear16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)2, 0xFFEEEEEE, 0xFFFFFFFF));
		linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)2, 0xFFEEEEEE, 0xFFFFFFFF));
		linear24.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)2, 0xFFEEEEEE, 0xFFFFFFFF));
		linear25.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)2, 0xFFEEEEEE, 0xFFFFFFFF));
		amt.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)1, 0xFFEEEEEE, 0xFFF5F5F5));
		_LengthOfEditText(cusNumb, 11);
		linearAMT.setVisibility(View.GONE);
		_autoTransitionScroll(linear2);
		key = "Bearer FLWSECK-359c1383db0460e99427fd3e789431c9-188435e3150vt-X";
		_changeActivityFont("light");
		textbtn.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
		Name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
		textview8_49.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
		textview10_98.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
		textview12_197.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
		textview22.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
		textview24.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
		textview26.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/light.ttf"), 1);
		label_name.setText(getIntent().getStringExtra("label_name"));
		code = getIntent().getStringExtra("biller_code");
		itemcode = getIntent().getStringExtra("item_code");
		fee = getIntent().getStringExtra("fee");
		Name.setText(getIntent().getStringExtra("biller_name"));
		billerName.setText(getIntent().getStringExtra("short_name"));
		etInput = new CurrencyEditText(this);
		amt.addView(etInput);
		etInput.setCurrency(CurrencySymbols.NIGERIA);
		etInput.setDelimiter(false);
		etInput.setSpacing(false);
		etInput.setDecimals(true);
		etInput.setSeparator(",");
		etInput.setHint("₦50 is the minimum");
		etInput.setInputType(InputType.TYPE_CLASS_NUMBER);
		etInput.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)crn, (int)1, 0xFFEEEEEE, 0xFFF5F5F5));
		if (getIntent().getStringExtra("amount").equals("0")) {
			etInput.setText("");
			etInput.setEnabled(true);
		}
		else {
			amut = Double.parseDouble(getIntent().getStringExtra("amount")) * 10;
			etInput.setEnabled(false);
			etInput.setText(String.valueOf(amut));
		}
	}
	private CurrencyEditText etInput;
	{
		img.setVisibility(View.GONE);
		if (getIntent().getStringExtra("short_name").contains("MTN")) {
			img.setImageResource(R.drawable.ic_airtime_mtn_1);
			img.setVisibility(View.VISIBLE);
		}
		if (getIntent().getStringExtra("short_name").contains("AIRTEL") || getIntent().getStringExtra("short_name").contains("Airtel")) {
			img.setImageResource(R.drawable.ic_airtime_airtel_1);
			img.setVisibility(View.VISIBLE);
		}
		if (getIntent().getStringExtra("short_name").contains("9Mobile") || getIntent().getStringExtra("short_name").contains("9MOBILE")) {
			img.setImageResource(R.drawable.ic_airtime_airtel_2);
			img.setVisibility(View.VISIBLE);
		}
		if (getIntent().getStringExtra("short_name").contains("GLO")) {
			img.setImageResource(R.drawable.ic_airtime_airtel_3);
			img.setVisibility(View.VISIBLE);
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _MaterialDialog(final String _title, final String _message, final String _button1text, final String _button2text) {
		final AlertDialog dialog1 = new AlertDialog.Builder(RechargepyActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.message,null); 
		dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		dialog1.setView(inflate);
		TextView t1 = (TextView) inflate.findViewById(R.id.t1);
		
		TextView t2 = (TextView) inflate.findViewById(R.id.t2);
		
		TextView b1 = (TextView) inflate.findViewById(R.id.b1);
		
		TextView b2 = (TextView) inflate.findViewById(R.id.b2);
		
		LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
		
		LinearLayout lin = (LinearLayout) inflate.findViewById(R.id.linear1);
		t1.setText(_title);
		t2.setText(_message);
		b1.setText(_button1text);
		b2.setText(_button2text);
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/muli.ttf"), 1);
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/muli.ttf"), 0);
		b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/muli.ttf"), 1);
		b2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/muli.ttf"), 1);
		lin.setVisibility(View.GONE);
		_rippleRoundStroke(bg, "#ffffff", "#ffffff", 31, 0, "#ffffff");
		b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				dialog1.dismiss();
				finish();
			}
		});
		b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				dialog1.dismiss();
			}
		});
		dialog1.setCancelable(true);
		dialog1.show();
	}
	
	
	public void _advancedCorners(final View _view, final String _color, final double _n1, final double _n2, final double _n3, final double _n4) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n4,(int)_n4,(int)_n3,(int)_n3});
		
		_view.setBackground(gd);
	}
	
	
	public void _telegramLoaderDialog(final boolean _visibility) {
		if (_visibility) {
			
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.show();
			coreprog.setContentView(R.layout.loading);
			
			
			LinearLayout linear2 = (LinearLayout)coreprog.findViewById(R.id.linear2);
			
			LinearLayout back = (LinearLayout)coreprog.findViewById(R.id.background);
			
			
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
			gd.setColor(Color.parseColor("#ffffffff"));
			gd.setCornerRadius(40); 
			gd.setStroke(0, Color.WHITE); 
			linear2.setBackground(gd);
			
		}
		else {
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _LengthOfEditText(final TextView _editText, final double _value_character) {
		InputFilter[] gb = _editText.getFilters(); 
		InputFilter[] newFilters = new InputFilter[gb.length + 1]; 
		System.arraycopy(gb, 0, newFilters, 0, gb.length); 
		newFilters[gb.length] = new InputFilter.LengthFilter((int)_value_character); 
		_editText.setFilters(newFilters);
	}
	
	
	public void _set_Notification(final String _Title, final String _Message) {
		/*
Developer :- mohammed atta channel
Powered by :- Gopal
*/
		
		/*
final Context context = getApplicationContext();


NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

Intent intent = new Intent(this, DashboardActivity.class); 
intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); 
PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0); 
androidx.core.app.NotificationCompat.Builder builder; 

    int notificationId = 1;
    String channelId = "channel-01";
    String channelName = "Channel Name";
    int importance = NotificationManager.IMPORTANCE_HIGH;

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        NotificationChannel mChannel = new NotificationChannel(
                channelId, channelName, importance);
        notificationManager.createNotificationChannel(mChannel);
    }

  
 androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.icon)
            .setContentTitle(_Title)
            .setContentText(_Message)
            .setAutoCancel(true)
            .setOngoing(false)
            .setContentIntent(pendingIntent);
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
    stackBuilder.addNextIntent(intent);
    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT
    );
    mBuilder.setContentIntent(resultPendingIntent);

    notificationManager.notify(notificationId, mBuilder.build());
*/
	}
	
	
	public void _autoTransitionScroll(final View _scroll) {
		android.transition.TransitionManager.beginDelayedTransition((LinearLayout)_scroll, new android.transition.AutoTransition());
	}
	
	
	public void _changeActivityFont(final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
	}
	
	
	public void _extra() {
		// original library is in github (https://github.com/AbhinayMe/currency-edittext)
		// converted to moreblock by DidDog
	}
	public class CurrencyEditText extends EditText {
		
		    private String current = "";
		    private CurrencyEditText editText = CurrencyEditText.this;
		
		    //properties
		    private String Currency = "";
		    private String Separator = ".";
		    private Boolean Spacing = false;
		    private Boolean Delimiter = false;
		    private Boolean Decimals = true;
		
		    public CurrencyEditText(android.content.Context context) {
			        super(context);
			        init();
			    }
		
		    public CurrencyEditText(android.content.Context context, android.util.AttributeSet attrs) {
			        super(context, attrs);
			        init();
			    }
		
		    public CurrencyEditText(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
			        super(context, attrs, defStyleAttr);
			        init();
			    }
		
		    public void init() {
			
			        this.addTextChangedListener(new android.text.TextWatcher() {
				            @Override
				            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
					
					            }
				
				            @Override
				            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
					                if (!s.toString().equals(current)) {
						                    editText.removeTextChangedListener(this);
						
						                    String cleanString = s.toString().replaceAll("[$,.]", "").replaceAll(Currency, "").replaceAll("\\s+", "");
						
						                    if (cleanString.length() != 0) {
							                        try {
								
								                            String currencyFormat = "";
								                            if (Spacing) {
									                                if (Delimiter) {
										                                    currencyFormat = Currency + ". ";
										                                } else {
										                                    currencyFormat = Currency + " ";
										                                }
									                            } else {
									                                if (Delimiter) {
										                                    currencyFormat = Currency + ".";
										                                } else {
										                                    currencyFormat = Currency;
										                                }
									                            }
								
								                            double parsed;
								                            int parsedInt;
								                            String formatted;
								
								                            if (Decimals) {
									                                parsed = Double.parseDouble(cleanString);
									                                formatted = java.text.NumberFormat.getCurrencyInstance().format((parsed / 100)).replace(java.text.NumberFormat.getCurrencyInstance().getCurrency().getSymbol(), currencyFormat);
									                            } else {
									                                parsedInt = Integer.parseInt(cleanString);
									                                formatted = currencyFormat + java.text.NumberFormat.getNumberInstance(java.util.Locale.US).format(parsedInt);
									                            }
								
								                            current = formatted;
								
								                            //if decimals are turned off and Separator is set as anything other than commas..
								                            if (!Separator.equals(",") && !Decimals) {
									                                //..replace the commas with the new separator
									                                editText.setText(formatted.replaceAll(",", Separator));
									                            } else {
									                                //since no custom separators were set, proceed with comma separation
									                                editText.setText(formatted);
									                            }
								                            editText.setSelection(formatted.length());
								                        } catch (java.lang.NumberFormatException e) {
								
								                        }
							                    }
						
						                    editText.addTextChangedListener(this);
						                }
					            }
				
				            @Override
				            public void afterTextChanged(android.text.Editable editable) {
					
					            }
				        });
			    }
		
		    /*
    *
    */
		    public double getCleanDoubleValue() {
			        double value = 0.0;
			        if (Decimals) {
				            value = Double.parseDouble(editText.getText().toString().trim().replaceAll("[$,]", "").replaceAll(Currency, ""));
				        } else {
				            String cleanString = editText.getText().toString().trim().replaceAll("[$,.]", "").replaceAll(Currency, "").replaceAll("\\s+", "");
				            try {
					                value = Double.parseDouble(cleanString);
					            } catch (java.lang.NumberFormatException e) {
					
					            }
				        }
			        return value;
			    }
		
		    public int getCleanIntValue() {
			        int value = 0;
			        if (Decimals) {
				            double doubleValue = Double.parseDouble(editText.getText().toString().trim().replaceAll("[$,]", "").replaceAll(Currency, ""));
				            value = (int) Math.round(doubleValue);
				        } else {
				            String cleanString = editText.getText().toString().trim().replaceAll("[$,.]", "").replaceAll(Currency, "").replaceAll("\\s+", "");
				            try {
					                value = Integer.parseInt(cleanString);
					            } catch (java.lang.NumberFormatException e) {
					
					            }
				        }
			        return value;
			    }
		
		    public void setDecimals(boolean value) {
			        this.Decimals = value;
			    }
		
		    public void setCurrency(String currencySymbol) {
			        this.Currency = currencySymbol;
			    }
		
		    public void setSpacing(boolean value) {
			        this.Spacing = value;
			    }
		
		    public void setDelimiter(boolean value) {
			        this.Delimiter = value;
			    }
		
		    /**
     * Separator allows a custom symbol to be used as the thousand separator. Default is set as comma (e.g: 20,000)
     * <p>
     * Custom Separator cannot be set when Decimals is set as `true`. Set Decimals as `false` to continue setting up custom separator
     *
     * @value is the custom symbol sent in place of the default comma
     */
		    public void setSeparator(String value) {
			        this.Separator = value;
			    }
	}
	{
	}
	public class CurrencySymbols {
		    public static final String NONE = "";
		    public static final String MALAYSIA = "RM";
		    public static final String INDONESIA = "Rp";
		    public static final String SRILANKA = "Rs";
		    public static final String USA = "$";
		    public static final String UK = "£";
		    public static final String INDIA = "₹";
		    public static final String PHILIPPINES = "₱";
		    public static final String PAKISTAN = "₨";
		    public static final String NIGERIA = "₦";
	}
	{
	}
	
	
	public void _widget_animate(final View _view) {
		animation.setTarget(_view);
		animation.setPropertyName("scaleX");
		animation.setFloatValues((float)(1.0d), (float)(1.1d));
		animation.setDuration((int)(100));
		animation.setRepeatMode(ValueAnimator.REVERSE);
		animation.setRepeatCount((int)(1));
		animation.start();
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}