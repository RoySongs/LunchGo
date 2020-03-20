package lunchrec.sgs.com.lunchrec.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

import java.util.ArrayList;

import lunchrec.sgs.com.lunchrec.MainActivity;
import lunchrec.sgs.com.lunchrec.R;
import lunchrec.sgs.com.lunchrec.roulette.GalleryAdapter;

public class OneFragment extends Fragment {

    private String TAG = MainActivity.class.getSimpleName();
    public ArrayList<Integer> images;
    private GalleryAdapter mAdapter;
    private RecyclerView recyclerView;
    private AlertDialog alertDialog;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.activity_food_roulette, container, false);

        images = new ArrayList<>();
        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
        //final VariableScrollSpeedLinearLayoutManager layoutManager = new VariableScrollSpeedLinearLayoutManager(getApplicationContext(), VariableScrollSpeedLinearLayoutManager.HORIZONTAL,true);
        //final VariableScrollSpeedLinearLayoutManager layoutManager = new VariableScrollSpeedLinearLayoutManager(VariableScrollSpeedLinearLayoutManager.HORIZONTAL,true);

        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        mAdapter = new GalleryAdapter(getContext(), images);



        recyclerView.setAdapter(mAdapter);


        recyclerView.addOnScrollListener(new CenterScrollListener());

        images.add(R.drawable.bbu);
        images.add(R.drawable.betnam);
        images.add(R.drawable.bokk);
        images.add(R.drawable.bossam);
        images.add(R.drawable.bude);
        images.add(R.drawable.cal);
        images.add(R.drawable.care);
        images.add(R.drawable.chicken);
        images.add(R.drawable.darkbokk);
        images.add(R.drawable.darkgal);
        images.add(R.drawable.darkgom);
        images.add(R.drawable.ddokbul);
        images.add(R.drawable.don);
        images.add(R.drawable.duck);
        images.add(R.drawable.gimbab);
        images.add(R.drawable.hesan);
        images.add(R.drawable.hotdog);
        images.add(R.drawable.mandu);
        images.add(R.drawable.momil);
        images.add(R.drawable.muk);
        images.add(R.drawable.nang);
        images.add(R.drawable.ozing);
        images.add(R.drawable.pasta);
        images.add(R.drawable.pat);
        images.add(R.drawable.pizza1);
        images.add(R.drawable.pizza2);
        images.add(R.drawable.ramen);
        images.add(R.drawable.ramen2);
        images.add(R.drawable.salad);
        images.add(R.drawable.samge);
        images.add(R.drawable.samgub);
        images.add(R.drawable.sand);
        images.add(R.drawable.sul);
        images.add(R.drawable.sun);
        images.add(R.drawable.sunde);
        images.add(R.drawable.taco);
        images.add(R.drawable.tangsuyuk);
        images.add(R.drawable.udong);
        images.add(R.drawable.uk);
        images.add(R.drawable.zanch);
        images.add(R.drawable.zeuk);
        images.add(R.drawable.zza);
        images.add(R.drawable.zzimdak);
        images.add(R.drawable.zzor);




        final int speedScroll = 500;
        final int stopTime = 10000;
        final Handler handler = new Handler();

        //롤링 시작
        final Runnable runnable = new Runnable() {
            int count = 0;
            boolean flag = true;
            @Override
            public void run() {
                recyclerView.smoothScrollToPosition(300);
                count++;
                handler.postDelayed(this,speedScroll);
            }
        };
        handler.postDelayed(runnable,speedScroll);






        Button buttonRed = (Button) view.findViewById(R.id.button) ;
        buttonRed.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //롤링 멈추기
                final Runnable stop_runnable = new Runnable() {
                    @Override
                    public void run() {
                        handler.removeCallbacks(runnable);
                        int randomPosition = (int)(Math.random()*images.size());
                        recyclerView.smoothScrollToPosition(randomPosition);
                    }
                };
                handler.postDelayed(stop_runnable,0);





                final Runnable dialogdelay = new Runnable() {
                    @Override
                    public void run() {
//
//                        Toast.makeText(FoodRoulette.this, "사진을 클릭하면 더 많은 주변목록을 불러옵니다", Toast.LENGTH_SHORT).show();
//
//                        final AlertDialog.Builder builder=new AlertDialog.Builder(FoodRoulette.this);
//                        LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
//                        //View view=inflater.inflate(R.layout.activity_menu_picker_result_dialog,null);
//
//
//                        builder.setCancelable(false);
//
//                        builder.setPositiveButton("결과 공유하기",dialogListener);
//                        builder.setNegativeButton("-Replay-",dialogListener);
//
//                        alertDialog=builder.create();
//                        alertDialog.show();
                    }

                };
                handler.postDelayed(dialogdelay, 2000);
            }



            DialogInterface.OnClickListener dialogListener=new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(dialog==alertDialog && which==DialogInterface.BUTTON_POSITIVE){
                        Intent msg = new Intent(getActivity().getIntent().ACTION_SEND);
                        msg.addCategory(Intent.CATEGORY_DEFAULT);
                        msg.putExtra(Intent.EXTRA_SUBJECT,"런치RUN!");
                        msg.putExtra(Intent.EXTRA_TEXT, "♥오늘의 점심메뉴는 오리구이 입니다♥");
                        msg.putExtra(Intent.EXTRA_TITLE, "제목");
                        msg.setType("text/plain");
                        startActivity(Intent.createChooser(msg, "공유하기냠냠"));


                    }else if(dialog==alertDialog && which==DialogInterface.BUTTON_NEGATIVE){
                        runnable.run();
                    }
                }
            };


        }) ;



        return view;
    }

}
