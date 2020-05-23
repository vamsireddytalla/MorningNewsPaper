package com.talla.morningnewstelugu.ViewModels;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.talla.morningnewstelugu.databinding.ActivityMainBinding;

public class PdfViewModel extends ViewModel
{

    public void loadPdfOnline(final ActivityMainBinding binding)
    {
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.getSettings().setBuiltInZoomControls(true);
        binding.webview.getSettings().setDisplayZoomControls(false);
        binding.webview.setWebChromeClient(new WebChromeClient());
        String filename = "http://todaysnewspapertelugu.com//uploads//pdf//23052020//AndhraPradesh//" +
                ".AP%20Main%20Editions//AndhraJyothi_Andhra-Pradesh_23-05-2020.pdf";
        binding.webview.loadUrl("https://docs.google.com/gview?embedded=true&url=" + filename);
        binding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                binding.webview.loadUrl("javascript:(function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();})()");
                binding.progressbar.setVisibility(View.GONE);
            }
        });

    }

}
