package chehara.crosswalklib;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.TextView;

import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

import java.util.Timer;


public class MainActivity extends AppCompatActivity {

    public XWalkView xWalkWebView;
    String url = "https://www.google.co.in/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
          //  XWalkPreferences.setValue(XWalkPreferences.ANIMATABLE_XWALK_VIEW, true);
            Intent intent = getIntent();


            Bundle extras = intent.getExtras();

            xWalkWebView = (XWalkView) findViewById(R.id.xwalkWebView);

            xWalkWebView.load(url, null);

            //  xWalkWebView.clearCache(true);
             Log.e("TAG", url);


            // xWalkWebView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.banner4));
            //  xWalkWebView.addJavascriptInterface(new JsInterface(), "Mobile");

            XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);
            // xWalkWebView.setBackgroundColor(ContextCompat.getColor(context, R.color.theme_new_secondary));


            //  xWalkWebView.getNavigationHistory().clear();
            xWalkWebView.setUIClient(new XWalkUIClient(xWalkWebView) {
                public boolean onConsoleMessage(ConsoleMessage cm) {
                    Log.e("LIB", cm.message() + " -- From line "
                            + cm.lineNumber() + " of "
                            + cm.sourceId());
                    return true;
                }

                @Override
                public void onPageLoadStarted(XWalkView view, String url) {

                    System.out.println("onPageLoadStarted  " + url);
                    try {


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }


                @Override
                public void onPageLoadStopped(XWalkView view, String url,
                                              XWalkUIClient.LoadStatus status) {
                    System.out.println("onPageLoadStopped  " + status);
                    try {



                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            });

            xWalkWebView.setResourceClient(new XWalkResourceClient(xWalkWebView) {
                @Override
                public void onReceivedHttpAuthRequest(XWalkView view, XWalkHttpAuthHandler handler, String host, String realm) {
                    System.out.println("onReceivedHttpAuthRequest" + handler);
                }

                @Override
                public boolean shouldOverrideUrlLoading(XWalkView view, String url) {

                    return super.shouldOverrideUrlLoading(view, url);
                }

                @Override
                public void onReceivedLoadError(XWalkView view, int errorCode, String description, String failingUrl) {

                    // if (dialog != null)

                    //  super.onReceivedLoadError(view, errorCode, description, failingUrl);


                }


                @Override
                public void onReceivedSslError(XWalkView view, ValueCallback<Boolean> callback, SslError error) {
                    // super.onReceivedSslError(view, callback, error);
                    // if (dialog != null)

                }

            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
