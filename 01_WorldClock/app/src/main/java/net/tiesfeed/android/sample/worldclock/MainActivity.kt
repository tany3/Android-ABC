package net.tiesfeed.android.sample.worldclock

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

        // 「追加する」ボタンをレイアウトから探す
        var addButton = findViewById<Button>(R.id.add)
        // 「追加する」ボタンがタップされたら、タイムゾーン選択画面へ遷移する
        addButton.setOnClickListener {
            val intent = Intent(this, TimeZoneSelectActivity::class.java)
            // 遷移先画面からの結果を受け取りたい場合
            startActivityForResult(intent, 1)
        }
    }
}
