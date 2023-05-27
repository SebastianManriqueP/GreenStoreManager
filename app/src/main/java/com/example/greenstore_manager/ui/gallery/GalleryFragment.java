package com.example.greenstore_manager.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.greenstore_manager.adapter.ListaComprasAdapter;
import com.example.greenstore_manager.databinding.FragmentGalleryBinding;
import com.example.greenstore_manager.model.GreenStoreRepository;
import com.example.greenstore_manager.model.ListaCompra;
import com.example.greenstore_manager.model.Planta;
import com.example.greenstore_manager.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GalleryFragment extends Fragment {

private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        /*consultas a WS*/
        GreenStoreRepository greenStoreRepository = new Retrofit.Builder()
                .baseUrl("http://34.170.233.17:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GreenStoreRepository.class);


        greenStoreRepository.getListaComprass().enqueue(new Callback<List<ListaCompra>>() {
            @Override
            public void onResponse(Call<List<ListaCompra>> call, Response<List<ListaCompra>> response) {
                if (response.isSuccessful()) {
                    List<ListaCompra> listaCompra = response.body();

                    /*eviar al Adapter*/
                    ListaComprasAdapter listaComprasAdapter  = new ListaComprasAdapter();
                    listaComprasAdapter.setContext(getActivity());
                    listaComprasAdapter.setListacompras(listaCompra);

                    binding.RecyclerView.setAdapter(listaComprasAdapter);
                    binding.RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                } else {
                    Log.d("msg-test", "error en la respuesta del webservice");
                }
            }

            @Override
            public void onFailure(Call<List<ListaCompra>> call, Throwable t) {
                t.printStackTrace();
            }


        })  ;


        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}