package sample.qiitaclient

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import sample.qiitaclient.model.Article
import sample.qiitaclient.view.ArticleView

/**
 * Created by taniuchi on 2018/09/04.
 */
class ArticleListAdapter(private val context: Context) : BaseAdapter() {

    var articles: List<Article> = emptyList()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View =
            ((convertView as? ArticleView) ?: ArticleView(context)).apply {
                setArticle(articles[position])
            }

    override fun getItem(position: Int): Any? = articles[position]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = articles.count()

}