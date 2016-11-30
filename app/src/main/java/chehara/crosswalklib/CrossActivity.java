package chehara.crosswalklib;

import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;

import org.xwalk.core.XWalkActivity;

import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

import chehara.crosswalklib.R;


public class CrossActivity extends XWalkActivity {

    public XWalkView xWalkWebView;
    String url = "https://cheharatime.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross);

        try {
            //  XWalkPreferences.setValue(XWalkPreferences.ANIMATABLE_XWALK_VIEW, true);
            Intent intent = getIntent();


            Bundle extras = intent.getExtras();

            xWalkWebView = (XWalkView) findViewById(R.id.webView);

            //xWalkWebView.load(url, null);

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

    @Override
    protected void onXWalkReady() {
        xWalkWebView.load(url, null);
    }
}
