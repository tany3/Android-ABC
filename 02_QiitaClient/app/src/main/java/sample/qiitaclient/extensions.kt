package sample.qiitaclient

import android.support.annotation.IdRes
import android.view.View

/**
 * Created by tany3 on 2018/09/04.
 */
fun <T : View> View.bindView(@IdRes id: Int): Lazy<T> = lazy {
    findViewById<T>(id)
}