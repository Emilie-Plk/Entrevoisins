package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourProfilePageActivity extends AppCompatActivity {


    @BindView(R.id.neighbourProfilePic)
    ImageView profileAvatar;
    @BindView(R.id.neighbourProfilePicName)
    TextView neighbourProfileName;
    @BindView(R.id.CVNeighbourNameTV)
    TextView cvNeighbourName;
    @BindView(R.id.CVNeighbourCityTV)
    TextView cvNeighbourCity;
    @BindView(R.id.CVNeighbourPhoneTV)
    TextView cvNeighbourPhone;
    @BindView(R.id.CVNeighbourSocial)
    TextView cvNeighbourSocial;
    @BindView(R.id.aboutMeDetailTV)
    TextView cvNeighbourAbout;
    @BindView(R.id.addFavoriteFab)
    FloatingActionButton addFavoriteFab;
    @BindView(R.id.back_imagebtn)
    ImageButton backImageBtn;

    private NeighbourApiService mApiService;

    private static final String TAG = NeighbourProfilePageActivity.class.getName();

    Neighbour neighbourAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_profile_page);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mApiService = DI.getNeighbourApiService();

        // get the clicked neighbour info via Bundle
        Bundle bundle = intent.getBundleExtra("BUNDLE_NEIGHBOUR");
        Neighbour currentNeighbour = (Neighbour) bundle.get("NEIGHBOUR_INFO");

        assert currentNeighbour != null;
        displayNeighbourInfo(currentNeighbour);

        neighbourAPI = mApiService.getNeighbourById(currentNeighbour.getId());

        backImageBtn.setOnClickListener(view -> finish());

        addFavoriteFab.setOnClickListener(view -> onClickFav());
    }


    private void displayNeighbourInfo(Neighbour neighbour) {
        Log.i(TAG, "Displaying neighbour info");
        neighbourProfileName.setText(neighbour.getName());
        cvNeighbourName.setText(neighbour.getName());
        cvNeighbourCity.setText(neighbour.getAddress());
        cvNeighbourPhone.setText(neighbour.getPhoneNumber());

        String neighbourFB = this.getResources().getString(R.string.social, neighbour.getName().toLowerCase());
        cvNeighbourSocial.setText(neighbourFB);
        cvNeighbourAbout.setText(neighbour.getAboutMe());

        Glide.with(NeighbourProfilePageActivity.this)
                .load(neighbour.getAvatarUrl())
                .centerCrop()
                .into(profileAvatar);
    }

    private void onClickFav() {
        // set/unset neighbourAPI (neighbour from API DB) to fav, and update its status
        mApiService.updateFavoriteNeighbour(neighbourAPI, neighbourAPI.getId());
        setFab();
        setToast();
    }

    private void setFab() {
        if (neighbourAPI.isFavorite()) {
            addFavoriteFab.setImageResource(R.drawable.ic_baseline_star_24);
            addFavoriteFab.setColorFilter(Color.parseColor("#F9BA3B"));
        } else addFavoriteFab.setImageResource(R.drawable.ic_star_border_white_24dp);
    }

    private void setToast() {
        String toast;
        if (neighbourAPI.isFavorite()) {
            toast = "%s has been added to favorite!";
        } else {
            toast = "%s has been removed from favorite!";
        }
        Toast.makeText(NeighbourProfilePageActivity.this,
                String.format(toast,
                        neighbourProfileName.getText().toString()),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setFab();
    }
}