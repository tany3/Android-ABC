package net.tiesfeed.android.sample.worldclock

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
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

        // 世界時計のリストを表示する
        showWorldClocks()
    }

    private fun showWorldClocks() {
        // プリファレンスから、保存しているタイムゾーンを得る
        val pref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val timeZones = pref.getStringSet("time_zone", setOf())

        val list = findViewById<ListView>(R.id.clockList)
        list.adapter = TimeZoneAdapter(this, timeZones.toTypedArray())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1
                && resultCode == Activity.RESULT_OK
                && data != null) {
            // 受け取ったデータから、タイムゾーンを得る
            val timeZone = data.getStringExtra("timeZone")

            // プリファレンスから、保存しているタイムゾーンを得る
            val pref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            val timeZones = pref.getStringSet("time_zone", setOf()).toMutableSet()

            // 保存していたタイムゾーン一覧に追加
            timeZones.add(timeZone)

            // プリファレンスに保存する
            pref.edit().putStringSet("time_zone", timeZones).apply()

            // リストを再表示する
            showWorldClocks()
        }
    }
}
