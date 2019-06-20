package com.champs21.safeinternate.activity.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.champs21.safeinternate.R;
import com.champs21.safeinternate.activity.adapter.EventAdapter;
import com.champs21.safeinternate.activity.adapter.HomeAdapter;


import com.champs21.safeinternate.activity.model.Item;
import com.champs21.safeinternate.activity.model.SafeInternetNews;
import com.champs21.safeinternate.activity.utils.MainSliderAdapter;
import com.champs21.safeinternate.activity.utils.PicassoImageLoadingService;


import java.util.ArrayList;

import ss.com.bannerslider.Slider;
import ss.com.bannerslider.event.OnSlideClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeAdapter.ItemListener, EventAdapter.ItemListener{
    private RecyclerView recyclerView, recyclerView1;
    private ArrayList<SafeInternetNews> safeInternetNews;
    private ArrayList<Item> arrayList1;
    private Slider slider;


    public HomeFragment() {
        // Required empty public constructor
    }
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        SliderView sliderView = view.findViewById(R.id.imageSlider);
//
//        SliderAdapterExample adapters = new SliderAdapterExample(getContext());
//
//        sliderView.setSliderAdapter(adapters);
//
//        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.WHITE);
//        sliderView.setIndicatorUnselectedColor(Color.GRAY);
//        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
//        sliderView.startAutoCycle();

        Slider.init(new PicassoImageLoadingService(getActivity()));

        slider = view.findViewById(R.id.banner_slider1);
        slider.setAdapter(new MainSliderAdapter());

        slider.setOnSlideClickListener(new OnSlideClickListener() {
            @Override
            public void onSlideClick(int position) {
                Toast.makeText(getActivity(),"ff  "+position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        safeInternetNews = new ArrayList<>();

        safeInternetNews.add(new SafeInternetNews("মার্চ ১১, ২০১৯", "খুব কঠিন সমীকরণ। নিউজিল্যান্ডের বিপক্ষে জিতলে ৯ পয়েন্ট নিয়েও যাওয়ার সুযোগ ছিল"));
        safeInternetNews.add(new SafeInternetNews("মার্চ ১১, ২০১৯", "খুব কঠিন সমীকরণ। নিউজিল্যান্ডের বিপক্ষে জিতলে ৯ পয়েন্ট নিয়েও যাওয়ার সুযোগ ছিল"));
        safeInternetNews.add(new SafeInternetNews("মার্চ ১১, ২০১৯", "খুব কঠিন সমীকরণ। নিউজিল্যান্ডের বিপক্ষে জিতলে ৯ পয়েন্ট নিয়েও যাওয়ার সুযোগ ছিল"));
        safeInternetNews.add(new SafeInternetNews("মার্চ ১১, ২০১৯", "খুব কঠিন সমীকরণ। নিউজিল্যান্ডের বিপক্ষে জিতলে ৯ পয়েন্ট নিয়েও যাওয়ার সুযোগ ছিল"));
//        arrayList.add(new Item("Item 6", R.drawable.terraria, "#0A9B88"));
//        arrayList.add(new Item("Item 7", R.drawable.ferrari, "#673BB7"));
//        arrayList.add(new Item("Item 8", R.drawable.jetpack_joyride, "#4BAA50"));
//        arrayList.add(new Item("Item 9", R.drawable.three_d, "#F94336"));
//        arrayList.add(new Item("Item 10", R.drawable.terraria, "#0A9B88"));

        HomeAdapter adapter = new HomeAdapter(getActivity(), safeInternetNews, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        recyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerView1);
        arrayList1 = new ArrayList<>();

        arrayList1.add(new Item("Item 1", R.drawable.battle, "#40ffffff"));
        arrayList1.add(new Item("Item 2", R.drawable.beer, "#3E51B1"));
        arrayList1.add(new Item("Item 3", R.drawable.ferrari, "#673BB7"));
        arrayList1.add(new Item("Item 4", R.drawable.jetpack_joyride, "#4BAA50"));

        EventAdapter eventAdapter = new EventAdapter(getActivity(), arrayList1, this);
        recyclerView1.setAdapter(eventAdapter);
        recyclerView1.setNestedScrollingEnabled(false);
        GridLayoutManager manager1 = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);


        recyclerView1.setLayoutManager(manager1);
    }

    @Override
    public void onItemClick(Item item) {
        Toast.makeText(getActivity(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
