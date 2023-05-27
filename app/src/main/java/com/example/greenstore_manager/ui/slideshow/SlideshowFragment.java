package com.example.greenstore_manager.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.greenstore_manager.adapter.ListaClientesAdapter;
import com.example.greenstore_manager.adapter.ListaComprasAdapter;
import com.example.greenstore_manager.databinding.FragmentSlideshowBinding;
import com.example.greenstore_manager.model.GreenStoreRepository;
import com.example.greenstore_manager.model.ListaCompra;
import com.example.greenstore_manager.model.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SlideshowFragment extends Fragment {

private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

    binding = FragmentSlideshowBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        /*consultas a WS*/
        GreenStoreRepository greenStoreRepository = new Retrofit.Builder()
                .baseUrl("http://34.170.233.17:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GreenStoreRepository.class);

        greenStoreRepository.getListaPersonas().enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if (response.isSuccessful()) {
                    List<Persona> listaPersonas = response.body();
                    /*eviar al Adapter*/
                    ListaClientesAdapter listaClientesAdapter  = new ListaClientesAdapter();
                    listaClientesAdapter.setContext(getActivity());
                    listaClientesAdapter.setListaPersona(listaPersonas);

                    binding.RecyclerView.setAdapter(listaClientesAdapter);
                    binding.RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }else{
                    Log.d("msg-test", "error en la respuesta del webservice");
                }
            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}