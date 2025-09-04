package com.example.app19


import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        webView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.google.co.kr")

        // 위 버튼 4개
        findViewById<Button>(R.id.button2).setOnClickListener {
            webView.loadUrl("https://topis.seoul.go.kr")
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            webView.loadUrl("https://m.work.go.kr")
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            webView.loadUrl("https://www.weather.go.kr/m/index.do")
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            webView.loadUrl("https://www.google.co.kr/maps")
        }

        // 아래 버튼 3개
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            if (webView.canGoBack()) webView.goBack()
        }
        findViewById<Button>(R.id.btnReload).setOnClickListener {
            webView.reload()
        }
        findViewById<Button>(R.id.btnForward).setOnClickListener {
            if (webView.canGoForward()) webView.goForward()
        }
    }
}