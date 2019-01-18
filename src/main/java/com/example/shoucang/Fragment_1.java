package com.example.shoucang;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_1 extends Fragment {
    private int page  = 1 ;
    private XRecyclerView xrv;
    private MyAdapter myAdapter;
    private List<Welfare.ResultsBean> beanList;
    private List<Welfare.ResultsBean> list= new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout, null);
        xrv = (XRecyclerView) view.findViewById(R.id.xrv);
        initext();
        myAdapter = new MyAdapter(list,getContext());
        xrv.setLayoutManager(new LinearLayoutManager(getContext()));
        xrv.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        return view;
    }
    private void initext(){
        Retrofit build = new Retrofit.Builder()
                                 .baseUrl(MyService.url)
                                 .addConverterFactory(GsonConverterFactory.create())
                                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                 .build();
        MyService myService = build.create(MyService.class);
        Observable<Welfare> observable = myService.welfarecall(page + "");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Welfare>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Welfare welfare) {
                        if(welfare.isError()){
                            beanList = welfare.getResults();
                            list.addAll(beanList);
                            Log.e("TAG","--------"+beanList.size());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
