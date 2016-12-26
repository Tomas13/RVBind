package ru.startandroid.rvbind;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;


public class ProfileViewModel {

    private static final int LAYOUT_HOLDER = R.layout.item_rv;
    private static final int PHOTOS_COLUMN_COUNT = 3;

    public final RecyclerConfiguration recyclerConfiguration = new RecyclerConfiguration();
    public User user;

    private Context context;

    public ProfileViewModel(Context context, User user) {
        this.context = context;
        this.user = user;

        initRecycler();
    }


    public void showDevMessage() {
        AppUtilities.showSnackbar(context, "dev_message", false);
    }

    private void initRecycler() {
        RecyclerBindingAdapter<String> adapter = getAdapter();

        recyclerConfiguration.setLayoutManager(new GridLayoutManager(context, PHOTOS_COLUMN_COUNT));
        recyclerConfiguration.setItemAnimator(new DefaultItemAnimator());
        recyclerConfiguration.setAdapter(adapter);
    }

    private RecyclerBindingAdapter<String> getAdapter() {
        ArrayList<String> photos = AppUtilities.getPhotos();
        RecyclerBindingAdapter<String> adapter = new RecyclerBindingAdapter<>(LAYOUT_HOLDER, BR.url, photos);
        adapter.setOnItemClickListener((position, item)
                -> AppUtilities.showSnackbar(
                context,
                context.getString(R.string.photo_message, position + 1),
                false));
        return adapter;
    }

}
