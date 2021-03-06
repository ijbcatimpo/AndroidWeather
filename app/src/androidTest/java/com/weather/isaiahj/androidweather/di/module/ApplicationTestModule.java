package com.weather.isaiahj.androidweather.di.module;

import android.app.Application;
import android.content.Context;

import com.weather.isaiahj.androidweather.BuildConfig;
import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.AppDataManager;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.data.network.ApiHeader;
import com.weather.isaiahj.androidweather.data.network.ApiHelper;
import com.weather.isaiahj.androidweather.data.network.AppApiHelper;
import com.weather.isaiahj.androidweather.data.prefs.AppPreferencesHelper;
import com.weather.isaiahj.androidweather.data.prefs.PreferencesHelper;
import com.weather.isaiahj.androidweather.di.ApiInfo;
import com.weather.isaiahj.androidweather.di.ApplicationContext;
import com.weather.isaiahj.androidweather.di.DatabaseInfo;
import com.weather.isaiahj.androidweather.di.PreferenceInfo;
import com.weather.isaiahj.androidweather.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by amitshekhar on 03/02/17.
 */
@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    // TODO : Mock all below for UI testing

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.PublicApiHeader providePublicApiHeader() {
        return new ApiHeader.PublicApiHeader(BuildConfig.API_KEY);
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/opensans/OpenSans-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
