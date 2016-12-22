package com.example.termproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Exer_follow extends AppCompatActivity {
    WebView webview1, webview2, webview3, webview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer_follow);

        webview1 = (WebView)findViewById(R.id.webv1);
        webview2 = (WebView)findViewById(R.id.webv2);
        webview3 = (WebView)findViewById(R.id.webv3);
        webview4 = (WebView)findViewById(R.id.webv4);

        webview1.setWebViewClient(new WebViewClient());
        WebSettings set1 = webview1.getSettings();
        set1.setJavaScriptEnabled(true);
        webview2.setWebViewClient(new WebViewClient());
        WebSettings set2 = webview2.getSettings();
        set2.setJavaScriptEnabled(true);
        webview3.setWebViewClient(new WebViewClient());
        WebSettings set3 = webview3.getSettings();
        set3.setJavaScriptEnabled(true);
        webview4.setWebViewClient(new WebViewClient());
        WebSettings set4 = webview4.getSettings();
        set4.setJavaScriptEnabled(true);

        webview1.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=B618F09474F0CC79708E8BCD56F24A4E0B38&outKey=V125db19044c37c0dcf435420f7b61076e68ee37888c9e890c8ab5420f7b61076e68e&width=544&height=306");
        webview2.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=7C00D063C234AFE565F2DEE11D67F75BD088&outKey=V1254bd70c439d0679c674fa067535cd14a64e4136c921496050b4fa067535cd14a64&width=544&height=306");
        webview3.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=94E565ECF9E7CA0FCDB614538A23D1B25849&outKey=V126814b90b0ad23d637fa26d7f39fd5efbc17e32696ddaf3aa35a26d7f39fd5efbc1&width=544&height=306");
        webview4.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=B8673ABA24AE8B46850AF00AE389C08DA8F1&outKey=V1298f56173d08a18c1e2697772de8f002d988a0bd147bff5f3f2697772de8f002d98&width=544&height=306");

    }

    @Override
    protected void onStop() {
        super.onStop();
        webview1.destroy();
        webview2.destroy();
        webview3.destroy();
        webview4.destroy();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview1.destroy();
        webview2.destroy();
        webview3.destroy();
        webview4.destroy();
        finish();
    }
}
