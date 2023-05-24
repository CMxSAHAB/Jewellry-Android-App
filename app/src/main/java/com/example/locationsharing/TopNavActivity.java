package com.example.locationsharing;

import static com.example.locationsharing.model.Constants.EXTRA_JEWELLERY;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.locationsharing.adapters.RVForPendant;
import com.example.locationsharing.adapters.RecyclerViewAdapterAyaan;
import com.example.locationsharing.databinding.ActivityTopNavBinding;
import com.example.locationsharing.model.Constants;
import com.example.locationsharing.model.Jewellery;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class TopNavActivity extends AppCompatActivity {
    private static final String TAG = "TopNavActivity";
    ActivityTopNavBinding binding;
    ImageSlider imageSlider;
    AllContentShowActivity allContentShowActivity;

    NavigationView navigationView;
    RecyclerViewAdapterAyaan adapterAyaan;
    RVForPendant rvForPendant;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityTopNavBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        navigationView = findViewById(R.id.nav_view);
        binding.topAppBar.setTitle("Ravi Jewellers");
        binding.topAppBar.setBackgroundColor(getResources().getColor(R.color.white));
        setSupportActionBar(binding.topAppBar);
        imageSlider = findViewById(R.id.image_slider);

        navbar();
        carousel();
        Log.d("AAA", "onCreate: " + Constants.jewellery.size());
        adapterAyaan = new RecyclerViewAdapterAyaan(this::navigateToDetailScreen);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setAdapter(adapterAyaan);
        adapterAyaan.submitList(Constants.jewellery);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_bar_menu, menu);
        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(TopNavActivity.this, GoldRateActivity.class));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    private void navigateToDetailScreen(Jewellery jewellery) {
        Intent intent = new Intent(this, AllContentShowActivity.class);
        intent.putExtra(EXTRA_JEWELLERY, jewellery);
        startActivity(intent);
    }


    private void carousel() {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.ganeshji, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.shriyantra, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.bangle, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.pendent, ScaleTypes.CENTER_CROP));


        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
    }

    private void navbar() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.topAppBar, R.string.open, R.string.close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //calling from database
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String uid = Objects.requireNonNull(user).getUid();



        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.userProfile) {
                Intent intent = new Intent(TopNavActivity.this, UserShowActivity.class);
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.store){
                Toast.makeText(this, "Store", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TopNavActivity.this, GoldRateActivity.class);
                startActivity(intent);
            }

            if (id == R.id.yourOrders) {
                Intent intent = new Intent(TopNavActivity.this, OrderShowActivity.class);
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.locateUs) {
                Intent intent = new Intent(TopNavActivity.this, MapsActivity.class);
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.PendantTP) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(0));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.bangleTP) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(1));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.braceletTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(2));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.chainTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(3));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.coupleRingTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(4));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.earRingsTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(5));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.fingerRingTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(6));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.goldCoinTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(7));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.mangalsutraTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(8));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.neckWearTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(9));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.nosePinTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(10));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            if (id == R.id.pendantSetTp) {
                Intent intent = new Intent(TopNavActivity.this, AllContentShowActivity.class);
                intent.putExtra(Constants.EXTRA_JEWELLERY, Constants.jewellery.get(11));
                startActivity(intent);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }

            return false;
        });

    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();

    }
}