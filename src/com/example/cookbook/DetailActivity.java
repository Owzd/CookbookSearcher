package com.example.cookbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.LayoutAlgorithm;

public class DetailActivity extends Activity {
	
	private WebView webview;
	private String keyword;
	private final String url = "file:///android_asset/detail.html"; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webview = (WebView) findViewById(R.id.webView);
		
		//ȡ�������ؼ���
		Intent intent = getIntent();
		keyword = intent.getStringExtra("keyword");
		
		//����webview�Ĳ����ͼ��ر���ҳ��
		webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);	//��ʹ��������ռλ
		webview.getSettings().setBuiltInZoomControls(false);	//�������½����Ű�ť
		webview.getSettings().setSupportZoom(false);	//������html����
		webview.getSettings().setJavaScriptEnabled(true);	//���룡ʹwebview�е�html֧��javascript���ܹ��밲׿���н���
		webview.getSettings().setUseWideViewPort(true);	//ʹ����Ӧ�ֱ���
		webview.getSettings().setLoadWithOverviewMode(true);	//ʹ����Ӧ�ֱ���
		webview.setWebViewClient(new webViewClient()); ////ΪWebView����WebViewClient����ĳЩ����	
		webview.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);// ��ֹ�������ݹ������º���������
//		webview.addJavascriptInterface(this, "android");	//ע�⣡ʹ��������䣬���ڱ����onCreate�������ע��@SuppressLint("JavascriptInterface")���͵���android.annotation.SuppressLint������Ȼ�ᱨ������Ҫ��@JavascriptInterfaceע��Ĺ��з���������webview�б�����
		webview.loadUrl(url);	//���ص�ǰ��Ŀ��assetsĿ¼�µ�welcome.html�ļ���webview
	}
	
	/**
	 * �ؼ�����ΪWebView����WebViewClient��Ȼ����дshouldOverrideUrlLoading�������ɡ�����WebViewClientΪWebView��һ�������࣬��Ҫ�������֪ͨ�������¼���
	 * @author Dr.Chan
	 *
	 */
	 class webViewClient extends WebViewClient{ 
		 	/**
		 	 * ��дshouldOverrideUrlLoading������ʹ������Ӻ�ʹ��������������򿪡� 
		 	 */
		 	@Override 
		    public boolean shouldOverrideUrlLoading(WebView view, String url) { 
		        view.loadUrl(url); 
		        //�������Ҫ�����Ե�������¼��Ĵ�����true�����򷵻�false 
		        return true; 
		    }
		 	
		 	/**
		 	 * ҳ��������ɺ����
		 	 */
		 	@Override
		 	public void onPageFinished(WebView view, String url) {
		 		super.onPageFinished(view, url);
//		 		webview.loadUrl("javascript:changeH1Value('" + getRomTotalSize() + "')");  
		 	}
	 }
}
