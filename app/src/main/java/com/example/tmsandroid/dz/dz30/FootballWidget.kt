package com.example.tmsandroid.dz.dz30

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.tmsandroid.*

class FootballWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        val appWidgetManager = AppWidgetManager.getInstance(context)
        val man = AppWidgetManager.getInstance(context)
        val ids = man.getAppWidgetIds(ComponentName(context, FootballWidget::class.java))

        for (appWidgetId in ids) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
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
    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}