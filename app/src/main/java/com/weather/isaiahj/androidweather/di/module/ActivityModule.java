package com.weather.isaiahj.androidweather.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.di.ActivityContext;
import com.weather.isaiahj.androidweather.di.PerActivity;
import com.weather.isaiahj.androidweather.ui.main.MainMvpPresenter;
import com.weather.isaiahj.androidweather.ui.main.MainMvpView;
import com.weather.isaiahj.androidweather.ui.main.MainPresenter;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListAdapter;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListMvpPresenter;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListMvpView;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListPresenter;
import com.weather.isaiahj.androidweather.ui.splash.SplashMvpPresenter;
import com.weather.isaiahj.androidweather.ui.splash.SplashMvpView;
import com.weather.isaiahj.androidweather.ui.splash.SplashPresenter;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailMvpPresenter;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailMvpView;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailPresenter;
import com.weather.isaiahj.androidweather.utils.rx.AppSchedulerProvider;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by isaiahj on 05/10/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    WeatherDetailMvpPresenter<WeatherDetailMvpView> provideFeedPresenter(
            WeatherDetailPresenter<WeatherDetailMvpView> presenter) {
        return presenter;
    }

    @Provides
    WeatherListMvpPresenter<WeatherListMvpView> provideWeatherListMvpPresenter(
            WeatherListPresenter<WeatherListMvpView> presenter) {
        return presenter;
    }

    @Provides
    WeatherListAdapter provideWeatherListAdapter() {
        return new WeatherListAdapter(new BulkCurrentWeather());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
