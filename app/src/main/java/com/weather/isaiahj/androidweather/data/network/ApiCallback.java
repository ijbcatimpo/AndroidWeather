package com.weather.isaiahj.androidweather.data.network;

import java.util.List;

/**
 * Created by Ayi on 05/06/2017.
 */

public interface ApiCallback {

    void onSuccess();

    void onSuccess(Object o);

    void onSuccess(List<?> list);

    void onFailure(Throwable t);

}
