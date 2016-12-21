package com.example.termproject;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Movie extends AppCompatActivity {
    WebView webview1, webview2, webview3;
    TextView text1, text2, text3;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        final String part = getIntent().getExtras().getString("Part_Name");

        webview1 = (WebView)findViewById(R.id.web1);
        webview2 = (WebView)findViewById(R.id.web2);
        webview3 = (WebView)findViewById(R.id.web3);

        text1 = (TextView)findViewById(R.id.wet1);
        text2 = (TextView)findViewById(R.id.wet2);
        text3 = (TextView)findViewById(R.id.wet3);

        title = (TextView)findViewById(R.id.name);

        webview1.setWebViewClient(new WebViewClient());
        WebSettings set1 = webview1.getSettings();
        set1.setJavaScriptEnabled(true);
        webview2.setWebViewClient(new WebViewClient());
        WebSettings set2 = webview2.getSettings();
        set2.setJavaScriptEnabled(true);
        webview3.setWebViewClient(new WebViewClient());
        WebSettings set3 = webview3.getSettings();
        set3.setJavaScriptEnabled(true);


        if(part.equals("squart")) {
            title.setText("스쿼트");
            text1.setText("백 스쿼트");
            text2.setText("프론트 스쿼트");
            text3.setText("오버헤드 스쿼트");
            webview1.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=8A573EF178A2781B204DB915120ECAA4C9CF&outKey=V122105d4c402fe32a3b8285572f2e8adbc70197000c54f6446a6285572f2e8adbc70&width=544&height=306");
            webview2.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=06DA6F980ED6969A2509659E30797796EBFA&outKey=V1299b586dec058658136421dbf1917f87423409b5a33baae9aee421dbf1917f87423&width=544&height=306");
            webview3.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=638423216DB42B22588FDAFF10F1743DC31A&outKey=V129fb01e51e000ccdbd442cfa394e93218216cff79c9498a82bc42cfa394e9321821&width=544&height=306");
        }
        else if(part.equals("press")) {
            title.setText("프레스");
            text1.setText("숄더 프레스");
            text2.setText("푸쉬 프레스");
            text3.setVisibility(View.GONE);
            webview1.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=8B8A7A9E63215A08D50AD9A6D8D324512607&outKey=V129e84a3b36003391d1ea1f9c4b3f1cb39965ca86137e2b92952a1f9c4b3f1cb3996&width=544&height=306");
            webview2.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=49078A2BDE717362BF76FCD9990868801D31&outKey=V123f60d49dc16dd45fa9d76e273f089b19410e0c09cf623b82e7d76e273f089b1941&width=544&height=306");
            webview3.setVisibility(View.GONE);
        }
        else if(part.equals("lift")) {
            title.setText("데드리프트");
            text1.setText("데드리프트");
            text2.setText("스모 데드리프트 하이 풀");
            text3.setVisibility(View.GONE);
            webview1.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=22849CD9678DE298A939A5C56112AF28DCB2&outKey=V123440a2f451bb56a806d2a0111826c28d3056a3d6424655eacdd2a0111826c28d30&width=544&height=306");
            webview2.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=49663B0E361E32D74AB381E760F310062BC7&outKey=V1252a45091ac17347f3147a4c2ee45c0bb30a023fa6af314339247a4c2ee45c0bb30&width=544&height=306");
            webview3.setVisibility(View.GONE);
        }
        else if(part.equals("clean")) {
            title.setText("스내치and클린");
            text1.setText("머슬 클린");
            text2.setText("행 스내치");
            text3.setVisibility(View.GONE);
            webview1.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=7DD9D66EC6A1A5B34F0B5436B05374AE3200&outKey=V12250f22c08246d6edbef28d8658b0e8afd17cab69841260bedcf28d8658b0e8afd1&width=544&height=306");
            webview2.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=04647B125B9AD5BBBD32AFD6687278EB6879&outKey=V129637f6d8c09a4933537cb8b95a9842c4e8795035fdaf40d3fb7cb8b95a9842c4e8&width=544&height=306");
            webview3.setVisibility(View.GONE);
        }
        else if(part.equals("teok")) {
            title.setText("턱걸이");
            text1.setText("Strict Chest to Bar Pull up");
            text2.setText("Kipping Toes to Bar");
            text3.setVisibility(View.GONE);
            webview1.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=661D60BC021753A91D82216FDDAA4E7CE478&outKey=V122803296f5f7b300153fc00f15df45674a326decf18261f86c7fc00f15df45674a3&width=544&height=306");
            webview2.loadUrl("http://serviceapi.nmv.naver.com/flash/convertIframeTag.nhn?vid=52F9FD33735D486097FCE129C52ACF725AED&outKey=V12706aa130233c4e0b04285572f2e8adbc70db411c6244ee55f3285572f2e8adbc70&width=544&height=306");
            webview3.setVisibility(View.GONE);

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        webview1.destroy();
        webview2.destroy();
        webview3.destroy();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview1.destroy();
        webview2.destroy();
        webview3.destroy();
        finish();
    }
}
