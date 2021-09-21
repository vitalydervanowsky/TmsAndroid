package com.example.tmsandroid.dz.dz30

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.widget.RemoteViews
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.AppWidgetTarget
import com.bumptech.glide.request.transition.Transition
import com.example.tmsandroid.*

class FootballWidget : AppWidgetProvider() {
    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        val appWidgetManager = AppWidgetManager.getInstance(context)
        val ids = appWidgetManager.getAppWidgetIds(ComponentName(context, FootballWidget::class.java))

        for (appWidgetId in ids) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val prefs = context.getSharedPreferences(LAST_MATCH_KEY, Context.MODE_PRIVATE)
    val title = prefs.getString(LAST_MATCH_TITLE_KEY, DEFAULT_TEXT)
    val competition = prefs.getString(LAST_MATCH_COMPETITION_KEY, DEFAULT_TEXT)
    val date = prefs.getString(LAST_MATCH_DATE_KEY, DEFAULT_TEXT)
    val url = prefs.getString(LAST_MATCH_THUMBNAIL_KEY, DEFAULT_TEXT)

    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.football_widget)

    if (title != null) {
        views.setTextViewText(R.id.appwidget_title, title)
    }
    if (competition != null) {
        views.setTextViewText(R.id.appwidget_competition, competition)
    }
    if (date != null) {
        views.setTextViewText(R.id.appwidget_date, date)
    }
    if (url != null) {
        val awt: AppWidgetTarget = object :
            AppWidgetTarget(context.applicationContext, R.id.appwidget_image, views, appWidgetId) {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                super.onResourceReady(resource, transition)
            }
        }
        Glide.with(context.applicationContext)
            .asBitmap()
            .load(url)
            .placeholder(R.drawable.img_placeholder_300_300)
            .error(R.drawable.img_placeholder_300_300)
            .into(awt)
    }
    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}