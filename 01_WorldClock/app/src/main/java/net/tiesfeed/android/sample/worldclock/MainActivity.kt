package net.tiesfeed.android.sample.worldclock

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 画面のレイアウトを指定
        setContentView(R.layout.activity_main)

        // ユーザーのデフォルトタイムゾーンを取得する
        var timeZone = TimeZone.getDefault()

        // タイムゾーン名を表示する
        val timeZoneView = findViewById<TextView>(R.id.timeZone)
        // タイムゾーンを表示する
        timeZoneView.text = timeZone.displayName
    }
}
