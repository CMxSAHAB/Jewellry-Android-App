package com.example.locationsharing;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webViewControl extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
