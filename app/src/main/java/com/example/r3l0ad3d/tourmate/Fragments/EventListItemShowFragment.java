package com.example.r3l0ad3d.tourmate.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.r3l0ad3d.tourmate.Adapter.AdapterExpandableList;
import com.example.r3l0ad3d.tourmate.R;
import com.example.r3l0ad3d.tourmate.Weather.Interface.WeatherApi;
import com.example.r3l0ad3d.tourmate.Weather.ModelClass.ForeCastReport;
import com.example.r3l0ad3d.tourmate.Weather.ModelClass.WeatherModelResponse;
import com.example.r3l0ad3d.tourmate.databinding.FragmentEventListItemShowBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListItemShowFragment extends Fragment {

    private FragmentEventListItemShowBinding binding ;
    private Handler handler;

    private static String cityName="dhaka";
    private static  List<ForeCastReport> foreCastReportList ;

    private List<String> parentList;
    private List<String> childList;
    private Map<String,List<List<String>>> childs;
    private AdapterExpandableList adapter;


    public EventListItemShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_list_item_show, container, false);

        binding = DataBindingUtil.bind(view);
        foreCastReportList = new ArrayList<>();

        parentList = new ArrayList<>();
        childList = new ArrayList<>();
        childs = new HashMap<>();

        setData();

        adapter = new AdapterExpandableList(getContext(),parentList,childs);

        binding.exList.setAdapter(adapter);

        //handler = new Handler(Looper.getMainLooper());

        //getReport();

        //Toast.makeText(getContext(),""+foreCastReportList.size(),Toast.LENGTH_LONG).show();

        return view;
    }

    private void setData() {
        parentList.add("Weather");
        parentList.add("Near By");
        for(int i=0;i<2;i++){
            List<String> list = new ArrayList<>();
            List<List<String>> tmp = new ArrayList<>();
            for(int j=0;j<5;j++){
                list.add("Hospital");
            }
            tmp.add(list);
            childs.put(parentList.get(i),tmp);
        }
    }

    private void getReport() {

        final String BASE_URL = "https://query.yahooapis.com/";

        final List<ForeCastReport> ret = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        String url = "v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" +
                cityName+"%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

        Call<WeatherModelResponse> weatherModelResponseCall = weatherApi.getWeatherResponse(url);

        weatherModelResponseCall.enqueue(new Callback<WeatherModelResponse>() {
            @Override
            public void onResponse(Call<WeatherModelResponse> call, Response<WeatherModelResponse> response) {
                if(response.code()==200){
                    WeatherModelResponse responsList = response.body();
                    if(responsList.getQuery().getResults().getChannel().getItem().getForecast().size()>0){
                        final ForeCastReport reportList = new ForeCastReport(responsList);

                        foreCastReportList.addAll(reportList.getForeCastReportList());
                        /*handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //foreCastReportList.addAll(reportList.getForeCastReportList());
                                setForeCastReportList(reportList.getForeCastReportList());
                                //Toast.makeText(getContext(),""+foreCastReportList.size(),Toast.LENGTH_LONG).show();
                            }
                        });*/
                    }
                    else{
                        Toast.makeText(getContext(),"Empty Data",Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(getContext(),""+foreCastReportList.size(),Toast.LENGTH_LONG).show();
                }else {
                    Log.d("Error","Connection Problem");
                }
            }

            @Override
            public void onFailure(Call<WeatherModelResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

}
