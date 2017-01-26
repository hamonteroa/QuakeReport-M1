package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by hamonteroa on 8/23/16.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
        Log.v("EarthquakeLoader","EarthquakeLoader");
    }

    @Override
    protected void onStartLoading() {
        Log.v("EarthquakeLoader","onStartLoading");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Earthquake> loadInBackground() {
        Log.v("EarthquakeLoader","loadInBackground");
        if(TextUtils.isEmpty(mUrl)) {
            return null;
        }

        return QueryUtils.fetchEarthquakeData(mUrl);
    }
}
