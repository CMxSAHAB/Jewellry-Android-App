package com.example.locationsharing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.locationsharing.adapters.RVForPendant;
import com.example.locationsharing.databinding.ActivityAllShowContentBinding;
import com.example.locationsharing.model.Constants;
import com.example.locationsharing.model.Jewellery;


public class AllContentShowActivity extends AppCompatActivity {
    ActivityAllShowContentBinding binding;

    RVForPendant rvForPendant;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllShowContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().hasExtra(Constants.EXTRA_JEWELLERY)) {
            Jewellery jewellery = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) ?
                    getIntent().getSerializableExtra(Constants.EXTRA_JEWELLERY, Jewellery.class)
                    : (Jewellery) getIntent().getSerializableExtra(Constants.EXTRA_JEWELLERY);
            if (jewellery != null) {
                String title = jewellery.getName();
                binding.topAppBar.setTitle(jewellery.getName());
                //fragmentsSet();
                setAllcontents((String) binding.topAppBar.getTitle());
                binding.topAppBar.setNavigationOnClickListener(view -> {
                    onBackPressed();
                });
                Log.d("AAA", "onCreate: " + jewellery.getDescription());

            } else {
                Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public  void setAllcontents(String title) {
        if (title.equals("Pendant")) {
            rvForPendant = new RVForPendant(Constants.pendents, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.pendents);
        }
        if (title.equals("Bangle")) {
            rvForPendant = new RVForPendant(Constants.bangle, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.bangle);
        }
        if (title.equals("Bracelet")) {
            rvForPendant = new RVForPendant(Constants.bracelet, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.bracelet);
        }
        if (title.equals("Chain")) {
            rvForPendant = new RVForPendant(Constants.chain, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.chain);
        }
        if (title.equals("Couple Ring")) {
            rvForPendant = new RVForPendant(Constants.coupleRing, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.coupleRing);
        }
        if (title.equals("Ear Ring")) {
            rvForPendant = new RVForPendant(Constants.earRings, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.earRings);
        }
        if (title.equals("Finger Ring")) {
            rvForPendant = new RVForPendant(Constants.fingerRing, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.fingerRing);
        }
        if (title.equals("Gold Coin")) {
            rvForPendant = new RVForPendant(Constants.goldCoin, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.goldCoin);
        }
        if (title.equals("Mangalsutra")) {
            rvForPendant = new RVForPendant(Constants.mangalsutra, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.mangalsutra);
        }
        if (title.equals("Neck Wear")) {
            rvForPendant = new RVForPendant(Constants.neckware, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.neckware);
        }
        if (title.equals("Nose Pin")) {
            rvForPendant = new RVForPendant(Constants.nosepin, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.nosepin);
        }
        if (title.equals("Pendant Set")) {
            rvForPendant = new RVForPendant(Constants.pendSet, getApplicationContext(),title);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
            binding.allContentShowRecyclerView.setLayoutManager(gridLayoutManager);
            binding.allContentShowRecyclerView.setAdapter(rvForPendant);
            rvForPendant.submitList(Constants.pendSet);
        }


    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}