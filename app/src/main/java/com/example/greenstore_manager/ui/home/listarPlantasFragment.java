package com.example.greenstore_manager.ui.home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
    import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.greenstore_manager.R;
import com.example.greenstore_manager.adapter.ListaPlantasAdapter;
import com.example.greenstore_manager.databinding.FragmentListarplantasBinding;
import com.example.greenstore_manager.model.GreenStoreRepository;
import com.example.greenstore_manager.model.Planta;
import com.example.greenstore_manager.model.PlantaconFoto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listarPlantasFragment extends Fragment {

private FragmentListarplantasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentListarplantasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        /*consultas a WS*/
        GreenStoreRepository greenStoreRepository = new Retrofit.Builder()
                .baseUrl("http://34.170.233.17:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GreenStoreRepository.class);


        greenStoreRepository.getListaPlantas().enqueue(new Callback<List<Planta>>() {
            @Override
            public void onResponse(Call<List<Planta>> call, Response<List<Planta>> response) {
                if (response.isSuccessful()) {
                    List<Planta> listaPlantas = response.body();

                    /*eviar al Adapter*/
                    ListaPlantasAdapter adapterPlanta = new ListaPlantasAdapter();
                    adapterPlanta.setContext(getActivity());
                    adapterPlanta.setListaPlantas(listaPlantas);

                    binding.recyclerView.setAdapter(adapterPlanta);
                    binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                } else {
                    Log.d("msg-test", "error en la respuesta del webservice");
                }
            }

            @Override
            public void onFailure(Call<List<Planta>> call, Throwable t) {
                t.printStackTrace();
            }

        })  ;




        /**Ir a editar planta**/
        NavController navController = NavHostFragment.findNavController(listarPlantasFragment.this);

        binding.Agregar.setOnClickListener( view -> {
            navController.navigate(R.id.action_nav_home_to_nueva_Planta);
        });


        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}